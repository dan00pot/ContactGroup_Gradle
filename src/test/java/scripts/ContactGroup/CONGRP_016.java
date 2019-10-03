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
 * Verify that contacts can be added to multiple groups
 * 
 * *Procedure:
 * 1- Access to Equinox client 
 * 2- Navigate to contact tab
 * 3- From group, click on more button -> Add contact to group
 * 4- Drop and drag contact which existing in other group to Adding panel
 * 5- Click Done button
 * 
 * *Expected result:
 * contacts can be added successfully
 *
 */

public class CONGRP_016 {

	static AndroidDriver<?> androidClientDriver;
	AndroidClientKeywords androidClient = new AndroidClientKeywords();
	Selenium selenium = new Selenium();
	DriverManagement driverMgnt = new DriverManagement();
	aadsData aadsData = new aadsData();

	final static Logger logger = LogManager.getLogger("VerifyContactCanBeAddedToMultipleGroups");
	
	@Before
	public void setUp() throws Exception {
		logger.info("beforeTest_VerifyContactCanBeAddedToMultipleGroups starting...\n");
		androidClientDriver = driverMgnt.createAndroidClientDriver();
		logger.info("beforeTest_VerifyContactCanBeAddedToMultipleGroups  completed...\n");
	}

	@Test
	public void test() {
		try {
			String ContactName = androidClient.addExistingContactToMultipleGroups(androidClientDriver);
			Boolean s = androidClient.verifyContactNameExistedAllContactGroups(androidClientDriver, ContactName);
			if(s) assertTrue(s);
			else throw new Exception("Verify Contact in All Group FAILED");
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
