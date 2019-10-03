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
 * Verify client remember and retains the last open/close states of the groups
 * 
 * *Procedure:
 * 1- Login Equinox client
 * 2- Open some groups 
 * 3- Logout then relogin
 * 
 * *Expected result:
 * client retains the last open/close states of the groups
 *
 */

public class CONGRP_003 {
	
	static AndroidDriver<?> androidClientDriver;
	AndroidClientKeywords androidClient = new AndroidClientKeywords();
	Selenium selenium = new Selenium();
	DriverManagement driverMgnt = new DriverManagement();
	aadsData aadsData = new aadsData();
	
	final static Logger logger = LogManager.getLogger("verifyContactGroupsAfterRelogin");
	
	@Before
	public void setUp() throws Exception {
		logger.info("beforeTest_VerifyContactGroupRelogin starting...\n");
		androidClientDriver = driverMgnt.createAndroidClientDriver();
		logger.info("beforeTest_VerifyContactGroupRelogin completed...\n");
	}
	
	@Test
	public void test() throws Exception {
		try {
			String groupName = "Contact_Group_003";
//			androidClient.addNewContactGroup(androidClientDriver, groupName);
			boolean result = androidClient.verifyContactGroupsAfterRelogin(androidClientDriver, groupName);
			if(result) assertTrue(result);
			else throw new Exception("Verify Contact Group FAILED");
			
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
