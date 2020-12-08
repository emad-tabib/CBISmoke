package com.generic.tests.FG.HomePage;

import com.generic.page.HomePage;
import com.generic.page.PDP.*;
import com.generic.setup.SelTestCase;

public class MiniCartValidation extends SelTestCase {
	
	public static final String PDPSearchTerm = "Rugs";
	
	public static void validate() throws Exception {
		String expectedEmptyCartText = "empty";
		
		if(isMobile()) {
			expectedEmptyCartText = "Empty";
		}
		
		getCurrentFunctionName(true);
		HomePage.clickOnMiniCart();
		Thread.sleep(3000);
		String emptyCartText = HomePage.getMiniCartText();
		sassert().assertTrue(emptyCartText.contains(expectedEmptyCartText), "<font color=#f442cb>expected text is: "
				+ expectedEmptyCartText + "<br>actual text is: " + emptyCartText + " </font>");

		//Add product to cart
		PDP.NavigateToPDP(PDPSearchTerm);
		PDP_cart.addProductsToCart();
		if (!isMobile()) {
			PDP_cart.clickAddToCartCloseBtn();
		}

		// validate the cart number updates.
		if (isMobile()) {
			sassert().assertTrue(HomePage.validateProductAdded(), "Added item to cart validation has some problems");
		}
		getCurrentFunctionName(false);

	}

}
