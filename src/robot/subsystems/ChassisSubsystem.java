
package robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import robot.RobotMap;
import robot.commands.JoystickCommand;
import util.Gyro;
import util.UltrasonicSensor;

public class ChassisSubsystem extends Subsystem {
	// Hardware declarations
	// Speed Controllers
	private Victor left_motor = new Victor(RobotMap.LEFT_MOTOR);
	private Victor right_motor = new Victor(RobotMap.RIGHT_MOTOR);

	// Encoders
	private Encoder left_Encoder = new Encoder(RobotMap.LEFT_ENCODER_A, RobotMap.LEFT_ENCODER_B);
	private Encoder right_Encoder = new Encoder(RobotMap.RIGHT_ENCODER_A, RobotMap.RIGHT_ENCODER_B);
	
	public UltrasonicSensor ultrasonicSensor = new UltrasonicSensor(RobotMap.ULTRASONIC_PORT);
	
	public Gyro gyro = new Gyro(2);
	
	public boolean isDriveCommandRunning = false;

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		left_motor.setInverted(true);
		setDefaultCommand(new JoystickCommand());
	}

	public double encoderAverage() {

		return (left_Encoder.get() + right_Encoder.get()) / 2;

	}

	public double getDistance(){
		return right_Encoder.getDistance();
	}
	
	public void encoderReset(){
		left_Encoder.reset();
		right_Encoder.reset();
	}
	
	public void setMotorSpeed(double speed, double turn) {

		if (turn < 0.3 && turn > -0.3) {

			left_motor.set(PIDController(speed, right_Encoder.getRate()));
			right_motor.set(PIDController(speed, right_Encoder.getRate()));

		} else {

			double leftSpeed = 0;
			double rightSpeed = 0;

			if (turn < -0.1) {

				leftSpeed = turn;			
				rightSpeed = -turn;		

			} else {

				leftSpeed = turn;			
				rightSpeed = -turn;		

			}

			left_motor.set(PIDController(leftSpeed, right_Encoder.getRate()));
			right_motor.set(PIDController(rightSpeed, right_Encoder.getRate()));

		}

	}

	public double PIDController(double speed, double encoderRate){
		 double normalizedSpeed = encoderRate/RobotMap.MAX_ENCODER_COUNTS;
		 double kp = 0.3;
		 
		 if(normalizedSpeed > 1.0){ normalizedSpeed = 1.0; }
		 if(normalizedSpeed < -1.0){ normalizedSpeed = -1.0; }
		 
		 double output = speed + (normalizedSpeed - speed) * kp;
		 
		 if(output > 1.0){ output = 1.0; }
		 if(output < -1.0){ output = -1.0; }
		 
		 return output;
	}
	
	
	public void callSmartDashboard() {
		SmartDashboard.putData("Encoder - Left", left_Encoder);
		SmartDashboard.putData("Encoder - Right", right_Encoder);
		SmartDashboard.putNumber("Ultrasonic Calibrated Volt", ultrasonicSensor.getVoltage());
		SmartDashboard.putNumber("Ultrasonic Raw Value", ultrasonicSensor.getValue());
//		SmartDashboard.putBoolean("is drive command running", isDriveCommandRunning);
		SmartDashboard.putNumber("gyro voltage", gyro.getVoltage());
	}

}
