package fr.gali.service;

import fr.gali.model.Article;
import fr.gali.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAll();
    Book save(Book book);
    void delete(String id);
    Book getById(String id);
}
