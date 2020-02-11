package com.cdv.training.structural.facade;

public class ShopKeeper {

    MobileShop iPhone;
    MobileShop sony;

    public ShopKeeper() {
        this.iPhone = new iPhone();
        this.sony = new Sony();
    }

    public void iPhoneSale() {
        iPhone.modelNo();
        iPhone.price();
    }

    public void sonySale() {
        sony.modelNo();
        sony.price();
    }

}
