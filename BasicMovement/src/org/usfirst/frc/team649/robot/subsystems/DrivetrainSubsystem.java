package org.usfirst.frc.team649.robot.subsystems;

import org.usfirst.frc.team649.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DrivetrainSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Victor[] motors;
	public final static double speedLimit = 0.4;
	
    public DrivetrainSubsystem() {
    	motors = new Victor[4];
    	for (int i = 0; i < RobotMap.Drivetrain.MOTOR_PORTS.length; i++) {
    		motors[i] = new Victor(RobotMap.Drivetrain.MOTOR_PORTS[i]);
    	}
    }
    
    
    public void straightDrive(double power) {
    	power = power * speedLimit;
    	motors[0].set(power);
    	motors[1].set(power);
    	motors[2].set(-power);	// Negative because this motor runs in opposite direction
    	motors[3].set(-power);	// Negative because this motor runs in opposite direction
    }
    
    // ************************************** Write Tank Drive here! Remember to limit the speed
    
    
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

