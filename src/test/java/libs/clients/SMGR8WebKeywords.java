package libs.clients;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import libs.common.DriverManagement;
import libs.common.Selenium;

public class SMGR8WebKeywords {
	
	WebDriver webDriver;
	Selenium selenium = new Selenium();
//	AMMTestData ammData = new AMMTestData();
	SMGR8WebLocators SMGRWeb = new SMGR8WebLocators();
	int timeout = 300;
	final static Logger logger = LogManager.getLogger("SMGRWebKeywords");
	DriverManagement driverMgnt = new DriverManagement();
	
	public void addContactSearchUserByFirstName(WebDriver webDriver, String user) throws Exception{
		logger.info("addContactSearchUserByFirstName - starting...\n");
		try {
			Thread.sleep(15000);

			//selenium.waitUntilElementClickable(webDriver, SMGRWeb.SMGR8_USER_MANAGEMENT_PAGE_FIRST_NAME_FILTER_BTN);
			Actions action = new Actions(webDriver);
			action.click(webDriver.findElement(By.xpath("//span[text()='First Name']//i[@class='anticon anticon-filter']/.."))).perform();
			//selenium.clickElement(webDriver, SMGRWeb.SMGR8_USER_MANAGEMENT_PAGE_FIRST_NAME_FILTER_BTN);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.SMGR8_USER_INFORMATION_ADD_POPUP_FIRSTNAME_FILTER);
			selenium.clickElement(webDriver, SMGRWeb.SMGR8_USER_INFORMATION_ADD_POPUP_FIRSTNAME_FILTER);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.SMGR8_USER_MANAGEMENT_PAGE_FIRST_NAME_FILTER_INPUT_TXT);
			selenium.inputText(webDriver, SMGRWeb.SMGR8_USER_MANAGEMENT_PAGE_FIRST_NAME_FILTER_INPUT_TXT, user);
			Thread.sleep(3000);
			selenium.enter(webDriver);
			selenium.enter(webDriver);
//			selenium.waitUntilElementClickable(webDriver, SMGRWeb.SMGR8_USER_MANAGEMENT_ADD_POPUP_PAGE_REFRESH_BTN);
//			selenium.clickElement(webDriver, SMGRWeb.SMGR8_USER_MANAGEMENT_ADD_POPUP_PAGE_REFRESH_BTN);
		} catch (Exception exception) { 
			driverMgnt.setFailedWinClientDriver(webDriver);
			logger.error("addContactSearchUserByFirstName - Failed with Exception: " + exception + "...\n");
			throw new Exception("addContactSearchUserByFirstName - Failed - Exception occurs: " + exception);
		}
		logger.info("addContactSearchUserByFirstName - completed...\n");			
	}

	public void loginSMGRMainPage(WebDriver webDriver, String user, String password) throws Exception{
		logger.info("LoginSMGRMainPage - starting...\n");
		try {
//			Thread.sleep(5000);
//			selenium.waitUntilElementClickable(webDriver, SMGRWeb.SMGR8_LOGIN_PAGE_USERNAME_TXT, 2000);
//			selenium.inputText(webDriver, SMGRWeb.SMGR8_LOGIN_PAGE_USERNAME_TXT, user);
//			selenium.waitUntilElementClickable(webDriver, SMGRWeb.SMGR8_LOGIN_PAGE_PASSWORD_TXT, 200);
//			selenium.inputText(webDriver, SMGRWeb.SMGR8_LOGIN_PAGE_PASSWORD_TXT, password);
//			Thread.sleep(2000);
//			selenium.waitUntilElementClickable(webDriver, SMGRWeb.SMGR8_LOGIN_PAGE_SUBMIT_BTN, 200);
//			selenium.clickElement(webDriver, SMGRWeb.SMGR8_LOGIN_PAGE_SUBMIT_BTN);
//			Thread.sleep(20000);	
			Thread.sleep(5000);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.LOGIN_PAGE_USERNAME_TXT);
			selenium.inputText(webDriver, SMGRWeb.LOGIN_PAGE_USERNAME_TXT, user);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.LOGIN_PAGE_PASSWORD_TXT);
			selenium.inputText(webDriver, SMGRWeb.LOGIN_PAGE_PASSWORD_TXT, password);
			Thread.sleep(2000);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.LOGIN_PAGE_SUBMIT_BTN);
			selenium.clickElement(webDriver, SMGRWeb.LOGIN_PAGE_SUBMIT_BTN);
			Thread.sleep(7000);	
			selenium.setZoomSize(webDriver);
			Thread.sleep(20000);
			if(selenium.isElementExisted(webDriver, SMGRWeb.SMGR8_LICENSE_ERROR_ESCAPE_BTN)) 
				selenium.clickElement(webDriver, SMGRWeb.SMGR8_LICENSE_ERROR_ESCAPE_BTN);
		} catch (Exception exception) { driverMgnt.setFailedWinClientDriver(webDriver);
			logger.error("LoginSMGRMainPage - Failed with Exception: " + exception + "...\n");
			throw new Exception("LoginSMGRMainPage - Failed - Exception occurs: " + exception);
		}
		logger.info("LoginSMGRMainPage - completed...\n");			
    }
	
	public void navigatetoUserManagement(WebDriver webDriver) throws Exception{
		logger.info("NavigatetoUSerManagement - starting...\n");
		try {
			Thread.sleep(2000);
			//selenium.waitUntilElementClickable(webDriver, SMGRWeb.SMGR8_MAINPAGE_USERS_DROPDOWN_BTN);
			selenium.mouseHover(webDriver, SMGRWeb.SMGR8_MAINPAGE_USERS_DROPDOWN_BTN);
			Thread.sleep(500);
			//selenium.waitUntilElementClickable(webDriver, SMGRWeb.SMGR8_MAINPAGE_USERS_MENU_USER_MANAGEMENT_BTN);
			selenium.mouseHover(webDriver, SMGRWeb.SMGR8_MAINPAGE_USERS_MENU_USER_MANAGEMENT_BTN);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.SMGR8_MAINPAGE_USERS_MENU_SUBMENU_MANAGE_USER_BTN);
			selenium.clickElement(webDriver, SMGRWeb.SMGR8_MAINPAGE_USERS_MENU_SUBMENU_MANAGE_USER_BTN);
			Thread.sleep(4000);
			selenium.switchToFrame(webDriver, SMGRWeb.SMGR8_USER_MANAGEMENT_PAGE_IFRAME);
		} catch (Exception exception) { driverMgnt.setFailedWinClientDriver(webDriver);
			logger.error("NavigatetoUSerManagement - Failed with Exception: " + exception + "...\n");
			throw new Exception("NavigatetoUSerManagement - Failed - Exception occurs: " + exception);
		}
		logger.info("NavigatetoUSerManagement - completed...\n");			
    }
	
	public void manageUserPageActionUser(WebDriver webDriver, String action) throws Exception{
		logger.info("manageUserPageActionUser - starting...\n");
		try {
			Thread.sleep(2000);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.SMGR8_USER_MANAGEMENT_PAGE_SELECT_USER_BTN);
			if (selenium.isElementSelected(webDriver, SMGRWeb.SMGR8_USER_MANAGEMENT_PAGE_SELECT_USER_BTN)==false)
			{
				selenium.clickElement(webDriver, SMGRWeb.SMGR8_USER_MANAGEMENT_PAGE_SELECT_USER_BTN);
			}
			Thread.sleep(3200);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.smgr8_userManagePageActionbuttonLocators(action));
			selenium.clickElement(webDriver, SMGRWeb.smgr8_userManagePageActionbuttonLocators(action));
		} catch (Exception exception) { driverMgnt.setFailedWinClientDriver(webDriver);
			logger.error("manageUserPageActionUser - Failed with Exception: " + exception + "...\n");
			throw new Exception("manageUserPageActionUser - Failed - Exception occurs: " + exception);
		}
		logger.info("manageUserPageActionUser - completed...\n");			
    }
	
	public void manageUserSearchUserBySipPhone(WebDriver webDriver, String sip) throws Exception{
		logger.info("ManageUserSearchUserBySipPhone - starting...\n");
		try {
			//selenium.switchToFrame(webDriver, SMGRWeb.SMGR8_USER_MANAGEMENT_PAGE_IFRAME);
			Thread.sleep(2000);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.SMGR8_USER_MANAGEMENT_PAGE_SIP_HANDLE_FILTER_BTN);
			selenium.clickElement(webDriver, SMGRWeb.SMGR8_USER_MANAGEMENT_PAGE_SIP_HANDLE_FILTER_BTN);
			Thread.sleep(2000);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.SMGR8_USER_MANAGEMENT_PAGE_SIP_HANDLE_FILTER_INPUT_TXT);
			selenium.inputText(webDriver, SMGRWeb.SMGR8_USER_MANAGEMENT_PAGE_SIP_HANDLE_FILTER_INPUT_TXT, sip);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.SMGR8_USER_MANAGEMENT_PAGE_REFRESH_BTN);
			selenium.clickElement(webDriver, SMGRWeb.SMGR8_USER_MANAGEMENT_PAGE_REFRESH_BTN);
		} catch (Exception exception) { driverMgnt.setFailedWinClientDriver(webDriver);
			logger.error("ManageUserSearchUserBySipPhone - Failed with Exception: " + exception + "...\n");
			throw new Exception("ManageUserSearchUserBySipPhone - Failed - Exception occurs: " + exception);
		}
		logger.info("ManageUserSearchUserBySipPhone - completed...\n");			
    }
	
	public boolean verifyIfContactisExsitedInContactList(WebDriver webDriver, String user) throws Exception{
		logger.info("verifyIfContactisExsitedInContactList - starting...\n");
		boolean s= false;
		try {
			if (selenium.isElementExisted(webDriver, SMGRWeb.smgr8_userInformationContactsTabRemoveContactCheckboxLocator(user)))
			{
				s = true;
			}
			else s= false;
			
		} catch (Exception exception) { driverMgnt.setFailedWinClientDriver(webDriver);
			logger.error("verifyIfContactisExsitedInContactList - Failed with Exception: " + exception + "...\n");
			throw new Exception("verifyIfContactisExsitedInContactList - Failed - Exception occurs: " + exception);
		}
		logger.info("verifyIfContactisExsitedInContactList - completed...\n");	
		return s;
    }
	
	public void navigatetoContactTabAndSearchContacts(WebDriver webDriver, String searchString) throws Exception{
		logger.info("navigatetoContactTabAndSearchContacts - starting...\n");
		boolean s= false;
		try {
			Thread.sleep(10000);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.SMGR8_USER_INFORMATION_CONTACTS_TAB);
			selenium.clickElement(webDriver, SMGRWeb.SMGR8_USER_INFORMATION_CONTACTS_TAB);
			Thread.sleep(5000);
			removeContactSearchUserByFirstName(webDriver, searchString);
		} catch (Exception exception) { driverMgnt.setFailedWinClientDriver(webDriver);
			logger.error("navigatetoContactTabAndSearchContacts - Failed with Exception: " + exception + "...\n");
			throw new Exception("navigatetoContactTabAndSearchContacts - Failed - Exception occurs: " + exception);
		}
		logger.info("navigatetoContactTabAndSearchContacts - completed...\n");	
	}
	
	public void removeContactSearchUserByFirstName(WebDriver webDriver, String user) throws Exception{
		logger.info("ManageUserSearchUserBySipPhone - starting...\n");
		try {
			Thread.sleep(15000);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.SMGR8_USER_MANAGEMENT_PAGE_FIRST_NAME_FILTER_BTN);
			selenium.clickElement(webDriver, SMGRWeb.SMGR8_USER_MANAGEMENT_PAGE_FIRST_NAME_FILTER_BTN);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.SMGR8_USER_MANAGEMENT_PAGE_FIRST_NAME_FILTER_INPUT_TXT);
			selenium.inputText(webDriver, SMGRWeb.SMGR8_USER_MANAGEMENT_PAGE_FIRST_NAME_FILTER_INPUT_TXT, user);
			Thread.sleep(3000);
			selenium.enter(webDriver);
			selenium.enter(webDriver);
		} catch (Exception exception) { driverMgnt.setFailedWinClientDriver(webDriver);
			logger.error("ManageUserSearchUserBySipPhone - Failed with Exception: " + exception + "...\n");
			throw new Exception("ManageUserSearchUserBySipPhone - Failed - Exception occurs: " + exception);
		}
		logger.info("ManageUserSearchUserBySipPhone - completed...\n");			
    }
	
	public void editUserAddNewContact(WebDriver webDriver, String user) throws Exception{
		logger.info("editUserAddNewContact - starting...\n");
		try {
			Thread.sleep(5000);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.SMGR8_USER_INFORMATION_CONTACTS_TAB);
			selenium.clickElement(webDriver, SMGRWeb.SMGR8_USER_INFORMATION_CONTACTS_TAB);
			Thread.sleep(2000);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.SMGR8_USER_INFORMATION_CONTACTS_TAB_ADD_BTN);
			selenium.clickElement(webDriver, SMGRWeb.SMGR8_USER_INFORMATION_CONTACTS_TAB_ADD_BTN);
			Thread.sleep(2000);
			addContactSearchUserByFirstName(webDriver, user);
			Thread.sleep(2000);
			logger.info("Searched User by First name");
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.SMGR8_USER_MANAGEMENT_ADD_POPUP_PAGE_SELECT_USER_BTN);
			selenium.clickElement(webDriver, SMGRWeb.SMGR8_USER_MANAGEMENT_ADD_POPUP_PAGE_SELECT_USER_BTN);
			Thread.sleep(2000);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.SMGR8_USER_MANAGEMENT_ADD_POPUP_PAGE_OK_BTN);
			selenium.clickElement(webDriver, SMGRWeb.SMGR8_USER_MANAGEMENT_ADD_POPUP_PAGE_OK_BTN);
			Thread.sleep(3000);
