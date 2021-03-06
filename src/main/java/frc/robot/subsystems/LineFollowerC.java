package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.Robot;
import frc.robot.constants.RobotMap;
import frc.robot.constants.PIDMap;

public class LineFollowerC extends PIDSubsystem {
    // private AxisCamera camera; //defines Axis Camera
    public DigitalInput lineRightC; //cargo side
    public DigitalInput lineLeftC;
    public DigitalInput lineMiddleC;
    public DigitalInput infraredC;
    public boolean noLine;

    public LineFollowerC() {

        super("LineFollower", PIDMap.LINE_FOLLOWER_P, PIDMap.LINE_FOLLOWER_I, PIDMap.LINE_FOLLOWER_D);// The constructor passes a name for the subsystem and the P, I and D constants that are useed when computing the motor output

        lineLeftC = new DigitalInput(RobotMap.PHO_LEFT_PORT_C);
        lineMiddleC = new DigitalInput(RobotMap.PHO_MIDDLE_PORT_C);
        lineRightC = new DigitalInput(RobotMap.PHO_RIGHT_PORT_C);
        infraredC = new DigitalInput(RobotMap.INFRA_PORT_C);

        noLine = false;

    }

    public void followLine() { //not used
        noLine = false;
        switch (getState()) {
            case ("000"):
                // finish command;
                Robot.driveTrain.stopDrive();
                break;
            case ("100"):
                // drive left;
                Robot.driveTrain.tankDrive(0.5, 1);
                break;
            case ("010"):
                // drive forward;
                Robot.driveTrain.tankDrive(1, 1);
                break;
            case ("001"):
                // drive right;
                Robot.driveTrain.tankDrive(1, 0.5);
                break;
            case ("110"):
                // drive left slowly;
                Robot.driveTrain.tankDrive(0.75, 1);
                break;
            case ("011"):
                // drive right slowly;
                Robot.driveTrain.tankDrive(1, 0.75);
                break;
            case ("111"):
                // error, shouldnt be possible

        }

    }

    public String getState() {
        return isLine(lineLeftC) + isLine(lineMiddleC) + isLine(lineRightC);
    }

    public String isLine(DigitalInput lineFollow) {
        /*if (lineFollow.getValue() >= RobotMap.LIGHT_THRESHOLD) {
            return "1";
        } */

        return lineFollow.get() ? "1" : "0";
    }

    public boolean isFinished() {
        //return infraredC.getValue() <= RobotMap.DISTANCE_FROM_LINE || noLine /**|| !Robot.oi.isdriverRBHeld()*/;
        return false;
    }

    @Override
    protected void usePIDOutput(double output) {
        double leftSpeed = RobotMap.BASE_SPEED;
        double rightSpeed = RobotMap.BASE_SPEED;

        leftSpeed += output;
        rightSpeed -= output;

        Robot.driveTrain.tankDrive(-leftSpeed, -rightSpeed);
    }

    @Override
    protected double returnPIDInput() {
        noLine = false;
        switch (getState()) {
            case ("000"):
                // finish command;
                //noLine = true;
                return 0.0;
            case ("100"):
                // drive left;
                return -1.0;
            case ("010"):
                // drive forward;
                return 0.0;
            case ("001"):
                // drive right;
                return 1.0;
            case ("110"):
                // drive left slowly;
                return -0.5;
            case ("011"):
                // drive right slowly;
                return 0.5;
            case ("111"):
                // error, shouldnt be possible
                return 0.0;
        }
        return 0.0;
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand();
    }
}
