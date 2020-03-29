package com.generic.page;

import java.net.URI;
import java.text.MessageFormat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import com.generic.selector.CartSelectors;
import com.generic.selector.CheckOutSelectors;
import com.generic.setup.ExceptionMsg;
import com.generic.setup.GlobalVariables;
import com.generic.setup.LoggingMsg;
import com.generic.setup.PDPs;
import com.generic.setup.SelTestCase;
import com.generic.util.RandomUtilities;
import com.generic.util.SelectorUtil;
import com.generic.page.PDP.*;

public class CheckOut extends SelTestCase {

	public static class shippingAddress {

		public static class keys {

			public static final String countery = "countery";
			public static final String title = "title";
			public static final String lastName = "lastName";
			public static final String firstName = "firstName";
			public static final String adddressLine = "adddressLine";
			public static final String city = "city";
			public static final String state = "state";
			public static final String zipcode = "postal";
			public static final String phone = "phone";
		}

		// Done CBI
		public static void typeFirstName(String firstName, boolean isSingle) throws Exception {
			try {
				getCurrentFunctionName(true);
				if (isSingle)
					SelectorUtil.initializeSelectorsAndDoActions(CheckOutSelectors.firstNameSingle.get(), firstName);
				else
					SelectorUtil.initializeSelectorsAndDoActions(CheckOutSelectors.firstName.get(), firstName);
				getCurrentFunctionName(false);
			} catch (NoSuchElementException e) {
				logs.debug(MessageFormat.format(
						ExceptionMsg.PageFunctionFailed + "First name field selector was not found by selenium",
						new Object() {
						}.getClass().getEnclosingMethod().getName()));
				throw e;
			}

		}

		// Done CBI
		public static void typeLastName(String lastName, boolean isSingle) throws Exception {
			try {
				getCurrentFunctionName(true);
				if (isSingle)
					SelectorUtil.initializeSelectorsAndDoActions(CheckOutSelectors.lastNameSingle.get(), lastName);
				else
					SelectorUtil.initializeSelectorsAndDoActions(CheckOutSelectors.lastName.get(), lastName);

				getCurrentFunctionName(false);
			} catch (NoSuchElementException e) {
				logs.debug(MessageFormat.format(
						ExceptionMsg.PageFunctionFailed + "Last name field selector was not found by selenium",
						new Object() {
						}.getClass().getEnclosingMethod().getName()));
				throw e;
			}

		}

		// Done CBI
		public static void typeStreetAddress(String streetAddress, boolean isSingle) throws Exception {
			try {
				getCurrentFunctionName(true);
				if (isSingle)
					SelectorUtil.initializeSelectorsAndDoActions(CheckOutSelectors.streetAddressSingle.get(),
							streetAddress);
				else
					SelectorUtil.initializeSelectorsAndDoActions(CheckOutSelectors.streetAddress.get(), streetAddress);

				getCurrentFunctionName(false);
			} catch (NoSuchElementException e) {
				logs.debug(MessageFormat.format(
						ExceptionMsg.PageFunctionFailed + "Street address field selector was not found by selenium",
						new Object() {
						}.getClass().getEnclosingMethod().getName()));
				throw e;
			}

		}

		// Done CBI
		public static void typeCity(String city) throws Exception {
			try {
				getCurrentFunctionName(true);
				if(!SelectorUtil.isNotDisplayed(CheckOutSelectors.city.get()))
				SelectorUtil.initializeSelectorsAndDoActions(CheckOutSelectors.city.get(), city);
				getCurrentFunctionName(false);
			} catch (NoSuchElementException e) {
				logs.debug(MessageFormat.format(
						ExceptionMsg.PageFunctionFailed + "City field selector was not found by selenium",
						new Object() {
						}.getClass().getEnclosingMethod().getName()));
				throw e;
			}

		}

		// Done CBI
		public static void typeZipCode(String zip, boolean isSingle) throws Exception {
			try {
				getCurrentFunctionName(true);
				if (isSingle)
					SelectorUtil.initializeSelectorsAndDoActions(CheckOutSelectors.zipCodeSingle.get(), zip);
				else
					SelectorUtil.initializeSelectorsAndDoActions(CheckOutSelectors.zipCode.get(), zip);

				getCurrentFunctionName(false);
			} catch (NoSuchElementException e) {
				logs.debug(MessageFormat.format(
						ExceptionMsg.PageFunctionFailed + "ZIP Code field selector was not found by selenium",
						new Object() {
						}.getClass().getEnclosingMethod().getName()));
				throw e;
			}

		}

