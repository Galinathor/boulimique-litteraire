package fr.gali.web.controller;

import fr.gali.model.User;
import fr.gali.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAll() {
        return userService.getAll();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getById(@PathVariable String id) {
        return userService.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public User save(@RequestBody @Valid User customer) {
        return userService.save(customer);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public User update(@PathVariable String id, @RequestBody @Valid User user) {
        user.setId(id);
        return userService.save(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id) {
        userService.delete(id);
    }
}
