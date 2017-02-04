package robot.oi;


public class GameController_Xbox360 extends GameController {

	public GameController_Xbox360(int port) {
		super(port);
	}
	
	public double getAxisLeftY() 			{return - joystick.getRawAxis(1);}
	public double getAxisLeftX() 			{return - joystick.getRawAxis(0);}
	public double getAxisRightY()			{return - joystick.getRawAxis(5);}
	public double getAxisRightX()			{return - joystick.getRawAxis(4);}
	
	public double getAxisLeftTrigger() 		{return joystick.getRawAxis(2);}
	public double getAxisRightTrigger() 	{return joystick.getRawAxis(3);}
	
	public boolean getButtonA()			 	{return joystick.getRawButton(1);}
	public boolean getButtonB()			 	{return joystick.getRawButton(2);}
	public boolean getButtonX()			 	{return joystick.getRawButton(3);}
	public boolean getButtonY()			 	{return joystick.getRawButton(4);}
	public boolean getButtonRightBumper()	{return joystick.getRawButton(5);}
	public boolean getButtonLeftBumper() 	{return joystick.getRawButton(6);}
	public boolean getButtonBack()		 	{return joystick.getRawButton(7);}
	public boolean getButtonStart()		 	{return joystick.getRawButton(8);}
	public boolean getButtonThumbRight() 	{return joystick.getRawButton(9);}
	public boolean getButtonThumbLeft()	 	{return joystick.getRawButton(10);} 
	
	
}
