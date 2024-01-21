package pl.zajecia.backendproject.shop.reponse;

public class ProductDontExistsResponse {
    private String message;


    public ProductDontExistsResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
