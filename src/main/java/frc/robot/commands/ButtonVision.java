package frc.robot.commands;

import frc.robot.constants.*;
import frc.robot.driver.*;
import frc.robot.subsystems.*;
import frc.robot.util.*;
import frc.robot.*;
import edu.wpi.first.wpilibj.command.Command;


public class ButtonVision extends Command {

    private PointTurn pt;
    private boolean isCargo;

    @Override
    protected boolean isFinished() {
        return pt.isFinished();
    }

    public ButtonVision( /*boolean isCargo*/) {
        //this.isCargo = isCargo;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {

        double x = Robot.hatchVision.getX();
        double y = Robot.hatchVision.getY();
        double angle = 0.0;

        angle = Math.atan(x / y);

        PointTurn pointTurn = new PointTurn(angle);
        pointTurn.start();


        /*
        if (isCargo) {
            pt = new PointTurn(VisionMove.getCargoAngle());
        } else {
            pt = new PointTurn(VisionMove.getHatchAngle());
        }
        pt.execute();
        */
    }
}
