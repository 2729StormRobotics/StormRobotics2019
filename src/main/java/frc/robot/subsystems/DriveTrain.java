package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import frc.robot.commands.*;
import frc.robot.constants.*;
import frc.robot.driver.*;
import frc.robot.util.*;
import frc.robot.*;

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

    private final CANSparkMax leftMotor;
    private final CANSparkMax leftMotor2;

    private final CANSparkMax rightMotor;
    private final CANSparkMax rightMotor2;

    private final TalonSRX leftTalonSRX;
    private final TalonSRX rightTalonSRX;

    private final CANPIDController leftPID;
    private final CANPIDController rightPID;
    private final CANPIDController left2PID;
    private final CANPIDController right2PID;


    public DriveTrain() {
        leftMotor = new CANSparkMax(RobotMap.LEFT_MOTOR_ID, CANSparkMaxLowLevel.MotorType.kBrushless);
        leftMotor2 = new CANSparkMax(RobotMap.LEFT_MOTOR2_ID, CANSparkMaxLowLevel.MotorType.kBrushless);
        rightMotor = new CANSparkMax(RobotMap.RIGHT_MOTOR_ID, CANSparkMaxLowLevel.MotorType.kBrushless);
        rightMotor2 = new CANSparkMax(RobotMap.RIGHT_MOTOR2_ID, CANSparkMaxLowLevel.MotorType.kBrushless);

        leftTalonSRX = new TalonSRX(RobotMap.LEFT_TALON_ID);
        rightTalonSRX = new TalonSRX(RobotMap.RIGHT_TALON_ID);

        leftMotor.setRampRate(RobotMap.RAMP_RATE);
        rightMotor.setRampRate(RobotMap.RAMP_RATE);
        leftMotor2.setRampRate(RobotMap.RAMP_RATE);
        rightMotor2.setRampRate(RobotMap.RAMP_RATE);

        leftPID = new CANPIDController(leftMotor);
        rightPID = new CANPIDController(rightMotor);

        left2PID = new CANPIDController(leftMotor2);
        right2PID = new CANPIDController(rightMotor2);

        leftPID.setP(RobotMap.PROPORTION);
        leftPID.setI(RobotMap.INTEGRAL);
        leftPID.setD(RobotMap.DIFFERENTIAL);

        left2PID.setP(RobotMap.PROPORTION);
        left2PID.setI(RobotMap.INTEGRAL);
        left2PID.setD(RobotMap.DIFFERENTIAL);

        rightPID.setP(RobotMap.PROPORTION);
        rightPID.setI(RobotMap.INTEGRAL);
        rightPID.setD(RobotMap.DIFFERENTIAL);

        right2PID.setP(RobotMap.PROPORTION);
        right2PID.setI(RobotMap.INTEGRAL);
        right2PID.setD(RobotMap.DIFFERENTIAL);

        leftMotor.setSmartCurrentLimit(RobotMap.STALL_LIMIT, RobotMap.FREE_LIMIT, RobotMap.RPM_LIMIT);
        rightMotor.setSmartCurrentLimit(RobotMap.STALL_LIMIT, RobotMap.FREE_LIMIT, RobotMap.RPM_LIMIT);
        leftMotor2.setSmartCurrentLimit(RobotMap.STALL_LIMIT, RobotMap.FREE_LIMIT, RobotMap.RPM_LIMIT);
        rightMotor2.setSmartCurrentLimit(RobotMap.STALL_LIMIT, RobotMap.FREE_LIMIT, RobotMap.RPM_LIMIT);


    }

    public void tankDrive(double leftSpeed, double rightSpeed) {
        //may need to adjust speed values
        leftMotor.set(-leftSpeed);
        leftMotor2.set(-leftSpeed);
        rightMotor.set(rightSpeed);
        rightMotor.set(rightSpeed);
    }

    public void stopDrive() {
        leftMotor.set(0);
        leftMotor2.set(0);
        rightMotor.set(0);
        rightMotor2.set(0);

    }

    public void disableDrive() {
        leftMotor.disable();
        rightMotor.disable();
        leftMotor2.disable();
        rightMotor2.disable();
    }

    public double getLeftPos() {
        return leftEncoder.getPosition();
    }

    public double getRightPos() {
        return rightEncoder.getPosition();
    }

    public double getLeftVelocity() {
        return leftEncoder.getVelocity();
    }

    public double getRightVelocity() {
        return rightEncoder.getVelocity();
    }

    public TalonSRX getLeftTalon() {
        return leftTalonSRX;
    }

    public TalonSRX getRightTalon() {
        return rightTalonSRX;
    }


    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new JoystickDrive());
    }
}
