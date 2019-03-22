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
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.PIDOutput;

public class PointTurn extends Command {

    private double initAngle;
    private double turnSpeed;
    private double setAngle;
    private boolean right;
    private PIDController turnController;

  public PointTurn(boolean right) {
    requires(Robot.driveTrain);
    this.right = right;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

    initAngle = NavX.getNavx().getYaw();
    if(right){
      setAngle = (initAngle + 90) % 360;
    }else if(!right && initAngle <= 90){
      setAngle = 360 + (initAngle - 90);
    }else{
      setAngle = initAngle - 90;
    }

    if(right){
      turnSpeed = 0.1;
    }else{
      turnSpeed = -0.1;
    }

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    Robot.driveTrain.tankDrive(turnSpeed, -turnSpeed);

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(Math.abs(setAngle-NavX.getNavx().getYaw()) <= 5){
      return true;
    }
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
      turnController.disable();
      Robot.driveTrain.tankDrive(0, 0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
      turnController.disable();
      Robot.driveTrain.tankDrive(0, 0);
  }
}
