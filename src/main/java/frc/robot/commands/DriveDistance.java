/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.constants.PIDMap;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.PIDOutput;

public class DriveDistance extends Command {

    private double distance, driveSpeed;
    private PIDController driveController;

  public DriveDistance(double distance) {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.driveTrain);

    this.distance = distance;

  }

  private final PIDSource distanceSource = new PIDSource() {

    @Override
    public void setPIDSourceType(PIDSourceType pidSource) {

    }

    @Override
    public PIDSourceType getPIDSourceType() {
        return PIDSourceType.kDisplacement;
    }

    @Override
    public double pidGet() {
        try {
            return Robot.driveTrain.getLeftTalon().get();
        } catch (NullPointerException npe) {
            return distance;
        }
    }
};
    private final PIDOutput driveSpeedSetter = new PIDOutput() {
        @Override
        public void pidWrite(double speed) {
            driveSpeed = speed;
        }
    };



  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    driveController = new PIDController(
        PIDMap.DRIVE_DISTANCE_P,
        PIDMap.DRIVE_DISTANCE_I,
        PIDMap.DRIVE_DISTANCE_D,
        distanceSource,
        driveSpeedSetter,
        PIDMap.POINT_TURN_PERIOD
    );
    driveController.setInputRange(0, 360);
    driveController.setOutputRange(-.80, .80);
    driveController.setAbsoluteTolerance(PIDMap.POINT_TURN_TOLERANCE);
    driveController.setContinuous(true);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
