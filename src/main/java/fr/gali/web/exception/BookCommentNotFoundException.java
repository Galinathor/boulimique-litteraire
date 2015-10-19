package fr.gali.web.exception;

public class BookCommentNotFoundException extends RuntimeException{
    private final String id;

    public BookCommentNotFoundException(String id) {
        this.id = id;
    }

    public String getMessage(){
        return "There is no book comment with id: " + id;
    }
}
