package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

public class Reverse extends InstantCommand{

    public Reverse(){
        super();
        
        requires(Robot.driveTrain);
    }

    public void initialize(){
        Robot.driveTrain.reverse = !Robot.driveTrain.reverse;
    }

}