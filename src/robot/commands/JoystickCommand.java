
package robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import robot.Robot;

/**
 *
 */

// TODO: Create max speed Constant

public class JoystickCommand extends Command {

	public JoystickCommand() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.chassisSubsystem);
		requires(Robot.shooterSubsystem);
	}

	// Called just before this Command runs the first time

	protected void initialize() {
		//Scheduler.getInstance().add(new DriveForward(3, 30, 0.5));
	}

	// Called repeatedly when this Command is scheduled to run
	double ultra = 0;
	boolean isDriveButtonReleased = false;

	protected void execute() {

		double speed = Robot.oi.getSpeedInput();
		double turn = -Robot.oi.getTurnInput();

		boolean driveForward = Robot.oi.isDriveButtonPressed();
		boolean intakeIn = Robot.oi.getIntakeIn();
		boolean intakeOut = Robot.oi.getIntakeOut();
		boolean shootHighOn = Robot.oi.getOutakeOn();
		boolean shootHighOff = Robot.oi.getOutakeOff();
		boolean outtake = Robot.oi.getOutakeOnlyOn();
		boolean turnRight = Robot.oi.isTurnRight();
		boolean turnLeft = Robot.oi.isTurnLeft();
//		boolean driveForwardCommand = Robot.oi.getDriveForwardCommand();
		
		
		Robot.chassisSubsystem.setMotorSpeed(speed, turn);

		// Both intake motors out
		if (intakeOut) {

			Robot.shooterSubsystem.setIntakeSpeed(-1);
			Robot.shooterSubsystem.setOuttakeSpeed(1);

		}
		// Only bottom intake motors in
		else if (intakeIn) {

			Robot.shooterSubsystem.setIntakeSpeed(1);

		}
		// Turn the bottom intake motor in
		else if (outtake) {

			Robot.shooterSubsystem.setOuttakeSpeed(-1);

		}
		// Turn the shoot high on
		else if (shootHighOn) {

			Robot.shooterSubsystem.shootHigh(-1);

		}
		// Turn the shoot high off
		else if (shootHighOff) {

			Robot.shooterSubsystem.shootHigh(0);

		}
		//Turns the intake motors off
		else {

			Robot.shooterSubsystem.setIntakeSpeed(0);
			Robot.shooterSubsystem.setOuttakeSpeed(0);
			
		}
		
		if(driveForward){
			Scheduler.getInstance().add(new DriveForward(3.0, 10, 0.5));
		}
		
		if(turnRight) {
			//Scheduler.getInstance().add(new TurnToAngleCommand(30));
		}
		
		if(turnLeft) {
			//Scheduler.getInstance().add(new TurnToAngleCommand(-30));
		}
		
//		if(isDriveButtonReleased){
//		}else{
//			isDriveButtonReleased = !Robot.oi.isDriveButtonPressed();
//		}

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}
}
