package SearchingAlgorithmUseCase;

public class UserSearchRestaurantsRequestModel {
    private String name;

    public UserSearchRestaurantsRequestModel(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }
}
