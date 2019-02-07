package frc.robot.commands;

import frc.robot.constants.*;
import frc.robot.driver.*;
import frc.robot.subsystems.*;
import frc.robot.util.*;
import frc.robot.*;
import edu.wpi.first.wpilibj.command.InstantCommand;

public class ToggleHab extends InstantCommand {

    public ToggleHab() {
        super();
        requires(Robot.pneumatics); // pneumatics is an instance of our Pneumatics subsystem
    }

    @Override
    protected void initialize() {
        Robot.pneumatics.toggleHab();
    }

}
