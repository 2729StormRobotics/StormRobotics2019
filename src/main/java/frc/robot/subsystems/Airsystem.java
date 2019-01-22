package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;

public class Airsystem extends Subsystem {
     //private AxisCamera camera;                       //defines Axis Camera
     private Solenoid s1;
     private Solenoid s2;                             //defines solenoids
     private Solenoid s3;
     private Solenoid s4;

     public Airsystem() {
          Compressor airCompressor = new Compressor();  //Digtial I/O,Relay
          airCompressor.start();                        // Start the air compressor

          s1 = new Solenoid(1);                        // Solenoid port
          s2 = new Solenoid(2);
          s3 = new Solenoid(3);
          s4 = new Solenoid(4);

     }

    @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    //setDefaultCommand();
  }
}
