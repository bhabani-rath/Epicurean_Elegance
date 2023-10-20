package com.cutm.foodorderapp.Fragment;

public class PopularItemModel {

    private static int pic;
    private static String name;
    private static String price;

    public PopularItemModel(int pic, String name, String price) {
        this.pic = pic;
        this.name = name;
        this.price = price;
    }

    public static int getPic() {
        return pic;
    }

    public static String getName() {
        return name;
    }

    public static String getPrice() {
        return price;
    }
}
