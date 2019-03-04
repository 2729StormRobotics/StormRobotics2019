/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SetSpeed extends Command {

    private double leftSpeed;
    private double rightSpeed;


  public SetSpeed(double leftSpeed, double rightSpeed) {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.driveTrain);
    this.leftSpeed = leftSpeed;
    this.rightSpeed = rightSpeed;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
      Robot.driveTrain.tankDrive(leftSpeed, rightSpeed);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Robot.driveTrain.checkSticksMoved();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    System.out.println("SetSpeed() has ended!!!");
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }


}
