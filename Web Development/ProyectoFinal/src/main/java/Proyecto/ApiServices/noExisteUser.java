package Proyecto.ApiServices;

public class noExisteUser extends RuntimeException {

    public noExisteUser(String message) {
        super(message);
    }
}