package com.example.demo.model;

import java.util.HashMap;
import java.util.Map;

public class ClassContainer {
    private final Map<String, ClassTeacher> container;

    public ClassContainer() {
        this.container = new HashMap<>();
    }

    // a) dodanie nowej grupy nauczycieli
    public void addClass(String groupName, int maxNumberOfTeacher) {
        if (container.containsKey(groupName)) { // sprawdzenie, czy grupa już istnieje
            System.out.println("Grupa " + groupName + " już istnieje.");
        } else {
            ClassTeacher newClass = new ClassTeacher(groupName, maxNumberOfTeacher);
            container.put(groupName, newClass); // dodanie grupy do mapy
            System.out.println("Dodano grupę: " + groupName + " z maksymalną liczbą nauczycieli: " + maxNumberOfTeacher);
        }
    }

    // dodatkowa metoda dodająca nauczyciela do grupy
    public void addTeacherToClass(String groupName, Teacher teacher) {
        ClassTeacher group = container.get(groupName);
        if (group != null) {
            group.addTeacher(teacher); // dodanie nauczyciela do grupy
        } else {
            System.out.println("Nie znaleziono grupy: " + groupName);
        }
    }

    // b) usunięcie grupy nauczycieli
    public void removeClass(String groupName) {
        if (container.containsKey(groupName)) {
            container.remove(groupName);
            System.out.println("Usunięto grupę: " + groupName);
        } else {
            System.out.println("Nie znaleziono grupy: " + groupName);
        }
    }

    // c) wyszukiwanie pustej grupy nauczycieli
    public void findEmpty() {
        System.out.println("Puste grupy:");
        for (Map.Entry<String, ClassTeacher> entry : container.entrySet()) {
            if (entry.getValue().getTeachers() == 0) {
                System.out.println("Grupa " + entry.getKey() + " jest pusta.");
            }
        }
    }

    // d) wyszukiwanie grupy nauczycieli po nazwie i jej procentowe zapełnienie
    public void summary() {
        for (Map.Entry<String, ClassTeacher> entry : container.entrySet()) {
            String groupName = entry.getKey();
            ClassTeacher group = entry.getValue();
            int currentSize = group.getTeachers();
            int maxSize = group.getMaxNumberOfTeacher();
            double percentage = ((double) currentSize / maxSize) * 100;
            System.out.println("Grupa " + groupName + " jest zapełniona w " + percentage + "%.");
        }
    }

    public Map<String, ClassTeacher> getAll() {
        return container;
    }
}
