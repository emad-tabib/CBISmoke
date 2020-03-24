package com.generic.selector;

import com.generic.setup.cselector;

public class HomePageSelectors
{
  	public static final cselector accountMenu = new cselector ("css,.gwt-MenuItem > a#accountMenu","css,#pwa-shop-nav-button > button > div");																									    
	// adding this
  	public static final cselector accountMenuBD = new cselector ("css,#myAccount > a","css,#pwa-my-account-button > button > div");
  	public static final cselector accountMenuItems = new cselector ("css,.gwt-MenuItem > div > a","css,div.pw-list-tile > a"); 	
  	// adding this
  	public static final cselector accountMenuItemsBD = new cselector ("css,div.topline > div.right > div > a","css,.my-account-controls-modal_class > div > div");
  	public static final cselector navIcon = new cselector("css,.nav-toggle", "css,div#pwa-shop-nav-button .pw-button");
  	// adding this
	public static final cselector BDcloseAccountMenu = new cselector("css,.nav-toggle","css,div.pw-header-bar__actions > button .c-custom-sheet__header-close-icon");

	public static final cselector navIconBD = new cselector("css,.nav-toggle", "css,div#pwa-shop-nav-button .pw-button", "css,div#pwa-shop-nav-button .pw-button");
	public static final cselector countrySelector = new cselector("css,#gwt_country_changer", "css,button.t-footer__selected-country");
	// adding this
	public static final cselector countrySelectorBD = new cselector("css,#gwt_country_changer","css,#app-footer > footer > div.u-bg-color-neutral-00.u-margin-top-lg.u-margin-bottom-lg.u-padding-start-lg.u-padding-end-lg > div > button");
	// adding this
	public static final cselector accordionHeaderBD =  new cselector("css,#footer > div.line2 > div.footerLinks > div.section.footer-links-list > div > div.header","css,div.pw-accordion > div.pw-accordion__item");
	public static final cselector accordionHeader =  new cselector("css,div.footerInner > div > div > div > h3","css,div.pw-accordion > div.pw-accordion__item"); 
	// adding this
	public static final cselector globalFooterBD = new cselector("css,#footer > div.line2 > div.footerLinks > div.section.footer-links-list","css,footer > div.c-custom-accordion");
	public static final cselector globalFooter =  new cselector("css,div.footerInner","css,footer > div.c-custom-accordion"); 
	// adding this
	public static final cselector YMALCarousels = new cselector("body gray-disabled-arrows" ,"css,#gwt_recommendations_home_1 > div > div > div > div.body > div > div","css,#home_rr_PWA > div > div > div > div > div > div");
	// adding this
	public static final cselector YMALCarouselsBD = new cselector("css,#crl8-homepage-carousel > div > div > div > div > div:nth-child(2) > div > div:nth-child(1) > div > div.sc-1pao5yo-0.cQIUaE > div");
	public static final cselector logo = new cselector("css,#logo1 a.logo-anchor","css,.t-header__logo");
	public static final cselector RYaccountMenu = new cselector ("css,.gwt-MenuItem > a#accountMenu","css,div.m-accordion-navigation__content-my-account");
	public static final cselector shopMenuRY = new cselector("css,.gwt-MenuItem a", "css,.t-header__menu-button .pw-button");
	public static final cselector expandShopMenuRY = new cselector("css,.pw-accordion__inner-header .pw-accordion__icon");
	public static final cselector menuItemsRY = new cselector("css,.subcat-level-1","css,.container .gwt-MenuItem a" ,"css,.pw-accordion__content .pw-list-tile__content"); 
	public static final cselector GHaccordionHeader =  new cselector("css,div.footer-container li.list-title","css,div.pw-accordion > div.pw-accordion__item");
	public static final cselector GHglobalFooter =  new cselector("css,div.footer-container","css,footer > div.c-custom-accordion"); 
	public static final cselector GHlogo = new cselector("css,#logoGH > a","t-header__logo");
	public static final cselector RYLogoLinkMobile = new cselector("css,","css,.t-header__logo .pw-header-bar__title a");

	
	public static final cselector miniCartBtn = new cselector("css,#gwt_minicart_div>table>tbody>tr>td>div","css,#cartAnchor","css,.pw-header-bar__actions.t-header-bar__cart > button");
	public static final cselector miniCartText = new cselector("css,.empty-cart-sign-in-container > .gwt-HTML.inst-copy","css,.m-mini-cart__empty-content.u-text-align-center>h2");
	// adding this
	public static final cselector miniCartTextBD = new cselector("css,.empty-cart-sign-in-container > .gwt-HTML.inst-copy","css,#pw-sheet-0 > div.pw-sheet__wrapper > div > div.pw-sheet__content > div > div > div > div");
	public static final cselector miniCartClose = new cselector("css,button.pw-button.c-icon-label-button");
	public static final cselector miniCartCloseFG = new cselector("css,button.pw-button.c-icon-label-button","css,button.pw-button");
	//#pwa-shop-nav-button
	// adding this
	public static final cselector miniCartCloseBD = new cselector("css,button.pw-button.c-icon-label-button");
	public static final cselector miniCartProductContainer = new cselector("css,.mini-cart-items-container","css,.m-mini-cart__content-products");
	public static final cselector GHminiCartText = new cselector("css,.empty-cart-sign-in-container > .gwt-HTML.inst-copy","css,.m-mini-cart__empty-content.u-text-align-center div.m-mini-cart__empty-header");
	public static final cselector GHminiCartClose = new cselector("css,#headerBox > div.t-header__bar > div > div:nth-child(1) > div.pw-header-bar__actions.t-header-bar__cart.u-margin-end-6");
	public static final cselector RYminiCartText = new cselector("css,.empty-cart-sign-in-container > .gwt-HTML.inst-copy","css, div.cart-empty-text");
	public static final cselector RYminiCartProductContainer = new cselector("css,mini-cart-items-container","css,div.pw-list.items-container");
	public static final cselector miniCartCheckoutBtn = new cselector("css,.mini-cart-product-panel-btn","pw-button pw--primary u-width-full");		
	public static final cselector RYminiCartCheckoutBtn = new cselector("css,.mini-cart-product-panel-btn","css,div.c-checkout-buttons__checkout > button");		
	public static final cselector searchIconOpenRY = new cselector("","css,div.t-header__search-button > button");
	public static final cselector searchIconOpen = new cselector("css,#uNavTop >.searchboxAsButton","css,div#searchBox","css,.t-header__search");
	public static final cselector searchIconClose = new cselector("css,#search-popup > .search-popup-close-icon","css,.left-container>.leftSideNav>button","css,.c-search-action  > div> button.pw-button");
	public static final cselector searchIconField = new cselector("css,#searchBox>#headerBox","css,#search-0");
	// adding this
	public static final cselector BDsearchIconField = new cselector("css,#pw-sheet-4 > div.pw-sheet__wrapper > div > div.pw-sheet__content > div > div > div.u-flexbox.u-justify-between.u-padding-lg.u-bg-color-neutral-10 > div > div.pw-search__inner > form > div > div.pw-search__field");
	public static final String moduleHeroImg = "css,#homepage-head div.row div.genericESpot div.module-hero div.col-xs-12 div.wrapper a img.img.img-responsive";
	// adding this
	public static final String moduleHeroImgBD = "css,#main-link > img";
	// adding this
	public static final String moduleHeroImgBDforMobile = "css,#main-link > img";
	public static final cselector carusals =new cselector( "css,.tilePanel>div>div>a>img","css,.genericESpot>div>div>div>.pw-scroller>div>.pw-scroller__content>.pw-scroller__item>article>a>div>div>div>div>div img");
	// adding this
	public static final cselector carusalsBD =new cselector( "css,#module6 > div > div.row.gutter-4.masonry-blocks");
	public static final cselector espots = new cselector("css,.genericESpot>div>div>div>a>img","css,.pw-responsive-html>div>#mainContent>div>div>div>.genericESpot>div>.col-xs-12>div>a>img");
	//adding this
	
