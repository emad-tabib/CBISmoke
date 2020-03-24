package com.generic.selector;

import com.generic.setup.cselector;

public class PLPSelectors {

	//CBI
	public static final cselector SearchIcon = new cselector("css,#uNavTop button.searchboxAsButton", "css,.t-header__fades-in>button");
	public static final cselector RYSearchIcon = new cselector("css,.t-header__search-button>button");
	public static final cselector BDSearchIcon = new cselector("css,div.u-margin-left-sm:nth-child(2) > button");
 
	public static final cselector GHsearchClose = new cselector("css,button.pw-search__close");
	public static final cselector searchBox = new cselector("css,#searchBox input#headerBox","css,form>div>div>input");
	public static final cselector BDsearchBox = new cselector("css,#searchBox input#headerBox","css,form>div>div>input");
	public static final cselector recommendedOption =new cselector("css,li.unbxd-as-popular-product.unbxd-as-popular-product-grid .unbxd-as-popular-product-info","css,.c-arrange.u-flexbox.c--align-middle.u-align-center");

	public static final cselector BDrecommendedOption =new cselector("css,li.unbxd-as-popular-product.unbxd-as-popular-product-grid .unbxd-as-popular-product-info","css,li.unbxd-as-keysuggestion","css,.c-arrange.u-flexbox.c--align-middle.u-align-center");
	public static final cselector recommendedOptionRY =new cselector("css,.unbxd-as-popular-product-image-container","css,.pw-image");

	

	public static final cselector SearchButton =new cselector("css,li.unbxd-as-popular-product.unbxd-as-popular-product-grid a.unbxd-as-popular-product-info");
    public static final cselector product =  new cselector("css,div.gwt-product-info-panel-details-panel-html > h2 > a","css,div.pw-list-tile__content  a.c-product-item__main-image"); 
    public static final cselector productName =  new cselector("css,div.gwt-product-info-panel-details-panel-html > h2 > a","css,a.pw-link.c-product-item-title-link > div > div > h2 > div"); 
    public static final cselector productContainer =  new cselector("css,div.unbxd-products-display-panel","css,footer > div.c-custom-accordion"); 
    public static final cselector productsImages = new cselector("css,div.iwc-main-img-wrapper img.iwc-main-img", "css,article > a > div > div > img");
    public static final cselector productsImagesBD = new cselector("css,.unbxd-grid-product-image", "css,article > a > div > div > img");

    
    public static final cselector productsImagesGR = new cselector("css,.gwt-product-info-panel-image-container > a > img", "css,Article > a > div > div > img");
    public static final cselector productsNames = new cselector("css,a.gwt-sub-category-info-panel-link","css,a.pw-link.c-product-item-title-link > div > div > h2 > div > div");

    public static final cselector GHproductsImages = new cselector("css,.gwt-product-info-panel-image-container>a>.unbxd-grid-product-image", "css,.c-product-item-img");
    public static final cselector productsImagesGH = new cselector("css,.gwt-product-info-panel-image-container > a > img","css,article > a > div > div > img");
    public static final cselector BDproductTitle = new cselector("css,h2 > a.gwt-sub-category-info-panel-link");

    public static final cselector PriceLowToHigh = new cselector("Price: Low to High","css,#unbxd_normal_sort_price-asc > div");
    public static final cselector PriceLowToHighGH = new cselector("Price: Low to High","css,#unbxd_normal_sort_price-asc");
    public static final cselector PriceLowToHighRYMobile = new cselector("css,","css,.m-product-sort-modal  .pw-button__inner");
    public static final cselector PriceLowToHighRYDesktop = new cselector("css,.unbxd-sort-by-option-anchor","css,");

    

    
    
    public static final cselector PriceHighToLow = new cselector("Price: High to Low","css,#unbxd_normal_sort_price-desc > div");
    public static final cselector ProductNameGH = new cselector("Product Name","css,#title-asc");
    public static final cselector ProductNameRY = new cselector("css,.unbxd-sort-by-option-anchor","css,.m-product-sort-modal .pw-button__inner");

