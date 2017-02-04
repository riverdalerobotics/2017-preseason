package robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import robot.RobotMap;

public class ShooterSubsystem extends Subsystem {

	//Bottom intake and outtake
	private Victor intake_motor = new Victor(RobotMap.INTAKE_MOTOR);
	
	//Top intake and outtake
	private Victor outtake_motor = new Victor(RobotMap.OUTTAKE_MOTOR);
	
	//High goal motor
	private Victor shoot_motor = new Victor(RobotMap.SHOOT_MOTOR);
	
    public void initDefaultCommand() {
//        setDefaultCommand(new JoystickCommand());
    }
    
    
	public void setIntakeSpeed(double speed){
		intake_motor.set(speed);
	}
	
	public void setOuttakeSpeed(double speed){
		outtake_motor.set(speed);
	}
	
	public void shootHigh(double speed){
		shoot_motor.set(-speed);
	}
	
	public void callSmartDashboard(){
		SmartDashboard.putBoolean("intake motor", intake_motor.get() > 0);
		SmartDashboard.putBoolean("outtake motor (top)", outtake_motor.get() > 0);
		SmartDashboard.putBoolean("shoot motor", shoot_motor.get() > 0);
	}
}

