package org.usfirst.frc.team649.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static final int OPERATOR_JOYSTICK = 0;
	public static final int DRIVE_JOYSTICK_HORIZONTAL = 2;
	public static final int DRIVE_JOYSTICK_VERTICAL = 1;
	
	public static class Drivetrain {
		// FR,BR,BL,BR
//		public static final int TEST_LIMIT_PORT = 0;
		public static final int[] LEFT_SIDE_ENCODER = {6,7};
		public static final int[] RIGHT_SIDE_ENCODER = {8,9};
		public static final int[] MOTOR_PORTS = { 9, 8, 7, 6 };
		public static final int SPIKE_PORT = 0;
		public static final int COMPRESS_LIMIT_CAN = 9;
		public static final int[] DRIVE_SOL = {4,5};
		public static final double MAX_SPEED = 1500.0;
		public static final double MAX_LOW_SPEED = 700.0;
		
	}
}
