package org.usfirst.frc.team649.robot.commands;

import org.usfirst.frc.team649.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveForTime extends Command {
	
	Timer timer;
	double time;
	boolean isFinished;
	double power;
	
    public DriveForTime(double time, double power) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.time = time;
    	timer = new Timer();
    	isFinished = false;
    	this.power = power;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drive.straightDrive(power);
    	isFinished = false;
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(timer.get() >= time) {
    		isFinished = true;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	SmartDashboard.putBoolean("DriveForTime end?", true);
    	Robot.drive.straightDrive(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
