package com.inventoryandsalessystem.user.services.impl;

import com.inventoryandsalessystem.user.entities.User;
import com.inventoryandsalessystem.user.exeptions.errors.UserNotFound;
import com.inventoryandsalessystem.user.repositories.UserRepository;
import com.inventoryandsalessystem.user.services.UserServiceI;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class UserServiceImpl implements UserServiceI {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user, Long user_id) {

        User userToUpdate = userRepository.findById(user_id)
                .orElseThrow( ()-> new UserNotFound("User not found"));

        userToUpdate .setName(user.getName());
        userToUpdate .setLastName(user.getLastName());
        userToUpdate.setTelephone(user.getTelephone());
        userToUpdate .setEmail(user.getEmail());
        userToUpdate .setRole(user.getRole());

        return userRepository.save(userToUpdate );
    }

    @Override
    public String deleteUser(Long userId) {

        userRepository.findById(userId)
                .orElseThrow(()-> new UserNotFound("User not found"));
        userRepository.deleteById(userId);

        return "User deleted successfully";
    }

    @Override
    public User findUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow( ()-> new UserNotFound("User not found"));
    }
}
