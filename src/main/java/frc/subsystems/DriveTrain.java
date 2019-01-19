package frc.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.constants.RobotMap;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public static void tankDrive(double leftSpeed, double rightSpeed){
   // RobotMap.LEFT_TALON_0.
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}