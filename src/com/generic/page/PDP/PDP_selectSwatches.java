package com.generic.page.PDP;

import java.text.MessageFormat;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import com.generic.page.PDP_BD;
import com.generic.selector.PDPSelectors;
import com.generic.setup.Common;
import com.generic.setup.ExceptionMsg;
import com.generic.setup.GlobalVariables;
import com.generic.setup.LoggingMsg;
import com.generic.setup.SelTestCase;
import com.generic.util.SelectorUtil;

public class PDP_selectSwatches extends SelTestCase{
	// done - SMK
	public static void selectSwatches() throws Exception {
		try {
			getCurrentFunctionName(true);
			Boolean bundle = PDP.bundleProduct();
			if (isFGGR() || isBD()) {
				String ProductID = null;
				if (!isMobile() && bundle)
					ProductID = PDP.getProductID(0);
				selectSwatches(bundle, ProductID);
			} else if (isGHRY()) {
				String ProductID = null;
				if (bundle)
					ProductID = PDP.getProductID(0);
				GHRYselectSwatches(bundle, ProductID);
			}


			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "swatch selector was not found by seleniuem", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	// done - SMK
	public static void selectSwatches(Boolean bundle, String ProductID) throws Exception {
		try {
			getCurrentFunctionName(true);
			if (isFGGR()) {
				if (!isMobile() && bundle) {
					FGGRselectSwatchesBundle(ProductID);

				} else {
					FGGRselectSwatchesSingle();
				}

			} else if (isGHRY()) {
				GHRYselectSwatches(bundle, ProductID);
			}
			else if (isBD()) {
				PDP_BD.BDselectSwatches(bundle, ProductID);
			}
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed + "select swatch was failed", new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	

	// Done SMK
	public static void FGGRselectSwatchesBundle(String ProductID) throws Exception {
		try {
			getCurrentFunctionName(true);
			int numberOfSwatchContainers = getNumberofSwatchContainersBundle();
			if (getSwatchContainersdivClassBundle(0, ProductID).contains("no-options")) {
				logs.debug("No options to select");
			} else {
				String ListSelector = MessageFormat.format(PDPSelectors.ListBoxBundle, ProductID);
				for (int i = 0; i < numberOfSwatchContainers; i++) {
					if (getSwatchContainersdivClassBundle(i, ProductID).contains("listbox")) {
						selectNthListBoxFirstValueBundle(ListSelector, i);

					} else {
						selectNthOptionFirstSwatchBundle("css,#" + ProductID + ">"
								+ MessageFormat.format(PDPSelectors.imageOption.get(), i + 1, 1).replace("css,", ""));
					}
				}

			}
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "Select swatches has falied, a selector was not found by selenium", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static void FGGRselectSwatchesSingle() throws Exception {
		try {
			getCurrentFunctionName(true);
			Boolean noOptions = true;
			if (SelTestCase.isMobile())
				noOptions = !PDP_cart.getAddToCartClass();
			else
				noOptions = getSwatchContainersdivClass(0).contains("no-options");

			if (noOptions) {
				logs.debug("No options to select");
			} else if (!SelTestCase.isMobile()) {
				int numberOfSwatchContainers = getNumberofSwatchContainers();
				for (int i = 0; i < numberOfSwatchContainers; i++) {
					if (getSwatchContainersdivClass(i).contains("listbox")) {
						selectNthListBoxFirstValue(i);
					} else {
						selectNthOptionFirstSwatch(i + 1);
					}
				}
			} else {
				int numberOfSwatchContainers = getNumberofSwatchContainers();
				for (int i = 1; i < numberOfSwatchContainers; i += 2) {
					if (getSwatchContainersdivClass(i).contains("u-product-options")) {
						selectNthListBoxFirstValue((i - 1) / 2);
					} else {
						selectNthOptionFirstSwatch((i + 1) / 2);
					}
				}
			}
			getCurrentFunctionName(false);

		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "Select swatches has falied, a selector was not found by selenium", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	
	// done - SMK
	public static String getSwatchContainersdivClass(int index) throws Exception {
		try {
			getCurrentFunctionName(true);
			String Str;
			if (!isBD()) {
				Str = PDPSelectors.FGGRSwatchesOptions.get();
			}
			else {
				Str = PDPSelectors.BDSwatchesOptions.get();
			}
			String SwatchContainerClass = SelectorUtil.getAttrString(Str, "class", index);
			logs.debug("SwatchContainerClass: " + SwatchContainerClass);
			getCurrentFunctionName(false);
			return SwatchContainerClass;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "swatches selector was not found by seleniuem", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	// done - SMK
	public static void selectNthOptionFirstSwatch(int index) throws Exception {
		try {
			getCurrentFunctionName(true);
			String subStrArr;
			if (isBD())
				subStrArr = MessageFormat.format(PDPSelectors.BDfirstSwatchInOptions.get(), index);
			else
				subStrArr = MessageFormat.format(PDPSelectors.firstSwatchInOptions.get(), index);
			logs.debug(MessageFormat.format(LoggingMsg.CLICKING_SEL, subStrArr));
			String nthSel = subStrArr;
			// Clicking on the div on desktop and iPad does not select the options,
			// you need to click on the img if there is an img tag.
			if (!SelTestCase.isMobile()) {
				String nthSel2;
				if (isBD())
					nthSel2 = subStrArr  + " img";
				else
					nthSel2 = subStrArr + ">img";
				if (!SelectorUtil.isNotDisplayed(nthSel2))
					if (isBD())
						nthSel = subStrArr + " img";
					else
						nthSel = subStrArr + ">img";
			}
		
			SelectorUtil.initializeSelectorsAndDoActions(nthSel);

			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Swatch selector was not found by selenium", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	

	// done - SMK
	public static int getNumberofSwatchContainers() throws Exception {
		try {
			getCurrentFunctionName(true);
			String Str;
			if (isBD()) {
				Str = PDPSelectors.BDSwatchesOptions.get();
				}
			else {
				Str = PDPSelectors.FGGRSwatchesOptions.get();
			}
			int numberOfSwatchContainers = SelectorUtil.getAllElements(Str).size();
			logs.debug("Number of Swatch Containers: " + numberOfSwatchContainers);
			getCurrentFunctionName(false);
			return numberOfSwatchContainers;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "swatches selector was not found by seleniuem", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	// done - SMK
		public static void selectNthListBoxFirstValue(int index) throws Exception {
			try {
				getCurrentFunctionName(true);
				String Str;
				String value;
				if (isBD()) {
					Str = PDPSelectors.BDallSizes.get();
					value = "FFF1";
				} else {
					Str = PDPSelectors.allSizes.get();
					value = "FFF1";
				}
				SelectorUtil.initializeSelectorsAndDoActions(Str, value);
				getCurrentFunctionName(false);
			} catch (NoSuchElementException e) {
				logs.debug(MessageFormat.format(
						ExceptionMsg.PageFunctionFailed + "Add to cart close button selector was not found by selenium",
						new Object() {
						}.getClass().getEnclosingMethod().getName()));
				throw e;
			}
		}
		
		// done - SMK
		public static int getNumberofSwatchContainersBundle() throws Exception {
			try {
				getCurrentFunctionName(true);
				String Str = "";
				int numberOfSwatchContainers = 0;
				if (!isBD())
					Str = "css,#" + PDP.getProductID(0) + ">" + PDPSelectors.FGGRSwatchesOptions.get().replace("css,", "");
				else {
					if (isMobile()) {
						String optionsContainer = PDPSelectors.BDoptionsContainer.get();

						if (SelectorUtil.isNotDisplayed(optionsContainer)) {
							return numberOfSwatchContainers;
						} else {
							Str = PDPSelectors.BDBundleSwatchesOptions.get();
						}
					} else {
						Str = "css,#" + PDP.getProductID(0) + " "
								+ PDPSelectors.BDBundleSwatchesOptions.get().replace("css,", "");
					}
				}
				numberOfSwatchContainers = SelectorUtil.getAllElements(Str).size();
				logs.debug("Number of Swatch Containers: " + numberOfSwatchContainers);
				getCurrentFunctionName(false);
				return numberOfSwatchContainers;
			} catch (NoSuchElementException e) {
				logs.debug(MessageFormat.format(
						ExceptionMsg.PageFunctionFailed + "swatches selector was not found by seleniuem", new Object() {
						}.getClass().getEnclosingMethod().getName()));
				throw e;
			}
		}
		
		// done - SMK
		public static void selectNthOptionFirstSwatchBundle(String Str) throws Exception {
			try {
				getCurrentFunctionName(true);
				// String StrBundle = MessageFormat.format(Str, index);
				logs.debug(MessageFormat.format(LoggingMsg.CLICKING_SEL, Str));
				SelectorUtil.initializeSelectorsAndDoActions(Str);
				// Clicking on the div on desktop and iPad does not select the options,
				// you need to click on the img if there is an img tag.
				if (!isMobile()) {
					String nthSel = Str + ">img";
					if (!SelectorUtil.isNotDisplayed(nthSel))
						SelectorUtil.initializeSelectorsAndDoActions(nthSel);
				}
				getCurrentFunctionName(false);
			} catch (NoSuchElementException e) {
				logs.debug(MessageFormat.format(
						ExceptionMsg.PageFunctionFailed + "swatch selector was not found by seleniuem", new Object() {
						}.getClass().getEnclosingMethod().getName()));
				throw e;
			}
		}
		
		public static String getSwatchContainersdivClassBundle(int index, String ProductID) throws Exception {
			try {
				getCurrentFunctionName(true);
				String Str;
				if (!isBD()) {
					Str = "css,#" + ProductID + ">" + PDPSelectors.FGGRSwatchesOptions.get().replace("css,", "");
				}
				else {
					Str = "css,#" + ProductID + " " + PDPSelectors.BDSwatchesOptions.get().replace("css,", "");
				}
				if (isBD() && isMobile()) {
					Str = PDPSelectors.BDSwatchesOptions.get();
				}

				String SwatchContainerClass = SelectorUtil.getAttrString(Str, "class", index);
				logs.debug("SwatchContainerClass: " + SwatchContainerClass);
				getCurrentFunctionName(false);
				return SwatchContainerClass;
			} catch (NoSuchElementException e) {
				logs.debug(MessageFormat.format(
						ExceptionMsg.PageFunctionFailed + "Swatches button selector was not found by seleniuem",
						new Object() {
						}.getClass().getEnclosingMethod().getName()));
				throw e;
			}
		}
		
		public static void GHRYselectSwatches(Boolean bundle, String ProductID) throws Exception {
			try {
				getCurrentFunctionName(true);
				GHRYselectColor(bundle, ProductID);
				int numberOfPanels = GHRYNumberOfOptions(bundle);
				logs.debug("numberOfPanels: " + numberOfPanels);

				if (numberOfPanels > 1)
					GHRYselectSize(bundle, ProductID);
				getCurrentFunctionName(false);

			} catch (NoSuchElementException e) {
				logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
				}.getClass().getEnclosingMethod().getName()));
				throw e;
			}
		}
		
		// done - SMK
		public static void GHRYselectSize(Boolean bundle, String ProductID) throws Exception {
			try {
				getCurrentFunctionName(true);
				String subStrArr = (PDPSelectors.GHRYSizeOptions.get());

				// Bundle product selector.
				if (bundle) {
					subStrArr = MessageFormat.format(PDPSelectors.GHRYSizeOptionsBundle.get(), ProductID);
				}
				List<WebElement> list = SelectorUtil.getAllElements(subStrArr);
				logs.debug("Number of size options:" + list.size());
				for (int index = 0; index < list.size(); index++) {
					String classValue = SelectorUtil.getAttrString(subStrArr, "class", index);
					if (!classValue.contains("no-available") && !classValue.contains("disabled")) {
						String nthSel = subStrArr ;//+ ">div";
						WebElement item = getDriver().findElements(By.cssSelector(nthSel)).get(index);
						JavascriptExecutor jse = (JavascriptExecutor) getDriver();
						jse.executeScript("arguments[0].scrollIntoView(false)", item);
						if (isMobile())
							Thread.sleep(1000);
						((JavascriptExecutor) getDriver()).executeScript("arguments[0].click()", item);
						break;
					}
				}
				getCurrentFunctionName(false);
			} catch (Exception e) {
				logs.debug("e.getMessage()" + e.getMessage());
				if (!(e.getMessage() == null) && e.getMessage().contains("element click intercepted")) {
					logs.debug(MessageFormat.format(LoggingMsg.FORMATTED_ERROR_MSG, e.getMessage()));
					logs.debug("Refresh the browser to close the Intercepted windows");
					Common.refreshBrowser();
					PDP.clickBundleItems();
					// update the product id after the refresh
					if (bundle)
						ProductID = PDP.getProductID(0);
					GHRYselectColor(bundle, ProductID);
					GHRYselectSize(bundle, ProductID);
				} else {
					logs.debug(MessageFormat.format(
							ExceptionMsg.PageFunctionFailed + "Size option selector was not found by seleniuem",
							new Object() {
							}.getClass().getEnclosingMethod().getName()));
					throw e;
				}
			}
		}
		
		// done - SMK
		public static void GHRYselectColor(Boolean bundle, String ProductID) throws Exception {

			try {
				getCurrentFunctionName(true);
				GHRYselectColorTemplate(bundle, ProductID);
				getCurrentFunctionName(false);
			} catch (Exception e) {
				if (!(e.getMessage() == null) && e.getMessage().contains("element click intercepted")) {
					logs.debug(MessageFormat.format(LoggingMsg.FORMATTED_ERROR_MSG, e.getMessage()));
					logs.debug("Refresh the browser to close the Intercepted windows");
					Common.refreshBrowser();
					PDP.clickBundleItems();
					// update the product id after the refresh
					if (bundle)
						ProductID = PDP.getProductID(0);
					GHRYselectColorTemplate(bundle, ProductID);
				} else {
					logs.debug(MessageFormat.format(
							ExceptionMsg.PageFunctionFailed + " Aplication was not able to select color swatch",
							new Object() {
							}.getClass().getEnclosingMethod().getName()));
					throw e;
				}
			}
		}
		
		// done - SMK
		public static void GHRYselectColorTemplate(Boolean bundle, String ProductID) throws Exception {
			try {
				getCurrentFunctionName(true);

				String subStrArr = (PDPSelectors.GHRYColorOptions.get());

				// Bundle product selector.
				if (bundle) {
					// ProductID = getProductID(0);
					subStrArr = MessageFormat.format(PDPSelectors.GHRYColorOptionsBundle.get(), ProductID);
				}
				List<WebElement> list = SelectorUtil.getAllElements(subStrArr);
				logs.debug("Number of color options:" + list.size());
				String classValue;
				for (int index = 0; index < list.size(); index++) {
					classValue = SelectorUtil.getAttrString(subStrArr, "class", index);
					if (!classValue.contains("no-available") && !classValue.contains("disabled")) {
						WebElement item;
						if (!isMobile()) {
							item = SelectorUtil.getAllElements(subStrArr + " .gwt-image-picker-option-image").get(index);
						} else {
							item = list.get(index);
						}
						JavascriptExecutor jse = (JavascriptExecutor) getDriver();
						jse.executeScript("arguments[0].scrollIntoView(false)", item);
						item.click();
						break;
					}
				}
				getCurrentFunctionName(false);
			} catch (NoSuchElementException e) {
				logs.debug(MessageFormat.format(
						ExceptionMsg.PageFunctionFailed + "Color option selector was not found by seleniuem", new Object() {
						}.getClass().getEnclosingMethod().getName()));
				throw e;
			}
		}
		
		/**
		 * Get the number options for GH & RY.
		 *
		 * @throws Exception
		 */
		public static int GHRYNumberOfOptions(Boolean bundle) throws Exception {
			getCurrentFunctionName(true);
			String subStrArr = PDPSelectors.avaibleOptions.get();

			// Bundle product selector.
			if (bundle) {
				String ProductID = PDP.getProductID(0);
				subStrArr = MessageFormat.format(PDPSelectors.GHAvailableOptionsBundle.get(), ProductID);
			}

			// Check if options is displayed.
			int numberOfAvaibleOptions = 0;
			if (!SelectorUtil.isNotDisplayed(subStrArr)) {
				numberOfAvaibleOptions = SelectorUtil.getAllElements(subStrArr).size();
			}
			logs.debug("number Of Avaible Options" + numberOfAvaibleOptions);
			getCurrentFunctionName(false);
			return numberOfAvaibleOptions;
		}
		
		// done - SMK
		public static void selectNthListBoxFirstValueBundle(String Str, int index) throws Exception {
			try {
				getCurrentFunctionName(true);
				String value = "index," + index + ",FFF1";
				SelectorUtil.initializeSelectorsAndDoActions(Str, value);
				getCurrentFunctionName(false);
			} catch (NoSuchElementException e) {
				logs.debug(MessageFormat.format(
						ExceptionMsg.PageFunctionFailed + "listbox item selector was not found by seleniuem", new Object() {
						}.getClass().getEnclosingMethod().getName()));
				throw e;
			}
		}
}