	//public static final cselector espotsBD = new cselector("css,.genericESpot>div>div>div>a>img","css,.pw-responsive-html>div>#mainContent>div>div>div>.genericESpot>div>.col-xs-12>div>a>img","css,#module1 > div:nth-child(2) > div > a > img");

	public static final cselector espotsBD = new cselector("css,.genericESpot>div>div>div>a>img","css,div.container-fluid > div > div > a  img");
	public static final cselector GHespots = new cselector("css,div.genericESpot section>div>div>div>a>img","css,div.responsive-content > div > div > #mobify-homepage > div > a");
	public static final cselector RYespots = new cselector("css,div.genericESpot section>div>div>div>a>img","css,div.container-fluid > div > div.col-sm-12 > a > img");
	public static final String HomePageSearchbutton = "toggle-mobile-menu";
	//public static final cselector miniCartMobd = new cselector("css,#cartAnchor","css,.pw-header-bar__actions.t-header-bar__cart > button");
	public static final cselector mainHomeCarousels = new cselector("body gray-disabled-arrows","css,#gwt_recommendations_home_1 > div > div > div > div.body","css,#home_rr_PWA > div > div > div");
	public static final String header = "header-container";
	public static final String body_topNavLinks = "css,#main-navigation-large>.container>.nav-links";
	public static final String body_categorySlider = "page-section category-slider";
	public static final String body_valuepropPromo = "four-desc page-section ocm-valueprop-promo";
	public static final String body_navTabsContainer = "nav-tabs-container";
	public static final String body = "homepage-value-packs";
	public static final String footerBottomSection = "footer-bottom-section";
	public static final String footerTopSection = "footer-top-section";
	public static final String footerLogo = "footer-ocm-logo";
	public static final String footerEmailSignUp = "footer-email-sign-up";
	// Header navigation menu selectors.
	public static final cselector navigationIcon = new cselector("css,.nav-toggle", "css,.t-header__menu-icon .pw-button");
	public static final cselector menuItems = new cselector("css,#css-top-navigation #flyout>.menuItem>a","css,#gwt-top-navigation .active>.gwt-nav-item-has-submenu>.gwt-HTML", "css,.navigation-modal_class .pw-link");
	public static final cselector menuItemsBD = new cselector("css,#css-top-navigation #flyout>.menuItem>a", "css,.pw-nav-menu__panel .pw-list-tile a");
	// adding this
	public static final cselector menuItemsBDforMobile = new cselector("css,.navigation-modal__class .pw-link");
	// adding this
	public static final cselector menuItemsBDforiPad = new cselector("css,#gwt-uid-11");
	public static final cselector menuItemsGH = new cselector("css,#css-top-navigation #flyout>.menuItem>a","css,.nav .dropdown >a", "css,.pw-accordion__icon");
	public static final cselector selectedMenuHeader = new cselector("", "css,#gwt-top-navigation .active>.gwt-nav-item-has-submenu.opened>.gwt-HTML", "css,.m-navigation__fades-in .pw-header-bar .c-sheet__title");

