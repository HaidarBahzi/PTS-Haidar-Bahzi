package com.example.aplikasi_pts;

public class Game {

    private String Name;
    private String Genre;
    private String Price;
    private Integer Image;
    private String Descripton;

    public String getName(){
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getGenre(){
        return Genre;
    }

    public void setGenre(String genre) {
        this.Genre = genre;
    }

    public String getPrice(){
        return Price;
    }

    public void setPrice(String price) {
        this.Price = price;
    }

    public Integer getImage() {
        return Image;
    }

    public void setImage(Integer image) {
        this.Image = image;
    }

    public void setDescription(String description) {
        this.Descripton = description;
    }

    public String getDescription() {
        return Descripton;
    }
}
