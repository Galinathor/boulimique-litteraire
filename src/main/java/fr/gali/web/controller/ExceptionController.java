package fr.gali.web.controller;

import fr.gali.web.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(BookNotFoundException.class)
    @ResponseStatus(value= HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorInfo handleBookNotFoundException(HttpServletRequest req, BookNotFoundException ex) {
        return new ErrorInfo(req.getRequestURL().toString(), ex.getMessage());
    }

    @ExceptionHandler(RecipeNotFoundException.class)
    @ResponseStatus(value= HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorInfo handleRecipeNotFoundException(HttpServletRequest req, RecipeNotFoundException ex) {
        return new ErrorInfo(req.getRequestURL().toString(), ex.getMessage());
    }

    @ExceptionHandler(BookCommentNotFoundException.class)
    @ResponseStatus(value= HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorInfo handleBookCommentNotFoundException(HttpServletRequest req, BookCommentNotFoundException ex) {
        return new ErrorInfo(req.getRequestURL().toString(), ex.getMessage());
    }

    @ExceptionHandler(RecipeCommentNotFoundException.class)
    @ResponseStatus(value= HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorInfo handleRecipeCommentNotFoundException(HttpServletRequest req, RecipeCommentNotFoundException ex) {
        return new ErrorInfo(req.getRequestURL().toString(), ex.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(value= HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorInfo handleUserNotFoundException(HttpServletRequest req, UserNotFoundException ex) {
        return new ErrorInfo(req.getRequestURL().toString(), ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value= HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorInfo handleMethodArgumentNotValidException(HttpServletRequest req, MethodArgumentNotValidException ex) {

        return new ErrorInfo(req.getRequestURL().toString(), this.getDefaultMessage(ex));
    }

    private String getDefaultMessage(MethodArgumentNotValidException ex){
        String[] message = ex.getMessage().split(";");
        String defaultMessage = message[message.length - 1];
        defaultMessage = defaultMessage.replace(" default message [", "");
        defaultMessage = defaultMessage.replace("]] ", "");
        return defaultMessage;
    }
}
