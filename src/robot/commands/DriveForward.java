package robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import robot.Robot;
import robot.RobotMap;

public class DriveForward extends Command {

	private double distance;
	private int time;
	private double speed;
	
    public DriveForward(double distance, int time, double speed) {
    	this.distance = Math.abs(distance * RobotMap.ENCODER_COUNTS_PER_FT);
    	this.time = time;
    	this.speed = speed;
    	requires(Robot.chassisSubsystem);
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.chassisSubsystem.encoderReset();
    	Robot.chassisSubsystem.isDriveCommandRunning = true;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.chassisSubsystem.setMotorSpeed(speed, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(timeSinceInitialized() >= time || Math.abs(Robot.chassisSubsystem.getDistance()) >= distance){
    		return true;
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassisSubsystem.setMotorSpeed(0, 0);
    	Robot.chassisSubsystem.isDriveCommandRunning = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
    public void updateSmartDashboard(){
    	SmartDashboard.putString("Running?", "running!");
    }
}
