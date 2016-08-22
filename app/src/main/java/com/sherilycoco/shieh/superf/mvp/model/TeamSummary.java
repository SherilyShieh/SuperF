package com.sherilycoco.shieh.superf.mvp.model;

/**
 * Created by Administrator on 2016/8/22.
 */
public class TeamSummary {
    private String name;
    private int Image;

    public TeamSummary(String name, int image) {
        this.name = name;
        Image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }
}
