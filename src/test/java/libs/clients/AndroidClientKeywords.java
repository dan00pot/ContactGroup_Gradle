package libs.clients;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ISelect;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.appium.java_client.android.AndroidDriver;
import libs.common.DriverManagement;
import libs.common.Selenium;

public class AndroidClientKeywords {
	final static Logger logger = LogManager.getLogger("androidClient");
	Selenium selenium = new Selenium();
	AndroidClientLocators androidClient = new AndroidClientLocators();
	DriverManagement driverMgnt = new DriverManagement();

	AndroidDriver androidClientDriver;
	
	ExtentHtmlReporter htmlReporter;
	static ExtentReports reports;
	ExtentTest test;
	int timeout = 1000;
	
	public String getAttribute(WebDriver driver, By byLocator, String attribute)
			throws Exception {
		try {
			logger.info("getAttribute starting...\n");
			logger.info("byLocator: " + byLocator + "\n");
			logger.info("attribute: " + attribute + "\n");
			WebElement element = driver.findElement(byLocator);
			String attributeValue = element.getAttribute(attribute);
			logger.info("value is: " + attributeValue);
			logger.info("getAttribute completed...\n");

			return attributeValue;
		} catch (Exception ex) {
			logger.error("clickElement - Failed - Exception occurs: " + ex
					+ "\n");
			throw new Exception("clickElement - Failed - Exception occurs: "
					+ ex);
		}
	}
	
	public void settingScreenMainClickOnTab(AndroidDriver androidClientDriver, String tabName) throws Exception{
		
		try {
			selenium.clickElement(androidClientDriver, androidClient.settingScreenTabLocators(tabName));
		} catch (Exception exception) { 
			throw new Exception("settingScreenMainClickOnTab - Failed - Exception occurs: " + exception);
		}			
    }
	
	public void goToServicePage(AndroidDriver androidClientDriver, String tabName) throws Exception{
		try {
			Thread.sleep(1000);
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.FIRST_SCREEN_MENU_BTN);
			selenium.clickElement(androidClientDriver, androidClient.FIRST_SCREEN_MENU_BTN);
			settingScreenMainClickOnTab(androidClientDriver, tabName);
			Thread.sleep(1000);
		} catch (Exception exception) {
			throw new Exception("OpenServicesPages - Failed - exception occurs:" + exception);
		}
	}
	
	public void enableDevicesServices(AndroidDriver androidClientDriver, String value) throws Exception {
		logger.info("enableDevicesServices - starting...\n");
		try {
			Thread.sleep(2000);
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.FIRST_SCREEN_MENU_BTN);
			selenium.clickElement(androidClientDriver, androidClient.FIRST_SCREEN_MENU_BTN);
			Thread.sleep(1000);
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.HEADER_SETTING_BTN);
			selenium.clickElement(androidClientDriver, androidClient.HEADER_SETTING_BTN);
			Thread.sleep(1000);
			settingScreenMainClickOnTab(androidClientDriver, "Services");
			if (selenium.getText(androidClientDriver, androidClient.SERVICES_DETAILS_BTN).equals("OFF"))
				{
				selenium.clickElement(androidClientDriver, androidClient.SERVICES_DETAILS_BTN);
				};
			settingScreenMainClickOnTab(androidClientDriver, "Device Services");
			Thread.sleep(1000);
			if (!selenium.getText(androidClientDriver, androidClient.STATUS_DEVICE_SERVICES_BTN).equals(value)) {
				selenium.waitUntilElementClickable(androidClientDriver, androidClient.STATUS_DEVICE_SERVICES_BTN);
				selenium.clickElement(androidClientDriver, androidClient.STATUS_DEVICE_SERVICES_BTN);
				settingScreenMainClickOnTab(androidClientDriver, "Done");
				Thread.sleep(1000);
				selenium.waitUntilElementClickable(androidClientDriver, androidClient.DEVICE_SERVICES_SIGNOUT_BTN);
				selenium.clickElement(androidClientDriver, androidClient.DEVICE_SERVICES_SIGNOUT_BTN);
				Thread.sleep(1000);
			} else	{
			settingScreenMainClickOnTab(androidClientDriver, "Done");
					}
			Thread.sleep(1000);
			settingScreenMainClickOnTab(androidClientDriver, "Back");
			settingScreenMainClickOnTab(androidClientDriver, "Done");
		} catch (Exception exception) {
			logger.error("enableDevicesServices - Failed with Exception: " + exception + "...\n");
			throw new Exception("enableDevicesServices - Failed - Exception occurs: " + exception);
		}
		logger.info("enableDevicesServices - completed...\n");
	}
	
	public boolean verifyContactGroup(AndroidDriver androidClientDriver, String value) throws Exception {
		logger.info("verifyContactGroup - starting...\n");
		boolean flag = false;
		try {
			goToServicePage(androidClientDriver, "Contacts");
			if ((value == "Device Services ON" && selenium.isElementExisted(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_GROUPS_TITLE_BAR)
					|| (value == "Device Services OFF" && !selenium.isElementExisted(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_GROUPS_TITLE_BAR)))) {
				flag = true;
			}
			else flag = false;
		} catch (Exception exception) {
			logger.error("verifyContactGroup - Failed with Exception: " + exception + "...\n");
			throw new Exception("verifyContactGroup - Failed - Exception occurs: " + exception);
		}
		logger.info("verifyContactGroup - completed...\n");
		return flag;
	}
	
