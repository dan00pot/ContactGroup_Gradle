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
 * Verify that Contact Group is displayed in Equinox client when AADS enable and hidden when disable
 *Procedure:
 *1- Enable AADS then login Equinox client
 *2- Disable AADS then login Equinox client
 *Expected result:
 *1- Contact group is displayed in contact list
 *2- Contact group is hidden in contact list
 */
public class CONGRP_001 {
	
	static AndroidDriver<?> androidClientDriver;
	AndroidClientKeywords androidClient = new AndroidClientKeywords();
	Selenium selenium = new Selenium();
	DriverManagement driverMgnt = new DriverManagement();
	aadsData aadsData = new aadsData();

	final static Logger logger = LogManager.getLogger("VerifyContactGroup");

	@Before
	public void setUp() throws Exception {
		logger.info("beforeTest_VerifyContactGroup starting...\n");
		androidClientDriver = driverMgnt.createAndroidClientDriver();
		logger.info("beforeTest_VerifyContactGroup  completed...\n");
	}

	@Test
	public void test() {
		try {
			androidClient.enableDevicesServices(androidClientDriver, "Device Services OFF");
			boolean result = androidClient.verifyContactGroup(androidClientDriver, "Device Services OFF");
			if(result) assertTrue(result); else throw new Exception("Verify Contact Group FAILED");
			androidClient.enableDevicesServices(androidClientDriver, "Device Services ON");
			boolean result1 = androidClient.verifyContactGroup(androidClientDriver, "Device Services ON");
			if(result1) assertTrue(result1);
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
