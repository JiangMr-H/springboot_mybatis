package com.jiang.Entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement // mediatype 转为xml
@Entity
public class UserForThymeleaf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; // 用户的唯一标识
    private String name;
    private int age;

    public UserForThymeleaf() {
    }

    public UserForThymeleaf(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