//	public void verifyElementsOfContactGroup(AndroidDriver androidClientDriver, String groupName) throws Exception {
//		logger.info("VerifyElementOfContactGroup - starting...\n");
//		try {
//			goToServicePage(androidClientDriver, "Contacts");
//			selenium.waitUntilElementClickable(androidClientDriver, androidClient.CONTACT_TAB_SCREEN_ADD_CONTACT_BTN);
//			selenium.clickElement(androidClientDriver, androidClient.CONTACT_TAB_SCREEN_ADD_CONTACT_BTN);
//			selenium.waitUntilElementClickable(androidClientDriver, androidClient.addScreenTabLocators("New Contact Group"));
//			selenium.clickElement(androidClientDriver, androidClient.addScreenTabLocators("New Contact Group"));
//			selenium.waitUntilElementClickable(androidClientDriver, androidClient.CONTACT_GROUP_FILTER_BTN);
//			selenium.clickElement(androidClientDriver, androidClient.CONTACT_GROUP_FILTER_BTN);
//			logger.info("**** verifyContentOfFilter ****");
//			for (int i = 1; i<=3; i++) {
////				String s1 = selenium.getAttribute(androidClientDriver, androidClient.CONTACT_GROUP_VERIFY_CONTENT_FILTER_BUTTON(i), "text");
////				if (!(s1 == "All Contacts" || s1 == "Equinox Contacts" || s1 == "Local Contacts")) {assert false;}
//				selenium.clickElement(androidClientDriver, androidClient.CONTACT_GROUP_VERIFY_CONTENT_FILTER_BUTTON(i));
////				else i++;		
//				i++;
//			};
//			selenium.waitUntilElementClickable(androidClientDriver, androidClient.CONTACT_GROUP_FILTER_BTN);
//			selenium.clickElement(androidClientDriver, androidClient.CONTACT_GROUP_FILTER_BTN);
//			selenium.waitUntilElementClickable(androidClientDriver, androidClient.CONTACT_GROUP_WINDOW_CHOOSE_CONTACTS_CHECKBOX(1));
//			selenium.clickElement(androidClientDriver, androidClient.CONTACT_GROUP_WINDOW_CHOOSE_CONTACTS_CHECKBOX(1));
//			contactScreenMainClickOnTab(androidClientDriver, "Next");
//			contactScreenMainClickOnTab(androidClientDriver, "Done");
//			selenium.waitUntilElementClickable(androidClientDriver, androidClient.CONTACT_GROUP_ENTER_GROUP_NAME_TXT);
//			selenium.inputText(androidClientDriver, androidClient.CONTACT_GROUP_ENTER_GROUP_NAME_TXT, groupName);
//			selenium.waitUntilElementClickable(androidClientDriver, androidClient.CONTACT_GROUP_ENTER_GROUP_NAME_OK_BTN);
//			selenium.clickElement(androidClientDriver, androidClient.CONTACT_GROUP_ENTER_GROUP_NAME_OK_BTN);
//		} catch (Exception exception) {
//			// TODO: handle exception
//			logger.error("verifyElementsOfContactGroup - Failed with Exception: " + exception + "...\n");
//			throw new Exception("verifyElementsOfContactGroup - Failed - Exception occurs: " + exception);
//		}
//		logger.info("VerifyElementOfContactGroup - completed...\n");
//	}
		
	
	public boolean verifyElementsOfContactGroup(AndroidDriver androidClientDriver, String groupName) throws Exception {
		logger.info("VerifyElementOfContactGroup - starting...\n");
		boolean flag =false;
		try {
			goToServicePage(androidClientDriver, "Contacts");
			boolean addButton = selenium.isElementExisted(androidClientDriver, androidClient.CONTACT_TAB_SCREEN_ADD_CONTACT_BTN);
			boolean contactGroupButton = selenium.isElementExisted(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_GROUPS_TITLE_BAR);
			boolean allContactButton = selenium.isElementExisted(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_LIST_HEADER_TITLE_BAR);
			selenium.longPress(androidClientDriver, androidClient.CONTACT_GROUP_NAME_NEXT_BTN(groupName));
			Thread.sleep(2000);
//			selenium.clickElement(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_GROUPS_NAME_CALL_VOICE_BTN);
			boolean audioCallButton = selenium.isElementExisted(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_GROUPS_NAME_CALL_VOICE_BTN);
			boolean videoCallButton = selenium.isElementExisted(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_GROUPS_NAME_CALL_VIDEO_BTN);
			boolean conversationButton = selenium.isElementExisted(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_GROUPS_NAME_CONVERSATION_BTN);
			boolean moreActionsButton = selenium.isElementExisted(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_GROUPS_NAME_MORE_ACTIONS_BTN);
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_GROUPS_NAME_MORE_ACTIONS_BTN);
			boolean editGroupNameButton = selenium.isElementExisted(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_GROUPS_NAME_MORE_ACTIONS_OPTION("Edit Group Name"));
			boolean addContacttoGroupButton = selenium.isElementExisted(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_GROUPS_NAME_MORE_ACTIONS_OPTION("Add Contact to Group"));
			boolean removeGroupButton = selenium.isElementExisted(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_GROUPS_NAME_MORE_ACTIONS_OPTION("Remove Group"));
			boolean cancelButton = selenium.isElementExisted(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_GROUPS_NAME_MORE_ACTIONS_OPTION("Cancel"));
			if (addButton && contactGroupButton && allContactButton && audioCallButton && videoCallButton && conversationButton && moreActionsButton && editGroupNameButton
					&& addContacttoGroupButton && removeGroupButton && cancelButton) {flag = true;}
		} catch (Exception exception) {
			// TODO: handle exception
			logger.error("verifyElementsOfContactGroup - Failed with Exception: " + exception + "...\n");
			throw new Exception("verifyElementsOfContactGroup - Failed - Exception occurs: " + exception);
		}
		logger.info("VerifyElementOfContactGroup - completed...\n");
		return flag;
	}
	
	public void goToServicePage1(AndroidDriver androidClientDriver, String tabName) throws Exception{
		try {
			Thread.sleep(2000);
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.FIRST_SCREEN_MENU_BTN);
			selenium.clickElement(androidClientDriver, androidClient.FIRST_SCREEN_MENU_BTN);
			settingScreenMainClickOnTab(androidClientDriver, tabName);
			Thread.sleep(1000);
		} catch (Exception exception) {
			throw new Exception("OpenServicesPages - Failed - exception occurs:" + exception);
		}
	}
	
	public void userRelogin(AndroidDriver AndroidClientDriver) throws Exception{
		try {
			Thread.sleep(2000);
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.PROFILE_AVATA_BTN);
			selenium.clickElement(androidClientDriver, androidClient.PROFILE_AVATA_BTN);
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.USER_SIGN_OUT_BTN);
			selenium.clickElement(androidClientDriver, androidClient.USER_SIGN_OUT_BTN);
			Thread.sleep(1000);
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.USER_SIGN_IN_BTN);
			selenium.clickElement(androidClientDriver, androidClient.USER_SIGN_IN_BTN);
			Thread.sleep(1000);
		} catch (Exception exception) {
			throw new Exception("userRelogin - Failed - exceptions occurs:" + exception);
		}
		
	}
	
	public boolean verifyContactGroupsAfterRelogin(AndroidDriver androidClientDriver, String groupName) throws Exception {
		logger.info("verifyContactGroupsAfterRelogin - starting...\n");
		boolean flag = false;
		try {
			goToServicePage(androidClientDriver, "Contacts");
			if (selenium.isElementExisted(androidClientDriver, androidClient.CONTACT_GROUP_MEMBERS_DISPLAY_BTN(groupName))) {
				Thread.sleep(2000);
				selenium.waitUntilElementClickable(androidClientDriver, androidClient.PROFILE_AVATA_BTN);
				selenium.clickElement(androidClientDriver, androidClient.PROFILE_AVATA_BTN);
				selenium.waitUntilElementClickable(androidClientDriver, androidClient.USER_SIGN_OUT_BTN);
				selenium.clickElement(androidClientDriver, androidClient.USER_SIGN_OUT_BTN);
				Thread.sleep(1000);
				selenium.waitUntilElementClickable(androidClientDriver, androidClient.USER_SIGN_IN_BTN);
				selenium.clickElement(androidClientDriver, androidClient.USER_SIGN_IN_BTN);
				Thread.sleep(1000);				
				goToServicePage(androidClientDriver, "Contacts");
				if (selenium.isElementExisted(androidClientDriver, androidClient.CONTACT_GROUP_MEMBERS_DISPLAY_BTN(groupName))) {
					selenium.clickElement(androidClientDriver, androidClient.CONTACT_GROUP_DISPLAY_NAME_BTN(groupName));
					flag = true;
					}
				else flag = false;
				Thread.sleep(2000);
				selenium.waitUntilElementClickable(androidClientDriver, androidClient.PROFILE_AVATA_BTN);
				selenium.clickElement(androidClientDriver, androidClient.PROFILE_AVATA_BTN);
				selenium.waitUntilElementClickable(androidClientDriver, androidClient.USER_SIGN_OUT_BTN);
				selenium.clickElement(androidClientDriver, androidClient.USER_SIGN_OUT_BTN);
				Thread.sleep(1000);
				selenium.waitUntilElementClickable(androidClientDriver, androidClient.USER_SIGN_IN_BTN);
				selenium.clickElement(androidClientDriver, androidClient.USER_SIGN_IN_BTN);
				Thread.sleep(1000);
				goToServicePage(androidClientDriver, "Contacts");
				if (!(selenium.isElementExisted(androidClientDriver, androidClient.CONTACT_GROUP_MEMBERS_DISPLAY_BTN(groupName)))) {
					selenium.clickElement(androidClientDriver, androidClient.CONTACT_GROUP_DISPLAY_NAME_BTN(groupName));
					flag = true;
					}
			else flag = false;
			};
		} catch (Exception exception) {
			logger.error("verifyContactGroupsAfterRelogin - Failed with Exception: " + exception + "...\n");
			throw new Exception("verifyContactGroupsAfterRelogin - Failed - Exception occurs: " + exception);
		}
		logger.info("verifyContactGroupsAfterRelogin - completed...\\n");
		return flag;
	}
	
	public boolean verifyContactGroupIsExistedContactList(AndroidDriver androidClientDriver, String groupName) throws Exception{
		logger.info("verifyContactIsExistedContactList - starting...\n");
		boolean flag= false;
		try {
			Thread.sleep(2000);
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.FIRST_SCREEN_MENU_BTN);
			selenium.clickElement(androidClientDriver, androidClient.FIRST_SCREEN_MENU_BTN);
			settingScreenMainClickOnTab(androidClientDriver, "Contacts");
			logger.info("**** verifyContactGroupsOnACA - Get number of result ****");
			String s1 = selenium.getAttribute(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_GROUPS_TITLE_BAR, "text");
			String number = s1.replaceAll("[^0-9]", "");
			int num = Integer.parseInt(number);
			
			for (int i = 0; i < num; i++) {
				String order = String.valueOf(i + 1);
				// get value in Enterprise if found
				String s2 = selenium.getText(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_GROUPS(order));
				logger.info("verifyEnterprieseContactSearch - result "+(i+1)+": " + s2);
				if (s2.contains(groupName)) {
					logger.info("verifyContactGroups - Existed the expected result - PASSED ");
					flag = true;
					break;
				}
			}
			
		} catch (Exception exception) { 
			logger.error("verifyContactGroups - Failed with Exception: " + exception + "...\n");
			throw new Exception("verifyContactGroups - Failed - Exception occurs: " + exception);
		}
		logger.info(flag);
		logger.info("verifyContactIsExistedContactList - completed...\n");
		return flag;
    }
	
	public void contactScreenMainClickOnTab(AndroidDriver androidClientDriver, String tabName) throws Exception{
		
		try {
			selenium.clickElement(androidClientDriver, androidClient.contactScreenTabLocators(tabName));
		} catch (Exception exception) { 
			throw new Exception("settingScreenMainClickOnTab - Failed - Exception occurs: " + exception);
		}			
    }
	
	public int countContact(AndroidDriver androidClientDriver, String textOflocator) throws Exception{
		logger.info("getNumberContact - starting...\n");
		int num;
		try {
			logger.info("getNumberContact - starting...\n1231");
			String s1 = selenium.getAttribute(androidClientDriver, androidClient.countContactOfButton(textOflocator), "text");
			System.out.println(s1);
			String number = s1.replaceAll("[^0-9]", "");
			num = Integer.parseInt(number);
		} catch (Exception exception) {
			// TODO: handle exception
			logger.error("getNumberContact - Failed with Exception: " + exception + "..\n");
			throw new Exception("getnumberContact - Failed - Exceptions occurs: " + exception);
		}
		logger.info("getNumberContact - completed...\n");
		return num;
	}
	
	public void addNewContactGroup(AndroidDriver androidClientDriver, String groupName) throws Exception {
		logger.info("addNewContactGroups - starting...\n");		
		try {
			Thread.sleep(2000);
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.FIRST_SCREEN_MENU_BTN);
			selenium.clickElement(androidClientDriver, androidClient.FIRST_SCREEN_MENU_BTN);
			Thread.sleep(1000);
			settingScreenMainClickOnTab(androidClientDriver, "Contacts");
			Thread.sleep(2000);
//			int number = countContact(androidClientDriver, "All Contacts");
//			Random random1 = new Random();
//			int numUser = random1.nextInt(number) + 1;
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.CONTACT_TAB_SCREEN_ADD_CONTACT_BTN);
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_TAB_SCREEN_ADD_CONTACT_BTN);
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.addScreenTabLocators("New Contact Group"));
			selenium.clickElement(androidClientDriver, androidClient.addScreenTabLocators("New Contact Group"));
