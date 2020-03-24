package com.generic.page.PDP;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.generic.selector.PDPSelectors;
import com.generic.setup.ExceptionMsg;
import com.generic.setup.SelTestCase;
import com.generic.util.RandomUtilities;
import com.generic.util.SelectorUtil;

public class PDP_Personalization extends SelTestCase {
	public static boolean validateTotalPriceAfterAddedPersonalized(String intialPrice, String finalPrice)
			throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isChanged = true;
			if (intialPrice.equals(finalPrice)) {
				isChanged = false;
			}
			getCurrentFunctionName(false);
			return isChanged;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static boolean validateAddedPersonalizedDetails(Boolean Bundle, String ProductID) throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isAdded = true;
			String addedPersonlizedDetailsSelector = PDPSelectors.addedPersonlizedDetails.get();
			if (isGH()) {
				addedPersonlizedDetailsSelector = PDPSelectors.GHAddedPersonlizedDetails.get();
			} else if (isBD()) {
				addedPersonlizedDetailsSelector = PDPSelectors.BDaddedPersonlizedDetails.get();
			}
			if (!isMobile() && Bundle) {
				if (isBD())
					addedPersonlizedDetailsSelector = "css,#" + ProductID + " "
							+ addedPersonlizedDetailsSelector.replace("css,", "");
				else
					addedPersonlizedDetailsSelector = "css,#" + ProductID + ">"
							+ PDPSelectors.addedPersonlizedDetails.get().replace("css,", "");
			}
			List<WebElement> addedPersonlizedDetailsItems = SelectorUtil
					.getAllElements(addedPersonlizedDetailsSelector);
			if (addedPersonlizedDetailsItems.size() <= 0) {
				isAdded = false;
			}
			getCurrentFunctionName(false);

