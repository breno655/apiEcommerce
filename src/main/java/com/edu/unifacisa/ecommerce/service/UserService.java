package com.edu.unifacisa.ecommerce.service;

import com.edu.unifacisa.ecommerce.model.User;
import com.edu.unifacisa.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void insertUser (User user) {
        userRepository.save(user);
    }

    public String login (String login, String senha) {
        List<User> listUsers = userRepository.findAll();
        String logado = "false";
        for (User user : listUsers){
            if (user.getLogin().equals(login) && user.getPassword().equals(senha)) {
                return "true";
            }
        } return logado;
    }

    public List<User> findAll () {
        return userRepository.findAll();
    }

    public User findById (long id) {
        return userRepository.findById(id).get();
    }

    public void deleteUser (long id) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
    }

    public void atualizaUser (long id, User user) {
        deleteUser(id);
        user.setId(id);
        insertUser(user);
    }

}
