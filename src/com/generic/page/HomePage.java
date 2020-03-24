package com.generic.page;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.NoSuchElementException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.generic.page.PDP.*;
import com.generic.selector.HomePageSelectors;
import com.generic.setup.SelTestCase;
import com.generic.util.SelectorUtil;
import com.generic.setup.ExceptionMsg;
import com.generic.setup.LoggingMsg;
import com.generic.util.SelectorUtil.commands.actions;

public class HomePage extends SelTestCase {
	public static int homePageMenuLevelTestItems = Integer
			.parseInt(getCONFIG().getProperty("homePageMenuLevelTestItems"));

	public final static String searchPlacholder = "Search - Keyword or Item #";
	public final static String pwaLinkClassNameIdentifier = "pw-link";
	public final static String searchURLProperty = "searchURL";
	public final static String monetateStatusProperty = "monetateStatus";

	public static boolean validateLogodisplayed() throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisplayed;
			logs.debug("Validate if logo exist");
			if (isGH()) {
				isDisplayed = SelectorUtil.isDisplayed(HomePageSelectors.GHlogo.get());
			} else {
				isDisplayed = SelectorUtil.isDisplayed(HomePageSelectors.logo.get());
			}
			logs.debug("Validate if logo exist" + isDisplayed);
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat
					.format(ExceptionMsg.PageFunctionFailed + "Logo selector is not found by selelnium ", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	public static void NavigateAwayFromHomePage() throws Exception {
		try {
			getCurrentFunctionName(true);
			getDriver().get(getURL() + getCONFIG().getProperty(searchURLProperty));
			getCurrentFunctionName(false);
		} catch (Exception e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Navigating from homepage by URL has failed", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	// This is to disable Monetate if needed.
	public static void updateMmonetate() throws Exception {
		try {
			getCurrentFunctionName(true);
			getDriver().get(getURL() + "/?monetate=" + getCONFIG().getProperty(monetateStatusProperty));
			getCurrentFunctionName(false);
		} catch (Exception e) {
			logs.debug(
					MessageFormat.format(ExceptionMsg.PageFunctionFailed + "Update monetate has failed", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	public static void clickOnLogo() throws Exception {

		try {
			getCurrentFunctionName(true);
			logs.debug("Clicking on Site logo");
			if (isGH()) {
				SelectorUtil.initializeSelectorsAndDoActions(HomePageSelectors.GHlogo.get());
			} else if (isRY() && isMobile()) {
				SelectorUtil.initializeSelectorsAndDoActions(HomePageSelectors.RYLogoLinkMobile.get(),
						"ForceAction,click");

			} else {
				SelectorUtil.initializeSelectorsAndDoActions(HomePageSelectors.logo.get(), "ForceAction,click");
			}
			Thread.sleep(2000);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat
					.format(ExceptionMsg.PageFunctionFailed + "Logo selector is not found by selelnium ", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static boolean validateHomePageLink() throws Exception {
		try {
			getCurrentFunctionName(true);
			String CurrentURL = getDriver().getCurrentUrl().replace("www.", "");
			logs.debug("Current URL is: " + CurrentURL);
			logs.debug("Current URL should match: " + getURL().replace("www.", "") + "/");
			boolean results = CurrentURL.equals(getURL().replace("www.", "") + "/");
			getCurrentFunctionName(false);
			return results;
		} catch (Exception e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed + "Validating home page has failed",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static boolean validateYMALCarouselsDisplayed() throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisplayed;
			logs.debug("Validate if YMAL carousels exist");
			if (isBD()) {
				isDisplayed = SelectorUtil.isDisplayed(HomePageSelectors.YMALCarouselsBD.get());
			} else {
				isDisplayed = SelectorUtil.isDisplayed(HomePageSelectors.YMALCarousels.get());
			}
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "YMAL Carousel selector is not found by selelnium ",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	public static boolean validateMainHomeCarouselsDisplayed() throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisplayed;
			logs.debug("Validate if main home carousels exist");
			isDisplayed = SelectorUtil.isDisplayed(HomePageSelectors.mainHomeCarousels.get());
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Main carousel in home page selector is not found by selelnium ",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static boolean validateAccountMenuDisplayed() throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisplayed;
			logs.debug("Validate if Account menu exist");
			if (isBD()) {
				isDisplayed = SelectorUtil.isDisplayed(HomePageSelectors.accountMenuBD.get());
			} else if (isRY()) {
				isDisplayed = SelectorUtil.isDisplayed(HomePageSelectors.RYaccountMenu.get());
			} else {
				isDisplayed = SelectorUtil.isDisplayed(HomePageSelectors.accountMenu.get());
			}
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Account menu selector is not found by selelnium ", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	public static void clickOnAccountMenu(Boolean withHover) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Clicking on Account menu");
			if (isBD()) {
				if (withHover) {
					SelectorUtil.initializeSelectorsAndDoActions(HomePageSelectors.accountMenuBD.get(), actions.hover);
				} else {
					SelectorUtil.initializeSelectorsAndDoActions(HomePageSelectors.accountMenuBD.get());
				}
			}

			if (!(isBD())) {
				if (withHover) {
					SelectorUtil.initializeSelectorsAndDoActions(HomePageSelectors.accountMenu.get(), actions.hover);
				} else {
					SelectorUtil.initializeSelectorsAndDoActions(HomePageSelectors.accountMenu.get());
				}
			}
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat
					.format(ExceptionMsg.PageFunctionFailed + "Account menu icon selector was not found", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static void clickOnCloseButton() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Clicking on Close Button");
			if (isBD()) {
				SelectorUtil.initializeSelectorsAndDoActions(HomePageSelectors.BDcloseAccountMenu.get());
			} else {
				SelectorUtil.initializeSelectorsAndDoActions(HomePageSelectors.navIcon.get());
			}
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Close button selector is not found by selelnium ", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static void clickOnRandomAccountMenuItem() throws Exception {
		try {
			getCurrentFunctionName(true);
			List<WebElement> accountMenuElements = getAccountMenuItems();
			Random random = new Random();
			int randomIndex = random.nextInt(accountMenuElements.size() - 1);
			WebElement element = accountMenuElements.get(randomIndex);
			SelectorUtil.clickOnWebElement(element);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Account menu element selector is not found by selelnium ",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static List<WebElement> getAccountMenuItems() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Get the account menu items.");
			List<WebElement> menuItems = new ArrayList<WebElement>();
			if (isBD()) {
				menuItems = SelectorUtil.getAllElements(HomePageSelectors.accountMenuItemsBD.get());
			} else {
				menuItems = SelectorUtil.getAllElements(HomePageSelectors.accountMenuItems.get());
			}
			getCurrentFunctionName(false);
			return menuItems;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Account menu elements selector is not found by selelnium ",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static boolean validateAccountMenuItemsDisplayed() throws Exception {
		try {
			getCurrentFunctionName(true);
			List<WebElement> accountMenuElements = getAccountMenuItems();
			logs.debug("Validate account menu links." + accountMenuElements);
			boolean isDisplayed = false;
			for (WebElement element : accountMenuElements) {
				isDisplayed = element.isDisplayed();
			}
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Accounts menu elements selector is not found by selelnium ",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static boolean validateCountrySelectorDisplayed() throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisplayed;
			logs.debug("Validate if country selector  exist");
			if (isBD()) {
				isDisplayed = SelectorUtil.isDisplayed(HomePageSelectors.countrySelectorBD.get());
			} else
				isDisplayed = SelectorUtil.isDisplayed(HomePageSelectors.countrySelector.get());
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Country selector is not found by selelnium ", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static boolean validateGlobalFooterItemsDisplayed() throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisplayed = true;
			logs.debug("Validate if global footer  exist");
			List<WebElement> footerItems = new ArrayList<WebElement>();
			if (isBD()) {
				isDisplayed = SelectorUtil.isDisplayed(HomePageSelectors.globalFooterBD.get());
				footerItems = SelectorUtil.getAllElements(HomePageSelectors.accordionHeaderBD.get());
			}

			else if (isGH() || isRY()) {
				isDisplayed = SelectorUtil.isDisplayed(HomePageSelectors.GHglobalFooter.get());
				footerItems = SelectorUtil.getAllElements(HomePageSelectors.GHaccordionHeader.get());
			} else {
				isDisplayed = SelectorUtil.isDisplayed(HomePageSelectors.globalFooter.get());
				footerItems = SelectorUtil.getAllElements(HomePageSelectors.accordionHeader.get());
			}
			for (WebElement element : footerItems) {
				isDisplayed = element.isDisplayed();
			}
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Items in global footer selector is not found by selelnium ",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static void clickOnMiniCart() throws Exception {
		try {
			getCurrentFunctionName(true);
			String subStrArr = HomePageSelectors.miniCartBtn.get();
			if (!isDesktop()) {
				logs.debug("Clicking on Mini Cart");
				SelectorUtil.initializeSelectorsAndDoActions(subStrArr);
			} else {
				logs.debug("Hovering on Mini Cart");
				PDP_cart.hoverMiniCart();
			}

			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Mini cart selector is not found by selelnium ", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static String getMiniCartText() throws Exception {
		try {
			getCurrentFunctionName(true);
			if (isBD()) {
				SelectorUtil.initializeSelectorsAndDoActions(HomePageSelectors.miniCartTextBD.get());
			} else if (isGH()) {
				SelectorUtil.initializeSelectorsAndDoActions(HomePageSelectors.GHminiCartText.get());
			} else if (isRY()) {
				SelectorUtil.initializeSelectorsAndDoActions(HomePageSelectors.RYminiCartText.get());
			} else {
				SelectorUtil.initializeSelectorsAndDoActions(HomePageSelectors.miniCartText.get());
			}
			String cartText = SelectorUtil.textValue.get();
			logs.debug("The cart text is:" + cartText);
			getCurrentFunctionName(false);
			return cartText;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Text in mini cart selector is not found by selelnium ",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static void clickOnMiniCartCloseBtn() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Clicking on Mini Cart clsoe icon");
			if(isBD()){
		logs.debug("Clicking on Mini Cart clsoe icon");
		SelectorUtil.initializeSelectorsAndDoActions(HomePageSelectors.miniCartCloseBD.get());
		}
		else if(isGH() || isRY()) {
			WebElement element = SelectorUtil.getElement(HomePageSelectors.GHminiCartClose.get());
			Actions actions = new Actions(SelTestCase.getDriver());
			actions.moveToElement(element).click().perform();
		}
		else if(isFG()) {
			SelectorUtil.initializeSelectorsAndDoActions(HomePageSelectors.miniCartCloseFG.get());
		}
		else {
			SelectorUtil.initializeSelectorsAndDoActions(HomePageSelectors.miniCartClose.get());
		}
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Mini cart close icon selector is not found by selelnium ",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static boolean validateMiniCartIsClosed() throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isNotDisplayed;
			String subStrArr = HomePageSelectors.miniCartText.get();
			logs.debug("Validate if mini cart is closed");
			isNotDisplayed = SelectorUtil.isNotDisplayed(subStrArr);
			getCurrentFunctionName(false);
			return isNotDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Mini cart text selector is not found by selelnium ",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static boolean validateMiniCartProductIsDsiplayed() throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisplayed;
			logs.debug("Validate if Mini cart products are displayed");
			if (isRY()) {
				isDisplayed = SelectorUtil.isDisplayed(HomePageSelectors.RYminiCartProductContainer.get());
			} else {
				isDisplayed = SelectorUtil.isDisplayed(HomePageSelectors.miniCartProductContainer.get());
			}
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Product in mini cart selector is not found by selelnium ",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static boolean validateMiniCartCheckoutBtnIsDisplayed() throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisplayed;
			logs.debug("Validate if Mini Cart Checkout Btn Is Displayed");
			if (isRY()) {
				isDisplayed = SelectorUtil.isDisplayed(HomePageSelectors.RYminiCartCheckoutBtn.get());
			} else {
				isDisplayed = SelectorUtil.isDisplayed(HomePageSelectors.miniCartCheckoutBtn.get());

			}
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "Checkout button im mini cart selector is not found by selelnium ", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static void searchIconClick() throws Exception {
		try {
			getCurrentFunctionName(true);
			if (isRY()) {
				logs.debug(MessageFormat.format(LoggingMsg.CLICKING_SEL, HomePageSelectors.searchIconOpenRY));
				SelectorUtil.initializeSelectorsAndDoActions(HomePageSelectors.searchIconOpenRY.get());
			} else if (isBD()) {
				logs.debug(MessageFormat.format(LoggingMsg.CLICKING_SEL, HomePageSelectors.BDsearchIconOpen));
				SelectorUtil.initializeSelectorsAndDoActions(HomePageSelectors.BDsearchIconOpen.get());
			} else {
				logs.debug(MessageFormat.format(LoggingMsg.CLICKING_SEL, HomePageSelectors.searchIconOpen));
				WebElement element = SelectorUtil.getElement(HomePageSelectors.searchIconOpen.get());
				Actions actions = new Actions(SelTestCase.getDriver());
				actions.moveToElement(element).click().perform();
			}

			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Search icon selector was not found by selenium", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static void searchIconExitClick() throws Exception {
		try {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			logs.debug(MessageFormat.format(LoggingMsg.CLICKING_SEL, HomePageSelectors.searchIconClose));
			subStrArr.add(HomePageSelectors.searchIconClose.get());
			SelectorUtil.initializeSelectorsAndDoActions(subStrArr);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "Close button for search modal selector was not found by selenium", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static boolean validateSearchIconFieldOpend() throws Exception {
		try {
			getCurrentFunctionName(true);
			
			boolean isDisplayed;
			logs.debug("Validate if search icon field opened");
			isDisplayed = SelectorUtil.isDisplayed(HomePageSelectors.searchIconField.get());

			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Search icon selector is not found by selelnium ", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static boolean validateSearchIconFieldClosed() throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isNotDisplayed;
			logs.debug("Validate if search icon field closed");
			if (isBD()) {
				isNotDisplayed = SelectorUtil.isNotDisplayed(HomePageSelectors.BDsearchIconField.get());
			} else {
				isNotDisplayed = SelectorUtil.isNotDisplayed(HomePageSelectors.searchIconField.get());
			}

			if (isNotDisplayed == false)
				if (!SelectorUtil.isDisplayed(HomePageSelectors.searchIconField.get()))
					isNotDisplayed = true;
			getCurrentFunctionName(false);
			return isNotDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Search icon selector is not found by selelnium ", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static String readSearchFieldPlaceHolderText() throws Exception {
		try {
			getCurrentFunctionName(true);
			
			List<String> subStrArr = new ArrayList<String>();
			String valuesArr = "placeholder";
			subStrArr.add(HomePageSelectors.searchIconField.get());
			String placeHolderText = SelectorUtil.getAttr(subStrArr, valuesArr);
			
			getCurrentFunctionName(false);
			return placeHolderText;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Search field placeholder selector is not found by selelnium ",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static boolean validateSearchFieldPlaceHolderText(String placeHolder) throws Exception {

		if (placeHolder.equals(readSearchFieldPlaceHolderText()))
			return true;
		else
			return false;
	}

	public static boolean isDisplayedModuleHeroImg() throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisplayed;
			List<String> subStrArr = new ArrayList<String>();
			logs.debug("Validate if logo exist");
			if (SelTestCase.isBD()) {
				subStrArr.add(HomePageSelectors.moduleHeroImgBD);
			} else {
				subStrArr.add(HomePageSelectors.moduleHeroImg);
			}
			isDisplayed = SelectorUtil.isDisplayed(subStrArr);
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Hero image selector is not found by selelnium ", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static boolean isLoadedModuleHeroImg() throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean loaded = false;
			if (isBD()) {
				loaded = SelectorUtil.isImgLoaded(HomePageSelectors.moduleHeroImgBD);
			} else {
				loaded = SelectorUtil.isImgLoaded(HomePageSelectors.moduleHeroImg);
			}
			getCurrentFunctionName(false);
			return loaded;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Hero Image selector is not found by selelnium ", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static List<WebElement> getCarusals() throws Exception {
		try {
			getCurrentFunctionName(true);
			List<String> subStrArr = new ArrayList<String>();
			if (isBD()) {
				subStrArr.add(HomePageSelectors.carusalsBD.get());
			} else {
				subStrArr.add(HomePageSelectors.carusals.get());
			}
			List<WebElement> carusals = SelectorUtil.getAllElements(subStrArr);
			getCurrentFunctionName(false);
			return carusals;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Carosuels selector is not found by selelnium ", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static boolean isListDisplayed(List<WebElement> elements) {
		try {
			getCurrentFunctionName(true);
			boolean loaded = true;
			for (int i = 0; i < elements.size(); i++) {
				JavascriptExecutor jse = (JavascriptExecutor) getDriver();
				jse.executeScript("arguments[0].scrollIntoView(false)", elements.get(i));
				if (!elements.get(i).isDisplayed()) {
					loaded = false;

				}
			}
			getCurrentFunctionName(false);
			return loaded;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "List validation has failed, a selector cant be found by selenium", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static boolean isListLoaded(List<WebElement> elements) {
		try {
			getCurrentFunctionName(true);
			boolean result = true;
			for (int i = 0; i < elements.size(); i++) {

				Object resultForOneCarusal = (Boolean) ((JavascriptExecutor) getDriver()).executeScript(
						"return arguments[0].complete && " + "typeof arguments[0].naturalWidth != \"undefined\" && "
								+ "arguments[0].naturalWidth > 0",
						elements.get(i));

				boolean loaded = false;
				if (resultForOneCarusal instanceof Boolean) {
					loaded = (Boolean) result;
					if (loaded == false)
						result = false;
				}
			}
			getCurrentFunctionName(false);
			return result;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "List validation has failed, a selector cant be found bu selenium", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static boolean isDisplayedAllCarouselContent() throws Exception {
		getCurrentFunctionName(true);
		List<WebElement> elements = getCarusals();
		boolean displayed = isListDisplayed(elements);
		getCurrentFunctionName(false);
		return displayed;
	}

	public static boolean isLoadedAllCarouselContent() throws Exception {
		getCurrentFunctionName(true);
		List<WebElement> elements = getCarusals();
		boolean result = isListLoaded(elements);
		getCurrentFunctionName(false);
		return result;
	}

	public static List<WebElement> getEspots() throws Exception {
		try {
			getCurrentFunctionName(true);
			List<WebElement> espots = new ArrayList<WebElement>();
			if (isBD()) {
				espots = SelectorUtil.getAllElements(HomePageSelectors.espotsBD.get());
			} else if (isGH()) {
				espots = SelectorUtil.getAllElements(HomePageSelectors.GHespots.get());
			} else if (isRY()) {
				espots = SelectorUtil.getAllElements(HomePageSelectors.RYespots.get());
			} else {
				espots = SelectorUtil.getAllElements(HomePageSelectors.espots.get());
			}

			getCurrentFunctionName(false);
			return espots;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Espots selector cant be found bu selenium", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	public static boolean isDisplayAllSpots() throws Exception {
		getCurrentFunctionName(true);
		List<WebElement> elements = getEspots();
		boolean loaded = isListDisplayed(elements);
		getCurrentFunctionName(false);
		return loaded;
	}

	public static boolean isLoadedAllEspots() throws Exception {
		getCurrentFunctionName(true);
		List<WebElement> elements = getEspots();
		boolean result = isListLoaded(elements);
		getCurrentFunctionName(false);
		return result;
	}

	/**
	 * Log the number of items at the menu first level.
	 *
	 * @param menuFirstLevelElements.
	 * @throws Exception
	 */
	public static void logNumberOfFirstLevelMenuItems(List<WebElement> menuFirstLevelElements) throws Exception {
		getCurrentFunctionName(true);

		logs.debug("Validate number of menu items in first level.");

		// Display the number of items in the menu first level.
		logs.debug("Number of menu items: " + menuFirstLevelElements.size());

		getCurrentFunctionName(false);
	}

	/**
	 * Validate if there's a menu and it contains an item/s.
	 *
	 * @param menuFirstLevelElements.
	 * @return boolean
	 * @throws Exception
	 */
	public static boolean menuValidation(List<WebElement> menuFirstLevelElements) throws Exception {
		getCurrentFunctionName(true);

		// Get the menu items list.
		logs.debug("Validate if menu displayed.");

		// Check if there's an item in the menu by check the number of items at first
		// level.
		if (menuFirstLevelElements.size() == 0)
			return false;
		getCurrentFunctionName(false);

		return true;
	}

	/**
	 * Validate the sub menu and the items in first level navigation and the target
	 * page.
	 *
	 * @param menuFirstLevelElements.
	 * @return boolean
	 * @throws Exception
	 */

	public static boolean validateSubMenuLists(List<WebElement> menuFirstLevelElements) throws Exception {
		getCurrentFunctionName(true);

		try {
			logs.debug("Validate menu sub menus list." + menuFirstLevelElements);
			int menuItemIndex;
			boolean validateSubMenuNavigation = true;

			int numberOfMenuItems = menuFirstLevelElements.size();
			if (homePageMenuLevelTestItems <= numberOfMenuItems) {
				numberOfMenuItems = homePageMenuLevelTestItems;
			}

			for (menuItemIndex = 0; menuItemIndex < numberOfMenuItems; menuItemIndex++) {
				// The elements should be selected at each iteration because the page will
				// navigate and lose the reference to the elements dom.
				List<WebElement> elements = getFirstLevelMenuItems();
				WebElement element = elements.get(menuItemIndex);

				// Save the text and href for the selected menu item.
				String href = element.getAttribute("href");

				// Navigate to an item in the menu.
				if (isGH()) {
					Actions actions = new Actions(SelTestCase.getDriver());
					actions.moveToElement(element).click().perform();
				} else {
					SelectorUtil.clickOnWebElement(element);
				}
				// Get the current page URL.
				String currentPageUrl = SelectorUtil.getCurrentPageUrl();
				logs.debug("Current page path: " + currentPageUrl);

				// Check if the current page title is the same as selected navigation title.
				if (!href.toLowerCase().contains(currentPageUrl.toLowerCase())) {
					validateSubMenuNavigation = false;
				}

			}
			getCurrentFunctionName(false);
			return validateSubMenuNavigation;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed
							+ "Validation sub-menu lists has failed, a selector can't be found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	/**
	 * Get the list of first level elements in the menu.
	 *
	 * @return List<WebElement>
	 * @throws Exception
	 */
	public static List<WebElement> getFirstLevelMenuItems() throws Exception {
		try {
			getCurrentFunctionName(true);

			logs.debug("Get the menu items first level.");
			List<WebElement> menuFirstLevelElements = new ArrayList<WebElement>();

			// Get the menu items list.
			if (isBD()) {
				menuFirstLevelElements = SelectorUtil.getAllElements(HomePageSelectors.menuItemsBD.get());
			} else if (isGH()) {
				menuFirstLevelElements = SelectorUtil.getAllElements(HomePageSelectors.GHmenuItems.get());
			} else if (isRY()) {
				menuFirstLevelElements = SelectorUtil.getAllElements(HomePageSelectors.RYmenuItems.get());
			} else {
				menuFirstLevelElements = SelectorUtil.getAllElements(HomePageSelectors.menuItems.get());
			}
			getCurrentFunctionName(false);

			return menuFirstLevelElements;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "First level menu items selector cant be found bu selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	/**
	 * Open the navigation menu.
	 *
	 * @throws Exception
	 */
	public static void openNavigationMenu() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Open navigation menu");
			// Click on navigation menu icon and Navigate to an item in the menu.
			if (isBD()) {
				SelectorUtil.initializeSelectorsAndDoActions(HomePageSelectors.navIconBD.get());
			} else if (isGH()) {
				SelectorUtil.initializeSelectorsAndDoActions(HomePageSelectors.GHnavigationIcon.get());
			} else {
				SelectorUtil.initializeSelectorsAndDoActions(HomePageSelectors.navIcon.get());
			}
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Navigation menu selector cant be found bu selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	/**
	 * Validate the navigation first and second level with navigation menu at mobile
	 * PWA.
	 *
	 * @return boolean
	 * @throws Exception
	 */
	public static boolean validateModalMenuSecondLevel() throws Exception {
		try {
			getCurrentFunctionName(true);

			logs.debug("Validate second level menu list.");
			int menuItemIndex;
			boolean validateSubMenuNavigation = true;

			// Open the menu modal.
			HomePage.openNavigationMenu();

			// Get the first menu modal list.
			List<WebElement> menuFirstLevelElements = getFirstLevelMenuItems();

			int numberOfMenuItems = menuFirstLevelElements.size();
			if (homePageMenuLevelTestItems <= numberOfMenuItems) {
				numberOfMenuItems = homePageMenuLevelTestItems;
			}

			for (menuItemIndex = 0; menuItemIndex < numberOfMenuItems; menuItemIndex++) {
				boolean currentPageMatchNavigated = true;

				// The elements should be selected at each iteration because the page will
				// navigate and lose the reference to the elements dom.
				List<WebElement> elements = getFirstLevelMenuItems();
				WebElement element = elements.get(menuItemIndex);

				// Save the parent text.
				String selectedText = element.getText().toLowerCase();
				// Navigate to second level in the menu.
				SelectorUtil.clickOnWebElement(element);

				// Get the sub menu header text.
				WebElement selectedMenuHeader;
				if (isBD()) {
					selectedMenuHeader = SelectorUtil.getElement(HomePageSelectors.selectedMenuHeaderBD.get());
				}

				else if (isGH() || isRY()) {
					selectedMenuHeader = SelectorUtil.getElement(HomePageSelectors.GHselectedMenuHeader.get());
				} else {
					selectedMenuHeader = SelectorUtil.getElement(HomePageSelectors.selectedMenuHeader.get());
				}
				String selectedMenuHeaderText = selectedMenuHeader.getText().toLowerCase();

				// Get the current page URL.
				String pageUrl = SelectorUtil.getCurrentPageUrl();
				// Check if the sub menu header title is the same of the selected item text.
				if (!selectedMenuHeaderText.equals(selectedText)) {
					currentPageMatchNavigated = false;
					validateSubMenuNavigation = false;
				} else {
					SelectorUtil.waitGWTLoadedEventPWA();

					List<WebElement> leafMenuItems;
					// Select the list of leaf items in the menu.
					if (isBD()) {
						leafMenuItems = SelectorUtil.getAllElements(HomePageSelectors.leafMenuItemsBD.get());
					} else {
						leafMenuItems = SelectorUtil.getAllElements(HomePageSelectors.leafMenuItems.get());
					}

					// Select a random item from the leaf items list.
					Random rand = new Random();
					int randomIndex = rand.nextInt(leafMenuItems.size() - 1);
					WebElement randomElement = leafMenuItems.get(randomIndex);

					logs.debug("Random selected item from: " + randomIndex);

					// Get the current page URL.
					String href = randomElement.getAttribute("href");
					String elementClassName = randomElement.getAttribute("class");

					// Navigate to the selected random page.
					SelectorUtil.clickOnWebElement(randomElement);

					Thread.sleep(1000);
					if (!isBD())
						SelectorUtil.waitGWTLoadedEventPWA();
					String currentPageUrl = SelectorUtil.getCurrentPageUrl();
					// Get the current page URL.
					logs.debug("Navigated random page path: " + currentPageUrl + "    " + href);

					if (elementClassName.contains(pwaLinkClassNameIdentifier)) {
						// Check if the current page URL different than the previous page URL for PWA
						// mobile.
						if (!href.equalsIgnoreCase(currentPageUrl)) {
							currentPageMatchNavigated = false;
							validateSubMenuNavigation = false;
						}
					} else if (pageUrl.equalsIgnoreCase(currentPageUrl)) {
						// Check if the current page URL different than the previous page URL for
						// tablet.
						currentPageMatchNavigated = false;
						validateSubMenuNavigation = false;
					}

					// Open the menu modal.
					HomePage.openNavigationMenu();
				}
				sassert().assertTrue(currentPageMatchNavigated, "Menu validation items navigation has some problems");
			}
			getCurrentFunctionName(false);
			return validateSubMenuNavigation;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "List validation has failed, a selector cant be found bu selenium", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

}// End of class