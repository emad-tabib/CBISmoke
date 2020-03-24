package com.generic.tests.RY.e2e;

import java.text.MessageFormat;
import java.util.NoSuchElementException;
import com.generic.page.PDP.*;
import com.generic.setup.ExceptionMsg;
import com.generic.setup.PDPs;
import com.generic.setup.SelTestCase;

public class PDP_e2e extends SelTestCase {

	public static final String singlePDPSearchTerm = "Rugs";

	public static void Validate() throws Exception {

		try {
			getCurrentFunctionName(true);

			PDPs.navigateToRandomPDP();
			Thread.sleep(2500);
			PDP_cart.clickAddToCartButtonNoBundle();
			Thread.sleep(3500);

			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

}
