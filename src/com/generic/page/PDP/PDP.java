package com.generic.page.PDP;

import java.text.MessageFormat;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import com.generic.page.PLP;
import com.generic.selector.PDPSelectors;
import com.generic.selector.PLPSelectors;
import com.generic.setup.ExceptionMsg;
import com.generic.setup.GlobalVariables;
import com.generic.setup.SelTestCase;
import com.generic.util.SelectorUtil;
import com.generic.util.StringUtils;

public class PDP extends SelTestCase {

	public static class keys {
		public static final String WLRandomName = "Wish list";

	}

	// done - SMK
	public static String NavigateToPDP(String SearchTerm) throws Exception {
		try {
			getCurrentFunctionName(true);
			if ((isFGGR() && !isiPad()) || ((isRY() && isMobile())) || ((isBD() && isMobile()))) {
				PLP.clickSearchicon();
			}
			String itemName = "";
			// This is to handle iPad behavior for search modal.
			// TODO: to use this process on all brands
			if (isGHRY() && isiPad() || isBD() && isiPad()) {
				PLP.clickSearch(SearchTerm);
				if (SelectorUtil.isElementExist(By.cssSelector(PLPSelectors.PLPPageSelector.get()))) {
					itemName = PLP.pickPLPFirstProduct();
				}
			} else {
				PLP.typeSearch(SearchTerm);
				itemName = PLP.pickRecommendedOption();
			}
			itemName = StringUtils.unescapeHtml(itemName);
			getCurrentFunctionName(false);
			return itemName;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "Navigation to PDP has failed, a selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	// done - SMK
	public static String getBrandRandomPLP() throws Exception {
		try {
			getCurrentFunctionName(true);
			String BrandURL;
			if (isFG())
				BrandURL = GlobalVariables.randomPLP.FG;
			else if (isGR())
				BrandURL = GlobalVariables.randomPLP.GR;
			else if (isGH())
				BrandURL = GlobalVariables.randomPLP.GH;
			else if (isRY())
				BrandURL = GlobalVariables.randomPLP.RY;
			else
				BrandURL = GlobalVariables.randomPLP.BD;
			getCurrentFunctionName(false);
			return BrandURL;
		} catch (Exception e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed + "Failed to get random PLP", new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	// done - SMK
	public static void NavigateToPDP() throws Exception {
		getCurrentFunctionName(true);
		getDriver().get(getURL() + getBrandRandomPLP());
		PLP.pickPLPRandomProduct();
		getCurrentFunctionName(false);
	}

	// Done CBI
	public static void closeModalforBundleItem() throws Exception {
		try {
			getCurrentFunctionName(true);
			SelectorUtil.initializeSelectorsAndDoActions(PDPSelectors.closeBundleProductModal.get());
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Close icon for bundle modal selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// done - SMK
	public static boolean validatePriceIsDisplayed(Boolean bundle, String ProductID) throws Exception {
		getCurrentFunctionName(true);
		try {
			boolean isDisplayed;
			logs.debug("Validate if top price exist");
			String selector = null;
			if (isFGGR()) {
				selector = PDPSelectors.topPriceSingle.get();
				if (!isMobile() && bundle) {
					logs.debug(PDPSelectors.topPriceBundle);
					selector = MessageFormat.format(PDPSelectors.topPriceBundle, ProductID);
				}
			} else if (isRY()) {
				selector = PDPSelectors.RYtopPriceSingle.get();
			} else if (isBD()) {
				selector = PDPSelectors.BDtopPriceSingle.get();
			} else {
				selector = PDPSelectors.GHtopPriceSingle.get();
			}
			isDisplayed = SelectorUtil.isDisplayed(selector);
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat
					.format(ExceptionMsg.PageFunctionFailed + "Price selector was not found by selenium", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// done - SMK
	public static boolean validateExpiredPDPMsgIsNotDisplayedSinglePDP() throws Exception {
		getCurrentFunctionName(true);
		try {
			boolean isNotDisplayed;
			logs.debug("Validate PDP is sold out");
			String selector = PDPSelectors.expiredPDP.get();
			isNotDisplayed = SelectorUtil.isNotDisplayed(selector);
			getCurrentFunctionName(false);
			return isNotDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "PDP Sold out message selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// done - SMK
	public static boolean validateExpiredPDPMsgIsNotDisplayedBundlePDP() throws Exception {
		getCurrentFunctionName(true);
		try {
			boolean isNotDisplayed;
			logs.debug("Validate PDP is sold out");
			String ProductID = getProductID(0);
			logs.debug(PDPSelectors.expiredPDPBundle);
			String selector = MessageFormat.format(PDPSelectors.topPriceBundle, ProductID);
			isNotDisplayed = SelectorUtil.isNotDisplayed(selector);
			getCurrentFunctionName(false);
			return isNotDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "PDP Sold out message selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// done - SMK
	public static boolean validateBundlePriceIsDisplayed() throws Exception {
		try {
			getCurrentFunctionName(true);

			boolean isDisplayed;
			logs.debug("Validate if top price exist for Bundle PDP");
			if (isBD())
				isDisplayed = SelectorUtil.isDisplayed(PDPSelectors.BDtopPriceBundleDesktop.get());
			else
				isDisplayed = SelectorUtil.isDisplayed(PDPSelectors.topPriceBundleDesktop.get());

			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "PDP Price selector was not found by selenium", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// done - SMK
	public static String getBottomPrice() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Validate if bottom price is updated after seleting options");
			String selector = PDPSelectors.bottomPriceSingle.get();
			if (isGHRY()) {
				selector = PDPSelectors.GHRYBottomPriceSingle.get();
			} else if (isBD())
				selector = PDPSelectors.BDbottomPriceSingle.get();
			if (!isMobile() && bundleProduct()) {
				String ProductID = getProductID(0);
				if (isBD())
					selector = MessageFormat.format(PDPSelectors.BDbottomPriceBundle, ProductID);
				else
					selector = MessageFormat.format(PDPSelectors.bottomPriceBundle, ProductID);
			}
			SelectorUtil.initializeSelectorsAndDoActions(selector);
			String price = SelectorUtil.textValue.get();
			getCurrentFunctionName(false);
			return price;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Bottom of PDP Price selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}

	// done - SMK

	public static String getBottomPrice(Boolean bundle, String ProductID) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Validate if bottom price is updated after seleting options");
			String selector;
			if (isBD())
				selector = PDPSelectors.BDbottomPriceSingle.get();
			else if (isGHRY()) {
				if (isRY() && isMobile()) {
					selector = PDPSelectors.RYBottomPriceSingle.get();
				} else {
					selector = PDPSelectors.GHRYBottomPriceSingle.get();
				}
			} else
				selector = PDPSelectors.bottomPriceSingle.get();

			if (bundle) {
				if (isBD()) {
					if (isMobile())
						selector = PDPSelectors.BDbottomPriceBundleMobile.get();
					else
						selector = MessageFormat.format(PDPSelectors.BDbottomPriceBundle, ProductID);

				} else if (isGH()) {
					selector = MessageFormat.format(PDPSelectors.GHBottomPriceBundle.get(), ProductID);
				} else if (!isMobile()) {
					selector = MessageFormat.format(PDPSelectors.bottomPriceBundle, ProductID);
				}
			}
			SelectorUtil.initializeSelectorsAndDoActions(selector);
			String price = SelectorUtil.textValue.get();
			getCurrentFunctionName(false);
			return price;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Bottom of PDP Price selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// done - SMK
	public static String getProductID(int index) throws Exception {
		try {
			getCurrentFunctionName(true);
			String Str = PDPSelectors.itemsID.get();
			if (isGH()) {
				if (isMobile()) {
					Thread.sleep(2500);
				}
				Str = PDPSelectors.GHItemsID.get();
			}
			
			if (isBD()) {
				if (isMobile()) {
					Thread.sleep(2500);
				}
				Str = PDPSelectors.BDitemsID.get();
			}
			
			String ID = SelectorUtil.getAttrString(Str, "id", index);
			getCurrentFunctionName(false);
			return ID;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Product ID selector was not found by selenium", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// done - SMK
	public static boolean bundleProduct() throws Exception {
		return bundleProduct(0);
	}

	// done - SMK
	public static boolean bundleProduct(int tries) throws Exception {
		getCurrentFunctionName(true);
		try {
			Thread.sleep(4500);
			String PDPChecker = "return gwtDynamic.coremetrics.isSingleProduct;";
			Boolean bundle = false;
			JavascriptExecutor jse = (JavascriptExecutor) getDriver();

			String value = (String) jse.executeScript(PDPChecker);

			logs.debug("isSingleProduct: " + value);

			if (value.equals("N")) {
				bundle = true;
				logs.debug("This item is bundle");
			} else if (value.equals("Y")) {
				bundle = false;
				logs.debug("This item is not bundle");
			} else {
				if (tries < 10)
					bundleProduct(tries++);
			}

			return bundle;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Executing JavaScript code to know PDP type has failed",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// Done SMK
	public static void clickBundleItems() throws Exception {
		try {
			getCurrentFunctionName(true);
			String selector = PDPSelectors.bundleItems.get();
			if (isGH()) {
				selector = PDPSelectors.GHBundleItems.get();
			} else if (isBD()) {
				selector = PDPSelectors.BDnumberOfBundleItems.get();
			}

			logs.debug("Clicking on any bundle item");
			if (!SelectorUtil.isNotDisplayed(selector)) {
				SelectorUtil.initializeSelectorsAndDoActions(selector);
			}
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Bundle items selector was not found by seleniuem", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// done-CBI
	public static String getTitle() throws Exception {
		try {
			getCurrentFunctionName(true);
			if (isGHRY()) {
				SelectorUtil.initializeSelectorsAndDoActions(PDPSelectors.titleGH.get());

			} 

			else if (isBD()) {
				SelectorUtil.initializeSelectorsAndDoActions(PDPSelectors.BDtitle.get());
			}
			else {
				SelectorUtil.initializeSelectorsAndDoActions(PDPSelectors.title.get());
			}

			getCurrentFunctionName(false);
			return SelectorUtil.textValue.get();
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "PDP tittle selector was not found by seleniuem", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// done-CBI
	public static String getImageSrcID() throws Exception {
		try {
			getCurrentFunctionName(true);
			WebElement product = SelectorUtil.getElement(PDPSelectors.imgID.get());

			String imgString = product.getAttribute("src");
			String imgID = imgString.substring(imgString.indexOf("Ryllace") + 8, imgString.indexOf("Ryllace") + 13);

			getCurrentFunctionName(false);
			return imgID;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static void closeOpendItem() throws Exception {
		try {
			getCurrentFunctionName(true);
			WebElement e = SelectorUtil.getElement(PDPSelectors.personalizedOpenItem.get());
			SelectorUtil.clickOnWebElement(e);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
		}

	}

	// done - SMK
	public static String GHgetOptionClass(int index) throws Exception {
		try {
			getCurrentFunctionName(true);
			String Str = PDPSelectors.GHfirstSwatchInOptions.get();
			String ID = SelectorUtil.getAttrString(Str, "class", index);
			getCurrentFunctionName(false);
			return ID;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Swatches in PDP selector was not found by seleniuem",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	/**
	 * Get the selected quantity.
	 *
	 * @return integer.
	 * @throws Exception
	 */
	public static int getQuantity(boolean bundle, String ProductID) throws Exception {
		try {
			getCurrentFunctionName(true);
			String quantitySelector = PDPSelectors.quantity.get();

			// Bundle product selector.
			if (bundle) {

				if (isMobile() && isBD()) {

					quantitySelector = PDPSelectors.BDQuantityBundleMobile.get();
				}

				else {
					if (ProductID.isEmpty()) {
						ProductID = getProductID(0);
					}

					quantitySelector = MessageFormat.format(PDPSelectors.quantityBundle.get(), ProductID);
					if (ProductID == null) {
						quantitySelector = PDPSelectors.quantityBundle.get();
					}
				}
			}
			WebElement quantity = SelectorUtil.getElement(quantitySelector);

			String quantityText = quantity.getAttribute("value");
			if (isMobile()) {
				// The qunatity is a div not an input.
				quantityText = quantity.getText();
			}

			int quantityValue = Integer.parseInt(quantityText);
			getCurrentFunctionName(false);
			return quantityValue;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static void selectQuantity(boolean bundle, String ProductID) throws Exception {
		try {
			getCurrentFunctionName(true);
			String incrementQuantitySelector = PDPSelectors.incrementQuantity.get();
			// Bundle product selector.
			if (bundle) {
				incrementQuantitySelector = MessageFormat.format(PDPSelectors.incrementQuantityBundle, ProductID);
				if (isBD() && isMobile()) {
					incrementQuantitySelector = PDPSelectors.incrementQuantity.get();
				}
			}
			SelectorUtil.initializeSelectorsAndDoActions(incrementQuantitySelector);
			getCurrentFunctionName(false);

		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// Done SMK
	public static boolean validateMobileBundlePriceIsDisplayed() throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisplayed;
			logs.debug("Validate if top price exist");
			String selector = PDPSelectors.miniPDPPrice.get();
			isDisplayed = SelectorUtil.isDisplayed(selector);
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Bundle price selector was not found by seleniuem", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

}