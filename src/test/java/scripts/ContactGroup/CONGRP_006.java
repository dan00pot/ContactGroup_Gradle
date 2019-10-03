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
 * Verify that Enterprise contacts can be added to the existing group
 * 
 * Procedure:
 * 1- Access to Equinox client
 * 2- Navigate to contact list
 * 3- From group, click on more button -> Add contact to group
 * 4- Search contact then drop and drag to Adding panel
 * 5- Click Done button
 * 
 * *Expected result:
 * Enterprise contact can be added to existing group
 *
 */

public class CONGRP_006 {
	
	static AndroidDriver<?> androidClientDriver;
	AndroidClientKeywords androidClient = new AndroidClientKeywords();
	Selenium selenium = new Selenium();
	DriverManagement driverMgnt = new DriverManagement();
	aadsData aadsData = new aadsData();
	
	final static Logger logger = LogManager.getLogger("AddEnterpriseConntact");

	@Before
	public void setUp() throws Exception {
		logger.info("beforeTest_AddEnterpriseConntact starting...\n");
		androidClientDriver = driverMgnt.createAndroidClientDriver();
		logger.info("beforeTest_AddEnterpriseConntact  completed...\n");
	}
	
	@Test
	public void test() {
		String groupName = "Contact_Group_004";
		String enterPriseUser ="kwagner";
		try {
			String ContactName = androidClient.addEnterpriseContacttoExistingGroup(androidClientDriver, groupName, enterPriseUser);
			boolean s = androidClient.verifyContactNameIsExistedContactGroup(androidClientDriver, groupName, ContactName);
			if(s) assertTrue(s);
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
