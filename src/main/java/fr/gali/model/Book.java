package fr.gali.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document(collection = "books")
public class Book extends Article{

    @Indexed
    private String author;
    @Indexed
    private String kind;
    @Indexed
    private String publicationDate;
    private String sumUp;
    private String opinion;

    public Book() {
    }

    public Book(String title, String author, String kind, String publicationDate, Picture jacket, String sumUp, String opinion, int grade) {
        super(title, grade, "book", jacket);
        this.author = author;
        this.kind = kind;
        this.publicationDate = publicationDate;
        this.sumUp = sumUp;
        this.opinion = opinion;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(DateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getTitle() {
        return super.getTitle();
    }

    public void setTitle(String title) {
        super.setTitle(title);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Picture getJacket() {
        return super.getJacket();
    }

    public void setJacket(Picture jacket) {
        super.setJacket(jacket);
    }

    public String getSumUp() {
        return sumUp;
    }

    public void setSumUp(String sumUp) {
        this.sumUp = sumUp;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public int getGrade() {
        return super.getGrade();
    }

    public void setGrade(int grade) {
        super.setGrade(grade);
    }
}
