package frc.robot.commands;

import frc.robot.subsystems.*;
import frc.robot.util.TalonRelative;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj.command.Command;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.followers.EncoderFollower;
import frc.robot.*;
import frc.robot.constants.RobotMap;

import java.io.File;

public class FollowPath extends Command {
    private TalonRelative leftTalon;
    private TalonRelative rightTalon;
    private EncoderFollower left;
    private EncoderFollower right;
    private final Trajectory leftTrajectory;
    private final Trajectory rightTrajectory;
    private double kd;


    public FollowPath(String leftCSV, String rightCSV, double kd) {
        requires(Robot.driveTrain);
        requires(Robot.navX);

        File leftMotionProfile = new File(leftCSV);
        File rightMotionProfile = new File(rightCSV);
        this.kd = kd;

        leftTrajectory = Pathfinder.readFromCSV(leftMotionProfile);
        rightTrajectory = Pathfinder.readFromCSV(rightMotionProfile);
    }

    /**
     * The initialize method is called the first time this Command is run after being started.
     */
    @Override
    protected void initialize() {
        super.initialize();

        left = new EncoderFollower(leftTrajectory);
        right = new EncoderFollower(rightTrajectory);

        left.configureEncoder(leftTalon.getSelectedSensorPosition(0), RobotMap.TICKS_PER_REVOLUTION, RobotMap.WHEEL_DIAMETER);
        right.configureEncoder(rightTalon.getSelectedSensorPosition(0), RobotMap.TICKS_PER_REVOLUTION, RobotMap.WHEEL_DIAMETER);


        left.configurePIDVA(1.0, 0.0, kd, RobotMap.MAX_VELOCITY, 0);
        right.configurePIDVA(1.0, 0.0, kd, RobotMap.MAX_VELOCITY, 0);


        try {
            NavX.getNavx().zeroYaw();
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
    }

    /**
     * Called when the command ended peacefully. This is where you may want to wrap up loose ends,
     * like shutting off a motor that was being used in the command.
     */
    @Override
    protected void end() {
        super.end();
        Robot.driveTrain.tankDrive(0, 0);
    }

    /**
     * Called when the command ends because somebody called {@link Command#cancel() cancel()} or
     * another command shared the same requirements as this one, and booted it out.
     * <p>
     * <p>This is where you may want to wrap up loose ends, like shutting off a motor that was being
     * used in the command.
     * <p>
     * <p>Generally, it is useful to simply call the {@link Command#end() end()} method within this
     * method, as done here.
     */
    @Override
    protected void interrupted() {
        super.interrupted();
        end();
    }

    /**
     * The execute method is called repeatedly until this Command either finishes or is canceled.
     */
    @Override
    protected void execute() {
        super.execute();
        System.err.println("Execute ProfileFollower.");
        leftTalon.configOpenloopRamp(0, 500);
        rightTalon.configOpenloopRamp(0, 500);
        double l = left.calculate(leftTalon.getSelectedSensorPosition(0));
        double r = right.calculate(rightTalon.getSelectedSensorPosition(0));
        double gyro_heading;
        try {
            gyro_heading = NavX.getNavx().getYaw();
        } catch(NullPointerException npe) {
            gyro_heading = 0;
        }
        double desired_heading = Pathfinder.r2d(left.getHeading());
        double angleDifference = Pathfinder.boundHalfDegrees(desired_heading - gyro_heading);
        double turn = 0.8 * (-1.0/80.0) * angleDifference;
        System.out.println("Left: " + (l));// + turn));
        System.out.println("Right: " + (r));// - turn));
        Robot.driveTrain.tankDrive(l, r);
        //leftMotor.set(ControlMode.PercentOutput, l + turn);// + turn);
        //rightMotor.set(ControlMode.PercentOutput, (r - turn));// - turn));

        //Robot._driveTrain.tankDrive(l+turn, r-turn);


    }

    @Override
    protected boolean isFinished() {
        return left.isFinished() && right.isFinished();
    }
}