	// adding this
	public static final cselector selectedMenuHeaderBD = new cselector("", "css,#gwt-top-navigation .active>.gwt-nav-item-has-submenu.opened>.gwt-HTML","css,.pw-list-tile .pw-button");
	public static final cselector GHnavigationIcon = new cselector("css,#pwa-shop-nav-button > button");
	public static final cselector RYmenuItems = new cselector("css,#css-top-navigation #flyout>.menuItem>a", "css,.m-accordion-navigation__content  div.pw-accordion__item > button");
	public static final cselector GHmenuItems = new cselector("css,#navbar-collapse-grid > ul > li > a", "css,.m-accordion-navigation__content  div.pw-accordion__item > button");
	public static final cselector BDmenuItems = new cselector("css,.gwt-MenuItem a","css,.navigation-modal__class .pw-link");
	public static final cselector GHselectedMenuHeader = new cselector("", "css,div.m-accordion-navigation__content  div.pw-accordion__item > button[aria-selected=\"true\"]");
	public static final cselector leafMenuItems = new cselector("", "css,.active-menu-item>:not(.gwt-nav-item-has-submenu)", "css,.navigation-modal_class .pw-list-tile:not(.pw--has-child) .pw-link");
	// adding this
	public static final cselector leafMenuItemsBD = new cselector("", "css,.active-menu-item>:not(.gwt-nav-item-has-submenu)", "css,.navigation-modal__class .pw-list-tile a");
	public static final String sideBoxHeader = "css,#sideBoxHeader";

	// Sign in selectors.
	public static final cselector signInNavigation = new cselector("css,#login a","css,.my-account-controls-modal_class .pw-link");
	public static final cselector signInEmailInput = new cselector("css,[name=logonId]", "css,[name=logonId].c-custom-input");
	public static final cselector signInEmailPasswordInput = new cselector("css,[name=logonPassword]", "css,[name=logonPassword].c-custom-input");
	public static final cselector signInButton = new cselector("css,#logonButton", "css, .t-login__submit-button .pw-button");
	public static final cselector welcomeMessage = new cselector("css,#welcome");
	public static final cselector accountMenuIcon = new cselector("css,#gwt_dropdownmenu_my_account", "css,.t-header__my-account");
	public static final String accountMenuList = "css,.my-account-controls-modal_class .pw-link";
	public static final cselector BDsearchIconOpen = new cselector("css,div#searchBox","css,div:nth-child(2)> button.pw-button");

    public static final cselector product =  new cselector("css,div.unbxd-products-dispaly-container > div > div > div > a","css,footer > div.c-custom-accordion"); 
    public static final cselector productContainer =  new cselector("css,div.unbxd-products-display-panel","css,footer > div.c-custom-accordion"); 
}