		// Done CBI
		public static void typePhone(String phone, boolean isSingle) throws Exception {
			try {
				getCurrentFunctionName(true);
				if (isSingle)
					SelectorUtil.initializeSelectorsAndDoActions(CheckOutSelectors.phoneSingle.get(), phone);
				else
					SelectorUtil.initializeSelectorsAndDoActions(CheckOutSelectors.phone.get(), phone);

				getCurrentFunctionName(false);
			} catch (NoSuchElementException e) {
				logs.debug(MessageFormat.format(
						ExceptionMsg.PageFunctionFailed + "Phone field selector was not found by selenium",
						new Object() {
						}.getClass().getEnclosingMethod().getName()));
				throw e;
			}

		}

		// Done CBI
		public static void selectState(String state) throws Exception {
			try {
				getCurrentFunctionName(true);
				if(!SelectorUtil.isNotDisplayed(CheckOutSelectors.state.get()))
				SelectorUtil.initializeSelectorsAndDoActions(CheckOutSelectors.state.get(), state);
				getCurrentFunctionName(false);
			} catch (NoSuchElementException e) {
				logs.debug(MessageFormat.format(
						ExceptionMsg.PageFunctionFailed + "State drop down selector was not found by selenium",
						new Object() {
						}.getClass().getEnclosingMethod().getName()));
				throw e;
			}

		}

	}// shipping address

	public static class paymentInnformation {

		public static class keys {
			public static final String name = "name";
			public static final String number = "number";
			public static final String expireYear = "expireYear";
			public static final String expireMonth = "expireMonth";
			public static final String CVCC = "CVCC";

		}

		// Done CBI
		public static void switchBackToMainWindow(String mainWindow) {
			try {
				getCurrentFunctionName(true);
				getDriver().switchTo().window(mainWindow);
				getCurrentFunctionName(false);
			} catch (NoSuchElementException e) {
				logs.debug(MessageFormat.format(
						ExceptionMsg.PageFunctionFailed + "Main window selector was not found by selenium",
						new Object() {
						}.getClass().getEnclosingMethod().getName()));
				throw e;
			}

		}

		// Done CBI
		public static String switchToPayPalWindow() throws InterruptedException {
			try {
				getCurrentFunctionName(true);
				Thread.sleep(1000);
				Set<String> winIds = getDriver().getWindowHandles();
				Iterator<String> iter = winIds.iterator();
				
				logs.debug("number of windows:" + winIds.size());
				
				String main = iter.next();
				logs.debug("main window " + main);
				
				String paypal = iter.next();
				logs.debug("paypal window " + paypal);
				
				getDriver().switchTo().window(paypal);
				
				getCurrentFunctionName(false);
				return main;
			} catch (NoSuchElementException e) {
				logs.debug(MessageFormat.format(
						ExceptionMsg.PageFunctionFailed + "PayPal window selector was not found by selenium",
						new Object() {
						}.getClass().getEnclosingMethod().getName()));
				throw e;
			}
		}

		// Done CBI
		public static void typeCVV(String CVV) throws Exception {
			try {
				getCurrentFunctionName(true);

				// Switch to cvv iframe
				Thread.sleep(2800);

				// wait for cvv iframe to load
				waitforCvvFrame();

				getDriver().switchTo().frame(GlobalVariables.CVV_Iframe_ID);
				SelectorUtil.initializeSelectorsAndDoActions(CheckOutSelectors.cvv2.get(), CVV);

				Thread.sleep(2000);
				// Switch to default frame
				getDriver().switchTo().defaultContent();
			} catch (NoSuchFrameException e) {
				try {

					if (isFG() || isBD() || isGR()) {
						SelectorUtil.initializeSelectorsAndDoActions(CheckOutSelectors.cvv.get(), CVV);
					} else if (isGH() || isRY()) {
						SelectorUtil.initializeSelectorsAndDoActions(CheckOutSelectors.cvvGH.get(), CVV);

					}
					getCurrentFunctionName(false);
				} catch (NoSuchElementException e2) {
					logs.debug(
							MessageFormat.format(ExceptionMsg.PageFunctionFailed + "CVV typing failed", new Object() {
							}.getClass().getEnclosingMethod().getName()));
					throw e;
				}
			}
		}

