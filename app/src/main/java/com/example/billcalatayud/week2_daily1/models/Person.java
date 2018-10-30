package com.example.billcalatayud.week2_daily1.models;

import java.io.Serializable;

public class Person implements Serializable {



    String name;

    public Person(String name, String age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    String age;
    String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

}
