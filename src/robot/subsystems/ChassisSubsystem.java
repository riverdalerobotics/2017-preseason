
package robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import robot.RobotMap;
import robot.commands.JoystickCommand;

public class ChassisSubsystem extends Subsystem {
	//Hardware declarations
	//Speed Controllers
	private Victor left_motor = new Victor(RobotMap.LEFT_MOTOR);
	private Victor right_motor = new Victor(RobotMap.RIGHT_MOTOR);
	
	//Encoders
	private Encoder left_Encoder = new Encoder(RobotMap.LEFT_ENCODER_A,RobotMap.LEFT_ENCODER_B);
	private Encoder right_Encoder = new Encoder(RobotMap.RIGHT_ENCODER_A,RobotMap.RIGHT_ENCODER_B);
    
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

