
package robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import robot.Robot;

/**
 *
 */
public class JoystickCommand extends Command {

    public JoystickCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.chassisSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double speed = Robot.oi.getSpeedInput();
    	Robot.chassisSubsystem.setMotorSpeeds(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

	@Override
	protected void end() {}
	
	@Override
	protected void interrupted() {}
}
