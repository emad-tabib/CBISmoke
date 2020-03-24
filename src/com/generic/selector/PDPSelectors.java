package com.generic.selector;

import com.generic.setup.cselector;

public class PDPSelectors {
	//CBI SMK
	public static final cselector continueShowppingBtn=new cselector("css,#cbiBody > div.gwt-DialogBox.ok-cancel-dlog.gwt_addtocart_div > div > table > tbody > tr.dialogMiddle > td.dialogMiddleCenter > div > table > tbody > tr:nth-child(3) > td > div > button.button.secondary");
	public static final cselector checkOutBtn=new cselector("css,#cbiBody > div.gwt-DialogBox.ok-cancel-dlog.gwt_addtocart_div > div > table > tbody > tr.dialogMiddle > td.dialogMiddleCenter > div > table > tbody > tr:nth-child(3) > td > div > button.button.primary","css,#gwt-add-to-cart-btn");
	public static final cselector avaibleSelection = new cselector("div.gwt-product-options-panel-option-title");
	public static final cselector title = new cselector("css,.gwt-product-title-panel","css,.t-product-details-heading__title.u-margin-bottom");
	public static final cselector BDtitle = new cselector("css,div.gwt-product-detail-product-name-label h1","css,.t-product-details-heading__title.u-margin-bottom");
	public static final cselector titleGH = new cselector("css,.gwt-product-detail-product-name-label","css,.t-product-details-heading__title");
	public static final cselector imgID = new cselector("css,.iwc-imagePanel > div > img","css,.pw-image img");

	public static final cselector avaibleOptions = new cselector("css,.gwt-product-option-panel-widget-panel>div","css,.c-product-option-items__container");
	public static final cselector allColors = new cselector("css,.gwt-image-picker-option >img","css,.pw-swatch__chip>.pw-swatch__chip-inner>.c-product-option-items__item-content.gwt-image-picker-option");
	public static final cselector allSizes = new cselector("css,.gwt-product-option-panel-listbox-container>div> .gwt-ListBox","css,.c-product-options__content.u-border-brand-color.u-border-radius");
	public static final cselector allFabrics = new cselector("css,.gwt-image-picker-option-holder>.gwt-selection-chip-picker-option", "css,.pw-swatch__chip>.pw-swatch__chip-inner");
	public static final cselector allShipLeadTime = new cselector("css,.gwt-image-picker-option-holder>.gwt-selection-chip-picker-option","css,.pw-swatch__chip>.pw-swatch__chip-inner");
	public static final cselector addToCartBtn = new cselector("gwt-add-to-cart-btn");
	public static final cselector addToCartBtnGH = new cselector("css,div.gwt-product-detail-buttons-panel > div> button.button.primary","css,button.c-add-to-cart");
	public static final cselector addToCartBtnBD = new cselector("css,.product-detail-cta-buttons-panel .add-to-cart-button","css,.c-add-to-cart");
	public static final cselector addToCartCloseBtn = new cselector("css,button.gwt-Button.ok-cancel-close-btn","css,div.pw-header-bar__actions > button.c-icon-label-button");
	public static final cselector firstSwatchInOptions = new cselector("css,.gwt-product-option-panel-widget-panel > div  > div > div:nth-child(1)","css,div.c-product-options> div:nth-child({0})> div.u-margin-top > div > div:nth-child(1) > div > button > div > div > div > div > div");
	public static final cselector topPrice = new cselector("gwt-pdp-main-was-now-price-holder","css,.t-product-details-heading__price.t-product-details__price>div");
	public static final cselector addToWLGRBtnEnabled = new cselector("css,.button.secondary.gift-registry","css,.t-product-details>div>.pw-button.u-width-full.u-text-uppercase");
	public static final cselector GHaddToWLGRBtnEnabled = new cselector("css,div.gwt-product-detail-buttons-panel > div > button.secondary","css,div.t-product-details > div > button.pw-button.pw--secondary");
	public static final cselector RYaddToWLGRBtnEnabled = new cselector("css,div.gwt-product-detail-buttons-panel > div > button.secondary","css,a.t-product-details__wishlist-button");
	public static final cselector addToWLGRBtnDisabled = new cselector("css,.button.secondary.gift-registry.disabled","css,.u-wishlist-gift-disable");
	public static final cselector addToCartBtnEnabled = new cselector("css,.button.primary#gwt-add-to-cart-btn","css,.c-add-to-cart");
	public static final cselector addToCartBtnDisabled = new cselector("css,.button.primary.disabled#gwt-add-to-cart-btn","css,.u-bg-disabled-color-add-to-cart");
	public static final cselector bottomPrice = new cselector("gwt-product-detail-widget-total-price-amount","css,.t-product-details-price>span");
	public static final cselector activeListBox = new cselector("css,.gwt-product-content-panel>.gwt-product-right-content-panel>.gwt-product-option-panel>.gwt-product-option-panel-listbox>.gwt-product-option-panel-listbox-container>div>select > option:nth-child(2)");
	public static final cselector activeSwatchOption = new cselector("css,div#gwt-option-panel > div:nth-child(1)> .gwt-product-option-panel-widget-panel > div  > div > div:nth-child(1)","css,div.c-product-options> div:nth-child(1)> div.u-margin-top > div > div:nth-child(1) > div > button > div > div > div > div > div");
	public static final cselector ListBox = new cselector("css,.gwt-product-content-panel>.gwt-product-right-content-panel>.gwt-product-option-panel>.gwt-product-option-panel-listbox>.gwt-product-option-panel-listbox-container>div>select","css,.c-product-options__content.u-border-brand-color.u-border-radius");
	public static final cselector swatchContainer = new cselector("css,.gwt-product-content-panel>.gwt-product-right-content-panel>.gwt-product-option-panel>.gwt-product-option-panel-swatchbox");
	public static final cselector imageOption = new cselector("css,.gwt-product-content-panel>.gwt-product-right-content-panel>div#gwt-option-panel > div:nth-child({0})> .gwt-product-option-panel-widget-panel > div  > div > div:nth-child({1})","css,div.c-product-options> div:nth-child({0})> div.u-margin-top > div > div:nth-child({1}) > div > button > div > div > div > div > div");
	public static final cselector chooseYourItems = new cselector("gwt-choose-your-item-btn");
	public static final cselector numberOfBundleItems = new cselector("css,.gwt-product-detail-products-container>.gwt-product-detail-widget","css,.t-product-details-heading__price.t-product-details__price>div");	
	public static final cselector itemsID = new cselector("css,.gwt-product-detail-products-container>.gwt-product-detail-widget");	
	public static final cselector BDitemsID = new cselector("css,#scrollableRigthPanel","css,.gwt-product-detail-products-container>.gwt-product-detail-widget","css,#app-main > div > div:nth-child(14)");
	public static final cselector addToCartModal = new cselector("css,.gwt-DialogBox.ok-cancel-dlog.gwt_addtocart_div","css,.pw-sheet__inner");
	public static final cselector topPriceBundleDesktop = new cselector("css,.gwt-product-detail-right-panel.gwt-product-right-content-panel>.gwt-pdp-main-was-now-price-holder");
	public  final static cselector topPriceSingle = new cselector("css,.gwt-product-content-panel>.gwt-product-right-content-panel>.gwt-product-right-center-content-panel>.gwt-product-price-container","css,.t-product-details-heading__price.t-product-details__price>div");
	public static final cselector addPersonalizationSingle = new cselector("css,.gwt-product-content-panel>.gwt-product-right-content-panel>.gwt-product-detail-widget-personalization-panel>.gwt-personalize-link-style");
	public static final cselector addToWLGRBtnEnabledSingle = new cselector("css,.gwt-product-content-panel>.gwt-product-right-content-panel>.gwt-product-bottom-content-panel>.product-bottom-gift-regestry-panel","css,.t-product-details>div>.pw-button.u-width-full.u-text-uppercase");
	public static final cselector RYAddToWLGRBtnEnabledSingle = new cselector("css,button.button.secondary","css,.pw-link.icon.t-product-details__wishlist-button");
	public static final cselector addToWLGRBtnDisabledSingle = new cselector("css,.gwt-product-content-panel>.gwt-product-right-content-panel>.gwt-product-bottom-content-panel.disabled>.product-bottom-gift-regestry-panel","css,.u-wishlist-gift-disable");
	public static final cselector addToCartBtnEnabledSingle = new cselector("css,.gwt-product-content-panel>.gwt-product-right-content-panel>.gwt-product-bottom-content-panel>.product-bottom-qty-atc-panel>div>button#gwt-add-to-cart-btn.button.primary","css,.c-add-to-cart");
	public static final cselector RYAddToCartBtnEnabledSingle = new cselector("css,.gwt-product-detail-buttons-container>button.button.primary","css,.c-add-to-cart");
	public static final cselector addToCartBtnDisabledSingle = new cselector("css,.gwt-product-content-panel>.gwt-product-right-content-panel>.gwt-product-bottom-content-panel>.product-bottom-qty-atc-panel>div>button#gwt-add-to-cart-btn.button.primary.disabled","css,.u-bg-disabled-color-add-to-cart");
	public static final cselector bottomPriceSingle = new cselector("css,.gwt-product-content-panel>.gwt-product-right-content-panel>.gwt-product-bottom-content-panel>.product-bottom-total-price-panel>div>.gwt-product-detail-widget-total-price-amount","css,.t-product-details-price>span");
	public static final cselector RYBottomPriceSingle = new cselector("css,.c-product-option-items__container>div>div>.t-product-details-heading__price");
	public static final cselector bundleItems = new cselector("u-widget-product-icon u-position-absolute");

