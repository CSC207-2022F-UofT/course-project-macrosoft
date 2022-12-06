package update_order_status_use_case;

public class NewResponseFormatter implements NewPresenter{


    @Override
    public void orderFound(NewResponseModel newResponseModel) {

    }

    @Override
    public void orderNotFound() {

    }

    @Override
    public NewResponseModel prepareSuccessView(NewResponseModel responsModel) {
        return  responsModel;
    }

    @Override
    public void setOrderPanel(NewPanelInterface newPanelInterface) {

    }

    @Override
    public NewResponseModel prepareFailView(String str) {
        return null;
    }

}
