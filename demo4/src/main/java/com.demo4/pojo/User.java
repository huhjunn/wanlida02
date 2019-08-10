package com.demo4.pojo;

public class User {
    private Integer user;
    private String name;
    private Integer age;

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "user=" + user +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
