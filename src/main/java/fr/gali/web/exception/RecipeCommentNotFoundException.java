package fr.gali.web.exception;

public class RecipeCommentNotFoundException extends RuntimeException{
    private final String id;

    public RecipeCommentNotFoundException(String id) {
        this.id = id;
    }

    public String getMessage(){
        return "There is no recipe comment with id: " + id;
    }
}
