/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.constants;

import frc.robot.commands.*;
import frc.robot.constants.*;
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
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;
  public final static int LEFT_MOTOR_ID = 0;
  public final static int RIGHT_MOTOR_ID = 1;
  public final static int RAMP_RATE = 0;

  public final static double PROPORTION = 0;
  public final static double INTEGRAL = 0;
  public final static double DIFFERENTIAL = 0;

  public final static int STALL_LIMIT = 255;
  public final static int FREE_LIMIT = 255;
  public final static int RPM_LIMIT = 5700;

  public final static int SOL_PICKUP_PORT = 0;
  public final static int SOL_PUNCH_PORT = 1;
  public final static int SOL_HAB_PORT = 2;
  public final static int SOL_ARM_PORT = 3;

  public final static int PHO_RIGHT_PORT = 0;
  public final static int PHO_MIDDLE_PORT = 0;
  public final static int PHO_LEFT_PORT = 0;

  public final static double CONTROLLER_DEADZONE = 0.05;
  
  public final static double LIGHT_THRESHOLD = 3000;


  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
