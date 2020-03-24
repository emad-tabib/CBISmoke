package com.generic.tests.RY.PDP;

import com.generic.page.PDP.*;
import com.generic.setup.SelTestCase;

public class PDPValidation extends SelTestCase {

	public static void validate() throws Exception {
		getCurrentFunctionName(true);
		Boolean bundle = false;
		String ProductID = null;
		String priceErrorMessage;
			priceErrorMessage = "Top price is not dispayed";
		sassert().assertTrue(PDP.validatePriceIsDisplayed(bundle, ProductID), priceErrorMessage);


		PDP_selectSwatches.selectSwatches(bundle, ProductID);
		if(isMobile()) {
		String bottomPrice = PDP.getBottomPrice(bundle, ProductID);
		sassert().assertTrue(!bottomPrice.equals("$0.00"),
				"Bottom price is not updated correctly, Current price: " + bottomPrice);
		}
		Thread.sleep(2500);
		sassert().assertTrue(PDP_WL.validateAddToWLGRIsEnabled(bundle, ProductID), "Add to WL/GR button is not enabled");
		sassert().assertTrue(PDP_cart.validateAddToCartIsEnabled(bundle, ProductID), "Add to Cart button is not enabled");
		PDP_cart.clickAddToCartButton();
		sassert().assertTrue(PDP_cart.validateProductIsAddedToCart(), "Product is not added successfully");
		getCurrentFunctionName(false);
	}
}
