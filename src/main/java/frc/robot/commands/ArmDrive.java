package frc.robot.commands;

import frc.robot.constants.*;
import frc.robot.driver.*;
import frc.robot.subsystems.*;
import frc.robot.util.*;
import frc.robot.*;
import edu.wpi.first.wpilibj.command.Command;

public class ArmDrive extends Command {

    public ArmDrive() {
        requires(Robot.cargoArm); // driveTrain is an instance of our DriveTrain subsystem

    }

    @Override
    protected void initialize() {
    }

    /*
     * execute() - In our execute method we call a tankDrive method we have created in our subsystem. This method takes two speeds as a parameter which we get from methods in the OI class.
     * These methods abstract the joystick objects so that if we want to change how we get the speed later we can do so without modifying our commands
     * (for example, if we want the joysticks to be less sensitive, we can multiply them by .5 in the getLeftSpeed method and leave our command the same).
     */
    @Override
    protected void execute() {
        Robot.cargoArm.armDrive(
            JoystickMath.getCubic(-Robot.oi.getLeftSpeedWeapons()),
            JoystickMath.getCubic(Robot.oi.getLeftTriggerWeapons()) - JoystickMath.getCubic(Robot.oi.getRightTriggerWeapons())
        );
    }

    /*
     * isFinished - Our isFinished method always returns false meaning this command never completes on it's own. The reason we do this is that this command will be set as the default command for the subsystem. This means that whenever the subsystem is not running another command, it will run this command. If any other command is scheduled it will interrupt this command, then return to this command when the other command completes.
     */
    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {

    }

    @Override
    protected void interrupted() {
        end();
    }
}
