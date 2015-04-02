package com.crendal.m.mydvdshelf.Entities;

import android.widget.ImageView;

import java.io.Serializable;

/**
 * Created by Mara on 13/03/2015.
 */
public class DVD  implements Serializable {

    private String Title;
    private String Synopsys;
    private String Date;
    private String Genre;
    private String Producteur;
    private String Image_Path;

    public DVD() {}

    public DVD(String title, String synopsys, String date, String genre, String producteur, String img_path) {
        Title = title;
        Synopsys = synopsys;
        Date = date;
        Genre = genre;
        Producteur = producteur;
        Image_Path = img_path;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getSynopsys() {
        return Synopsys;
    }

    public void setSynopsys(String synopsys) {
        Synopsys = synopsys;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String getProducteur() {
        return Producteur;
    }

    public void setProducteur(String producteur) {
        Producteur = producteur;
    }

    public String getImage_Path() {
        return Image_Path;
    }

    public void setImage_Path(String image_Path) {
        Image_Path = image_Path;
    }
}
