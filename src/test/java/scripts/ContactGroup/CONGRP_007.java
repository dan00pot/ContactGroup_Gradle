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
 * Verify that group contacts can be added to favorite and also removed 
 * 
 * Procedure:
 * 1- Access to Equinox client
 * 2- Navigate to contact list
 * 3- Open the existing group
 * 4- Add some contact to favorite list
 * 5- Remove contact from favorite
 * 
 * Expected result:
 * 4- Contact displayed as favorite in favorite list, group list and contact list
 * 5- Contact is removed from favorite list successfully
 *
 */

public class CONGRP_007 {

	static AndroidDriver<?> androidClientDriver;
	AndroidClientKeywords androidClient = new AndroidClientKeywords();
	Selenium selenium = new Selenium();
	DriverManagement driverMgnt = new DriverManagement();
	aadsData aadsData = new aadsData();
	
	final static Logger logger = LogManager.getLogger("VerifyFavoriteContactinGroup");
	
	@Before
	public void setUp() throws Exception {
		logger.info("beforeTest_VerifyFavoriteContactinGroup starting...\n");
		androidClientDriver = driverMgnt.createAndroidClientDriver();
		logger.info("beforeTest_VerifyFavoriteContactinGroup completed...\n");
	}
	
	@Test
	public void test() {
		String groupName = "Contact_Group_Giang";
		String ContactName = "Franklyn Rush";
		try {
//			contact exist return false; favorite exist return true
			
//			if (androidClient.verifyFavoriteContactNameIsExistedContactGroup(androidClientDriver, groupName, ContactName)
//					&& androidClient.verifyFavoriteContactExistedinAllContactList(androidClientDriver, ContactName)) {
//				boolean result = (androidClient.verifyContactExistedinFavoritelist(androidClientDriver, ContactName));
//				if (!result) {
//						androidClient.modifyContacttoFavoriteList(androidClientDriver, ContactName, "Add Favorite Contact");
//				} else throw new Exception("Verify Favorite Contact in Group FAILED");
//			};
//			
//			logger.info("tearDown starting 1454567546456...\n");
//			boolean s = (!(androidClient.verifyFavoriteContactNameIsExistedContactGroup(androidClientDriver, groupName, ContactName))
//							&& !(androidClient.verifyFavoriteContactExistedinAllContactList(androidClientDriver, ContactName))
//								&& (androidClient.verifyContactExistedinFavoritelist(androidClientDriver, ContactName)));
//				if(s) assertTrue(s); 
//				else throw new Exception("Verify Favorite Contact in Group FAILED");
//			logger.info("tearDown starting 1454567546456...\n");
//			androidClient.modifyContacttoFavoriteList(androidClientDriver, ContactName, "Remove Favorite Contact");
			boolean s1 = (androidClient.verifyFavoriteContactNameIsExistedContactGroup(androidClientDriver, groupName, ContactName)
							&& androidClient.verifyFavoriteContactExistedinAllContactList(androidClientDriver, ContactName)
								&& (!androidClient.verifyContactExistedinFavoritelist(androidClientDriver, ContactName)));
			if(s1) assertTrue(s1); else throw new Exception("Verify Favorite Contact in Group FAILED");
			logger.info("tearDown starting 123012...\n");
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
