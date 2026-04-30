package com.example.demo.model;

public class Teacher implements Comparable<Teacher> {
    private final String name;
    private final String surname;
    private TeacherCondition condition;
    private final int birthYear;
    private double salary;

    public Teacher(String name, String surname, TeacherCondition condition, int birthYear, double salary) {
        this.name = name;
        this.surname = surname;
        this.condition = condition;
        this.birthYear = birthYear;
        this.salary = salary;
    }

    public String toString() {
        return "Nauczyciel: " + name + " " + surname + ", stan: " + condition + ", wiek: " + birthYear + ", pensja: " + salary;
    }

    public void printing() {
        System.out.println(toString());
    }

    // metoda compareTo do interfejsu Comparable
    @Override
    public int compareTo(Teacher teacher) {
        int compareSurname = surname.compareTo(teacher.surname);
        if(compareSurname == 0) {
            return name.compareTo(teacher.name); //jeżeli nazwiska są takie same to porównujemy imiona
        }
        else {
            return compareSurname;
        }
    }

    // gettery i settery
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public TeacherCondition getCondition() {
        return condition;
    }

    public void addSalary(double salary) {
        this.salary += salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setCondition(TeacherCondition newCondition) {
        this.condition = newCondition;
    }

    public Double getSalary() {
        return salary;
    }

    public int getBirthYear() {
        return birthYear;
    }
}


