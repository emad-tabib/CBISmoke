package com.generic.page.PDP;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.generic.page.PDP.PDP.keys;
import com.generic.selector.PDPSelectors;
import com.generic.setup.ExceptionMsg;
import com.generic.setup.SelTestCase;
import com.generic.util.SelectorUtil;

public class PDP_WL extends SelTestCase {
	// Done SMK
	public static boolean validateSelectRegistryOrWishListModalIsDisplayed() throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisplayed;
			logs.debug("Validate select a registry or wish list modal exist");
			isDisplayed = SelectorUtil.isDisplayed(PDPSelectors.SelectRegistryOrWishListModal.get());
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "Modal for selecting gift registrey selector was not found by seleniuem", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static void clickOnCreateNewWL() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Click on create new wish list");
			if (isRY()) {
				List<WebElement> elements = SelectorUtil.getAllElements(PDPSelectors.RYcreateNewWL.get());
				SelectorUtil.clickOnWebElement(elements.get(elements.size() - 1));

			} else {
				WebElement element = SelectorUtil.getElement(PDPSelectors.giftRegistryListBox.get());
				WebElement option;
				
				try {// Selector is not stable
					option = element.findElement(By.cssSelector(PDPSelectors.createNewWL.get()));

				} catch (Exception e) {
					option = element.findElement(By.cssSelector(PDPSelectors.createNewWL2.get()));
				}
				
				option.click();
				
				if(isBD() && isMobile()) {
					SelectorUtil.initializeSelectorsAndDoActions(PDPSelectors.addButtonWLModal.get());		
				}
				
				
				if(!isMobile())
				  clickOnCreateNewWLConfirmationBtn();
			}
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Create wishlsit selector was not found by seleniuem",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static boolean validateNameYourNewWLModalIsDisplayed() throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisplayed = true;
			logs.debug("Validate Name your new wish list modal exist");
			
