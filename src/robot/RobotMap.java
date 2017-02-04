package robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	// Motors
	final public static int LEFT_MOTOR = 0;
	final public static int RIGHT_MOTOR = 3;

	final public static int INTAKE_MOTOR = 7;
	final public static int OUTTAKE_MOTOR = 2;
	final public static int SHOOT_MOTOR = 5;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	final public static int LEFT_ENCODER_B = 9;
	final public static int LEFT_ENCODER_A = 8;
	final public static int RIGHT_ENCODER_B = 1;
	final public static int RIGHT_ENCODER_A = 0;

	//analog
	final public static int ULTRASONIC_PORT = 3;
	// Properties
	final public static int DELAY = 50000;
	
	//constants
	final public static int MAX_ENCODER_COUNTS = 1800;
	final public static int ENCODER_COUNTS_PER_FT = 300;
}
