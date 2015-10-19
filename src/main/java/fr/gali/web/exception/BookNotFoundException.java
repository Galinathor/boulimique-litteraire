package fr.gali.web.exception;

public class BookNotFoundException extends RuntimeException{
    private final String id;

    public BookNotFoundException(String id) {
        this.id = id;
    }

    public String getMessage(){
        return "There is no book with id: " + id;
    }
}
