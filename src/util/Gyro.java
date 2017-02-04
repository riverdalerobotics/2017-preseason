package util;

import edu.wpi.first.wpilibj.AnalogInput;

public class Gyro extends AnalogInput{

	public Gyro(int port) {
		super(port);
	}

//	public double getRawAngle(){
//		return super.getAngle() % 360;
//	}
	
//	public double normalizedAngle(double rawAngle){		
//		if(rawAngle > 180){
//			return -rawAngle % 180;
//		}else{
//			return rawAngle;
//		}
//	}


//	public void turningToAngle(double angle){
//		Robot.chassisSubsystem.setMotorSpeed(0, angle/180);	
//	}
}
