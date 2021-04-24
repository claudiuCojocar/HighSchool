package com.company.persons;

import com.company.DisplayPersonInfo;
import com.company.Gender;

public class Person implements DisplayPersonInfo {

    private String name;
    private Gender gender;
    private String bio;
    private int age;
    private Group group;

    public Person(String name, Gender gender, String bio, int age,Group group) {
        this.name = name;
        this.gender = gender;
        this.bio = bio;
        this.age = age;
        this.group = group;
    }

    @Override
    public void displayInfo() {
        System.out.println("Name and description:\n" + name + "\n" + bio + "\n");
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", gender=" + gender +
                ", bio='" + bio + '\'' +
                ", age=" + age +
                ", group=" + group ;
    }
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
