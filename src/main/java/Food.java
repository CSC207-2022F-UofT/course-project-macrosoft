import java.util.List;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;

public class Food {

    private String name;
    private String description;
    private List<String> ingredients;
    private List<BufferedImage> images;
    private double price;

    public Food(String name, String description, List<String> ingredients, List<BufferedImage> image, double price) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.images = image;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<BufferedImage> getImage() {
        return images;
    }

    public void setImages(List<BufferedImage> image) {
        this.images = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

