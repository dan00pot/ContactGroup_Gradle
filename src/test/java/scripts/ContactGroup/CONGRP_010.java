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
 * Verify that allowing empty groups after removal of the last person
 * 
 * Procedure:
 * 1- Access to Equinox client
 * 2- Navigate to contact tab
 * 3- Remove all contacts of group
 * 
 * Expected result:
 * Group still exist after remove all contacts (empty group)
 *
 */

public class CONGRP_010 {
	
	static AndroidDriver<?> androidClientDriver;
	AndroidClientKeywords androidClient = new AndroidClientKeywords();
	Selenium selenium = new Selenium();
	DriverManagement driverMgnt = new DriverManagement();
	aadsData aadsData = new aadsData();

	final static Logger logger = LogManager.getLogger("VerifyEmptyContactGroup");

	@Before
	public void setUp() throws Exception {
		logger.info("beforeTest_VerifyEmptyContactGroup starting...\n");
		androidClientDriver = driverMgnt.createAndroidClientDriver();
		logger.info("beforeTest_VerifyEmptyContactGroup completed...\n");
	}

	@Test
	public void test() {
		String groupName = "Contact_Group_Giang";
		String ContactName = "duy 002";
		try {
//			androidClient.removeAllContactOfContactGroup(androidClientDriver, groupName);
			androidClient.verifyGroupExistAfterRemoveAllContact(androidClientDriver, groupName);

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
