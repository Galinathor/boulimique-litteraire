package fr.gali.model;

import org.joda.time.DateTime;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection="recipes")
public class Recipe extends Article{
    @Indexed
    private String kind;
    @Indexed
    private int difficulty;
    private String source;
    private List<String> ingredients;
    private String recipe;
    private String notes;

    public Recipe() {
    }

    public Recipe(String title, String kind, int difficulty, Picture jacket, String source, List<String> ingredients, String recipe, String notes, int grade) {
        super(title, grade, "recipe", jacket);
        this.kind = kind;
        this.difficulty = difficulty;
        this.source = source;
        this.ingredients = ingredients;
        this.recipe = recipe;
        this.notes = notes;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
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

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public Picture getJacket() {
        return super.getJacket();
    }

    public void setJacket(Picture jacket) {
        super.setJacket(jacket);
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getGrade() {
        return super.getGrade();
    }

    public void setGrade(int grade) {
        super.setGrade(grade);
    }
}
