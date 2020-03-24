package com.generic.page;

import java.net.URI;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.generic.selector.CartSelectors;
import com.generic.setup.SelTestCase;
import com.generic.setup.ExceptionMsg;
import com.generic.setup.GlobalVariables;
import com.generic.setup.LoggingMsg;
import com.generic.util.SelectorUtil;

public class Cart extends SelTestCase {

	static String editLinkinCartClass = "u-visibility-hidden";
	static String wishlistPropertyName = "WishList";
	// Done CBI
	public static String getTaxValue() throws Exception {
		try {
			getCurrentFunctionName(true);
			WebElement price = SelectorUtil.getElement(CartSelectors.tax.get());
			if (price.getText().trim().isEmpty()) {
				price = SelectorUtil.getElement(CartSelectors.taxGR);
			}
			getCurrentFunctionName(false);
			return price.getText().replace("$", "").replace(",", "").trim();
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Tax element selector was not found by selenium", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// Done CBI
	public static String getShippingValue() throws Exception {
		try {
			getCurrentFunctionName(true);
			WebElement price = SelectorUtil.getElement(CartSelectors.shipping.get());
			getCurrentFunctionName(false);
			return price.getText().replace("$", "").replace(",", "").trim();
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Shipping value element selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// Done CBI
	public static void paypalBtnClick() throws Exception {
		try {
			getCurrentFunctionName(true);
			String subStrArr = CartSelectors.paypalCheckoutBtn.get();
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "PayPal Button in Cart selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// Done CBI
	public static void moveItemsToCartFromWishlist() throws Exception {
		try {
			getCurrentFunctionName(true);
			String subStrArr;
			if (isGH())
				subStrArr = CartSelectors.GHsavedListFirstItem.get() + CartSelectors.GHreturnFromWishListBtn.get();
			else if (isRY())
				subStrArr = CartSelectors.GHsavedListFirstItem.get() + CartSelectors.RYreturnFromWishListBtn.get();
			else
				subStrArr = CartSelectors.savedListFirstItem.get() + CartSelectors.returnFromWishListBtn.get();
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Add to cart from wishlist selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// Done CBI
	public static boolean verifySavedList() throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean inPDPPage = SelectorUtil.isDisplayed(CartSelectors.savedListFirstItem.get());
			getCurrentFunctionName(false);
			return inPDPPage;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Items in saved list selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// Done CBI
	public static void clickRemoveBtnForSavedItem() throws Exception {
		try {
			getCurrentFunctionName(true);
			String subStrArr;
			if (isGHRY())
				subStrArr = CartSelectors.GHRYfirstAddedItemsRemove.get();
			else
				subStrArr = CartSelectors.firstAddedItemsRemove.get();
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "Remove button for saved items selector was not found by selenium", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// Done CBI
	public static void clickMoveToWishListBtnForSavedItem() throws Exception {
		try {
			getCurrentFunctionName(true);
			String subStrArr = CartSelectors.firstAddedItemsMoveToLater.get();
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed
							+ "Move to wishlist button for item in cart selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// Done CBI
	public static String getTotalPrice() throws Exception {
		try {
			getCurrentFunctionName(true);
			WebElement price = SelectorUtil.getElement(CartSelectors.addedItemsTotalPrice.get());
			getCurrentFunctionName(false);
			return price.getText().trim();
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Total price in cart element selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// Done CBI
	public static boolean isListLoaded(List<WebElement> elements) {
		try {
			getCurrentFunctionName(true);
			boolean result = HomePage.isListLoaded(elements);
			getCurrentFunctionName(false);
			return result;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// Done CBI
	public static List<WebElement> getAllAddedItemsInCart() throws Exception {
		try {
			getCurrentFunctionName(true);
			List<WebElement> savedElements = SelectorUtil.getAllElements(CartSelectors.addedItemsInCart.get());
			getCurrentFunctionName(false);
			return savedElements;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Product element in cart selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// Done CBI
	public static boolean isItemAdded() throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isAdded;
			List<WebElement> savedElements = getAllAddedItemsInCart();
			if (savedElements.size() >= 1)
				isAdded = true;
			else
				isAdded = false;
			getCurrentFunctionName(false);
			return isAdded;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed + "Get number of products in cart failed", new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// Done CBI
	public static boolean addedItemImageValidation() throws Exception {
		try {
			getCurrentFunctionName(true);
			List<WebElement> savedElements = SelectorUtil.getAllElements(CartSelectors.addedItemsImage.get());
			boolean displayed = HomePage.isListDisplayed(savedElements);
			boolean loaded = isListLoaded(savedElements);
			getCurrentFunctionName(false);
			return displayed & loaded;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Product iamge in cart selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// Done CBI
	public static boolean checkAddedItemPriceDisplay() throws Exception {
		try {
			getCurrentFunctionName(true);
			List<WebElement> savedItems = new ArrayList<WebElement>();
			boolean inDisplayed;

			if (isGHRY())
				savedItems = SelectorUtil.getAllElements(CartSelectors.GHRYaddedItemsPrice.get());
			else
				savedItems = SelectorUtil.getAllElements(CartSelectors.addedItemsPrice.get());

			if (savedItems.size() > 0)
				inDisplayed = true;
			else
				inDisplayed = false;

			getCurrentFunctionName(false);
			return inDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Product price in cart selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// Done CBI
	public static boolean checkAddedItemTotalPriceDisplay() throws Exception {

		try {
			getCurrentFunctionName(true);
			boolean isDisplayed = SelectorUtil.isDisplayed(CartSelectors.addedItemsTotalPrice.get());
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "TotalPrice selector was not found by selenium", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// Done CBI
	public static List<String> getFirstSavedItemsOptions() throws Exception {
		try {
			getCurrentFunctionName(true);			
			List<String> values = new ArrayList<String>();
			List<WebElement>  elements = SelectorUtil.getAllElements(CartSelectors.firstAddedItemsOption.get());
			for(WebElement  element: elements) {
				values.add(element.getText());
			}
			getCurrentFunctionName(false);
			return values;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "Options for the first product in cart selector was not found by selenium", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// Done CBI
	public static List<String> getlastAddedItemsOptions() throws Exception {
		try {
			getCurrentFunctionName(true);
			List<String> values = new ArrayList<String>();
			List<WebElement>  elements = SelectorUtil.getAllElements(CartSelectors.lastAddedItemsOption.get());
			for(WebElement  element: elements) {
				values.add(element.getText());
			}
			getCurrentFunctionName(false);
			return values;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "Options for the last product in cart selector was not found by selenium", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static Boolean isItemEditable() throws Exception {
		try {
			getCurrentFunctionName(true);
			Boolean isEditable = false;
			if (!SelectorUtil.isNotDisplayed(CartSelectors.editFromCartLink.get())) {
				if (isMobile()) {
					String Str = CartSelectors.editFromCartLink.get();
					String editButtonClass = SelectorUtil.getAttrString(Str, "class");
					if (!editButtonClass.toLowerCase().contains(editLinkinCartClass))
						isEditable = true;
				} else {
					isEditable = true;
				}
			}
			getCurrentFunctionName(false);
			return isEditable;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "Options for the last product in cart selector was not found by selenium", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// Done CBI
	public static void editOptions() throws Exception {
		try {
			getCurrentFunctionName(true);

			// Click Edit for the first product in cart
			SelectorUtil.initializeSelectorsAndDoActions(CartSelectors.editFromCartLink.get());

			// Expand options accordion for desktop version
			if (!SelTestCase.getBrowserName().contains(GlobalVariables.browsers.iPhone)) {
				SelectorUtil.initializeSelectorsAndDoActions(CartSelectors.expandOptionsModal.get());
			}

			// Editing the product
			try {
				// Check if the product has drop-down and edit it
				if (isMobile()) {
					SelectorUtil.initializeSelectorsAndDoActions(CartSelectors.optionsDropDown.get(), "FFF2");
				} else {
					List<WebElement> selects = SelectorUtil.getElementsList(CartSelectors.optionsDropDown.get());
					for (int i = 0; i < selects.size(); i++) {
						WebElement ele = selects.get(i);
						Select dropDownList = new Select(ele);
						dropDownList.selectByIndex(2);
					}
				}

			} catch (Exception e) {

				try {

					List<WebElement> imgs = getDriver().findElements(By.cssSelector(CartSelectors.optionsImage.get()));
					if (imgs.size() < 3)
						throw new Exception();
					WebElement ele = imgs.get(imgs.size() - 1);
					JavascriptExecutor executor = (JavascriptExecutor) getDriver();
					executor.executeScript("arguments[0].click();", ele);

				} catch (Exception e2) {
					Thread.sleep(2500);

					// Check if the product has buttons and select one
					SelectorUtil.initializeSelectorsAndDoActions(CartSelectors.optionsButton.get());
				}

			}

			// Click finish and preview button for edit modal on mobile version
			if (isMobile()) {

				if (isGR())
					SelectorUtil.initializeSelectorsAndDoActions(CartSelectors.finishAndPreviewButtonGR.get());
				else if (isGHRY())
					SelectorUtil.initializeSelectorsAndDoActions(CartSelectors.GHRYfinishAndPreviewButton.get());
				else if(isFG())
					SelectorUtil.initializeSelectorsAndDoActions(CartSelectors.finishAndPreviewButton.get());
			}

			// Save the edits
			if (isGR())
				SelectorUtil.initializeSelectorsAndDoActions(CartSelectors.saveEditsButtonGR.get());
			else if (isGHRY())
				SelectorUtil.initializeSelectorsAndDoActions(CartSelectors.GHRYsaveEditsButton.get());
			else if (isBD()) {
				SelectorUtil.initializeSelectorsAndDoActions(CartSelectors.saveEditsButtonBD.get());	
			}else
				SelectorUtil.initializeSelectorsAndDoActions(CartSelectors.saveEditsButton.get());
			getCurrentFunctionName(false);

		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Edit options selector was not found by selenium", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		} // CATCH

	}// EDIT METHOD

	public static boolean verifySavedItemToWL() throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean inPDPPage = SelectorUtil.isDisplayed(CartSelectors.WLFirstItem.get());
			getCurrentFunctionName(false);
			return inPDPPage;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "First item in saved for later selector was not found by selenium", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static boolean validateSelectWishListModalIsDisplayed() throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisplayed;
			logs.debug("Validate select a registry or wish list modal exist");
			isDisplayed = SelectorUtil.isDisplayed(CartSelectors.WLModal.get());
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Wishlist modal selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static void clickOnSelectWLConfirmationBtn() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Click on create new wish list");
			SelectorUtil.initializeSelectorsAndDoActions(CartSelectors.selectWLConfiramtionBtn.get());
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Create a new wishlist button selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static void clickOnCheckout() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Click on create checkout/go to shopping bag");
			if (isGH())
				SelectorUtil.initializeSelectorsAndDoActions(CartSelectors.checkoutBtn.get());
			else if (isRY())
				SelectorUtil.initializeSelectorsAndDoActions(CartSelectors.RYGoToShoppingBagBtn.get());
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Go to shopping cart button selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static void navigatetoWishList() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug(MessageFormat.format(LoggingMsg.GETTING_TEXT,
					"Navigating to wish list ..." + getCONFIG().getProperty(wishlistPropertyName)));
			getDriver()
					.get(new URI(getDriver().getCurrentUrl()).resolve(getCONFIG().getProperty(wishlistPropertyName)).toString());
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Navigating to wishlist page by URL has failed", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static void selectWLByName(String createdWL) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Click on created  wish list");
			SelectorUtil.initializeSelectorsAndDoActions(CartSelectors.selectWL.get());
			List<WebElement> options = SelectorUtil.getAllElements(CartSelectors.selectWLOptions.get());

			for (WebElement option : options) {
				if (option.getText().toLowerCase().contains(createdWL.toLowerCase())) {
					option.click();
					break;
				}
			}

			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed + "Selecting the wishlist has failed",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static boolean validateAddedToWLModalIsDisplayed() throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisplayed;
			logs.debug("Validate add to cart confirmation is displayed");
			isDisplayed = SelectorUtil.isDisplayed(CartSelectors.addedToWLModal.get());
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Added to wishlist modal selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static void clickOnViewListBtn() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Clicking on view list button");
			SelectorUtil.initializeSelectorsAndDoActions(CartSelectors.viewListBtn.get());
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "View wishlist button selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static void createNewWL(String WLName) throws Exception {
		try {
			getCurrentFunctionName(true);
			SelectorUtil.initializeSelectorsAndDoActions(CartSelectors.WLName.get(), WLName);
			SelectorUtil.initializeSelectorsAndDoActions(CartSelectors.nameYourNewWLconfirmationBtn.get());
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "Create a new wishlist has failed, unable to find appropriate selectors", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

}// MAIN CLASS