//			int i = 0;
//					Random rd = new Random();
//					while (i < numUser) {
//					    int rdNum = rd.nextInt(numUser) + 1;		
//					    if (!selenium.isElementSelected(androidClientDriver, androidClient.CONTACT_GROUP_WINDOW_CHOOSE_CONTACTS_CHECKBOX(rdNum))) {
//					    	selenium.clickElement(androidClientDriver, androidClient.CONTACT_GROUP_WINDOW_CHOOSE_CONTACTS_CHECKBOX(number));
//					    	i = (i + 1);
//					    }
//					}
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.CONTACT_GROUP_WINDOW_CHOOSE_CONTACTS_CHECKBOX(1));
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_GROUP_WINDOW_CHOOSE_CONTACTS_CHECKBOX(1));
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.CONTACT_GROUP_WINDOW_CHOOSE_CONTACTS_CHECKBOX(2));
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_GROUP_WINDOW_CHOOSE_CONTACTS_CHECKBOX(2));
			contactScreenMainClickOnTab(androidClientDriver, "Next");
			contactScreenMainClickOnTab(androidClientDriver, "Done");
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.CONTACT_GROUP_ENTER_GROUP_NAME_TXT);
			selenium.inputText(androidClientDriver, androidClient.CONTACT_GROUP_ENTER_GROUP_NAME_TXT, groupName);
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.CONTACT_GROUP_ENTER_GROUP_NAME_OK_BTN);
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_GROUP_ENTER_GROUP_NAME_OK_BTN);
		} catch (Exception exception) {
			// TODO: handle exception
			logger.error("addNewContactGroups - Failed with Exception: " + exception + "...\n");
			throw new Exception("addNewContactGroups - Failed -Exception occurs: " + exception);
		}
		logger.info("addnewContactGroups - completed...\n");
	}
	
	public void editContactGroup(AndroidDriver androidClientDriver, String oldName, String newName) throws Exception {
		logger.info("EditContactGroups - starting...\n");
		try {
			Thread.sleep(2000);
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.FIRST_SCREEN_MENU_BTN);
			selenium.clickElement(androidClientDriver, androidClient.FIRST_SCREEN_MENU_BTN);
			Thread.sleep(1000);
			settingScreenMainClickOnTab(androidClientDriver, "Contacts");
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.CONTACT_GROUP_NAME_NEXT_BTN(oldName));
			selenium.longPress(androidClientDriver, androidClient.CONTACT_GROUP_NAME_NEXT_BTN(oldName));
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_GROUPS_NAME_MORE_ACTIONS_BTN);
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_GROUPS_NAME_MORE_ACTIONS_BTN);
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.EDIT_GROUP_NAME_BTN);
			selenium.clickElement(androidClientDriver, androidClient.EDIT_GROUP_NAME_BTN);
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.CONTACT_GROUP_ENTER_GROUP_NAME_TXT);
			selenium.inputText(androidClientDriver, androidClient.CONTACT_GROUP_ENTER_GROUP_NAME_TXT, newName);
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.CONTACT_GROUP_ENTER_GROUP_NAME_OK_BTN);
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_GROUP_ENTER_GROUP_NAME_OK_BTN);
			
		} catch (Exception exception) {
			// TODO: handle exception
			logger.error("addNewContactGroups - Failed with Exception: " + exception + "...\n");
			throw new Exception("addNewContactGroups - Failed -Exception occurs: " + exception);
		}
		logger.info("EditContactGroups - completed...\n");
	}

	public void removeContactGroup(AndroidDriver androidClientDriver, String groupName) throws Exception{
		try {
			logger.info("editContactGroupName - starting");
			chooseContactGroupMoreActions(androidClientDriver, groupName, "Remove Group");
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.CONTACT_GROUP_CONFIRM_REMOVE_BTN);
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_GROUP_CONFIRM_REMOVE_BTN);


		} catch (Exception exception) {
			logger.error("removeContactGroup - Failed with Exception: " + exception + "...\n");

			throw new Exception("removeContactGroup - Failed - Exception occurs: " + exception);
		}
    }
	
	public String addEquinoxContacttoExistingGroup(AndroidDriver androidClientDriver, String groupName) throws Exception{
		String addContact = null;
		try {
			logger.info("editContactGroupName - starting");
			chooseContactGroupMoreActions(androidClientDriver, groupName, "Add Contact to Group");	
			if (selenium.isElementSelected(androidClientDriver, androidClient.CONTACT_GROUP_WINDOW_CHOOSE_CONTACTS_CHECKBOX(1))
				|| selenium.isElementSelected(androidClientDriver, androidClient.CONTACT_GROUP_WINDOW_CHOOSE_CONTACTS_CHECKBOX(2))) {
				throw new Exception("Selected contact is still able to choose again ");
			}
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_GROUP_WINDOW_CHOOSE_CONTACTS_CHECKBOX(3));
			addContact = selenium.getAttribute(androidClientDriver, androidClient.CONTACT_GROUP_WINDOW_CHOOSE_CONTACTS_NAME_TXT(3), "text");
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.CONTACT_GROUP_WINDOW_NEXT_BTN);
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_GROUP_WINDOW_NEXT_BTN);
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.CONTACT_GROUP_WINDOW_DONE_BTN);
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_GROUP_WINDOW_DONE_BTN);
			

		} catch (Exception exception) {
			logger.error("addEquinoxContacttoGroup - Failed with Exception: " + exception + "...\n");

			throw new Exception("addEquinoxContacttoGroup - Failed - Exception occurs: " + exception);
		}
		return addContact;
    }
	
	public String  addEnterpriseContacttoExistingGroup(AndroidDriver androidClientDriver, String groupName, String enterPriseUser) throws Exception {
		String addContact = null;
		try {
			logger.info("editContactGroupName - starting...\n");
			chooseContactGroupMoreActions(androidClientDriver, groupName, "Add Contact to Group");	
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.CONTACT_SEARCH_USER_EDIT_TEXT);
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_SEARCH_USER_EDIT_TEXT);
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.CONTACT_SEARCH_USER_EDIT_TEXT);			
			selenium.mobileInputText(androidClientDriver, androidClient.CONTACT_SEARCH_USER_EDIT_TEXT, enterPriseUser);
			Thread.sleep(3000);
			int number = countContact(androidClientDriver, "Enterprise Directory");
			
			for (int i=1; i<=number; i++) {
				selenium.waitUntilElementClickable(androidClientDriver, androidClient.CONTACT_GROUP_WINDOW_CHOOSE_ENTERPRISE_CONTACTS_CHECKBOX(i));
				String s1 = selenium.getAttribute(androidClientDriver, androidClient.CONTACT_GROUP_WINDOW_CHOOSE_ENTERPRISE_CONTACTS_CHECKBOX(i), "enabled");
				if (s1.equals("true")) {
					addContact = selenium.getAttribute(androidClientDriver, androidClient.CONTACT_GROUP_WINDOW_CHOOSE_ENTERPRISE_CONTACTS_NAME(i), "text");
					Thread.sleep(1000);
					selenium.waitUntilElementClickable(androidClientDriver, androidClient.CONTACT_GROUP_WINDOW_CHOOSE_ENTERPRISE_CONTACTS_CHECKBOX(i));
					selenium.clickElement(androidClientDriver, androidClient.CONTACT_GROUP_WINDOW_CHOOSE_ENTERPRISE_CONTACTS_CHECKBOX(i));
//					selenium.clickElement(androidClientDriver, androidClient.CONTACT_GROUP_WINDOW_CHOOSE_ENTERPRISE_CONTACTS_NAME(i));				
					break;
				}
			}
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.CONTACT_GROUP_ADD_ENTERPRISE_CONTACT_OK_BTN);
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_GROUP_ADD_ENTERPRISE_CONTACT_OK_BTN);
			Thread.sleep(5000);
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.CONTACT_GROUP_ADD_ENTERPRISE_CONTACT_DONE_BTN);
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_GROUP_ADD_ENTERPRISE_CONTACT_DONE_BTN);
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.CONTACT_GROUP_WINDOW_NEXT_BTN);
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_GROUP_WINDOW_NEXT_BTN);
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.CONTACT_GROUP_WINDOW_DONE_BTN);
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_GROUP_WINDOW_DONE_BTN);
			
		} catch (Exception exception) {
			// TODO: handle exception
			logger.error("addEnterpriseContacttoGroup - Failed with Exception: " + exception + "...\n");

			throw new Exception("addEnterpriseContacttoGroup - Failed - Exception occurs: " + exception);
		}
		return addContact;
	}
	
	public boolean  verifyContactExistedinFavoritelist(AndroidDriver androidClientDriver, String ContactName) throws Exception {
		boolean flag = false;
		try {
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.FIRST_SCREEN_MENU_BTN);
			selenium.clickElement(androidClientDriver, androidClient.FIRST_SCREEN_MENU_BTN);
			settingScreenMainClickOnTab(androidClientDriver, "Favorites");
			
			int number =1;
			while (selenium.isElementExisted(androidClientDriver, androidClient.FAVORITE_CONTACT_IN_FAVORITE_LIST(number))) {
				logger.info("verifyContactIsExistedContactList123 - completed...\n");
				if ((selenium.getAttribute(androidClientDriver, androidClient.FAVORITE_CONTACT_IN_FAVORITE_LIST(number), "text").equals(ContactName))) {
					logger.info("verifyContactIsExistedContactList456 - completed...\n");
					flag = true;
				}
				number++;	
			}
		} catch (Exception exception) {
			// TODO: handle exception
			logger.error("isContactinFavoritelist - Failed with Exception: " + exception + "...\n");
			
			throw new Exception("isContactinFavoritelist - Failed - Exception occurs: " + exception);
		}
		logger.info("verifyContactIsExistedContactList - completed...\n");
		return flag;
	}
	
	public boolean verifyFavoriteContactExistedinAllContactList(AndroidDriver androidClientDriver, String contactName) throws Exception {
		boolean flag = false;
		try {
			Thread.sleep(2000);
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.FIRST_SCREEN_MENU_BTN);
			selenium.clickElement(androidClientDriver, androidClient.FIRST_SCREEN_MENU_BTN);
			settingScreenMainClickOnTab(androidClientDriver, "Contacts");
			Thread.sleep(1000);
			logger.info("**** verifyAllContactOnACA - Get number of result ****");
			String s1 = selenium.getAttribute(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_LIST_HEADER_TITLE_BAR,"text");
			String number = s1.replaceAll("[^0-9]", "");
			int num = Integer.parseInt(number);
			
			for (int i = 0; i < num; i++) {
				String order = String.valueOf(i + 1);
				// get value in Enterprise if found
				String s2 = selenium.getText(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_NAME_IN_ALL_CONTACT_LIST(order));
				logger.info("verifyFavoriteContactExistedinAllContactList - result "+(i+1)+": " + s2);
				if (s2.contains(contactName) && !(selenium.isElementExisted(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_FAVORITE_CONTACT_NAME_IN_ALL_CONTACT_LIST(order)))) {
					logger.info("verifyFavoriteContactExistedinAllContactList - Existed the expected result - PASSED ");
					flag = true;
					break;
				}
			}
		} catch (Exception exception) {
			// TODO: handle exception
			logger.error("verifyFavoriteContactExistedinAllContactList - Failed with Exception: " + exception + "...\n");
			
			throw new Exception("verifyFavoriteContactExistedinAllContactList - Failed - Exception occurs: " + exception);
		}
		return flag;
	}
	
	public boolean verifyFavoriteContactNameIsExistedContactGroup(AndroidDriver androidClientDriver, String groupName, String ContactName) throws Exception{
		logger.info("verifyContactNameIsExistedContactGroup - starting...\n");
		boolean flag= false;
		try {
			Thread.sleep(2000);
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.FIRST_SCREEN_MENU_BTN);
			selenium.clickElement(androidClientDriver, androidClient.FIRST_SCREEN_MENU_BTN);
			settingScreenMainClickOnTab(androidClientDriver, "Contacts");
			logger.info("**** verifyContactGroupsOnACA - Get number of result ****");
			Thread.sleep(1000);
			String s1 = selenium.getAttribute(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_GROUPS_NAME(groupName), "text");
			String number = s1.replaceAll("[^0-9]", "");
			int num = Integer.parseInt(number);
			
			for (int i = 0; i < num; i++) {
				String order = String.valueOf(i + 1);
				// get value in Enterprise if found
				String s2 = selenium.getText(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_NAME_IN_CONTACT_GROUP(groupName,order));
				logger.info("verifyEnterprieseContactSearch - result "+(i+1)+": " + s2);
				if (s2.contains(ContactName) && !(selenium.isElementExisted(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_FAVORITE_CONTACT_NAME_IN_CONTACT_GROUP(groupName,order))) ) {
					logger.info("verifyContactGroups - Existed the expected result - PASSED ");
					flag = true;
					break;
				}
			}
			
		} catch (Exception exception) { 
			logger.error("verifyContactGroups - Failed with Exception: " + exception + "...\n");
			throw new Exception("verifyContactGroups - Failed - Exception occurs: " + exception);
		}
		logger.info("verifyContactIsExistedContactList - completed...\n");
		return flag;
    }
	
	public void modifyContacttoFavoriteList(AndroidDriver androidClientDriver, String ContactName, String value) throws Exception {
		try {
			logger.info("modifyContacttoFavoriteList - starting");
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.FIRST_SCREEN_MENU_BTN);
			selenium.clickElement(androidClientDriver, androidClient.FIRST_SCREEN_MENU_BTN);
			settingScreenMainClickOnTab(androidClientDriver, "Favorites");
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.CONTACT_SEARCH_USER_EDIT_TEXT);
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_SEARCH_USER_EDIT_TEXT);
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.CONTACT_SEARCH_USER_EDIT_TEXT);			
			selenium.mobileInputText(androidClientDriver, androidClient.CONTACT_SEARCH_USER_EDIT_TEXT, ContactName);
			Thread.sleep(3000);
			int number = countContact(androidClientDriver, "Contacts");
			
			for (int i=1; i<=number; i++) {
				if (selenium.getAttribute(androidClientDriver, androidClient.FAVORITE_SCREEN_CONTACTS_NAME(number), "text").equals(ContactName)) {
					selenium.waitUntilElementClickable(androidClientDriver, androidClient.FAVORITE_SCREEN_CONTACTS_NAME(number));
					selenium.clickElement(androidClientDriver, androidClient.FAVORITE_SCREEN_CONTACTS_NAME(number));
					break;
				};
			};
			Thread.sleep(2000);
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.FAVORITE_SCREEN_CONTACT_FAVORITE_BTN);
			selenium.clickElement(androidClientDriver, androidClient.FAVORITE_SCREEN_CONTACT_FAVORITE_BTN);
			Thread.sleep(2000);
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.FAVORITE_SCREEN_CONTACT_DETAILS_BACK_BTN);
			selenium.clickElement(androidClientDriver, androidClient.FAVORITE_SCREEN_CONTACT_DETAILS_BACK_BTN);
