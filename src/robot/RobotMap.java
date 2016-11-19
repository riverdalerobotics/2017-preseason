package robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    
	 // PWM
	 final public static int LEFT_MOTOR= 0;
     final public static int RIGHT_MOTOR = 1;
    
     //Analog Input Ports
     final public static int GYRO = 0;
     
     
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
     
     //Digital IO Ports
     final public static int LEFT_ENCODER_B = 1;
     final public static int LEFT_ENCODER_A = 0;
     final public static int RIGHT_ENCODER_B = 2;
     final public static int RIGHT_ENCODER_A = 3;
     
     //Robot Properties
     public static final double MAX_DRIVE_SPEED = 1800;
     public static final double DRIVE_ENCODER_COUNTS_PER_FT = 300.0;

     public static final double DRIVE_PID_PROPORTIONAL_GAIN = 2.0;
     public static final double OVERSHOOT_ON_MOTOR_OFF = 200.0;
     
}
