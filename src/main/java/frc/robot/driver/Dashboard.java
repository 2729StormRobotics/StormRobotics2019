package frc.robot.driver;

import frc.robot.commands.*;
import frc.robot.constants.*;
import frc.robot.subsystems.*;
import frc.robot.util.*;
import frc.robot.*;


import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.kauailabs.navx.AHRSProtocol;


import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Dashboard {


    SendableChooser<Command> autoChooser;

    SendableChooser<Command> test;


    public Dashboard() {

    }


    public static void updateCANSparkMax(CANSparkMax sparkMax) {

        final String addressString = "StormDashboard/CANSparkMax/";

        SmartDashboard.putNumber(addressString + "Bus_Voltage", sparkMax.getBusVoltage());
        SmartDashboard.putNumber(addressString + "Output_Percent", sparkMax.get());
        SmartDashboard.putNumber(addressString + "Output_Voltage", sparkMax.getAppliedOutput());
        SmartDashboard.putNumber(addressString + "Output_Current", sparkMax.getOutputCurrent());
        SmartDashboard.putNumber(addressString + "Output_Watts", sparkMax.getOutputCurrent() * sparkMax.getBusVoltage());
        SmartDashboard.putString(addressString + "Control_Mode", sparkMax.getPIDController().toString());
        SmartDashboard.putNumber(addressString + "Temperature", sparkMax.getMotorTemperature());
        SmartDashboard.putBoolean(addressString + "isInverted", sparkMax.getInverted());

        SmartDashboard.putNumber("Left_Velocity", sparkMax.getEncoder().getVelocity());
        SmartDashboard.putNumber("Encoder_Left", sparkMax.getEncoder().getPosition());
        SmartDashboard.putNumber("Right_Velocity", sparkMax.getEncoder().getVelocity());
        SmartDashboard.putNumber("Encoder_Right", sparkMax.getEncoder().getVelocity());

    }


     public static void updateNavX() {
     if (NavX.getNavx() != null) {

     final String addressString = "StormDashboard/NavX/";

     SmartDashboard.putBoolean(addressString + "Connected", NavX.getNavx().isConnected());
     SmartDashboard.putNumber(addressString + "Gyro/Pitch", NavX.getNavx().getPitch());
     SmartDashboard.putNumber(addressString + "Gyro/Roll", NavX.getNavx().getRoll());
     SmartDashboard.putNumber(addressString + "Gyro/Yaw", NavX.getNavx().getYaw());
     SmartDashboard.putNumber(addressString + "Altitude", NavX.getNavx().getAltitude());
     SmartDashboard.putNumber(addressString + "Displacement/X", NavX.getNavx().getDisplacementX());
     SmartDashboard.putNumber(addressString + "Displacement/Y", NavX.getNavx().getDisplacementY());
     SmartDashboard.putNumber(addressString + "Displacement/Z", NavX.getNavx().getDisplacementZ());
     SmartDashboard.putNumber(addressString + "CompassHeading", NavX.getNavx().getCompassHeading());
     SmartDashboard.putNumber(addressString + "Velocity/X", NavX.getNavx().getVelocityX());
     SmartDashboard.putNumber(addressString + "Velocity/Y", NavX.getNavx().getVelocityY());
     SmartDashboard.putNumber(addressString + "Velocity/Z", NavX.getNavx().getVelocityZ());
     SmartDashboard.putNumber(addressString + "BarometricPressure", NavX.getNavx().getBarometricPressure());
     SmartDashboard.putNumber(addressString + "Quaternion/W", NavX.getNavx().getQuaternionW());
     SmartDashboard.putNumber(addressString + "Quaternion/X", NavX.getNavx().getQuaternionX());
     SmartDashboard.putNumber(addressString + "Quaternion/Y", NavX.getNavx().getQuaternionY());
     SmartDashboard.putNumber(addressString + "Quaternion/Z", NavX.getNavx().getQuaternionZ());
     }
     }


}
