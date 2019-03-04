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

    private double driveSpeed, distance, initDistance;
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
        return Robot.driveTrain.leftMotor.getSelectedSensorPosition(0);
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
        PIDMap.DRIVE_DISTANCE_PERIOD
    );
    driveController.setInputRange(Integer.MIN_VALUE, Integer.MAX_VALUE);
    driveController.setOutputRange(-.10, .10);
    driveController.setAbsoluteTolerance(PIDMap.DRIVE_DISTANCE_TOLERANCE);
    driveController.setContinuous(false);

    initDistance = Robot.driveTrain.leftMotor.getSelectedSensorPosition(0);

    driveController.setSetpoint(initDistance + distance);

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
      Robot.driveTrain.tankDrive(driveSpeed, driveSpeed);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return driveController.onTarget();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
      driveController.disable();
      Robot.driveTrain.tankDrive(0, 0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    driveController.disable();
    Robot.driveTrain.tankDrive(0, 0);
  }
}
