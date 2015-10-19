package fr.gali.web.exception;

public class UserNotFoundException extends RuntimeException{
    private final String id;

    public UserNotFoundException(String id) {
        this.id = id;
    }

    public String getMessage(){
        return "There is no user with id: " + id;
    }
}
