/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.schedulers.SequentialScheduler;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.cameraserver.*;
import edu.wpi.first.networktables.NetworkTable;
import frc.robot.commands.*;
import frc.robot.commandgroups.*;
import frc.robot.constants.*;
import frc.robot.driver.*;
import frc.robot.subsystems.*;
import frc.robot.util.*;


import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.robot.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

    public static OI oi;
    public static DriveTrain driveTrain;
    public static Pneumatics pneumatics;
    public static LineFollowerH lineFollowerH;
    public static LineFollowerC lineFollowerC;
    public static CargoArm cargoArm;
    public static NavX navX;
    public static HatchVision hatchVision;
    public static CargoVision cargoVision;
    public static NetworkTable vision;
    CommandGroup resetSubsystems;
    public static SerialPort jevois;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {

        //m_chooser.setDefaultOption("DriveTrain", new DriveTrain());
        // chooser.addOption("My Auto", new MyAutoCommand());
        System.out.println("robotInit() has been called!");
        driveTrain = new DriveTrain();
        pneumatics = new Pneumatics();
        lineFollowerC = new LineFollowerC();
        lineFollowerH = new LineFollowerH();
        cargoArm = new CargoArm();
        resetSubsystems = new ResetSubsystems(); //retracts grab and punch pistons
        navX = new NavX();
        hatchVision = new HatchVision();
        cargoVision = new CargoVision();
        oi = new OI();

        jevois = new SerialPort(57600, SerialPort.Port.kMXP);

        vision = NetworkTableInstance.getDefault().getTable("Vision");
        CameraServer.getInstance().startAutomaticCapture();
        CameraServer.getInstance().startAutomaticCapture();

        new PunchOut();
        new ArmOut();
        new HabIn();



        System.out.println("robotInit() has finished!!");

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
        //Dashboard.updateCANSparkMax(driveTrain.leftMotor, "Drive/Left/1");
        //Dashboard.updateCANSparkMax(driveTrain.leftMotor2, "Drive/Left/2");
        //Dashboard.updateCANSparkMax(driveTrain.rightMotor, "Drive/Right/1");
        //Dashboard.updateCANSparkMax(driveTrain.rightMotor2, "Drive/Right/2");
        //Dashboard.updateTalon(driveTrain.getLeftTalon(), "Drive/TalonLeft");
        //Dashboard.updateTalon(driveTrain.getRightTalon(), "Drive/TalonRight");

        //Dashboard.updateCANSparkMax(cargoArm.leftMotor, "CargoArm/Left");
        //Dashboard.updateCANSparkMax(cargoArm.rightMotor, "CargoArm/Right");
        Dashboard.updateTalon(cargoArm.armTalon, "CargoArm/Talon");


        Dashboard.updateArmBoolean();


        Dashboard.updateLineSensorsC(lineFollowerC);
        Dashboard.updateLineSensorsH(lineFollowerH);

        cargoArm.armTalon.debugEncoder();

        //Dashboard.updateNavX(navX);
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
        //retractPistons.start();
    }

    /**
     * This function is called periodically during operator control.
     */
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();

    }

    /**
     * This function is called periodically during test mode.
     */
    @Override
    public void testPeriodic() {
        Scheduler.getInstance().run();
    }
}
