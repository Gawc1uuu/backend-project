package pl.zajecia.backendproject.shop.reponse;

public class ProductCannotBeEmptyResponse {
    private String message;

    public ProductCannotBeEmptyResponse(String message) {
        this.message = message;
    }

    public ProductCannotBeEmptyResponse(){

    }
    public String getMessage() {
        return message;
    }
}
