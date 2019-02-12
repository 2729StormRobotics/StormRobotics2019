package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.Robot;
import frc.robot.constants.RobotMap;
import frc.robot.util.TalonAbsolute;

public class CargoArm extends PIDSubsystem {
    // private AxisCamera camera; //defines Axis Camera
    private CANSparkMax leftMotor;
    private CANSparkMax rightMotor;
    private TalonAbsolute _talon;

    public CargoArm() {

        super("CargoArm", 2.0, 0.0, 0.0);// The constructor passes a name for the subsystem and the P, I and D constants that are useed when computing the motor output
        getPIDController().setContinuous(false); //manipulating the raw internal PID Controller
        setInputRange(0, 4096);
        setOutputRange(-1, 1);
        setPercentTolerance(0.05);

        leftMotor = new CANSparkMax(1, MotorType.kBrushless);
        rightMotor = new CANSparkMax(1, MotorType.kBrushless);
        _talon = new TalonAbsolute(1);



    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand();
    }

    protected double returnPIDInput() {
        return _talon.get(); // returns the sensor value that is providing the feedback for the system
    }

    protected void usePIDOutput(double output) {
        leftMotor.pidWrite(-output); // this is where the computed output value fromthe PIDController is applied to the motor
        rightMotor.pidWrite(output);
    }


}