    public static final cselector PriceLowToHighPLP = new cselector("Price: Low to High","css,#unbxd_prime_sort_price-asc > div");
    public static final cselector PriceLowToHighPLP2 = new cselector("Price: Low to High","css,#unbxd_liquidation_sort_price-asc");
    public static final cselector PriceLowToHighPLPGH = new cselector("Price: Low to High","css,#unbxd_prime_sort_price-asc");
    public static final cselector PriceLowToHighPLPGHUNBXD = new cselector("Price: Low to High","css,#unbxd_liquidation_sort_price-asc");
    public static final cselector sortingOptionBD = new cselector("css,.unbxd-sort-by-option-anchor","css,.t-product-list__sort-filters-options> .c-product-list__container-sort-option > div > div > div > select > option");

    
        
    public static final cselector PriceHighToLowPLP = new cselector("Price: High to Low","css,#unbxd_prime_sort_price-desc > div");
    public static final cselector PriceHighToLowPLP2 = new cselector("Price: High to Low","css,#unbxd_liquidation_sort_price-desc");

    public static final cselector FilterContainer = new cselector("css,div.text-facets-container-panel div.unbxd-all-options-container span.gwt-InlineLabel.selected-option-span","css,div.c-product-list__container-filter-option.u-flex-1.u-margin-end > div > button > div");
    public static final cselector FilterContainerBD = new cselector("css,div.text-facets-container-panel div.unbxd-all-options-container span.gwt-InlineLabel.selected-option-span","css,.c-product-list__container-filter-option button");

    public static final cselector FilterContainerGHRY = new cselector("css,#text-facets-container-panel .selected-option-span","css,.c-product-list__filters-filter-button");
    public static final cselector FilterContainerGHRYDesktop = new cselector("css,.unbxd-facet-option-checkbox input","css,");

    
    public static final cselector FilterContainerContents =  new cselector("css,div.unbxd-facet-option.text-facet span.unbxd-facet-option-checkbox input","css,.u-color-neutral-70.u-text-uppercase.u-text-align-center.u-letter-spacing-3");
    public static final cselector FilterContainerContentsGH =  new cselector("css,","css,.pw-sheet__content .pw-accordion__close-icon");

   
    public static final cselector mobileSortingMenu = new cselector("","css,.c-product-list__filters-sort-button");
    public static final cselector SortingMenuRY = new cselector("css,.unbxd-sort-options-container .selected-option-span","css,.c-product-list__filters-sort-button");
    public static final cselector SortingMenuBD = new cselector("css,.unbxd-sort-options-container .selected-option-span","css,.c-product-list__sort-select-container");

    
	public static final cselector allCatigories = new cselector("","css,div.c-custom-accordion__list-of-items-item>div>div>div>input");
	public static final cselector clearanceGH = new cselector("css,.unbxd-facet-option-checkbox input","css,#Clearance");
	public static final cselector colorFilterGH = new cselector("css,.unbxd-facet-option-checkbox > input","css,.pw-field__inner input");
	
	public static final cselector firstFilterRY = new cselector("css,.unbxd-all-options-container.expanded input","css,.m-product-list__filter-container .m-product-list__filter-items .pw-button");
	public static final cselector firstFilterBD = new cselector("css,.unbxd-facet-option-checkbox > input","css,.c-custom-accordion__list-of-items-item input");
	public static final cselector doneButtonRY = new cselector("css,","css,.m-product-list__filter-buttons-container > button");

	public static final cselector allCatigories2 = new cselector("","css,.pw-accordion__content .pw-link");	
	public static final cselector filterPrice = new cselector("","css,.c-price-range__max-price input");	

	
	
	public static final cselector BDMobileSorting = new cselector("css,select.c-select-options__select");
	public static final cselector GRMobileSorting = new cselector("css,.c-product-list__container-sort-option.u-flex-1 > div > div > div > select");
	public static final cselector GRDeskTopSorting = new cselector("css,.unbxd-all-sort-options .selected-option-span");
	public static final cselector GRDeskTopSortingLowtoHIgh = new cselector("css,#unbxd-sort-options-container > div > div > a:nth-child(2)");
	public static final cselector GRDeskTopSortingHighToLow = new cselector("css,#unbxd-sort-options-container > div > div > a:nth-child(3)");
	public static final cselector BDDeskTopSortingCustomerRating = new cselector("css,#unbxd-sort-options-container > div > div > a:nth-child(4)");
	public static final cselector BDDeskTopSortingLowToHigh = new cselector("css,#unbxd-sort-options-container > div > div > a:nth-child(3)");


