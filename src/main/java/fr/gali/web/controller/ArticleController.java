package fr.gali.web.controller;

import fr.gali.model.Article;
import fr.gali.model.Book;
import fr.gali.model.Recipe;
import fr.gali.service.BookService;
import fr.gali.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping(value="/articles")
public class ArticleController {
    @Autowired
    private BookService bookService;
    @Autowired
    private RecipeService recipeService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Article> getAll() {
        List<Book> books = bookService.getAll();
        List<Recipe> recipes = recipeService.getAll();

        List<Article> lastBooks = getLastBooks(books);
        List<Article> lastRecipes = getLastRecipes(recipes);

        return mergeArticles(lastBooks, lastRecipes);
    }

    private List<Article> mergeArticles(List<Article> lastArticles, List<Article> lastRecipes){
        int j, size;
        boolean rep;

        if (lastArticles.size() < 5){
            size = 5 - lastArticles.size();
            for (int i = 0; i < size; i++){
                lastArticles.add(lastRecipes.get(i));
                lastRecipes.remove(i);
            }
        }
        Collections.sort(lastArticles);

        for (int i = 0; i < lastRecipes.size(); i++){
            j = 0;
            rep = true;
            while (j < lastArticles.size() && rep) {
                if (lastRecipes.get(i).compareTo(lastArticles.get(j)) < 0){
                    decalArticle(lastArticles, lastRecipes.get(i), j);
                    rep = false;
                }
                j++;
            }
        }

        return lastArticles;
    }

    private List<Article> getLastBooks(List<Book> books){
        List<Article> lastArticles = new ArrayList();
        int j;
        boolean rep;
        if (books.size() >= 5){
            for (int i = 0; i < 5; i++){
                lastArticles.add(books.get(i));
            }
            Collections.sort(lastArticles);

            for (int i = 5; i < books.size(); i++){
                j = 0;
                rep = true;
                while (j < lastArticles.size() && rep) {
                    if (books.get(i).getCreationDate().getMillis() > lastArticles.get(j).getCreationDate().getMillis()) {
                        decalArticle(lastArticles, books.get(i), j);
                        rep = false;
                    }
                    j++;
                }
            }
        }
        else{
            for (int i = 0; i < books.size(); i++){
                lastArticles.add(books.get(i));
            }
            Collections.sort(lastArticles);
        }
        return lastArticles;
    }

    private List<Article> getLastRecipes(List<Recipe> recipes){
        List<Article> lastArticles = new ArrayList();
        int j;
        boolean rep;
        if (recipes.size() >= 5){
            for (int i = 0; i < 5; i++){
                lastArticles.add(recipes.get(i));
            }
            Collections.sort(lastArticles);

            for (int i = 5; i < recipes.size(); i++){
                j = 0;
                rep = true;
                while (j < lastArticles.size() && rep) {
                    if (recipes.get(i).getCreationDate().getMillis() > lastArticles.get(i).getCreationDate().getMillis()) {
                        decalArticle(lastArticles, recipes.get(i), i);
                        rep = false;
                    }
                    j++;
                }
            }
        }
        else{
            for (int i = 0; i < recipes.size(); i++){
                lastArticles.add(recipes.get(i));
            }
            Collections.sort(lastArticles);
        }
        return lastArticles;
    }

    private void decalArticle(List<Article> articles, Article article, int index){
        articles.add(index, article);
        articles.remove(articles.size()-1);
    }
}
