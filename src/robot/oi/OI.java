package robot.oi;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	GameController driver_Stick = new GameController_Xbox360(0);

	public double getSpeed() {
		return driver_Stick.getAxisRightY(); // this is mapped on driver station
	}

	public double getTurn() {
		return driver_Stick.getAxisLeftX(); // for the forward and back
	}

	public void updateSmartDashboard() {
		SmartDashboard.putString("Driver Controller", driver_Stick.toString());
	}

	public boolean getStartDriveStraightCommand() {return driver_Stick.getButtonY();}

	public boolean isJoystickMovement(){
		
		return
					Math.abs(driver_Stick.getAxisLeftX()) >= 0.03
				|| 	Math.abs(driver_Stick.getAxisLeftY()) >= 0.03
				|| 	Math.abs(driver_Stick.getAxisRightX()) >= 0.03
				|| 	Math.abs(driver_Stick.getAxisRightY()) >= 0.03;
		
	}
}
