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

    public static void updateLineSensorsH(LineFollowerH lineFollower) {
        final String addressString = "StormDashboard/LineFollower/";
        SmartDashboard.putBoolean(addressString + "Hatch Left", lineFollower.lineLeftH.get());
        SmartDashboard.putBoolean(addressString + "Hatch Center", lineFollower.lineMiddleH.get());
        SmartDashboard.putBoolean(addressString + "Hatch Right", lineFollower.lineRightH.get());

        SmartDashboard.putNumber(addressString + "Hatch Distance", lineFollower.infraredH.getVoltage());
    }

    public static void updateLineSensorsC(LineFollowerC lineFollower) {
        final String addressString = "StormDashboard/LineFollower/";
        SmartDashboard.putBoolean(addressString + "Cargo Left", lineFollower.lineLeftC.get());
        SmartDashboard.putBoolean(addressString + "Cargo Center", lineFollower.lineMiddleC.get());
        SmartDashboard.putBoolean(addressString + "Cargo Right", lineFollower.lineRightC.get());

        SmartDashboard.putNumber(addressString + "Cargo Distance", lineFollower.infraredC.getVoltage());
    }

    public static void updateCANSparkMax(CANSparkMax sparkMax, String label) {

        final String addressString = "StormDashboard/CANSparkMax/" + label + "/";

        //SmartDashboard.putNumber(addressString + "Bus_Voltage", sparkMax.getBusVoltage());
        SmartDashboard.putNumber(addressString + "Output_Percent", sparkMax.get());
        //SmartDashboard.putNumber(addressString + "Output_Voltage", sparkMax.getAppliedOutput());
        SmartDashboard.putNumber(addressString + "Output_Current", sparkMax.getOutputCurrent());
        //SmartDashboard.putNumber(addressString + "Output_Watts",
         //       sparkMax.getOutputCurrent() * sparkMax.getBusVoltage());
        //SmartDashboard.putString(addressString + "Control_Mode", sparkMax.getPIDController().toString());
        //SmartDashboard.putNumber(addressString + "Temperature", sparkMax.getMotorTemperature());
        //SmartDashboard.putBoolean(addressString + "isInverted", sparkMax.getInverted());

        SmartDashboard.putNumber("Encoder_Velocity", sparkMax.getEncoder().getVelocity());
        SmartDashboard.putNumber("Encoder_Position", sparkMax.getEncoder().getPosition());

    }

    public static void updateTalon(TalonAbsolute talon, String label) {

        final String addressString = "StormDashboard/Talon/" + label + "/";

        //SmartDashboard.putNumber(addressString + "Bus Voltage", talon.getBusVoltage());
        SmartDashboard.putNumber(addressString + "Output Percent", talon.getMotorOutputPercent());
        //SmartDashboard.putNumber(addressString + "Output Voltage", talon.getMotorOutputVoltage());
        SmartDashboard.putNumber(addressString + "Output Current", talon.getOutputCurrent());
        //SmartDashboard.putNumber(addressString + "Output Watts", talon.getOutputCurrent() * talon.getMotorOutputVoltage());
        SmartDashboard.putString(addressString + "control Mode", talon.getControlMode().toString());
        SmartDashboard.putNumber(addressString + "Position", talon.get());
        SmartDashboard.putNumber(addressString + "Angle", talon.getAngle());
        SmartDashboard.putNumber(addressString + "Negative_Angle", talon.getAngleNeg());
        //SmartDashboard.putBoolean(addressString + "Inverted", talon.getInverted());
    }

    public static  void updateNavX() {
        final String addressString = "StormDashboard/NavX/";

        // try {
        //     if (NavX.getNavx() != null) {
        //         SmartDashboard.putBoolean(addressString + "Connected", NavX.getNavx().isConnected());
        //         SmartDashboard.putNumber(addressString + "Gyro/Pitch", NavX.getNavx().getPitch());
        //         SmartDashboard.putNumber(addressString + "Gyro/Roll", NavX.getNavx().getRoll());
        //         SmartDashboard.putNumber(addressString + "Gyro/Yaw", NavX.getNavx().getYaw());
        //         SmartDashboard.putNumber(addressString + "Altitude", NavX.getNavx().getAltitude());
        //         SmartDashboard.putNumber(addressString + "Displacement/X", NavX.getNavx().getDisplacementX());
        //         SmartDashboard.putNumber(addressString + "Displacement/Y", NavX.getNavx().getDisplacementY());
        //         SmartDashboard.putNumber(addressString + "Displacement/Z", NavX.getNavx().getDisplacementZ());
        //         SmartDashboard.putNumber(addressString + "CompassHeading", NavX.getNavx().getCompassHeading());
        //         SmartDashboard.putNumber(addressString + "Velocity/X", NavX.getNavx().getVelocityX());
        //         SmartDashboard.putNumber(addressString + "Velocity/Y", NavX.getNavx().getVelocityY());
        //         SmartDashboard.putNumber(addressString + "Velocity/Z", NavX.getNavx().getVelocityZ());
        //         SmartDashboard.putNumber(addressString + "BarometricPressure", NavX.getNavx().getBarometricPressure());
        //         SmartDashboard.putNumber(addressString + "Quaternion/W", NavX.getNavx().getQuaternionW());
        //         SmartDashboard.putNumber(addressString + "Quaternion/X", NavX.getNavx().getQuaternionX());
        //         SmartDashboard.putNumber(addressString + "Quaternion/Y", NavX.getNavx().getQuaternionY());
        //         SmartDashboard.putNumber(addressString + "Quaternion/Z", NavX.getNavx().getQuaternionZ());
        //     } else {
        //         SmartDashboard.putBoolean(addressString + "Connected", false);
        //     }
        // } catch (NullPointerException npe) {
        //     SmartDashboard.putBoolean(addressString + "Connected", false);
        // }
    }

}