	public static final cselector miniPDPPrice = new cselector("css,.t-product-details-heading >div>.t-product-details-heading__price.t-product-details__price");
	public static final cselector ListBoxOption = new cselector("css,.gwt-product-content-panel>.gwt-product-right-content-panel>.gwt-product-option-panel>.gwt-product-option-panel-listbox>.gwt-product-option-panel-listbox-container>div>select>option", "css,.c-product-options__content.u-border-brand-color.u-border-radius>option");
	public static final cselector allImageOptions = new cselector("css,.gwt-product-content-panel>.gwt-product-right-content-panel>div#gwt-option-panel > div:nth-child({0})> .gwt-product-option-panel-widget-panel > div  > div > div","css,div.c-product-options> div:nth-child({0})> div.u-margin-top > div > div > div > button > div > div > div > div > div");
	public static final cselector expiredPDP = new cselector("css,.gwt-product-content-panel>.gwt-product-right-content-panel>div>.gwt-product-detail-widget-base-expired-label","css,.t-product-details-messages__expired");
	public static final cselector closeBundleProductModal = new cselector("css,.c-icon-label-button");
	
	public static final String bottomPriceBundle = "css,#{0}>" + bottomPriceSingle.DesktopSelector.replace("css,", "");
	public static final String addToCartBtnDisabledBundle = "css,#{0}>" + addToCartBtnDisabledSingle.DesktopSelector.replace("css,", "");
	public static final String addToCartBtnEnabledBundle = "css,#{0}>" + addToWLGRBtnEnabledSingle.DesktopSelector.replace("css,", "");
	public static final String addToWLGRBtnEnabledBundle = "css,#{0}>" + addToWLGRBtnEnabledSingle.DesktopSelector.replace("css,", "");
	public static final String addToWLGRBtnDisabledBundle = "css,#{0}>" + addToWLGRBtnDisabledSingle.DesktopSelector.replace("css,", "");
	public final static String topPriceBundle = "css,#{0}>" + topPriceSingle.DesktopSelector.replace("css,", "");
	public static final String ListBoxBundle = "css,#{0}>" + ListBox.DesktopSelector.replace("css,", "");
	public static final String activeListBoxBundle = "css,#{0}>" + activeListBox.DesktopSelector.replace("css,", "");
	public static final String swatchContainerBundle = "css,#{0}>" + swatchContainer.DesktopSelector.replace("css,", "");
	public static final String imageOptionBundle = "css,#{0}>" + imageOption.DesktopSelector.replace("css,", "");

