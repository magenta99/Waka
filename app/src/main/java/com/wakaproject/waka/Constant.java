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

    //SẢN PHẨM TRONG GIỎ HÀNG
    public static final String PRODUCT_CART_TABLE = "GioHang";

    public static final String PRODUCT_CART_ID = "MaSanPham";
    public static final String PRODUCT_CART_NAME = "TenSanPham";
    public static final String PRODUCT_CART_NUMBER = "SoLuong";
    public static final String PRODUCT_CART_PRICE = "GiaThanh";
    public static final String PRODUCT_CART_IMAGE = "HinhAnh";


    public static final String CREATE_PRODUCT_CART_TABLE = "CREATE TABLE " + PRODUCT_CART_TABLE + "(" +
            "" + PRODUCT_CART_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            "" + PRODUCT_CART_NAME + " NVARCHAR(100)," +
            "" + PRODUCT_CART_PRICE + " INT," +
            "" + PRODUCT_CART_IMAGE + " BLOB," +
            "" + PRODUCT_CART_NUMBER + " INT" +
            ")";

    //USER
    public static final String USER_TABLE = "NguoiDung";

    //khai bao ten cot trong bang nguoiDung
    public static final String USER_NAME = "Username";
    public static final String USER_PASSWORD = "Password";
    public static final String USER_PHONE = "Phone";
    public static final String USER_FULL_NAME = "HoTen";

    //cau lenh tao bang nguoi dung

    //CREATE TABLE nguoiDung (userName NVARCHAR(50) , Password NVARCHAR(50) , Phone NCHAR(10) , hoTen NVARCHAR(50));

    public static final String CREATE_USER_TABLE = "CREATE TABLE " + USER_TABLE + "(" +
            "" + USER_NAME + " NVARCHAR(50) PRIMARY KEY NOT NULL ," +
            "" + USER_PASSWORD + " NVARCHAR(50)," +
            "" + USER_PHONE + " NCHAR(10)," +
            "" + USER_FULL_NAME + " NVARCHAR(50)" +
            ")";


}
