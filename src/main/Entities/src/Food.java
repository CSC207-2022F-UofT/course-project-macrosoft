import org.bson.types.ObjectId;

public class Food {
    private String name;
    private String description;
    private String category;
    private float price;
    private ObjectId itemID;

    public Food(String name, String description, String category, float price, ObjectId itemID) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.itemID = itemID;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ObjectId getItemID() {
        return itemID;
    }

    public void setItemID(ObjectId itemID) {
        this.itemID = itemID;
    }
}