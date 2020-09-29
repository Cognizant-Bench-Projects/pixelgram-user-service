package com.cognizant.service;

import com.cognizant.model.User;
import com.cognizant.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public User getUserById(int id) {
        return this.userRepository.getOne(id);
    }

    public User login(String email, String pass) {
        try {
            User u = this.userRepository.findByEmailAndPass(email, pass);
            return u;
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    public User createUser(User u) {
        return this.userRepository.save(u);
    }
}
