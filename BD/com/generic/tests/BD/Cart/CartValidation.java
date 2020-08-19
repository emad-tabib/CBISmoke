package com.generic.tests.BD.Cart;

import java.net.URI;
import java.util.List;
import com.generic.page.Cart;
import com.generic.page.CheckOut;
import com.generic.setup.SelTestCase;
import com.generic.page.PDP.*;

public class CartValidation extends SelTestCase {

	public static void addProductToCart(String item) throws Exception {
		PDP.NavigateToPDP(item);
		Thread.sleep(3500);

		if (PDP.bundleProduct())
			PDP.clickBundleItems();
		
		Thread.sleep(3500);
		PDP_cart.addProductsToCart();
		
		Thread.sleep(3500);
		if (!isMobile())
			PDP_cart.clickAddToCartCloseBtn();

	}

	public static void cartValidation() throws Exception {
		// Search for products and add them to cart
		addProductToCart("table");

		URI url = new URI(getURL());
		getDriver().get("https://" + url.getHost());

		if (isiPad()) {
			addProductToCart("rugs");
		} else {
			addProductToCart("red");
		}

		// Navigate to cart by URL
		CheckOut.navigatetoCart();

		Thread.sleep(3500);

		Cart.closeGWPIfExsist();

		Thread.sleep(1500);

		// Check addition of products and thier images and prices
		sassert().assertTrue(Cart.isItemAdded(), "Added item to cart validation has some problems");
		sassert().assertTrue(Cart.addedItemImageValidation(), "Added item image validation has some problems");
		sassert().assertTrue(Cart.checkAddedItemPriceDisplay(),
				"Added item price displayed validation has some problems");
		sassert().assertTrue(Cart.checkAddedItemTotalPriceDisplay(),
				"Added item total price displayed validation has some problems");

		Cart.closeGWPIfExsist();

		if (Cart.isItemEditable()) {

			List<String> optionsBefore = Cart.getFirstSavedItemsOptions();

			Thread.sleep(2000);

			// Perform edit on first product in cart
			Cart.editOptions();

			Thread.sleep(3000);

			List<String> optionsAfter = Cart.getlastAddedItemsOptions();

			logs.debug("optionsBefore : " + optionsBefore + " , optionsAfter: " + optionsAfter);
			// Check if the edit is saved correctly
			sassert().assertTrue(!optionsBefore.equals(optionsAfter), "Edit item validation has some problems");
		}
		// Save total before moving item
		String totalPriceBeforeMove = Cart.getTotalPrice();

		// Moving item
		Cart.clickMoveToWishListBtnForSavedItem();

		Thread.sleep(5000);

		// Save total again
		String totalPriceAfterMove = Cart.getTotalPrice();

		logs.debug(
				"totalPriceBeforeMove =  " + totalPriceBeforeMove + " , totalPriceAfterMove = " + totalPriceAfterMove);
		// Compare total values
		sassert().assertTrue(!totalPriceBeforeMove.equals(totalPriceAfterMove),
				"Move item to wish list validation has some problems");

		Thread.sleep(2000);
		sassert().assertTrue(Cart.verifySavedList(), "Saved list validation has some problems");

		Thread.sleep(2000);
		Cart.moveItemsToCartFromWishlist();
		Thread.sleep(4000);
		// Deletion and total before and after
		String totalPriceBeforeDelete = Cart.getTotalPrice();

		Cart.clickRemoveBtnForSavedItem();

		Thread.sleep(4000);

		String totalPriceAfterDelete = Cart.getTotalPrice();
		logs.debug("totalPriceBeforeDelete =" + totalPriceBeforeDelete + " , totalPriceAfterDelete = "
				+ totalPriceAfterDelete);
		sassert().assertTrue(!totalPriceBeforeDelete.equals(totalPriceAfterDelete),
				"Remove item validation has some problems");

	}

}
