package com.cesur.splinterio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cesur.splinterio.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
