package com.example.task1;

public class DataModel {

    String name;
    String description;
    int image;
    int id;

    public DataModel(String name, String description, int image, int id){
        this.name = name;
        this.description = description;
        this.image = image;
        this.id = id;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public Integer getImage() { return image; }
    public Integer getId() { return id; }
}
