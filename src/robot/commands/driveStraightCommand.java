package robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import robot.Robot;
import robot.RobotMap;

/**
 *
 */
public class driveStraightCommand extends Command {

	private double encoderDistance;
	private double speed;
    private double timeout;
	
	//Input distance in feet and a negative speed input for backwards direction
	public driveStraightCommand(double distance, double speed, double timeout) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		requires(Robot.chassisSubsystem);
    	this.encoderDistance	= Math.abs(distance * RobotMap.DRIVE_ENCODER_COUNTS_PER_FT) - RobotMap.OVERSHOOT_ON_MOTOR_OFF;
    	this.speed				 = speed;
    	this.timeout = timeout;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    
    Robot.chassisSubsystem.resetEncoders();	
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.chassisSubsystem.setBothMotorSpeeds(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
    	//Check for distance BUT check for timeout first OR if there is joystick movement
    	
    	if(Robot.oi.isJoystickMovement()) { return true; }
    	
    	if (timeSinceInitialized() > timeout) {return true;};
    	return Robot.chassisSubsystem.getEncoderAverageDistance() > encoderDistance;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassisSubsystem.setBothMotorSpeeds(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
