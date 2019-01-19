package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public class WhichButton extends Command {
private int buttonId;

    public WhichButton(int button) {
        super("WhichButton" + button);
        buttonId = button;
    }

    // 	initialize() - This method sets up the command and is called immediately before the command is executed for the first time and every subsequent time it is started .
    //  Any initialization code should be here. 
    protected void initialize() {
    }

    /*
     *	execute() - This method is called periodically (about every 20ms) and does the work of the command. Sometimes, if there is a position a
     *  subsystem is moving to, the command might set the target position for the subsystem in initialize() and have an empty execute() method.
     */
    protected void execute() {
        System.out.println("Pressed button " + buttonId + "!");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }


}