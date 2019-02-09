package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.constants.RobotMap;

public class LineFollower extends PIDSubsystem {
    // private AxisCamera camera; //defines Axis Camera
    private DigitalInput lineRight;
    private DigitalInput lineLeft;
    private DigitalInput lineMiddle;
    private AnalogInput infrared;
    private boolean noLine;

    private static final double BASE_SPEED = 0.2;

    private double turnSpeed;
    private double leftSpeed;
    private double rightSpeed;

    public static final double PID_OUTPUT_MIN_LIMIT = -1.0;
    public static final double PID_OUTPUT_MAX_LIMIT = 1.0;

    public LineFollower() {

        super("LineFollower", 0.1, 0, 0);

        lineLeft = new DigitalInput(RobotMap.PHO_LEFT_PORT);
        lineMiddle = new DigitalInput(RobotMap.PHO_MIDDLE_PORT); // Photoelectric sensor port
        lineRight = new DigitalInput(RobotMap.PHO_RIGHT_PORT);
        infrared = new AnalogInput(RobotMap.INFRA_PORT);
        noLine = false;



    }



    public String getState() {
        return isLine(lineLeft) + isLine(lineMiddle) + isLine(lineRight);
    }

    public String isLine(DigitalInput lineFollow) {
        return (lineFollow.get() ? "1" : "0");
    }

    public boolean isFinished() {
        return infrared.getValue() <= RobotMap.DISTANCE_FROM_LINE || noLine;
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand();
    }

    @Override
    protected double returnPIDInput() {
        noLine = false;
        switch (getState()) {
            case ("000"):
                // finish command;
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
    protected void usePIDOutput(double output) {

        leftSpeed = BASE_SPEED;
        rightSpeed = BASE_SPEED;

        leftSpeed += output;
        rightSpeed -= output;

        if (leftSpeed > 1.0) {
            leftSpeed = 1.0;
        } else if (leftSpeed < -1.0) {
            leftSpeed = -1.0;
        }

        if (rightSpeed > 1.0) {
            rightSpeed = 1.0;
        } else if (rightSpeed < -1.0) {
            rightSpeed = -1.0;
        }

        SmartDashboard.putNumber("lineFollower/output", output);
        SmartDashboard.putNumber("lineFollower/leftSpeed", leftSpeed);
        SmartDashboard.putNumber("lineFollower/rightSpeed", rightSpeed);
        SmartDashboard.updateValues();

        Robot.driveTrain.tankDrive(leftSpeed, rightSpeed);
    }
}
