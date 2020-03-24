package com.generic.tests.BD.PDP;

import com.generic.page.PDP.*;
import com.generic.page.PDP_SC_CS;
import com.generic.setup.SelTestCase;

public class CSPDPValidation extends SelTestCase {
	
	public static void validate(String searchTerm , String desc) throws Exception { 
		
		getCurrentFunctionName(true);
		 
		PDP.NavigateToPDP(searchTerm);
		sassert().assertTrue(PDP_SC_CS.validatePriceIsDisplayed(desc),
				"The price for the item is not dispayed"); 
		
		PDP_SC_CS.selectColor(); 
		PDP_SC_CS.CSselectFinishColor(); 
		
		
		if(!isMobile()) {
			PDP_SC_CS.pickOneQuantity();
		}
		String bottomPrice = PDP_SC_CS.getBottomPrice(desc);
		sassert().assertTrue(!bottomPrice.equals("$0.00"),
				"Bottom price is not updated correctly, Current price: " + bottomPrice);
		Thread.sleep(2500);
		sassert().assertTrue(PDP_WL.validateAddToWLGRIsEnabled(false, " "), "Add to WL/GR button is not enabled");
		sassert().assertTrue(PDP_cart.validateAddToCartIsEnabled(false, " "), "Add to Cart button is not enabled");
		PDP_SC_CS.clickAddToCartButton();
		sassert().assertTrue(PDP_SC_CS.validateProductIsAddedToCart(), "Product is not added successfully");
		PDP_SC_CS.clickAddToOrderSwatch(desc);
		sassert().assertTrue(PDP_SC_CS.validateOrderSwatch(), "The Order a Swatch Modal is not dispayed");
		sassert().assertTrue(PDP_SC_CS.validateOrderSwatchDropdown(), "The Order a Swatch Dropdown is not dispayed");
		sassert().assertTrue(PDP_SC_CS.validateSearchSwatchIsDisplayed(), "The Swatch Search Input is not dispayed");
		sassert().assertTrue(PDP_SC_CS.validateSearchSwatchWorkedAsWell("black", desc), "The Swatch Search did not Work successfully");
		
		//Add Single Swatch
		PDP_SC_CS.clickAddSwatch('S');
		sassert().assertTrue(PDP_SC_CS.validateAddSwatchIsDisable(), "The Order a Swatch Modal is not disable");
		
		//Add Multiple Swatch
		PDP_SC_CS.clickAddSwatch('M');
		sassert().assertTrue(PDP_SC_CS.validateAddMoreThan10Swatches(), "The Swatch Limitation Not Working");
		PDP_SC_CS.clickAddSwatchesToCartButton();
		Thread.sleep(5000);
		//Check if number of swatches added is 10 or Not
		sassert().assertTrue(PDP_SC_CS.validateNumAddedSwatchesIsRight(), "Number of Added Swatches is not Correct");
		sassert().assertTrue(PDP_cart.validateProductIsAddedToCart(), "Swatches is not added successfully");
		 
		getCurrentFunctionName(false);
	}

}
