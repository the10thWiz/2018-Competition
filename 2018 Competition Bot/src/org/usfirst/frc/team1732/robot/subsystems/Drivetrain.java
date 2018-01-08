package org.usfirst.frc.team1732.robot.subsystems;

import org.usfirst.frc.team1732.robot.config.RobotConfig;
import org.w3c.dom.Element;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drivetrain extends Subsystem {

	public DifferentialDrive drive = new DifferentialDrive(null, null);

	private TalonSRX leftTalonMaster;
	private TalonSRX leftTalon1;
	private TalonSRX leftTalon2;
	private TalonSRX rightTalonMaster;
	private TalonSRX rightTalon1;
	private TalonSRX rightTalon2;

	public Drivetrain(Element driveTrain) {
		leftTalonMaster = configureTalon(RobotConfig.getElement(driveTrain, "leftTalonMaster"));
		leftTalon1 = configureTalon(RobotConfig.getElement(driveTrain, "leftTalon1"));
		leftTalon2 = configureTalon(RobotConfig.getElement(driveTrain, "leftTalon2"));
		rightTalonMaster = configureTalon(RobotConfig.getElement(driveTrain, "leftTalonMaster"));
		rightTalon1 = configureTalon(RobotConfig.getElement(driveTrain, "leftTalon1"));
		rightTalon2 = configureTalon(RobotConfig.getElement(driveTrain, "leftTalon2"));

	}

	private TalonSRX configureTalon(Element talonElement) {
		int CANid = RobotConfig.getInteger(talonElement, "CANid");
		TalonSRX talon = new TalonSRX(CANid);
		boolean isFollower = RobotConfig.getBoolean(talonElement, "isFollower");
		if (isFollower) {

		} else {
			// I have methods here that we might want to use, but am waiting for more
			// documentation
			// talon.configContinuousCurrentLimit(amps, timeoutMs);
			// talon.configNeutralDeadband(percentDeadband, timeoutMs);
			// talon.configNominalOutputForward(percentOut, timeoutMs)
			// talon.config
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