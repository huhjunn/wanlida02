package com.helloworld.hellodemo1.pojo;

public class student {
    private String id;
    private Integer age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "student{" +
                "id='" + id + '\'' +
                ", age=" + age +
                '}';
    }
}
