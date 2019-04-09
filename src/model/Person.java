package model;

import java.io.Serializable;

/*
You have to make sure that this class implements "Serializable"
Otherwise you will get an error when you are trying to save and load.
 */

public class Person implements Serializable {
    public static int count = 0;

    private int id;
    private String name;
    private String occupation;
    private AgeCategory ageCategory;
    private EmploymentCategory empCat;
    private String taxID;
    private boolean usCitizen;
    private Gender gender;

    public Person(String name, String occupation, AgeCategory ageCategory,
                  EmploymentCategory employmentCategory, String taxID,
                  boolean usCitizen, Gender gender){
        this.name = name;
        this.occupation = occupation;
        this.ageCategory = ageCategory;
        this.empCat = employmentCategory;
        this.taxID = taxID;
        this.usCitizen = usCitizen;
        this.gender = gender;

        // Every time a new person is created, it will increment the count thus increasing the id
        this.id = count;
        count++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public AgeCategory getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(AgeCategory ageCategory) {
        this.ageCategory = ageCategory;
    }

    public EmploymentCategory getEmpCat() {
        return empCat;
    }

    public void setEmpCat(EmploymentCategory empCat) {
        this.empCat = empCat;
    }

    public String getTaxID() {
        return taxID;
    }

    public void setTaxID(String taxID) {
        this.taxID = taxID;
    }

    public boolean isUsCitizen() {
        return usCitizen;
    }

    public void setUsCitizen(boolean usCitizen) {
        this.usCitizen = usCitizen;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
