package frc.robot.commands;

import frc.robot.commands.*;
import frc.robot.constants.*;
import frc.robot.driver.*;
import frc.robot.subsystems.*;
import frc.robot.util.*;
import frc.robot.*;
import edu.wpi.first.wpilibj.command.Command;

public class DriveDistance extends Command {

    private double distance;
    private double power;
    private double initialLeftPos;
    private double initialRightPos;
    private double currentLeftPos;
    private double currentRightPos;

    public DriveDistance(double distance, double power) {
        requires(Robot.driveTrain); // drivetrain is an instance of our Drivetrain subsystem
        this.distance = distance;
        this.power = power;
    }

    protected void initialize() {
        initialLeftPos = Robot.driveTrain.getLeftPos();
        initialRightPos = Robot.driveTrain.getRightPos();
    }

    /*
     * execute() - In our execute method we call a tankDrive method we have created in our subsystem. This method takes two speeds as a parameter which we get from methods in the OI class.
     * These methods abstract the joystick objects so that if we want to change how we get the speed later we can do so without modifying our commands
     * (for example, if we want the joysticks to be less sensitive, we can multiply them by .5 in the getLeftSpeed method and leave our command the same).
     */
    protected void execute() {
        Robot.driveTrain.tankDrive(power, power);
        currentLeftPos = Robot.driveTrain.getLeftPos();
        currentRightPos = Robot.driveTrain.getRightPos();

    }

    /*
     * isFinished - Our isFinished method is called when both wheels reach the target distance.
     */
    protected boolean isFinished() {
        return ((currentLeftPos - initialLeftPos) > distance && (currentRightPos - initialRightPos) < distance);
    }

    protected void end() {
        Robot.driveTrain.stopDrive();
    }

    protected void interrupted() {
        end();
    }
}