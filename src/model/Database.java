package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Database {
    private ArrayList<Person> people;

    public Database(){
        people = new ArrayList<Person>();
    }

    public void addPerson(Person person){
        people.add(person);
    }

    public List<Person> getPeople(){
        return people;
    }

    public void saveToFile(File file) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        // Convert the people array list to a regular array.
        Person[] persons = people.toArray(new Person[people.size()]);

        oos.writeObject(persons);

        oos.close();
    }

    public void loadFromFile(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        /*
        Get the persons array from the file.
        Then clear the people array list.
        Then convert the persons array into an array list.
        Finally, place the persons array into the people array list.
         */
        try {

            Person[] persons = (Person[])ois.readObject();

            people.clear();

            people.addAll(Arrays.asList(persons));

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        }

        ois.close();
    }
}
