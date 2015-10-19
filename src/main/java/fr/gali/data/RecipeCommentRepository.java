package fr.gali.data;

import fr.gali.model.RecipeComment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecipeCommentRepository extends MongoRepository<RecipeComment, String> {
}
