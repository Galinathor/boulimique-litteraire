package fr.gali;

import fr.gali.data.*;
import fr.gali.model.*;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/application-context.xml","classpath:/spring/data-context.xml"})
public class FillDb {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookCommentRepository bookCommentRepository;
    @Autowired
    private RecipeCommentRepository recipeCommentRepository;

    @Test
    public void testFillDb() throws InterruptedException {
        User user1 = new User("Example", "Bob", false);
        User user2 = new User("Example", "Victor", false);
        User user3= new User("Example", "Hugo", false);

        user1 = userRepository.save(user1);
        user2 = userRepository.save(user2);
        user3 = userRepository.save(user3);

        List<String> ingredients1 = new ArrayList();
        ingredients1.add("Courgette");
        ingredients1.add("Vache qui rit");

        List<String> ingredients2 = new ArrayList();
        ingredients2.add("Mascarpone");
        ingredients2.add("Fruits rouges");

        List<String> ingredients3 = new ArrayList();
        ingredients3.add("Champignons");
        ingredients3.add("Creme légère");


        Recipe recipe1 = new Recipe("Soupe a la courgette et vache qui rit", "Plat", 1, new Picture(),"Fait maison", ingredients1, "Bonjour je suis une recette", "Bonjour je suis une remarque", 8);
        Thread.sleep(1000);
        Book book1 = new Book("Harry Pottique et les rollers de la mort", "François 1er", "Fantastique", "2003", new Picture(), "Bonjour je suis un resume", "Bonjour je suis un avis", 9);
        Thread.sleep(1000);
        Book book3 = new Book("J'irai cracher sur vos tombes", "Boris Vian", "Roman", "1973", new Picture(), "Bonjour je suis un resume", "Bonjour je suis un avis", 5);
        Thread.sleep(1000);
        Recipe recipe2 = new Recipe("Buche de noel mascarpone fruit rouge", "Dessert", 3, new Picture(), "Fait maison", ingredients2, "Bonjour je suis une recette", "Bonjour je suis une remarque", 10);
        Thread.sleep(1000);
        Book book2 = new Book("L'aiguille creuse", "Morice Leblanc", "Policier", "", new Picture(), "Bonjour je suis un resume", "Bonjour je suis un avis", 7);
        Thread.sleep(1000);
        Recipe recipe3 = new Recipe("Sauce champignon pour poulet rapide et facile", "Accompagnement", 1, new Picture(), "Marmiton", ingredients3, "Bonjour je suis une recette", "Bonjour je suis une remarque", 2);

        book1 = bookRepository.save(book1);
        book2 = bookRepository.save(book2);
        book3 = bookRepository.save(book3);

        recipe1 = recipeRepository.save(recipe1);
        recipe2 = recipeRepository.save(recipe2);
        recipe3 = recipeRepository.save(recipe3);

        BookComment bookComment1 = new BookComment(user1.getId(), book1.getId(), 7, "Bonjour je suis un commentaire");
        BookComment bookComment2 = new BookComment(user1.getId(), book2.getId(), 5, "Bonjour je suis un commentaire");
        BookComment bookComment3 = new BookComment(user2.getId(), book3.getId(), 4, "Bonjour je suis un commentaire");
        BookComment bookComment4 = new BookComment(user2.getId(), book1.getId(), 9, "Bonjour je suis un commentaire");
        BookComment bookComment5 = new BookComment(user3.getId(), book3.getId(), 5, "Bonjour je suis un commentaire");

        bookComment1 = bookCommentRepository.save(bookComment1);
        bookComment2 = bookCommentRepository.save(bookComment2);
        bookComment3 = bookCommentRepository.save(bookComment3);
        bookComment4 = bookCommentRepository.save(bookComment4);
        bookComment5 = bookCommentRepository.save(bookComment5);

        RecipeComment recipeComment1 = new RecipeComment(user1.getId(), recipe1.getId(), 7, "Bonjour je suis un commentaire");
        RecipeComment recipeComment2 = new RecipeComment(user2.getId(), recipe1.getId(), 5, "Bonjour je suis un commentaire");
        RecipeComment recipeComment3 = new RecipeComment(user2.getId(), recipe3.getId(), 4, "Bonjour je suis un commentaire");
        RecipeComment recipeComment4 = new RecipeComment(user3.getId(), recipe2.getId(), 9, "Bonjour je suis un commentaire");
        RecipeComment recipeComment5 = new RecipeComment(user1.getId(), recipe3.getId(), 10, "Bonjour je suis un commentaire");

        recipeComment1 = recipeCommentRepository.save(recipeComment1);
        recipeComment2 = recipeCommentRepository.save(recipeComment2);
        recipeComment3 = recipeCommentRepository.save(recipeComment3);
        recipeComment4 = recipeCommentRepository.save(recipeComment4);
        recipeComment5 = recipeCommentRepository.save(recipeComment5);
    }
}
