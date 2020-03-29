package com.generic.tests.BD.e2e;

import java.text.MessageFormat;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import com.generic.page.CheckOut;
import com.generic.setup.ExceptionMsg;
import com.generic.setup.GlobalVariables;
import com.generic.setup.LoggingMsg;
import com.generic.setup.SelTestCase;

public class Checkout_e2e extends SelTestCase {

	public static void ValidateGuest(int productsCount, LinkedHashMap<String, String> addressDetails,
			LinkedHashMap<String, String> paymentDetails, LinkedHashMap<String, String> userdetails) throws Exception {

		try {
			getCurrentFunctionName(true);

			String orderSubTotal;
			String orderTax;
			String orderShipping;

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
			sassert().assertTrue(CheckOut.checkProductsinStepTwo() >= productsCount,
					"Some products are missing in step 2 ");

			// Proceed to step 3
			CheckOut.proceedToStepThree();
			
			Thread.sleep(2000);
			// Fill email field and proceed to step 4
			CheckOut.fillEmailBillingAddress();
			
			Thread.sleep(2000);

			// Proceed to step 4
			CheckOut.proceedToStepFour();

			Thread.sleep(3500);

			// Fill payment details in the last step
			CheckOut.fillPayment(paymentDetails);
			
			// Saving tax and shipping costs to compare them in the confirmation page
			orderShipping = CheckOut.getShippingCosts();
			orderTax = CheckOut.getTaxCosts(GlobalVariables.FG_TAX_CART);
			orderSubTotal = CheckOut.getSubTotal();


			logs.debug(MessageFormat.format(LoggingMsg.SEL_TEXT, "Shippping cost is: " + orderShipping
					+ " ---- Tax cost is:" + orderTax + " ---- Subtotal is:" + orderSubTotal));


			// Click place order button
			CheckOut.placeOrder();

			Thread.sleep(3500);
			
			if (isMobile() && !CheckOut.checkIfOrderPlaced() ) {

				// Fill payment details in the last step
				CheckOut.fillPayment(paymentDetails);

				// Click place order button
				CheckOut.placeOrder();

			}

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

	public static void ValidateRegistered(int productsCount, LinkedHashMap<String, String> addressDetails,
			LinkedHashMap<String, String> paymentDetails, LinkedHashMap<String, String> userdetails) throws Exception {

		try {
			getCurrentFunctionName(true);
			String orderSubTotal;
			String orderTax;
			String orderShipping;

			int productsCountStepTWO = 0;


			// Clicking begin secure checkout
			CheckOut.clickBeginSecureCheckoutButton();
			Thread.sleep(1500);
			if (!CheckOut.checkIfInStepTwo()) {
				// Proceed to step 2
				CheckOut.proceedToStepTwo();
			}

			// Check number of products in step 2
			sassert().assertTrue(CheckOut.checkProductsinStepTwo() >= productsCount,
					"Some products are missing in step 2 ");

			productsCountStepTWO = CheckOut.checkProductsinStepTwo();

			// Proceed to step 3
			CheckOut.proceedToStepThree();

			// Proceed to step 4
			CheckOut.proceedToStepFour();
			Thread.sleep(4000);

			// Fill payment details in the last step
			CheckOut.fillPayment(paymentDetails);

			// Saving tax and shipping costs to compare them in the confirmation page
			orderShipping = CheckOut.getShippingCosts();
			orderTax = CheckOut.getTaxCosts(GlobalVariables.FG_TAX_CART);
			orderSubTotal = CheckOut.getSubTotal();


			logs.debug(MessageFormat.format(LoggingMsg.SEL_TEXT, "Shippping cost is: " + orderShipping
					+ " ---- Tax cost is:" + orderTax + " ---- Subtotal is:" + orderSubTotal));

			Thread.sleep(3000);
			
			// Click place order button
			CheckOut.placeOrder();
			
			Thread.sleep(2500);
			
			if (isMobile() && !CheckOut.checkIfOrderPlaced() ) {

				// Fill payment details in the last step
				CheckOut.fillPayment(paymentDetails);

				// Click place order button
				CheckOut.placeOrder();

			}


			Thread.sleep(3500);

			CheckOut.closePromotionalModal();

			CheckOut.checkOrderValues(productsCountStepTWO,orderShipping, orderTax,orderSubTotal );

			CheckOut.printOrderIDtoLogs();

			getCurrentFunctionName(false);

		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

}
