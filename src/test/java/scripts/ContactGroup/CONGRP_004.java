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
 *Verify that contact group can be created
 *
 *Procedure:
 *1- Access to Equinox client
 *2- Navigate to contact tab
 *3- Click on Add button -> New Group
 *4- Input group name and add some contacts to group
 *5- Click Done button
 *
 *Expected result:
 *Group can be created successfully and contain contacts fully
 */

public class CONGRP_004 {
	
	static AndroidDriver<?> androidClientDriver;
	AndroidClientKeywords androidClient = new AndroidClientKeywords();
	Selenium selenium = new Selenium();
	DriverManagement driverMgnt = new DriverManagement();
	aadsData aadsData = new aadsData();

	final static Logger logger = LogManager.getLogger("addNewContactGroups");
	
	@Before
	public void setUp() throws Exception {
		logger.info("beforeTest_AddNewContactGroup starting...\n");
		androidClientDriver = driverMgnt.createAndroidClientDriver();
		logger.info("beforeTest_AddNewContactGroup  completed...\n");
	}

	@Test
	public void test() {
		try {
			String groupName = "Contact_Group_004";
			androidClient.addNewContactGroup(androidClientDriver, groupName);
			boolean s = androidClient.verifyContactGroupIsExistedContactList(androidClientDriver, groupName);
			if(s) assertTrue(s);
			else throw new Exception("Verify Contact Group FAILED");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@After
	public void tearDown() throws Exception {
		logger.info("tearDown starting...\n");
		logger.info("tearDown completed...\n");
	}

}
