package com.generic.tests.BD.PDP;

import com.generic.page.HomePage;
import com.generic.page.PDP.*;
import com.generic.page.PDP_BD;
import com.generic.setup.SelTestCase;

public class PDP_VK extends SelTestCase{
	public static void validate(String searchTerm) throws Exception {
		getCurrentFunctionName(true);
		PDP.NavigateToPDP(searchTerm);
	    Boolean bundle = PDP.bundleProduct();
			String ProductID = "";
			if (!isMobile() && bundle) 
				ProductID = PDP.getProductID(0);
				
			if(bundle) {
			PDP.selectQuantity(true, ProductID);
			PDP_BD.BDselectSwatches(bundle, ProductID);
			Thread.sleep(3500);
			PDP_BD.clickOnConfigureBtn(ProductID);
			Thread.sleep(1500);
			PDP_BD.BDSelectItemsConfigurations(bundle);
            PDP_BD.clickOnConfigureModalDoneBtn();
			}else {
				PDP.selectQuantity(false, ProductID);
				PDP_BD.BDSelectItemsConfigurations(bundle);

			}
		

		
        String priceErrorMessage;
		if (!bundle) {
			priceErrorMessage = "Top price is not dispayed";
		} else if (!isMobile() && bundle) {
			sassert().assertTrue(PDP.validateBundlePriceIsDisplayed(), "Bundle Price is not dispayed");
			priceErrorMessage = "Top price for the bundle items are not dispayed";
		} else {
			priceErrorMessage = "Price for the bundle items are not dispayed";
		}
		sassert().assertTrue(PDP_BD.validatePriceIsDisplayed(), priceErrorMessage);

	
		Thread.sleep(2500);
		sassert().assertTrue(PDP_WL.validateAddToWLGRIsEnabled(bundle, ProductID), "Add to WL/GR button is not enabled");
		sassert().assertTrue(PDP_cart.validateAddToCartIsEnabled(bundle, ProductID), "Add to Cart button is not enabled");
	
		
		boolean priceShownInSizeOption = PDP_BD.isPriceShownInSizeOption();
	
		String bottomPrice ;
		if(priceShownInSizeOption) {
			 bottomPrice = PDP_BD.BDgetBottomPrice(ProductID,bundle);
		}else {
			 bottomPrice = PDP.getBottomPrice(bundle, ProductID);
		}
		sassert().assertTrue(!bottomPrice.equals("$0.00"),
				"Bottom price is not updated correctly, Current price: " + bottomPrice);
		Thread.sleep(2500);
		PDP_cart.clickAddToCartButton();
		sassert().assertTrue(PDP_cart.validateProductIsAddedToCart(), "Product is not added successfully");

		getCurrentFunctionName(false);
	}
	
	

}
