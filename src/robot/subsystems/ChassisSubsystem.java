
package robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import robot.commands.JoystickCommand;

public class ChassisSubsystem extends Subsystem {
	//Hardware declarations
	//Speed Controllers
	private Victor left_motor = new Victor(0);
	private Victor right_motor = new Victor(1);
	
	//Encoders
	private Encoder left_Encoder = new Encoder(0,1);
	private Encoder right_Encoder = new Encoder(2,3);
    
	// Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() { 
        // Set the default command for a subsystem here.
        setDefaultCommand(new JoystickCommand());
    	
    }
    
    public void setMotorSpeeds(double speed){
    	left_motor.set(speed);
    	right_motor.set(speed);
    }
}

