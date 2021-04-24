package com.company.persons;

import com.company.Gender;
import com.company.WrongGrade;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person implements Comparable<Student>{

    private List<Integer> grades = new ArrayList<>();
    private double averageGrades;


    public Student(String name, Gender gender, String bio, int age, Group group, List<Integer> grades) {
        super(name, gender, bio, age, group);
        this.grades = grades;
    }

    public void averageGrades() throws WrongGrade {
        if (grades.size() > 0) {
            double sumGrades = 0;
            double numberOfNotes = 0;
            for (Integer grade : grades) {
                if (grade < 1 || grade > 10) {
                    throw new WrongGrade("The value need to be between 1 and 10...");
                }
                sumGrades += grade;
                numberOfNotes++;
            }
            this.averageGrades = sumGrades / numberOfNotes;
        } else {
            System.out.println("The student has no grades...");
        }
    }
    public List<Integer> getGrades() {
        return grades;
    }

    public void setGrades(List<Integer> grades) {
        this.grades = grades;
    }

    public double getAverageGrades() {
        return averageGrades;
    }

    public void setAverageGrades(double averageGrades) {
        this.averageGrades = averageGrades;
    }

    @Override
    public String toString() {
        String gradesList = "";
        for (Integer grade : grades) {
            gradesList += grade + " ";
        }
        return "Student{" +
                super.toString() +
                ", grades=" + gradesList +
                ", averageGrades=" + averageGrades +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return getName().compareTo(o.getName());
    }
}
