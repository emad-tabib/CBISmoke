package com.generic.tests.GR.HomePage;

import com.generic.page.HomePage;
import com.generic.setup.Common;
import com.generic.setup.SelTestCase;

public class YMALCarouselsVerification extends SelTestCase {

	public static void validate() throws Exception {
		getCurrentFunctionName(true);
		if (isMobile()) {
			Common.refreshBrowser();
			Thread.sleep(3000);
		}
		sassert().assertTrue(HomePage.validateYMALCarouselsDisplayed(), "YMAL Carousels is not displayed");
		getCurrentFunctionName(false);

	}

}
