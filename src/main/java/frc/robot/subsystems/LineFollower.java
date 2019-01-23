package frc.robot.subsystems;

import frc.robot.commands.*;
import frc.robot.constants.*;
import frc.robot.driver.*;
import frc.robot.subsystems.*;
import frc.robot.util.*;
import frc.robot.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.constants.RobotMap;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.DigitalInput;

public class LineFollower extends Subsystem {
     //private AxisCamera camera;                       //defines Axis Camera
     private DigitalInput lineRight;
     private DigitalInput lineLeft;
     private DigitalInput lineMiddle;


     public LineFollower() {
          
        lineRight = new DigitalInput(RobotMap.PHO_RIGHT_PORT);                        // Solenoid port
        lineLeft = new DigitalInput(RobotMap.PHO_LEFT_PORT);
        lineMiddle = new DigitalInput(RobotMap.PHO_MIDDLE_PORT);

     }

     /*public void pickupHatch(){
         solPickUp.set(!solPickUp.get());
         
     }

     public void punchHatch(){
        solPunch.set(!solPunch.get());
        
    }

    public void toggleArm(){
        solArm.set(!solArm.get());
        
    }

    public void toggleHab(){
        solHab.set(!solHab.get());
        
    }*/

    @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    //setDefaultCommand();
  }
}
