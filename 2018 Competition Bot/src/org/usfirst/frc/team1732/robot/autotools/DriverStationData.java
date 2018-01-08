package org.usfirst.frc.team1732.robot.autotools;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;

public class DriverStationData {

	private static String platePosition = "";

	public static void pollPlatePosition() {
		platePosition = DriverStation.getInstance().getGameSpecificMessage();
	}

	public static boolean isCloseSwitchPlateLeft() {
		return platePosition.charAt(0) == 'L';
	}

	public static boolean isScalePlateLeft() {
		return platePosition.charAt(0) == 'L';
	}

	public static boolean isFarSwitchPlateLeft() {
		return platePosition.charAt(0) == 'L';
	}

	public static boolean isRedAlliance() {
		return DriverStation.getInstance().getAlliance().equals(Alliance.Red);
	}
}
