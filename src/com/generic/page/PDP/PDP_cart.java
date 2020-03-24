package com.generic.page.PDP;

import java.text.MessageFormat;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import com.generic.page.HomePage;
import com.generic.selector.HomePageSelectors;
import com.generic.selector.PDPSelectors;
import com.generic.setup.ExceptionMsg;
import com.generic.setup.SelTestCase;
import com.generic.util.SelectorUtil;

public class PDP_cart extends SelTestCase {

	public static void clickAddToCartButtonNoBundle() throws Exception {
		try {
			getCurrentFunctionName(true);

			if (SelTestCase.isFGGR())
				SelectorUtil.initializeSelectorsAndDoActions(PDPSelectors.addToCartBtn.get());

			if (SelTestCase.isGHRY())
				SelectorUtil.initializeSelectorsAndDoActions(PDPSelectors.GHRYaddToCartBtn.get());

			if (SelTestCase.isBD())
				SelectorUtil.initializeSelectorsAndDoActions(PDPSelectors.addToCartBtnBD.get());

			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Add to cart button selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	

	public static boolean getAddToCartClass() throws Exception {
		try {
			getCurrentFunctionName(true);
			String Str;
			boolean isDisabled = true;
			if (isBD()) {
				Str = PDPSelectors.BDaddToCartBtn.get();
				String addToCartBtnDisabledAttribute = SelectorUtil.getAttrString(Str, "disabled");
				if (addToCartBtnDisabledAttribute == null) {
					logs.debug("addToCartBtnClass: no");
					isDisabled = false;
				} else {
					logs.debug("addToCartBtnClass: yes");
					isDisabled = true;
				}

			} else {
				Str = PDPSelectors.addToCartBtn.get();
				String addToCartBtnClass = SelectorUtil.getAttrString(Str, "class");
				logs.debug("addToCartBtnClass: " + addToCartBtnClass);
				isDisabled = addToCartBtnClass.contains("disabled");
			}
			getCurrentFunctionName(false);
			return isDisabled;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Add to cart button selector was not found by seleniuem",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	
	/**
	 * Get the number of items from the header mini cart.
	 *
	 * @return integer.
	 * @throws Exception
	 */
	public static int getNumberOfCartItems() throws Exception {

		try {
			getCurrentFunctionName(true);
			WebElement miniCart = SelectorUtil.getElement(PDPSelectors.miniCartItems.get());
			String miniCartText = miniCart.getText();

			if (!isMobile()) {
				// Split the number of items from the text (Desktop & Tablet).
				String[] listString = miniCartText.split("\\(");
				miniCartText = listString[1];
				miniCartText = miniCartText.split("item")[0].trim();
			}

			int miniCartItems = Integer.parseInt(miniCartText);
			getCurrentFunctionName(false);
			return miniCartItems;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static void hoverMiniCart() throws Exception {
		try {
			getCurrentFunctionName(true);
			Wait<WebDriver> wait = new FluentWait<WebDriver>(SelTestCase.getDriver()).withTimeout(Duration.ofSeconds(30))
			        .pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
			
			WebElement field = getDriver()
					.findElement(By.cssSelector(HomePageSelectors.miniCartBtn.get().replace("css,", "")));

			JavascriptExecutor jse = (JavascriptExecutor) getDriver();
			jse.executeScript("arguments[0].scrollIntoView(false)", field);
			Thread.sleep(200);
			WebElement field2 = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.cssSelector(HomePageSelectors.miniCartBtn.get().replace("css,", "")));
				}
			});

			Actions HoverAction = new Actions(getDriver());
			HoverAction.moveToElement(field2).click().build().perform();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Mini cart button selector was not found by seleniuem",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static boolean validateAddToCartModalIsDisplayed() throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisplayed;
			logs.debug("Validate add to cart confirmation modal displayed");
			isDisplayed = SelectorUtil.isDisplayed(PDPSelectors.addToCartConfirmationModal.get());
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "checkout added to cart confirmation selector was not found by seleniuem", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static boolean addedProductIsDisplayedInShoppingCart(String addedProductName) throws Exception {
		try {
			getCurrentFunctionName(true);
			Thread.sleep(3500);
			boolean isDisplayed = true;
			List<WebElement> products = SelectorUtil.getElementsList(PDPSelectors.shoppingCartProductsName.get());

			for (int i = 0; i < products.size(); i++) {
				if (products.get(i).getText().contains(addedProductName)) {
					return true;
				}
			}
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Product in shopping cart selector was not found by seleniuem",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	
	public static void clickOnCheckout() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Clicking on Checkout");
			SelectorUtil.initializeSelectorsAndDoActions(PDPSelectors.addToCartConfirmationModalCheckoutBtn.get());
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed
							+ "checkout button in added to cart confirmation selector was not found by seleniuem",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	// done - SMK
	public static boolean validateProductIsAddedToCart() throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisplayed;
			// Validate the add to cart modal is displayed for Desktop and iPad.
			// For Mobile, verify it from mini cart because there is no add to cart modal in
			// mobile.
			if (!isMobile()) {
				Thread.sleep(4000);
				isDisplayed = SelectorUtil.isDisplayed(PDPSelectors.addToCartModal.get());
			} else if (isMobile() && (isGHRY() || isBD())) {
				isDisplayed = SelectorUtil.isDisplayed(PDPSelectors.addToCartModal.get());
			} else {
				HomePage.clickOnMiniCart();
				isDisplayed = HomePage.validateMiniCartProductIsDsiplayed();
			}
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Add to cart modal selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	// done - SMK
	public static boolean validateAddToCartIsEnabled(Boolean Bundle, String ProductID) throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisplayed;
			logs.debug("Validate if Add To Cart Is Displayed");
			// here it will pass if the button exist regardless if it is enabled or
			// disabled.
			// because there is no attribute to verify if it is enabled.
			String selectorEnabled;
			if (isBD())
				selectorEnabled = PDPSelectors.BDaddToCartBtnEnabledSingle.get();
			else if (isFGGR())
				selectorEnabled = PDPSelectors.addToCartBtnEnabledSingle.get();
			else if (isRY())
				selectorEnabled = PDPSelectors.RYAddToCartBtnEnabledSingle.get();
			else
				selectorEnabled = PDPSelectors.GHAddToCartBtnEnabledSingle.get();

			if (!isMobile() && Bundle) {

				if (isBD())
					selectorEnabled = MessageFormat.format(PDPSelectors.BDaddToCartBtnEnabledBundle, ProductID);
				else if (isFGGR())
					selectorEnabled = MessageFormat.format(PDPSelectors.addToCartBtnEnabledBundle, ProductID);
				else
					selectorEnabled = MessageFormat.format(PDPSelectors.GHAddToCartBtnEnabledBundle, ProductID);
			}
			isDisplayed = SelectorUtil.isDisplayed(selectorEnabled);
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Add to cart registrey button selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	

	// done - SMK
	public static void addProductsToCart() throws Exception {
		try {
			getCurrentFunctionName(true);
			PDP_selectSwatches.selectSwatches();
			Thread.sleep(2000);
			clickAddToCartButton();
			if (PDP.bundleProduct() && SelTestCase.isMobile()) {
				PDP.closeModalforBundleItem();
			}
			Thread.sleep(2000);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "Add products to cart has failed, a selector was not found by selenium", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	

	/**
	 * Click on add to cart button.
	 *
	 * @throws Exception
	 */
	public static void clickAddToCartButton() throws Exception {
		try {
			getCurrentFunctionName(true);
			String subStrArr = null;
			if (SelTestCase.isFGGR())
				subStrArr = PDPSelectors.addToCartBtn.get();
			if (SelTestCase.isGHRY())
				subStrArr = PDPSelectors.GHRYaddToCartBtn.get();
			if (SelTestCase.isBD())
				subStrArr = PDPSelectors.BDaddToCartBtn.get();

			// Bundle product selector.
			if (!isMobile() && (isBD() || isGH()) && PDP.bundleProduct()) {
				if (!isMobile() && PDP.bundleProduct()) {
					String ProductID = PDP.getProductID(0);
					subStrArr = MessageFormat.format(PDPSelectors.GHAddToCartBtnEnabledBundle, ProductID);
				}
			}
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Add to cart button selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// done - SMK
	public static void clickAddToCartCloseBtn() throws Exception {
		try {
			getCurrentFunctionName(true);
			String subStrArr = PDPSelectors.addToCartCloseBtn.get();
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Add to cart close button selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}





	
	
	
	
	
}
