/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.constants;

import frc.robot.commands.*;
import frc.robot.driver.*;
import frc.robot.subsystems.*;
import frc.robot.util.*;
import frc.robot.*;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.

    public static final int LEFT_MOTOR_ID = 14;
    public static final int RIGHT_MOTOR_ID = 1;
    public static final int LEFT_MOTOR2_ID = 15;
    public static final int RIGHT_MOTOR2_ID = 36;

    public static final int LEFT_TALON_ID = 5;
    public static final int RIGHT_TALON_ID = 4;

    public static final int RAMP_RATE = 0;

    public static final int STALL_LIMIT = 255;
    public static final int FREE_LIMIT = 255;
    public static final int RPM_LIMIT = 5700;

    public static final double CONTROLLER_DEADZONE = 0.05;

    public static final int TICKS_PER_REVOLUTION = 4096;
    public static final double WHEEL_DIAMETER = 0.15 * 3.279;   //meters
    public static final double MAX_VELOCITY = 20;   //meters/sec

}
