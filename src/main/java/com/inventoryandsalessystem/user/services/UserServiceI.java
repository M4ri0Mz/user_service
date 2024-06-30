package com.inventoryandsalessystem.user.services;

import com.inventoryandsalessystem.user.entities.User;

public interface UserServiceI {
    // create
    public User createUser(User user);
    // update
    public User updateUser(User user, Long user_id);
    // delete
    public String deleteUser(Long userId);
    // find
    public User findUserById(Long userId);
}
