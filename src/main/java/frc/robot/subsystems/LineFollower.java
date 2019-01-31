package frc.robot.subsystems;

import frc.robot.commands.*;
import frc.robot.constants.*;
import frc.robot.driver.*;
import frc.robot.util.*;
import frc.robot.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.constants.RobotMap;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.AnalogInput;

public class LineFollower extends Subsystem {
     //private AxisCamera camera;                       //defines Axis Camera
     private AnalogInput lineRight;
     private AnalogInput lineLeft;
     private AnalogInput lineMiddle;
     private AnalogInput infrared;
     private boolean noLine;

     
     


     public LineFollower() {

        lineLeft = new AnalogInput(RobotMap.PHO_LEFT_PORT);
        lineMiddle = new AnalogInput(RobotMap.PHO_MIDDLE_PORT);                        // Solenoid port
        lineRight = new AnalogInput(RobotMap.PHO_RIGHT_PORT);
        infrared = new AnalogInput(RobotMap.INFRA_PORT);
        noLine = false;

     }

     public void followLine(){
       noLine = false;
      switch (getState()){
        case("000"):
          // finish command;
          Robot.driveTrain.stopDrive();
        case("100"):
          // drive left;
          Robot.driveTrain.tankDrive(0.5, 1);
        case("010"):
          // drive forward;
          Robot.driveTrain.tankDrive(1, 1);
        case("001"):
          // drive right;
          Robot.driveTrain.tankDrive(1, 0.5);
        case("110"):
          // drive left slowly;
          Robot.driveTrain.tankDrive(0.75, 1);
        case("011"):
          // drive right slowly;
          Robot.driveTrain.tankDrive(1, 0.75);
        case("111"):
          // error, shouldnt be possible
          
      }
        


     }

     public String getState() {
      return isLine(lineLeft) + isLine(lineMiddle) + isLine(lineRight);
     }


     public String isLine(AnalogInput lineFollow) {
        if (lineFollow.getValue() >= RobotMap.LIGHT_THRESHOLD) {
          return "1";
        } 

        return "0";
     }

     public boolean isFinished() {
       return infrared.getValue() <= RobotMap.DISTANCE_FROM_LINE || noLine;
     }

    @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    //setDefaultCommand();
  }
}
