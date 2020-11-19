package com.generic.tests.GR.HomePage;

import com.generic.page.HomePage;
import com.generic.page.PDP.*;
import com.generic.setup.GlobalVariables;
import com.generic.setup.SelTestCase;

public class MiniCartValidation extends SelTestCase {

	public static void validate() throws Exception {

		getCurrentFunctionName(true);
		HomePage.clickOnMiniCart();
		Thread.sleep(2000);
		String emptyCartText = HomePage.getMiniCartText();
		if (SelTestCase.getBrowserName().contains(GlobalVariables.browsers.iPhone)) {
			sassert().assertTrue(emptyCartText.contains("Empty"), "<font color=#f442cb>expected text is: "
					+ "Your Shopping Cart Is Empty." + "<br>actual text is: " + emptyCartText + " </font>");
		} else {
			sassert().assertTrue(emptyCartText.contains("empty"), "<font color=#f442cb>expected text is: "
					+ "Your shopping cart is empty." + "<br>actual text is: " + emptyCartText + " </font>");
		}

		//Add product to cart
		PDP.NavigateToPDP();
		if (PDP.bundleProduct())
			PDP.clickBundleItems();
		PDP_cart.addProductsToCart();
		if (!isMobile()) {
			PDP_cart.clickAddToCartCloseBtn();
		}

		// validate the cart number updates 
		if (isMobile()) {
			sassert().assertTrue(HomePage.validateProductAdded(), "Added item to cart validation has some problems");
		}

		getCurrentFunctionName(false);

	}

}
