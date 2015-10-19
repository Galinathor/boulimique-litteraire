package fr.gali.data;

import fr.gali.model.BookComment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookCommentRepository extends MongoRepository<BookComment, String> {
}
