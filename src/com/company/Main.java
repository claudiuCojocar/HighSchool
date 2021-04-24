package com.company;

import com.company.persons.Group;
import com.company.persons.Professor;
import com.company.persons.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Professor> professors = populateWithProfessors();
        displayProfessors(professors);

        List<Student> students = populateWithStudents();
        displayStudents(students);

        calculateAverageGrades(students);
        bestStudents(students);
        majorStudents(students);
        showBestStudent(students);

        showAllStudents(students);
        deleteStupids(students);
        showAllStudents(students);

        showByGroups(students,professors);

        numberOfStudentsByGroups(students);

        sortByName(students);
        showAllStudents(students);

        reverseByName(students);
        showAllStudents(students);
    }
    private static void reverseByName(List<Student> students){
        Collections.reverse(students);
    }
    private static void sortByName(List<Student> students){
        Collections.sort(students);
    }
    private static void numberOfStudentsByGroups(List<Student> students){
        for(Group group:Group.values()){
            int numberOfStudents = 0;
            for(Student student:students){
                if(student.getGroup().equals(group)){
                    numberOfStudents++;
                }
            }
            System.out.println("GROUP "+group+" :"+numberOfStudents);
        }
        System.out.println();
    }
    private static void showByGroups(List<Student> students, List<Professor> professors){
        System.out.println("GROUPS WITH PROFESSOR AND STUDENTS\n");
        for (Group group:Group.values()) {
            System.out.println("GROUP: "+group);
            for (Professor professor:professors) {
                if(professor.getGroup().equals(group)){
                    System.out.println(professor.toString());
                }
            }
            for (Student student:students){
                if(student.getGroup().equals(group)){
                    System.out.println(student.toString());
                }
            }
            System.out.println();
        }
    }
    private  static void showAllStudents(List<Student> students){
        for (Student student:students) {
            System.out.println(student.toString());
        }
        System.out.println();
    }
    private static void deleteStupids(List<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getAverageGrades() < 5){
                students.remove(i);
            }
        }
    }

    private static void showBestStudent(List<Student> students) {
        double bestAverageGrades = 0;
        Student bestStudent = null;
        for (Student student : students) {
            if (student.getAverageGrades() > bestAverageGrades) {
                bestStudent = student;
                bestAverageGrades = student.getAverageGrades();
            }
        }
        System.out.println("BEST STUDENT IS:");
        System.out.println(bestStudent.toString()+"\n");
    }

    private static void calculateAverageGrades(List<Student> students) {
        for (Student student : students) {
            try {
                student.averageGrades();
            } catch (WrongGrade wrongGrade) {
                wrongGrade.printStackTrace();
            }
        }
        System.out.println();
    }

    private static void majorStudents(List<Student> students) {
        System.out.println("MAJOR STUDENT OF OURS COLLEGE:");
        for (Student student : students) {
            if (student.getAge() >= 18) {
                System.out.println(student.toString());
            }
        }
        System.out.println();
    }

    private static void bestStudents(List<Student> students) {
        System.out.println("BEST STUDENTS OF OURS COLLEGE:");
        for (Student student : students) {
            if (student.getAverageGrades() > 8) {
                System.out.println(student.toString());
            }
        }
        System.out.println();
    }

    private static void displayStudents(List<Student> students) {
        System.out.println("INFORMATION ABOUT STUDENTS:");
        for (Student student : students) {
            student.displayInfo();
        }
    }

    private static void displayProfessors(List<Professor> professors) {
        System.out.println("INFORMATION ABOUT PROFESSORS:");
        for (Professor prof : professors) {
            prof.displayInfo();
        }
    }

    private static List<Professor> populateWithProfessors() {
        List<Professor> professors = new ArrayList<>();
        Professor currentProfessor = new Professor("Mircea Zaciu", Gender.MALE, "BORN TO KILL KIDS", 57, Group.A);
        professors.add(currentProfessor);
        currentProfessor = new Professor("Mariana Chelaru", Gender.FEMALE, "ENGLISH TEACHER, CRAZY", 66, Group.B);
        professors.add(currentProfessor);
        currentProfessor = new Professor("George Baba", Gender.MALE, "HISTORY TEACHER, COUSIN WITH STEFAN CEL MARE", 38, Group.C);
        professors.add(currentProfessor);
        currentProfessor = new Professor("Mirela Ghita", Gender.FEMALE, "SPORT TEACHER, 300 KG PER HAND", 44, Group.D);
        professors.add(currentProfessor);
        currentProfessor = new Professor("Ghiolban Gun", Gender.MALE, "DIRECTOR, KNOW EVERYTHING", 41, Group.RESERVED);
        professors.add(currentProfessor);
        return professors;
    }

    private static List<Student> populateWithStudents() {
        List<Student> students = new ArrayList<>();
        Student currentStudent = new Student("Cojocar Claudiu", Gender.MALE, "OLIMPICUL UNIVERSAL", 18, Group.A, Arrays.asList(10, 10, 10, 9, 10));
        students.add(currentStudent);
        currentStudent = new Student("Cojocar Denisa", Gender.FEMALE, "INVAT DAR DEGEABA", 15, Group.B, Arrays.asList(6, 6, 8, 5, 7));
        students.add(currentStudent);
        currentStudent = new Student("Barba Emilia", Gender.FEMALE, "CONTABILITATEA E VIATA MEA, SI MANELELE", 17, Group.C, Arrays.asList(9, 7, 10, 9, 8));
        students.add(currentStudent);
        currentStudent = new Student("Ciocan Marcel", Gender.MALE, "NU STIU CE CAUT LA LICEU, EU VREA LA STANA", 25, Group.C, Arrays.asList(3, 5, 2, 2, 4));
        students.add(currentStudent);
        currentStudent = new Student("Invatatot Mirela", Gender.FEMALE, "PULA PULA PIZDA PIZDA", 17, Group.D, Arrays.asList(8, 7, 9, 7, 6));
        students.add(currentStudent);
        currentStudent = new Student("Ghiolban Claudiu", Gender.MALE, "ORICE OM ESTE FERICIT", 19, Group.A, Arrays.asList(8, 10, 7, 9, 10));
        students.add(currentStudent);
        currentStudent = new Student("Cojocar Marcel", Gender.MALE, "IMI PLACE BEREA SI ALUNUL", 16, Group.B, Arrays.asList(6, 4, 8, 5, 3));
        students.add(currentStudent);
        currentStudent = new Student("Barba Emanuela", Gender.FEMALE, "SI MANELELE ESTE MUZIK", 21, Group.A, Arrays.asList(9, 5, 6, 9, 8));
        students.add(currentStudent);
        currentStudent = new Student("Cacat Marcel", Gender.MALE, "MI-AS FI DORIT UN AL NUME", 20, Group.C, Arrays.asList(3, 9, 8, 5, 4));
        students.add(currentStudent);
        currentStudent = new Student("Bilabag Mirela", Gender.FEMALE, "CIKA LAKA CIKI CEA", 16, Group.D, Arrays.asList(2, 7, 9, 5, 6));
        students.add(currentStudent);
        return students;
    }
}
