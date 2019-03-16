package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

public class Slow extends InstantCommand{

    public Slow(){
        super();
        
        requires(Robot.driveTrain);
    }

    public void initialize(){
        Robot.driveTrain.slow = !Robot.driveTrain.slow;
    }

}
