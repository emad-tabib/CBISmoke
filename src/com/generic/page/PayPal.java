package com.generic.page;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebElement;
import com.generic.selector.CartSelectors;
import com.generic.selector.CheckOutSelectors;
import com.generic.selector.PayPalSelectors;
import com.generic.setup.SelTestCase;
import com.generic.setup.ExceptionMsg;
import com.generic.util.SelectorUtil;

public class PayPal extends SelTestCase {

	// CBI
	public static void signIn(String userName, String Password) throws Exception {
		try {
			getCurrentFunctionName(true);
			Thread.sleep(3000);
			typeUserName(userName);
			Thread.sleep(3000);
			clickNext();
			Thread.sleep(3000);
			typePassword(Password);
			Thread.sleep(3000);
			clickLogin();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Sign in to paypal failed, a selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// CBI
	private static void clickNext() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("clicking on next btn");
			SelectorUtil.initializeSelectorsAndDoActions(PayPalSelectors.nextBtn);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "PayPal next button selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));

		}

	}

	// CBI
	private static void clickLogin() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("clicking on login btn");
			SelectorUtil.initializeSelectorsAndDoActions(PayPalSelectors.loginBtn);

			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "PayPal login button selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	// CBI
	public static void clickOnContinue() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("clicking on continue btn");
			SelectorUtil.initializeSelectorsAndDoActions(PayPalSelectors.paymnetSubmit);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "PayPal continue button selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	// CBI
	private static void typePassword(String Password) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("typing password");
			SelectorUtil.initializeSelectorsAndDoActions(PayPalSelectors.password, Password);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "PayPal continue button selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	// CBI
	private static void typeUserName(String userName) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("type username");
			SelectorUtil.initializeSelectorsAndDoActions(PayPalSelectors.userName, userName);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "PayPal username field selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}
	
