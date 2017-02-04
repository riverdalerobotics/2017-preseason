package robot.oi;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	GameController driver_Stick = new GameController_Xbox360(0);

	public double getSpeedInput() {
		return driver_Stick.getAxisLeftY(); // this is mapped on driver station
	}

	public double getTurnInput() {
		return driver_Stick.getAxisRightX();
	}

	public boolean getLeftMotor() {
		return driver_Stick.getButtonB();
	}

	public boolean getOutakeOn() {
		return driver_Stick.getButtonB();
	}

	public boolean getIntakeIn() {
		return driver_Stick.getButtonRightBumper();
	}

	public boolean getIntakeOut() {
		return driver_Stick.getButtonLeftBumper();
	}

	public boolean getOutakeOnlyOn() {
		return driver_Stick.getButtonY();
	}

	public boolean getOutakeOff() {
		return driver_Stick.getButtonX();
	}

	public boolean isDriveButtonPressed() {
		return driver_Stick.getButtonA();
	}

	public boolean isTurnRight() {		
		return driver_Stick.getButtonThumbRight();
	}

	public boolean isTurnLeft() {
		return driver_Stick.getButtonThumbLeft();
	}

	public void callSmartDashboard() {
		SmartDashboard.putString("Controller", driver_Stick.toString());
		SmartDashboard.putBoolean("Driver Button", isDriveButtonPressed());
	}

}
