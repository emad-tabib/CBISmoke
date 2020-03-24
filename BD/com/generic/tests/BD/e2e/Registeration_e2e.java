package com.generic.tests.BD.e2e;

import java.text.MessageFormat;
import java.util.NoSuchElementException;
import com.generic.page.Registration;
import com.generic.setup.Common;
import com.generic.setup.ExceptionMsg;
import com.generic.setup.SelTestCase;
import com.generic.util.RandomUtilities;

public class Registeration_e2e extends SelTestCase {

	public static void Validate() throws Exception {

		try {
			getCurrentFunctionName(true);
			String email = RandomUtilities.getRandomName() + "@testing.com";
			String password = "P@ssword1";
			
			Registration.goToRegistrationForm();
			Common.refreshBrowser();
			
			Thread.sleep(2000);
			Registration.typeEmailAddress(email);
			Thread.sleep(3500);
			
			Common.refreshBrowser();

			Registration.registerFreshUser(email, password, "Firstvisa", "Lastvisa");
			
			Thread.sleep(3500);

			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

}
