package com.edu.unifacisa.ecommerce.controller;

import com.edu.unifacisa.ecommerce.model.User;
import com.edu.unifacisa.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

//    @RequestMapping(value="/user", method = RequestMethod.GET)
//    public ResponseEntity< List<User> > listarTodosUsuarios(@RequestHeader HttpHeaders headers) {
//        List<User> users = null;
//        try {
//            String sessionToken = headers.get("sessionToken").get(0);
//            users = userService.getAllUsers(sessionToken);
//            if (users != null) {
//                return new ResponseEntity<List<User>>(users, HttpStatus.OK);
//            } else {
//                return new ResponseEntity<List<User>>(users, HttpStatus.UNAUTHORIZED);
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return new ResponseEntity<List<User>>(users, HttpStatus.BAD_REQUEST);
//        }
//    }

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

    @PutMapping("atualiza={id}")
    public void atualizaUser (@PathVariable long id, @RequestBody User user) {
        userService.atualizaUser(id, user);
    }

}
