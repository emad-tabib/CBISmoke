package com.generic.tests.BD.HomePage;

import com.generic.page.HomePage;
import com.generic.setup.Common;
import com.generic.setup.SelTestCase;

public class AccountMenuValidation extends SelTestCase {
	public static boolean validate() throws Exception {
		getCurrentFunctionName(true);
		boolean accountMenuValidation = true;
		if (isMobile()) {
			Common.refreshBrowser();
			accountMenuValidation = validateMobile();
		} else {
			accountMenuValidation = validateDesktopAndTablet();
		}
		getCurrentFunctionName(false);
		return accountMenuValidation;
	}

	public static boolean validateDesktopAndTablet() throws Exception {
		getCurrentFunctionName(true);
		boolean accountMenuValidation = true;
		accountMenuValidation = HomePage.validateAccountMenuItemsDisplayed();
		HomePage.clickOnRandomAccountMenuItem();
		getCurrentFunctionName(false);
		return accountMenuValidation;
	}

	public static boolean validateMobile() throws Exception {
		getCurrentFunctionName(true);
		boolean accountMenuValidation = true;
		accountMenuValidation = HomePage.validateAccountMenuDisplayed();
		HomePage.clickOnAccountMenu(false);
		HomePage.validateAccountMenuItemsDisplayed();
		HomePage.clickOnCloseButton();
		getCurrentFunctionName(false);
		return accountMenuValidation;
	}

}
