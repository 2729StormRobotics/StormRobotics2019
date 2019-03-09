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
     * @return the getX
     */
    public static double getX() {
        NetworkTableEntry ntX = Robot.vision.getEntry("hatchX");
        return ntX.getDouble(0.0);
    }

    /**
     * @return the getY
     */
    public static double getY() {
        NetworkTableEntry ntY = Robot.vision.getEntry("hatchY");
        return ntY.getDouble(0.0);
    }

    /**
     * @return the getAngle
     */
    public static double getAngle() {
        NetworkTableEntry ntAngle = Robot.vision.getEntry("hatchAngle");
        return ntAngle.getDouble(0.0);
    }

    /**
     * @return the cargoDistance
     */
    /*
    public static double getCargoDistance() {
        NetworkTableEntry ntCargoDistance = Robot.vision.getEntry("cargoDistance");
        return ntCargoDistance.getDouble(0.0);
    }
    */

}
