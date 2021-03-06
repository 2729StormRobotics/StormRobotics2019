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
public class HatchVision extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.


  /**
     * @return the getX
     */
    public double getX() {
        return Double.parseDouble(Robot.jevois.readString().split(" ")[0]);
    }

    /**
     * @return the getY
     */
    public double getY() {
        return Double.parseDouble(Robot.jevois.readString().split(" ")[1]);
    }

    /**
     * @return the getAngle
     */
    public double getAngle() {
        return Double.parseDouble(Robot.jevois.readString().split(" ")[2]);
    }

    public double getInitialTurnAngle(double x, double y, double theta){
        return Math.atan(x/y) - 180 + theta + Math.atan((Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2))*Math.sin(theta)-1.5)/(Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2))*Math.cos(theta)));
    }

    public double getDistanceDrive(double x, double y, double theta){
        return Math.sqrt(Math.pow(Math.sqrt((Math.pow(x, 2)+Math.pow(y, 2)*Math.sin(theta)-1.5)), 2) + Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2))*Math.cos(theta));
    }

    public double getFinalTurnAngle(double x, double y, double theta){
        return Math.atan(Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2))*Math.cos(theta)/(Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2))*Math.sin(theta) - 1.5));
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
