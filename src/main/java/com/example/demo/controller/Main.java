package com.example.demo.controller;

import com.example.demo.model.Teacher;
import com.example.demo.model.TeacherCondition;

import java.util.ArrayList;
import java.util.List;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Teacher> teachers = new ArrayList<>();

        //Listę nauczycieli
        Teacher teacher1 = new Teacher("Jan", "Kowalski", TeacherCondition.OBECNY, 1998, 7000);
        Teacher teacher2 = new Teacher("Anna", "Nowak", TeacherCondition.DELEGACJA, 1954, 9000);
        Teacher teacher3 = new Teacher("Piotr", "Wiśniewski", TeacherCondition.CHORY, 1999, 8700);
        Teacher teacher4 = new Teacher("Katarzyna", "Dąbrowska", TeacherCondition.NIEOBECNY, 2001, 5500);
        Teacher teacher5 = new Teacher("Marek", "Lewandowski", TeacherCondition.OBECNY, 1986, 15500);

        //dodanie nauczycieli do listy
        teachers.add(teacher1);
        teachers.add(teacher2);
        teachers.add(teacher3);
        teachers.add(teacher4);
        teachers.add(teacher5);

        //wywołanie konkretnego nauczyciela
    /*    teachers.get(3).printing();

        //wywołanie wszystkich nauczycieli
        for (Teacher teacher : teachers) {
            teacher.printing();
        }

*/


        // ZADANIE 3
        //porównanie nauczycieli
        //  - 0 jeżeli nazwiska są takie same
        //  - >0 jeżeli nazwisko pierwszego nauczyciela jest później w alfabecie
        //  - <0 jeżeli nazwisko pierwszego nauczyciela jest wcześniej w alfabecie

     //   System.out.println(teachers.get(4).compareTo(teachers.get(1)));

        //sortowanie wszytkich nauczycieli
     /*   Collections.sort(teachers);
        for (Teacher teacher : teachers) {
            teacher.printing();
        }
*/

        //ZADANIE 4

        //a) dodanie nauczyciela do grupy
   /*   ClassTeacher grupa1 = new ClassTeacher("1A", 3);
        grupa1.addTeacher(teachers.get(0));
        grupa1.addTeacher(teachers.get(1));
        grupa1.addTeacher(teachers.get(0));
        grupa1.addTeacher(teachers.get(4));

        grupa1.printAllTeachers();
*/

        //b) dodanie wynagrodzenia do pensji nauczyciela
       /* teachers.get(0).printing();
         ClassTeacher.addSalary(teachers.get(0), 1000);
        teachers.get(0).printing();
*/
        //c) usuwanie nauczyciela z listy nauczycieli

        /*ClassTeacher.removeTeacher(teachers, teachers.get(3));
        //wywołanie wszystkich nauczycieli
        for (Teacher teacher : teachers) {
            teacher.printing();
        }
        */

        //d) zmiana stanu nauczyciela
        /*teachers.get(2).printing();
        ClassTeacher.changeCondition(teachers, teachers.get(2), TeacherCondition.OBECNY);
        teachers.get(2).printing();
*/
        // e) wyszukiwanie nauczyciela po nazwisku
        //ClassTeacher.search(teachers, "kowalski");

        // f) wyszukiwanie po fragmencie nazwiska
        //ClassTeacher.searchPartial(teachers, "ski");

        // g) ilość nauczycieli o danym stanie
        /*for (Teacher teacher : teachers) {
            teacher.printing();
        }
        ClassTeacher.countByCondition(teachers, TeacherCondition.OBECNY);
*/

        // h) informacje o wszytskich nauczycielach
        //ClassTeacher.summary(teachers);

        // i) posortowanie nauczycieli po nazwisku
        //ClassTeacher.sortBySurname(teachers);

        // j) posortowanie nauczycieli po pensji malejąco
        //ClassTeacher.sortBySalary(teachers);

        // k) nauczyciel z największą pensją
        //ClassTeacher.getMaxSalary(teachers);

        // ZADANIE 5
        //tworzenie kontenera
      /*  ClassContainer container = new ClassContainer();

        // a) dodanie grup nauczycieli
        container.addClass("1A", 3);
        container.addClass("2B", 4);
        container.addClass("1C", 5);

        //dodanie nauczycieli do grupy (dodatkowa metoda)
        container.addTeacherToClass("1A", teachers.get(0));
        container.addTeacherToClass("1A", teachers.get(1));
        container.addTeacherToClass("2B", teachers.get(2));
        container.addTeacherToClass("2B", teachers.get(3));
*/
        // b) usuwanie grupy nauczycieli
        //container.removeClass("1A");

        // c) wyszukiwanie pustej grupy nauczycieli
        //container.findEmpty();

        // d) wypisanie grup i ich procentowe zapełnienie
        //container.summary();



    }
}