package com.cesur.splinterio.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.cesur.splinterio.models.User;
import com.cesur.splinterio.models.dtos.UserDTO;
import com.cesur.splinterio.repositories.UserRepository;
import com.cesur.splinterio.services.UserService;

public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDTO getUserByEmail(String email) {
        User user = userRepository.getUserByEmail(email).get();
        UserDTO response = new UserDTO();
        response.setActive(user.getActive());
        response.setEmail(user.getEmail());
        response.setId(user.getId());
        response.setLastConnection(user.getLastConnection());
        response.setName(user.getName());
        response.setRol(user.getRol());
        return response;
    }

    @Override
    public void updateUser(UserDTO user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setActive(user.getActive());
        existingUser.setEmail(user.getEmail());
        existingUser.setLastConnection(user.getLastConnection());
        existingUser.setName(user.getName());
        existingUser.setRol(user.getRol());
        userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void storeUser(UserDTO user) {
        User newUser = new User();
        newUser.setActive(user.getActive());
        newUser.setEmail(user.getEmail());
        newUser.setLastConnection(user.getLastConnection());
        newUser.setName(user.getName());
        newUser.setRol(user.getRol());
        userRepository.save(newUser);
    }

}
