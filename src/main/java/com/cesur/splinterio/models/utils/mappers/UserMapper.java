package com.cesur.splinterio.models.utils.mappers;

import java.time.LocalDateTime;

import com.cesur.splinterio.models.User;
import com.cesur.splinterio.models.dtos.UserDTO;
import com.cesur.splinterio.models.dtos.UserDTOWOP;

public class UserMapper {

    public static UserDTO userToDTO(User user) {
        UserDTO response = new UserDTO();
        if (user != null) {
            response.setId(user.getId());
            response.setName(user.getName());
            response.setEmail(user.getEmail());
            response.setActive(user.getActive());
            response.setLastConnection(user.getLastConnection());
            response.setRol(user.getRol());
            response.setPassword(user.getPassword());
        }
        return response;
    }

    public static UserDTOWOP userToDTOWOP(User user) {
        UserDTOWOP response;
        if (user != null) {
            response = new UserDTOWOP(
                    user.getId(),
                    user.getName(),
                    user.getEmail(),
                    user.getRol(),
                    user.getActive(),
                    user.getLastConnection());
        } else {
            response = new UserDTOWOP();
        }
        return response;
    }

    public static User dtoToUserCreated(UserDTO user) {
        User response = new User();
        if (response != null) {
            response.setId(user.getId());
            response.setName(user.getName());
            response.setEmail(user.getEmail());
            response.setActive(user.getActive());
            response.setRol(user.getRol());
            response.setPassword(user.getPassword());
            

            // response.setDeletedAt();
            // response.setUpdatedAt();
            // response.setLastConnection();
            if(user.getCreatedAt() == null){
                response.setCreatedAt(LocalDateTime.now());
            } else{
                response.setCreatedAt(user.getCreatedAt());
                if (user.getDeletedAt() != null) {
                    response.setDeletedAt(user.getDeletedAt());
                } else if(user.getUpdateAt() != null) {
                    response.setUpdateAt(user.getUpdateAt());
                }
                
            }


        }
        return response;
    }

}
