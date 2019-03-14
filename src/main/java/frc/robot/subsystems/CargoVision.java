/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class CargoVision extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  /**
     * @return the getX
     */
    public double getX() {
        NetworkTableEntry ntX = Robot.vision.getEntry("cargoX");
        return ntX.getDouble(0.0);
    }

    /**
     * @return the getY
     */
    public double getY() {
        NetworkTableEntry ntY = Robot.vision.getEntry("cargoY");
        return ntY.getDouble(0.0);
    }

    /**
     * @return the getAngle
     */
    public double getAngle() {
        NetworkTableEntry ntAngle = Robot.vision.getEntry("cargoAngle");
        return ntAngle.getDouble(0.0);
    }

    /**
     * @return the cargoDistance
     */
    /*
    public static double getCargoDistance() {
        NetworkTableEntry ntCargoDistance = Robot.vision.getEntry("cargoDistance");
        return ntCargoDistance.getDouble(0.0);
    }
    */

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
