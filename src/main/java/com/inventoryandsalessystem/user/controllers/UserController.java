package com.inventoryandsalessystem.user.controllers;

import com.inventoryandsalessystem.user.entities.User;
import com.inventoryandsalessystem.user.services.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserServiceI userServiceI;

    @PostMapping("/users/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<User>(userServiceI.createUser(user), HttpStatus.OK);
    }

    @GetMapping("/users/{user_id}")
    public ResponseEntity<User> findUser(@PathVariable Long user_id) {
        return new ResponseEntity<User>(userServiceI.findUserById(user_id), HttpStatus.OK);
    }

    @PutMapping("/users/{user_id}")
    public ResponseEntity<User> updateUser(@RequestBody User user,
                                           @PathVariable Long user_id // maybe it will be deleted
    ) {
        return new ResponseEntity<User>(userServiceI.updateUser(user,user_id), HttpStatus.OK);
    }

    @DeleteMapping("/users/{user_id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long user_id) {
       return new ResponseEntity<>(userServiceI.deleteUser(user_id),HttpStatus.OK);
    }

   /*
    Probablemente, además de un UUID hay que agregar otro identificador, una lista de identificadores.
   */

}
