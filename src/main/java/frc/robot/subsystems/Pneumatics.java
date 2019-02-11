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

        solPickUp = new DoubleSolenoid(0,1);                        // Solenoid port
        solPunch = new DoubleSolenoid(0,1);
        solHab = new DoubleSolenoid(0,1);
        solArm = new DoubleSolenoid(0,1);

    }

    public void pickupHatch() {
        if (solPickUp.get().equals(Value.kForward))
            solPickUp.set(Value.kReverse);
        solPickUp.set(Value.kForward);

    }

    public Value getPickupHatch() {
        return solPickUp.get();
    }

    public void punchHatch() {
        if (solPunch.get().equals(Value.kForward))
            solPunch.set(Value.kReverse);
        solPunch.set(Value.kForward);

    }

    public Value getPunchHatch() {
        return solPunch.get();
    }

    public void toggleArm() {
        if (solArm.get().equals(Value.kForward))
            solArm.set(Value.kReverse);
        solArm.set(Value.kForward);

    }

    public Value getArm() {
        return solPickUp.get();
    }

    public void toggleHab() {
        if (solHab.get().equals(Value.kForward))
            solHab.set(Value.kReverse);
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
