package com.company.persons;

import com.company.Gender;

public class Professor extends Person {

    public Professor(String name, Gender gender, String bio, int age,Group group) {
        super(name, gender, bio, age, group);
    }

    @Override
    public String toString() {
        return "Professor{" + super.toString() + "}";
    }
}
