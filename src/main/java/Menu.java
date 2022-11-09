import java.util.*;

public class Menu {

    private List<Food> foodList;

    public Menu(List<Food> foodTtems) {
        this.foodList = foodTtems;
    }

    public List<Food> getFoodTtems() {
        return foodList;
    }

    public void setFoodTtems(List<Food> foodTtems) {
        this.foodList = foodTtems;
    }

}
