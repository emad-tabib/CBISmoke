package com.generic.selector;

import com.generic.setup.cselector;

public class GiftRegistrySelectors {
	public static final cselector GH_GRLink=new cselector("css,.col-links2 > li:nth-child(4) > a");
	public static final cselector GHSaveToGR = new cselector("css,.gwt-product-detail-buttons-container:nth-child(2) > button","css,.gwt-bundle-add-to-gift-registry-btn #gwt-add-to-gift-registry-btn", "css,.u-margin-end-md > button");
	public static final cselector GHAddGRProductToCart = new cselector("css,.options >div> a", "css,.t-registry-list-product-list__add-to-cart-btn.pw-button");

	public static final cselector GHHomePageMenueToGR = new cselector("css,div:nth-child(1)>.pw-accordion__header");
	public static final cselector GHGifRegistryLink = new cselector("css,div:nth-child(3)>.pw-list-tile>.pw-link");

	public static final cselector GHEmailInput = new cselector("css,[type=email].c-custom-input");
	public static final cselector GHPasswordInput = new cselector("css,[type=password].c-custom-input");
	public static final cselector GHLoginBtn = new cselector("css,.t-login__submit-button>.pw-button");

	public static final cselector GHViewRegistryButton = new cselector("css,.gwt-added-to-gift-registry-modal .primary", "css,.m-add-to-registry .pw--primary");

	public static final cselector GHChechoutBtn = new cselector("css,.pw-button.pw--primary");
	public static final cselector GHCreateRegistryButton = new cselector("css,[onclick*=submitCreateRegistyLogon]","css,#giftRegistryFormsNew #newRegistry a");
	
	
	
	
	public static final cselector GRLink = new cselector("css,#giftregistry a");
	public static final cselector GRLinkforBD = new cselector("css,#sideBox > ul > li:nth-child(4) > ul > li:nth-child(1) > a","css,#app-main > div > div:nth-child(2) > ul > li:nth-child(3) > ul > li:nth-child(1) > a");
	public static final cselector FGCreateRegistryButton = new cselector("css,.create-registry","css,.responsive-content .create-registry");
	//public static final cselector GRCreateRegistryButton = new cselector("css,[onclick*=submitCreateRegisty]","css,.responsive-content [onclick*=submitCreateRegisty]");
	//div > div > div > ul > li:nth-child(1) > div > a
	public static final cselector GRCreateRegistryButton = new cselector("css,[onclick*=submitCreateRegisty]","css,div > div > div > ul > li:nth-child(1) > div > a");
	public static final cselector BDCreateRegistryButton = new cselector("css,#mainContent > div.data > div > div.hidden-xs > div > div.row.registry-items > div > div > div.row-registry-buttons > a:nth-child(2)","css,#app-main > div > div.u-margin-bottom > div > div > div > div > div.hidden-sm.hidden-md.hidden-lg.text-center > div.u-margin-bottom-hg.u-padding-all-lg > div:nth-child(1) > a");
	
	// Gift registry step one.
	public static final cselector eventType = new cselector("css,#event_type_id","css,.t-gift-registry-information #event_type_id");
	public static final cselector eventDay = new cselector("css,#gr_event_day","css,.t-gift-registry-information__event-date select");
	public static final cselector eventYear = new cselector("css,#gr_event_year","css,.t-gift-registry-information__event-date select");
	public static final cselector eventMonth = new cselector("css,#gr_event_month","css,.t-gift-registry-information__event-date select");
	public static final cselector registryName = new cselector("css,#gr_reg_name","css,.t-gift-registry-information #gr_reg_name");
	public static final cselector confirmInformtionButton = new cselector("css,.gwt-gr-create-next-button","css,.t-gift-registry__next");
	public static final cselector stepOneContainer = new cselector("css,.GR_create_progressBar_Step1","css,.t-create-gift-registry-step-one");

