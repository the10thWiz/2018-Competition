package org.usfirst.frc.team1732.robot.config;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/*
 * More stuff to recieve/load a config from network tables would be added to this class, but for now it will be kind of emptys
 */
public class RobotConfig {

	private static final String savedConfigPath = "config/RobotConfig.xml";
	private static final String tableName = "XML Configs";
	private static final String configTableEntry = "Robot Config";

	public static Document getSavedRobotConfig() throws SAXException, IOException, ParserConfigurationException {
		return ConfigUtils.makeDOMdoc(new File(savedConfigPath));
	}

	/*
	 * Returns the first element within the document with that name
	 */
	public static Element getElement(Document doc, String elementName) {
		return (Element) doc.getElementsByTagName(elementName).item(0);
	}

	/*
	 * Returns the first element within the top element with that name
	 */
	public static Element getElement(Element top, String elementName) {
		return (Element) top.getElementsByTagName(elementName).item(0);
	}

	public static String getText(Element top, String elementName) {
		return getElement(top, elementName).getTextContent();
	}

	public static int getInteger(Element top, String elementName) {
		return Integer.parseInt(getText(top, elementName));
	}

	public static boolean getBoolean(Element top, String elementName) {
		return Boolean.parseBoolean(getText(top, elementName));
	}

	public static double getDouble(Element top, String elementName) {
		return Double.parseDouble(getText(top, elementName));
	}

}