package org.usfirst.frc.team1732.robot.subsystems;

import org.w3c.dom.Document;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drivetrain extends Subsystem {

	public DifferentialDrive d = new DifferentialDrive(null, null);

	public Drivetrain(Document config) {

	}

	@Override
	public void initDefaultCommand() {

	}

	@Override
	public void periodic() {

	}
}
