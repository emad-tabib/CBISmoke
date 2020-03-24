package com.generic.tests.BD.PDP;

import com.generic.page.PDP.*;
import com.generic.page.PDP_BD;
import com.generic.page.PDP_SC_CS;
import com.generic.setup.SelTestCase;

public class FabricPDPValidation extends SelTestCase {
	
	public static void validate(String searchTerm) throws Exception { 
		
		getCurrentFunctionName(true);

		PDP.NavigateToPDP(searchTerm);
		sassert().assertTrue(PDP_BD.validateTheRightPDP(searchTerm), "You are in the wrong PDP");
		sassert().assertTrue(PDP_BD.validatePriceIsDisplayed(),
				"The price for the item is not dispayed"); 
		sassert().assertTrue(PDP_WL.validateAddToWLGRIsEnabled(false, " "), "Add to WL/GR button is not enabled");
		sassert().assertTrue(PDP_BD.validateFabricAddToCartIsEnabled(), "Add to Cart button is not enabled");
		//there is No bottom price.
		PDP_BD.clickAddToCartButton();
		sassert().assertTrue(PDP_SC_CS.validateProductIsAddedToCart(), "Product is not added successfully");
		PDP_BD.pickOneQuantity();
		PDP_BD.clickAddToFreeSwatch();
		Thread.sleep(5000);
		sassert().assertTrue(PDP_SC_CS.validateProductIsAddedToCart(), "Swatch is not added successfully");
		
	}

}
