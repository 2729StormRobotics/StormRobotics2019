package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PIDSourceType;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.constants.PIDMap;
import frc.robot.constants.RobotMap;
import frc.robot.util.TalonAbsolute;
import frc.robot.util.TalonRelative;
import frc.robot.commands.*;

public class CargoArm extends PIDSubsystem {
    // private AxisCamera camera; //defines Axis Camera
    public CANSparkMax leftMotor;
    public CANSparkMax rightMotor;
    public TalonAbsolute armTalon;

    public boolean stopPID;

    private TalonRelative intakeMotor;

    public CargoArm() {


        super("CargoArm", PIDMap.CARGO_ARM_P, PIDMap.CARGO_ARM_I, PIDMap.CARGO_ARM_D);// The constructor passes a name for the subsystem and the P, I and D constants that are useed when computing the motor output
        getPIDController().setContinuous(false); //manipulating the raw internal PID Controller
        setInputRange(-20, 110);
        setOutputRange(-1, 1);
        setPercentTolerance(1);
        stopPID = false;



        leftMotor = new CANSparkMax(RobotMap.FRONT_ARM_ID, MotorType.kBrushless);
        rightMotor = new CANSparkMax(RobotMap.BACK_ARM_ID, MotorType.kBrushless);

        intakeMotor = new TalonRelative(RobotMap.CARGO_INTAKE_PORT);

        armTalon = new TalonAbsolute(RobotMap.ARM_TALON_ID);



    }

    public void armDrive(double speed, double intakeSpeed) {
        //if ((-speed > 0 && armTalon.getAngleNeg() < RobotMap.MAX_ARM_ANGLE) || (-speed < 0 && armTalon.getAngleNeg() > RobotMap.MIN_ARM_ANGLE)) {
            leftMotor.set(speed * 0.15);
            rightMotor.set(speed * 0.15);
        //}

    }

    public void intake(double speed) {
        intakeMotor.set(ControlMode.PercentOutput, speed);
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ArmDrive());
    }

    @Override
    protected double returnPIDInput() {
        //return _talon.get(); // returns the sensor value that is providing the feedback for the system
        return armTalon.getAngle();
    }

    @Override
    protected void usePIDOutput(double output) {
        //output = RobotMap.HORIZONTAL_POWER * Math.cos(Math.toRadians(output));

        leftMotor.pidWrite(0.07 * output); // this is where the computed output value fromthe PIDController is applied to the motor
        rightMotor.pidWrite(0.07 * output);
    }



}