	public static final String expiredPDPBundle = "css,#{0}>" + expiredPDP.DesktopSelector.replace("css,", "");
	public static final String ListBoxOptionBundle = "css,#{0}>" + ListBoxOption.DesktopSelector.replace("css,", "");
	
	public static final cselector SelectRegistryOrWishListModal = new cselector("css,#gwt-add-to-gift-registry-modal","css,.pw-sheet__inner");
    public static final cselector giftRegistryListBox = new cselector("css,select.gift-registry-list-bx","css,div.pw-sheet__content > div > div  select");
    public static final cselector createNewWL = new cselector("css,select.gift-registry-list-bx > option[value='Create New Wish List']","css, div.pw-sheet__content > div > div  select > option[value='Create New Wish List']");
    public static final cselector RYcreateNewWL = new cselector("css,li> button.wishlist-item","css,div.t-product-details__wishlist-dropdown > button");
    public static final cselector RYcreateNewWLName = new cselector("css,li> button.wishlist-item > span","css,div.t-product-details__wishlist-dropdown > button > div");
    public static final cselector createNewWLConfirmationBtn = new cselector("css,div.gwt-submit-cancel-dialog-button-panel > button.button.primary","css, div.pw-sheet__content > div > div > button");
    public static final cselector nameYourNewWL = new cselector("css,#gwt-wishlist-create-modal","css,div.m-create_new_wishlist_modal");
    public static final cselector WLName = new cselector("css,input#wishlist_name_id");
    public static final cselector nameYourNewWLconfirmationBtn = new cselector("css,#gwt-wishlist-create-modal  button.button.primary","css,div.pw-sheet__content > div > div > button.pw--primary");
    public static final cselector confirmationModal = new cselector("css,div.gwt-DialogBox.ok-cancel-dlog.gwt-added-to-wish-list-modal","css,div.m-product_added_to_wishlist_modal");
    public static final cselector productName = new cselector("css,div.gwt-product-main-title-panel > div > h2","css,div.c-custom-sheet__content > div >div> div> div> div.u-justify-center");
    public static final cselector addToCardProductName = new cselector("css,div.addToCartProductName > div","css,span.t-product-details-heading__title-text > div > div");
    public static final cselector viewListBtn = new cselector("css,td > div > button.button.primary","css,button.pw-button.pw--secondary");
    public static final cselector GHRYviewListBtn = new cselector("css,td > div > button.button.primary","css,div.u-flexbox > button.pw-button.pw--primary");
    public static final cselector addedProductName = new cselector("css,div.gwt_gr_label","css,.t-registry-list-product-list__product-name");
    public static final cselector myWLAddToCartBtn = new cselector("css,div.wish-list-add-to-cart > div > button","css,div.t-registry-list-product-list__product-add-to-cart.u-flex-grow > button");
    public static final cselector GHmyWLAddToCartBtn = new cselector("css,div.wish-list-add-to-cart > div > a","css,button.t-registry-list-product-list__add-to-cart-btn");
    public static final cselector RYmyWLAddToCartBtn = new cselector("css,div.wish-list-add-to-cart > div > a","css,.t-registry-list-product-list__product-add-to-cart > button");
    public static final cselector addToCartConfirmationModal = new cselector("css,div.gwt-DialogBox.ok-cancel-dlog.gwt_addtocart_div");
    public static final cselector addToCartConfirmationModalCheckoutBtn = new cselector("css,div.gwt-DialogBox.ok-cancel-dlog.gwt_addtocart_div button.button.primary");
    public static final cselector shoppingCartProductsName = new cselector("css,div.order-item-name > div","css,div.c-cart-product-item> div > a > h2");
                                                                              
	
	public static final cselector addPersonalizedButton = new cselector("css,.gwt-product-content-panel>div.gwt-product-right-content-panel>div.gwt-product-detail-widget-personalization-panel> div.gwt-personalize-link-style" , "pw-button c-add-personalization-button" );
	public static final cselector addPersonalizedButtonGH = new cselector("css,.gwt-product-detail-widget-personalization-panel >.gwt-personalize-link-style" , "css,.u-border> div > button" );
	public static final cselector personalizationIdentiferGH = new cselector("css,.gwt-personalize-link-style" ,"css,.t-product-details-heading .u-text-uppercase.u-text-size-small" );
	public static final cselector personalizedItems = new cselector("button third gwt-tab-header-sign-button","css,div.pw-accordion--is-prerender > button");
	public static final cselector personalizedOpenItem = new cselector ("button third gwt-tab-header-sign-button","css,div.pw-accordion--is-open > button");
	public static final cselector personalizedItemColors1 = new cselector("css,div.gwt-accordion-tab-content.tabopen > div > div > div.gwt-personalization-modal-accordions-content-option >div >div>div>div.gwt-image-picker-option>img","css,div.pw-accordion--is-open>div > div > div > div > div > div > div > div>div>div>div.u-margin-top.m-product-options-no-padding>div>div>div>button");
	public static final cselector personalizedTypeFaces = new cselector ("css,div.gwt-accordion-tab-content.tabopen > div > div > div.gwt-personalization-modal-accordions-content-option>div>div.gwt-personalization-image-picker-option>img");
	public static final cselector personalizedItemColors2 = new cselector("css,div.gwt-accordion-tab-content.tabopen > div > div > div.gwt-personalization-modal-accordions-content-option > div>div.gwt-personalization-swatch-picker-option>img");
	public static final cselector tabHeaderTitle = new cselector("css,div.gwt-accordion-tab-header>div.gwt-tab-header-title");
	public static final cselector personalizedInputValue = new cselector("css,div.gwt-accordion-tab-content.tabopen > div > div > div.gwt-personalization-modal-accordions-content-option>input","css,div.pw-accordion--is-open>div>div>div>div>div>div>div>div>div>div>div>div>div>input");
	public static final cselector itemSizeMenu = new cselector("css,div.gwt-accordion-tab-content.tabopen > div > div > div.gwt-personalization-modal-accordions-content-option>div.gwt-product-option-panel-listbox-container");
	public static final cselector personalizationSaveAndCloseButton = new cselector ("css,div.gwt-submit-cancel-dialog-button-panel > button.button.primary" , "css,div.pw-accordion--is-open>div>div>div>div>button.pw--primary");
	public static final cselector addedPersonlizedDetails = new cselector("css,.gwt-product-content-panel>div.gwt-product-right-content-panel>div.gwt-product-detail-widget-personalization-panel> div.gwt-product-detail-widget-personalization-chosen-values>div.gwt-HTML","css,div.c-personalization-chosen-values>div>div.c-personalization-chosen-value");
	public static final cselector personlizedModal = new cselector ("gwt-DialogBox","pw-lockup pw--is-locked");
	public static final cselector personalizedItemMenu = new cselector("css,div.gwt-accordion-tab-content.tabopen > div > div > div.gwt-personalization-modal-accordions-content-option>div.gwt-product-option-panel-listbox-container>div>select","css,div.pw-accordion--is-open>div>div>div>div>div>div>div>div>div>div>div>div>div>select");
	public static final cselector personalizedMenuOptions = new cselector("css,div.gwt-accordion-tab-content.tabopen > div > div > div.gwt-personalization-modal-accordions-content-option>div.gwt-product-option-panel-listbox-container>div>select>option","css,div.pw-accordion--is-open>div>div>div>div>div>div>div>div>div>div>div>div>div>select>option");
	public static final cselector personlizedStyleItem = new cselector ("css,div.gwt-accordion-tab-content.tabopen > div > div > div.gwt-personalization-modal-accordions-content-option>div.gwt-option-picker-image-picker>div.gwt-personalization-image-picker-option>img");
	public static final cselector personlizedTitle = new cselector ("css,div.c-add-personalization-panel>span");

