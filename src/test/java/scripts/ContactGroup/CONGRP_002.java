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
 *Verify new elements and changes of Equinox client for contact group:
 *_ Add button -> New Group
 *_ No new filter for groups
 *_ Contact list separated to 2 part: Contact Groups and All Contacts
 *_ Contact Group: Top of contact list, sort alphabetically, default closed
 *_ Group tab: Image, Name, Number of member, open/close group
 *_ Call, Video call, Conversation, More button of group
 *_ More button: Edit Group Name, Add Contact to Group, Remove Group
 *
 */

/**
 * @author Giang
 * this case should hold because locator not click, re-check behavior aads test case 
 * Not Completed
 */
public class CONGRP_002 {
	
	static AndroidDriver<?> androidClientDriver;
	AndroidClientKeywords androidClient = new AndroidClientKeywords();
	Selenium selenium = new Selenium();
	DriverManagement driverMgnt = new DriverManagement();
	aadsData aadsData = new aadsData();
	
	final static Logger logger = LogManager.getLogger("VerifyContactGroupElements");
	
	@Before
	public void setUp() throws Exception {
		logger.info("beforeTest_VerifyContactGroupElements starting...\n");
		androidClientDriver = driverMgnt.createAndroidClientDriver();
		logger.info("beforeTest_VerifyContactGroupElements  completed...\n");
	}

	@Test
	public void test() throws Exception {
		String groupName = "Contact_Group_xyz";
		try {
//			androidClient.addNewContactGroup(androidClientDriver, groupName);
//			boolean s = androidClient.verifyContactGroupIsExistedContactList(androidClientDriver, groupName);
//			if(s) assertTrue(s);
//			else throw new Exception("Verify Contact Group FAILED");
			boolean result = androidClient.verifyElementsOfContactGroup(androidClientDriver, groupName);
			if(result) assertTrue(result); else throw new Exception("Verify Element of Group FAILED");
		} catch (Exception e) {
			// TODO: handle exception
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
