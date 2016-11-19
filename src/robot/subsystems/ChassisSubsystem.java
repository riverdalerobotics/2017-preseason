
package robot.subsystems;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import robot.RobotMap;
import robot.commands.JoystickCommand;

public class ChassisSubsystem extends Subsystem {
	// Hardware declarations
	// Motors
	private Victor leftMotor = new Victor(RobotMap.LEFT_MOTOR);
	private Victor rightMotor = new Victor(RobotMap.RIGHT_MOTOR);

	// Encoders
	private Encoder leftEncoder = new Encoder(RobotMap.LEFT_ENCODER_A, RobotMap.LEFT_ENCODER_B);
	private Encoder rightEncoder = new Encoder(RobotMap.RIGHT_ENCODER_A, RobotMap.RIGHT_ENCODER_B, true);
	// At the end, the true is for inverting the encoder

	
	//Gyro
	private Gyro gyro = new AnalogGyro(RobotMap.GYRO);
	
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new JoystickCommand());

	}

	public void setBothMotorSpeeds(double speed) {
		leftMotor.set(calcPIDValue(speed, leftEncoder.getRate()));
		rightMotor.set(calcPIDValue(-speed, rightEncoder.getRate()));
	}

	// Master MotorSpeed command that contains all the logic in one command and
	// improves consistency
	public void setMotorSpeeds(double forwardSpeed, double turnSpeed) {

		if (Math.abs(forwardSpeed) <= 0.1) {
			// We know that the user didn't intend to go forward, Can be changed
			// if you want to go slower

			leftMotor.set(calcPIDValue(turnSpeed, leftEncoder.getRate())); 	// Turns on a pivot
			rightMotor.set(calcPIDValue(-turnSpeed, rightEncoder.getRate())); // Turns on a pivot
		}

	}

	public void robotInit() {

		rightMotor.setInverted(true);
		rightEncoder.setReverseDirection(true);

	}

	public void updateSmartDashboard() {

		SmartDashboard.putData("Right Encoder", rightEncoder);
		SmartDashboard.putData("Left Encoder", leftEncoder);
		SmartDashboard.putNumber("Gyro", gyro.getAngle());

	}

	public double calcPIDValue(double setPoint, double feedback) {

		double normalizedFeedback = feedback/RobotMap.MAX_DRIVE_SPEED;
		if 	(normalizedFeedback > 1.0)	{normalizedFeedback = 1.0;} 
		if	(normalizedFeedback < -1.0)	{normalizedFeedback = -1.0;}
		
		double error = setPoint - normalizedFeedback;
		
		double output = setPoint + error * RobotMap.DRIVE_PID_PROPORTIONAL_GAIN;

		double normalizedOutput = output;
		if	(normalizedOutput > 1.0)	{normalizedOutput = 1.0;} 
		if	(normalizedOutput < -1.0)	{normalizedOutput = -1.0;}
		
		return output;
	}

	public void resetEncoders(){		
		leftEncoder.reset();
		rightEncoder.reset();		
	}
	
	public double getEncoderAverageDistance(){
		return (leftEncoder.getDistance() + rightEncoder.getDistance()) / 2;
	}
}
