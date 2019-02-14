package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PIDSourceType;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.Robot;
import frc.robot.constants.PIDMap;
import frc.robot.constants.RobotMap;
import frc.robot.util.TalonAbsolute;
import frc.robot.util.TalonRelative;

public class CargoArm extends PIDSubsystem {
    // private AxisCamera camera; //defines Axis Camera
    private CANSparkMax leftMotor;
    private CANSparkMax rightMotor;
    //private TalonAbsolute _talon;

    private TalonRelative intakeMotor;

    public CargoArm() {

        super("CargoArm", PIDMap.CARGO_ARM_P, PIDMap.CARGO_ARM_I, PIDMap.CARGO_ARM_D);// The constructor passes a name for the subsystem and the P, I and D constants that are useed when computing the motor output
        getPIDController().setContinuous(false); //manipulating the raw internal PID Controller
        setInputRange(0, 4096);
        setOutputRange(-1, 1);
        setPercentTolerance(0.05);

        leftMotor = new CANSparkMax(RobotMap.FRONT_ARM_ID, MotorType.kBrushless);
        rightMotor = new CANSparkMax(RobotMap.BACK_ARM_ID, MotorType.kBrushless);

        intakeMotor = new TalonRelative(RobotMap.CARGO_INTAKE_PORT);

        //_talon = new TalonAbsolute(1);



    }

    public void armDrive(double speed, double intakeSpeed) {

        leftMotor.set(-speed);
        rightMotor.set(-speed);
        intakeMotor.set(ControlMode.PercentOutput, intakeSpeed);

    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand();
    }

    @Override
    protected double returnPIDInput() {
        //return _talon.get(); // returns the sensor value that is providing the feedback for the system
        return 0.0;
    }

    @Override
    protected void usePIDOutput(double output) {
        leftMotor.pidWrite(-output); // this is where the computed output value fromthe PIDController is applied to the motor
        rightMotor.pidWrite(output);
    }


}