//			selenium.scrollToElement(webDriver, SMGRWeb.SMGR8_USER_MANAGEMENT_PAGE_COMMIT_BTN);
//			selenium.waitUntilElementClickable(webDriver, SMGRWeb.SMGR8_USER_MANAGEMENT_PAGE_COMMIT_BTN);
			logger.info("Finished Add Conatct User by First name");
			selenium.clickElement(webDriver, SMGRWeb.SMGR8_USER_MANAGEMENT_PAGE_COMMIT_BTN);
			Thread.sleep(10000);
			logger.info("Commit successfull");
		//	selenium.elementShouldExisted(webDriver, SMGRWeb.USER_MANAGEMENT_PAGE_STATUS_SUCESSFULLY_TXT);
			
		} catch (Exception exception) { driverMgnt.setFailedWinClientDriver(webDriver);
			logger.error("editUserAddNewContact - Failed with Exception: " + exception + "...\n");
			throw new Exception("editUserAddNewContact - Failed - Exception occurs: " + exception);
		}
		logger.info("editUserAddNewContact - completed...\n");			
    }
	
	public void editUserRemoveContact(WebDriver webDriver, String user) throws Exception{
		logger.info("manageUserPageActionUser - starting...\n");
		try {
			
			Thread.sleep(8000);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.USER_INFORMATION_CONTACTS_TAB);
			selenium.clickElement(webDriver, SMGRWeb.USER_INFORMATION_CONTACTS_TAB);
			Thread.sleep(5000);
			removeContactSearchUserByLastName(webDriver, user);
			Thread.sleep(8000);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.userInformationContactsTabRemoveContactCheckboxLocator(user));
			selenium.clickElement(webDriver, SMGRWeb.userInformationContactsTabRemoveContactCheckboxLocator(user));
			Thread.sleep(8000);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.USER_INFORMATION_CONTACTS_TAB_REMOVE_BTN);
			selenium.clickElement(webDriver, SMGRWeb.USER_INFORMATION_CONTACTS_TAB_REMOVE_BTN);
			selenium.clickElement(webDriver, SMGRWeb.USER_INFORMATION_CONTACTS_TAB_REMOVE_BTN);
			Thread.sleep(10000);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.EDIT_USER_PAGE_COMMIT_BTN);
			selenium.clickElement(webDriver, SMGRWeb.EDIT_USER_PAGE_COMMIT_BTN);
			Thread.sleep(10000);
			selenium.elementShouldExisted(webDriver, SMGRWeb.USER_MANAGEMENT_PAGE_STATUS_SUCESSFULLY_TXT);
			
		} catch (Exception exception) { driverMgnt.setFailedWinClientDriver(webDriver);
			logger.error("manageUserPageActionUser - Failed with Exception: " + exception + "...\n");
			throw new Exception("manageUserPageActionUser - Failed - Exception occurs: " + exception);
		}
		logger.info("manageUserPageActionUser - completed...\n");			
    }
	
	public void removeContactSearchUserByLastName(WebDriver webDriver, String user) throws Exception{
		logger.info("removeContactSearchUserByLastName - starting...\n");
		try {
			Thread.sleep(15000);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.USER_MANAGEMENT_PAGE_FILTER_ENABLE_BTN);
			selenium.clickElement(webDriver, SMGRWeb.USER_MANAGEMENT_PAGE_FILTER_ENABLE_BTN);
			Thread.sleep(10000);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.userSearchFilteringTxt("Last Name"));
			selenium.inputText(webDriver, SMGRWeb.userSearchFilteringTxt("Last Name"), user);
//			selenium.waitUntilElementClickable(webDriver, SMGRWeb.userSearchFilteringTxt("First Name"), 8000);
//			selenium.inputText(webDriver, SMGRWeb.userSearchFilteringTxt("First Name"), user);
			selenium.waitUntilElementClickable(webDriver, SMGRWeb.USER_MANAGEMENT_PAGE_APPLY_FILTER_BTN);
			selenium.clickElement(webDriver, SMGRWeb.USER_MANAGEMENT_PAGE_APPLY_FILTER_BTN);
		} catch (Exception exception) { driverMgnt.setFailedWinClientDriver(webDriver);
			logger.error("ManageUserSearchUserBySipPhone - Failed with Exception: " + exception + "...\n");
			throw new Exception("ManageUserSearchUserBySipPhone - Failed - Exception occurs: " + exception);
		}
		logger.info("ManageUserSearchUserBySipPhone - completed...\n");			
    }
	
	
}
