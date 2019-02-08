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
    private double gyroAngle;


  public PointTurn(double angle) {
    requires(Robot.driveTrain);
    this.angle = angle;
  }

    private final PIDSource angleSource = new PIDSource() {

        @Override
        public void setPIDSourceType(PIDSourceType pidSource) {

        }

        @Override
        public PIDSourceType getPIDSourceType() {
            return PIDSourceType.kDisplacement;
        }

        @Override
        public double pidGet() {
            return 0;
	}



  };

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    try{
        initAngle = NavX.getNavx().getYaw();
    } catch (NullPointerException npe){
        initAngle = 0;
        npe.printStackTrace();
    }
    try {
        gyroAngle = NavX.getNavx().getYaw();
    } catch(NullPointerException npe) {
        gyroAngle = 0;
    }

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    try {
        gyroAngle = NavX.getNavx().getYaw();
    } catch(NullPointerException npe) {
        gyroAngle = 0;
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return angleChanged() >= angle;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }

  private double angleChanged() {
    int direction = (angle >= 0 ? 1 : -1);
    return (direction * (gyroAngle - initAngle) > 0 ? 360 : 0) + direction * (initAngle - gyroAngle);
  }

}
