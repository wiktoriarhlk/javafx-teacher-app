package com.example.demo.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ClassTeacher {
    private final String groupName;
    private final List<Teacher> teachers;
    private final int maxNumberOfTeacher;

    public ClassTeacher(String groupName, int maxNumberOfTeacher) {
        this.groupName = groupName;
        this.maxNumberOfTeacher = maxNumberOfTeacher;
        this.teachers = new ArrayList<>();
    }


    // a) Dodawanie nauczyciela do grupy
    public boolean addTeacher(Teacher newTeacher) {
        if (teachers.size() >= maxNumberOfTeacher) {
            System.out.println("Nie można dodać nauczyciela. Osiągnięto maksymalną liczbę nauczycieli w grupie " + groupName + ".");
            return false;
        }

        if (teachers.contains(newTeacher)) {
            System.out.println("Nauczyciel " + newTeacher.getName() + " " + newTeacher.getSurname() + " już istnieje w grupie " + groupName + ".");
            return false;
        }

        teachers.add(newTeacher);
        System.out.println("Dodano nauczyciela: " + newTeacher.getName() + " " + newTeacher.getSurname() + " do grupy " + groupName + ".");
        return false;
    }

    // metoda pomocnicza do wypisywania wszystkich nauczycieli w grupie
    public void printAllTeachers() {
        System.out.println("Nauczyciele w grupie: " + groupName);
        for (Teacher t : teachers) {
            t.printing();
        }
    }

    // b) Dodawanie wynagrodzenia do pensji nauczyciela
    public static void addSalary(Teacher t, double amount) {
           t.addSalary(amount);
                System.out.println("Zwiększono pensję nauczycielowi " + t.getName() + " " + t.getSurname() +
                        " o " + amount + ". Nowa pensja: " + t.getSalary());
            }

    // c) Usuwanie nauczyciela
    public static void removeTeacher(List<Teacher> list, Teacher target) {
        list.remove(target);
            System.out.println("Usunięto nauczyciela: " + target.getName() + " " + target.getSurname());
    }

    // d) Zmiana stanu nauczyciela
    public static void changeCondition(List<Teacher> list, Teacher teacher, TeacherCondition newCondition) {
        teacher.setCondition(newCondition);
                System.out.println("Zmieniono stan nauczyciela " + teacher.getName() + " " + teacher.getSurname() + " na " + newCondition + ".");
                return;
    }

    // e) Sprawdzanie czy nauczyciel istnieje
    public static void search(List<Teacher> list, String surname) {
        for (Teacher t : list) {
            if (t.getSurname().equalsIgnoreCase(surname)) {
                System.out.println("Nauczyciel o nazwisku " + t.getSurname() + " istnieje na liście.");
                return;
            }
        }
        System.out.println("Nauczyciel o nazwisku " + surname + " nie istnieje na liście.");
    }

    // f) Wyszukiwanie fragmentu nazwiska lub imienia
    public static void searchPartial(List<Teacher> list, String query) {
        boolean found = false;
        for (Teacher t : list) {
            if (t.getSurname().toLowerCase().contains(query.toLowerCase()) ||
                    t.getName().toLowerCase().contains(query.toLowerCase())) {
                System.out.println("Znaleziono nauczyciela: " + t.getName() + " " + t.getSurname());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Brak dopasowania.");
        }
    }

    // g) zwracanie liczby naczycieli o danym stanie
    public static void countByCondition(List<Teacher> list, TeacherCondition condition) {
        int count = 0;
        for (Teacher t : list) {
            if (t.getCondition() == condition) {
                count++;
            }
        }
        System.out.println("Liczba nauczycieli w stanie " + condition + ": " + count);
    }

    // h) wypisanie informacji o wszystkich nauczycielach
    public static void summary(List<Teacher> list) {
        for (Teacher t : list) {
            System.out.println(t.toString());
        }
    }

    // i) posortowanie nauczycieli alfabetycznie po nazwisku
    public static void sortBySurname(List<Teacher> list) {
        Collections.sort(list); // z użyciem Comparable i metody compareTo do obiektu Teacher
        System.out.println("Nauczyciele posortowani alfabetycznie po nazwisku:");
        for (Teacher t : list) {
            System.out.println(t.toString());
        }
    }

    //gettery do classContainer
    public int getTeachers() {
        return teachers.size();
    }

    public int getMaxNumberOfTeacher() {
        return maxNumberOfTeacher;
    }

    public String getGroupName() {
        return groupName;
    }

    public List<Teacher> getTeacherList() {
        return new ArrayList<>(teachers); // zakładając, że `teachers` to np. Set lub List
    }

    // j) posortowanie naczycieli po wynagrodzeniu malejąco
    public static class SalaryComparator implements Comparator<Teacher> {
        @Override
        public int compare(Teacher t1, Teacher t2) {
            double salary = t1.getSalary() - t2.getSalary();
            if (salary == 0) {
                return t1.getSurname().compareTo(t2.getSurname());
            } else if (salary > 0) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    public static void sortBySalary(List<Teacher> list) {
        list.sort(new SalaryComparator());
        System.out.println("Nauczyciele posortowani po wynagrodzeniu malejąco:");
        for (Teacher t : list) {
            System.out.println(t.toString());
        }
    }

    // k) metoda Collections.max
    public static Teacher getMaxSalary(List<Teacher> list) {
        Teacher maxSalaryTeacher = Collections.max(list, new SalaryComparator().reversed());
        System.out.println("Nauczyciel z najwyższą pensją: " + maxSalaryTeacher.toString());
        return maxSalaryTeacher;
    }




}
