package com.jenish9599.android.eleganceapp;

/**
 * Created by jenishpatel on 06/12/17.
 */

public class blogs {


    public String title;
    public String description;
    public String imgsrc;


    public blogs(String title, String description, String imgsrc) {
        this.title = title;
        this.description = description;
        this.imgsrc = imgsrc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }
}
