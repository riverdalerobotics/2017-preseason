package robot.oi;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	GameController driver_Stick = new GameController_Xbox360(0);
	
	public double getSpeedInput(){
		return  driver_Stick.getLeftYAxis(); // this is mapped on driver station
	}
    
}

