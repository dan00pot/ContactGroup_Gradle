package libs.clients;

import org.openqa.selenium.By;

public class AndroidClientLocators {
	
	// ###########################################################################################################################
	// ########################################LOCATOR OF ELEMENTS IN FIRST
	// SCREEN WHEN LAUNCHING ANDROID CLIENT##################
	// ###########################################################################################################################
	public By FIRST_SCREEN_MENU_BTN = By
			.xpath("//android.widget.ImageButton[contains(@content-desc,'Open Navigation Drawer')]");
	
	// ###########################################################################################################################
	// ########################################LOCATOR OF ELEMENTS IN SETTING
	// SCREEN##############################################
	// ###########################################################################################################################
	public By settingScreenTabLocators(String tabName) {
		return By.xpath("//android.widget.TextView[contains(@text,'" + tabName
				+ "')]");
	};
//	public By SERVICES_DETAILS_BTN(String status) {
//		return By.xpath("//android.widget.Switch[contains(@text,'" + status
//				+ "')]");
//	}
	
	public By SERVICES_DETAILS_BTN = By
			.id("android:id/checkbox");	
	
	
	public By HEADER_SETTING_BTN = By
			.xpath("//android.widget.ImageButton[@content-desc=\'Settings\']");
	
	// ###########################################################################################################################
	// ########################################LOCATOR OF ELEMENTS IN DEVICE SERVICES
	// SCREEN##############################################
	// ###########################################################################################################################
	public By DEVICE_SERVICES_SIGNOUT_BTN = By
			.id("android:id/button1");	
	public By STATUS_DEVICE_SERVICES_BTN = By
			.id("com.avaya.android.flare:id/acs_login_enabled");
	
	// ###########################################################################################################################
	// ################################LOCATOR OF ELEMENTS CONTACT WINDOWS
	// DETAIL SCREEN##########################################
	// ###########################################################################################################################
	public By CONTACT_TAB_SCREEN_ADD_CONTACT_BTN = By
			.id("com.avaya.android.flare:id/contactsActionButton");
	
	public By CONTACT_TAB_SCREEN_ADD_CONTACT_CONTACT_GROUP_BTN = By
			.xpath("//android.widget.TextView[@text = 'New Contact Group']");
	
	public By addScreenTabLocators(String tabName) {
		return By.xpath("//android.widget.TextView[contains(@text,'" + tabName
				+ "')]");
	}
	
	// ###########################################################################################################################
	// ################################LOCATOR OF ELEMENTS CONTACT WINDOWS
	// DETAIL SCREEN##########################################
	// ###########################################################################################################################
	
//	public By CONTACT_GROUP_WINDOW_CHOOSE_CONTACTS_CHECKBOX(int number) {
//		return By.xpath("//android.widget.RelativeLayout["+number+"]/android.widget.CheckBox");
//	}
	
	public By CONTACT_SEARCH_USER_EDIT_TEXT = By .id("com.avaya.android.flare:id/unifiedContactsSearchEditText");
	
	public By contactScreenTabLocators(String tabName) {
		return By.xpath("//android.widget.TextView[contains(@text,'" + tabName+ "')]");
	};
	
	public By CONTACT_GROUP_ENTER_GROUP_NAME_TXT = By.xpath("//*[@resource-id='com.avaya.android.flare:id/input']");
	
	public By CONTACT_GROUP_ENTER_GROUP_NAME_OK_BTN = By.xpath("//android.widget.Button[@text='OK']");
	
	public By CONTACT_GROUP_ADD_ENTERPRISE_CONTACT_OK_BTN = By.xpath("//android.widget.TextView[@text='OK']");
	
//	public By CONTACT_GROUP_ADD_ENTERPRISE_CONTACT_DONE_BTN= By.xpath("//*android.widget.Button[@text='DONE']");
	
	public By CONTACT_GROUP_ADD_ENTERPRISE_CONTACT_DONE_BTN= By.id("com.avaya.android.flare:id/unifiedContactsSearchCancel");
	
	public By CONTACT_GROUP_WINDOW_CHOOSE_ENTERPRISE_CONTACTS_CHECKBOX(int number) {
		return By.xpath("//android.widget.TextView[contains(@text,'Enterprise Directory')]/../following-sibling::android.widget.FrameLayout[" +number+"]//android.widget.CheckBox");
//		return By.xpath("//android.widget.TextView[contains(@text,'Enterprise Directory')]/parent::android.widget.LinearLayout//following-sibling::android.widget.FrameLayout[" +number+"]//descendant::android.widget.RelativeLayout/android.widget.CheckBox");
//		return By.xpath("//android.widget.TextView[contains(@text,'"+group+"')]/../following-sibling::android.widget.RelativeLayout["+order+"]//android.widget.TextView");
	}
	
