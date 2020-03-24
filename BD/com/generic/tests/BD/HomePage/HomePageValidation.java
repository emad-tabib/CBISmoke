package com.generic.tests.BD.HomePage;

import com.generic.page.HomePage;
import com.generic.setup.Common;
import com.generic.setup.SelTestCase;

public class HomePageValidation extends SelTestCase {

	public static void validateSearch() throws Exception {
		String searchHint = "Keyword/Item #";
		if(isMobile()) {
			Common.refreshBrowser();
			searchHint = "Start typing a keyword or item #";
		}
		HomePage.searchIconClick();
		sassert().assertTrue(HomePage.validateSearchIconFieldOpend(),
				"Search icon field opened validation has some problems");
		sassert().assertTrue(HomePage.validateSearchFieldPlaceHolderText(searchHint),
				"Search field place holder validation has some problems");
		if(isMobile()) {
		HomePage.searchIconExitClick();
		sassert().assertTrue(HomePage.validateSearchIconFieldClosed(),
				"Search icon field closed validation has some problems");
		}
	}

	public static void validateCaroselAndEspot() throws Exception {
		if(isMobile())
			Common.refreshBrowser();
		sassert().assertTrue(HomePage.isDisplayedModuleHeroImg(),
				"Search module mero Image displayed validation has some problems");
		sassert().assertTrue(HomePage.isLoadedModuleHeroImg(),
				"Search module mero Image loaded validation has some problems");

		sassert().assertTrue(HomePage.isDisplayAllSpots(), "Home page Espots display validation has some problems");
		sassert().assertTrue(HomePage.isLoadedAllEspots(), "Home page Espots loaded validation has some problems");

		sassert().assertTrue(HomePage.isDisplayedAllCarouselContent(),
				"Home page carousal display validation has some problems");
		sassert().assertTrue(HomePage.isLoadedAllCarouselContent(),
				"Home page carousal loaded validation has some problems");

	}

}
