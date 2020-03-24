package com.generic.page;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebElement;
import com.generic.setup.ExceptionMsg;
import com.generic.setup.SelTestCase;
import com.generic.util.SelectorUtil;
import com.generic.selector.PDPSelectors;


public class PDP_SC_CS extends SelTestCase {
	
	public static boolean validateTheRightPDP(String targetedItem) throws Exception {
		boolean isRightItem = false;
		try {
			getCurrentFunctionName(true);
			logs.debug("Validate if you are in the right PDP");
			
			String itemTitle = SelectorUtil.getElement(PDPSelectors.BDItemTitle.get()).getText();
			isRightItem = itemTitle.contains("Slipcover");
			 
			return isRightItem;
		}catch(NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "PDP Item Title selector was not found by selenium", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
		
	}
	
	public static void SCselectConfiguration() throws Exception {
		try {
			getCurrentFunctionName(true);
			String subStrArr = PDPSelectors.SCBDConfigOptions.get();
			List<WebElement> configOptions = new ArrayList<>();
			
			configOptions = SelectorUtil.getAllElements(subStrArr);
			WebElement selectedElement = SelectorUtil.getRandomWebElement(configOptions);
			SelectorUtil.clickOnWebElement(selectedElement);
			
			logs.debug("The configuration Selected is :" + selectedElement.getText());
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "There is No configuration options", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static void SCselectFabric() throws Exception {
		try {
			getCurrentFunctionName(true);
			String subStrArr = PDPSelectors.SCBDFabricOptions.get();
			List<WebElement> FabricOptions = new ArrayList<>();
			FabricOptions = SelectorUtil.getAllElements(subStrArr);
			WebElement selectedElement = SelectorUtil.getRandomWebElement(FabricOptions);
			SelectorUtil.clickOnWebElement(selectedElement);
			logs.debug("The Fabric Selected is :" + selectedElement.getText());
			//Reset The Fabric by select the default option
			SelectorUtil.clickOnWebElement(FabricOptions.get(0));
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "There is No Fabric options", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static WebElement selectColor() throws Exception {
		try {
			getCurrentFunctionName(true); 
			WebElement selectedElement = null;
			String subStrArr = PDPSelectors.BDColorOptions.get();
			List<WebElement> ColorOptions = new ArrayList<>();
			ColorOptions = SelectorUtil.getAllElements(subStrArr);
			selectedElement = SelectorUtil.getRandomWebElement(ColorOptions);
			SelectorUtil.clickOnWebElement(selectedElement);
			getCurrentFunctionName(false);
			return selectedElement;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "There is No Color options", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static boolean validatePriceIsDisplayed(String key) throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisplayed;
			String selector;
			logs.debug("Validate if price exist");
			if(isCS(key)) {
				selector = PDPSelectors.CSBDTopPrice.get();
				isDisplayed = SelectorUtil.isDisplayed(selector);
			}else {
				selector = PDPSelectors.BDTopPrice.get();
				isDisplayed = SelectorUtil.isDisplayed(selector);
			}
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "price selector was not found by seleniuem", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static boolean isCS(String csKey) {
		getCurrentFunctionName(true);
		boolean result = csKey.equals("COM Shop");
		getCurrentFunctionName(false);
		return result;
	}
	
	public static void pickOneQuantity() throws Exception {
		try {
			
			String subStrArr = PDPSelectors.IncrementBtn.get();
			WebElement increment = SelectorUtil.getElement(subStrArr);
			
			SelectorUtil.clickOnWebElement(increment);
			logs.debug("Select One Item");
		
			getCurrentFunctionName(false);
			
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Color selector was not found by seleniuem", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static String getBottomPrice(String Key) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Validate if bottom price is updated after seleting options");
			String selector;
			if(isCS(Key)) {
				selector = PDPSelectors.CSBDBottomPrice.get();
				SelectorUtil.initializeSelectorsAndDoActions(selector);	
			}else {
				selector = PDPSelectors.BDBottomPrice.get();
				SelectorUtil.initializeSelectorsAndDoActions(selector);	
			}
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
	
	public static void clickAddToCartButton() throws Exception {
		try {
			getCurrentFunctionName(true);
			String subStrArr = null;
			subStrArr = PDPSelectors.BDaddToCartBtn.get();
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
	
	public static void clickAddToOrderSwatch(String Key) throws Exception {
		try {
			getCurrentFunctionName(true);
			String subStrArr = null;
			if(isCS(Key)) {
				subStrArr = PDPSelectors.CSOrderASwatchButton.get();
			}else {
				subStrArr = PDPSelectors.OrderASwatchButton.get();
			}
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Order a Swatch button selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static boolean validateOrderSwatch() throws Exception {
		try { 
			getCurrentFunctionName(true);
			boolean isDisplayed;
			isDisplayed = SelectorUtil.isDisplayed(PDPSelectors.OrderASwatchModal.get());
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Oreder a Swatch modal selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static boolean validateOrderSwatchDropdown() throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisplayed;
			isDisplayed = SelectorUtil.isDisplayed(PDPSelectors.OrderSwatchesDropdown.get());
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Oreder a Swatch Dropdown selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static boolean validateSearchSwatchIsDisplayed() throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisplayed;
			isDisplayed = SelectorUtil.isDisplayed(PDPSelectors.SearchSwatchInput.get());
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Swatch Search selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static boolean validateSearchSwatchWorkedAsWell(String searchTerm, String desc) throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isWorked = false;
			String selector = PDPSelectors.SearchSwatchInput.get();
			SelectorUtil.initializeSelectorsAndDoActions(selector, searchTerm);
			List<WebElement> searchResults = new ArrayList<>();
			searchResults = getAllSwatchSearchResult(desc);
			Thread.sleep(5000);
			WebElement selectedElement = SelectorUtil.getRandomWebElement(searchResults);
			String descOfSelectedItem = selectedElement.getAttribute("alt");
			isWorked = descOfSelectedItem.toLowerCase().contains(searchTerm.toLowerCase()) ? true : false ;
			//Reset Or Clear the Search Input
			SelectorUtil.clickOnWebElement(SelectorUtil.getElement(PDPSelectors.ResetFilterBtn.get()));
			getCurrentFunctionName(false);
			return isWorked;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "There is No Search Results to Validate it ..",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static List<WebElement> getAllSwatchSearchResult(String Key) throws Exception{
		try {
			getCurrentFunctionName(true);
			String subStrArr;
			if(isCS(Key)) {
				subStrArr = PDPSelectors.CSSearchSwatchResults.get();
			}else {
				subStrArr = PDPSelectors.SearchSwatchResults.get();
			}
			List<WebElement> searchResults = new ArrayList<>();
			searchResults = SelectorUtil.getAllElements(subStrArr);
			getCurrentFunctionName(false);
			return searchResults;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Search Result selector was not found by seleniuem", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static List<WebElement> getAllSuggestedSwatches() throws Exception{
		try {
			getCurrentFunctionName(true);
			String subStrArr = PDPSelectors.SuggestedSwatches.get();
			List<WebElement> searchResults = new ArrayList<>();
			searchResults = SelectorUtil.getAllElements(subStrArr);
			getCurrentFunctionName(false);
			return searchResults;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Suggested Swatches selector was not found by seleniuem", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	//add single Swatch Or Multiple depend on the key value
	public static void clickAddSwatch(char key) throws Exception {
		try {
			getCurrentFunctionName(true);
			List<WebElement> allSwatches = getAllSuggestedSwatches();
			if(key == 'S') {
				SelectorUtil.clickOnWebElement(allSwatches.get(0));
				logs.debug("Add a Swatch Successfully");
			}else {
				for(int i=1 ; i < 12 ; i++) {
					SelectorUtil.clickOnWebElement(allSwatches.get(i));
				}
				logs.debug("Add more than 10 swatches");
			}
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Add a Swatch button selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static boolean validateAddSwatchIsDisable() throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisable;
			logs.debug("Validate if AddSwatch Buttom disabled ");
			String selector = PDPSelectors.firstSuggestedSwatch.get();
			isDisable = !SelectorUtil.getElement(selector).isEnabled();
			getCurrentFunctionName(false);
			return isDisable;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Add Swatch Button was not found by seleniuem", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static boolean validateAddMoreThan10Swatches() throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisplayed;
			isDisplayed = SelectorUtil.isDisplayed(PDPSelectors.SwatchLimitMsg.get());
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Swatch Limitation Message selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static void clickAddSwatchesToCartButton() throws Exception {
		try {
			getCurrentFunctionName(true);
			String subStrArr = null;
			subStrArr = PDPSelectors.AddSwatchesToCartBtn.get();
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Add Swatches to cart button selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static boolean validateNumAddedSwatchesIsRight() throws Exception {
		try {
			boolean isCorrectNum = false;
			getCurrentFunctionName(true);
			List<WebElement> addedSwatchesList = new ArrayList<>();
			addedSwatchesList = getAllAddedSwatches();
			int numberOfAddedItems = addedSwatchesList.size();
			if (numberOfAddedItems == 10) {
				isCorrectNum = true;
			}
			getCurrentFunctionName(false);
			return isCorrectNum;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "validate the of number Adde dSwatches has failed",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static List<WebElement> getAllAddedSwatches() throws Exception{
		try {
			getCurrentFunctionName(true);
			String subStrArr = PDPSelectors.AddedSwatchesItems.get();
			List<WebElement> addedSwatchesList = new ArrayList<>();
			addedSwatchesList = SelectorUtil.getAllElements(subStrArr);
			getCurrentFunctionName(false);
			return addedSwatchesList;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Swatches Item selector was not found by seleniuem", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static boolean validateProductIsAddedToCart() throws Exception {
		try {
			getCurrentFunctionName(true);
				boolean isDisplayed;
				Thread.sleep(4000);
				isDisplayed = SelectorUtil.isDisplayed(PDPSelectors.BDAddToCartModal.get());
				SelectorUtil.clickOnWebElement(SelectorUtil.getElement(PDPSelectors.closeModal.get()));
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
	
	
	public static WebElement CSselectFinishColor() throws Exception {
		try {
			getCurrentFunctionName(true); 
			WebElement selectedElement = null;
			String subStrArr = PDPSelectors.CSFinishColorOptions.get();
			List<WebElement> ColorOptions = new ArrayList<>();
			ColorOptions = SelectorUtil.getAllElements(subStrArr);
			selectedElement = SelectorUtil.getRandomWebElement(ColorOptions);
			SelectorUtil.clickOnWebElement(selectedElement);
			getCurrentFunctionName(false);
			return selectedElement;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "There is No Color options", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
}
