package user_homepage_use_case;


import org.bson.types.ObjectId;

public class display_screen {

    public static void main(String[] args) {
        UserHomepageController controller = new UserHomepageController(new ObjectId("63335e7abb6cd6599ed6f64b"));
        UserHomePageScreen screen = new UserHomePageScreen(controller);

    }
}
