/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1732.robot;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.usfirst.frc.team1732.robot.autotools.DriverStationData;
import org.usfirst.frc.team1732.robot.config.RobotConfig;
import org.xml.sax.SAXException;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {

	// so that we can use instance variables
	private static Robot instance;
	public RobotConfig robotConfig;

	// avoid using this method, put everything that doesn't HAVE to be here in
	// robotInit()
	public Robot() throws SAXException, IOException, ParserConfigurationException {
		super();
		instance = this;
		setPeriod(0.01); // periodic methods will loop every 10 ms (1/100 sec)
	}

	public Robot getInstance() {
		return instance;
	}

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	@Override
	public void robotInit() {
		try {
			robotConfig = new RobotConfig();
		} catch (SAXException | IOException | ParserConfigurationException e) {
			System.err.println("Error reading the XML Config. Check the syntax and the path");
			e.printStackTrace();
		}
	}

	@Override
	public void robotPeriodic() {

	}

	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		DriverStationData.pollPlatePosition();
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {

	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {

	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void testInit() {

	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {

	}
}
