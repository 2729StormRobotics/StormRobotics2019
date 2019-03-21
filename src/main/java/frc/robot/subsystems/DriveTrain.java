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
import com.revrobotics.CANSparkMax.IdleMode;


import com.revrobotics.CANPIDController;


/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveTrain extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public final CANSparkMax leftMotor;
    public final CANSparkMax leftMotor2;

    public final CANSparkMax rightMotor;
    public final CANSparkMax rightMotor2;

    private final TalonRelative leftTalon;
    private final TalonRelative rightTalon;

    public boolean reverse = false;
    public boolean slow = false;


    public DriveTrain() {

        // super("DriveTrain", 2.0, 0.0, 0.0) The constructor passes a name for the subsystem and the P, I and D constants that are useed when computing the motor output
        // getPIDController().setContinuous(false); manipulating the raw internal PID Controller
        // setInputRange(0, 4096);
        // setOutputRange(-1, 1);
        // setPercentTolerance(0.05);

        leftMotor = new CANSparkMax(RobotMap.LEFT_MOTOR_ID, CANSparkMaxLowLevel.MotorType.kBrushless);
        leftMotor2 = new CANSparkMax(RobotMap.LEFT_MOTOR2_ID, CANSparkMaxLowLevel.MotorType.kBrushless);
        rightMotor = new CANSparkMax(RobotMap.RIGHT_MOTOR_ID, CANSparkMaxLowLevel.MotorType.kBrushless);
        rightMotor2 = new CANSparkMax(RobotMap.RIGHT_MOTOR2_ID, CANSparkMaxLowLevel.MotorType.kBrushless);

        leftTalon = new TalonRelative(RobotMap.LEFT_TALON_ID);
        rightTalon = new TalonRelative(RobotMap.RIGHT_TALON_ID);

        leftMotor.restoreFactoryDefaults();
        leftMotor2.restoreFactoryDefaults();
        rightMotor.restoreFactoryDefaults();
        rightMotor2.restoreFactoryDefaults();

        /*
        leftMotor.setOpenLoopRampRate(RobotMap.RAMP_RATE);
        rightMotor.setOpenLoopRampRate(RobotMap.RAMP_RATE);
        leftMotor2.setOpenLoopRampRate(RobotMap.RAMP_RATE);
        rightMotor2.setOpenLoopRampRate(RobotMap.RAMP_RATE);
        */

        leftMotor.setSmartCurrentLimit(RobotMap.STALL_LIMIT);
        rightMotor.setSmartCurrentLimit(RobotMap.STALL_LIMIT);
        leftMotor2.setSmartCurrentLimit(RobotMap.STALL_LIMIT);
        rightMotor2.setSmartCurrentLimit(RobotMap.STALL_LIMIT);

        leftMotor.setIdleMode(IdleMode.kBrake);
        leftMotor2.setIdleMode(IdleMode.kBrake);
        rightMotor.setIdleMode(IdleMode.kBrake);
        rightMotor2.setIdleMode(IdleMode.kBrake);

        leftMotor2.follow(leftMotor);
        rightMotor2.follow(rightMotor);
    }

    public void tankDrive(double leftSpeed, double rightSpeed) {

        if(slow){
            if(!reverse){
                leftMotor.set(-leftSpeed*0.5);
                rightMotor.set(rightSpeed*0.5);
            } else if (reverse){
                leftMotor.set(rightSpeed*0.5);
                rightMotor.set(-leftSpeed*0.5);
            }
        } else {
            if(!reverse){
                leftMotor.set(-leftSpeed);
                rightMotor.set(rightSpeed);
            } else if (reverse){
                leftMotor.set(rightSpeed);
                rightMotor.set(-leftSpeed);
            }
        }

        //may need to adjust speed values
        //leftMotor.set(SmartDashboard.getNumber("leftSpeed", 0.0));
        //leftMotor2.set(SmartDashboard.getNumber("leftSpeed2", 0.0));
        //rightMotor.set(SmartDashboard.getNumber("rightSpeed", 0.0));
        //rightMotor2.set(SmartDashboard.getNumber("rightSpeed2", 0.0));
    }

    public void stopDrive() {
        leftMotor.set(0);
        rightMotor.set(0);
    }

    public void disableDrive() {
        leftMotor.disable();
        rightMotor.disable();
    }

    public TalonRelative getLeftTalon() {
        return leftTalon;
    }

    public TalonRelative getRightTalon() {
        return rightTalon;
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new JoystickDrive());
    }

}
