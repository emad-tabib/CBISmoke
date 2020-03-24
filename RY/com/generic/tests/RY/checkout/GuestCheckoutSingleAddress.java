package com.generic.tests.RY.checkout;

import java.text.MessageFormat;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import com.generic.page.CheckOut;
import com.generic.setup.ExceptionMsg;
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

			// Add products to cart
			CheckOut.addRandomProductTocart(productsCount);

			// Navigating to Cart by URL
			CheckOut.navigatetoCart();

			// Clicking begin secure checkout
			CheckOut.clickBeginSecureCheckoutButton();

			// Clicking begin secure checkout
			CheckOut.clickGuestCheckoutButton();

			Thread.sleep(1000);

			// Add addresses for each product and save them
			CheckOut.fillCheckoutFirstStepAndSave(addressDetails);

			// Proceed to step 2
			CheckOut.proceedToStepTwo();

			// Check number of products in step 2
			sassert().assertTrue(CheckOut.checkProductsinStepTwo() >= productsCount, "Some products are missing in step 2 ");

			// Proceed to step 3
			CheckOut.proceedToStepThree();

			// Fill email field and proceed to step 4
			CheckOut.fillEmailBillingAddress();

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
			orderShipping = CheckOut.getShippingCostsRYInStep4();
			orderTax = CheckOut.getTaxCostsRYInStep4();
			orderSubTotal = CheckOut.getSubTotal();

			logs.debug(MessageFormat.format(LoggingMsg.SEL_TEXT, "Shippping cost is: " + orderShipping + " ---- Tax cost is:" + orderTax + " ---- Subtotal is:" + orderSubTotal));
			
			Thread.sleep(2500);

			// Click place order button
			CheckOut.placeOrder();
			
			Thread.sleep(3000);
			
			if (isMobile() && !CheckOut.checkIfOrderPlaced() ) {

				// Fill payment details in the last step
				CheckOut.fillPayment(paymentDetails);

				// Click place order button
				CheckOut.placeOrder();

			}

			Thread.sleep(2500);

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
