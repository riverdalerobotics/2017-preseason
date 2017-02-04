package robot.oi;

import edu.wpi.first.wpilibj.Joystick;

public abstract class GameController{

	private int port;
	protected Joystick joystick;
	
	public GameController(int port) {
		this.port = port;
		joystick = new Joystick(port);
		
	}
	
	public int getPort(){
		return this.port;
	}
	public Joystick getJoystick() {return joystick;}
	
	abstract public double getAxisLeftY(); 			
	abstract public double getAxisLeftX(); 			
	abstract public double getAxisRightY();			
	abstract public double getAxisRightX();			
	
	abstract public double getAxisLeftTrigger();
	abstract public double getAxisRightTrigger();
	
	abstract public boolean getButtonA();				
	abstract public boolean getButtonB();				
	abstract public boolean getButtonX();				
	abstract public boolean getButtonY();				
	abstract public boolean getButtonRightBumper();	
	abstract public boolean getButtonLeftBumper();	
	abstract public boolean getButtonBack();			
	abstract public boolean getButtonStart();			
	abstract public boolean getButtonThumbRight();	
	abstract public boolean getButtonThumbLeft();
//	abstract public boolean getPOV();
	
	public boolean anyButtonPressed(){
		return getButtonA() || getButtonB() || getButtonY() || getButtonX() ||
				getButtonRightBumper() || getButtonLeftBumper() || 
				getButtonThumbLeft() || getButtonThumbRight() ||
				getButtonStart() || getButtonBack();
	}
	
	//TODO: Add to smartdahsboard: ToString()
	@Override
	public String toString () {
	
		StringBuilder sb = new StringBuilder();
		
		//Controller type
		sb.append("Controller Type: " + joystick.getType());
		
		sb.append(System.getProperty("line.separator"));
		
		//Axis
		sb.append("Left Axis: (" + getAxisLeftX() + ", " + getAxisLeftY() + ")");
		
		sb.append(System.getProperty("line.separator"));
		
		sb.append("Right Axis: (" + getAxisRightX() + ", " + getAxisRightY() + ") ");
		
		sb.append(System.getProperty("line.separator"));
		//Triggers
		sb.append("Triggers:  Left - " + getAxisLeftTrigger() + "  Right - " + getAxisRightTrigger());
		
		sb.append(System.getProperty("line.separator"));
		
		//Buttons
		if(anyButtonPressed()){
			sb.append("Buttons pressed: ");
			sb.append(getButtonA()				? 	"A "				:	"");
			sb.append(getButtonB()				? 	"B "				: 	"");
			sb.append(getButtonX()				? 	"X "				: 	"");
			sb.append(getButtonY()				? 	"Y "				: 	"");
			sb.append(getButtonBack()			? 	"Back "				: 	"");
			sb.append(getButtonStart()			? 	"Start "			: 	"");
			sb.append(getButtonLeftBumper()		? 	"LeftBumper "		: 	"");
			sb.append(getButtonRightBumper()	? 	"RightBumper "		: 	"");
			sb.append(getButtonThumbLeft()		? 	"LeftThumb "		: 	"");
			sb.append(getButtonThumbRight()		? 	"RightThumb "		: 	"");
		}
		
		return sb.toString();
		
	}
	
}
