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
 * Verify that contact group can be renamed
 * 1- Access to Equinox client
 * 2- Navigate to contact tab
 * 3- From group, click on more button -> Edit Group Name
 * 4- Rename group name then click done button
 * 
 * Expected result:
 * Name of group is changed successfully
 *
 */

public class CONGRP_008 {

	static AndroidDriver<?> androidClientDriver;
	AndroidClientKeywords androidClient = new AndroidClientKeywords();
	Selenium selenium = new Selenium();
	DriverManagement driverMgnt = new DriverManagement();
	aadsData aadsData = new aadsData();
	
	final static Logger logger = LogManager.getLogger("editContactGroups");

	@Before
	public void setUp() throws Exception {
		logger.info("beforeTest_EditContactGroup starting...\n");
		androidClientDriver = driverMgnt.createAndroidClientDriver();
		logger.info("beforeTest_EditContactGroup  completed...\n");
	}

	@Test
	public void test() {
		try {
			androidClient.editContactGroup(androidClientDriver, "Contact_Group_004", "Contact_Group_008");
			boolean s = androidClient.verifyContactGroupIsExistedContactList(androidClientDriver, "groups1s");
			logger.info(s);
			if(s) assertTrue(s); //WHY
			else throw new Exception("Verify Contact Group FAILED");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@After
	public void tearDown() throws Exception {
		logger.info("tearDown starting...\n");
		logger.info("tearDown completed...\n");
	}

}