	public static final cselector GHRYaddToCartBtn = new cselector("css,.gwt-product-detail-buttons-container>button.button.primary","css,.c-add-to-cart");
	public static final cselector GHfirstSwatchInOptions = new cselector("css,div> .gwt-product-option-panel-widget-panel > div  > div > div:nth-child(1)","css,div.c-product-options> div:nth-child({0})> div.u-margin-top > div > div:nth-child(1) > div > button > div > div > div > div > div");

	public  final static cselector RYtopPriceSingle = new cselector("css,.gwt-product-detail-top-price", "css,.t-product-details-heading__price.t-product-details__price");
	public  final static cselector GHtopPriceSingle = new cselector("css,.gwt-product-detail-quantity-price-column>.gwt-product-detail-widget-price-holder", "css,.t-product-details-heading__price-and-tag>.t-product-details-heading__price.t-product-details__price");
	public static final cselector GHRYColorOptions = new cselector("css,.gwt-product-detail-widget-options-column>div>div>.gwt-product-option-panel-swatchbox>.gwt-product-option-panel-widget-panel>.gwt-image-picker>.gwt-image-picker-option-holder>.gwt-image-picker-option","css,.gwt-image-picker-option>div");
	public static final cselector GHRYSizeOptions = new cselector("css,.gwt-product-detail-widget-options-column>div>div>div>div>.gwt-product-option-panel-widget-panel>.gwt-selection-chip-picker>div>.gwt-selection-chip-picker-option>div","css,.pw-swatch__chip-inner>div>.c-product-option-items__item-normal");
	public static final cselector offerControlClose = new cselector("css,body>form>div>.offer-control.close");
	public static final cselector GHOfferControlClose = new cselector("fcopt-offer-35642-content","fcopt-offer-35745-content");
	public static final cselector RYOfferControlClose = new cselector("fcopt-offer-100287-content","fcopt-offer-94688-content");
	
	public static final cselector FGGRSwatchesOptions = new cselector("css,.gwt-product-content-panel>.gwt-product-right-content-panel>#gwt-option-panel>div","css,.c-product-options>div>div>div" );
	public static final cselector FGGRSwatchesOptionsList = new cselector("css,.gwt-product-content-panel>.gwt-product-right-content-panel>#gwt-option-panel>div>.gwt-product-option-panel-listbox-container>div>select", "css,.c-product-options__container>select");
	public static final cselector FGGRSwatchesOptionsSwatchBox = new cselector("css,.gwt-product-content-panel>.gwt-product-right-content-panel>#gwt-option-panel>div>div>div.gwt-selection-chip-picker>img", "css,.c-product-option-items__item-normal");

	// GH PDP selectors
	public final static cselector GHRYBottomPriceSingle = new cselector("css,.gwt-product-detail-widget-price-holder", "css,.t-product-details__quantity .t-product-details__price");
	public static final cselector GHFirstSwatchInOptions = new cselector("css,div#gwt-option-panel > div:nth-child({0}) .gwt-product-option-panel-widget-panel > div  > div > div:nth-child(1)","css,div.c-product-options> div:nth-child({0})> div.u-margin-top > div > div:nth-child(1) > div > button > div > div > div > div > div");
	public static final cselector GHAddPersonalizedButton = new cselector("css,.gwt-product-detail-widget-personalization-panel .gwt-personalize-link-style" , "css,.c-add-personalization-panel .pw-button");
	public static final cselector GHAddedPersonlizedDetails = new cselector("css,.gwt-product-detail-widget-personalization-chosen-values .gwt-HTML","css,.c-edit-personalization-panel");
	public static final cselector GHAddToWLGRBtnEnabledSingle = new cselector("css,.gwt-product-detail-buttons-panel .secondary","css,.t-product-details>div>.pw--secondary");
	public static final cselector GHAddToCartBtnEnabledSingle = new cselector("css,.gwt-product-detail-buttons-panel .primary","css,.c-add-to-cart");

