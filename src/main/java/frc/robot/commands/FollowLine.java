package frc.robot.commands;

import frc.robot.commands.*;
import frc.robot.constants.*;
import frc.robot.driver.*;
import frc.robot.subsystems.*;
import frc.robot.util.*;
import frc.robot.*;
import edu.wpi.first.wpilibj.command.Command;

public class FollowLine extends Command {

    public FollowLine() {
    	requires(Robot.driveTrain); // airsystem is an instance of our Airsystem subsystem
    }

    protected void initialize() {
    }

    
    protected void execute() {
    	Robot.lineFollower.followLine();
    }

    /*
     * isFinished - Our isFinished method always returns false meaning this command never completes on it's own. The reason we do this is that this command will be set as the default command for the subsystem. This means that whenever the subsystem is not running another command, it will run this command. If any other command is scheduled it will interrupt this command, then return to this command when the other command completes.
     */
    protected boolean isFinished() {
        return Robot.lineFollower.isFinished();
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}