package MenuEditingUseCase.first_try;

import Entities.Restaurant;
import LoginUseCase.LoginRestaurantInteractor;
import MenuEditingUseCase.first_try.Views.MenuView;

import javax.swing.*;

public class AppRun {
    public AppRun(){
        LoginRestaurantInteractor i = new LoginRestaurantInteractor();
        i.login("yinuo's res", "cptbtptp");
        Restaurant curRes = LoginRestaurantInteractor.getCurrentRestaurant();

        final MenuView v = new MenuView(curRes);

    }

    public static void main(String... args){
        SwingUtilities.invokeLater(AppRun::new);
    }
}
