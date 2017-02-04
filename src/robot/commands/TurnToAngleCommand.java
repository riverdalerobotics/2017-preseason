/*package robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import robot.Robot;
import util.Gyro;

/**
 *

public class TurnToAngleCommand extends Command {

	double desiredAngle;
	Gyro gyro;
    double currentAngle;
    
    public TurnToAngleCommand(double desiredAngle) {
        this.desiredAngle = desiredAngle;
        requires(Robot.chassisSubsystem);
    }

    
    // Called just before this Command runs the first time
    protected void initialize() {
    	gyro = Robot.chassisSubsystem.gyro;
    	Robot.chassisSubsystem.setMotorSpeed(0, 0);
    	gyro.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	currentAngle = gyro.normalizedAngle(gyro.getAngle());
    	double error = desiredAngle - currentAngle;
    	    	
    	gyro.turningToAngle(error);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(gyro.getRawAngle() == desiredAngle){
    		return true;
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
*/