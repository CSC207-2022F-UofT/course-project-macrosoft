package SearchingAlgorithmUseCase;

import java.util.Scanner;

public class GetNameFromUser {
    public static void printWantedRestaurant() {
        Scanner myObj = new Scanner(System.in);

        System.out.println("Enter restaurant name:");

        // String input
        String name = myObj.nextLine();

        // Output input by user
        System.out.println("Name: " + SearchRestaurantsInteractor.getRestaurant(name).getName());
    }
}
