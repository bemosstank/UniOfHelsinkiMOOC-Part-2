/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ensia
 */
import java.util.*;

public class Employees {

    private List<Person> list;

    public Employees() {
        this.list = new ArrayList<>();
    }

    public void add(Person personsToAdd) {
        this.list.add(personsToAdd);
    }

    public void add(List<Person> peopleToAdd) {
        this.list = peopleToAdd;
    }

    public void print() {
        this.list.stream().forEach(persons-> System.out.println(persons));
    }

    public void print(Education education) {
        Iterator<Person> persons = this.list.iterator();
        while (persons.hasNext()) {
            Person person = persons.next();
            if (person.getEducation() == education) {
                System.out.println(person);
            }
        }
    }

    public void fire(Education education) {
        Iterator<Person> persons = this.list.iterator();
        while (persons.hasNext()) {
            if (persons.next().getEducation() == education) {
                persons.remove();
            }
        }
    }
}