		// Done CBI
		public static void waitforCvvFrame() throws Exception {
			try {
				boolean cvvStatus = false;
				int noOfTries = 0;

				while (!cvvStatus) {
					logs.debug(cvvStatus + "  Waiting for cvv iframe");

					cvvStatus = checkCvvIframe();
					noOfTries++;

					if (noOfTries > 25)
						break;

					Thread.sleep(2000);
				}

			} catch (NoSuchElementException e) {
				logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
				}.getClass().getEnclosingMethod().getName()));
				throw e;
			}

		}

		// Done CBI
		private static boolean checkCvvIframe() throws Exception {
			try {

				if (getDriver().findElements(By.id(GlobalVariables.CVV_Iframe_ID)).size() != 0)
					return true;
				else
					return false;

			} catch (NoSuchElementException e) {
				logs.debug(MessageFormat.format(
						ExceptionMsg.PageFunctionFailed + "CVV field selector was not found by selenium", new Object() {
						}.getClass().getEnclosingMethod().getName()));
				throw e;
			}

		}

		// Done CBI
		private static void typeExpireMonth(String month) throws Exception {
			try {
				getCurrentFunctionName(true);
				
				if(isGH() || isRY())
					month=month.substring(1);//Remove 0 from 06 
				
				SelectorUtil.initializeSelectorsAndDoActions(CheckOutSelectors.monthField.get(), month);
				getCurrentFunctionName(false);
			} catch (NoSuchElementException e) {
				logs.debug(MessageFormat.format(
						ExceptionMsg.PageFunctionFailed + "Month drop down selector was not found by selenium",
						new Object() {
						}.getClass().getEnclosingMethod().getName()));
				throw e;
			}
		}

		// Done CBI
		public static void typeExpireYear(String expireYear) throws Exception {
			try {
				getCurrentFunctionName(true);
				SelectorUtil.initializeSelectorsAndDoActions(CheckOutSelectors.yearField.get(), expireYear);
				getCurrentFunctionName(false);
			} catch (NoSuchElementException e) {
				logs.debug(MessageFormat.format(
						ExceptionMsg.PageFunctionFailed + "Year drop down selector was not found by selenium",
						new Object() {
						}.getClass().getEnclosingMethod().getName()));
				throw e;
			}
		}

		// Done CBI
		public static void typeCardNumber(String cardNumber) throws Exception {
			try {
				getCurrentFunctionName(true);
				SelectorUtil.initializeSelectorsAndDoActions(CheckOutSelectors.creditCardField.get(), cardNumber);
				getCurrentFunctionName(false);
			} catch (NoSuchElementException e) {
				logs.debug(MessageFormat.format(
						ExceptionMsg.PageFunctionFailed + "Credit card field selector was not found by selenium",
						new Object() {
						}.getClass().getEnclosingMethod().getName()));
				throw e;
			}

		}

	}// payment info

	// Done CBI
	public static void searchForProductsandAddToCart(int productsNo) throws Exception {
		try {
			getCurrentFunctionName(true);
			// Add products to cart
			for (int i = 0; i < productsNo; i++) {
				Thread.sleep(4000);

				PDP.NavigateToPDP();

				if (PDP.bundleProduct()) {
					PDP.clickBundleItems();
				}
				
				Thread.sleep(2000);
				PDP_cart.addProductsToCart();

				URI url = new URI(getURL());
				getDriver().get("https://" + url.getHost());
			}
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Search for products and add to cart has failed.. ",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// Done CBI
	public static void navigatetoCart() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug(MessageFormat.format(LoggingMsg.GETTING_TEXT,
					"Navigating to cart ..." + getCONFIG().getProperty("Cart")));
			getDriver().get(new URI(getDriver().getCurrentUrl()).resolve(getCONFIG().getProperty("Cart")).toString());
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed + "Navigating to Cart by URL has failed ",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// Done CBI
	public static void clickBeginSecureCheckoutButton() throws Exception {
		try {
			getCurrentFunctionName(true);
			SelectorUtil.initializeSelectorsAndDoActions(CheckOutSelectors.beginSecureCheckoutButton.get());
			logs.debug(MessageFormat.format(LoggingMsg.SEL_TEXT, "Clicking Begin secure checkout button"));
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "Begin secure checkout button selector was not found by selenium ", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// Done CBI
	public static void clickGuestCheckoutButton() throws Exception {
		try {
			getCurrentFunctionName(true);
			SelectorUtil.initializeSelectorsAndDoActions(CheckOutSelectors.guestCheckoutButton.get());
			logs.debug(MessageFormat.format(LoggingMsg.SEL_TEXT, "Clicking guest checkout button"));
			getCurrentFunctionName(false);

		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Guest checkout button selector was not found by selenium ",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	// Done CBI
	public static void clickMultipleAddressesTab() throws Exception {
		try {
			getCurrentFunctionName(true);
			List<WebElement> tabs = SelectorUtil.getAllElements(CheckOutSelectors.multipleAddressesTab.get());
			tabs.get(1).click();
			logs.debug(MessageFormat.format(LoggingMsg.SEL_TEXT, "Clicking multiple address tab"));
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Multiple address button selector was not found by selenium ",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	// Done CBI
	public static void clickAddAddressButton() throws Exception {
		try {
			getCurrentFunctionName(true);
			SelectorUtil.initializeSelectorsAndDoActions(CheckOutSelectors.multipleAddressesTab.get(), "index,1");
			logs.debug(MessageFormat.format(LoggingMsg.SEL_TEXT, "Clicking multiple address tab"));
			getCurrentFunctionName(false);

		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Add new address button selector was not found by selenium ",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	// Done CBI
	public static void fillCheckoutFirstStepAndSave(int productsCount, LinkedHashMap<String, String> addressDetalis)
			throws Exception {
		try {
			getCurrentFunctionName(true);
			for (int buttonIndex = 0; buttonIndex < productsCount; buttonIndex++) {
				Thread.sleep(2000);
				// Add new address
				logs.debug(MessageFormat.format(LoggingMsg.SEL_TEXT, "Clicking add new address button "));
				SelectorUtil.initializeSelectorsAndDoActions(CheckOutSelectors.addAddressButton.get(),
						"index," + buttonIndex);
				
				Thread.sleep(3000);
				// Filling address fields
				logs.debug(MessageFormat.format(LoggingMsg.SEL_TEXT, "filling address att index " + buttonIndex));
				shippingAddress.typeFirstName(addressDetalis.get(CheckOut.shippingAddress.keys.firstName), false);
				shippingAddress.typeLastName(addressDetalis.get(CheckOut.shippingAddress.keys.lastName), false);
				shippingAddress.typeStreetAddress(RandomUtilities.getRandomName(), false);
				shippingAddress.typeZipCode(addressDetalis.get(CheckOut.shippingAddress.keys.zipcode), false);
				shippingAddress.typePhone(RandomUtilities.getRandomPhone(), false);
				shippingAddress.selectState(addressDetalis.get(CheckOut.shippingAddress.keys.state));
				shippingAddress.typeCity(addressDetalis.get(CheckOut.shippingAddress.keys.city));
				// Save address button
				SelectorUtil.initializeSelectorsAndDoActions(CheckOutSelectors.saveAddressButton.get(), "");
			}

		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed + "Filling first checkout step has failed",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// Done CBI --- This version is for one address case
	public static void fillCheckoutFirstStepAndSave(LinkedHashMap<String, String> addressDetalis) throws Exception {
		try {
			getCurrentFunctionName(true);

			// Filling address fields
			shippingAddress.typeFirstName(addressDetalis.get(CheckOut.shippingAddress.keys.firstName), true);
			shippingAddress.typeLastName(addressDetalis.get(CheckOut.shippingAddress.keys.lastName), true);
			shippingAddress.typeStreetAddress(RandomUtilities.getRandomName(), true);
			shippingAddress.typeZipCode(addressDetalis.get(CheckOut.shippingAddress.keys.zipcode), true);
			shippingAddress.typePhone(RandomUtilities.getRandomPhone(), true);

		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed + "Filling first checkout step has failed ",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// Done CBI
	public static int checkProductsinStepTwo() throws Exception {
		try {
			getCurrentFunctionName(true);
			int productsNumber = SelectorUtil.getAllElements(CheckOutSelectors.productContainerInStepTwo.get()).size();
			logs.debug("Found" + productsNumber + "Products in step 2");
			getCurrentFunctionName(false);
			return productsNumber;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "Products container in step two selector was not found by selenium ", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// Done CBI
	public static void proceedToStepTwo() throws Exception {
		try {
			getCurrentFunctionName(true);
			// Click next to proceed to step 2
			SelectorUtil.initializeSelectorsAndDoActions(CheckOutSelectors.firstStepNextButton.get());
			watiStepTobeready();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Next button in step one selector was not found by selenium ",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// Done CBI
	public static boolean checkIfInStepTwo() throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean state = false;
			Thread.sleep(1000);

			if (isFG() || isBD()) {
				state = SelectorUtil.isDisplayed(CheckOutSelectors.stepTwoIdentifier.get());
			} else if (isGR()) {
				state = SelectorUtil.isDisplayed(CheckOutSelectors.stepTwoIdentifierGR.get());
			}
			else if (isRY() || isGH()) {
				state = SelectorUtil.isDisplayed(CheckOutSelectors.productContainerInStepTwo.get());
			}

			getCurrentFunctionName(false);
			logs.debug("In step 2 state is ---- " + state+ " ----");
			return state;

		} catch (NoSuchElementException e) {
			try {

				if (isFG()) {
					return SelectorUtil.isDisplayed(CheckOutSelectors.stepTwoIdentifier2.get());

				} else if (isGR()) {
					return SelectorUtil.isDisplayed(CheckOutSelectors.stepTwoIdentifier2GR.get());

				} else {
					return false;
				}
			} catch (NoSuchElementException e2) {
				return false;

			}

		}
	}

	public static void watiStepTobeready() throws Exception {
		try {
			getCurrentFunctionName(true);

			SelectorUtil.waitElementToDisappear(By.cssSelector(CheckOutSelectors.stepLoaderButton.get()));

			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Step loader mark selector was not found by selenium ",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// Done CBI
	public static void proceedToStepFour() throws Exception {
		try {
			getCurrentFunctionName(true);
			// Click next to proceed to step 4
			SelectorUtil.initializeSelectorsAndDoActions(CheckOutSelectors.thirdStepNextButton.get(),
					"ForceAction,click");
			watiStepTobeready();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Next button in step three selector was not found by selenium ",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// Done CBI
	public static void proceedToStepThree() throws Exception {
		try {
			getCurrentFunctionName(true);
			SelectorUtil.initializeSelectorsAndDoActions(CheckOutSelectors.secondStepNextButton.get(),
					"ForceAction,click");
			watiStepTobeready();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Next button in step two selector was not found by selenium ",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// Done CBI
	public static void fillEmailBillingAddress() throws Exception {
		try {
			getCurrentFunctionName(true);
			// Fill email field
			SelectorUtil.initializeSelectorsAndDoActions(CheckOutSelectors.emailBillingAddress.get(),
					RandomUtilities.getRandomEmail());
			getCurrentFunctionName(false);

		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "email in belling address selector was not found by selenium ",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// Done CBI
	public static String getShippingCosts() throws Exception {
		try {
			getCurrentFunctionName(true);
			int shppingIndex = 0;

			if (isMobile()) {
				shppingIndex = 1;
			}
			getCurrentFunctionName(false);
			return SelectorUtil.getNthElement(CheckOutSelectors.shippingAndTaxCost.get(), shppingIndex).getText();

		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Shipping cost element selector was not found by selenium ",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	
	// Done CBI
	public static String getShippingCostsRYInStep4() throws Exception {
		try {
			getCurrentFunctionName(true);
			int shppingIndex = 1;

			getCurrentFunctionName(false);
			return SelectorUtil.getNthElement(CheckOutSelectors.shippingAndTaxCost.get(), shppingIndex).getText();

		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// Done CBI
	public static String getTaxCosts(int grTaxIndex) throws Exception { // grTaxIndex this value is set 1 for GR and 0
																		// for FG
		try {
			getCurrentFunctionName(true);
			int taxIndex = 1;
			int expectedElementstoBeFound =8;
			int RYMobileTaxIndex =1;
			int MobileTaxIndex =2;
			
			List<WebElement> elements =SelectorUtil.getAllElements(CheckOutSelectors.shippingAndTaxCost.get()); 
			
			if (isRY() && !isMobile()) {
				taxIndex = RYMobileTaxIndex + grTaxIndex;
			}
			
			if (isMobile()) {
				taxIndex = MobileTaxIndex + grTaxIndex;
				
				if(elements.size()==expectedElementstoBeFound && isFG())
					taxIndex++;
			}
			
			
			getCurrentFunctionName(false);
			return elements.get(taxIndex).getText();

		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Tax element selector was not found by selenium ", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	
	
	// Done CBI
	public static String getTaxCostsRYInStep4() throws Exception {

		try {
			getCurrentFunctionName(true);

			int taxIndex = 2;

			getCurrentFunctionName(false);
			return SelectorUtil.getNthElement(CheckOutSelectors.shippingAndTaxCost.get(), taxIndex).getText();

		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// Done CBI
	public static String getSubTotal() throws Exception {
		try {
			getCurrentFunctionName(true);
			int subTotalIndex = 0;

			if (getBrowserName().contains(GlobalVariables.browsers.iPhone)) {
				getCurrentFunctionName(false);
				return SelectorUtil.getNthElement(CheckOutSelectors.shippingAndTaxCost.get(), subTotalIndex).getText();
			} else {
				getCurrentFunctionName(false);
				return SelectorUtil.getElement(CheckOutSelectors.subTotalValue.get()).getText();
			}

		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Subtotal element selector was not found by selenium ",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// Done CBI
	public static void fillPayment(LinkedHashMap<String, String> paymentDetails) throws Exception {
		try {
			getCurrentFunctionName(true);
			CheckOut.paymentInnformation.typeCardNumber(paymentDetails.get(CheckOut.paymentInnformation.keys.number));
			Thread.sleep(1500);
			CheckOut.paymentInnformation
					.typeExpireMonth(paymentDetails.get(CheckOut.paymentInnformation.keys.expireMonth));
			Thread.sleep(1500);
			CheckOut.paymentInnformation
					.typeExpireYear(paymentDetails.get(CheckOut.paymentInnformation.keys.expireYear));
			Thread.sleep(1500);
			CheckOut.paymentInnformation.typeCVV(paymentDetails.get(CheckOut.paymentInnformation.keys.CVCC));
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed + "Fill payment method has failed",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// Done CBI
	public static void placeOrder() throws Exception {
		try {
			getCurrentFunctionName(true);
			SelectorUtil.initializeSelectorsAndDoActions(CheckOutSelectors.placeSecureOrderButton.get(),
					"ForceAction,click");
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Place order button selector was not found by selenium ",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	// Done CBI
	public static void closeRegisterButton() throws Exception {
		try {
			getCurrentFunctionName(true);

			if (!getBrowserName().contains(GlobalVariables.browsers.iPhone)) {
				SelectorUtil.initializeSelectorsAndDoActions(CheckOutSelectors.closeRegisterButton.get());
			}

			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "Close button for registration modal selector was not found by selenium ", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	// Done CBI
	public static int checkProductsinConfirmationPage() throws Exception {
		try {
			getCurrentFunctionName(true);
			int productsNumber = SelectorUtil.getAllElements(CheckOutSelectors.itemID.get()).size();
			logs.debug("Found" + productsNumber + "Products in confirmation page");
			getCurrentFunctionName(false);
			return productsNumber;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed
							+ "Product container in confirmation page selector was not found by selenium ",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	// Done CBI
	public static void closePromotionalModal() throws Exception {
		try {
			getCurrentFunctionName(true);
			if (!getBrowserName().contains(GlobalVariables.browsers.iPad)) {
				try {
					WebDriverWait wait = new WebDriverWait(getDriver(), 25);
					WebElement closeElement = wait.until(
							visibilityOfElementLocated(By.cssSelector(CheckOutSelectors.closePoromotionalModal.get())));
					closeElement.click();
				} catch (Exception e) {
					logs.debug("Promotional message didn't show up");

				}
			}
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	public static void clickCheckouStepFourConfirmationButton() throws Exception {
		try {
			getCurrentFunctionName(true);
			if (!SelectorUtil.isNotDisplayed(CartSelectors.paymentPageCheckNextBtn.get()))
				SelectorUtil.initializeSelectorsAndDoActions(CartSelectors.paymentPageCheckNextBtn.get());
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Confirmation button in step 4 selector was not found by selenium ",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	
	public static boolean isPaymentPageSelectedAndPayPalSelected() throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisplayed = SelectorUtil.isDisplayed(CheckOutSelectors.paymentPagePayPalTitle.get());
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "paypal elemet selector in payment was not found by selenium ", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	
	public static void clickPayPalOrderSubmit() throws Exception {
		try {
			getCurrentFunctionName(true);
			SelectorUtil.initializeSelectorsAndDoActions(CheckOutSelectors.paymentPagePayPalSubmitBtn.get());
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "Submit button for paypal selector was not found by selenium ", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	


	public static void clickCreditCardPayment() throws Exception {
		try {
			getCurrentFunctionName(true);
			SelectorUtil.initializeSelectorsAndDoActions(CheckOutSelectors.creditCartTab.get());
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Credit card tab selector in step 4 was not found by selenium ",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	public static void printOrderIDtoLogs() throws Exception {
		try {
			getCurrentFunctionName(true);
			SelectorUtil.initializeSelectorsAndDoActions(CheckOutSelectors.orderID.get());
			logs.debug(SelectorUtil.textValue.toString().replace("text is :", "Order ID is: "));

			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Order ID Container selector was not found by selenium ",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}
	
	public static void addRandomProductTocart(int prodCount) throws Exception {
		try {
			getCurrentFunctionName(true);

			for (int count = 0; count < prodCount; count++) {
				Thread.sleep(3000);
				PDPs.navigateToRandomPDP();
				Thread.sleep(3000);
				PDP_cart.clickAddToCartButtonNoBundle();
				Thread.sleep(3500);
			}
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Order ID Container selector was not found by selenium ",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}
	
	
	public static void checkOrderValues(int AddedProdsCount,String orderShippingInStepFour,String orderTaxInStepFour,String orderSubTotalInStepFour ) throws Exception {
		try {
			getCurrentFunctionName(true);
			
			// Check number of products in confirmation page
			sassert().assertEquals(CheckOut.checkProductsinConfirmationPage(), AddedProdsCount,"Some products are missing in confirmation page ");

			// Check if shipping costs match
			sassert().assertEquals(CheckOut.getShippingCosts(), orderShippingInStepFour, "Shipping cost value issue ");

			// Check if tax cost match
			sassert().assertEquals(CheckOut.getTaxCosts(GlobalVariables.FG_TAX_CONFIRMATION), orderTaxInStepFour,"Tax value issue ");

			// Check if subtotal value match
			sassert().assertEquals(CheckOut.getSubTotal(), orderSubTotalInStepFour, "Subtotal value issue ");
			
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Order ID Container selector was not found by selenium ",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}
	
	
	public static void checkOrderValuesGR(int AddedProdsCount,String orderShippingInStepFour,String orderTaxInStepFour,String orderSubTotalInStepFour ) throws Exception {
		try {
			getCurrentFunctionName(true);
			
			// Check number of products in confirmation page
			sassert().assertEquals(CheckOut.checkProductsinConfirmationPage(), AddedProdsCount,"Some products are missing in confirmation page ");

			// Check if shipping costs match
			sassert().assertEquals(CheckOut.getShippingCosts(), orderShippingInStepFour, "Shipping cost value issue ");

			// Check if tax cost match
			sassert().assertEquals(CheckOut.getTaxCosts(GlobalVariables.GR_TAX_CONFIRMATION), orderTaxInStepFour,"Tax value issue ");

			// Check if subtotal value match
			sassert().assertEquals(CheckOut.getSubTotal(), orderSubTotalInStepFour, "Subtotal value issue ");
			
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Order ID Container selector was not found by selenium ",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}
	
	
	public static boolean checkIfOrderPlaced() throws Exception {
		getCurrentFunctionName(true);

		try {
			boolean state = true;
			try {
				if (SelectorUtil.isDisplayed(CheckOutSelectors.placeSecureOrderButton.get())) {
					state = false;
					logs.debug("button is still displayed");
				}
				
			} catch (Exception e) {
				state = true;
			}

			getCurrentFunctionName(false);
			logs.debug("Order state is" +state);
			return state;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static boolean checkIfinStepFour() throws Exception {
		getCurrentFunctionName(true);

		try {
			boolean state = false;
			try {
				if (SelectorUtil.isDisplayed(CheckOutSelectors.creditCardField.get())) {
					state = true;
					logs.debug("Now in Step 4");
				}
				
			} catch (Exception e) {
				state = false;
			}

			getCurrentFunctionName(false);
			return state;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

}