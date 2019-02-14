/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class PunchOut extends InstantCommand {
  /**
   * Add your docs here.
   */
  public PunchOut() {
    super();
    // Use requires() here to declare subsystem dependencies
    requires(Robot.pneumatics);
  }

  // Called once when the command executes
  @Override
  protected void initialize() {
      Robot.pneumatics.punchHatch(true);
  }

}