	public static final cselector PDPPageClassName = new cselector("css,.view-ProductDetailView","css,.t-product-details");

	public static final cselector personalizationPrice = new cselector("css,.gwt-item-personalization-cost .gwt-personalization-choice-selected-name", "css,.c-personalization-chosen-values>div>div");
	public static final cselector GHPersonalizationSaveAndCloseButton = new cselector ("css,div.gwt-submit-cancel-dialog-button-panel > button.button.primary" , "css,.c-personalization-accordion__preview-save .pw--primary");
	public static final cselector GHPersonalizedInputValue = new cselector("css,#personalization-modal-options-scroll .gwt-accordion-tab:nth-child({0}) input","css,.pw-accordion--is-open .c-product-options input");
	public static final cselector GHPersonalizedItemColors = new cselector("css,#personalization-modal-options-scroll .gwt-accordion-tab:nth-child({0}) .gwt-personalization-modal-accordions-content-option .gwt-personalization-swatch-picker-option img","css,.pw-accordion--is-open .c-product-options .color-item .pw-button");
	public static final cselector personalizedItemStyle = new cselector("css,#personalization-modal-options-scroll .gwt-accordion-tab:nth-child({0}) .gwt-personalization-modal-accordions-content-option .gwt-personalization-image-picker-option img");
	public static final cselector GHPersonalizedItems = new cselector("css,.m-personalization-accordion .pw-accordion__item");
	public static final cselector continuePersonalizationSelection = new cselector("css,.pw-accordion--is-open .pw--primary");
	public static final cselector miniCartItems = new cselector("css,#gwt_minicart_div .cartText", "css,.t-header__badge-center>span>span");
	public static final cselector quantity = new cselector("css,.gwt-quantity-textbox", "css,.t-product-details-quantity-value");

	// GH bundle PDP.
	public static final cselector GHBundleItems = new cselector("css,.t-product-details__accordion-collection .pw-accordion__header");
	public static final cselector GHMiniPDPPrice = new cselector("css,.t-product-details__accordion-collection .t-product-details__price");
	public static final cselector GHBottomPriceBundle = new cselector("css,#{0} .gwt-product-detail-widget-price-holder", "css,#{0} .pw-accordion__content-wrapper .t-product-details__price");
	public static final cselector GHRYSizeOptionsBundle = new cselector("css,#{0} .gwt-product-detail-widget-options-column>div>div>div>div>.gwt-product-option-panel-widget-panel>.gwt-selection-chip-picker>div>.gwt-selection-chip-picker-option>div", "css,#{0} .c-product-options__item");
	public static final cselector GHRYColorOptionsBundle = new cselector("css,#{0} .gwt-product-detail-widget-options-column>div>div>.gwt-product-option-panel-swatchbox>.gwt-product-option-panel-widget-panel>.gwt-image-picker>.gwt-image-picker-option-holder>.gwt-image-picker-option","css,#{0} .gwt-image-picker-option>div");
	public static final String GHAddToWLGRBtnEnabledBundle = "css,#{0} #gwt-add-to-gift-registry-btn";
	public static final String GHAddToCartBtnEnabledBundle = "css,#{0} #gwt-add-to-cart-btn";
	public static final cselector quantityBundle = new cselector("css,#{0} .gwt-quantity-textbox", "css,#{0} .t-product-details-quantity-value");
	public static final cselector GHAvailableOptionsBundle = new cselector("css,#{0} .gwt-product-option-panel-widget-panel>div", "css,#{0} .t-product-options__product-option-label");
	public static final cselector GHNumberOfBundleItems = new cselector("css,.gwt-product-detail-products-container>.gwt-product-detail-widget","css,.t-product-details__accordion-collection .pw-accordion__item>button");
	public static final cselector GHItemsID = new cselector("css,.gwt-product-detail-products-container>.gwt-product-detail-widget", "css,.t-product-details__accordion-collection .pw-accordion__item.pw-accordion--is-open");	

