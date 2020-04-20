package com.generic.setup;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Random;
import com.generic.selector.PDPSelectors;
import com.generic.util.SelectorUtil;

public class PDPs extends SelTestCase {
	public static Random random = new Random();

	static String[] GHproducts = new String[] {};

	static String[] BDproducts = new String[] {};

	static String[] GRproducts = new String[] {};

	static String[] FGproducts = new String[] {};

	static String[] RYproducts = new String[] {};

	public static void navigateToRandomPDP(int maxTries) throws URISyntaxException, InterruptedException {
		getCurrentFunctionName(true);

		String productURL;
		maxTries--;
		
		ArrayList<String> brandProduct = (ArrayList<String>) products.get(getBrand());

		productURL = brandProduct.get(random.nextInt(brandProduct.size()-1));
	
		getDriver().get(new URI(getDriver().getCurrentUrl()).resolve(productURL).toString());

		Thread.sleep(2500);
		
		if((!checkifProductAvillable() || !checkifProductPuplished()) && maxTries>0) {
			navigateToRandomPDP(maxTries);
		}
		
		getCurrentFunctionName(false);

	}//Navigate Method

	
	//Overload to give 5 tries as default
	public static void navigateToRandomPDP() throws URISyntaxException, InterruptedException {
		navigateToRandomPDP(5);
	}

	
	//to check if teh product is available 
	public static boolean checkifProductAvillable() {
		getCurrentFunctionName(true);
		boolean state = true;
		try {
			if (SelectorUtil.isDisplayed(PDPSelectors.Unavilable_Product_Message.get()))
				state = false;

			getCurrentFunctionName(false);
			return state;
		} catch (Exception e) {
			getCurrentFunctionName(false);
			state = true;
			return state;
		}

	}// Check Method

	//To check if the product is puplished
	public static boolean checkifProductPuplished() {
		getCurrentFunctionName(true);
		boolean state = true;
		try {
			if (SelectorUtil.isDisplayed(PDPSelectors.UnPuplished_Product_Message.get()))
				state = false;

			getCurrentFunctionName(false);
			return state;
		} catch (Exception e) {
			getCurrentFunctionName(false);
			state = true;
			return state;
		}

	}// Check Method
	

}//Class
