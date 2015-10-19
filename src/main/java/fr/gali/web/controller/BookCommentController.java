package fr.gali.web.controller;

import fr.gali.model.BookComment;
import fr.gali.service.BookCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/bookComments")
public class BookCommentController {
    @Autowired
    private BookCommentService bookCommentService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<BookComment> getAll() {
        return bookCommentService.getAll();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    @ResponseBody
    public BookComment getById(@PathVariable String id) {
        return bookCommentService.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public BookComment save(@RequestBody @Valid BookComment customer) {
        return bookCommentService.save(customer);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public BookComment update(@PathVariable String id, @RequestBody @Valid BookComment bookComment) {
        bookComment.setId(id);
        return bookCommentService.save(bookComment);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id) {
        bookCommentService.delete(id);
    }
}
