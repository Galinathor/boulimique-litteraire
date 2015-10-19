package fr.gali.model;

import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class Article implements Comparable<Article>{
    @Id
    protected String id;
    @Indexed
    @CreatedDate
    protected DateTime creationDate;
    @Indexed
    private String title;
    private String type;
    @Indexed
    private int grade;
    private Picture jacket;

    public Article(String title, int grade, String type, Picture jacket) {
        this.title = title;
        this.grade = grade;
        this.type = type;
        this.jacket = jacket;
        this.creationDate = DateTime.now();
    }

    public Picture getJacket() {
        return jacket;
    }

    public void setJacket(Picture jacket) {
        this.jacket = jacket;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Article() {
        this.creationDate = DateTime.now();
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
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public int compareTo(Article article) {
        if (this.creationDate.getMillis() > article.getCreationDate().getMillis())
            return -1;
        else if (this.creationDate.getMillis() < article.getCreationDate().getMillis())
            return 1;
        else
            return 0;
    }
}
