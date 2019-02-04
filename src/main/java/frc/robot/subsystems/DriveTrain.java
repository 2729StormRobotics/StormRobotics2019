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
    private final CANSparkMax rightMotor;

    private final TalonSRX lefTalonSRX;
    private final TalonSRX rightTalonSRX;

    private final CANEncoder leftEncoder;
    private final CANEncoder rightEncoder;

    private final CANPIDController leftPID;
    private final CANPIDController rightPID;


    public DriveTrain() {
        leftMotor = new CANSparkMax(RobotMap.LEFT_MOTOR_ID, CANSparkMaxLowLevel.MotorType.kBrushless);
        rightMotor = new CANSparkMax(RobotMap.RIGHT_MOTOR_ID, CANSparkMaxLowLevel.MotorType.kBrushless);

        lefTalonSRX = new TalonSRX(RobotMap.LEFT_MOTOR_ID);
        rightTalonSRX = new TalonSRX(RobotMap.RIGHT_MOTOR_ID);

        leftEncoder = leftMotor.getEncoder();
        rightEncoder = rightMotor.getEncoder();

        leftMotor.setRampRate(RobotMap.RAMP_RATE);
        rightMotor.setRampRate(RobotMap.RAMP_RATE);

        leftPID = new CANPIDController(leftMotor);
        rightPID = new CANPIDController(rightMotor);

        leftPID.setP(RobotMap.PROPORTION);
        leftPID.setI(RobotMap.INTEGRAL);
        leftPID.setD(RobotMap.DIFFERENTIAL);

        rightPID.setP(RobotMap.PROPORTION);
        rightPID.setI(RobotMap.INTEGRAL);
        rightPID.setD(RobotMap.DIFFERENTIAL);

        leftMotor.setSmartCurrentLimit(RobotMap.STALL_LIMIT, RobotMap.FREE_LIMIT, RobotMap.RPM_LIMIT);
        rightMotor.setSmartCurrentLimit(RobotMap.STALL_LIMIT, RobotMap.FREE_LIMIT, RobotMap.RPM_LIMIT);


    }

    public void tankDrive(double leftSpeed, double rightSpeed) {
        //may need to adjust speed values
        leftMotor.set(leftSpeed);
        rightMotor.set(rightSpeed);
    }

    public void stopDrive() {
        leftMotor.set(0);
        rightMotor.set(0);
    }

    public void disableDrive() {
        leftMotor.disable();
        rightMotor.disable();
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


    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new JoystickDrive());
    }
}
