package com.edu.unifacisa.ecommerce.controller;

import com.edu.unifacisa.ecommerce.model.User;
import com.edu.unifacisa.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public List<User> getUsers () {
        return userService.findAll();
    }

    @PostMapping("/insert")
    public void insertUser (@RequestBody User user) {
        userService.insertUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser (@PathVariable long id) {
        userService.deleteUser(id);
    }

    @GetMapping("{id}")
    public User findById (@PathVariable long id) {
        return userService.findById(id);
    }

    @PutMapping("update={id}")
    public void atualizaUser (@PathVariable long id, @RequestBody User user) {
        userService.atualizaUser(id, user);
    }

    @PostMapping("/login")
    public String login (@RequestBody User user) {
        String login = user.getLogin();
        String password = user.getPassword();
        String logado = userService.login(login, password);
        System.out.println(logado);
        return logado;
    }

}
