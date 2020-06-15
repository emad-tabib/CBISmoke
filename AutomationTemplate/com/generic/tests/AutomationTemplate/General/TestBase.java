package com.generic.tests.AutomationTemplate.General;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.LinkedHashMap;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;
import com.generic.setup.Common;
import com.generic.setup.LoggingMsg;
import com.generic.setup.SelTestCase;
import com.generic.setup.SheetVariables;
import com.generic.util.SASLogger;
import com.generic.util.dataProviderUtils;

public class TestBase extends SelTestCase {

	// TODO [SAS]: change the sheet if needed to match the requested sheet
	// testDataSheet should be String initialized on SheetVariables class
	// Please note that name of sheet should be in xlsx file (data sheet) 
	public static final String testDataSheet = SheetVariables.cartSheet;

	private static XmlTest testObject;
	private static ThreadLocal<SASLogger> Testlogs = new ThreadLocal<SASLogger>();
	LinkedHashMap<String, String> productDetails;

	@BeforeClass
	public static void initialSetUp(XmlTest test) throws Exception {
		testCaseRepotId = SheetVariables.cartCaseId;
		Testlogs.set(new SASLogger(test.getName() + test.getIndex()));
		testObject = test;
	}

	@DataProvider(name = "DataProvider", parallel = true)
	public static Object[][] loadTestData() throws Exception {
		// concurrency maintenance on sheet reading
		getBrowserWait(testObject.getParameter("browserName"));
		dataProviderUtils TDP = dataProviderUtils.getInstance();
		Object[][] data = TDP.getData(testDataSheet);
		Testlogs.get().debug(Arrays.deepToString(data).replace("\n", "--"));
		return data;
	}

	@Test(dataProvider = "DataProvider")
	//TODO [SAS]: you need to rename class test name from GeneralBaseTest to anything related to your new test
	//TODO [SAS]: you need to modify the parameters provided to GeneralBaseTest based on number of columns in testDataSheet 
	public void GeneralBaseTest(String caseId, String runTest, String desc, String proprties) throws Exception {
		//TODO [SAS]: change the logger lead term from General to anything related to your test
		Testlogs.set(new SASLogger("General " + getBrowserName()));
		// Important to add this for logging/reporting
		setTestCaseReportName(SheetVariables.cartTestCaseId);
		Testlogs.get().debug("Case Browser: " + testObject.getParameter("browserName"));
		String CaseDescription = MessageFormat.format(LoggingMsg.TEST_CASE_DESC, testDataSheet + "." + caseId,
				this.getClass().getCanonicalName(), desc);
		initReportTime();

		try {
			// TODO [SAS]: add all test logic and steps into this function on TestValidation class,
			// logic should start here from Home page. 
			TestValidation.testValidationfunction();

			sassert().assertAll();

			Common.testPass(CaseDescription);
		} catch (Throwable t) {
			if ((getTestStatus() != null) && getTestStatus().equalsIgnoreCase("skip")) {
				throw new SkipException("Skipping this exception");
			} else {
				Common.testFail(t, CaseDescription, testDataSheet + "_" + caseId);
			}

		} // catch
	}// test
}
