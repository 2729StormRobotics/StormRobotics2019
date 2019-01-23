package frc.robot.commands;

import frc.robot.commands.*;
import frc.robot.constants.*;
import frc.robot.driver.*;
import frc.robot.subsystems.*;
import frc.robot.util.*;
import frc.robot.*;
import edu.wpi.first.wpilibj.command.*;

public abstract class CommandBase extends Command {
    public static OI oi;
    public static DriveTrain driveTrain = new DriveTrain();
    public static Pneumatics pneumatics = new Pneumatics();


    public static void init() {
        oi = new OI();
    }

    public CommandBase(String name) {super(name); }
    public CommandBase() {super();}
}