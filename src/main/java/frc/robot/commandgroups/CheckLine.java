package frc.robot.commandgroups;

import frc.robot.commands.*;
import frc.robot.constants.*;
import frc.robot.driver.*;
import frc.robot.subsystems.*;
import frc.robot.util.*;
import frc.robot.*;
import edu.wpi.first.wpilibj.command.CommandGroup;


public class CheckLine extends CommandGroup {

    public CheckLine() {
        if (!Robot.lineFollower.getState().equals("000")) {
            // addSequential(new FollowLine());
        }
    }


}
