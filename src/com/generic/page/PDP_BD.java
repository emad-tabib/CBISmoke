package com.generic.page;

import java.text.MessageFormat;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.generic.page.PDP.*;
import com.generic.selector.PDPSelectors;
import com.generic.setup.ExceptionMsg;
import com.generic.setup.SelTestCase;
import com.generic.util.SelectorUtil;

public class PDP_BD extends SelTestCase {

	// done - SMK
	public static String BDgetBottomPrice(String ProductID, boolean bundle) throws Exception {
		try {
			getCurrentFunctionName(true);
			String price = "";
			String selector;
			if (isMobile())
				selector = PDPSelectors.BDallSizes.get();
			else if (bundle)
				selector = MessageFormat.format(PDPSelectors.BDListBoxBundle, ProductID) + ">option:nth-child(2)";
			else
				selector = PDPSelectors.BDallSizes.get();
			String optionText = SelectorUtil.getElement(selector).getText();
			price = optionText.substring(optionText.lastIndexOf("$") + 1);
			getCurrentFunctionName(false);
			return price;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Bottom price  selector was not found by seleniuem",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// done - SMK
	public static boolean BDselectSwatches(Boolean bundle, String ProductID) throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isPriceShownInOption = false;
			if (bundle) {
				isPriceShownInOption = BDselectSwatchesBundle(ProductID);
			} else {

				Boolean noOptions = true;
				if (SelTestCase.isMobile())
					noOptions = !PDP_cart.getAddToCartClass();
				else
					noOptions = PDP_selectSwatches.getSwatchContainersdivClass(0).contains("no-options");

				isPriceShownInOption = !noOptions;
				PDP_selectSwatches.FGGRselectSwatchesSingle();
			}
			getCurrentFunctionName(false);
			return isPriceShownInOption;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed + "select swatch was failed", new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static boolean isPriceShownInSizeOption() throws Exception {
		try {
			getCurrentFunctionName(true);
			Boolean isShown = false;
			if (!SelectorUtil.isNotDisplayed(PDPSelectors.BD_size_option.get())) {
				if (SelectorUtil.getElement(PDPSelectors.BD_size_option.get()).getText().contains("$")) {
					isShown = true;
				} else {
					isShown = false;
				}
			}

			getCurrentFunctionName(false);
			return isShown;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed + "select swatch was failed", new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static boolean BDselectSwatchesBundle(String ProductID) throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isSizeShownAsListbox = false;
			int numberOfSwatchContainers = PDP_selectSwatches.getNumberofSwatchContainersBundle();
			if ((numberOfSwatchContainers == 0)
					|| PDP_selectSwatches.getSwatchContainersdivClassBundle(0, ProductID).contains("no-options")) {
				logs.debug("No options to select");
			} else {
				String ListSelector;
				if (isMobile())
					ListSelector = PDPSelectors.BDallSizes.get();
				else
					ListSelector = MessageFormat.format(PDPSelectors.BDListBoxBundle, ProductID);

				for (int i = 0; i < numberOfSwatchContainers; i++) {

					if (PDP_selectSwatches.getSwatchContainersdivClassBundle(i, ProductID).contains("listbox")
							|| !SelectorUtil.isNotDisplayed(PDPSelectors.BDallSizes.get())) {
						isSizeShownAsListbox = true;
						if (!SelectorUtil.isNotDisplayed(ListSelector))
							PDP_selectSwatches.selectNthListBoxFirstValueBundle(ListSelector, i);
					} else {
						if (isMobile()) {
							SelectorUtil.initializeSelectorsAndDoActions(
									MessageFormat.format(PDPSelectors.BDimageOption.get(), 1, i + 1, 1));
							WebElement element = SelectorUtil
									.getElement(MessageFormat.format(PDPSelectors.BDimageOption.get(), 1, i + 1, 1));
							Actions action = new Actions(getDriver());
							action.moveToElement(element).click().build().perform();

						} else {
							PDP_selectSwatches
									.selectNthOptionFirstSwatchBundle("css,#" + ProductID + " " + MessageFormat
											.format(PDPSelectors.BDimageOption.get(), i + 1, 1).replace("css,", ""));

						}
					}
				}

			}

			getCurrentFunctionName(false);
			return isSizeShownAsListbox;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "Select swatches has falied, a selector was not found by selenium", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static String getPersonaliztionCost(String ProductID, Boolean bundle) throws Exception {
		try {
			getCurrentFunctionName(true);
			String cost = "Free";
			String costSelector = PDPSelectors.BDPersonalizationCost.get();
			if (!isMobile()) {
				if (bundle)
					costSelector = "css,#" + ProductID + " "
							+ PDPSelectors.BDPersonalizationCost.get().replace("css,", "");
				if (!SelectorUtil.isNotDisplayed(costSelector))
					cost = SelectorUtil.getElement(costSelector).getText();
			} else {
				if (!SelectorUtil.isNotDisplayed(costSelector)) {
					String text = SelectorUtil.getElement(costSelector).getText();
					cost = text.substring(text.lastIndexOf("$") + 1);
				}
			}
			getCurrentFunctionName(false);
			return cost;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Personalization cost selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static String isPersonaliztionCostDisplayedInMonogramDetails(String ProductID, Boolean bundle)
			throws Exception {
		try {
			getCurrentFunctionName(true);
			String cost = "";
			String details = "";

			String monogramDetails = PDPSelectors.BDaddedPersonlizedDetails.get();
			if (bundle && !isMobile())
				monogramDetails = "css,#" + ProductID + " "
						+ PDPSelectors.BDaddedPersonlizedDetails.get().replace("css,", "");
			details = SelectorUtil.getElement(monogramDetails).getText();
			if (!details.equalsIgnoreCase("None")) {
				String productMonogramCost = PDPSelectors.BDMonogramCost.get();
				if (bundle && !isMobile()) {
					productMonogramCost = "css,#" + ProductID + " "
							+ PDPSelectors.BDMonogramCost.get().replace("css,", "");
				}
				cost = SelectorUtil.getElement(productMonogramCost).getText();
			}
			getCurrentFunctionName(false);
			return cost;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Personalization cost selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static int BDgetNumberOfConfigureItems(boolean bundle, int productNo) throws Exception {
		try {
			getCurrentFunctionName(true);
			int number = 0;
			if (isMobile()) {
				if (bundle)
					number = SelectorUtil
							.getAllElements(MessageFormat.format(PDPSelectors.BDconfigureItemsBundle.get(), productNo))
							.size();
				else
					number = SelectorUtil
							.getAllElements(MessageFormat.format(PDPSelectors.BDconfigureItems.get(), productNo + 1))
							.size();
			} else {
				if (bundle)
					number = SelectorUtil
							.getAllElements(MessageFormat.format(PDPSelectors.BDconfigureItemsBundle.get(), productNo))
							.size();
				else
					number = SelectorUtil
							.getAllElements(MessageFormat.format(PDPSelectors.BDconfigureItems.get(), productNo))
							.size();
			}
			getCurrentFunctionName(false);
			return number;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed
							+ "Get number of configure items has falied, a selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	public static void BDSelectItemsConfigurations(boolean bundle) throws Exception {
		try {
			int productsNo = 0;
			if (bundle) {
				productsNo = SelectorUtil.getAllElements(PDPSelectors.BDproductsBundle.get()).size();
			} else {
				productsNo = SelectorUtil.getAllElements(PDPSelectors.BDproducts.get()).size();
			}
			for (int i = 0; i < productsNo; i++) {
				BDnthProductConfigureItemsSelection(i + 1, bundle);
			}
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed
							+ "Select Items Configurations has falied, a selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static boolean BDnthProductConfigureItemsSelection(int productNo, boolean bundle) throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isSizeShownAsListbox = false;
			int numberOfconfigureItems = PDP_BD.BDgetNumberOfConfigureItems(bundle, productNo);
			if ((numberOfconfigureItems == 0)) {
				logs.debug("No configuration to select");
			} else {

				for (int i = 0; i < numberOfconfigureItems; i++) {
					if (SelectorUtil
							.isNotDisplayed(MessageFormat.format(PDPSelectors.BDopenedConfigureItem.get(), i + 1))) {
						int index = i + 1;
						if (!isMobile() && !bundle)
							SelectorUtil.initializeSelectorsAndDoActions(
									MessageFormat.format(PDPSelectors.BDconfigureItems.get(), productNo) + ":nth-child("
											+ index + ")");
						if (isMobile() && bundle && index == 1) {
							// SelectorUtil.initializeSelectorsAndDoActions(MessageFormat.format(PDPSelectors.BDitemsAccordion.get(),productNo,index));
						}
					}
					if (isMobile()) {
						if (bundle) {
							selectOption(MessageFormat.format(PDPSelectors.BDnthConfigureItemOptionBundle.get(),
									productNo, i + 1));
						} else {
							SelectorUtil.initializeSelectorsAndDoActions(MessageFormat
									.format(PDPSelectors.BDnthConfigureItemOption.get(), productNo + 1, i + 1));
						}
					} else {
						if (bundle)
							selectOption(MessageFormat.format(PDPSelectors.BDnthConfigureItemOptionBundle.get(),
									productNo, i + 2));
						else
							SelectorUtil.initializeSelectorsAndDoActions(MessageFormat
									.format(PDPSelectors.BDnthConfigureItemOption.get(), productNo, i + 1));
					}
				}
			}

			getCurrentFunctionName(false);
			return isSizeShownAsListbox;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed
							+ "Product Configure Items Selection has falied, a selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static boolean validatePriceIsDisplayed() throws Exception {
		try {
			boolean isDisplayed = false;
			isDisplayed = SelectorUtil.isDisplayed(PDPSelectors.BDVK_PDPPrice.get());
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "price  not displayed, a selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	public static boolean validatePDP_PC_TopPriceIsDisplayed() throws Exception {
		try {
			boolean isDisplayed = false;
			isDisplayed = SelectorUtil.isDisplayed(PDPSelectors.BDPDP_PCtopPrice.get());
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Top price  not displayed, a selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	public static String validatePDP_PC_BottomPriceIsDisplayed() throws Exception {
		try {
			String price = "";
			SelectorUtil.initializeSelectorsAndDoActions(PDPSelectors.BDPDP_PCbottomPrice.get());
			price = SelectorUtil.textValue.get();
			getCurrentFunctionName(false);
			return price;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "Bottom price  not displayed, a selector was not found by selenium", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	public static void clickOnConfigureBtn(String ProductID) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Click on Configure button");
			if (isMobile())
				SelectorUtil.initializeSelectorsAndDoActions(PDPSelectors.BDconfigureBtn.get());
			else
				SelectorUtil.initializeSelectorsAndDoActions(
						"css,#" + ProductID + " " + PDPSelectors.BDconfigureBtn.get().replace("css,", ""));

			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Configure button selector was not found by seleniuem",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static void clickOnConfigureModalDoneBtn() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Click on Configure modal Done button");
			SelectorUtil.initializeSelectorsAndDoActions(PDPSelectors.BDconfigureModalDoneBtn.get());
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Configure modal done button selector was not found by seleniuem",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static void selectOption(String Selector) throws Exception {
		try {
			getCurrentFunctionName(true);
			Thread.sleep(1000);
			if (!SelectorUtil.isNotDisplayed(Selector)) {
				SelectorUtil.initializeSelectorsAndDoActions(Selector);
			}
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	public static boolean validateTheRightPDP(String targetedItem) throws Exception {
		boolean isRightItem = false;
		try {
			getCurrentFunctionName(true);
			logs.debug("Validate if you are in the right PDP");

			String itemTitle = SelectorUtil.getElement(PDPSelectors.BDItemTitle.get()).getText();
			isRightItem = itemTitle.contains("Fabric");

			return isRightItem;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "PDP Item Title selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	public static boolean validateFabricAddToCartIsEnabled() throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisplayed;
			logs.debug("Validate if Add To Cart Is Displayed");

			String selectorEnabled = PDPSelectors.FabricAddtoCartBtn.get();
			isDisplayed = SelectorUtil.isDisplayed(selectorEnabled);
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Add to cart button selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static void clickOnNextBtn() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Click on next button");
			SelectorUtil.initializeSelectorsAndDoActions(PDPSelectors.BDnextButton.get());
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Next button selector was not found by seleniuem", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static void clickStartDesignBtn() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Click on start design  button");
			SelectorUtil.initializeSelectorsAndDoActions(PDPSelectors.BDstartDesignBtn.get());
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "start design button selector was not found by seleniuem",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static void clickOnSaveBtn() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Click on save button");
			SelectorUtil.initializeSelectorsAndDoActions(PDPSelectors.BDsaveBtn.get());
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "save button selector was not found by seleniuem", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static void clickAddToCartBtn() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Click on add to cart button");
			SelectorUtil.initializeSelectorsAndDoActions(PDPSelectors.BDAddToCart_PDP_PC.get());
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Add to cart button selector was not found by seleniuem",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static boolean isaddToWLGRbtnEnabled() throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisplayed = false;
			logs.debug("Validate if Add To WL/GR Is Displayed");
			isDisplayed = SelectorUtil.isDisplayed(PDPSelectors.BDPDP_PCaddToWLGRBtnEnabled.get());
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Add to WL/GR button selector was not found by seleniuem",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static void clickAddToCartButton() throws Exception {
		try {
			getCurrentFunctionName(true);
			String subStrArr = null;
			subStrArr = PDPSelectors.FabricAddtoCartBtn.get();
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

	public static boolean isaddToCartbtnEnabled() throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisplayed = false;
			logs.debug("Validate if Add To cart Is Displayed");
			isDisplayed = SelectorUtil.isDisplayed(PDPSelectors.BDAddToCart_PDP_PC.get());
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Add to cart button selector was not found by seleniuem",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static void pickOneQuantity() throws Exception {
		try {

			String subStrArr = PDPSelectors.pickOneFreeSwatch.get();
			WebElement increment = SelectorUtil.getElement(subStrArr);

			SelectorUtil.clickOnWebElement(increment);
			logs.debug("Select One Item");

			getCurrentFunctionName(false);

		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Increment selector was not found by seleniuem", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static void clickOnPCoptions() throws Exception {
		try {
			getCurrentFunctionName(true);
			List<WebElement> options = SelectorUtil.getAllElements(PDPSelectors.BDPCoptions.get());
			Random random = new Random();
			int randomIndex = random.nextInt(options.size() - 1);
			WebElement element = options.get(randomIndex);
			if (isMobile()) {
				Actions action = new Actions(getDriver());
				action.moveToElement(element).click().build().perform();
			} else {
				SelectorUtil.clickOnWebElement(element);
			}
			Thread.sleep(2000);
			if (!SelectorUtil.isNotDisplayed(PDPSelectors.BDremovePrevSelectionModal.get())) {
				SelectorUtil.initializeSelectorsAndDoActions(PDPSelectors.BDremovePrevSelectionModalConfirmBtn.get());

			}
			logs.debug("Click on option");
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Click on option selector was not found by seleniuem",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static void selectConfigureSwatches() throws Exception {
		try {
			getCurrentFunctionName(true);

			while (!SelectorUtil.isNotDisplayed(PDPSelectors.BDnextButton.get())) {
				PDP_BD.clickOnPCoptions();
				Thread.sleep(2500);
				PDP_BD.clickOnNextBtn();

			}
			logs.debug("Select configure swatches ");
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed
							+ "Select configure swatches has failed, selector was not found by seleniuem",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static void clickAddToFreeSwatch() throws Exception {
		try {
			getCurrentFunctionName(true);
			String subStrArr = null;
			subStrArr = PDPSelectors.FabricAddFreeSwatchtoCartBtn.get();
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "Add free swatch to cart button selector was not found by selenium", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static boolean validateProductIsAddedToCart() throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisplayed;
			Thread.sleep(1000);
			isDisplayed = SelectorUtil.isDisplayed(PDPSelectors.BDaddToCartModal.get());
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
}
