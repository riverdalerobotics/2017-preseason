package util;

import edu.wpi.first.wpilibj.AnalogInput;

public class UltrasonicSensor extends AnalogInput{

	LowPassFilter lowpassfilter = new LowPassFilter(10, 0.02, 10);
	
	public UltrasonicSensor(int port) {
		super(port);
	}
	
	public double getRawDistance(){
		double m = 0.0;
		double b = 0.0;
		return m * super.getVoltage() + b;
	}
	
	public void reset(){
		lowpassfilter.reset(getRawDistance());
	}
	
	public double getVoltage(){
		return super.getVoltage();
	}
	
	public void getDistance(){
		lowpassfilter.calculate(getRawDistance());
	}
}
