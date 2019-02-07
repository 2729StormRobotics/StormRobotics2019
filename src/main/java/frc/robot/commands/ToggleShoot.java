package frc.robot.commands;

import frc.robot.constants.*;
import frc.robot.driver.*;
import frc.robot.subsystems.*;
import frc.robot.util.*;
import frc.robot.*;
import edu.wpi.first.wpilibj.command.InstantCommand;

public class ToggleShoot extends InstantCommand {

    public ToggleShoot() {
        super();
        requires(Robot.pneumatics);
    }

    @Override
    protected void initialize() {
        Robot.pneumatics.shootCargo();
    }

}
