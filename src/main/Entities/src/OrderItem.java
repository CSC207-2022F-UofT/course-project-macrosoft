import org.bson.types.ObjectId;

public class OrderItem {
    private ObjectId foodItemID;
    private Food food;
    private int numberOfItem;

    public OrderItem(ObjectId foodItemID, Food food, int numberOfItem) {
        this.foodItemID = foodItemID;
        this.food = food;
        this.numberOfItem = numberOfItem;
    }

    public ObjectId getFoodItemID() {
        return foodItemID;
    }

    public void setFoodItemID(ObjectId foodItemID) {
        this.foodItemID = foodItemID;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public int getNumberOfItem() {
        return numberOfItem;
    }

    public void setNumberOfItem(int numberOfItem) {
        this.numberOfItem = numberOfItem;
    }
}