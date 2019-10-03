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
 * Verify removing contacts 
 * 
 * Procedure:
 * 1- Access to Equinox client
 * 2- Navigate to contact tab
 * 3- Open group
 * 4- Open contact detail
 * 5- Click x button to remove contact from group
 * 
 * Expected result:
 * Contact is removed from group list but still exist in contact list of client
 *
 */

public class CONGRP_009 {

	static AndroidDriver<?> androidClientDriver;
	AndroidClientKeywords androidClient = new AndroidClientKeywords();
	Selenium selenium = new Selenium();
	DriverManagement driverMgnt = new DriverManagement();
	aadsData aadsData = new aadsData();

	final static Logger logger = LogManager.getLogger("VerifyRemovingContacts");
	
	@Before
	public void setUp() throws Exception {
		logger.info("beforeTest_VerifyRemovingContacts starting...\n");
		androidClientDriver = driverMgnt.createAndroidClientDriver();
		logger.info("beforeTest_VerifyRemovingContacts  completed...\n");
	}

	@Test
	public void test() {
		String groupName = "Contact_Group_Giang"; 
		String ContactName = "Franklyn Rush";
		try {
			androidClient.removingContactOfContactGroup(androidClientDriver, groupName, ContactName);
			androidClient.verifyContactNameIsExistedContactGroup(androidClientDriver, groupName, ContactName);
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
