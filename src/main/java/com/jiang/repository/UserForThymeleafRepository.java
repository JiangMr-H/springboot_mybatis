package com.jiang.repository;

import com.jiang.Entity.UserForThymeleaf;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserForThymeleafRepository extends CrudRepository<UserForThymeleaf,Long> {
    /**
     * 新增或者修改用户
     * @param user
     * @return
     */
    UserForThymeleaf save(UserForThymeleaf user);

    /**
     * 删除用户
     * @param id
     */
    void deleteById(Long id);

    /**
     * 根据用户id获取用户
     * @param id
     * @return
     */
    UserForThymeleaf findAllById(Long id);

    /**
     * 获取所有用户的列表
     * @return
     */
    List<UserForThymeleaf> findAll();


}
