package fr.gali.service;

import fr.gali.model.Article;
import fr.gali.model.Recipe;

import java.util.List;

public interface RecipeService {
    List<Recipe> getAll();
    Recipe save(Recipe recipe);
    void delete(String id);
    Recipe getById(String id);
}
