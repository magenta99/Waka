package com.wakaproject.waka;

public class Product {
    public String PRODUCT_ID;
    public String PRODUCT_NAME;
    public String PRODUCT_TYPE;
    public int PRODUCT_SOLDNUMBER;
    public int PRODUCT_INVENTORYNUMBER;
    public int PRODUCT_PRICE;
    public byte[] PRODUCT_IMAGE;
    public String PRODUCT_DESCRIPTION;

    public Product(String PRODUCT_ID, String PRODUCT_NAME, String PRODUCT_TYPE, int PRODUCT_SOLDNUMBER, int PRODUCT_INVENTORYNUMBER, int PRODUCT_PRICE, byte[] PRODUCT_IMAGE, String PRODUCT_DESCRIPTION) {
        this.PRODUCT_ID = PRODUCT_ID;
        this.PRODUCT_NAME = PRODUCT_NAME;
        this.PRODUCT_TYPE = PRODUCT_TYPE;
        this.PRODUCT_SOLDNUMBER = PRODUCT_SOLDNUMBER;
        this.PRODUCT_INVENTORYNUMBER = PRODUCT_INVENTORYNUMBER;
        this.PRODUCT_PRICE = PRODUCT_PRICE;
        this.PRODUCT_IMAGE = PRODUCT_IMAGE;
        this.PRODUCT_DESCRIPTION = PRODUCT_DESCRIPTION;
    }

}
