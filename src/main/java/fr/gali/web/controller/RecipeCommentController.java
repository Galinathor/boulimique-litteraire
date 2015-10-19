package fr.gali.web.controller;

import fr.gali.model.RecipeComment;
import fr.gali.service.RecipeCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/recipeComments")
public class RecipeCommentController {
    @Autowired
    private RecipeCommentService recipeCommentService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<RecipeComment> getAll() {
        return recipeCommentService.getAll();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    @ResponseBody
    public RecipeComment getById(@PathVariable String id) {
        return recipeCommentService.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public RecipeComment save(@RequestBody @Valid RecipeComment customer) {
        return recipeCommentService.save(customer);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public RecipeComment update(@PathVariable String id, @RequestBody @Valid RecipeComment recipeComment) {
        recipeComment.setId(id);
        return recipeCommentService.save(recipeComment);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id) {
        recipeCommentService.delete(id);
    }
}
