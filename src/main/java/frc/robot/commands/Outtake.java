/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

public class Outtake extends InstantCommand {
  public Outtake() {
      super();
    // Use requires() here to declare subsystem dependencies
    requires(Robot.cargoArm);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.cargoArm.intake(-0.5);
  }

}
