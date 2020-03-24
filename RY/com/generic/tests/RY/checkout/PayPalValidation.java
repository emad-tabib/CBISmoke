package com.generic.tests.RY.checkout;

import java.util.LinkedHashMap;
import com.generic.page.Cart;
import com.generic.page.CheckOut;
import com.generic.page.PayPal;
import com.generic.page.Registration;
import com.generic.setup.SelTestCase;
import com.generic.util.RandomUtilities;

public class PayPalValidation extends SelTestCase {

	public static void validate(String userType, int productsCount, LinkedHashMap<String, String> userDetalis,
			LinkedHashMap<String, String> paymentDetails) throws Exception {

		// Perform Registration
		if (userType.contains("registered")) {
			String fName = "FirstVisa";
			String lName = "LastVisa";
			String userMail = RandomUtilities.getRandomEmail();
			String userPassword = "TestITG226";
			//Perform Registration
			Registration.registerFreshUser(userMail, userPassword, fName, lName);
		}

		// Add products to cart
		CheckOut.searchForProductsandAddToCart(productsCount);

		// Navigating to Cart by URL
		CheckOut.navigatetoCart();

		Thread.sleep(4000);

		sassert().assertTrue(Cart.checkAddedItemTotalPriceDisplay(), "Cart page is not displayed");

		float subtotalValue = Float.parseFloat(Cart.getTotalPrice().replace("$", "").replace(",", "").trim());

		Cart.paypalBtnClick();
		String main = null;
		if (SelTestCase.isDesktop())
			main =  CheckOut.paymentInnformation.switchToPayPalWindow();
		Thread.sleep(1000);
		if (PayPal.isPayPalModelDisplayed()) {
			String PayPalEmail = paymentDetails.get(CheckOut.paymentInnformation.keys.number);
			String PayPalPassword = paymentDetails.get(CheckOut.paymentInnformation.keys.CVCC); 
			PayPal.signIn(PayPalEmail, PayPalPassword);
			sassert().assertTrue(PayPal.isPayPalShipToPageDisplayed(), "(PayPAl Ship to) page is not displayed");

			Thread.sleep(6000);

			if (userType.contains("registered")) {
				PayPal.clickOnContinueRegistered();
				PayPal.clickConfirmRegistered();
			}

			else {
				PayPal.clickOnContinue();

			}
			
			if (SelTestCase.isDesktop())
				 CheckOut.paymentInnformation.switchBackToMainWindow(main);

			Thread.sleep(2000);
			CheckOut.clickCheckouStepFourConfirmationButton();
			
			if (CheckOut.isPaymentPageSelectedAndPayPalSelected()) {
				sassert().assertTrue(PayPal.isOrderSummaryDisplayed(), "Order summary is not displayed");
				float newSubTotal = Float.parseFloat(Cart.getTotalPrice().replace("$", "").replace(",", "").trim());
				sassert().assertTrue(subtotalValue == newSubTotal, "Subtotal value is incorrect");
				float shippingValue = Float.parseFloat(Cart.getShippingValue());
				float tax = Float.parseFloat(Cart.getTaxValue());
				CheckOut.clickPayPalOrderSubmit();
				Thread.sleep(3000);

				PayPal.closePayPalSubmitRegestration();
				sassert().assertTrue(PayPal.isSubmitConfermationMessageDisplayed(),
						"Order confirmation page is not displayed");

				sassert().assertTrue(PayPal.checkOrderNumberAndEmailAndShippingAddress(),
						"Order number or email or shipping address is not displayed");
				sassert().assertTrue(PayPal.checkConfirmationPageImg(), "Product image is not displayed");
				sassert().assertTrue(PayPal.isPayPalPayment(), "Payment type is PayPal");

				float confirmationSubtotal = Float.parseFloat(PayPal.getConfirmationPageSubtotalValue());
				float confirmationTax = Float.parseFloat(PayPal.getConfirmationPageTaxValue());
				float confirmationShipping = Float.parseFloat(PayPal.getConfirmationPageShippingValue());
				float total = Float.parseFloat(PayPal.getConfirmationTotalValue());

				if (confirmationTax != tax)
					sassert().assertTrue(false, "Tax value is not same");
				if (confirmationSubtotal != subtotalValue)
					sassert().assertTrue(false, "Subtotal value is not same");
				if (confirmationShipping != shippingValue)
					sassert().assertTrue(false, "shipping value is not same");
				if (subtotalValue + tax + shippingValue != total)
					sassert().assertTrue(false, "Total value is not equales the sum of subtotal + tax + shipping");

			}
		}

	}

}