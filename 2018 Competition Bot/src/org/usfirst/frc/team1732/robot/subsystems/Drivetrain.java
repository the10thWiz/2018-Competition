package org.usfirst.frc.team1732.robot.subsystems;

import org.usfirst.frc.team1732.robot.config.RobotConfig;
import org.usfirst.frc.team1732.robot.drivercontrol.DifferentialDrive;
import org.w3c.dom.Element;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem {

	public DifferentialDrive drive;

	private TalonSRX leftTalon1;
	private TalonSRX rightTalon1;

	private static final int CONFIG_TIMEOUT = 10; // recommended timeout by CTRE
	private static final double DRIVE_DEADBAND = 0.04; // CTRE default, but also need to pass to DifferentialDrive

	public Drivetrain(Element driveTrain) {
		leftTalon1 = configureTalon(RobotConfig.getElement(driveTrain, "leftTalon1"));
		configureTalon(RobotConfig.getElement(driveTrain, "leftTalon2"));
		configureTalon(RobotConfig.getElement(driveTrain, "leftTalon3"));
		rightTalon1 = configureTalon(RobotConfig.getElement(driveTrain, "RightTalon1"));
		configureTalon(RobotConfig.getElement(driveTrain, "RightTalon2"));
		configureTalon(RobotConfig.getElement(driveTrain, "RightTalon3"));
		drive = new DifferentialDrive(leftTalon1, rightTalon1);
		drive.setDeadband(DRIVE_DEADBAND); // might not need these: talon's have their own "neutral zone"
	}

	private TalonSRX configureTalon(Element talonElement) {
		int CANid = RobotConfig.getInteger(talonElement, "CANid");
		TalonSRX talon = new TalonSRX(CANid);
		talon.setNeutralMode(NeutralMode.Coast);
		talon.setInverted(RobotConfig.getBoolean(talonElement, "isInverted"));
		// we need to figure out exactly what the follower motors will "follow" (do we
		// need to configure current limit for followers too, or just master?

		boolean isFollower = RobotConfig.getBoolean(talonElement, "isFollower");
		if (isFollower) {
			talon.set(ControlMode.Follower, RobotConfig.getInteger(talonElement, "masterCANid"));
		} else {
			// I have methods commented out here that we might want to use, but am waiting
			// for more documentation

			talon.configNeutralDeadband(DRIVE_DEADBAND, CONFIG_TIMEOUT);
			talon.configNominalOutputForward(+0, CONFIG_TIMEOUT);
			talon.configNominalOutputReverse(-0, CONFIG_TIMEOUT);
			talon.configPeakOutputForward(+1.0, CONFIG_TIMEOUT);
			talon.configPeakOutputReverse(-1.0, CONFIG_TIMEOUT);

			// talon.configOpenloopRamp(secondsFromNeutralToFull, configTimeoutMS);
			// talon.enableVoltageCompensation(false);

			// talon.enableCurrentLimit(false);
			// talon.configContinuousCurrentLimit(amps, configTimeoutMS);
			// talon.configPeakCurrentDuration(milliseconds, configTimeoutMS);
			// talon.configPeakCurrentLimit(amps, configTimeoutMS)

			/*
			 * can set very specific frame periods (how frequently CAN data is sent)
			 * 
			 * talon.setControlFramePeriod(ControlFrame.Control_3_General, 20);
			 * talon.setStatusFramePeriod(StatusFrame.Status_1_General, periodMs,
			 * configTimeoutMS)
			 * talon.setStatusFramePeriod(StatusFrameEnhanced.Status_1_General, periodMs,
			 * configTimeoutMS)
			 */

		}
		return talon;
	}

	@Override
	public void initDefaultCommand() {

	}

	@Override
	public void periodic() {

	}
}