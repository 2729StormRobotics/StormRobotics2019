package frc.robot.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class FollowLine extends Command {

    private PIDController lineController;
    private double turnSpeed;

    private static final double BASE_SPEED = 0.2;

    private PIDOutput motorSpeedWrite = new PIDOutput() {

        @Override
        public void pidWrite(double output) {
            turnSpeed = output;
        }
    };

    public FollowLine() {
        requires(Robot.driveTrain);
        requires(Robot.lineFollower);
    }

    @Override
    protected void initialize() {
        lineController = new PIDController(0.5, 0.0, 0.0, Robot.lineFollower, motorSpeedWrite);

        lineController.setInputRange(-1.0, 1.0);
        lineController.setOutputRange(-0.2, 0.2);
        lineController.setAbsoluteTolerance(0.25);
        lineController.setContinuous(false);

        lineController.enable();
    }

    @Override
    protected void execute() {
        double leftSpeed = BASE_SPEED;
        double rightSpeed = BASE_SPEED;

        leftSpeed += turnSpeed;
        rightSpeed -= turnSpeed;

        Robot.driveTrain.tankDrive(leftSpeed, rightSpeed);
    }

    /*
     * isFinished - Our isFinished method always returns false meaning this command
     * never completes on it's own. The reason we do this is that this command will
     * be set as the default command for the subsystem. This means that whenever the
     * subsystem is not running another command, it will run this command. If any
     * other command is scheduled it will interrupt this command, then return to
     * this command when the other command completes.
     */
    @Override
    protected boolean isFinished() {
        return Robot.lineFollower.isFinished();
    }

    @Override
    protected void end() {
        lineController.disable();
        super.end();
    }

    @Override
    protected void interrupted() {
        end();
    }
}