	// Contact Information (Gift registry step two).
	public static final cselector firstNameGR = new cselector("css,#registrant_fnbox","css,.t-registrant-information #registrant_fnbox");
	public static final cselector lastNameGR = new cselector("css,#registrant_lnbox","css,.t-registrant-information #registrant_lnbox");
	public static final cselector emailAddressGR = new cselector("css,#registrant_emailbox","css,.t-registrant-information #registrant_emailbox");
	public static final cselector streetAddressGR = new cselector("css,#registrant_sa1box","css,.t-registrant-information #registrant_sa1box");
	public static final cselector cityAddressGR = new cselector("css,#registrant_citybox","css,.t-registrant-information #registrant_citybox");
	public static final cselector regionAddressGR = new cselector("css,#registrant_region","css,.t-registrant-information #registrant_region");
	public static final cselector zipCodeGR = new cselector("css,#registrant_zipbox","css,.t-registrant-information #registrant_zipbox");
	public static final cselector phoneGR = new cselector("css,#registrant_phone1box","css,.t-registrant-information #registrant_phone1box");
	public static final cselector createRegistryButtonStepTwo = new cselector("css,.GR_create_buttons_step3 .primary", "css,.t-gift-registry__next");
	public static final cselector stepTwoContainer = new cselector("css,.GR_create_progressBar_Step2","css,.t-create-gift-registry-step-two");

	// Manage gift registry Modal.
	public static final cselector confirmationModalGR = new cselector("css,.gwt-gift-registry-create-confirmation-dialog","css,.m-confirmation_box_modal");
	public static final cselector manageRegistryButton = new cselector("css,.gwt-gift-registry-create-confirmation-dialog .okCancelPanel .secondary","css,.m-confirmation_box_modal .pw--secondary");
	public static final cselector manageRegisrtyButtonBD = new cselector("css,.gwt-gift-registry-create-confirmation-dialog .okCancelPanel .secondary","css,div.pw-sheet__wrapper > div > div.pw-sheet__content > div > div > div.u-flexbox.u-direction-row-reverse.u-padding-top-md.confirmation-dialog-box__buttons-container > button.pw-button.pw--secondary.u-width-full.u-margin-end");
	// Manage gift registry page.
	public static final cselector manageGRContainer = new cselector("css,.manage-registry-page","css,.t-manage-gift-registry");																			    
	public static final cselector registryInfo = new cselector("css,#descriptionGR","css,.t-registry-select-list select");
	public static final cselector emptyRegistryMsg = new cselector("css,.gift_registry_manage_WWCM","css,.t-registry-no-products-list__description");
	public static final cselector giftCardContainer = new cselector("css,.gr_custom_add_to_cart","css,.t-personalized-gift-card");
	public static final cselector beginAddingItemsButton = new cselector("css,.gift_registry_manage_WWCM + .spot.actions .primary", "css,.t-registry-no-products-list__add-btn");
	public static final cselector beginAddingItemsButtonBD = new cselector("css,.gift_registry_manage_WWCM + .spot.actions .primary", "css,div.u-flexbox.u-direction-row-reverse.u-padding-top-md.confirmation-dialog-box__buttons-container > button:nth-child(1)");
	public static final cselector addGRProductToCart = new cselector("css,.gr_add_to_cart_btn", "css,.t-registry-list-product-list__product-add-to-cart .pw-button");
	public static final cselector BDaddGRProductToCart = new cselector("css,#giftRegistryQuantityForm > div > table > tbody > tr:nth-child(4) > td.options > div > a","css,button.pw-button.t-registry-list-product-list__add-to-cart-btn");
	
	public static final cselector addCartFromGRModal = new cselector("css,.gwt_addtocart_div", "css,.t-registry-list-product-list__product-add-to-cart .pw-button");
	public static final cselector BDaddCartFromGRModal = new cselector("css,.gwt_addtocart_div","css,div.t-registry-list-product-list__details-add-container");
	public static final cselector checkoutFromGRModal = new cselector("css,.gwt_addtocart_div .primary", "css,.t-registry-list-product-list__product-add-to-cart .pw-button");
	public static final cselector productListGR = new cselector("css,[id*=gwt_giftregistry_item_display]", "css,.t-registry-list-product-list");