			if (isBD())
				isDisplayed = SelectorUtil.isDisplayed(PDPSelectors.nameYourNewWLBD.get());
			else
				isDisplayed = SelectorUtil.isDisplayed(PDPSelectors.nameYourNewWL.get());
			
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Name your wishlist mdoal selector was not found by seleniuem",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static void createNewWL(String WLName) throws Exception {
		try {
			getCurrentFunctionName(true);
			SelectorUtil.initializeSelectorsAndDoActions(PDPSelectors.WLName.get(), WLName);
			if (isBD())
				SelectorUtil.initializeSelectorsAndDoActions(PDPSelectors.BDnameYourNewWLconfirmationBtn.get());
			else
				SelectorUtil.initializeSelectorsAndDoActions(PDPSelectors.nameYourNewWLconfirmationBtn.get());

			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "create a new wishlist button selector was not found by seleniuem", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static String getWishListName() {
		int random = (int) (Math.random() * 1000000 + 1);
		String WLName = keys.WLRandomName + random;
		return WLName;
	}

	public static boolean validateCreatedWLisSelectedByDefault(String createdWL) throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isSelected = true;
			Select element = new Select(SelectorUtil.getElement(PDPSelectors.giftRegistryListBox.get()));
			WebElement option = element.getFirstSelectedOption();
			String defaultWL = option.getText();
			String selectedWL = defaultWL;
			selectedWL = selectedWL.replaceAll("\"", "");
			if (selectedWL.equals(createdWL)) {
				isSelected = true;
			} else {
				isSelected = false;
			}
			getCurrentFunctionName(false);
			return isSelected;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Gift registries list box selector was not found by seleniuem",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static void clickOnCreateNewWLConfirmationBtn() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug("Click on create new wish list");
			if (isBD())
				SelectorUtil.initializeSelectorsAndDoActions(PDPSelectors.BDcreateNewWLConfirmationBtn.get());
			else
				SelectorUtil.initializeSelectorsAndDoActions(PDPSelectors.createNewWLConfirmationBtn.get());
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "Create a new wishlist button selector was not found by seleniuem", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	public static boolean validateConfirmationModalWithCorrectProductIsDisplayed(String selectedProductName)
			throws Exception {

		try {
			getCurrentFunctionName(true);

			boolean isDisplayed;
			logs.debug("Validate  if confirmation modal exists");

			try {
				Thread.sleep(2500);

				isDisplayed = SelectorUtil.isDisplayed(PDPSelectors.confirmationModal.get());
				logs.debug("Validate confirmation modal exist menu" + isDisplayed + "   " + selectedProductName);

				WebElement addToCardProductElement; 
				
				if (isMobile() && isGH()) {
					addToCardProductElement = SelectorUtil.getElement(PDPSelectors.productNameinWLModalGHMobile.get());

				} else if (isBD()) {

					addToCardProductElement = SelectorUtil.getElement(PDPSelectors.addToCardProductNameBD.get());
				} else {
					addToCardProductElement = SelectorUtil.getElement(PDPSelectors.addToCardProductName.get());

				}

				String viewListBtnSelector;
				
				if (isGH() || isRY()) {
					viewListBtnSelector = PDPSelectors.GHRYviewListBtn.get();
				} else if (isGR()) {
					viewListBtnSelector = PDPSelectors.viewListBtnGR.get();
				} else if (isBD()) {
					viewListBtnSelector = PDPSelectors.BDRYviewListBtn.get();
				} else {
					viewListBtnSelector = PDPSelectors.viewListBtn.get();
				}

				if (addToCardProductElement.getText().equals(selectedProductName))
					logs.debug("Product is the right added one");

				Thread.sleep(2500);
				SelectorUtil.initializeSelectorsAndDoActions(viewListBtnSelector);
				getCurrentFunctionName(false);

				return isDisplayed;

			} catch (Exception e) {
				logs.debug("Validate confirmation modal failed ");
				return false;

			}

		} catch (Exception e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Added to wishlist modal selector was not found by seleniuem",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;

		}
	}

	public static boolean addedProductIsDisplayedInTheWL(String addedProductName) throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisplayed = true;
			Thread.sleep(3500);
			List<WebElement> products = SelectorUtil.getElementsList(PDPSelectors.addedProductName.get());
			List<WebElement> addToCartBtns = new ArrayList<WebElement>();
			if (isGH() || isBD()) {
				addToCartBtns = SelectorUtil.getElementsList(PDPSelectors.GHmyWLAddToCartBtn.get());
			} else if (isRY()) {
				addToCartBtns = SelectorUtil.getElementsList(PDPSelectors.RYmyWLAddToCartBtn.get());
			} else {
				addToCartBtns = SelectorUtil.getElementsList(PDPSelectors.myWLAddToCartBtn.get());
			}

			for (int i = 0; i < products.size(); i++) {
				if (products.get(i).getText().toLowerCase().contains(addedProductName.toLowerCase())) {
					SelectorUtil.clickOnWebElement(addToCartBtns.get(i));
					return true;
				}
			}
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "added product to wishlist validation has faleid, a selector is missing", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	public static boolean selectWLByName(String createdWL) throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isSelected = false;
			List<WebElement> elements = SelectorUtil.getAllElements(PDPSelectors.RYcreateNewWLName.get());
			for (int index = 0; index < elements.size(); index++) {
				if (elements.get(index).getText().toLowerCase().equalsIgnoreCase(createdWL)) {
					isSelected = true;
					List<WebElement> WLElements = SelectorUtil.getAllElements(PDPSelectors.RYcreateNewWL.get());
					SelectorUtil.clickOnWebElement(WLElements.get(index));
					break;
				}
			}
			getCurrentFunctionName(false);
			return isSelected;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Wihsllist name selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	/**
	 * Check if the add to cart button is enabled.
	 *
	 * @throws Exception
	 */
	public static boolean validateAddToWLGRIsEnabled(Boolean Bundle, String ProductID) throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisplayed;
			logs.debug("Validate if Add To WL/GR Is Displayed");
			// here it will pass if the button exist regardless if it is enabled or
			// disabled.
			// because there is no attribute to verify if it is enabled.
			String selectorEnabled;

			if (isFGGR()) {
				if (Bundle)
					selectorEnabled = PDPSelectors.addToWLGRBtnEnabledBundleMobile.get();
				else
					selectorEnabled = PDPSelectors.addToWLGRBtnEnabledSingle.get();
			}

			else if (isRY())
				selectorEnabled = PDPSelectors.RYAddToWLGRBtnEnabledSingle.get();

			else if (isBD()) {
				if (Bundle)
					selectorEnabled = PDPSelectors.BDaddToWLGRBtnEnabledBundleMobile.get();
				else
					selectorEnabled = PDPSelectors.BDaddToWLGRBtnEnabledSingle.get();
			}
			else
				selectorEnabled = PDPSelectors.GHAddToWLGRBtnEnabledSingle.get();
			
			if (!isMobile() && Bundle) {
				String addToWLGRBtnEnabledBundleSelector;
				if (isBD())
					selectorEnabled = PDPSelectors.BDaddToWLGRBtnEnabledSingle.get();
				else if (isGH()) {
					addToWLGRBtnEnabledBundleSelector = PDPSelectors.GHAddToWLGRBtnEnabledBundle;
					logs.debug(addToWLGRBtnEnabledBundleSelector);
					selectorEnabled = MessageFormat.format(addToWLGRBtnEnabledBundleSelector, ProductID);
				} else {
					addToWLGRBtnEnabledBundleSelector = PDPSelectors.addToWLGRBtnEnabledBundle;
					logs.debug(addToWLGRBtnEnabledBundleSelector);
					selectorEnabled = MessageFormat.format(addToWLGRBtnEnabledBundleSelector, ProductID);
				}
			}
            isDisplayed = SelectorUtil.isDisplayed(selectorEnabled);
            getCurrentFunctionName(false);
            return isDisplayed;
        } catch (NoSuchElementException e) {
            logs.debug(MessageFormat.format(
                    ExceptionMsg.PageFunctionFailed + "Add to gift registrey button selector was not found by selenium",
                    new Object() {
                    }.getClass().getEnclosingMethod().getName()));
            throw e;
        }
    }
	
	
	// CS WL Button
	public static boolean validateAddToWLGRIsEnabledCS(Boolean Bundle, String ProductID) throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisplayed;
			logs.debug("Validate if Add To WL/GR Is Displayed");

			String selectorEnabled;

			selectorEnabled = PDPSelectors.BDaddToWLGRBtnEnabledCSMobile.get();

			if (!isMobile() && Bundle) {
				if (isBD())
					selectorEnabled = PDPSelectors.BDaddToWLGRBtnEnabledSingle.get();

			}
			isDisplayed = SelectorUtil.isDisplayed(selectorEnabled);
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Add to gift registrey button selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	
	// SC WL Button
	public static boolean validateAddToWLGRIsEnabledSC(Boolean Bundle, String ProductID) throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisplayed;
			logs.debug("Validate if Add To WL/GR Is Displayed");

			String selectorEnabled;

			selectorEnabled = PDPSelectors.BDaddToWLGRBtnEnabledSC.get();

			if (!isMobile() && Bundle) {
				if (isBD())
					selectorEnabled = PDPSelectors.BDaddToWLGRBtnEnabledSingle.get();

			}
			isDisplayed = SelectorUtil.isDisplayed(selectorEnabled);
			getCurrentFunctionName(false);
			return isDisplayed;
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Add to gift registrey button selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	
	//.t-product-details__wishlist-button
	
	public static boolean validateAddToWLGRIsEnabledVK(Boolean Bundle, String ProductID) throws Exception {
		try {
			getCurrentFunctionName(true);
			boolean isDisplayed;
			logs.debug("Validate if Add To WL/GR Is Displayed");
			String addToWLGRBtnEnabledBundleSelector;
			
			addToWLGRBtnEnabledBundleSelector = PDPSelectors.BDaddToWLGRBtnEnabledSingle.get();
			
			if (isMobile() && Bundle) {
				
				addToWLGRBtnEnabledBundleSelector = PDPSelectors.BDaddToWLGRBtnEnabledBundleMobile.get();

			}
			
            isDisplayed = SelectorUtil.isDisplayed(addToWLGRBtnEnabledBundleSelector);
            getCurrentFunctionName(false);
            return isDisplayed;
        } catch (NoSuchElementException e) {
            logs.debug(MessageFormat.format(
                    ExceptionMsg.PageFunctionFailed + "Add to gift registrey button selector was not found by selenium",
                    new Object() {
                    }.getClass().getEnclosingMethod().getName()));
            throw e;
        }
    }

	// done - SMK
	public static void clickAddToWLGR() throws Exception {
		try {
			getCurrentFunctionName(true);
			if (isGH()) {
				SelectorUtil.initializeSelectorsAndDoActions(PDPSelectors.GHaddToWLGRBtnEnabled.get());
			} else if (isRY()) {
				WebElement element = SelectorUtil.getElement(PDPSelectors.RYaddToWLGRBtnEnabled.get());
				element.click();
			} else if (isBD()) {
				try {
					SelectorUtil.initializeSelectorsAndDoActions(PDPSelectors.BDaddToWLGRBtnEnabledSingle.get());
				} catch (Exception e) {
					SelectorUtil.initializeSelectorsAndDoActions(PDPSelectors.BDaddToWLGRBtnEnabledSingle2.get());

				}
			} else {
				SelectorUtil.initializeSelectorsAndDoActions(PDPSelectors.addToWLGRBtnEnabled.get());
			}
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Add to wishlistGR button selector was not found by selenium",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}
	

	// Done SMK
	public static boolean selectWLByName() throws Exception {
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
