/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.constants.*;
import frc.robot.driver.*;
import frc.robot.subsystems.*;
import frc.robot.util.*;
import frc.robot.*;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.PIDOutput;

public class PointTurn extends Command {

    private double angle; //delta angle
    private double initAngle;
    private double turnSpeed;
    private double setpoint;
    private PIDController turnController;

  public PointTurn(double angle) {
    requires(Robot.driveTrain);
    this.angle = angle;
  }

    // private final PIDSource angleSource = new PIDSource() {

    //     @Override
    //     public void setPIDSourceType(PIDSourceType pidSource) {

    //     }

    //     @Override
    //     public PIDSourceType getPIDSourceType() {
    //         return PIDSourceType.kDisplacement;
    //     }

    //     // @Override
    //     // public double pidGet() {
    //         // try {
    //         //     return NavX.getNavx().getYaw();
    //         // } catch (NullPointerException npe) {
    //         //     return restrictAngleRange(angle + initAngle);
    //         // }
    //     // }
    // };


    private final PIDOutput turnSpeedSetter = new PIDOutput() {
        @Override
        public void pidWrite(double speed) {
            turnSpeed = speed;
        }
    };


  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

        // turnController = new PIDController(
        //     PIDMap.POINT_TURN_P,
        //     PIDMap.POINT_TURN_I,
        //     PIDMap.POINT_TURN_D,
        //     angleSource,
        //     turnSpeedSetter,
        //     PIDMap.POINT_TURN_PERIOD
        // );
        turnController.setInputRange(0, 360);
        turnController.setOutputRange(-.80, .80);
        turnController.setAbsoluteTolerance(PIDMap.POINT_TURN_TOLERANCE);
        turnController.setContinuous(true);

    try{
        // initAngle = NavX.getNavx().getYaw();
    } catch (NullPointerException npe){
        initAngle = 0;
        npe.printStackTrace();
    }

    setpoint = restrictAngleRange(initAngle + angle);
    turnController.setSetpoint(setpoint);

    turnController.enable();

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    Robot.driveTrain.tankDrive(turnSpeed, -turnSpeed);

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    //return angleChanged() >= Math.abs(angle);
    return turnController.onTarget();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
      turnController.disable();
      Robot.driveTrain.tankDrive(0, 0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
      turnController.disable();
      Robot.driveTrain.tankDrive(0, 0);
  }

/*
  private double angleChanged() {
    int direction = (angle >= 0 ? 1 : -1);
    return (direction * (gyroAngle - initAngle) < 0 ? 360 : 0) + direction * (gyroAngle - initAngle);
  }
*/

  private double restrictAngleRange(double theta) {
    return (theta < 0 ? 360 + (theta % 360) : theta % 360);
  }


}
