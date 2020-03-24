package com.generic.tests.RY.e2e;

import java.text.MessageFormat;
import java.util.NoSuchElementException;
import com.generic.page.Login;
import com.generic.setup.ExceptionMsg;
import com.generic.setup.SelTestCase;

public class Login_e2e extends SelTestCase {
	
	public static void Validate(String UserName, String Password) throws Exception {
	try {
		getCurrentFunctionName(true);
		
		//Login Step
		Login.logIn(UserName,Password);

		getCurrentFunctionName(false);
	} catch (NoSuchElementException e) {
		logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
		}.getClass().getEnclosingMethod().getName()));
		throw e;
	}

	}

}