			return isAdded;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Personalization details selector was not found by seleniuem",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static boolean validatePersonalizedModal() throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisplayed = true;
			isDisplayed = SelectorUtil.isDisplayed(PDPSelectors.personlizedModal.get());
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Personalization modal selector was not found by seleniuem",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static String getTotalPriceAfterAddedPersonalized(Boolean Bundle, String ProductID) throws Exception {
		try {
			getCurrentFunctionName(true);
			String addedPersonlizedDetailsSelector = PDPSelectors.addedPersonlizedDetails.get();
			if (!isMobile() && Bundle) {
				addedPersonlizedDetailsSelector = "css,#" + ProductID + ">"
						+ PDPSelectors.addedPersonlizedDetails.get().replace("css,", "");
			}
			List<WebElement> addedPersonlizedDetailsItems = SelectorUtil
					.getAllElements(addedPersonlizedDetailsSelector);
			WebElement totalPriceElement = addedPersonlizedDetailsItems.get(addedPersonlizedDetailsItems.size() - 1);
			String totalPrice = totalPriceElement.getText();
			logs.debug("totalPriceElement:  " + totalPrice);
			getCurrentFunctionName(false);
			return totalPrice;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Personalization details selector was not found by seleniuem",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// Done SMK
	public static boolean PersonalizedItem(Boolean Bundle, String ProductID) throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisplayed = false;
			if (isGH()) {

				isDisplayed = SelectorUtil.isDisplayed(PDPSelectors.personalizationIdentiferGH.get());
				getCurrentFunctionName(false);
				logs.debug("PDP is personalizable result is:" + isDisplayed);
				return isDisplayed;

			} else {
				String addPersonalizedButtonSelector = PDPSelectors.addPersonalizedButton.get();
				if (isBD())
					addPersonalizedButtonSelector = PDPSelectors.BDaddPersonalizedButton.get();

				if (!isMobile() && Bundle) {
					if (isBD())
						addPersonalizedButtonSelector = "css,#" + ProductID + " "
								+ PDPSelectors.BDaddPersonalizedButton.get().replace("css,", "");
					else {
						addPersonalizedButtonSelector = "css,#" + ProductID + ">"
								+ PDPSelectors.addPersonalizedButton.get().replace("css,", "");
						logs.debug("addPersonalizedButtonSelector:  " + addPersonalizedButtonSelector);
					}
				}
				isDisplayed = SelectorUtil.isDisplayed(addPersonalizedButtonSelector);
				getCurrentFunctionName(false);
				return isDisplayed;
			}
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static void clickAddPersonalizationButton(Boolean Bundle, String ProductID) throws Exception {
		try {
			getCurrentFunctionName(true);

			String addPersonalizedButtonSelector = PDPSelectors.addPersonalizedButton.get();
			if (isGH()) {
				addPersonalizedButtonSelector = PDPSelectors.addPersonalizedButtonGH.get();
			}
			if (isBD())
				addPersonalizedButtonSelector = PDPSelectors.BDaddPersonalizedButton.get();

			if (!isMobile() && Bundle) {
				if (isBD())
					addPersonalizedButtonSelector = "css,#" + ProductID + " "
							+ PDPSelectors.BDaddPersonalizedButton.get().replace("css,", "");
				else {
					addPersonalizedButtonSelector = "css,#" + ProductID + ">"
							+ PDPSelectors.addPersonalizedButton.get().replace("css,", "");
					logs.debug("addPersonalizedButtonSelector:  " + addPersonalizedButtonSelector);
				}
			}

			SelectorUtil.initializeSelectorsAndDoActions(addPersonalizedButtonSelector);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Personalization button selector was not found by seleniuem",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static boolean isFreePersonalization(Boolean Bundle, String ProductID) throws Exception {// check if add
		// personalization
		// free or not
		try {
			getCurrentFunctionName(true);
			boolean isFree = true;
			String addPersonalizedButtonSelector = PDPSelectors.personlizedTitle.get();// for iPhone
			if (isBD())
				addPersonalizedButtonSelector = PDPSelectors.BDpersonlizedTitle.get();
			if (!isMobile()) {
				addPersonalizedButtonSelector = PDPSelectors.addPersonalizedButton.get();// for single PDP
				if (isBD())
					addPersonalizedButtonSelector = PDPSelectors.BDaddPersonalizedButton.get();// for single PDP
				if (Bundle) {// for bundle PDP
					if (isBD())
						addPersonalizedButtonSelector = "css,#" + ProductID + " "
								+ PDPSelectors.BDaddPersonalizedButton.get().replace("css,", "");
					else
						addPersonalizedButtonSelector = "css,#" + ProductID + ">"
								+ PDPSelectors.addPersonalizedButton.get().replace("css,", "");

				}
			}
			WebElement element = SelectorUtil.getElement(addPersonalizedButtonSelector);
			String personalizationText = element.getText().toLowerCase();
			logs.debug("personalizationText:  " + personalizationText);

			if (!personalizationText.contains("free")) {
				isFree = false;
			}
			logs.debug("isFreePersonalization: " + isFree);
			getCurrentFunctionName(false);
			return isFree;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Personalization Price check has failed, a selector is missing",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static void clickPersonalizationSaveAndCloseButton() throws Exception {
		try {
			getCurrentFunctionName(true);
			String subStrArr = PDPSelectors.personalizationSaveAndCloseButton.get();
			if (isGH()) {
				subStrArr = PDPSelectors.GHPersonalizationSaveAndCloseButton.get();
			} else if (isBD()) {
				subStrArr = PDPSelectors.BDpersonalizationSaveAndCloseButton.get();
			}
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "Personalization  save button selector was not found by seleniuem", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static void clickPersonalizationSaveAndCloseButtonForiPhone() throws Exception {
		try {
			getCurrentFunctionName(true);
			List<WebElement> elementsList = SelectorUtil.getAllElements(PDPSelectors.personalizedItems.get());
			WebElement element = elementsList.get(elementsList.size() - 1);
			SelectorUtil.clickOnWebElement(element);
			clickPersonalizationSaveAndCloseButton();
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Personalization save button selector was not found by seleniuem",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static boolean isPersonalizedStyle() throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisplayed = SelectorUtil.isDisplayed(PDPSelectors.personlizedStyleItem.get());
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static boolean isPersonalizedInputSwatchesDisplayed(String value) throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisplayed = SelectorUtil.isDisplayed(value);
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static void selectPersonalizationModalSwatchesForiPhone() throws Exception {
		try {
			getCurrentFunctionName(true);
			PDP.closeOpendItem();
			List<WebElement> elementsList = SelectorUtil.getAllElements(PDPSelectors.personalizedItems.get());
			if (isBD())
				elementsList = SelectorUtil.getAllElements(PDPSelectors.BDpersonalizedItems.get());
			for (int i = 0; i < elementsList.size() - 1; i++) {
				WebElement element = elementsList.get(i);
				SelectorUtil.clickOnWebElement(element);
				String personalizedInputValue = PDPSelectors.personalizedInputValue.get();
				String personalizedItemColors1 = PDPSelectors.personalizedItemColors1.get();

				if (isBD()) {
					personalizedInputValue = PDPSelectors.BDpersonalizedInputValue.get();
				}
				if (isPersonalizedInputSwatchesDisplayed(personalizedInputValue)) {// input container
																					// like MONOGRAM
																					// or any value
					WebElement input = SelectorUtil.getElement(personalizedInputValue);
					input.sendKeys(RandomUtilities.getRandomStringWithLength(3));
				} else if (isPersonalizedInputSwatchesDisplayed(personalizedItemColors1)) { // like
																							// item
																							// color
					List<WebElement> itemColors = SelectorUtil.getAllElements(personalizedItemColors1);
					if (itemColors.size() > 0) {
						WebElement firstItemColor = itemColors.get(0);
						SelectorUtil.clickOnWebElement(firstItemColor);
					}
				} else if (isPersonalizedInputSwatchesDisplayed(PDPSelectors.personalizedItemMenu.get())) {// like item
																											// size
					WebElement menu = SelectorUtil.getElement(PDPSelectors.personalizedItemMenu.get());
					List<WebElement> options = menu
							.findElements(By.cssSelector(PDPSelectors.personalizedMenuOptions.get()));
					options.get(1).click();// the first item is selected size
				}
			}
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed
							+ "Selecting swatches for personalized product selector was not found by seleniuem",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static void selectPersonalizationModalSwatches() throws Exception {
		try {
			getCurrentFunctionName(true);
			PDP.closeOpendItem();
			List<WebElement> elementsList = new ArrayList<WebElement>();
			if (isBD())
				elementsList = SelectorUtil.getAllElements(PDPSelectors.BDpersonalizedItems.get());
			else
				elementsList = SelectorUtil.getAllElements(PDPSelectors.personalizedItems.get());

			for (int i = 0; i < elementsList.size(); i++) {
				WebElement element = elementsList.get(i);
				if (!isBD())
					SelectorUtil.clickOnWebElement(element);

				String inputSwatches = PDPSelectors.personalizedInputValue.get();
				;
				String personalizedItemColor2 = PDPSelectors.personalizedItemColors2.get();
				;

				if (isBD()) {
					inputSwatches = PDPSelectors.BDpersonalizedInputValue.get();
					personalizedItemColor2 = PDPSelectors.BDpersonalizedItemColors2.get();
				}

				if (isPersonalizedInputSwatchesDisplayed(inputSwatches)) {// input container
																			// like MONOGRAM // or any value
					WebElement input = SelectorUtil.getElement(inputSwatches);
					input.sendKeys(RandomUtilities.getRandomStringWithLength(3));
				} else if (isPersonalizedInputSwatchesDisplayed(PDPSelectors.personalizedItemColors1.get())) { // like
																												// item
																												// color
					List<WebElement> itemColors = SelectorUtil
							.getAllElements(PDPSelectors.personalizedItemColors1.get());
					if (itemColors.size() > 0) {
						WebElement firstItemColor = itemColors.get(0);
						SelectorUtil.clickOnWebElement(firstItemColor);
					}
				} else if (isPersonalizedInputSwatchesDisplayed(personalizedItemColor2)) { // like
																							// thread
																							// color
					List<WebElement> itemColors = SelectorUtil.getAllElements(personalizedItemColor2);
					if (itemColors.size() > 0) {
						WebElement firstItemColor = itemColors.get(0);
						SelectorUtil.clickOnWebElement(firstItemColor);
					}

				} else if (isPersonalizedInputSwatchesDisplayed(PDPSelectors.personalizedTypeFaces.get())) {// like
																											// TypeFace
																											// , English
																											// style ,
																											// etching
																											// style
																											// (Roman
					List<WebElement> items = SelectorUtil.getAllElements(PDPSelectors.personalizedTypeFaces.get());
					if (items.size() > 0) {
						WebElement firstItemColor = items.get(0);
						SelectorUtil.clickOnWebElement(firstItemColor);
					}
				} else if (isPersonalizedInputSwatchesDisplayed(PDPSelectors.personalizedItemMenu.get())) {// like item
																											// size
					WebElement menu = SelectorUtil.getElement(PDPSelectors.personalizedItemMenu.get());
					List<WebElement> options = menu
							.findElements(By.cssSelector(PDPSelectors.personalizedMenuOptions.get()));
					options.get(1).click();// the first item is selected size
				}
				// Thread.sleep(1000);
			}
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

}
