/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.constants.*;
import frc.robot.driver.*;
import frc.robot.subsystems.*;
import frc.robot.util.*;
import frc.robot.*;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.driver.OI;
import frc.robot.Robot;

public class MoveArmPID extends Command {

    private double setpoint;

  public MoveArmPID(double setpoint) {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.cargoArm);
    this.setpoint = setpoint;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.cargoArm.setSetpoint(setpoint);
    Robot.cargoArm.enable();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (Robot.oi.getArmMovement()) {
      interrupted();
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
    //return Robot.cargoArm.onTarget();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.cargoArm.disable();
    Robot.cargoArm.armDrive(0, 0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
      end();
  }
}
