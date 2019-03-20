package com.wakaproject.waka;

public class Constant {
    public static final String PRODUCT_TABLE = "SanPham";

    public static final String PRODUCT_ID = "MaSanPham";
    public static final String PRODUCT_NAME = "TenSanPham";
    public static final String PRODUCT_TYPE = "TheLoai";
    public static final String PRODUCT_SOLDNUMBER = "SoLuongDaBan";
    public static final String PRODUCT_INVENTORYNUMBER = "SoLuongTonKho";
    public static final String PRODUCT_PRICE = "GiaThanh";
    public static final String PRODUCT_IMAGE = "HinhAnh";
    public static final String PRODUCT_DESCRIPTION = "MoTa";

    public static final String CREATE_PRODUCT_TABLE = "CREATE TABLE " + PRODUCT_TABLE + "(" +
            "" + PRODUCT_ID + " NCHAR(7) PRIMARY KEY NOT NULL," +
            "" + PRODUCT_NAME + " NVARCHAR(100)," +
            "" + PRODUCT_TYPE + " NVARCHAR(30)," +
            "" + PRODUCT_SOLDNUMBER + " INT," +
            "" + PRODUCT_PRICE + " INT," +
            "" + PRODUCT_IMAGE + " BLOB," +
            "" + PRODUCT_DESCRIPTION + " NVARCHAR(1000)," +
            "" + PRODUCT_INVENTORYNUMBER + " INT" +
            ")";
}