//			if (value.equals("Add Favorite Contact")) {
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.FAVORITE_SCREEN_ADD_FAVORITE_CONTACT_DONE_BTN);
			selenium.clickElement(androidClientDriver, androidClient.FAVORITE_SCREEN_ADD_FAVORITE_CONTACT_DONE_BTN);
//			}	
		} catch (Exception exception) {
			// TODO: handle exception
			logger.error("modifyContacttoFavoriteList - Failed with Exception: " + exception + "...\n");
			
			throw new Exception("modifyContacttoFavoriteList - Failed - Exception occurs: " + exception);
		}
		
	}
	
	public void chooseContactGroupMoreActions(AndroidDriver androidClientDriver, String groupName, String option) throws Exception{
		try {
			logger.info("editContactGroupName - starting");
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.FIRST_SCREEN_MENU_BTN);
			selenium.clickElement(androidClientDriver, androidClient.FIRST_SCREEN_MENU_BTN);
			settingScreenMainClickOnTab(androidClientDriver, "Contacts");
			selenium.longPress(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_GROUPS_NAME(groupName));
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_GROUPS_NAME_MORE_ACTIONS_BTN);
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_GROUPS_NAME_MORE_ACTIONS_OPTION(option));
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_GROUPS_NAME_MORE_ACTIONS_OPTION(option));	
		} catch (Exception exception) {
			logger.error("removeContactGroup - Failed with Exception: " + exception + "...\n");

			throw new Exception("removeContactGroup - Failed - Exception occurs: " + exception);
		}
    }
	
	public boolean verifyContactNameIsExistedContactGroup(AndroidDriver androidClientDriver, String groupName, String ContactName) throws Exception{
		logger.info("verifyContactNameIsExistedContactGroup - starting...\n");
		boolean flag= false;
		try {
			Thread.sleep(2000);
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.FIRST_SCREEN_MENU_BTN);
			selenium.clickElement(androidClientDriver, androidClient.FIRST_SCREEN_MENU_BTN);
			settingScreenMainClickOnTab(androidClientDriver, "Contacts");
			logger.info("**** verifyContactGroupsOnACA - Get number of result ****");
			String s1 = selenium.getAttribute(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_GROUPS_NAME(groupName), "text");
			String number = s1.replaceAll("[^0-9]", "");
			int num = Integer.parseInt(number);
			
			for (int i = 0; i < num; i++) {
				String order = String.valueOf(i + 1);
				// get value in Enterprise if found
				String s2 = selenium.getText(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_NAME_IN_CONTACT_GROUP(groupName,order));
				logger.info("verifyEnterprieseContactSearch - result "+(i+1)+": " + s2);
				if (s2.contains(ContactName)) {
					logger.info("verifyContactGroups - Existed the expected result - PASSED ");
					flag = true;
					break;
				}
			}	
		} catch (Exception exception) { 
			logger.error("verifyContactGroups - Failed with Exception: " + exception + "...\n");
			throw new Exception("verifyContactGroups - Failed - Exception occurs: " + exception);
		}
		logger.info("verifyContactIsExistedContactList - completed...\n");
		return flag;
    }
	
	public void removingContactOfContactGroup(AndroidDriver androidClientDriver, String groupName, String ContactName) throws Exception {
		logger.info("RemovingContactOfContactGroup - Starting...\n");
		try {
			Thread.sleep(2000);
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.FIRST_SCREEN_MENU_BTN);
			selenium.clickElement(androidClientDriver, androidClient.FIRST_SCREEN_MENU_BTN);
			settingScreenMainClickOnTab(androidClientDriver, "Contacts");			
			logger.info("**** verifyContactGroupsOnACA - Get number of result ****");
			String s1 = selenium.getAttribute(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_GROUPS_NAME(groupName), "text");
			String number = s1.replaceAll("[^0-9]", "");
			int num = Integer.parseInt(number);
			
			for (int i = 0; i < num; i++) {
				String order = String.valueOf(i + 1);
				// get value in Enterprise if found
				String s2 = selenium.getText(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_NAME_IN_CONTACT_GROUP(groupName,order));
				logger.info("verifyEnterprieseContactSearch - result "+(i+1)+": " + s2);
				if (s2.contains(ContactName)) {
					selenium.clickElement(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_NAME_IN_CONTACT_GROUP(groupName, order));
					selenium.waitUntilElementClickable(androidClientDriver, androidClient.CONTACT_DETAIL_REMOVE_CONTACT_FROM_GROUP_BY_X_BTN(groupName));
					selenium.clickElement(androidClientDriver, androidClient.CONTACT_DETAIL_REMOVE_CONTACT_FROM_GROUP_BY_X_BTN(groupName));
					selenium.waitUntilElementClickable(androidClientDriver, androidClient.CONTACR_DETAIL_REMOVE_CONTACT_FROM_GROUP_REMOVE_CONFIRM_BTN);
					selenium.clickElement(androidClientDriver, androidClient.CONTACR_DETAIL_REMOVE_CONTACT_FROM_GROUP_REMOVE_CONFIRM_BTN);
					selenium.waitUntilElementClickable(androidClientDriver, androidClient.CONTACT_DETAiLS_SCREEN_CONTACT_DETAILS_BACK_BTN);
					selenium.clickElement(androidClientDriver, androidClient.CONTACT_DETAiLS_SCREEN_CONTACT_DETAILS_BACK_BTN);
					break;
				}
			}	
			
		} catch (Exception exception) {
			// TODO: handle exception
			logger.error("RemovingContactOfContactGroup - Failed with Exception: " + exception + "...\n");
			throw new Exception("RemovingContactOfContactGroup - Failed - Exception occurs: " + exception);
		}
		logger.info("RemovingContactOfContactGroup - Completed...\n");
		
	}
	
	public void removeAllContactOfContactGroup(AndroidDriver androidClientDriver, String groupName) throws Exception {
		logger.info("removeAllContactOfContactGroup - Starting...\n");
		try {
			Thread.sleep(2000);
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.FIRST_SCREEN_MENU_BTN);
			selenium.clickElement(androidClientDriver, androidClient.FIRST_SCREEN_MENU_BTN);
			settingScreenMainClickOnTab(androidClientDriver, "Contacts");
			Thread.sleep(2000);
			while (selenium.isElementExisted(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_NAME_IN_CONTACT_GROUP(groupName, "1"))) {
				String nameContact = selenium.getAttribute(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_NAME_IN_CONTACT_GROUP(groupName, "1"), "text");
				if (!nameContact.equals("No Contacts In Group")) {
				removingContactOfContactGroup(androidClientDriver, groupName, nameContact);
				} else break;
			}	
		} 
		catch (Exception exception) {
			// TODO: handle exception
			logger.error("removeAllContactOfContactGroup - Failed with Exception: " + exception + "...\n");
			throw new Exception("removeAllContactOfContactGroup - Failed - Exception occurs: " + exception);
		}
		logger.info("RemovingContactOfContactGroup - Completed...\n");
	}
	
	public boolean verifyGroupExistAfterRemoveAllContact(AndroidDriver androidClientDriver, String groupName) throws Exception{
		logger.info("verifyGroupExistAfterRemoveAllContact - Starting...\n");
		boolean flag = false;
		try {
			Thread.sleep(2000);
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.FIRST_SCREEN_MENU_BTN);
			selenium.clickElement(androidClientDriver, androidClient.FIRST_SCREEN_MENU_BTN);
			settingScreenMainClickOnTab(androidClientDriver, "Contacts");
			String emptyContact = selenium.getAttribute(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_NAME_IN_CONTACT_GROUP(groupName, "1"), "text");
			if (emptyContact.equals("No Contact In Groups")) flag = true;
			
		} catch (Exception exception) {
			// TODO: handle exception
			logger.error("removeAllContactOfContactGroup - Failed with Exception: " + exception + "...\n");
			throw new Exception("removeAllContactOfContactGroup - Failed - Exception occurs: " + exception);
		}
		logger.info("RemovingContactOfContactGroup - Completed...\n");
		return flag;
	}
	
	public void makeAudioCallToGroup(AndroidDriver androidClientDriver, String groupName) throws Exception {
		logger.info("VerifyCanMakeAudioCallToGroup - Starting...\n");
		try {
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.FIRST_SCREEN_MENU_BTN);
			selenium.clickElement(androidClientDriver, androidClient.FIRST_SCREEN_MENU_BTN);
			settingScreenMainClickOnTab(androidClientDriver, "Contacts");
			selenium.longPress(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_GROUPS_NAME(groupName));
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_GROUPS_NAME_CALL_VOICE_BTN);
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_GROUPS_NAME_CALL_VOICE_BTN);
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_GROUPS_SELECTION_HEADER_ACTION_CALL_BTN);
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_GROUPS_SELECTION_HEADER_ACTION_CALL_BTN);
			Thread.sleep(3000);
			
		} catch (Exception exception) {
			// TODO: handle exception
			logger.error("VerifyCanMakeAudioCallToGroup - Failed with Exception: " + exception + "...\n");
			throw new Exception("VerifyCanMakeAudioCallToGroup - Failed - Exception occurs: " + exception);
		}
		logger.info("VerifyCanMakeAudioCallToGroup - Completed...\n");
	}
	
	public void makeVideoCallToGroup(AndroidDriver androidClientDriver, String groupName) throws Exception {
		logger.info("VerifyCanMakeVideoCallToGroup - Starting...\n");
		try {
			Thread.sleep(2000);
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.FIRST_SCREEN_MENU_BTN);
			selenium.clickElement(androidClientDriver, androidClient.FIRST_SCREEN_MENU_BTN);
			settingScreenMainClickOnTab(androidClientDriver, "Contacts");
			selenium.longPress(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_GROUPS_NAME(groupName));
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_GROUPS_NAME_CALL_VIDEO_BTN);
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_GROUPS_NAME_CALL_VIDEO_BTN);
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_GROUPS_SELECTION_HEADER_ACTION_CALL_BTN);
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_GROUPS_SELECTION_HEADER_ACTION_CALL_BTN);
			Thread.sleep(3000);
			
		} catch (Exception exception) {
			// TODO: handle exception
			logger.error("VerifyCanMakeVideoCallToGroup - Failed with Exception: " + exception + "...\n");
			throw new Exception("VerifyCanMakeVideoCallToGroup - Failed - Exception occurs: " + exception);
		}
		logger.info("VerifyCanMakeVideoCallToGroup - Completed...\n");
	}
	
	public String addExistingContactToMultipleGroups(AndroidDriver androidClientDriver) throws Exception {
		logger.info("verifyCanAddedContactToMultipleGroups - Starting...\n");
		String nameOfFirstContact = null;
		try {
			// get first contact of first group and add to other group
			Thread.sleep(2000);
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.FIRST_SCREEN_MENU_BTN);
			selenium.clickElement(androidClientDriver, androidClient.FIRST_SCREEN_MENU_BTN);
			settingScreenMainClickOnTab(androidClientDriver, "Contacts");
			String string1 = selenium.getAttribute(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_GROUPS_TITLE_BAR, "text");
			String number = string1.replaceAll("[^0-9]", "");
			int numberOfgroups = Integer.parseInt(number);
			String nameOfFirstGroups = selenium.getAttribute(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_GROUPS("1"), "text");
			nameOfFirstContact = selenium.getAttribute(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_NAME_IN_CONTACT_GROUP(nameOfFirstGroups,"1"), "text");
			for (int i = 1; i <= numberOfgroups; i++) {
				
				String order = ""+ i;
//				selenium.scrollToElement(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_GROUPS(order));
				String nameOfGroup = selenium.getAttribute(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_GROUPS(order),"text");
				if (!(verifyContactNameIsExistedContactGroup(androidClientDriver, nameOfGroup, nameOfFirstContact))) {
					addContactfromAllContactListtoExistingGroup(androidClientDriver, nameOfGroup, nameOfFirstContact);
				}
			}
					
		} catch (Exception exception) {
			// TODO: handle exception
			logger.error("VerifyCanMakeVideoCallToGroup - Failed with Exception: " + exception + "...\n");
			throw new Exception("VerifyCanMakeVideoCallToGroup - Failed - Exception occurs: " + exception);
		}
		logger.info("verifyCanAddedContactToMultipleGroups - Completed...\n");
		return nameOfFirstContact;
	}
	
	public boolean verifyContactNameExistedAllContactGroups(AndroidDriver androidClientDriver, String ContactName)throws Exception {
		boolean flag = false;
		try {
			logger.info("verifyContactExistinAllContactGroups - starting");
			Thread.sleep(2000);
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.FIRST_SCREEN_MENU_BTN);
			selenium.clickElement(androidClientDriver, androidClient.FIRST_SCREEN_MENU_BTN);
			settingScreenMainClickOnTab(androidClientDriver, "Contacts");
			String string1 = selenium.getAttribute(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_GROUPS_TITLE_BAR, "text");
			String number = string1.replaceAll("[^0-9]", "");
			int numberOfgroups = Integer.parseInt(number);
			for (int i = 1; i <= numberOfgroups; i++) {
				
				String order = ""+ i;
//				selenium.scrollToElement(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_GROUPS(order));
				String nameOfGroup = selenium.getAttribute(androidClientDriver, androidClient.CONTACT_DETAILS_SCREEN_CONTACT_GROUPS(order),"text");
				if (verifyContactNameIsExistedContactGroup(androidClientDriver, nameOfGroup, ContactName)) {flag = true;}
				else {flag = false;}
			}
		} catch (Exception exception) {
			// TODO: handle exception
			logger.error("verifyContactExistinAllContactGroups - Failed with Exception: " + exception + "...\n");

			throw new Exception("verifyContactExistinAllContactGroups - Failed - Exception occurs: " + exception);
		}
		return flag;
	}
	
	public String addContactfromAllContactListtoExistingGroup(AndroidDriver androidClientDriver, String groupName, String ContactName) throws Exception{
		String addContact = null;
		try {
			logger.info("editContactGroupName - starting");
			chooseContactGroupMoreActions(androidClientDriver, groupName, "Add Contact to Group");	
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_GROUP_WINDOW_CHOOSE_CONTACTS_CHECKBOX_BY_NAME(ContactName));
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.CONTACT_GROUP_WINDOW_NEXT_BTN);
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_GROUP_WINDOW_NEXT_BTN);
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.CONTACT_GROUP_WINDOW_DONE_BTN);
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_GROUP_WINDOW_DONE_BTN);
			

		} catch (Exception exception) {
			logger.error("addEquinoxContacttoGroup - Failed with Exception: " + exception + "...\n");

			throw new Exception("addEquinoxContacttoGroup - Failed - Exception occurs: " + exception);
		}
		return addContact;
    }

}
