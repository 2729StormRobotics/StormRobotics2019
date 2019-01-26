package frc.robot.commands;

import frc.robot.commands.*;
import frc.robot.constants.*;
import frc.robot.driver.*;
import frc.robot.subsystems.*;
import frc.robot.util.*;
import frc.robot.*;
import edu.wpi.first.wpilibj.command.Command;

public class TogglePunch extends Command {

    public TogglePunch() {
    	requires(Robot.pneumatics); // airsystem is an instance of our Airsystem subsystem
    }
    

    protected void initialize() {
        Robot.pneumatics.punchHatch();
    }

    /*
     * execute() - In our execute method we call a tankDrive method we have created in our subsystem. This method takes two speeds as a parameter which we get from methods in the OI class.
     * These methods abstract the joystick objects so that if we want to change how we get the speed later we can do so without modifying our commands
     * (for example, if we want the joysticks to be less sensitive, we can multiply them by .5 in the getLeftSpeed method and leave our command the same).
     */
    protected void execute() {
    }

    /*
     * isFinished - Our isFinished method always returns true, meaning this command completes during initialization
     */
    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
        end();
    }
}