	public By CONTACT_GROUP_WINDOW_CHOOSE_ENTERPRISE_CONTACTS_NAME(int number) {
//		return By.xpath("//android.widget.TextView[contains(@text,'Enterprise Directory')]/parent::android.widget.LinearLayout//following-sibling::android.widget.FrameLayout["+number+"]//descendant::android.widget.LinearLayout/android.widget.TextView");
		return By.xpath("//android.widget.TextView[contains(@text,'Enterprise Directory')]/../following-sibling::android.widget.FrameLayout["+number+"]//android.widget.TextView");
	}
	
	
	public By CONTACT_GROUP_WINDOW_CHOOSE_CONTACTS_CHECKBOX(int number) {
		return By.xpath("//android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout[" + number + "]/android.widget.CheckBox[1]");
	}
	
	public By CONTACT_GROUP_WINDOW_CHOOSE_CONTACTS_CHECKBOX_BY_NAME(String ContactName) {
		return By.xpath("//android.widget.TextView[contains(@text,'" + ContactName + "')]/../following-sibling::android.widget.CheckBox[1]");
	}
	
	public By CONTACT_GROUP_WINDOW_CHOOSE_CONTACTS_NAME_TXT(int number) {
		return By.xpath("//android.widget.RelativeLayout["+number+"]//android.widget.TextView");
	}
	
	public By CONTACT_GROUP_NAME_NEXT_BTN(String groupName) {
		return By.xpath("//android.widget.TextView[contains(@text,'" + groupName+ "')]");
	}
	
	public By EDIT_GROUP_NAME_BTN = By.xpath("//android.widget.TextView[@text = 'Edit Group Name']");
	
	public By CONTACT_GROUP_WINDOW_NEXT_BTN = By.xpath("//*[@resource-id='com.avaya.android.flare:id/tv_contact_picker_header_action']");
	
	public By CONTACT_GROUP_WINDOW_DONE_BTN = By.xpath("//*[@resource-id='com.avaya.android.flare:id/tv_contact_group_selection_header_action']");
	
//	public By CONTACT_GROUP_ENTER_GROUP_NAME_OK_BTN = By.xpath("//*[@resource-id='android:id/button1']");
	public By CONTACT_GROUP_CONFIRM_REMOVE_BTN = By.xpath("//android.widget.Button[@text='REMOVE GROUP']");
	
	public By CONTACT_GROUP_FILTER_BTN = By.xpath("//android.widget.Spinner/android.widget.ImageView");
	
	public By CONTACT_GROUP_VERIFY_CONTENT_FILTER_BUTTON(int number) {
		//return By.xpath("//android.widget.ListView/android.widget.TextView["+ number +"]");
//		return By.xpath("//android.widget.ListView/android.widget.TextView["+number+"]");
		return By.xpath("//android.widget.ListView/android.widget.TextView");
		//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.ListView[1]/android.widget.TextView[1]
	}
	
	public By CONTACT_DETAIL_REMOVE_CONTACT_FROM_GROUP_BY_X_BTN(String groupName) {
		return By.xpath("//android.widget.TextView[@text='" +groupName+ "']//following-sibling::android.widget.ImageButton");
	}
	
	public By CONTACR_DETAIL_REMOVE_CONTACT_FROM_GROUP_REMOVE_CONFIRM_BTN = By.xpath("//android.widget.Button[@text='REMOVE CONTACT']");
	
	public By CONTACT_DETAiLS_SCREEN_CONTACT_DETAILS_BACK_BTN = By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
	
	// ###########################################################################################################################
	// ################################LOCATOR OF ELEMENTS CONTACT DETAIL
	// SCREEN##################################################
	// ###########################################################################################################################
	public By CONTACT_DETAILS_SCREEN_CONTACT_GROUPS_TITLE_BAR = By.xpath("//android.widget.TextView[contains(@text,'Contact Groups')]");
	
	public By CONTACT_DETAILS_SCREEN_LIST_HEADER_TITLE_BAR = By.xpath("//android.widget.TextView[contains(@text,'All Contacts')]");
	
//	public By CONTACT_GROUP_MEMBERS_DISPLAY_BTN = By.xpath("//android.widget.TextView[contains(@text,'reloginGroup')]/parent::*//following-sibling::android.widget.RelativeLayout");
	
	public By PROFILE_AVATA_BTN = By.id("com.avaya.android.flare:id/profile_avatar");
	
	public By USER_SIGN_OUT_BTN = By.xpath("//android.widget.TextView[contains(@text,'Sign Out')]");
	
	public By USER_SIGN_IN_BTN = By.id("com.avaya.android.flare:id/btnSignIn");
	
//	public By CONTACT_GROUP_DISPLAY_NAME_BTN = By.xpath("//android.widget.TextView[contains(@text,'reloginGroup')]");
	public By CONTACT_GROUP_DISPLAY_NAME_BTN(String groupName) {
		return By.xpath("//android.widget.TextView[contains(@text,'"+groupName+"')]");	
	}
	
	public By CONTACT_GROUP_MEMBERS_DISPLAY_BTN(String groupName) {
		return By.xpath("//android.widget.TextView[contains(@text,'"+groupName+"')]/parent::*//following-sibling::android.widget.RelativeLayout");
	}
	
	public By countContactOfButton(String tabName) {
		return By.xpath("//android.widget.TextView[contains(@text,'" + tabName
				+ "')]");}
	
