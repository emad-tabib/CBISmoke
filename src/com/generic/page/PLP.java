package com.generic.page;


import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import com.generic.selector.PLPSelectors;
import com.generic.setup.LoggingMsg;
import com.generic.setup.SelTestCase;
import com.generic.util.SelectorUtil;

public class PLP extends SelTestCase {
    //TODO: removing the list declaration to maintain concurrency 
	private static List<String> subStrArr = new ArrayList<String>();
    private static List<String> valuesArr = new ArrayList<String>();
    private static int numberOfProductsShownInHeader;
    
    public static class keys {
		public static final String caseId = "caseId";
	}

    public static void selectSortOptions1ByValue(String sortByTxt) throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		logs.debug(MessageFormat.format(LoggingMsg.SELECTING_ELEMENT_VALUE,PLPSelectors.sortOptions1, sortByTxt));
		subStrArr.add(PLPSelectors.sortOptions1);
		valuesArr.add(sortByTxt);
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		String SelectedOptions2Val = getSortOptions2SelectedValue();
		logs.debug(MessageFormat.format(LoggingMsg.PLP_SELECTED_SORT_VALUES,"sortOptions1", sortByTxt, "sortOptions2", SelectedOptions2Val.trim()));
		getCurrentFunctionName(false);
	}
    
    public static String getSortOptions2SelectedValue() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		logs.debug(MessageFormat.format(LoggingMsg.GET_ELEMENT_BY_LOCATOR,PLPSelectors.sortOptions2));
		subStrArr.add(PLPSelectors.sortOptions2);
		valuesArr.add("");
		String sortOptions2SelectedValue = "";
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		sortOptions2SelectedValue = SelectorUtil.textValue;
		getCurrentFunctionName(false);
    	return sortOptions2SelectedValue;
    }
    
    public static void selectSortOptions2ByValue(String sortByTxt) throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		logs.debug(MessageFormat.format(LoggingMsg.SELECTING_ELEMENT_VALUE,PLPSelectors.sortOptions2, sortByTxt));
		subStrArr.add(PLPSelectors.sortOptions2);
		valuesArr.add(sortByTxt);
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		String SelectedOptions1Val = getSortOptions2SelectedValue();
		logs.debug(MessageFormat.format(LoggingMsg.PLP_SELECTED_SORT_VALUES,"sortOptions2", sortByTxt, "sortOptions1", SelectedOptions1Val.trim()));
		getCurrentFunctionName(false);
	}
    
    public static String getSortOptions1SelectedValue() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		logs.debug(MessageFormat.format(LoggingMsg.GET_ELEMENT_BY_LOCATOR,PLPSelectors.sortOptions1));
		subStrArr.add(PLPSelectors.sortOptions1);
		valuesArr.add("");
		String sortOptions2SelectedValue = "";
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		sortOptions2SelectedValue = SelectorUtil.textValue;
		getCurrentFunctionName(false);
    	return sortOptions2SelectedValue;
    }
    
    public static String getNumberOfproducts() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		subStrArr.add(PLPSelectors.numberOfProductsFound);
		valuesArr.add("");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		logs.debug(MessageFormat.format(LoggingMsg.NUMBER_OF_PRODUCTS, SelectorUtil.textValue));
		getCurrentFunctionName(false);
		String productsNum = SelectorUtil.textValue.split(" ")[0];
		numberOfProductsShownInHeader = Integer.parseInt(productsNum);
		return productsNum;
	}
    
    public static boolean doesDisplayedProductsNumTextMatchesProductsDisplayed () throws Exception {
    	getCurrentFunctionName(true);
    	List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		subStrArr.add(PLPSelectors.productItem);
		valuesArr.add("noClick");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		logs.debug(MessageFormat.format(LoggingMsg.EXPECTED_TEXT, numberOfProductsShownInHeader));
		logs.debug(MessageFormat.format(LoggingMsg.ACTUAL_TEXT, SelectorUtil.numberOfFoundElements));
		getCurrentFunctionName(false);
		if (numberOfProductsShownInHeader == SelectorUtil.numberOfFoundElements) {
    		return true;
    	} else {
    		logs.debug(MessageFormat.format(LoggingMsg.ACTUAL_EXPECTED_ERROR, SelectorUtil.numberOfFoundElements, numberOfProductsShownInHeader));
    		return false;
    	}
    }
    
    public static void clickFindStores() throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		logs.debug(MessageFormat.format(LoggingMsg.CLICKING_SEL, PLPSelectors.findStoresNearMeAjax));
		subStrArr.add(PLPSelectors.findStoresNearMeAjax);
		valuesArr.add("");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}
    
    public static void typeUserLocationStore(String storeName) throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		logs.debug(MessageFormat.format(LoggingMsg.TYPING_ELEMENT_VALUE, PLPSelectors.userLocationStore, storeName));
		subStrArr.add(PLPSelectors.userLocationStore);
		valuesArr.add(storeName + ",pressEnter");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}
    
    public static void clickAddToCart(String productCodePost) throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		logs.debug(MessageFormat.format(LoggingMsg.CLICKING_SEL, PLPSelectors.addToCartForm + productCodePost));
		subStrArr.add(PLPSelectors.addToCartForm + productCodePost);
		valuesArr.add("");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}
    
    public static void clickProductPickupInStoreButton(String productCodePost) throws Exception {
		getCurrentFunctionName(true);
		List<String> subStrArr = new ArrayList<String>();
		List<String> valuesArr = new ArrayList<String>();
		logs.debug(MessageFormat.format(LoggingMsg.CLICKING_SEL, PLPSelectors.productPickupInStoreButton + productCodePost));
		subStrArr.add(PLPSelectors.productPickupInStoreButton + productCodePost);
		valuesArr.add("");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}
    
    public static void clickMoreStores() throws Exception {
		getCurrentFunctionName(true);
		logs.debug(MessageFormat.format(LoggingMsg.CLICKING_SEL, PLPSelectors.moreStores));
		subStrArr.add(PLPSelectors.moreStores);
		valuesArr.add("");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}
    
    public static String getPLPProductPrice(String productCodePost) throws Exception {
		getCurrentFunctionName(true);
		String selText = MessageFormat.format(PLPSelectors.plpProductPriceLabel, productCodePost);
		logs.debug(MessageFormat.format(LoggingMsg.GETTING_SEL, selText));
		subStrArr.add(selText);
		valuesArr.add("noClick");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
		return SelectorUtil.textValue;
	}
    
    public static String getPLPProductPriceFromCartBag() throws Exception {
		getCurrentFunctionName(true);
		logs.debug(MessageFormat.format(LoggingMsg.GETTING_SEL, PLPSelectors.addToCartItemPrice));
		subStrArr.add(PLPSelectors.addToCartItemPrice);
		valuesArr.add("noClick");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
		return SelectorUtil.textValue;
	}
    
    public static void clickCheckoutBtn() throws Exception {
		getCurrentFunctionName(true);
		logs.debug(MessageFormat.format(LoggingMsg.CLICKING_SEL, PLPSelectors.addToCartItemCheckoutBtn));
		subStrArr.add(PLPSelectors.addToCartItemCheckoutBtn);
		valuesArr.add("");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}
    
    public static void clickContinueShoppingBtn() throws Exception {
		getCurrentFunctionName(true);
		logs.debug(MessageFormat.format(LoggingMsg.CLICKING_SEL, PLPSelectors.addToCartItemContinueShoppingBtn));
		subStrArr.add(PLPSelectors.addToCartItemContinueShoppingBtn);
		valuesArr.add("");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}
    
    public static void clickCboxCloseBtn() throws Exception {
		getCurrentFunctionName(true);
		logs.debug(MessageFormat.format(LoggingMsg.CLICKING_SEL, PLPSelectors.cboxCloseBtn));
		subStrArr.add(PLPSelectors.cboxCloseBtn);
		valuesArr.add("");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}
    
    public static void clickleftNavCheckBoxCheckBox(String checkBoxValue) throws Exception {
		getCurrentFunctionName(true);
		logs.debug(MessageFormat.format(LoggingMsg.CLICKING_SEL, checkBoxValue));
		subStrArr.add(checkBoxValue);
		valuesArr.add("");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}
    
    public static String getFacetNavTitleStoresCount() throws Exception {
		getCurrentFunctionName(true);
		logs.debug(MessageFormat.format(LoggingMsg.CLICKING_SEL, PLPSelectors.facetNavTitleStores + ": " + PLPSelectors.facetNavSecondCount));
		subStrArr.add(PLPSelectors.facetNavTitleStores);
		valuesArr.add("child,"+PLPSelectors.facetNavSecondCount);
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
		return SelectorUtil.textValue;
	}
    
    public static String getFacetNavTitlePriceCount() throws Exception {
		getCurrentFunctionName(true);
		logs.debug(MessageFormat.format(LoggingMsg.CLICKING_SEL, PLPSelectors.facetNavTitlePrice + ": " + PLPSelectors.facetNavThirdCount));
		subStrArr.add(PLPSelectors.facetNavTitlePrice);
		valuesArr.add("child,"+PLPSelectors.facetNavThirdCount);
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
		return SelectorUtil.textValue;
	}
    
    public static String getFacetNavTitleColourCount() throws Exception {
		getCurrentFunctionName(true);
		logs.debug(MessageFormat.format(LoggingMsg.CLICKING_SEL, PLPSelectors.facetNavTitleColour + ": " + PLPSelectors.facetNavThirdCount));
		subStrArr.add(PLPSelectors.facetNavTitleColour);
		valuesArr.add("child,"+PLPSelectors.facetNavThirdCount);
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
		return SelectorUtil.textValue;
	}
    public static String getFacetNavTitleSizeCount() throws Exception {
		getCurrentFunctionName(true);
		logs.debug(MessageFormat.format(LoggingMsg.CLICKING_SEL, PLPSelectors.facetNavTitleSize + ": " + PLPSelectors.facetNavThirdCount));
		subStrArr.add(PLPSelectors.facetNavTitleSize);
		valuesArr.add("child,"+PLPSelectors.facetNavThirdCount);
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
		return SelectorUtil.textValue;
	}
    
    public static void clickChangeLocationLink() throws Exception {
		getCurrentFunctionName(true);
		logs.debug(MessageFormat.format(LoggingMsg.CLICKING_SEL, PLPSelectors.changeLocationLink));
		subStrArr.add(PLPSelectors.changeLocationLink);
		valuesArr.add("");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}
    
    public static boolean isLocationFacetContainerHidden() {
		getCurrentFunctionName(true);
		boolean isLocationContainerHidden = false;
		logs.debug(MessageFormat.format(LoggingMsg.CLICKING_SEL, PLPSelectors.locationFacetContainer));
		subStrArr.add(PLPSelectors.locationFacetContainer);
		valuesArr.add("");
		try {
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		} catch (Exception e) {
			isLocationContainerHidden = true;
		}
		getCurrentFunctionName(false);
		return isLocationContainerHidden;
	}
    
    public static void verifyChangeLocationLink() throws Exception {
		getCurrentFunctionName(true);
		clickFindStores();
		Thread.sleep(3000);
		clickChangeLocationLink();
		Thread.sleep(3000);
		boolean isLocationContainerHidden = isLocationFacetContainerHidden();
		if (!isLocationContainerHidden) {
			logs.debug(LoggingMsg.PLP_CHANGE_LOCATION_LINK_FUNCTIONALITY_MSG);
		}
		getCurrentFunctionName(false);
	}
    
    public static void compareAppliedFilterWithDisplayedProductNumber(String filterName) throws Exception {
		getCurrentFunctionName(true);
		String tempAppliedFilterCount = "";
		if (filterName.equals("stores")) {
			tempAppliedFilterCount = PLP.getFacetNavTitleStoresCount();
		} else if (filterName.equals("price")) {
			tempAppliedFilterCount = PLP.getFacetNavTitlePriceCount();
		} else if (filterName.equals("colour")) {
			tempAppliedFilterCount = PLP.getFacetNavTitleColourCount();
		} else if (filterName.equals("size")) {
			tempAppliedFilterCount = PLP.getFacetNavTitleSizeCount();
		}
		tempAppliedFilterCount = tempAppliedFilterCount.replace("(", "").replace(")", "");
		logs.debug(MessageFormat.format(LoggingMsg.PLP_SELECTED_FILTER_COUNT, filterName, tempAppliedFilterCount));
		String appliedFilterCount = tempAppliedFilterCount.trim();
		String displayedProductsCount = PLP.getNumberOfproducts().trim();
		logs.debug(MessageFormat.format(LoggingMsg.NUMBER_OF_PRODUCTS, displayedProductsCount));
		if (!appliedFilterCount.isEmpty() && displayedProductsCount.equals(appliedFilterCount)) {
			logs.debug(MessageFormat.format(LoggingMsg.PLP_FILTER_FUNCTIONALITY, ""));
		} else {
			logs.debug(MessageFormat.format(LoggingMsg.PLP_FILTER_FUNCTIONALITY, "not"));
		}
		getCurrentFunctionName(false);
	}
    
    public static void clickNthProductItem(String nthChild) throws Exception {
		getCurrentFunctionName(true);
		String selText = MessageFormat.format(PLPSelectors.nthProductItem, nthChild);
		logs.debug(MessageFormat.format(LoggingMsg.CLICKING_SEL, selText));
		subStrArr.add(selText);
		valuesArr.add("");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}
    
    public static void removeNthAppliedFacet(String nthChild) throws Exception {
		getCurrentFunctionName(true);
		String selText = MessageFormat.format(PLPSelectors.nthAppliedFacets, nthChild);
		logs.debug(MessageFormat.format(LoggingMsg.CLICKING_SEL, selText));
		subStrArr.add(selText);
		valuesArr.add("");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}
    
    public static void typePickUpInStoreLocationForSearch(String storeName) throws Exception {
		getCurrentFunctionName(true);
		logs.debug(MessageFormat.format(LoggingMsg.TYPING_ELEMENT_VALUE, PLPSelectors.pickupInStoreLocationSearch, storeName));
		subStrArr.add(PLPSelectors.pickupInStoreLocationSearch);
		valuesArr.add(storeName + ",pressEnter");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}
    
    public static void clickPickupNthAccessibleTabIcon(String nthIcon) throws Exception {
		getCurrentFunctionName(true);
		String pickupNthAccessibleTabIcon = MessageFormat.format(PLPSelectors.pickupNthAccessibleTabIcon, nthIcon);
		logs.debug(MessageFormat.format(LoggingMsg.CLICKING_SEL, pickupNthAccessibleTabIcon));
		subStrArr.add(pickupNthAccessibleTabIcon);
		valuesArr.add("");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}
    
    public static void clickPickUpInStoreAddToBagBtn(String productCodePost) throws Exception {
		getCurrentFunctionName(true);
		String pickupModalAddToBagBtn = MessageFormat.format(PLPSelectors.pickupAddToBagBtn, productCodePost);
		logs.debug(MessageFormat.format(LoggingMsg.CLICKING_SEL, pickupModalAddToBagBtn));
		subStrArr.add(pickupModalAddToBagBtn);
		valuesArr.add("");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}
    
    public static void clickPickUpInStoreDecreaseQtyBtn(String productCodePost) throws Exception {
		getCurrentFunctionName(true);
		String pickupModalDecreaseQtyBtn = MessageFormat.format(PLPSelectors.pickupDecreaseQtyBtn, productCodePost);
		logs.debug(MessageFormat.format(LoggingMsg.CLICKING_SEL, pickupModalDecreaseQtyBtn));
		subStrArr.add(pickupModalDecreaseQtyBtn);
		valuesArr.add("");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}
    
    public static void clickPickUpInStoreIncreaseQtyBtn(String productCodePost) throws Exception {
		getCurrentFunctionName(true);
		String pickupModalIncreaseQtyBtn = MessageFormat.format(PLPSelectors.pickupIncreaseQtyBtn, productCodePost);
		logs.debug(MessageFormat.format(LoggingMsg.CLICKING_SEL, pickupModalIncreaseQtyBtn));
		subStrArr.add(pickupModalIncreaseQtyBtn);
		valuesArr.add("");
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}
    
    public static void typePickUpInStoreQty(String productCodePost, String qty) throws Exception {
		getCurrentFunctionName(true);
		String pickupModalQtyInput = MessageFormat.format(PLPSelectors.pickupQtyInput, productCodePost);
		logs.debug(MessageFormat.format(LoggingMsg.TYPING_ELEMENT_VALUE, pickupModalQtyInput, qty));
		subStrArr.add(pickupModalQtyInput);
		valuesArr.add(qty);
		SelectorUtil.initializeSelectorsAndDoActions(subStrArr, valuesArr);
		getCurrentFunctionName(false);
	}
}
