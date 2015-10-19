package fr.gali.web.controller;

import fr.gali.model.Article;
import fr.gali.model.Recipe;
import fr.gali.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/recipes")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Recipe> getAll() {
        return recipeService.getAll();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Recipe getById(@PathVariable String id) {
        return recipeService.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Recipe save(@RequestBody @Valid Recipe customer) {
        return recipeService.save(customer);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Recipe update(@PathVariable String id, @RequestBody @Valid Recipe recipe) {
        recipe.setId(id);
        return recipeService.save(recipe);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id) {
        recipeService.delete(id);
    }
}