	public static final cselector GRFilterContainer = new cselector("css,#text-facets-container-panel > div:nth-child(1) > span","css,div.pw-accordion__close-icon");
	public static final cselector BDFilterContainer = new cselector("css,#text-facets-container-panel > div:nth-child(1) > span","css,button.c-product-list__filter-button");
	public static final cselector GRFilterContainerContents = new cselector("css,.unbxd-facet-option-checkbox input","css,.u-text-letter-spacing-0 > div");
	public static final cselector BDFilterContainerContents = new cselector("css,.unbxd-facet-option-checkbox input","css,div.c-custom-sheet__content.u-height-full.u-border-top  div > div.pw-accordion__icon > div.pw-accordion__open-icon");
	public static final cselector GRallCatigories = new cselector("","css,.pw-field__label-wrap.pw--end > label > div > div > div");

	//Random PLP
	public static final cselector desktopMenuItem = new cselector("css,a.gwt-MenuItem");
	public static final cselector PLPIdentifier = new cselector("css,.product-details-main-container","css,.c-product-item__price");

	public static final cselector navigatetoPLP = new cselector(
			"css,#mainContent > div.container.no-padding.grid-subcategories > div > div:nth-child(1) > div > a > img",
			"css,#mainContent > div.container.no-padding.grid-subcategories > div > div:nth-child(1) > div > a > img",
			"css,#app-main > div > div:nth-child(1) > div.u-flexbox.u-direction-row.u-flex-wrap > div:nth-child(1) > a > div.c-lazy-image.u-width-full > div > img");

	
	public static final cselector navigatetoPLPBD = new cselector(
			"css,div.gwt-product-image-horizontal-panel > a",
			"css,.gwt-sub-category-image",
			"css,.t-category-list__category a > img" );

	public static final cselector navigatetoPLP2 = new cselector(
			"css,#mainContent > div.genericESpot > div.container.no-padding.grid-subcategories > div > div:nth-child(1) > div > a > img",
			"css,#mainContent > div.genericESpot > div.container.no-padding.grid-subcategories > div > div:nth-child(1) > div > a > img",
			"css,#app-main > div > div:nth-child(1) > div.u-flexbox.u-direction-row.u-flex-wrap > div:nth-child(1) > a > div.c-lazy-image.u-width-full > div > img");

	public static final cselector navigatetoPLPGR = new cselector(
			"css,#mainContent > div.container.no-padding.grid-subcategories > div > div:nth-child(1) > div > a > img",
			"css,#mainContent > div.container.no-padding.grid-subcategories > div > div:nth-child(1) > div > a > img",
			"css,#app-main > div > div:nth-child(3) > div:nth-child(1) > a > div.c-lazy-image.u-width-full > div > img");
	
	public static final cselector navigatetoPLPGH = new cselector(
			"css,.gwt-sub-category-image",
			"css,.gwt-sub-category-image",
			"css,.c-lazy-image.u-width-full > div > img");
	
	public static final cselector navigatetoPLP2GR = new cselector(
			"css,#mainContent > div.genericESpot > div.container.no-padding.grid-subcategories > div > div:nth-child(1) > div > a > img",
			"css,#mainContent > div.genericESpot > div.container.no-padding.grid-subcategories > div > div:nth-child(1) > div > a > img",
			"css,#app-main > div > div:nth-child(1) > div.u-flexbox.u-direction-row.u-flex-wrap > div:nth-child(1) > a > div.c-lazy-image.u-width-full > div > img");
	
	public static final cselector GHRecommendedOption =new cselector("css,.unbxd-as-popular-product-info","css,.c--align-middle a.pw-link.c-arrange.u-flexbox.c--align-middle.u-align-center", "css,div.pw-sheet__wrapper > div > div.pw-sheet__content > div > div > div:nth-child(2) > ul div > a");
	public static final cselector GHSearchButton = new cselector("css,#searchButton");
	public static final cselector PLPPageSelector = new cselector("css,.view-UnbxdBodyView");
}
