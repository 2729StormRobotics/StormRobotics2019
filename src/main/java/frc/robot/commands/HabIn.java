package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class HabIn extends InstantCommand {
  /**
   * Add your docs here.
   */
  public HabIn() {
    super();
    // Use requires() here to declare subsystem dependencies
    requires(Robot.pneumatics);
  }

  // Called once when the command executes
  @Override
  protected void initialize() {
      Robot.pneumatics.habIn(false);
  }

}