package com.generic.page;

import java.text.MessageFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebElement;
import com.generic.selector.RegistrationSelectors;
import com.generic.setup.ExceptionMsg;
import com.generic.setup.LoggingMsg;
import com.generic.setup.SelTestCase;
import com.generic.util.RandomUtilities;
import com.generic.util.SelectorUtil;
import com.generic.util.SelectorUtil.commands.actions;
import java.net.URI;

public class Registration extends SelTestCase {
	public static class keys {
		public static final String password = "password";
		public static final String email = "mail";
	}

	public static class shippingAddress {

		public static class keys {

			public static final String isSavedShipping = "saved-shipping";

			public static final String countery = "countery";
			public static final String title = "title";
			public static final String lastName = "lastName";
			public static final String firstName = "firstName";
			public static final String adddressLine = "adddressLine";
			public static final String city = "city";
			public static final String state = "state";
			public static final String zipcode = "postal";
			public static final String phone = "phone";
		}
	}
	
	public static int RYGHFirstNameIndex =0;
	public static int RYGHLastNameIndex =2;
	public static int RYGHEmailAddressIndex =0;
	public static int RYGHPasswordIndex =2;
	public static int RYGHConfirmPasswordIndex =3;
	public static int RYGHAddressLineIndex =4;
	public static int RYGHCityIndex =6;
	public static int RYGHZIPCodeIndex =7;
	public static int RYGHPhoneIndex =8;
	

	
	
	// Done CBI Smoke
	public static void typeFirstName(String firstName) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug(MessageFormat.format(LoggingMsg.TYPING_ELEMENT_VALUE, "firstname ", firstName));
			
