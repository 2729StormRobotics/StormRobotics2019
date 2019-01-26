package frc.robot.commandgroups;

import frc.robot.commands.*;
import frc.robot.constants.*;
import frc.robot.driver.*;
import frc.robot.subsystems.*;
import frc.robot.util.*;
import frc.robot.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class ScoreAll extends CommandGroup {

    public ScoreAll() {
        addSequential(new ScoreHatch());
    }
}