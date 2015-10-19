package fr.gali.service;

import fr.gali.data.BookRepository;
import fr.gali.model.Book;
import fr.gali.web.exception.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookService")
public class BookServiceImpl implements BookService{
    @Autowired
    protected BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public BookServiceImpl(){

    }

    @Override
    public List<Book> getAll() {
        List<Book> results = bookRepository.findAll();
        return results;
    }

    @Override
    public Book getById(String id) {
        Book result = bookRepository.findOne(id);
        if (result == null){
            throw new BookNotFoundException(id);
        }
        else {
            return result;
        }
    }

    @Override
    public Book save(Book book) {
        if (book.getId() != null){
            if (bookRepository.findOne(book.getId()) == null){
                throw new BookNotFoundException(book.getId());
            }
        }
        Book result = bookRepository.save(book);
        return result;
    }

    @Override
    public void delete(String id) {
        bookRepository.delete(id);
    }
}
