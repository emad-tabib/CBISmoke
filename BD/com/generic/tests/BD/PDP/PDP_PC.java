package com.generic.tests.BD.PDP;

import com.generic.page.PDP.*;
import com.generic.page.PDP_BD;
import com.generic.setup.SelTestCase;

public class PDP_PC  extends SelTestCase{
	public static void validate(String searchTerm) throws Exception {
		getCurrentFunctionName(true);
		PDP.NavigateToPDP(searchTerm);
		
	    Boolean bundle = PDP.bundleProduct();
				String ProductID = "";
				if (!isMobile() && bundle) 
					ProductID = PDP.getProductID(0);
				
		String priceErrorMessage;
		if (!bundle) {
			priceErrorMessage = "Top price is not dispayed";
		} else if (!isMobile() && bundle) {
			sassert().assertTrue(PDP.validateBundlePriceIsDisplayed(), "Bundle Price is not dispayed");
			priceErrorMessage = "Top price for the bundle items are not dispayed";
		} else {
			priceErrorMessage = "Price for the bundle items are not dispayed";
		}
			sassert().assertTrue(PDP_BD.validatePDP_PC_TopPriceIsDisplayed(), priceErrorMessage);
		if(isMobile())
			PDP_BD.clickStartDesignBtn();
		   
		PDP_BD.selectConfigureSwatches();

		if(isMobile())
			PDP_BD.clickOnSaveBtn();

		Thread.sleep(2500);
		if(isMobile()) {
			sassert().assertTrue(PDP_BD.isaddToWLGRbtnEnabled(), "Add to WL/GR button is not enabled");
		    sassert().assertTrue(PDP_BD.isaddToCartbtnEnabled(), "Add to Cart button is not enabled");
		}else {
		    sassert().assertTrue(PDP_WL.validateAddToWLGRIsEnabled(bundle, ProductID), "Add to WL/GR button is not enabled");
		    sassert().assertTrue(PDP_cart.validateAddToCartIsEnabled(bundle, ProductID), "Add to Cart button is not enabled");
		}
		String bottomPrice ;

	         bottomPrice = PDP_BD.validatePDP_PC_BottomPriceIsDisplayed();
		sassert().assertTrue(!bottomPrice.equals("$0.00"),
				"Bottom price is not updated correctly, Current price: " + bottomPrice);
		Thread.sleep(2500);
		if(isMobile())
			PDP_BD.clickAddToCartBtn();
		else
			PDP_cart.clickAddToCartButton();
		sassert().assertTrue(PDP_BD.validateProductIsAddedToCart(), "Product is not added successfully");

		getCurrentFunctionName(false);
	}
	

}
