package com.generic.setup;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.SkipException;

import com.generic.setup.GlobalVariables.browsers;
import com.generic.util.ReportUtil;
import com.generic.util.dataProviderUtils;

public class Common extends SelTestCase {

	public static String expected = null;
	public static String actual = null;

	public static class DataSheetConstants {
	}

	public static WebDriver initializeBrowser(String browser) throws Exception {
		getCurrentFunctionName(true);
		WebDriver driverInstance = null;
		try {
			logs.debug(MessageFormat.format(LoggingMsg.BROWSER_NAME, browser));
			if (browser.equalsIgnoreCase("chrome")) {

				System.setProperty("webdriver.chrome.driver", PagesURLs.getDriversPath(browser));
				ChromeOptions co = new ChromeOptions();
				co.addArguments("--ignore-certificate-errors");
				driverInstance = new ChromeDriver(co);
				driverInstance.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				driverInstance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			} else if (browser.contains("mobile")) {
				/*
				 * https://cs.chromium.org/chromium/src/chrome/test/chromedriver/chrome/
				 * mobile_device_list.cc iPad Nexus 6 Nexus 5 Galaxy Note 3 Nexus 6P iPhone 8
				 * Plus iPhone 7 Plus Nexus 7 iPhone 7 Nexus 10 iPhone 8 iPhone 6 Nexus 5X
				 * Galaxy Note II iPhone 6 Plus iPhone X Galaxy S5
				 */

				String mobile = browser.split("_")[1];

				Map<String, String> mobileEmulation = new HashMap<String, String>();
				mobileEmulation.put("deviceName", mobile);
				Map<String, Object> chromeOptions = new HashMap<String, Object>();
				chromeOptions.put("mobileEmulation", mobileEmulation);

				ChromeOptions options = new ChromeOptions();
				options.addArguments("--ignore-certificate-errors");

				if (getCONFIG().getProperty("chached_chrome").equalsIgnoreCase("yes")) {
					options.addArguments("user-data-dir=" + System.getProperty("user.home")
							+ "/AppData/Local/Google/Chrome SxS/User Data/");
					options.addArguments("detach=true");
				}

				options.setExperimentalOption("mobileEmulation", mobileEmulation);

				System.setProperty("webdriver.chrome.driver", PagesURLs.getDriversPath("chrome"));
				driverInstance = new ChromeDriver(options);

			} else {
				logs.debug(LoggingMsg.INVALID_BROWSER_ERROR_MSG);
				throw new Exception(LoggingMsg.INVALID_BROWSER_ERROR_MSG);
			}

		} catch (Throwable t) {
			t.printStackTrace();
			SelTestCase.setTestStatus("Fail: " + t.getMessage());
			SelTestCase.setStartTime(ReportUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa"));
			ReportUtil.addError(SelTestCase.getTestStatus(), null);
			throw new Exception(t);
		}
		getCurrentFunctionName(false);
		return driverInstance;
	}

	/**
	 * Reads URL from config.properties file
	 * 
	 * @throws Exception
	 *
	 *
	 */
	public static void launchApplication(String Browser, String Env, String brand) throws Exception {
		getCurrentFunctionName(true);

		logs.debug(MessageFormat.format(LoggingMsg.TEST_ENVIRONMENT_NAME, Env));

		logs.debug("brand: " + brand);

		if (getCONFIG().getProperty("chached_chrome").equalsIgnoreCase("yes")) {
			// TODO: please enable it later with correct url in case Chrome Cached
			logs.debug(LoggingMsg.ENABLE_BLOCK_FOR_FUTURE);
			logs.debug("signing out from all users");
			logs.debug(PagesURLs.getSignOutPage());
			getDriver().get(PagesURLs.getSignOutPage());
		}

		String url = brands.get(Env, brand);
		logs.debug("Navigating to the following brand/ env :" + url);
		SelTestCase.setURL(url);
	//	launchProdWCS8StaticLinks(Env, brand);
		getDriver().get(url);
		if (!Browser.contains(browsers.iOS))
			getDriver().manage().window().maximize();

		if (Browser.contains("IE") || Browser.contains("edge")) {
			Thread.sleep(2000);
			getDriver().navigate().to("javascript:document.getElementById('overridelink').click()");
		}
		getCurrentFunctionName(false);
	}

	public static void launchProdWCS8StaticLinks(String Env, String brand) throws Exception {
		getCurrentFunctionName(true);

		if (Env.contains("prod") || Env.contains("www")) {
			logs.debug("Navigating to the static CSS links for the folloing brand:" + brand);
			if (brand.equalsIgnoreCase("FG")) {
				getDriver().get(GlobalVariables.WCS8StaticUrls.FGStatic1);
				Thread.sleep(2000);
				getDriver().get(GlobalVariables.WCS8StaticUrls.FGStatic2);
				Thread.sleep(2000);
			}

			if (brand.equalsIgnoreCase("GR")) {
				getDriver().get(GlobalVariables.WCS8StaticUrls.GRStatic1);
				Thread.sleep(2000);
				getDriver().get(GlobalVariables.WCS8StaticUrls.GRStatic2);
				Thread.sleep(2000);
			}

			if (brand.equalsIgnoreCase("GH")) {
				getDriver().get(GlobalVariables.WCS8StaticUrls.GHStatic1);
				Thread.sleep(2000);
				getDriver().get(GlobalVariables.WCS8StaticUrls.GHStatic2);
				Thread.sleep(2000);
			}

			if (brand.equalsIgnoreCase("BD")) {
				getDriver().get(GlobalVariables.WCS8StaticUrls.BDStatic1);
				Thread.sleep(2000);
				getDriver().get(GlobalVariables.WCS8StaticUrls.BDStatic2);
				Thread.sleep(2000);
			}

			if (brand.equalsIgnoreCase("RY")) {
				getDriver().get(GlobalVariables.WCS8StaticUrls.RYStatic1);
				Thread.sleep(2000);
				getDriver().get(GlobalVariables.WCS8StaticUrls.RYStatic2);
				Thread.sleep(2000);
			}
		}
		getCurrentFunctionName(false);
	}

	/**
	 * Explicit wait
	 *
	 *
	 * @param waitTime
	 */
	public static void wait(int waitTime) {

		try {
			logs.debug(MessageFormat.format(LoggingMsg.WAIT_FOR_TIME, waitTime));
			Thread.sleep(waitTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Set test case status that will appear in the Automation Report
	 *
	 */
	public static void testPass() {
		logs.debug("Test Status: PASS");
		setTestStatus("Pass");

	}
	
	/**
	 * Set test case status that will appear in the Automation Report
	 *
	 */
	public static void testPass(String CaseDescription) {
		logCaseDetailds(CaseDescription);
		logs.debug("Test Status: PASS");
		setTestStatus("Pass");

	}

	public static void testSkipped(String CaseDescription) {
		logCaseDetailds(CaseDescription);
		logs.debug("Test Status: Skipped");
		setTestStatus("Skip");
		throw new SkipException("Test Skipped");

	}

	
	/**
	 * Set test case status that will appear in the Automation Report
	 *
	 *
	 */
	public static void testFail(Throwable t, String CaseDescription, String screenshotName) {
		logCaseDetailds(CaseDescription + "<br><b><font color='red'>Failure Reason: </font></b>"
				+ t.getMessage().replace("\n", "").trim());
		setTestCaseDescription(getTestCaseDescription());
		logs.debug(MessageFormat.format(LoggingMsg.DEBUGGING_TEXT, t.getMessage()));
		t.printStackTrace();

		logs.debug("Test Status: Failed");
		setTestStatus("Fail: " + t.getMessage());
		logs.debug(MessageFormat.format(LoggingMsg.CURRENT_URL, SelTestCase.getDriver().getCurrentUrl()));

		ReportUtil.takeScreenShot(getDriver(), screenshotName);
		Assert.fail(t.getMessage());
	}
	
	/**
	 * Set test case status that will appear in the Automation Report
	 *
	 *
	 */
	public static void testFail(Throwable t, String screenShotName) {
		logs.debug("Test Status: Failed");
		setTestStatus("Fail: " + t.getMessage());
		setScreenShotName(screenShotName + "_" + counter + ".jpg");
		ReportUtil.addError(getTestStatus(), getScreenShotName());
		logs.debug(MessageFormat.format(LoggingMsg.CURRENT_URL, SelTestCase.getDriver().getCurrentUrl()));
	}

	public static void testFailTemp(List<Exception> t, String screenShotName) {
		String temp = "";
		for (int i = 0; i < t.size(); i++) {

			temp = temp + "Error " + i + 1 + "----" + t.get(i).getMessage();
		}
		setTestStatus("Fail: " + temp);
		setScreenShotName(screenShotName + ".jpg");
		ReportUtil.addError(getTestStatus(), getScreenShotName());
	}

	/**
	 * Closes the opened browsers by selenium.
	 *
	 */
	public static void closeApplication() {
		if (getCONFIG().getProperty("debug").equalsIgnoreCase("no")) {
			ActionDriver.closeBrowser();
		}
	}

	public static void refreshBrowser() {

		ActionDriver.refreshBrowser();
	}

	public static void killDriverServerIfRunning() throws Exception {
		String line;
		String pidInfo = "";
		Process p = Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\" + "tasklist.exe");
		BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
		while ((line = input.readLine()) != null) {
			pidInfo += line;
		}
		input.close();
		if (getCONFIG().getProperty("browser").equalsIgnoreCase("chrome")) {
			if (pidInfo.contains("chromedriver.exe")) {
				Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
				logs.debug(MessageFormat.format(LoggingMsg.KILLING_PROCESS, "chromeDriver.exe"));
			} else {
				logs.debug(
						MessageFormat.format(LoggingMsg.NOT_RUNNING_PROCESS_ERROR_MSG, "chromeDriver.exe", "chrome"));
			}
		}

	}

	public static void captureScreen(String screenShotName) {
		try {
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Dimension screenSize = toolkit.getScreenSize();
			Rectangle screenRect = new Rectangle(screenSize);
			Robot robot = new Robot();
			BufferedImage image = robot.createScreenCapture(screenRect);
			ImageIO.write(image, "png", new File(screenShotName));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static LinkedHashMap<String, Object> readAddresses() throws Exception {
		/*
		 * output example [ { A1={ firstName=Accept, lastName=Tester, title=MR.,
		 * adddressLine=49FeatherstoneStreet, city=LONDON, postal=EC1Y8SY,
		 * countery=UNITEDKINGDOM }, A2={ firstName=Accept, lastName=Tester, title=MR.,
		 * adddressLine=ArdenhamCourt, city=LONDON, postal=HP193EQ,
		 * countery=UNITEDKINGDOM } } ]
		 */

		LinkedHashMap<String, Object> addresses = new LinkedHashMap<>();
		dataProviderUtils TDP = dataProviderUtils.getInstance();
		Object[][] data = TDP.getData(SheetVariables.addresses, 1);

		// data map
		int header = 0;
		int addresscode = 0;
		int firstName = 1;
		int lastName = 2;
		int title = 3;
		int addressLine = 4;
		int city = 5;
		int state = 6;
		int postal = 7;
		int countery = 8;
		int phone = 9;

		for (int row = 1; row < data.length; row++) {
			LinkedHashMap<String, Object> address = new LinkedHashMap<>();
			address.put((String) data[header][firstName], data[row][firstName]);
			address.put((String) data[header][lastName], data[row][lastName]);
			address.put((String) data[header][title], data[row][title]);
			address.put((String) data[header][addressLine], data[row][addressLine]);
			address.put((String) data[header][city], data[row][city]);
			address.put((String) data[header][state], data[row][state]);
			address.put((String) data[header][postal], data[row][postal]);
			address.put((String) data[header][countery], data[row][countery]);
			address.put((String) data[header][phone], data[row][phone]);

			addresses.put((String) data[row][addresscode], address);
		}
		logs.debug(Arrays.asList(addresses) + "");
		return addresses;
	}// readAddresses

	public static LinkedHashMap<String, Object> readLocalInventory() throws Exception {
		/*
		 * Output example [ { P1={
		 * url=/yacceleratorstorefront/en/Categories/Bags%2BBoardbags/Bags/Seizure-
		 * Satchel/p/300613490, color=black, size=SizeUni,�34.792 1, qty=1 }, P2={
		 * url=/yacceleratorstorefront/en/Categories/Bags%2BBoardbags/Bags/Seizure-Bag/p
		 * /300441924, color=claycourt, size=SizeUni, �24.26 4, qty=1 } } ]
		 */
		LinkedHashMap<String, Object> products = new LinkedHashMap<>();
		ArrayList<String> FGproducts = new ArrayList<String>();
		ArrayList<String> GRproducts = new ArrayList<String>();
		ArrayList<String> GHproducts = new ArrayList<String>();
		ArrayList<String> RYproducts = new ArrayList<String>();
		ArrayList<String> BDproducts = new ArrayList<String>();

		dataProviderUtils TDP = dataProviderUtils.getInstance();
		Object[][] data = TDP.getData(SheetVariables.products, 1);

		// data map
		int header = 0;
		int name = 0;
		int brand = 1;
		int url = 2;
		

		for (int row = 1; row < data.length; row++) {

			if (isFG() && brands.FG.equalsIgnoreCase((String) data[row][brand])) {
				FGproducts.add((String) data[row][url]);
			}
			else if (isGR()&& brands.GR.equalsIgnoreCase((String) data[row][brand])) {
				GRproducts.add((String) data[row][url]);
			}
			else if (isGH()&& brands.GH.equalsIgnoreCase((String) data[row][brand])) {
				GHproducts.add((String) data[row][url]);
			}
			else if (isRY()&& brands.RY.equalsIgnoreCase((String) data[row][brand])) {
				RYproducts.add((String) data[row][url]);
			}
			else if (isBD()&& brands.BD.equalsIgnoreCase((String) data[row][brand])) {
				BDproducts.add((String) data[row][url]);
			}
		}
		products.put(brands.FG, FGproducts);
		products.put(brands.GR, GRproducts);
		products.put(brands.GH, GHproducts);
		products.put(brands.RY, RYproducts);
		products.put(brands.BD, BDproducts);
		
		logs.debug("Products: " + Arrays.asList(products) + "");
		return products;
	}// readProducts

	public static LinkedHashMap<String, Object> readPaymentcards() throws Exception {
		/*
		 * [ { visa={ number=4111111111111111, name=AcceptTester, expireYear=2022,
		 * expireMonth=6, CVCC=333 }, master={ number=5555555555554444,
		 * name=Accept*Tester, expireYear=2022, expireMonth=6, CVCC=334 } } ]
		 */
		LinkedHashMap<String, Object> cards = new LinkedHashMap<>();

		dataProviderUtils TDP = dataProviderUtils.getInstance();
		Object[][] data = TDP.getData(SheetVariables.cards, 1);

		// data map
		int header = 0;
		int card = 0;
		int number = 1;
		int name = 2;
		int expireMonth = 3;
		int expireYear = 4;
		int CVCC = 5;

		for (int row = 1; row < data.length; row++) {
			LinkedHashMap<String, Object> cardOb = new LinkedHashMap<>();
			cardOb.put((String) data[header][number], data[row][number]);
			cardOb.put((String) data[header][name], data[row][name]);
			cardOb.put((String) data[header][expireMonth], data[row][expireMonth]);
			cardOb.put((String) data[header][expireYear], data[row][expireYear]);
			cardOb.put((String) data[header][CVCC], data[row][CVCC]);

			cards.put((String) data[row][card], cardOb);
		}
		logs.debug(Arrays.asList(cards) + "");
		return cards;
	}// read payments

	public static LinkedHashMap<String, Object> readTestparams(String testSheet, int caseIndex) throws Exception {
		/*
		 * [ { desc=loggedinuserwithsavedmaistropaymentandshippingaddress,
		 * proprties=loggedin, products=P2, shippingMethod=STANDARDDELIVERY,
		 * payment=maistro, shippingAddress=A1, billingAddress=A2, coupon=,
		 * email=ibatta@dbi.com, orderId=, orderTotal=, orderSubtotal=, orderTax=,
		 * orderShipping= } ]
		 */
		LinkedHashMap<String, Object> tests = new LinkedHashMap<>();
		dataProviderUtils TDP = dataProviderUtils.getInstance();
		Object[][] data = TDP.getData(testSheet, 1);

		// data map
		int header = 0;
		for (int row = 1; row < data.length; row++) {
			LinkedHashMap<String, String> params = new LinkedHashMap<>();
			for (int col = 1; col < data[0].length; col++) {
				params.put((String) data[header][col], (String) data[row][col]);
			} // for col
			tests.put(Integer.toString(row), params);
		} // for rows
		return tests;
	}// read test param

	public static LinkedHashMap<String, Object> readUsers() throws Exception {
		/*
		 * [ { ibatta@dbi.com={ name=U1, title=MR., username=ibatta, firstName=Accept,
		 * lastName=Tester, password=1234567, mail=ibatta@dbi.com } } ]
		 */
		LinkedHashMap<String, Object> users = new LinkedHashMap<>();

		dataProviderUtils TDP = dataProviderUtils.getInstance();
		Object[][] data = TDP.getData(SheetVariables.users, 1);

		// data map
		int header = 0;
		int name = 0;
		int title = 1;
		int userName = 2;
		int firstName = 3;
		int lastName = 4;
		int password = 5;
		int mail = 6;

		for (int row = 1; row < data.length; row++) {
			LinkedHashMap<String, Object> user = new LinkedHashMap<>();
			user.put((String) data[header][name], data[row][name]);
			user.put((String) data[header][title], data[row][title]);
			user.put((String) data[header][userName], data[row][userName]);
			user.put((String) data[header][firstName], data[row][firstName]);
			user.put((String) data[header][lastName], data[row][lastName]);
			user.put((String) data[header][password], data[row][password]);
			user.put((String) data[header][mail], data[row][mail]);

			users.put((String) data[row][name], user);
		}
		logs.debug(Arrays.asList(users) + "");
		return users;
	}// read users

	public static String[] readRunners() throws Exception {
		ArrayList<String> runners = new ArrayList<String>();

		dataProviderUtils TDP = dataProviderUtils.getInstance();
		Object[][] data = TDP.getData(SheetVariables.RunnersRegressionSheet);

		// data map
		int name = 0;

		logs.debug((String) data[0][name] + "");
		for (int row = 0; row < data.length; row++) {
			runners.add((String) data[row][name]);
		}
		return runners.toArray(new String[runners.size()]);
	}// read runners

	public static String[] readBrands() throws Exception {
		ArrayList<String> brands = new ArrayList<String>();

		dataProviderUtils TDP = dataProviderUtils.getInstance();
		Object[][] data = TDP.getData(SheetVariables.BrandsSheet);

		// data map
		int name = 0;

		logs.debug((String) data[0][name] + "");
		for (int row = 0; row < data.length; row++) {
			brands.add((String) data[row][name]);
		}
		return brands.toArray(new String[brands.size()]);
	}// read Brands

	public static String[] readEnvs() throws Exception {
		ArrayList<String> Envs = new ArrayList<String>();

		dataProviderUtils TDP = dataProviderUtils.getInstance();
		Object[][] data = TDP.getData(SheetVariables.EnvSheet);

		// data map
		int name = 0;

		logs.debug((String) data[0][name] + "");
		for (int row = 0; row < data.length; row++) {
			Envs.add((String) data[row][name]);
		}
		return Envs.toArray(new String[Envs.size()]);
	}// read envs

	public static String[] readBrowsers() throws Exception {

		ArrayList<String> browsers = new ArrayList<String>();

		dataProviderUtils TDP = dataProviderUtils.getInstance();
		Object[][] data = TDP.getData(SheetVariables.BrowsersListingSheet);

		// data map
		int name = 0;

		for (int row = 0; row < data.length; row++) {
			browsers.add((String) data[row][name]);
		}
		return browsers.toArray(new String[browsers.size()]);
	}// read browsers

	public static void takeScreenShot2() {
		ReportUtil.takeScreenShot(getDriver(), "common");
	}

}// class
