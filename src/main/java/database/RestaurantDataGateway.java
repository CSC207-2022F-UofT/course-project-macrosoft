package database;

import entities.Restaurant;
import org.bson.types.ObjectId;

import java.util.List;

/**
 * Gateway for the Restaurant entity to Database.
 */
public interface RestaurantDataGateway {

    /**
     * Gets the id of a new restaurant
     *
     * @param name     the name of the new restaurant
     * @param email    the email of the new restaurant
     * @param location the location of the new restaurant
     * @param phone    the phone number of the new restaurant
     * @return the id of the new restaurant
     */
    ObjectId newRestaurant(String name, String email, String location, String phone);

    /**
     * Saves a restaurant to the database
     *
     * @param restaurant the restaurant to be saved
     */
    void save(Restaurant restaurant);

    /**
     * Finds all restaurants in the database
     *
     * @return a list of all restaurants in the database
     */
    List<Restaurant> findAll();

    /**
     * Finds a restaurant by its id
     *
     * @param id the id of the restaurant
     * @return the restaurant with the given id
     */
    Restaurant findById(ObjectId id);

    /**
     * Finds the restaurant name by the restaurant id.
     *
     * @param restId the restaurant id
     * @return String the restaurant name found by the id
     */
    String getRestaurantNameById(ObjectId restId);

    /**
     * Finds a restaurant by its name
     *
     * @param restaurantName the name of the restaurant
     * @return a list of restaurants with the given name
     */
    List<Restaurant> findByRestaurantName(String restaurantName);

    /**
     * Updates the verified status of a restaurant
     *
     * @param restaurantId the id of the restaurant to be updated
     * @param newStatus    the new verified status of the restaurant
     */
    void updateVerifiedStatus(ObjectId restaurantId, Boolean newStatus);

    /**
     * Updates the information of a restaurant
     *
     * @param restaurantID the id of the restaurant to be updated
     * @param newName      the new name of the restaurant
     * @param newEmail     the new email of the restaurant
     * @param newLocation  the new location of the restaurant
     * @param newPhone     the new phone number of the restaurant
     */
    void updateRestaurantInfo(ObjectId restaurantID, String newName, String newEmail,
                              String newLocation, String newPhone);

    /**
     * Updates the menu of a restaurant based on the restaurant id and the menu id
     *
     * @param restaurantId the id of the restaurant to be updated
     * @param menuId       the id of the menu to be added to the restaurant
     */
    void updateMenuId(ObjectId restaurantId, ObjectId menuId);

    /**
     * Deletes a restaurant by its id
     *
     * @param id the id of the restaurant to be deleted
     */
    void removeResById(ObjectId id);
}
