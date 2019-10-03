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
 * Verify that group can be deleted 
 * 
 * Procedure:
 * 1- Login to Equinox client
 * 2- Navigate to Contact list
 * 3- Delete group which have some contacts
 * 4- Delete the empty group
 * 5- Re-add the group with same group name
 * 
 * Expected result:
 * Groups can be deleted
 * New group with same name with the deleted group can be added successfully
 *
 */

/**
 * @author Giang
 * behavior ?
 *
 */
public class CONGRP_011 {
	static AndroidDriver<?> androidClientDriver;
	AndroidClientKeywords androidClient = new AndroidClientKeywords();
	Selenium selenium = new Selenium();
	DriverManagement driverMgnt = new DriverManagement();
	aadsData aadsData = new aadsData();

	final static Logger logger = LogManager.getLogger("Remove Contact");

	@Before
	public void setUp() throws Exception {
		logger.info("beforeTest_Edit Contact Group starting...\n");
		androidClientDriver = driverMgnt.createAndroidClientDriver();
		logger.info("beforeTest_Edit ContactGroup  completed...\n");
	}

	@Test
	public void test() {
		String groupName =  "Contact_Group_008";
		try {
			androidClient.removeContactGroup(androidClientDriver, groupName);
			boolean s = androidClient.verifyContactGroupIsExistedContactList(androidClientDriver, groupName);
			if(!s) assertTrue(!s);
			else throw new Exception("Verify Contact Group FAILED");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertFalse(true);
			e.printStackTrace();
		}
	}

	@After
	public void tearDown() throws Exception {
		logger.info("tearDown starting...\n");
		logger.info("tearDown completed...\n");
	}

}
