package com.generic.tests.BD.PDP;

import com.generic.page.PDP.*;
import com.generic.page.PDP_BD;
import com.generic.setup.SelTestCase;
import com.generic.setup.Common;

public class WistListGuestValidation extends SelTestCase {
	public static void validate() throws Exception {
		getCurrentFunctionName(true);
		if (isMobile())
			Common.refreshBrowser();
	    String selectedProductName = PDP.NavigateToPDP("Rugs");
	    Boolean bundle = PDP.bundleProduct();
		String ProductID = null;
		if (!isMobile() && bundle)
			ProductID = PDP.getProductID(0);
		PDP_BD.BDselectSwatches(bundle, ProductID);
		PDP_WL.clickAddToWLGR();
		PDP_WL.clickOnCreateNewWL();
		sassert().assertTrue(PDP_WL.validateNameYourNewWLModalIsDisplayed(), "Name your new wish list modal is not dispayed");
        String WLName = PDP_WL.getWishListName();
        PDP_WL.createNewWL(WLName);		
		sassert().assertTrue(PDP_WL.validateSelectRegistryOrWishListModalIsDisplayed(), " Select A Registry or Wish list modal is not dispayed");
		Thread.sleep(1000);
		sassert().assertTrue(PDP_WL.validateCreatedWLisSelectedByDefault(WLName), "created wish list is not selected by default");
		PDP_WL.clickOnCreateNewWLConfirmationBtn();

		sassert().assertTrue(PDP_WL.validateConfirmationModalWithCorrectProductIsDisplayed(selectedProductName), " Confirmation Modal is not dispayed");
        logs.debug("selectedProductName"+selectedProductName);
		//validate if selected product displayed in the WL and click on add to cart button
		sassert().assertTrue(PDP_WL.addedProductIsDisplayedInTheWL(selectedProductName), "Added product is not displayed in the Wish list");
		if (!isMobile()) {
		sassert().assertTrue(PDP_cart.validateAddToCartModalIsDisplayed(), "Add to cart confirmation modal not displayed.");
		PDP_cart.clickOnCheckout();
		sassert().assertTrue(PDP_cart.addedProductIsDisplayedInShoppingCart(selectedProductName), "Product not added to the cart.");
		}
		
		getCurrentFunctionName(false);

	}
}