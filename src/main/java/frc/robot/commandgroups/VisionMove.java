package frc.robot.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.commands.*;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.NetworkTablesJNI;


public class VisionMove extends CommandGroup {

    public VisionMove() {
    }

    /**
     * @return the hatchDistance
     */
    public static double getHatchDistance() {
        NetworkTableEntry ntHatchDistance = Robot.vision.getEntry("hatchDistance");
        return ntHatchDistance.getDouble(0.0);
    }

    /**
     * @return the hatchAngle
     */
    public static double getHatchAngle() {
        NetworkTableEntry ntHatchAngle = Robot.vision.getEntry("hatchAngle");
        return ntHatchAngle.getDouble(0.0);
    }

    /**
     * @return the cargoAngle
     */
    public static double getCargoAngle() {
        NetworkTableEntry ntCargoAngle = Robot.vision.getEntry("cargoAngle");
        return ntCargoAngle.getDouble(0.0);
    }

    /**
     * @return the cargoDistance
     */
    public static double getCargoDistance() {
        NetworkTableEntry ntCargoDistance = Robot.vision.getEntry("cargoDistance");
        return ntCargoDistance.getDouble(0.0);
    }
}
