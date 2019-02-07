package frc.robot.commands;

import frc.robot.constants.*;
import frc.robot.driver.*;
import frc.robot.subsystems.*;
import frc.robot.util.*;
import frc.robot.*;
import edu.wpi.first.wpilibj.command.InstantCommand;

public class ToggleArm extends InstantCommand {

    public ToggleArm() {
        super();
        requires(Robot.pneumatics);
    }

    @Override
    protected void initialize() {
        Robot.pneumatics.toggleArm();
    }
}
