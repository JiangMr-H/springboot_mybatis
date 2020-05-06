package com.jiang.repository;

import com.jiang.Entity.UserForThymeleaf;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserForThymeleafRepositoryImpl {

    private static AtomicLong counter = new AtomicLong();

    private final ConcurrentMap<Long, UserForThymeleaf> userMap = new ConcurrentHashMap<Long, UserForThymeleaf>();

    public UserForThymeleafRepositoryImpl(){
        UserForThymeleaf u = new UserForThymeleaf();
        u.setId(30);
        u.setName("李四");
        u.setAge(30);
        this.saveOrUpateUser(u);
    }


    public UserForThymeleaf saveOrUpateUser(UserForThymeleaf user) {
        Long id = user.getId();
        if(id<=0){
            id=counter.incrementAndGet();
            user.setId(id);
        }
        this.userMap.put(id,user);
        return user;
    }


    public void deleteUser(Long id) {
        this.userMap.remove(id);
    }


    public UserForThymeleaf getUserById(Long id) {
        return this.userMap.get(id);
    }


    public List<UserForThymeleaf> listUser() {
        return new ArrayList<UserForThymeleaf>(this.userMap.values());
    }
}
