package robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	Joystick driver_Stick = new Joystick(0);
	
	public double getSpeedInput(){
		return - driver_Stick.getRawAxis(0); // this is mapped on driver station
	}
    
}

