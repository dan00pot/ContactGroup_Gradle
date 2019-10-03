package scripts.ContactGroup;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.winium.WiniumDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.windows.WindowsDriver;
import libs.clients.AndroidClientKeywords;
import libs.clients.WindowsClientKeywords;
import libs.common.DriverManagement;
import libs.common.Selenium;
import testData.aadsData;



/**
 * @author Administrator
 * Verify that can make call to group from client
 * 
 * *Procedure:
 * 1- Login to Equinox client
 * 2- Navigate to contact list
 * 3- Make audio call to group via click on phone button on group bar
 * 
 * *Expected result:
 * Call can be made and all contacts in group can receive call 
 *
 */

public class CONGRP_013 {
	
	static WiniumDriver winDriver;
	static WindowsDriver<?> windowsDriver;
	static WindowsDriver<?> windowsDriverRoot;
	static AndroidDriver<?> androidClientDriver;
	AndroidClientKeywords androidClient = new AndroidClientKeywords();
	WindowsClientKeywords winClient = new WindowsClientKeywords();
	Selenium selenium = new Selenium();
	DriverManagement driverMgnt = new DriverManagement();
	aadsData aadsData = new aadsData();

	final static Logger logger = LogManager.getLogger("VerifyAudioCallToGroup");

	@Before
	public void setUp() throws Exception {
		logger.info("beforeTest_VerifyAudioCallToGroup starting...\n");
		androidClientDriver = driverMgnt.createAndroidClientDriver();
		winDriver = driverMgnt.createWindowsClientDriver("http://10.255.251.19:9999");
		windowsDriverRoot = driverMgnt.createWinAppDriver("http://10.255.251.19:4725");
		winClient.confirmOpenApp(windowsDriverRoot);
		logger.info("beforeTest_VerifyAudioCallToGroup  completed...\n");
	}

	@Test
	public void test() {
		String groupName = "Contact_Group_Giang";
		try {
			androidClient.makeAudioCallToGroup(androidClientDriver, groupName);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	@After
	public void tearDown() throws Exception {
		logger.info("tearDown starting...\n");
		logger.info("tearDown completed...\n");
	}


}