	public static void closePayPalSubmitPopup() throws Exception {
		try {
			getCurrentFunctionName(true);
			if (!SelectorUtil.isNotDisplayed(CheckOutSelectors.paymentSubmitPopUpClose.get()))
				SelectorUtil.initializeSelectorsAndDoActions(CheckOutSelectors.paymentSubmitPopUpClose.get());
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "Close PayPal modal button selector was not found by selenium ", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	
	public static void clickOnContinueRegistered() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("clicking on Agree and continue btn");
			SelectorUtil.initializeSelectorsAndDoActions(PayPalSelectors.paymnetSubmitRegistered);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	public static void clickConfirmRegistered() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("clicking on Agree and continue btn");
			SelectorUtil.initializeSelectorsAndDoActions(PayPalSelectors.confirmRegistered);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}
	
	public static String getConfirmationTotalValue() throws Exception {
		try {
			getCurrentFunctionName(true);
			String str = null;
			if (!isMobile() || isFGGR())
				str = CheckOutSelectors.confirmationTotal.get();
			else if (isGHRY() && isMobile())
				str = CheckOutSelectors.GHConfirmationTotal.get();
			else if(isBD() && isMobile())
				str = CheckOutSelectors.BDConfirmationTotal.get();
			WebElement price = SelectorUtil.getElement(str);
			getCurrentFunctionName(false);
			return price.getText().replace("$", "").replace(",", "").trim();
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed
							+ "Confirmation  total value element selector was not found by selenium ",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static String getConfirmationPageTaxValue() throws Exception {
		try {
			getCurrentFunctionName(true);
			WebElement price = SelectorUtil.getElement(CheckOutSelectors.confirmationPageTax.get());
			getCurrentFunctionName(false);
			return price.getText().replace("$", "").replace(",", "").trim();
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Tax value element selector was not found by selenium ",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static String getConfirmationPageShippingValue() throws Exception {
		try {
			getCurrentFunctionName(true);
			WebElement price = SelectorUtil.getElement(CheckOutSelectors.confirmationShipping.get());
			getCurrentFunctionName(false);
			return price.getText().replace("$", "").replace(",", "").trim();
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Shipping value element selector was not found by selenium ",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static String getConfirmationPageSubtotalValue() throws Exception {
		try {
			getCurrentFunctionName(true);
			WebElement price = SelectorUtil.getElement(CheckOutSelectors.confirmationPageSubtotal.get());
			getCurrentFunctionName(false);
			return price.getText().replace("$", "").replace(",", "").trim();
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Subtotal value element selector was not found by selenium ",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static boolean isPayPalPayment() throws Exception {

		try {
			getCurrentFunctionName(true);
			WebElement price = SelectorUtil.getElement(CheckOutSelectors.confirmationPageAccountType.get());
			boolean result = false;
			if (price.getText().trim().equals("PayPal Account"))
				result = true;
			getCurrentFunctionName(false);
			return result;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "PayPal identification sring selector was not found by selenium ", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static boolean checkConfirmationPageImg() throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisplayed = SelectorUtil.isDisplayed(CheckOutSelectors.confirmationPageProductImg.get())
					&& SelectorUtil.isImgLoaded(CheckOutSelectors.confirmationPageProductImg.get());
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "Image in confirmation page selector was not found by selenium ", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static boolean checkOrderNumberAndEmailAndShippingAddress() throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisplayed = SelectorUtil.isDisplayed(CheckOutSelectors.orderNumber.get())
					&& SelectorUtil.isDisplayed(CheckOutSelectors.email.get())
					&& SelectorUtil.isDisplayed(CheckOutSelectors.shippingAddress.get());
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "Some selector for order number or email or shipping address is not found by selenium ",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static int getCountOFProductForConfPage() throws Exception {
		try {
			getCurrentFunctionName(true);

			List<String> subStrArr = new ArrayList<String>();
			subStrArr.add(CheckOutSelectors.paypalConfermationPageAllProduct.get());
			List<WebElement> elements = SelectorUtil.getAllElements(subStrArr);
			getCurrentFunctionName(false);
			return elements.size();
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "Product selector in confirmation page was not found by selenium ", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static boolean isSubmitConfermationMessageDisplayed() throws Exception {
		try {
			getCurrentFunctionName(true);
			String str = null;
			boolean isDisplayed = false;
			if (isFGGR() || !isMobile())
				str = CheckOutSelectors.paypalSubmitConfermationMessage.get();
			else if (isGHRY() && isMobile())
				str = CheckOutSelectors.GHPaypalSubmitConfermationMessage.get();
			else if(isBD() && isMobile())
				str = CheckOutSelectors.BDPaypalSubmitConfermationMessage.get();
			isDisplayed = SelectorUtil.isDisplayed(str);
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "PayPal confirmation msg selector was not found by selenium ",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}





	public static boolean isOrderSummaryDisplayed() throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisplayed = SelectorUtil.isDisplayed(CartSelectors.addedItemsTotalPrice.get());
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Order summary element selector was not found by selenium ",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}



	public static boolean isPayPalModelDisplayed() throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisplayed = SelectorUtil.isDisplayed(PayPalSelectors.userName);
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Paypal modal selector was not found by selenium ",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static boolean isPayPalShipToPageDisplayed() throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisplayed = false; 
			
			try {
				isDisplayed = SelectorUtil.isDisplayed(PayPalSelectors.paymnetSubmit);
			} catch (Exception e) {
				
				try {
					isDisplayed = SelectorUtil.isDisplayed(PayPalSelectors.paymnetSubmitRegistered);
				} catch (Exception e2) {

				}
			}
			
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "PayPal shipping address selector was not found by selenium ",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static void closePayPalSubmitRegestration() throws Exception {
		try {
			getCurrentFunctionName(true);
			PayPal.closePayPalSubmitPopup();
			if (!SelectorUtil.isNotDisplayed(CheckOutSelectors.paymentPayPalSubmitRegistrationCloseBtn.get()))
				SelectorUtil.initializeSelectorsAndDoActions(
						CheckOutSelectors.paymentPayPalSubmitRegistrationCloseBtn.get());
			PayPal.closePayPalSubmitPopup();

			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "Close paypal registration button selector was not found by selenium ", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}


}