	//BD Selectors
	public static final cselector BDSwatchesOptions = new cselector("css,.gwt-product-option-panel > div","css,.c-product-options>div>div>div" );
	public static final cselector BDBundleSwatchesOptions = new cselector("css,.gwt-product-option-panel > div","css,.t-product-details__accordion-collection >div:nth-child(1) .c-product-options>div>div>div.u-flexbox" );
	public static final cselector BDoptionsContainer = new cselector("css,div.t-product-details__accordion-collection > div:nth-child(1) .c-product-options");
	public static final cselector BDallSizes = new cselector("css,div>.gwt-ListBox","css,.c-product-options__content.u-border-brand-color.u-border-radius");
	public static final cselector BDallColors = new cselector("css,.image-picker-option-image-container >img","css,.pw-swatch__chip>.pw-swatch__chip-inner>.c-product-option-items__item-content.gwt-image-picker-option");	
	public static final cselector BDbottomPriceSingle = new cselector("css,div.gwt-price-panel.gwt-was-now-price-with-promo-holder .gwt-promo-discount-now-label","css,div > div:nth-child(2) > div > div.t-product-details__price");
	public static final cselector BDaddToCartBtnEnabledSingle = new cselector("css,button.add-to-cart-button","css,button.c-add-to-cart");
	public static final cselector BDaddToWLGRBtnEnabledSingle = new cselector("css,button.add-to-gift-registry-button","css,button.t-product-details__wishlist-button");
	public static final cselector BDListBox = new cselector("css,select.gwt-ListBox","css,.c-product-options__content.u-border-brand-color.u-border-radius");
	public static final cselector BDtopPriceSingle = new cselector("css,div.gwt-product-top-price-and-number > div > div","css,div.u-padding-bottom div.t-product-details-heading__price > div");
	public static final cselector BDnumberOfBundleItems = new cselector("css,.gwt-product-detail-products-container>.gwt-product-detail-widget","css,div.u-margin-bottom > .t-product-details-heading__price.t-product-details__price>div");	
	public static final cselector BDaddToCartBtn = new cselector("css,button.add-to-cart-button","css,button.c-add-to-cart");
	public static final cselector BDfirstSwatchInOptions = new cselector("css,div:nth-child({0})>.gwt-product-option-panel-widget-panel>div>div>div:nth-child(1)","css,.c-product-options>div:nth-child({0}) .c-product-option-items__container button>div>div:nth-child(1)>div>div:nth-child(1)> div");
	public static final cselector BDtopPriceBundleDesktop = new cselector("css,.gwt-price-panel");
	public static final String BDaddToCartBtnEnabledBundle = "css,#{0} #gwt-add-to-cart-btn";
	public static final String BDbottomPriceBundle = "css,#{0} .product-detail-widget-top-row-price-column div.gwt-promo-discount-now-label";
	public static final String BDListBoxBundle = "css,#{0} " + BDListBox.DesktopSelector.replace("css,", "");
	public static final cselector incrementQuantity = new cselector("css,#incrementId", "css,button.increment-quantity");
	public static final String incrementQuantityBundle =  "css,#{0} " + incrementQuantity.DesktopSelector.replace("css,", "");
	public static final cselector BDQuantityBundleMobile = new cselector( "css,.t-product-details-quantity-value") ;
	public static final cselector BDbottomPriceBundleMobile = new cselector("css,.t-product-details-heading__price-and-tag .t-product-new-price");

	//NEW BD
	public static final cselector BDItemTitle = new cselector("css,.gwt-product-detail-product-name-label","css,.t-product-details-heading__title");
	public static final cselector SCBDConfigOptions = new cselector("css,.gwt-fabric-with-frame-selection-container > div.gwt-selection-chip-picker > div > div","css,div.c-fabric-configurations > div:nth-child(1) > div:nth-child(2) > div > div.pw-swatch__items > div > button");
	public static final cselector SCBDFabricOptions = new cselector("css,div.gwt-fabric-types-selection-container > div.gwt-selection-chip-picker > div > div","css,div.c-fabric-configurations > div:nth-child(2) > div:nth-child(2) > div > div.pw-swatch__items > div > button");
	public static final cselector BDColorOptions = new cselector("css,.gwt-pdp-swatch-thumbnail-image","css,div.c-fabric-swatches-panel > div > div.pw-swatch__items > div > button");
	public static final cselector BDBottomPrice = new cselector("css,div.gwt-price-itemNumber > div > div > div.gwt-HTML.gwt-now-price-holder.gwt-promo-discount-now-label","css,div.u-padding-lg.u-bg-color-alto.u-margin-bottom.u-border-top > div > div.u-text-size-base > span");
	public static final cselector IncrementBtn = new cselector("css, #incrementId");
	public static final cselector BDTopPrice = new cselector("css,div.header-column.header-column-2 > div > div > div.gwt-HTML.gwt-now-price-holder.gwt-promo-discount-now-label","css,div.t-product-details-heading__price-wrapper > div > div > div > span.t-product-promo-price.final-price.u-text-weight-medium.u-color-accent.u-text-size-18");
	public static final cselector OrderASwatchButton = new cselector("css,#gwt-comshop-slipcover-customization-sub-tab-panel > button","css,div.c-order-swatch > button");
	public static final cselector OrderASwatchModal = new cselector("css,div.gwt-DialogBox.ok-cancel-dlog.slipcover-comshop-order-swatch-modelV2","css,div.pw-sheet__wrapper > div");
	public static final cselector OrderSwatchesDropdown = new cselector("css,div.gwt-swatch-filter-panel > div.swatch-filters-panel > div > div","css,div.u-flexbox.u-padding-bottom-lg > div:nth-child(1) > button");
	public static final cselector SearchSwatchInput = new cselector("css,div.gwt-swatch-filter-panel > input","css, div.pw-sheet__content > div > div > div:nth-child(4) > div > div > div > div > div > div > input");
	public static final cselector SearchSwatchResults = new cselector("css,div.all-swatches-container-panel > div > div.gwt-PDP-Fabric-Image-panel:not([aria-hidden]) > img","css,div.m-order-swatch-modal__option.u-display-flex.u-padding-lg.u-border-no-color.u-margin-top-lg.u-margin-bottom-lg.u-border-alto > div > button > div > div > img");
	public static final cselector SuggestedSwatches = new cselector("css,div.all-swatches-container-panel > div > div > div > button","css,div.m-order-swatch-modal__option.u-display-flex.u-padding-lg.u-border-no-color.u-margin-top-lg.u-margin-bottom-lg.u-border-alto > div > div > button");
	public static final cselector ResetFilterBtn = new cselector("css,div.swatch-filters-panel > button","css, div.c-fabric-empty-result-panel.u-flex-1.u-text-align-end > div > button");
	public static final cselector firstSuggestedSwatch = new cselector("css,div.all-swatches-container-panel > div > div:nth-child(1) > div > button","css, div.m-order-swatch-modal__option.u-display-flex.u-padding-lg.u-border-no-color.u-margin-top-lg.u-margin-bottom-lg.u-border-alto > div:nth-child(1) > div > button");
	public static final cselector SwatchLimitMsg = new cselector("css,div.order-selected-swatch-panel > div.gwt-HTML.swatch-detail-header-exceeded-limitation","css,div.pw-dangerous-html > div > div.gwt-HTML.swatch-detail-header-exceeded-limitation");
	public static final cselector AddSwatchesToCartBtn = new cselector("css,div.swatches-to-cart-button-panel > button","css,div.u-margin-top.u-margin-bottom-lg > button");
	public static final cselector AddedSwatchesItems = new cselector("css,div.addToCartProductsContainer > div > div > div","css,div > div.pw-sheet__content > div > div > div > div.u-margin-start-lg.u-margin-top.u-color-neutral-110.u-text-weight-light.u-text-size-base > div");
	public static final cselector closeModal = new cselector("css,div.gwt-DialogBox.ok-cancel-dlog.gwt_addtocart_div > div > table > tbody > tr.dialogTop > td.dialogTopCenter > div > div > div > button","css,.captionContainer > button","css,.m-products_added_to_cart_modal  .c-icon-label-button");
	public static final cselector BDAddToCartModal = new cselector("css,.gwt-DialogBox.ok-cancel-dlog.gwt_addtocart_div","css,div.pw-sheet__wrapper > div > div.pw-sheet__content");

