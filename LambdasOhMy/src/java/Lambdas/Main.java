package Lambdas;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void printPersons(
            List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }


    public static void main(String[] args) {
        Person tp, tp1, tp2, tp3, tp4;
        ArrayList<Person> myPeeps = new ArrayList<>();

        tp = new Person("Ricardo Jiminez", LocalDate.of(1990, Month.APRIL, 22), Person.Sex.MALE, "RickyBaby@gmail.com");
        tp1 = new Person("Sarah Jiminez", LocalDate.of(1970, Month.AUGUST, 12), Person.Sex.FEMALE, "SarahBaby@gmail.com");
        tp2 = new Person("Martha Stewart", LocalDate.of(1980, Month.JULY, 18), Person.Sex.MALE, "CookBaby@gmail.com");
        tp3 = new Person("JimBob Johnson", LocalDate.of(2001, Month.MARCH, 7), Person.Sex.MALE, "JimBob@gmail.com");
        tp4 = new Person("Ol Man Tucker", LocalDate.of(2003, Month.MAY, 22), Person.Sex.MALE, "Tuck@gmail.com");
        myPeeps.add(tp1);
        myPeeps.add(tp2);
        myPeeps.add(tp3);
        myPeeps.add(tp4);
        myPeeps.add(tp);


        //Example of a local class
        class checkForOver18 implements CheckPerson {
            @Override  //Function we're implementing from the Interface below
            public Boolean test(Person person) {
                return person.getAge() >= 18;
            }
        }
        printPersons(myPeeps, new checkForOver18());


        //Example using an anonymous class
        printPersons(myPeeps, new CheckPerson() {
            @Override // Function we're implementing from the interface below
            public Boolean test(Person person) {
                return person.getAge() >= 18;
            }
        });


        //Example using an lambdas
        printPersons(myPeeps, person -> person.getAge() >= 45);

    }
}