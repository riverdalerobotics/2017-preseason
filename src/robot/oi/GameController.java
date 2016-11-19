package robot.oi;

import edu.wpi.first.wpilibj.Joystick;

public class GameController {

	private int port;
	protected Joystick joystick;
	
	public GameController(int port) {
		this.port = port;
		joystick = new Joystick(port);
		
	}
	
	public Joystick getJoystick() {return joystick;}
	
	public double getAxisLeftY() 			{return 0.0;}
	public double getAxisLeftX() 			{return 0.0;}
	public double getAxisRightY()			{return 0.0;}
	public double getAxisRightX()			{return 0.0;}
	
	public boolean getButtonA()				{return false;}
	public boolean getButtonB()				{return false;}
	public boolean getButtonX()				{return false;}
	public boolean getButtonY()				{return false;}
	public boolean getButtonRightBumper()	{return false;}
	public boolean getButtonLeftBumper()	{return false;}
	public boolean getButtonBack()			{return false;}
	public boolean getButtonStart()			{return false;}
	public boolean getButtonThumbRight()	{return false;}
	public boolean getButtonThumbLeft()		{return false;}
	
	public int getPOV() {return-1;}
	
	public String toString(){
		
		return
				"(" + getAxisLeftX() + ", " + getAxisLeftY() + ") "
				+ 
				"(" + getAxisRightX() + ", " + getAxisRightY() + ")";}

}
