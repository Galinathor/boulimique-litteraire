package fr.gali.service;

import fr.gali.data.RecipeCommentRepository;
import fr.gali.model.RecipeComment;
import fr.gali.web.exception.RecipeCommentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("recipeCommentService")
public class RecipeCommentServiceImpl implements RecipeCommentService{
    @Autowired
    protected RecipeCommentRepository recipeCommentRepository;

    public RecipeCommentServiceImpl(RecipeCommentRepository recipeCommentRepository){
        this.recipeCommentRepository = recipeCommentRepository;
    }

    public RecipeCommentServiceImpl(){

    }

    @Override
    public List<RecipeComment> getAll() {
        List<RecipeComment> results = recipeCommentRepository.findAll();
        return results;
    }

    @Override
    public RecipeComment getById(String id) {
        RecipeComment result = recipeCommentRepository.findOne(id);
        if (result == null){
            throw new RecipeCommentNotFoundException(id);
        }
        else {
            return result;
        }
    }

    @Override
    public RecipeComment save(RecipeComment recipeComment) {
        if (recipeComment.getId() != null){
            if (recipeCommentRepository.findOne(recipeComment.getId()) == null){
                throw new RecipeCommentNotFoundException(recipeComment.getId());
            }
        }
        RecipeComment result = recipeCommentRepository.save(recipeComment);
        return result;
    }

    @Override
    public void delete(String id) {
        recipeCommentRepository.delete(id);
    }
}
