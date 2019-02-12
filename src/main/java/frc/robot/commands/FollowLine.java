package frc.robot.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.LineFollower;

public class FollowLine extends Command {

    public FollowLine() {
        requires(Robot.driveTrain);
        requires(Robot.lineFollower);
    }

    @Override
    protected void initialize() {

        Robot.lineFollower.setSetpoint(0);
        Robot.lineFollower.setInputRange(-1.0, 1.0);
        Robot.lineFollower.setOutputRange(-0.2, 0.2);
        Robot.lineFollower.setAbsoluteTolerance(0.25);
        Robot.lineFollower.getPIDController().setContinuous(false);

        Robot.lineFollower.enable();
    }

    @Override
    protected void execute() {
    }

    /*
     * isFinished - Our isFinished method always returns false meaning this command
     * never completes on it's own. The reason we do this is that this command will
     * be set as the default command for the subsystem. This means that whenever the
     * subsystem is not running another command, it will run this command. If any
     * other command is scheduled it will interrupt this command, then return to
     * this command when the other command completes.
     */
    @Override
    protected boolean isFinished() {
        return Robot.lineFollower.isFinished();
    }

    @Override
    protected void end() {
        Robot.lineFollower.disable();
        super.end();
    }

    @Override
    protected void interrupted() {
        end();
    }
}
