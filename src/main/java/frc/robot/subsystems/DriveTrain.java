package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.*;
import frc.robot.constants.*;
import frc.robot.driver.*;
import frc.robot.util.*;
import frc.robot.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.CANPIDController;


/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveTrain extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public final TalonSRX leftMotor;
    public final TalonSRX leftMotor2;

    public final TalonSRX rightMotor;
    public final TalonSRX rightMotor2;




    public DriveTrain() {

        // super("DriveTrain", 2.0, 0.0, 0.0) The constructor passes a name for the subsystem and the P, I and D constants that are useed when computing the motor output
        // getPIDController().setContinuous(false); manipulating the raw internal PID Controller
        // setInputRange(0, 4096);
        // setOutputRange(-1, 1);
        // setPercentTolerance(0.05);


        leftMotor = new TalonSRX(RobotMap.LEFT_MOTOR_ID);
        leftMotor2 = new TalonSRX(RobotMap.LEFT_MOTOR2_ID);
        rightMotor = new TalonSRX(RobotMap.RIGHT_MOTOR_ID);
        rightMotor2 = new TalonSRX(RobotMap.RIGHT_MOTOR2_ID);

/*
        leftMotor.setRampRate(RobotMap.RAMP_RATE);
        rightMotor.setRampRate(RobotMap.RAMP_RATE);
        leftMotor2.setRampRate(RobotMap.RAMP_RATE);
        rightMotor2.setRampRate(RobotMap.RAMP_RATE);
*/


        leftMotor2.follow(leftMotor);
        rightMotor2.follow(rightMotor);






    }

    public void tankDrive(double leftSpeed, double rightSpeed) {

        leftMotor.set(ControlMode.PercentOutput, -leftSpeed);
        rightMotor.set(ControlMode.PercentOutput, rightSpeed);

    }

    public void stopDrive() {
        leftMotor.set(ControlMode.PercentOutput, 0);
        rightMotor.set(ControlMode.PercentOutput, 0);
    }

    public void disableDrive() {
        leftMotor.set(ControlMode.PercentOutput, 0);
        rightMotor.set(ControlMode.PercentOutput, 0);
    }

    public boolean checkSticksMoved() {
        boolean leftStickMoved = JoystickMath.getCubic(Robot.oi.getLeftSpeedDriver()) != 0;
        boolean rightStickMoved = JoystickMath.getCubic(Robot.oi.getRightSpeedDriver()) != 0;
        if (leftStickMoved || rightStickMoved) {
            System.out.println("sticks were moved!!!");
            return true;
        } else {
            System.out.println("sticks were not moved!!!");
            return false;
        }
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new JoystickDrive());
    }

}
