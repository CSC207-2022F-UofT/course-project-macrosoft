package menu_editing_use_case;
import entities.*;
import org.bson.types.ObjectId;

//Application Business Rule layer

public class AddFoodRequestModel {

    private ObjectId resId;
    private Menu curMenu;

    private String name;

    private String category;

    private String description;

    private float price;

    public AddFoodRequestModel(ObjectId resId, Menu curMenu, String name, String category, String description, float price) {
        this.resId = resId;
        this.curMenu = curMenu;
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
    }

    public Menu getCurMenu() {
        return curMenu;
    }

    public void setCurMenu(Menu curMenu) {
        this.curMenu = curMenu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ObjectId getResId() {
        return resId;
    }

    public void setResId(ObjectId resId) {
        this.resId = resId;
    }
}

