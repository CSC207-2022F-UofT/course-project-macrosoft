package restaurant_homepage_use_case;

import org.bson.types.ObjectId;

public class show_screen {

    public static void main(String[] args) {
         RestaurantHomepageController controller = new RestaurantHomepageController(new ObjectId("63797394ee00665db6a0a950"));
         RestaurantHomepageScreen screen = new RestaurantHomepageScreen(controller, "yinuo's res");
    }
}
