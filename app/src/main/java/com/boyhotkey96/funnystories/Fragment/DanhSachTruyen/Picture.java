package com.boyhotkey96.funnystories.Fragment.DanhSachTruyen;

/**
 * Created by Tan on 12/3/2017.
 */

public class Picture {
    private int id;
    private String Name, ImageURL;

    public Picture(int id, String name, String imageURL) {
        this.id = id;
        Name = name;
        ImageURL = imageURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImageURL() {
        return ImageURL;
    }

    public void setImageURL(String imageURL) {
        ImageURL = imageURL;
    }
}
