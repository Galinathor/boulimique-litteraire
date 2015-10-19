package fr.gali.service;

import fr.gali.model.BookComment;

import java.util.List;

public interface BookCommentService {
    List<BookComment> getAll();
    BookComment save(BookComment bookComment);
    void delete(String id);
    BookComment getById(String id);
}
