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



}
