package com.generic.tests.RY.PDP;

import com.generic.page.PDP.*;
import com.generic.setup.SelTestCase;
import com.generic.setup.Common;

public class WistListGuestValidation extends SelTestCase {
	public static void validate() throws Exception {
		getCurrentFunctionName(true);
		if (isMobile())
			Common.refreshBrowser();
		   String selectedProductName = PDP.NavigateToPDP("Slippers");
		PDP_selectSwatches.selectSwatches();
		Thread.sleep(2000);
		PDP_WL.clickAddToWLGR();
		Thread.sleep(2000);
		PDP_WL.clickOnCreateNewWL();
		sassert().assertTrue(PDP_WL.validateNameYourNewWLModalIsDisplayed(), "Name your new wish list modal is not dispayed");
        String WLName = PDP_WL.getWishListName();
        PDP_WL.createNewWL(WLName);
		
		sassert().assertTrue(PDP_WL.selectWLByName(WLName), "created wish list is not selected by default");
		sassert().assertTrue(PDP_WL.validateConfirmationModalWithCorrectProductIsDisplayed(selectedProductName), " Confirmation Modal is not dispayed");
        logs.debug("selectedProductName"+selectedProductName);
		//validate if selected product displayed in the WL and click on add to cart button
		sassert().assertTrue(PDP_WL.addedProductIsDisplayedInTheWL(selectedProductName), "Added product is not displayed in the Wish list");
		if (!isMobile()) {
			Thread.sleep(2000);
		sassert().assertTrue(PDP_cart.validateAddToCartModalIsDisplayed(), "Add to cart confirmation modal not displayed.");
		PDP_cart.clickOnCheckout();
		sassert().assertTrue(PDP_cart.addedProductIsDisplayedInShoppingCart(selectedProductName), "Product not added to the cart.");
		}
		
		getCurrentFunctionName(false);

	}
}