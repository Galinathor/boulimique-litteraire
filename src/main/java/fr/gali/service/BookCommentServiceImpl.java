package fr.gali.service;

import fr.gali.data.BookCommentRepository;
import fr.gali.model.BookComment;
import fr.gali.web.exception.BookCommentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookCommentService")
public class BookCommentServiceImpl implements BookCommentService{
    @Autowired
    protected BookCommentRepository bookCommentRepository;

    public BookCommentServiceImpl(BookCommentRepository bookCommentRepository){
        this.bookCommentRepository = bookCommentRepository;
    }

    public BookCommentServiceImpl(){

    }

    @Override
    public List<BookComment> getAll() {
        List<BookComment> results = bookCommentRepository.findAll();
        return results;
    }

    @Override
    public BookComment getById(String id) {
        BookComment result = bookCommentRepository.findOne(id);
        if (result == null){
            throw new BookCommentNotFoundException(id);
        }
        else {
            return result;
        }
    }

    @Override
    public BookComment save(BookComment bookComment) {
        if (bookComment.getId() != null){
            if (bookCommentRepository.findOne(bookComment.getId()) == null){
                throw new BookCommentNotFoundException(bookComment.getId());
            }
        }
        BookComment result = bookCommentRepository.save(bookComment);
        return result;
    }

    @Override
    public void delete(String id) {
        bookCommentRepository.delete(id);
    }
}