	//COM Shop
	public static final cselector CSBDTopPrice = new cselector("css,.gwt-pdp-main-was-now-price-holder  .gwt-pdp-main-stacked-price-now-label","css,div.t-product-details-heading__price-wrapper > div > div > div > span.t-product-promo-price.final-price.u-text-weight-medium.u-color-accent.u-text-size-18");
	public static final cselector CSBDBottomPrice = new cselector("css,.gwt-comshop-product-detail-widget-price-holder .gwt-pdp-main-stacked-price-now-label","css,.t-product-details__quantity .t-product-new-price");
	public static final cselector CSFinishColorOptions = new cselector("css, table > tbody > tr:nth-child(2) > td > div > div.gwt-comshop-body-option-swatch-container > img","css, div.c-fabric-options > div > div > div > div > div.pw-swatch__items > div > button");
	public static final cselector CSOrderASwatchButton = new cselector("css,#gwt-comshop-customization-sub-tab-panel > button","css,div.c-order-swatch > button");
	public static final cselector CSSearchSwatchResults = new cselector("css,div.swatches-container-panel.fabric-swatches-container > div.gwt-PDP-Fabric-Image-panel:not([aria-hidden]) > img","css, div.pw-sheet__content > div > div > div:nth-child(7) > div:nth-child(1) > div.m-order-swatch-modal__option.u-display-flex.u-padding-lg.u-border-no-color.u-margin-top-lg.u-margin-bottom-lg.u-border-alto > div > button > div > div > img");

	public static final cselector BDimageOption = new cselector("css,div.gwt-product-option-panel>div:nth-child({0}) .gwt-product-option-panel-widget-panel>div>div>div:nth-child({1})>div","css,.t-product-details__accordion-collection >div:nth-child({0}) .c-product-options>div:nth-child({1})>div>div.c-product-option-items__container > div:nth-child({2})>div") ;
    public static final cselector BDaddPersonalizedButton = new cselector("css,.gwt-personalize-link-style","css,.pw-button.add-personalization-button");
	public static final cselector BDpersonalizedItemColors2 = new cselector("css,.gwt-option-picker-swatch-picker> div.gwt-personalization-swatch-picker-option > img");
    public static final cselector BDPersonalizationCost = new cselector("css,div.gwt-HTML.hyper-label.gwt-personalize-link-style > div","css,.pw-button.add-personalization-button>div");
	public static final cselector BDaddedPersonlizedDetails = new cselector("css,div.gwt-custom-personalization-chosen-values-container > div > div > div.gwt-Label.product-option-chosen-values-panel-entry-value","css,.c-personalization-panel .u-display-inline-block > span.u-padding-end-sm:nth-child(2)");
    public static final cselector BDpersonalizedInputValue = new cselector("css,input.gwt-option-picker-alpha-numeric-textbox","css,div.pw-accordion--is-open>div>div>div>div>div>div>div>div>div>div>div>div>div>input");
	public static final cselector BDpersonalizedItems = new cselector("css,.gwt-personalization-picker-panel","css,div.pw-accordion--is-prerender > button");
	public static final cselector BDMonogramCost = new cselector("css,div.gwt-custom-personalization-chosen-values-container > div > div > div.gwt-product-personalization-option-chosen-values-panel.gwt-item-personalization-cost > div.gwt-Label.product-option-chosen-values-panel-entry-value","css,.c-personalization-panel  .u-display-inline-block:nth-child(3) > span.u-padding-end-sm:nth-child(2)");
	public static final cselector BDpersonlizedTitle = new cselector ("css,.pw-button.add-personalization-button > div");
	public static final cselector BDpersonalizationSaveAndCloseButton = new cselector ("css,div.gwt-submit-cancel-dialog-button-panel > button.button.primary" , "css,.m-personalization__button-save-and-close"); 
    public static final cselector BDcreateNewWLConfirmationBtn = new cselector("css,div.gwt-submit-cancel-dialog-button-panel > button.button.primary","css, div.pw-sheet__content > div > div  button.pw--primary");
    public static final cselector BDnameYourNewWLconfirmationBtn = new cselector("css,#gwt-wishlist-create-modal  button.button.primary","css,button.m-create-wishlist__create-button");
    public static final cselector BDconfigureItems = new cselector("css,.vk-product-detail-accordion-container > div:nth-child({0}) .vk-product-detail-items-display-accordion > div","css,div.c-variable-kit-items-display-panel:nth-child({0}) .c-vk-product-detail-accordion") ;
    public static final cselector BDnthConfigureItemOption = new cselector("css,.vk-product-detail-accordion-container > div:nth-child({0}) .vk-product-detail-items-display-accordion > div:nth-child({1}) .gwt-image-picker-option img","css,div.c-variable-kit-items-display-panel:nth-child({0}) .c-vk-product-detail-accordion:nth-child({1}) button.pw-swatch__button");
    public static final cselector BDopenedConfigureItem = new cselector("css,.vk-product-detail-items-display-accordion > div:nth-child({0}) > div.tabopen","css,button.m-create-wishlist__create-button");
    public static final cselector BDproducts = new cselector("css,.vk-product-detail-items-display-accordion","css,.m-product-options .c-variable-kit-items-display-panel");
    public static final cselector BDVK_PDPPrice = new cselector("css,.gwt-was-now-price-panel","css,.t-product-details-heading__price.t-product-details__price");
    public static final cselector BDconfigureBtn = new cselector("css,div.gwt-bundle-vk-detail-widget-column3 > button","css,div.c-configure-button-container.u-padding-lg > div > button.c-configure-button > .pw-button__inner");
    public static final cselector BDproductsBundle = new cselector("css,.gwt-vk-item-display-panel","css,.c-variable-kit-product > div");
    public static final cselector BDnthConfigureItemOptionBundle = new cselector("css,.gwt-vk-item-display-panel:nth-child({0}) > div.gwt-vk-item-panel:nth-child({1})  select","css,.c-variable-kit-product > div:nth-child({0}) .pw-accordion__item:nth-child({1}) button.pw-button");
    public static final cselector BDconfigureItemsBundle = new cselector("css,.gwt-vk-item-display-panel:nth-child({0}) > div.gwt-vk-item-panel","css,.c-variable-kit-product> div:nth-child({0})>.pw-accordion.c-variable-kit-product__bellows > .pw-accordion__item");
    public static final cselector BDconfigureModalDoneBtn = new cselector("css,div.gwt-submit-cancel-dialog-button-panel > button","css,.c-variable-kit-product__save-button button");
    public static final cselector BDitemsAccordion = new cselector("css,.c-variable-kit-product> div:nth-child({0}) .pw-accordion__item.c-variable-kit-product__bellows-item:nth-child({1}) > button");

    
    //Fabric
    public static final cselector FabricAddtoCartBtn = new cselector("css,#gwt-product-detail-widget-id-475942 .gwt-bundle-add-to-cart-btn >button","css,#gwt-product-detail-widget-id-546381 .gwt-bundle-add-to-cart-btn > button","css,.u-margin-start-negative-md .u-margin-bottom-md .u-padding-start-md button");
    public static final cselector FabricAddFreeSwatchtoCartBtn = new cselector("css,#gwt-product-detail-widget-id-475951 .gwt-bundle-add-to-cart-btn >button","css,#gwt-product-detail-widget-id-546381 .gwt-bundle-add-to-cart-btn >button","css,.t-product-details__fabric-swatch-content .t-product-details__swatch-qty-cart .u-width-2of3 .u-padding-start-md > button");
    public static final cselector pickOneFreeSwatch = new cselector("css,#gwt-product-detail-widget-id-475951 .csb-quantity-ctl > #incrementId","css,#gwt-product-detail-widget-id-546381 .csb-quantity-ctl > #incrementId","css,div.t-product-details__swatch-qty-cart.u-flexbox > div:nth-child(1) > div > div > div > div > button.pw-button.pw--icon-only.increment-quantity.u-padding-0.u-border-0");

