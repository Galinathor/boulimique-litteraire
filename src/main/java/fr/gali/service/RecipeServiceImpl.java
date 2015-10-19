package fr.gali.service;

import fr.gali.data.RecipeRepository;
import fr.gali.model.Recipe;
import fr.gali.web.exception.RecipeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("recipeService")
public class RecipeServiceImpl implements RecipeService{
    @Autowired
    protected RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository){
        this.recipeRepository = recipeRepository;
    }

    public RecipeServiceImpl(){

    }

    @Override
    public List<Recipe> getAll() {
        List<Recipe> results = recipeRepository.findAll();
        return results;
    }

    @Override
    public Recipe getById(String id) {
        Recipe result = recipeRepository.findOne(id);
        if (result == null){
            throw new RecipeNotFoundException(id);
        }
        else {
            return result;
        }
    }

    @Override
    public Recipe save(Recipe recipe) {
        if (recipe.getId() != null){
            if (recipeRepository.findOne(recipe.getId()) == null){
                throw new RecipeNotFoundException(recipe.getId());
            }
        }
        Recipe result = recipeRepository.save(recipe);
        return result;
    }

    @Override
    public void delete(String id) {
        recipeRepository.delete(id);
    }
}
