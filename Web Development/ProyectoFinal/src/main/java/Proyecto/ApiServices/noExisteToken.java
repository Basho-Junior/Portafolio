package Proyecto.ApiServices;

public class noExisteToken extends RuntimeException {

    public noExisteToken(String message) {
        super(message);
    }
}
