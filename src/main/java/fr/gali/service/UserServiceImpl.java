package fr.gali.service;

import fr.gali.data.UserRepository;
import fr.gali.model.User;
import fr.gali.web.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    protected UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserServiceImpl(){

    }

    @Override
    public List<User> getAll() {
        List<User> results = userRepository.findAll();
        return results;
    }

    @Override
    public User getById(String id) {
        User result = userRepository.findOne(id);
        if (result == null){
            throw new UserNotFoundException(id);
        }
        else {
            return result;
        }
    }

    @Override
    public User save(User user) {
        if (user.getId() != null){
            if (userRepository.findOne(user.getId()) == null){
                throw new UserNotFoundException(user.getId());
            }
        }
        User result = userRepository.save(user);
        return result;
    }

    @Override
    public void delete(String id) {
        userRepository.delete(id);
    }
}
