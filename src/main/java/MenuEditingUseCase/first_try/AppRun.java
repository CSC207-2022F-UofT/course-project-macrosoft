package MenuEditingUseCase.first_try;
import LoginUseCase.*;
import Entities.*;

import MenuEditingUseCase.Views.MenuView;

import javax.swing.*;

public class AppRun {
    public AppRun(){
        LoginRestaurantInteractor.login("yinuo's res", "cptbtptp");
        Restaurant curRes = LoginRestaurantInteractor.getCurrentRestaurant();

        final MenuView v = new MenuView(curRes);

    }

    public static void main(String... args){
        SwingUtilities.invokeLater(AppRun::new);
    }
}
