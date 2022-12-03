package user_homepage_use_case;


public class display_screen {

    public static void main(String[] args) {
        UserHomepageController controller = new UserHomepageController();
        UserHomePagePresenter presenter = new UserHomePagePresenter();

        UserHomePageScreen screen = new UserHomePageScreen(controller);

    }
}