	public By CONTACT_DETAILS_SCREEN_CONTACT_GROUPS(String order) {
		return By.xpath("//android.widget.TextView[contains(@text,'Contact Groups')]/following-sibling::android.view.ViewGroup["+order+"]/android.widget.TextView");
	}
	
	public By CONTACT_DETAILS_SCREEN_CONTACT_GROUPS_BY_ORDER(int order) {
		return By.xpath("//android.widget.TextView[contains(@text,'Contact Groups')]/following-sibling::android.view.ViewGroup["+order+"]/android.widget.TextView");
	}
	
	public By CONTACT_DETAILS_SCREEN_CONTACT_GROUPS_NAME(String name) {
		return By.xpath("//android.widget.TextView[contains(@text,'"+name+"')]");
	}
	public By CONTACT_DETAILS_SCREEN_CONTACT_GROUPS_NAME_MORE_ACTIONS_OPTION(String option) {
		return By.xpath("//android.widget.TextView[@text = '" + option + "']");
	}
	
	public By CONTACT_DETAILS_SCREEN_CONTACT_GROUPS_NAME_MORE_ACTIONS_BTN = By.xpath("//*[@resource-id='com.avaya.android.flare:id/contact_list_group_more_actions']");
	
	public By CONTACT_DETAILS_SCREEN_CONTACT_GROUPS_NAME_CALL_VOICE_BTN = By.xpath("//*[@resource-id='com.avaya.android.flare:id/contact_list_group_call_voice']");
	
	public By CONTACT_DETAILS_SCREEN_CONTACT_GROUPS_NAME_CALL_VIDEO_BTN = By.xpath("//*[@resource-id='com.avaya.android.flare:id/contact_list_group_call_video']");
	
	
	public By CONTACT_DETAILS_SCREEN_CONTACT_GROUPS_NAME_CONVERSATION_BTN = By.xpath("//*[@resource-id='com.avaya.android.flare:id/contact_list_group__message']");
	
	public By CONTACT_DETAILS_SCREEN_CONTACT_GROUPS_SELECTION_HEADER_ACTION_CALL_BTN = By.xpath("//android.widget.TextView[contains(@text,'Call')]");
	
	public By CONTACT_DETAILS_SCREEN_CONTACT_NAME_IN_CONTACT_GROUP(String group, String order) {
		return By.xpath("//android.widget.TextView[contains(@text,'"+group+"')]/../following-sibling::android.widget.RelativeLayout["+order+"]//android.widget.TextView");
	}
	
	public By CONTACT_DETAILS_SCREEN_FAVORITE_CONTACT_NAME_IN_CONTACT_GROUP(String group, String order) {
		return By.xpath("//android.widget.TextView[contains(@text,'"+group+"')]/../following-sibling::android.widget.RelativeLayout["+order+"]/android.widget.ImageView");
	}
	
	public By CONTACT_DETAILS_SCREEN_CONTACT_NAME_IN_ALL_CONTACT_LIST (String order) {
		return By.xpath("//android.widget.TextView[contains(@text,'All Contacts')]//following-sibling::android.widget.RelativeLayout["+order+"]//android.widget.TextView");
	};
	
	public By CONTACT_DETAILS_SCREEN_FAVORITE_CONTACT_NAME_IN_ALL_CONTACT_LIST (String order) {
		return By.xpath("//android.widget.TextView[contains(@text,'All Contacts')]//following-sibling::android.widget.RelativeLayout["+order+"]/android.widget.ImageView");
	};
	
	public By CONTACT_DETAIL_SCREEN_NAME_IN_ALL_CONTACT_LIST (String order) {
		return By.xpath("");
	};
	
// ###########################################################################################################################
// ################################LOCATOR OF ELEMENTS FAVORITE WINDOWS
// ################################################
// ###########################################################################################################################
	
//	public By FAVORITE_CONTACT_IN_FAVORITE_LIST (int number) {
//		return By.xpath("//android.widget.RelativeLayout/android.widget.LinearLayout["+number+"]/android.widget.TextView");
//	};
	
	public By FAVORITE_CONTACT_IN_FAVORITE_LIST (int number) {
		return By.xpath("//android.widget.TextView[contains(@text,'#')]/..//preceding-sibling::android.support.v7.widget.RecyclerView//android.widget.RelativeLayout["+number+"]//android.widget.TextView");
	};
	
	public By FAVORITE_SCREEN_CONTACTS_NAME (int number) {
		return By.xpath("//android.widget.TextView[contains(@text,'Contacts')]/..//following-sibling::android.widget.FrameLayout["+number+"]//android.widget.TextView");
	};
	
	public By FAVORITE_SCREEN_CONTACT_FAVORITE_BTN = By.id("com.avaya.android.flare:id/contact_favorite");
	
	public By FAVORITE_SCREEN_CONTACT_DETAILS_BACK_BTN = By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
	
	public By  FAVORITE_SCREEN_ADD_FAVORITE_CONTACT_DONE_BTN= By.id("com.avaya.android.flare:id/unifiedContactsSearchCancel");
}

