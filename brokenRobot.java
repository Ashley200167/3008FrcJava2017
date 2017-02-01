
/**
 * This is a demo program showing how to use Mecanum control with the RobotDrive
 * class.
 */
public class Robot extends SampleRobot {
	private static final AxisType Y = null;

	private static final AxisType Z = null;

	private static final AxisType X = null;

	RobotDrive robotDrive;

	// Channels for the wheels
	final int kFrontLeftChannel = 9;
	final int kRearLeftChannel = 8;
	final int kFrontRightChannel = 7;
	final int kRearRightChannel = 6;
	

	// The channel on the driver station that the joystick is connected to


	
	//public static JoystickBase logitechAttack3D (int port) {
		//Joystick joystick = new Joystick(1);
		//Joystick leftStick = new Joystick(0); // set to ID 1 in DriverStation
		//Joystick rightStick = new Joystick(1); // set to ID 2 in DriverStation

	    //return ((Object) joystick).create(joystick::getRawAxis,
	    //                          joystick::getRawButton,
	    //                          joystick::getPOV,
	    //                          joystick::getY, // pitch
	    //                          () -> joystick.getTwist() * -1, // yaw is reversed
	    //                          joystick::getX); // roll
	    //                          joystick.getThrottle)  // throttle
	    //                          () -> joystick.getRawButton(1),} 
	    //                           
	
	public Robot() {
		robotDrive = new RobotDrive(kFrontLeftChannel, kRearLeftChannel, kFrontRightChannel, kRearRightChannel);
		robotDrive.setInvertedMotor(MotorType.kFrontLeft, false); // invert the
																	// left side
																	// motors
		robotDrive.setInvertedMotor(MotorType.kRearLeft, false); // you may need
																// to change or
																// remove this
																// to match your
																// robot
		robotDrive.setExpiration(0.1);
	}

	/**
	 * Runs the motors with Mecanum drive.
	 */
	@Override
	public void operatorControl() {
		robotDrive.setSafetyEnabled(true);
		
		Joystick stick0 = new Joystick(0);
		Joystick stick1 = new Joystick(1);
		Joystick stick2 = new Joystick (2);
		
		double speed0X = stick0.getAxis(X);
		double speed0Y = stick0.getAxis(Y);
		double speed0Z = stick0.getAxis(Z);
		/*
		double speed1X = stick1.getAxis(X);
		double speed1Y = stick1.getAxis(Y);
		double speed1Z = stick1.getAxis(Z);
		
		double speed2X = stick2.getAxis(X);
		double speed2Y = stick2.getAxis(Y);
		double speed2Z = stick2.getAxis(Z);
		*/
		while (isOperatorControl() && isEnabled()) {

			// Use the joystick X axis for lateral movement, Y axis for forward
			// movement, and Z axis for rotation.
			// This sample does not use field-oriented drive, so the gyro input
			// is set to zero.
	
			robotDrive.mecanumDrive_Polar(speed0X, speed0Y, speed0Z);
		}
	}


	private JoystickBase Joystick(int i) {
		// TODO Auto-generated method stub
		return null;
	}


	private int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}


	private int getX() {
		// TODO Auto-generated method stub
		return 0;
	}


	private int getY() {
		// TODO Auto-generated method stub
		return 0;
	}
}
