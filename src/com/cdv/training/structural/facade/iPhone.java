package com.cdv.training.structural.facade;

public class iPhone implements MobileShop {

    @Override
    public void modelNo() {
       System.out.println("Iphone 8");
    }

    @Override
    public void price() {
        System.out.println("80,000.00");
    }

}
