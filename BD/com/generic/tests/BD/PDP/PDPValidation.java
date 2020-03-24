package com.generic.tests.BD.PDP;

import com.generic.page.PDP.*;
import com.generic.page.PDP_BD;

import com.generic.setup.SelTestCase;

public class PDPValidation extends SelTestCase {

	public static void validate(String searchTerm, Boolean Personalized) throws Exception {
		getCurrentFunctionName(true);
		PDP.NavigateToPDP(searchTerm);
		// int numberOfItems = PDP.getNumberOfItems();
		Boolean bundle = PDP.bundleProduct();
		String ProductID = null;
		if (!isMobile() && bundle)
			ProductID = PDP.getProductID(0);
		String priceErrorMessage;
		// price error message
		// for single PDP, validate the price is displayed below the title of the page
		// for both desktop and mobile
		// for bundle PDP Desktop, validate the top price is displayed for the
		// collection. (this is not displayed in mobile).
		// for bundle PDP mobile and desktop,validate the prices are displayed in bundle
		// landing page for all items.

		if (!bundle) {
			priceErrorMessage = "Top price is not dispayed";

		} else if (!isMobile() && bundle) {
			sassert().assertTrue(PDP.validateBundlePriceIsDisplayed(), "Bundle Price is not dispayed");
			priceErrorMessage = "Top price for the bundle items are not dispayed";
		} else {
			priceErrorMessage = "Price for the bundle items are not dispayed";
		}
		sassert().assertTrue(PDP.validatePriceIsDisplayed(bundle, ProductID), priceErrorMessage);

		// for bundle PDP mobile, validate the price is displayed in mini PDP page
		PDP_BD.BDselectSwatches(bundle, ProductID);
		boolean priceShownInSizeOption = PDP_BD.isPriceShownInSizeOption();
		if(isMobile()) {
			if(PDP.getQuantity(bundle, ProductID) == 0) {
				PDP.selectQuantity(bundle, ProductID);
			}
		}else {
			if(PDP.getQuantity(bundle,ProductID) == 0) {
				PDP.selectQuantity(bundle, ProductID);
			}
		}
		String bottomPrice ;
		if(priceShownInSizeOption) {
			 bottomPrice = PDP_BD.BDgetBottomPrice(ProductID,bundle);

		}else {
			 bottomPrice = PDP.getBottomPrice(bundle, ProductID);

		}
		sassert().assertTrue(!bottomPrice.equals("$0.00"),
				"Bottom price is not updated correctly, Current price: " + bottomPrice);
		Thread.sleep(2500);
		// click add personalized button
		if (Personalized && PDP_Personalization.PersonalizedItem(bundle, ProductID)) {
			String initialPrice = PDP_BD.getPersonaliztionCost(ProductID,bundle);
			boolean isFreePersonalization = PDP_Personalization.isFreePersonalization(bundle, ProductID);
			PDP_Personalization.clickAddPersonalizationButton(bundle, ProductID);
			sassert().assertTrue(PDP_Personalization.validatePersonalizedModal(), "Personalization Modal is not dispayed");
			if (isMobile()) {
				PDP_Personalization.selectPersonalizationModalSwatchesForiPhone();
				PDP_Personalization.clickPersonalizationSaveAndCloseButtonForiPhone();
			} else {
				PDP_Personalization.selectPersonalizationModalSwatches();
				PDP_Personalization.clickPersonalizationSaveAndCloseButton();
			}
			Thread.sleep(2000);
			sassert().assertTrue(PDP_Personalization.validateAddedPersonalizedDetails(bundle, ProductID),
					"Added personalization details is not dispayed");
			if (!isFreePersonalization) {
				String finalPrice = PDP_BD.isPersonaliztionCostDisplayedInMonogramDetails(ProductID,bundle); // take final price after added personalization
				logs.debug("compare price" + initialPrice + finalPrice);
				sassert().assertTrue(PDP_Personalization.validateTotalPriceAfterAddedPersonalized(initialPrice, finalPrice),
						"Bottom price is not updated correctly, Current price: " + finalPrice);
			}
		}
		sassert().assertTrue(PDP_WL.validateAddToWLGRIsEnabled(bundle, ProductID), "Add to WL/GR button is not enabled");
		sassert().assertTrue(PDP_cart.validateAddToCartIsEnabled(bundle, ProductID), "Add to Cart button is not enabled");
		PDP_cart.clickAddToCartButton();
		sassert().assertTrue(PDP_cart.validateProductIsAddedToCart(), "Product is not added successfully");
		getCurrentFunctionName(false);
	}
	
	

}
