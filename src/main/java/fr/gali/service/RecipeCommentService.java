package fr.gali.service;

import fr.gali.model.RecipeComment;

import java.util.List;

public interface RecipeCommentService {
    List<RecipeComment> getAll();
    RecipeComment save(RecipeComment recipeComment);
    void delete(String id);
    RecipeComment getById(String id);
}
