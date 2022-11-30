package OrderHistoryUseCase;

import Entities.User;

public class OrderHistoryRequestModel {
    private User curUser;
    public OrderHistoryRequestModel(User curUser) {
        this.curUser = curUser;
    }

    public User getCurUser() {
        return curUser;
    }

    public void setCurUser(User curUser) {
        this.curUser = curUser;
    }
}
