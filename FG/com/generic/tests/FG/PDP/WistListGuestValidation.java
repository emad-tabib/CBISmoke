package com.generic.tests.FG.PDP;

import com.generic.page.CheckOut;
import com.generic.page.PDP.*;
import com.generic.setup.SelTestCase;

public class WistListGuestValidation extends SelTestCase {
	public static void validate() throws Exception {
		getCurrentFunctionName(true);

		String selectedProductName = PDP.NavigateToPDP("mirror");

		PDP_selectSwatches.selectSwatches();

		PDP_WL.clickAddToWLGR();

		sassert().assertTrue(PDP_WL.validateSelectRegistryOrWishListModalIsDisplayed(),
				" Select A Registry Or Wish list modal is not dispayed");

		PDP_WL.clickOnCreateNewWL();

		sassert().assertTrue(PDP_WL.validateNameYourNewWLModalIsDisplayed(),
				"Name your new wish list modal is not dispayed");

		String WLName = PDP_WL.getWishListName();

		PDP_WL.createNewWL(WLName);

		sassert().assertTrue(PDP_WL.validateSelectRegistryOrWishListModalIsDisplayed(),
				" Select A Registry Or Wish list modal is not dispayed after created a new one");

		sassert().assertTrue(PDP_WL.validateCreatedWLisSelectedByDefault(WLName),
				"created wish list is not selected by default");

		PDP_WL.clickOnCreateNewWLConfirmationBtn();

		sassert().assertTrue(PDP_WL.validateConfirmationModalWithCorrectProductIsDisplayed(selectedProductName),
				" Confirmation Modal is not dispayed");
		logs.debug("selectedProductName" + selectedProductName);

		// validate if selected product displayed in the WL and click on add to cart
		// button
		sassert().assertTrue(PDP_WL.addedProductIsDisplayedInTheWL(selectedProductName),
				"Added product is not displayed in the Wish list");

		if (!isMobile()) {
			sassert().assertTrue(PDP_cart.validateAddToCartModalIsDisplayed(),
					"Add to cart confirmation modal not displayed.");
		}

		CheckOut.navigatetoCart();
		sassert().assertTrue(PDP_cart.addedProductIsDisplayedInShoppingCart(selectedProductName),
				"Product not added to the cart.");

		getCurrentFunctionName(false);

	}
}