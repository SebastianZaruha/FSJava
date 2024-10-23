package com.cesur.splinterio.models.utils.mappers;

import java.time.LocalDateTime;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.cesur.splinterio.models.User;
import com.cesur.splinterio.models.dtos.UserDTO;

@Mapper
public interface UserMapper {

    UserMapper instance = Mappers.getMapper(UserMapper.class);

    // condicion base
    UserDTO userToUserDB(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "updateAt", ignore = true)
    @Mapping(target = "lastConnection", ignore = true)
    User userDTOToUserDB(UserDTO user);

    @Mapping(target = "id", ignore = true)
    User userDTOToUserWithoutId(UserDTO user);

    // condicion compleja
    @Mapping(target = "password", ignore = true)
    UserDTO userToUserDTOWithoutPass(User user);

    // @Mapping(target = "lastConnection", qualifiedByName =
    // "calculateLaseConnection")
    // UserDTO userToUserDTOLastConnection(User user);
    // UserDTO userToUoserDTOLastConnectio(User user);

    // @Named("getCurrentTime")
    // default LocalDateTime calculateLastConnection() {
    // return LocalDateTime.now();
    // }

}
