package fr.gali.model;

import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bookComments")
public class BookComment {

    @Id
    private String id;
    @Indexed
    @CreatedDate
    private DateTime creationDate;
    @Indexed
    private String userId;
    @Indexed
    private String bookId;
    private int grade;
    private String comment;

    public BookComment() {
        this.creationDate = DateTime.now();
    }

    public BookComment(String userId, String bookId, int grade, String comment) {
        this.userId = userId;
        this.bookId = bookId;
        this.grade = grade;
        this.comment = comment;
        this.creationDate = DateTime.now();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public DateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(DateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
