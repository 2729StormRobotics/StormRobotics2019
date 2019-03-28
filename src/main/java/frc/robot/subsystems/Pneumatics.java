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


    public Pneumatics() {
                            // Start the air compressor

        solPickUp = new DoubleSolenoid(0,1,2);                        // Solenoid port
    
    }

    public void toggleSolonoid(boolean out){
        if(out){
            solPickUp.set(Value.kForward);
        }else{
            solPickUp.set(Value.kReverse);
        }
        
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand();
    }


}
