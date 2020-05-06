package com.jiang.repository;

import com.jiang.Entity.User;
import com.jiang.Entity.UserForJpa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserForJpa,Long> {

    public List<UserForJpa> findAll();

}
