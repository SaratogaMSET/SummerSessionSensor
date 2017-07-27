
package org.usfirst.frc.team649.robot;

// ***** This is where we add import statements which allow 
// ***** us to use different parts of the WPI libraries
import edu.wpi.first.wpilibj.DigitalInput; //
import edu.wpi.first.wpilibj.AnalogPotentiometer; //
import edu.wpi.first.wpilibj.AnalogInput; //
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team649.robot.commands.DriveForTime;
import org.usfirst.frc.team649.robot.commands.DriveCommand;
import org.usfirst.frc.team649.robot.subsystems.DrivetrainSubsystem;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	// ***** This is where we declare different objects such 
	// ***** as drivetrains, sensors, OI, etc.  
	public static DrivetrainSubsystem drive;
	public static OI oi;
	DigitalInput limitSwitch; //
	AnalogPotentiometer pot; //
	AnalogInput ai; //

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		// ***** This is where we initialize the different 
		// ***** parts of the robot which we declared earlier
		oi = new OI();
		drive = new DrivetrainSubsystem();
		limitSwitch = new DigitalInput(2); //
		ai = new AnalogInput(1); //
		pot = new AnalogPotentiometer(ai, 2, -1); //
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
		// ***** Modify for sensor use
		double driveValLim = 0;//
		if(!limitSwitch.get())//
			driveValLim = 1;//
		double driveValAn = pot.get(); //
		new DriveCommand(driveValAn).start();	// For more information about this command, see DriveCommand.java
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
