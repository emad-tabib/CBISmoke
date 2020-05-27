package com.generic.setup;

import java.text.MessageFormat;
import java.util.ArrayList;

import com.generic.setup.SelTestCase;

public class GlobalVariables extends SelTestCase {

	public class browsers {
		public static final String firefox = "Firefox";
		public static final String chrome = "Chrome";
		public static final String Nexus = "mobile_Nexus 5";
		public static final String iPhone = "mobile_iPhone X";
		public static final String iPad = "mobile_iPad";
		public static final String IE = "IE";
		public static final String edge = "edge";
		public static final String iOS = "IOS_grid";
		
	}

	public class randomPLP {
	public static final String FG = "/indoor-decor/indoor-area-rugs/?";
	public static final String GR = "/indoor-decor/indoor-lighting/?";
	public static final String GH = "/womens-fashion/tops-tees/";
	public static final String RY = "/store/plus-size-dresses/?";
	public static final String BD = "/lighting/all-lighting/?";

}

public class WCS8StaticUrls {
	public static final String FGStatic1 = "https://static1.frontgate.com/wcsstore/CornerStoneBrands/css-gen/brands/10053/main.css";
	public static final String FGStatic2 = "https://static2.frontgate.com/wcsstore/CornerStoneBrands/css-gen/brands/10053/main.css";
	public static final String GRStatic1 = "https://static1.grandinroad.com/wcsstore/CornerStoneBrands/css-gen/brands/11103/main.css";
	public static final String GRStatic2 = "https://static2.grandinroad.com/wcsstore/CornerStoneBrands/css-gen/brands/11103/main.css";
	public static final String GHStatic1 = "https://static1.garnethill.com/wcsstore/CornerStoneBrands/css-gen/brands/10054/main.css";
	public static final String GHStatic2 = "https://static2.garnethill.com/wcsstore/CornerStoneBrands/css-gen/brands/10054/main.css";
	public static final String BDStatic1 = "https://static1.ballarddesigns.com/wcsstore/CornerStoneBrands/css-gen/brands/10052/main.css";
	public static final String BDStatic2 = "https://static2.ballarddesigns.com/wcsstore/CornerStoneBrands/css-gen/brands/10052/main.css";
	public static final String RYStatic1 = "https://static1.ryllace.com/wcsstore/CornerStoneBrands/css-gen/brands/10060/main.css";
	public static final String RYStatic2 = "https://static2.ryllace.com/wcsstore/CornerStoneBrands/css-gen/brands/10060/main.css";

}

// Iframe ID for CVV Filed in chekout
public static final String CVV_Iframe_ID = "cvv_Tokenizer";

	// Indexes for tax value
	public static final int GR_TAX_CART = 0;
	public static final int GR_TAX_CART_MOBILE = 0;
	public static final int GR_TAX_CONFIRMATION = 0;

	public static final int FG_TAX_CART = 0;
	public static final int FG_TAX_CONFIRMATION = 0;

	/*
	 * public String firstName; public String lastName; public String emailAddress;
	 * public String confEmailAddress; public String zipCode; public String country;
	 * public String password; public String confPassword;
	 */

	public ArrayList<String> list;

	public static boolean flag = false;

	public GlobalVariables(String sheetName, int row) {
		getCurrentFunctionName(true);
		logs.debug(MessageFormat.format(LoggingMsg.READING_DATA_FROM_SHEET, sheetName, row));
		SelTestCase.getCurrentFunctionName(false);

	}

}
