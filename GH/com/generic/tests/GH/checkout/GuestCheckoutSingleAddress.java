package com.generic.tests.GH.checkout;

import java.text.MessageFormat;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;

import com.generic.page.Cart;
import com.generic.page.CheckOut;
import com.generic.setup.Common;
import com.generic.setup.ExceptionMsg;
import com.generic.setup.GlobalVariables;
import com.generic.setup.LoggingMsg;
import com.generic.setup.SelTestCase;

public class GuestCheckoutSingleAddress extends SelTestCase {


	public static void startTest(int productsCount, LinkedHashMap<String, String> addressDetails,
			LinkedHashMap<String, String> paymentDetails) throws Exception {
		getCurrentFunctionName(true);

		try {
			String orderSubTotal;
			String orderTax;
			String orderShipping;
			Thread.sleep(5000);
			if (isMobile())
				Thread.sleep(5000);
			
			// Add products to cart
			CheckOut.addRandomProductTocart(productsCount);
			if (isMobile())
				Thread.sleep(5000);
			// Navigating to Cart by URL
			CheckOut.navigatetoCart();
			
			Thread.sleep(3500);

			Cart.closeGWPIfExsist();
			Thread.sleep(3500);
			Cart.closeGWPIfExsist();
			if (isMobile()) {
				Common.refreshBrowser();
				Thread.sleep(3000);
			}
			// Clicking begin secure checkout
			CheckOut.clickBeginSecureCheckoutButton();
			
			Thread.sleep(4000);
			
			// Clicking begin secure checkout
			CheckOut.clickGuestCheckoutButton();

			Thread.sleep(1000);

			// Add addresses for each product and save them
			CheckOut.fillCheckoutFirstStepAndSave(addressDetails);

			Thread.sleep(4000);

			// Proceed to step 2
			CheckOut.proceedToStepTwo();
			
			Thread.sleep(3000);

			// Check number of products in step 2
			sassert().assertTrue(CheckOut.checkProductsinStepTwo() == productsCount, "Some products are missing in step 2 ");

			// Proceed to step 3
			CheckOut.proceedToStepThree();

			// Fill email field and proceed to step 4
			CheckOut.fillEmailBillingAddress();
		
			Thread.sleep(3000);

			// Proceed to step 4
			CheckOut.proceedToStepFour();
			
			Thread.sleep(3500);

			// Current PWA issue
			if (!CheckOut.checkIfinStepFour()) {
				CheckOut.proceedToStepFour();

			}
			
			Thread.sleep(3500);

			// Fill payment details in the last step
			CheckOut.fillPayment(paymentDetails);

			// Saving tax and shipping costs to compare them in the confirmation page
			orderShipping = CheckOut.getShippingCosts();
			orderTax = CheckOut.getTaxCosts(GlobalVariables.FG_TAX_CART);
			orderSubTotal = CheckOut.getSubTotal();

			logs.debug(MessageFormat.format(LoggingMsg.SEL_TEXT, "Shippping cost is: " + orderShipping + " ---- Tax cost is:" + orderTax + " ---- Subtotal is:" + orderSubTotal));
			
			Thread.sleep(2500);

			// Click place order button
			CheckOut.placeOrder();
			Thread.sleep(2500);
			if (isMobile())
				Thread.sleep(GlobalVariables.deley.placeOrderDelay);
			
			if (isMobile() && !CheckOut.checkIfOrderPlaced() ) {

				// Fill payment details in the last step
				CheckOut.fillPayment(paymentDetails);

				// Click place order button
				CheckOut.placeOrder();

			}


			Thread.sleep(2000);

			CheckOut.closePromotionalModal();

			Thread.sleep(2000);

			CheckOut.closeRegisterButton();

			CheckOut.checkOrderValues(productsCount,orderShipping, orderTax,orderSubTotal );

			CheckOut.printOrderIDtoLogs();

			getCurrentFunctionName(false);

		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}
	
}
