package com.cdv.training.structural.facade;

public class Sony implements MobileShop {

    @Override
    public void modelNo() {
        System.out.println("Sony");
    }

    @Override
    public void price() {
        System.out.println("100,000.00");
    }

}
