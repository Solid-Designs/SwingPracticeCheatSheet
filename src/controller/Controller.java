package controller;

import gui.FormEvent;
import model.*;
// Never import gui stuff into your data model.
// Only here in the controller!

public class Controller {
    public void addPerson(FormEvent ev){
        Database db = new Database();

        String name = ev.getName();
        String occupation = ev.getOccupation();
        int ageCatId = ev.getAgeCategory();
        String empCat = ev.getEmpCat();
        boolean isUS = ev.isUsCitizen();
        String taxID = ev.getTaxID();
        String gender = ev.getGender();

        // This is how you change the integer value to the enumeration
        AgeCategory ageCategory = null;

        switch(ageCatId){
            case 0:
                ageCategory = AgeCategory.child;
                break;
            case 1:
                ageCategory = AgeCategory.adult;
                break;
            case 2:
                ageCategory = AgeCategory.senior;
                break;
        }

        EmploymentCategory empCategory;

        if(empCat.equals("employed")){
            empCategory = EmploymentCategory.employed;
        } else if(empCat.equals("self-employed")){
            empCategory = EmploymentCategory.selfEmployed;
        } else if(empCat.equals("unemployed")){
            empCategory = EmploymentCategory.unEmployed;
        } else{
            empCategory = EmploymentCategory.other;
            System.err.println(empCat);
        }

        Gender genderCat;

        if(gender.equals("Male")){
            genderCat = Gender.male;
        } else{
            genderCat = Gender.female;
        }

        // Add all the information that you get from the form event to the person model
        Person person = new Person(name, occupation, ageCategory, empCategory, taxID, isUS, genderCat);

        // Then add the person to the database array list
        db.addPerson(person);
    }
}
