package fr.gali.web.exception;

public class RecipeNotFoundException extends RuntimeException{
    private final String id;

    public RecipeNotFoundException(String id) {
        this.id = id;
    }

    public String getMessage(){
        return "There is no recipe with id: " + id;
    }
}
