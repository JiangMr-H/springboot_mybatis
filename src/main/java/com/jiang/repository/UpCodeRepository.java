package com.jiang.repository;

import com.jiang.Entity.Code;
import com.jiang.Entity.UserForJpa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UpCodeRepository extends JpaRepository<Code,Integer> {

    List<Code> queryUpCodeByTau(String tap);

    List<Code> findAll();


}
