package frc.robot.subsystems;

import frc.robot.commands.*;
import frc.robot.constants.*;
import frc.robot.driver.*;
import frc.robot.util.*;
import frc.robot.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.constants.RobotMap;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Pneumatics extends Subsystem {
    //private AxisCamera camera;                       //defines Axis Camera
    private DoubleSolenoid solPickUp;
    private DoubleSolenoid solPunch;                             //defines solenoids
    private DoubleSolenoid solHab;
    private DoubleSolenoid solArm;
    private DoubleSolenoid solCargoPickUp;
    private DoubleSolenoid solShoot;
    private Compressor airCompressor;

    public Pneumatics() {
        airCompressor = new Compressor();  //Digtial I/O,Relay
        airCompressor.start();                        // Start the air compressor

        solPickUp = new DoubleSolenoid(RobotMap.SOL_PICKUP_PORT, RobotMap.SOL_PICKUP_PORT + 1);                        // Solenoid port
        solPunch = new DoubleSolenoid(RobotMap.SOL_PUNCH_PORT, RobotMap.SOL_PUNCH_PORT + 1);
        solHab = new DoubleSolenoid(RobotMap.SOL_HAB_PORT, RobotMap.SOL_HAB_PORT + 1);
        solArm = new DoubleSolenoid(RobotMap.SOL_ARM_PORT, RobotMap.SOL_ARM_PORT + 1);

    }

    public void pickupHatch(boolean out) {
        solPickUp.set(out ? Value.kForward : Value.kReverse);
    }

    public Value getPickupHatch() {
        return solPickUp.get();
    }

    public void punchHatch(boolean out) {
        solPunch.set(out ? Value.kForward : Value.kReverse);

    }

    public void outArm(boolean out) {
        solArm.set(out ? Value.kForward : Value.kReverse);
    }

    public Value getPunchHatch() {
        return solPunch.get();
    }

    public void toggleArm() {
        if (solArm.get().equals(Value.kForward)) {
            solArm.set(Value.kReverse);
            return;
        }
        solArm.set(Value.kForward);

    }

    public void toggleGrab() {
        if (solPickUp.get().equals(Value.kForward)) {
            solPickUp.set(Value.kReverse);
            return;
        }
        solPickUp.set(Value.kForward);
    }

    public void togglePunch() {
        if (solPunch.get().equals(Value.kForward)) {
            solPunch.set(Value.kReverse);
            return;
        }
        solPunch.set(Value.kForward);
    }

    public Value getArm() {
        return solPickUp.get();
    }

    public void toggleHab() {
        if (solHab.get().equals(Value.kForward)) {
            solHab.set(Value.kReverse);
            return;
        }
        solHab.set(Value.kForward);
    }

    public Value getHab() {
        return solHab.get();
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
