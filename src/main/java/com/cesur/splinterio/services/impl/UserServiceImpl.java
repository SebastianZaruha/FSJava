package com.cesur.splinterio.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesur.splinterio.models.User;
import com.cesur.splinterio.models.dtos.UserDTO;
import com.cesur.splinterio.models.utils.mappers.UserMapper;
import com.cesur.splinterio.repositories.UserRepository;
import com.cesur.splinterio.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDTO getUserByEmail(String email) {
        User user = userRepository.getUserByEmail(email).get();

        return UserMapper.instance.userToUserDTOWithoutPass(user);
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
    public void storeUser(UserDTO userFromControl) {
        User userToDB = UserMapper.instance.userDTOToUserDB(userFromControl);
        userRepository.save(userToDB);

    }

}