	// Gift registry at PDP
	public static final cselector selectGRModal = new cselector("css,#gwt-add-to-gift-registry-modal", "css,.m-select_wl_gr_modal");
	public static final cselector BDselectGRModal = new cselector("css,#gwt-add-to-gift-registry-modal > div > table > tbody > tr.dialogMiddle > td.dialogMiddleCenter > div > div > table > tbody > tr:nth-child(3) > td > select", "css,.m-select_wl_gr_modal");
	public static final cselector saveToGR = new cselector("css,#gift-registry-btn", "css,.t-product-details #gift-registry-btn");
	// adding this
	public static final cselector BDsaveToGR = new cselector("css,#scrollableRigthPanel > div > div.qty-and-cta-buttons-panel > div.product-detail-cta-buttons-panel > button.button.primary.add-to-gift-registry-button","css,#app-main > div > div:nth-child(14) > div.u-margin-start-lg.u-margin-end-lg > button");
	public static final cselector FGListBoxGR = new cselector("css,.gift-registry-list-bx", "css,.m-select_wl_gr_modal.m-select_wl_gr_modal .c-custom-select");
	public static final cselector GRListBoxGR = new cselector("css,.gift-registry-list-bx", "css,.m-select_wl_gr_modal.m-select_wl_gr_modal select");
	
	public static final cselector FGAddToGiftRegistySelectButton = new cselector("css,#gwt-add-to-gift-registry-modal .primary", "css,.m-select_wl_gr_modal .pw-sheet__content .pw-button");
	public static final cselector GRAddToGiftRegistySelectButton = new cselector("css,#gwt-add-to-gift-registry-modal .primary", "css,.m-select_wl_gr_modal .pw--primary");
	public static final cselector BDAddToGiftRegistySelectButton = new cselector("css,#gwt-add-to-gift-registry-modal .primary", "css,div.pw-sheet__wrapper > div > div.pw-sheet__content > div > div > div.u-padding-top-0.u-position-relative.u-width-full > div:nth-child(2) > div.u-width-1of2.u-margin-start-sm > button");

	public static final cselector addToGiftRegistyModal = new cselector("css,.gwt-added-to-gift-registry-modal", "css,.m-add-to-registry");
	public static final cselector viewRegistryButton = new cselector("css,.gwt-added-to-gift-registry-modal .primary", "css,.m-add-to-registry .pw--secondary");
	public static final cselector viewRegistryButtonBD = new cselector("css,.gwt-added-to-gift-registry-modal .primary", "css,.pw--primary.u-margin-top");
	public static final cselector productAddedToGRContainer = new cselector("css,.addToCartProductsList", "css,.m-registry-confirmation__image");
	public static final cselector movableMiniCart = new cselector("css,.c-movable-cart-item-counter-badge");

	// Gift registry in shopping.
	public static final cselector addedFromGR = new cselector("css,.from-registry-link", "css,.t-cart__messages-from-customer-registry");
	//public static final cselector miniCartText = new cselector("css,.cartText", "css,.qa-header__cart .pw-badge span>span");
	//.t-header-bar__cart > button > div > p
	public static final cselector miniCartText = new cselector("css,.cartText", "css,.t-header-bar__cart > button > div > p");
	public static final cselector miniCartTextBD = new cselector("css,.cartText","css,#headerBox > div.t-header__bar > div > div.t-header-top.u-flexbox.u-width-full.u-padding-sm > div.pw-header-bar__actions.t-header-bar__cart > button > div");
	public static final cselector cartProductContainer = new cselector("css,.order-item-display-widget-v2", "css,.c-cart-product");
	public static final cselector BDcartProductContainer = new cselector("css,#shopping-cart-v2-root > div > div.main-panel > div.left-main-panel > div.items-container","css,#app-main > div > div > div:nth-child(1) > div > div");
	//public static final cselector itemInCart = new cselector("css,.c-cart-product-item");
	public static final cselector itemInCart = new cselector("css,#gwt_minicart_div > table > tbody > tr > td:nth-child(2) > div");
	public static final cselector GHaddtoGR = new cselector("css,","css,","css,div.u-margin-start-md.u-margin-end-md > button");
	public static final cselector GHadditemtoGR = new cselector("css,","css,","css,div.pw-sheet__content > div > div > button");
	public static final cselector FGadditemtoGR = new cselector("css,","css,","css,div.pw-sheet__content > div > div > button");
}
