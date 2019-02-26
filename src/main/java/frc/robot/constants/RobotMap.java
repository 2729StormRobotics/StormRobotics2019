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

    public static final int FRONT_ARM_ID = 13;
    public static final int BACK_ARM_ID = 2;
    public static final int ARM_TALON_ID = 10;
    public static final double MAX_ARM_ANGLE = 100;
    public static final double MIN_ARM_ANGLE = 0;

    public static final double HORIZONTAL_ARM_ANGlE = 0;
    public static final double LVL1_ARM_ANGlE = 48;
    public static final double SHIP_ARM_ANGlE = 90;


    public static final int RAMP_RATE = 0;

    public static final double PROPORTION = 0;
    public static final double INTEGRAL = 0;
    public static final double DIFFERENTIAL = 0;

    public static final int STALL_LIMIT = 255;
    public static final int FREE_LIMIT = 255;
    public static final int RPM_LIMIT = 5700;

    public static final int SOL_PICKUP_PORT = 6;
    public static final int SOL_PUNCH_PORT = 2;
    public static final int SOL_HAB_PORT = 0;
    public static final int SOL_ARM_PORT = 4;

    public static final int CARGO_INTAKE_PORT = 11;

    public static final int PHO_RIGHT_PORT_H = 0; //hatch side
    public static final int PHO_MIDDLE_PORT_H = 1;
    public static final int PHO_LEFT_PORT_H = 2;

    public static final int PHO_RIGHT_PORT_C = 7; //cargo side
    public static final int PHO_MIDDLE_PORT_C = 8;
    public static final int PHO_LEFT_PORT_C = 9;

    public static final double CONTROLLER_DEADZONE = 0.05;

    public static final double LIGHT_THRESHOLD = 3000;

    public static final int INFRA_PORT_H = 3;
    public static final int INFRA_PORT_C = 0;

    public static final double DISTANCE_FROM_LINE = 5; //cm

    public static final int TICKS_PER_REVOLUTION = 4096;
    public static final double WHEEL_DIAMETER = 0.15 * 3.279;   //meters
    public static final double MAX_VELOCITY = 20;   //meters/sec

    public static final double BASE_SPEED = 0.2; //for line following

    public static final double HORIZONTAL_POWER = 0.3913/12; //% motor power to cargoArm to remain horizontal
}
