package com.example.besant.besant;

/**
 * Created by Sai Naveen Kumar on 9/7/2017.
 */

public class Dataprovider {

    private int img_res;
    private String item_name;

    public Dataprovider(int img_res, String name, String item_name) {
        this.setImg_res(img_res);
        this.setItem_name(item_name);
    }

    public int getImg_res()
    {
        return img_res;
    }

    public void setImg_res(int img_res)
    {
        this.img_res = img_res;
    }

    public String getItem_name()
    {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = this.item_name;
    }
}

