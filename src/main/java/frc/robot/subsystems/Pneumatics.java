package frc.robot.subsystems;

import frc.robot.commands.*;
import frc.robot.constants.*;
import frc.robot.driver.*;
import frc.robot.util.*;
import frc.robot.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.constants.RobotMap;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;

public class Pneumatics extends Subsystem {
    //private AxisCamera camera;                       //defines Axis Camera
    private Solenoid solPickUp;
    private Solenoid solPunch;                             //defines solenoids
    private Solenoid solHab;
    private Solenoid solArm;
    private Solenoid solCargoPickUp;
    private Solenoid solShoot;
    private Compressor airCompressor;

    public Pneumatics() {
        airCompressor = new Compressor();  //Digtial I/O,Relay
        airCompressor.start();                        // Start the air compressor

        solPickUp = new Solenoid(RobotMap.SOL_PICKUP_PORT);                        // Solenoid port
        solPunch = new Solenoid(RobotMap.SOL_PUNCH_PORT);
        solHab = new Solenoid(RobotMap.SOL_HAB_PORT);
        solArm = new Solenoid(RobotMap.SOL_ARM_PORT);

        solCargoPickUp = new Solenoid(RobotMap.SOL_CARGOPICK_PORT);
        solShoot = new Solenoid(RobotMap.SOL_SHOOT_PORT);
    }

    public void pickupHatch() {
        solPickUp.set(!solPickUp.get());

    }

    public boolean getPickupHatch() {
        return solPickUp.get();
    }

    public void punchHatch() {
        solPunch.set(!solPunch.get());

    }

    public boolean getPunchHatch() {
        return solPunch.get();
    }

    public void toggleArm() {
        solArm.set(!solArm.get());

    }

    public boolean getArm() {
        return solPickUp.get();
    }

    public void toggleHab() {
        solHab.set(!solHab.get());
    }

    public boolean getHab() {
        return solHab.get();
    }

    public void pickupCargo() {
        solCargoPickUp.set(!solCargoPickUp.get());

    }

    public boolean getPickupCargo() {
        return solCargoPickUp.get();
    }

    public void shootCargo() {
        solShoot.set(!solShoot.get());

    }

    public boolean getShootCargo() {
        return solShoot.get();
    }

    public void disableCompressor() {
        airCompressor.close();
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand();
    }


}
