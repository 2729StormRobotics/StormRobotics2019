package frc.robot.driver;

import frc.robot.commands.*;
import frc.robot.constants.*;
import frc.robot.driver.*;
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

    

    private void updateCANSparkMax(CANSparkMax sparkMax) {

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

    


    /** When navX implemenation is complete

    private void updateNavX(NavX navX) {
        if (NavX.getNavx() != null) {

            final String addressString = "StormDashboard/NavX/";

            SmartDashboard.putBoolean(addressString + "Connected", navX.getNavx().isConnected());
            SmartDashboard.putNumber(addressString + "Gyro/Pitch", navX.getNavx().getPitch());
            SmartDashboard.putNumber(addressString + "Gyro/Roll", navX.getNavx().getRoll());
            SmartDashboard.putNumber(addressString + "Gyro/Yaw", navX.getNavx().getYaw());
            SmartDashboard.putNumber(addressString + "Altitude", navX.getNavx().getAltitude());
            SmartDashboard.putNumber(addressString + "Displacement/X", navX.getNavx().getDisplacementX());
            SmartDashboard.putNumber(addressString + "Displacement/Y", navX.getNavx().getDisplacementY());
            SmartDashboard.putNumber(addressString + "Displacement/Z", navX.getNavx().getDisplacementZ());
            SmartDashboard.putNumber(addressString + "CompassHeading", navX.getNavx().getCompassHeading());
            SmartDashboard.putNumber(addressString + "Velocity/X", navX.getNavx().getVelocityX());
            SmartDashboard.putNumber(addressString + "Velocity/Y", navX.getNavx().getVelocityY());
            SmartDashboard.putNumber(addressString + "Velocity/Z", navX.getNavx().getVelocityZ());
            SmartDashboard.putNumber(addressString + "BarometricPressure", navX.getNavx().getBarometricPressure());
            SmartDashboard.putNumber(addressString + "Quaternion/W", navX.getNavx().getQuaternionW());
            SmartDashboard.putNumber(addressString + "Quaternion/X", navX.getNavx().getQuaternionX());
            SmartDashboard.putNumber(addressString + "Quaternion/Y", navX.getNavx().getQuaternionY());
            SmartDashboard.putNumber(addressString + "Quaternion/Z", navX.getNavx().getQuaternionZ());
        }
    }
    */

}
