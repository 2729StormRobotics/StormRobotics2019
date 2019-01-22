package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import frc.robot.commands.*;
import frc.robot.constants.*;
import frc.robot.driver.*;
import frc.robot.subsystems.*;
import frc.robot.util.*;
import frc.robot.*;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private CANSparkMax leftMotor;
  private CANSparkMax rightMotor;

  public DriveTrain() {
    leftMotor = new CANSparkMax(RobotMap.LEFT_MOTOR_ID, CANSparkMaxLowLevel.MotorType.kBrushless);
    rightMotor = new CANSparkMax(RobotMap.RIGHT_MOTOR_ID, CANSparkMaxLowLevel.MotorType.kBrushless);

  }

  public void tankDrive(double leftSpeed, double rightSpeed){
    //may need to adjust speed values
    leftMotor.set(leftSpeed);
    rightMotor.set(rightSpeed);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new Drive());
  }
}