			if (isGH() || isRY() || isBD() || isGR()) {
				if (isMobile()) {
					List<WebElement> fields = SelectorUtil.getAllElements(RegistrationSelectors.firstNameGH.get());
					SelectorUtil.writeToFieldPWA(fields.get(RYGHFirstNameIndex),firstName);
				} else
					SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.firstNameGH.get(), firstName);
			}

			else if(isBD() && isMobile()) {
				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.firstNameBD.get(), firstName);
			}
			else {
				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.firstName.get(), firstName);
			}
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Firstname field selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	// Done CBI Smoke
	public static void typeLastName(String lastName) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug(MessageFormat.format(LoggingMsg.TYPING_ELEMENT_VALUE, "lastname ", lastName));
			
			if (isGH() || isRY() || isBD()) {
				if (isMobile()) {
					List<WebElement> fields = SelectorUtil.getAllElements(RegistrationSelectors.lastNameGH.get());
					SelectorUtil.writeToFieldPWA(fields.get(RYGHLastNameIndex),lastName);
				} else
					SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.lastNameGH.get(), lastName);

			} 
			else SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.lastName.get(), lastName);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Last naem field selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	// Done CBI Smoke
	public static void typeEmailAddress(String address) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug(MessageFormat.format(LoggingMsg.TYPING_ELEMENT_VALUE, "emailAddress ", address));
			
			if(isGH()|| isRY()) {
				if(isMobile()) {
					List <WebElement> fields = SelectorUtil.getAllElements(RegistrationSelectors.emailAddressGH.get());
					SelectorUtil.writeToFieldPWA(fields.get(RYGHEmailAddressIndex),address);
				}
				else
				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.emailAddressGH.get(), address);
			}
			else
			SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.emailAddress.get(), address);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Email field selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	// Done CBI Smoke
	public static void typePassword(String password) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug(MessageFormat.format(LoggingMsg.TYPING_ELEMENT_VALUE, "password ", password));
			if (isGH() || isRY()) {

				if (isMobile()) {
					List<WebElement> fields = SelectorUtil.getAllElements(RegistrationSelectors.passwordGH.get());
					SelectorUtil.writeToFieldPWA(fields.get(RYGHPasswordIndex),password);
				} else
					SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.passwordGH.get(), password);

			} else
				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.password.get(), password);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Password field selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// Done CBI Smoke
	public static void typeConfirmPassword(String confPassword) throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug(MessageFormat.format(LoggingMsg.TYPING_ELEMENT_VALUE, "confirmPassword", confPassword));
			if (isGH() || isRY()) {
				if (isMobile()) {
					List<WebElement> fields = SelectorUtil
							.getAllElements(RegistrationSelectors.confirmPasswordGH.get());
					SelectorUtil.writeToFieldPWA(fields.get(RYGHConfirmPasswordIndex),confPassword);
				} else
					SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.confirmPasswordGH.get(),
							confPassword);

			} else
				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.confirmPassword.get(), confPassword);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Confirm password field selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// Done CBI Smoke
	public static void typeCompany(String comapnyName) throws Exception {
		try {
			getCurrentFunctionName(true);
			if (!isRY()) {
				logs.debug(MessageFormat.format(LoggingMsg.TYPING_ELEMENT_VALUE, "companyName", comapnyName));
				if (isGH() || isBD()) {
					if (isMobile()) {
						List<WebElement> fields = SelectorUtil
								.getAllElements(RegistrationSelectors.companyNameGH.get());
						SelectorUtil.writeToFieldPWA(fields.get(3),comapnyName);
					} else
						SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.companyNameGH.get(),
								comapnyName);
				} else
					SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.companyName.get(), comapnyName);
			}
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Company field selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// Done CBI Smoke
	public static void clickRegisterButton() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug(MessageFormat.format(LoggingMsg.CLICKING_SEL, "Register btn"));
			SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.registerBtn.get(),
					"ForceAction,click");
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Register button selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	// Done CBI Smoke
	public static void fillRegistrationFirstStep(String email, String confEmail, String confPassword, String password)
			throws Exception {
		try {
			getCurrentFunctionName(true);
			Thread.sleep(1500);
			if (!"".equals(email))
				typeEmailAddress(email);
			
			if (!"".equals(confEmail))
				typeconfEmailAddress(confEmail);

			if (!"".equals(password))
				typePassword(password);

			if (!"".equals(confPassword))
				typeConfirmPassword(confPassword);

			Thread.sleep(1000);

			clickRegisterButton();

			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	// Done CBI Smoke
	public static void fillRegistrationSecondStep(String fName, String lName, String companyName,
			LinkedHashMap<String, String> addressDetails) throws Exception {
		try {
			getCurrentFunctionName(true);

			if (!"".equals(fName))
				typeFirstName(fName);

			if (!"".equals(lName))
				typeLastName(lName);

			if (!"".equals(companyName))
				typeCompany(companyName);

			typeAddressLine1(RandomUtilities.getRandomName());

			if (!"".equals(addressDetails.get(shippingAddress.keys.city)))
				typeCity(addressDetails.get(shippingAddress.keys.city));

			if (!"".equals(addressDetails.get(shippingAddress.keys.state)))
				typeState(addressDetails.get(shippingAddress.keys.state));

			if (!"".equals(addressDetails.get(shippingAddress.keys.zipcode)))
				typeZipcode(addressDetails.get(shippingAddress.keys.zipcode));

			typePhone(RandomUtilities.getRandomPhone());

			clickSaveButton();
			getCurrentFunctionName(false);
		}

		catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	// Done CBI
	public static void clickSaveButton() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug(MessageFormat.format(LoggingMsg.CLICKING_SEL, "Register btn"));
			SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.saveButton.get(), "");
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Save button selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	// Done CBI Smoke
	private static void typePhone(String phone) throws Exception {
		try {
			getCurrentFunctionName(true);
			if (isGH() || isRY() || isBD()) {
				if (isMobile()) {
					List<WebElement> fields = SelectorUtil.getAllElements(RegistrationSelectors.phoneGH.get());
					SelectorUtil.writeToFieldPWA(fields.get(RYGHPhoneIndex), phone);
				} else
					SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.phoneGH.get(), phone);

			} else if (isBD() && isMobile()) {
				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.phoneBD.get(), phone);
			}
			else {
				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.phone.get(), phone);
			}
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Phone field selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	// Done CBI Smoke
	private static void typeconfEmailAddress(String email) throws Exception {
		try {
			getCurrentFunctionName(true);
			if (isGH() ) {
				if (!isMobile())
					SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.confirmEmailAddress.get(),
							email);
			} else if (isGR() || isFG() || isRY() ||isBD()) {
				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.confirmEmailAddress.get(), email);

			}

			logs.debug("Data is" + email);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Confirm email field selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	// Done CBI Smoke
	private static void typeAddressLine1(String address) throws Exception {
		try {
			getCurrentFunctionName(true);
			if (isGH() || isRY() || isBD()) {
				if (isMobile()) {
					List<WebElement> fields = SelectorUtil.getAllElements(RegistrationSelectors.AddressLine1GH.get());
					SelectorUtil.writeToFieldPWA(fields.get(RYGHAddressLineIndex),address);
				} else
					SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.AddressLine1GH.get(), address);

			} else
				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.AddressLine1.get(), address);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Address field selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	// Done CBI Smoke
	private static void typeCity(String city) throws Exception {
		try {
			getCurrentFunctionName(true);
			if (isGH() || isRY() || isBD()) {
				if (isMobile()) {
					List<WebElement> fields = SelectorUtil.getAllElements(RegistrationSelectors.cityGH.get());
					SelectorUtil.writeToFieldPWA(fields.get(RYGHCityIndex),city);
				} else
					SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.cityGH.get(), city);
			} else
				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.city.get(), city);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "City field selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	// Done CBI Smoke
	private static void typeState(String state) throws Exception {
		try {
			getCurrentFunctionName(true);
			if (isGH() || isRY()|| isBD()) {
				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.stateGH.get(), state);
			} else
				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.state.get(), state);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "State drop down selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	// Done CBI Smoke
	private static void typeZipcode(String zipcode) throws Exception {
		try {
			getCurrentFunctionName(true);
			if (isGH() || isRY()|| isBD()) {
				if (isMobile()) {
					List<WebElement> fields = SelectorUtil.getAllElements(RegistrationSelectors.ZipcodeGH.get());
					SelectorUtil.writeToFieldPWA(fields.get(RYGHZIPCodeIndex),zipcode);
				} else
					SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.ZipcodeGH.get(), zipcode);

			} else
				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.Zipcode.get(), zipcode);
			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "ZIP Code field selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	// Done CBI
	public static String getFirstNameError() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug(MessageFormat.format(LoggingMsg.GETTING_TEXT, "First Name Error"));
			SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.firstNameError.get());
			getCurrentFunctionName(false);
			return SelectorUtil.textValue.get();
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "First name error msg selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// Done CBI
	public static String getLastNameError() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug(MessageFormat.format(LoggingMsg.GETTING_TEXT, "Last Name Error"));
			SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.lastNameError.get());
			getCurrentFunctionName(false);
			return SelectorUtil.textValue.get();
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Last name erro msg selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	// Done CBI
	public static String getEmailAddressErrorInvalid() throws Exception {
		try {
			getCurrentFunctionName(true);

			if (isMobile()) {
				logs.debug(MessageFormat.format(LoggingMsg.GETTING_TEXT, "Email Address Error"));
				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.emailAddressErrorMobile.get(),
						MessageFormat.format(actions.index, "0"));
			} else {
				logs.debug(MessageFormat.format(LoggingMsg.GETTING_TEXT, "Email Address Error"));
				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.emailAddressError.get());
			}

			getCurrentFunctionName(false);
			return SelectorUtil.textValue.get();
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Email address error msg selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// Done CBI
	public static String getConfEmailAddressErrorInvalid() throws Exception {
		try {
			getCurrentFunctionName(true);

			if (isMobile()) {
				logs.debug(MessageFormat.format(LoggingMsg.GETTING_TEXT, "Email Address Error"));
				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.confEmailAddressErrorMobile.get(),
						MessageFormat.format(actions.index, "1"));
			} else {
				logs.debug(MessageFormat.format(LoggingMsg.GETTING_TEXT, "Email Address Error"));
				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.confEmailAddressError.get(), "");
			}

			getCurrentFunctionName(false);
			return SelectorUtil.textValue.get();
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed
					+ "Confirm email address error msg selector was not found by selenuim", new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// Done CBI
	public static String getPasswordError() throws Exception {
		try {
			getCurrentFunctionName(true);

			if (isMobile()) {
				logs.debug(MessageFormat.format(LoggingMsg.GETTING_TEXT, "Email Address Error"));
				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.passwordRulesErrorMobile.get(),
						MessageFormat.format(actions.index, "2"));

			} else {
				logs.debug(MessageFormat.format(LoggingMsg.GETTING_TEXT, "Email Address Error"));
				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.passwordRulesError.get());
			}

			getCurrentFunctionName(false);
			return SelectorUtil.textValue.get();
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Password error msg selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// Done CBI
	public static String getConfirmPasswordError() throws Exception {
		try {
			getCurrentFunctionName(true);

			if (isMobile()) {
				logs.debug(MessageFormat.format(LoggingMsg.GETTING_TEXT, "Confirm Password Error"));
				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.confirmPasswordErrorMobile.get(),
						MessageFormat.format(actions.index, "3"));
			} else {
				logs.debug(MessageFormat.format(LoggingMsg.GETTING_TEXT, "Confirm Password Error"));
				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.confirmPasswordError.get());
			}

			getCurrentFunctionName(false);
			return SelectorUtil.textValue.get();
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Confirm password error msg selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// done CBI
	public static String getFirstNameErrorInvalid() throws Exception {
		try {
			getCurrentFunctionName(true);

			if (isMobile()) {
				logs.debug(MessageFormat.format(LoggingMsg.GETTING_TEXT, "First name Error"));
				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.firstNameErrorMobile.get(),
						MessageFormat.format(actions.index, "0"));
			} else {
				logs.debug(MessageFormat.format(LoggingMsg.GETTING_TEXT, "First name Error"));
				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.firstNameError.get());
			}

			getCurrentFunctionName(false);
			return SelectorUtil.textValue.get();
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "First name error msg selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// done CBI
	public static String getLastNameErrorInvalid() throws Exception {
		try {
			getCurrentFunctionName(true);

			if (isMobile()) {
				logs.debug(MessageFormat.format(LoggingMsg.GETTING_TEXT, "Last name Error"));
				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.lastNameErrorMobile.get(),
						MessageFormat.format(actions.index, "1"));
			} else {
				logs.debug(MessageFormat.format(LoggingMsg.GETTING_TEXT, "Last name Error"));
				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.lastNameError.get());
			}

			getCurrentFunctionName(false);
			return SelectorUtil.textValue.get();
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Last name error msg selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// done CBI
	public static String getStreetAddressErrorInvalid() throws Exception {
		try {
			getCurrentFunctionName(true);

			if (isMobile()) {
				logs.debug(MessageFormat.format(LoggingMsg.GETTING_TEXT, "Street address Error"));
				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.streetAddreesErrorMobile.get(),
						MessageFormat.format(actions.index, "2"));
			} else {
				logs.debug(MessageFormat.format(LoggingMsg.GETTING_TEXT, "Street address Error"));
				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.streetAddreesError.get());
			}

			getCurrentFunctionName(false);
			return SelectorUtil.textValue.get();
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Street address error msg selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// done CBI
	public static String getCityErrorInvalid() throws Exception {
		try {
			getCurrentFunctionName(true);

			if (isMobile()) {
				logs.debug(MessageFormat.format(LoggingMsg.GETTING_TEXT, "City Error"));
				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.cityErrorMobile.get(),
						MessageFormat.format(actions.index, "3"));
			} else {
				logs.debug(MessageFormat.format(LoggingMsg.GETTING_TEXT, "City Error"));
				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.cityError.get());
			}

			getCurrentFunctionName(false);
			return SelectorUtil.textValue.get();
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "City error msg selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// done CBI
	public static String getStateErrorInvalid() throws Exception {
		try {
			getCurrentFunctionName(true);

			if (isMobile()) {
				logs.debug(MessageFormat.format(LoggingMsg.GETTING_TEXT, "State Error"));
				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.stateErrorMobile.get());
			} else {
				logs.debug(MessageFormat.format(LoggingMsg.GETTING_TEXT, "State Error"));
				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.stateError.get());
			}

			getCurrentFunctionName(false);
			return SelectorUtil.textValue.get();
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "State error msg selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// done CBI
	public static String getZIPCodeErrorInvalid() throws Exception {
		try {
			getCurrentFunctionName(true);

			if (isMobile()) {
				logs.debug(MessageFormat.format(LoggingMsg.GETTING_TEXT, "State Error"));
				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.ZIPCodeErrorMobile.get(),
						MessageFormat.format(actions.index, "4"));
			} else {
				logs.debug(MessageFormat.format(LoggingMsg.GETTING_TEXT, "State Error"));
				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.ZIPCodeError.get());
			}

			getCurrentFunctionName(false);
			return SelectorUtil.textValue.get();
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "ZIP Code error msg selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// done CBI
	public static String getPhoneErrorInvalid() throws Exception {
		try {
			getCurrentFunctionName(true);

			if (isMobile()) {
				logs.debug(MessageFormat.format(LoggingMsg.GETTING_TEXT, "State Error"));
				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.phoneErrorMobile.get(),
						MessageFormat.format(actions.index, "5"));
			} else {
				logs.debug(MessageFormat.format(LoggingMsg.GETTING_TEXT, "State Error"));
				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.phoneError.get());
			}

			getCurrentFunctionName(false);
			return SelectorUtil.textValue.get();
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Phone error msg selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}
	}

	// Done CBI Smoke
	public static String getRegistrationSuccessMessage() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug(MessageFormat.format(LoggingMsg.GETTING_TEXT, "welcome Message check"));

			if (isGH()) {
				try {
					SelectorUtil.isDisplayed(RegistrationSelectors.welcomeMessageGH.get());
				} catch (Exception e) {
					logs.debug("Registration has failed");
				}
			}

			else if (isRY()) {
				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.welcomeMessageRY.get(), "");
			}

			else if (isGR() || isFG()) {
				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.welcomeMessage.get(), "");
			}

			getCurrentFunctionName(false);

			return SelectorUtil.textValue.get();
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed + "Registration sucess msg selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	// Done CBI Smoke
	public static void goToRegistrationForm() throws Exception {
		try {
			getCurrentFunctionName(true);
			logs.debug(MessageFormat.format(LoggingMsg.GETTING_TEXT,
					"Navigating to registration page..." + getCONFIG().getProperty("RegistrationPage")));
			getDriver().get(new URI(getDriver().getCurrentUrl()).resolve(getCONFIG().getProperty("RegistrationPage"))
					.toString());

			// GH
			if (isGH() || isBD()) {

				if (!isMobile()) {
					logs.debug(
							MessageFormat.format(LoggingMsg.GETTING_TEXT, "Clicking Register Button for desktop..."));
					SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.registrationButton.get());

				} else {
					logs.debug(MessageFormat.format(LoggingMsg.GETTING_TEXT, "Clicking Register Tab for mobile... GH"));
					SelectorUtil.getAllElements(RegistrationSelectors.mobileRegistrationTabGHBD.get()).get(1).click();

					logs.debug(MessageFormat.format(LoggingMsg.GETTING_TEXT,
							"Clicking Register Button for mobile...  GH"));
					SelectorUtil
							.initializeSelectorsAndDoActions(RegistrationSelectors.mobileRegistrationButtonGHBD.get());
				}

				// RY
			} else if (isRY()) {
				logs.debug(MessageFormat.format(LoggingMsg.GETTING_TEXT, "Clicking Register Button RY..."));
				SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.registrationButtonRY.get());

			}

			// FG, GR
			else if (isGR() || isFG()) {
				if (!isMobile()) {
					logs.debug(
							MessageFormat.format(LoggingMsg.GETTING_TEXT, "Clicking Register Button for desktop..."));
					SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.registrationButton.get());
				} else {

					logs.debug(MessageFormat.format(LoggingMsg.GETTING_TEXT, "Clicking Register Tab for mobile..."));
					SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.mobileRegistrationTab.get());

					logs.debug(MessageFormat.format(LoggingMsg.GETTING_TEXT, "Clicking Register Button for mobile..."));
					SelectorUtil.initializeSelectorsAndDoActions(RegistrationSelectors.mobileRegistrationButton.get());
				}
			}

			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(
					ExceptionMsg.PageFunctionFailed
							+ "Navigation to registration form has failed, a selector was not found by selenuim",
					new Object() {
					}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

	// Done - CBI
	public static String registerFreshUser(String email, String password) throws Exception {

		// Prepare registration data
		String firstName = RandomUtilities.getRandomName();
		String lastName = RandomUtilities.getRandomName();

		return registerFreshUser(email, password, firstName, lastName);
	}

	// Done - CBI
	@SuppressWarnings("unchecked")
	public static String registerFreshUser(String email, String password, String fname, String lname) throws Exception {

		// click on register new user button
		Registration.goToRegistrationForm();
		// prepare random address details
		LinkedHashMap<String, String> addressDetails = (LinkedHashMap<String, String>) addresses.get("A3");

		// Prepare registration data
		String firstName = fname;
		String lastName = lname;
		String companyName = RandomUtilities.getRandomName();

		// register new user and validate the results
		Registration.fillRegistrationFirstStep(email, email, password, password);

		Thread.sleep(6500);
		Registration.fillRegistrationSecondStep(firstName, lastName, companyName, addressDetails);

		// Success message needs to be updated on excel to (Welcome to your account at )
		String registrationSuccessMsg = Registration.getRegistrationSuccessMessage();
		return registrationSuccessMsg;
	}
	


}
