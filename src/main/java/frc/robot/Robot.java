/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.DriveTrain;
import frc.robot.util.Controller;
import edu.wpi.first.wpilibj.Joystick;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

@SuppressWarnings("deprecation")
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static DriveTrain m_subsystem = new DriveTrain();
  public static OI m_oi;

  DifferentialDrive           robotDrive;
  CANSparkMax               motorLeft, motorRight;
  Joystick            stick;

  Command m_autonomousCommand;
  Controller controller = new Controller();
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  public Robot() 
    {
        System.out.println("Robot.constructor()");
    }

  @Override
  public void robotInit() {
    m_oi = new OI();
    //m_chooser.setDefaultOption("DriveTrain", new DriveTrain());
    // chooser.addOption("My Auto", new MyAutoCommand());
    SmartDashboard.putData("Auto mode", m_chooser);

    System.out.println("Robot.robotInit()");
 
        // Create two PWM Talon motor controller objects for left & right motors on PWM ports 0 & 1.
        // Assumes robot has two motors controlled by Talon controllers connected via PWM.
        // Add them to a drive controller class that can do tank and arcade driving based on
        // joystick input.

        motorLeft = new CANSparkMax(0, MotorType.kBrushless); //change numbers
        motorRight = new CANSparkMax(1, MotorType.kBrushless);

        robotDrive = new DifferentialDrive(motorLeft, motorRight);  
        
        robotDrive.setExpiration(0.1);   // need to see motor input at least every 
                                         // 10th of a second or stop motors.

        // One side has motors reversed so the wheels turn in the same direction.
        //robotDrive.setRightSideInverted(false);

        stick = new Joystick(0);         // joystick on usb port 0.
  }

  public void autonomous() 
    {
        System.out.println("Robot.autonomous()");

        //robotDrive.setSafetyEnabled(false);     // motor safety off due to the fact
                                                // we want the motor to run 2 sec
                                                // with no other input.

        //robotDrive.tankDrive(0.5, 0.5);         // drive forwards half speed
        //Timer.delay(2.0);                       //    for 2 seconds.
        //robotDrive.tankDrive(0.0, 0.0);         // stop motors.
    }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_chooser.getSelected();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    motorLeft.set(controller.getLeftSpeed());
    motorRight.set(controller.getRightSpeed());
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
