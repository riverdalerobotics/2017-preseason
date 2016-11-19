
package robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import robot.Robot;

/**
 *
 */
public class JoystickCommand extends Command {

	private boolean wasStartDriveStraightButtonReleased = false;
	
    public JoystickCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.chassisSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if (wasStartDriveStraightButtonReleased){
    	
    		if(Robot.oi.getStartDriveStraightCommand()){
    			
    			Scheduler.getInstance().add(new driveStraightCommand(3.0, 0.5, 5));
    			wasStartDriveStraightButtonReleased = false;
    		}
    	}else {
    		
    		wasStartDriveStraightButtonReleased = ! Robot.oi.getStartDriveStraightCommand();
    		
    	}
    	double speed = Robot.oi.getSpeed();
    	double turn = Robot.oi.getTurn();
    	
    	if (Math.abs(speed) <= 0.1){
    	
    		Robot.chassisSubsystem.setMotorSpeeds(speed, turn);
    		
    	}
    	else {
    		Robot.chassisSubsystem.setBothMotorSpeeds(speed);
     	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }
    
	
	protected void end() {}
	
	
	protected void interrupted() {}
}
