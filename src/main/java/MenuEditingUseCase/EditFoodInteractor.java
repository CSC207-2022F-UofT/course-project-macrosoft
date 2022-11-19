package MenuEditingUseCase;
import Entities.*;

public class EditFoodInteractor {

    public static void modifyName(Food currFood, String newName)
    {
        currFood.setName(newName);
    }

    public static void modifyPrice(Food currFood, float newPrice){
        currFood.setPrice(newPrice);
    }

    public static void modifyDescription(Food currFood, String newDescription){
        currFood.setDescription(newDescription);
    }

    public static void modifyCategory(Food currFood, String newCategory){
        currFood.setDescription(newCategory);
    }
}
