package scripts.ContactGroup;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.appium.java_client.android.AndroidDriver;
import libs.clients.AndroidClientKeywords;
import libs.common.DriverManagement;
import libs.common.Selenium;
import testData.aadsData;


/**
 * @author Administrator
 * Verify that can make video call to group
 * 
 * *Procedure:
 * 1- Login to Equinox client
 * 2- Navigate to contact list
 * 3- Make video call to group via click on camera button on group bar
 * 
 * Expected result:
 * Call can be made and all contacts in group can receive call 
 *
 */

public class CONGRP_014 {
	
	static AndroidDriver<?> androidClientDriver;
	AndroidClientKeywords androidClient = new AndroidClientKeywords();
	Selenium selenium = new Selenium();
	DriverManagement driverMgnt = new DriverManagement();
	aadsData aadsData = new aadsData();

	final static Logger logger = LogManager.getLogger("VerifyVideoCallToGroup");

	@Before
	public void setUp() throws Exception {
		logger.info("beforeTest_VerifyVideoCallToGroup starting...\n");
		androidClientDriver = driverMgnt.createAndroidClientDriver();
		logger.info("beforeTest_VerifyVideoCallToGroup  completed...\n");
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