    public static final cselector BDnextButton = new cselector("css,div.tabcontent.tabopen > div > div > div.tabs-button-panel > button.button.secondary.step-button.next","css,div.bellows--is-open  button.js--next");
    public static final cselector BDPCoptions = new cselector("css,div.tabcontent.tabopen > div > div > div.gwt-pc-option-content-panel > div > div.gwt-option-values-panel > div > div > div > div > img","css,div.bellows--is-open > div.bellows__content-wrapper > div > div.js-configure-fabric__fabric-swatches > div.c-swatch-msg-container > div > div > ul > li img");
    public static final cselector BDremovePrevSelectionModal = new cselector("css,.gwt-DialogBox.ok-cancel-dlog.remove-prev-selection-conf-dialog","css,section.pinny.c-sheet.c--dialog.pinny--is-open");
    public static final cselector BDremovePrevSelectionModalConfirmBtn = new cselector("css,.gwt-DialogBox.ok-cancel-dlog.remove-prev-selection-conf-dialog .button.primary","css,.js-confirmation-change-selection-pinny >.pinny__content .c-arrange__item:nth-child(1) > button");
    public static final cselector BDstartDesignBtn = new cselector("css,button.js-start-designing-btn");
    public static final cselector BDconfiguratorSection = new cselector("css,.c-configurator.bellows > div.js-configure__configurator-section");

    public static final cselector BDConfigureSwatches = new cselector("css,div.bellows--is-open > div.bellows__content-wrapper > div > div.js-configure-fabric__fabric-swatches > div.c-swatch-msg-container > div > div > ul > li");
    public static final cselector BDsaveBtn = new cselector("css,button.js-save-btn");
    public static final cselector BDPDP_PCaddToWLGRBtnEnabled = new cselector("css,button.js-add-to-wishlist.js-add");
    public static final cselector BDAddToCart_PDP_PC = new cselector("css,div.t-pdp__actions> button.js-add-to-cart.js--add");
	public static final cselector BDaddToCartModal = new cselector("css,.gwt-DialogBox.ok-cancel-dlog.gwt_addtocart_div");
    public static final cselector BDPDP_PCtopPrice = new cselector("css,.gwt-now-price-holder","css,.js-price.c--large");
    public static final cselector BDPDP_PCbottomPrice = new cselector("css,.gwt-right-bottom-product-options .gwt-now-price-holder","css,.js-custom-design-conteiner .js-price.c--large");
    public static final cselector BD_size_option = new cselector("css,#gwt-option-panel > div.enabled.gwt-product-option-panel-listbox > div.gwt-product-option-panel-listbox-container > div > select > option:nth-child(2)"); 
    
}
