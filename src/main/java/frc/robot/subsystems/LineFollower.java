package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.constants.RobotMap;

public class LineFollower extends Subsystem implements PIDSource {
  // private AxisCamera camera; //defines Axis Camera
  private AnalogInput lineRight;
  private AnalogInput lineLeft;
  private AnalogInput lineMiddle;
  private AnalogInput infrared;
  private boolean noLine;

  public LineFollower() {

    lineLeft = new AnalogInput(RobotMap.PHO_LEFT_PORT);
    lineMiddle = new AnalogInput(RobotMap.PHO_MIDDLE_PORT); // Solenoid port
    lineRight = new AnalogInput(RobotMap.PHO_RIGHT_PORT);
    infrared = new AnalogInput(RobotMap.INFRA_PORT);
    noLine = false;

  }

  public void followLine() {
    noLine = false;
    switch (getState()) {
    case ("000"):
      // finish command;
      Robot.driveTrain.stopDrive();
    case ("100"):
      // drive left;
      Robot.driveTrain.tankDrive(0.5, 1);
    case ("010"):
      // drive forward;
      Robot.driveTrain.tankDrive(1, 1);
    case ("001"):
      // drive right;
      Robot.driveTrain.tankDrive(1, 0.5);
    case ("110"):
      // drive left slowly;
      Robot.driveTrain.tankDrive(0.75, 1);
    case ("011"):
      // drive right slowly;
      Robot.driveTrain.tankDrive(1, 0.75);
    case ("111"):
      // error, shouldnt be possible

    }

  }

  public String getState() {
    return isLine(lineLeft) + isLine(lineMiddle) + isLine(lineRight);
  }

  public String isLine(AnalogInput lineFollow) {
    if (lineFollow.getValue() >= RobotMap.LIGHT_THRESHOLD) {
      return "1";
    }

    return "0";
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
  public void setPIDSourceType(PIDSourceType pidSource) {

  }

  @Override
  public PIDSourceType getPIDSourceType() {
    return PIDSourceType.kDisplacement;
  }

  @Override
  public double pidGet() {
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
}
