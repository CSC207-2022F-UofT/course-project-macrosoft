import java.awt.image.BufferedImage;
import java.util.List;

public class MenuEditor {

    private Menu currentMenu;

    public MenuEditor(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }

    public void removeFood(Food removeFood){
        currentMenu.getFoodTtems().remove(removeFood);
    }

    public void addFood(String name, String description, List<String> ingredients, List<BufferedImage> images, double price){
        Food newFood = new Food(name, description, ingredients, images, price);
        currentMenu.getFoodTtems().add(newFood);
    }

    public void editName(Food foodEditing, String newName){
        foodEditing.setName(newName);
    }

    public void editDescription(Food foodEditing, String newDescription){
        foodEditing.setDescription(newDescription);
    }

    public void editImages(Food foodEditing, List<BufferedImage> newImages){
        foodEditing.setImages(newImages);
    }

    public void editPrice(Food foodEditing, Double newPrice){
        foodEditing.setPrice(newPrice);
    }

}
