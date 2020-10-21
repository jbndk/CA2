package dto;

import entities.Hobby;
import entities.Person;
import java.util.List;

/**
 *
 * @author claes
 */
public class PersonDTO {
    private String email;
    private String fName;
    private String lName;
    private String street;
    private String zip;
    private String hobbyName;
    private int phNumber;
    private List<Hobby>hobbies;

    public PersonDTO(String fName, String lName,String street, String zip) {
        this.fName = fName;
        this.lName = lName;
        this.phNumber = phNumber;
        this.street = street;
        this.zip = zip;
    }

    public PersonDTO(String email, String fName, String lName, String street, String zip, String hobbyName, int phNumber) {
        this.email = email;
        this.fName = fName;
        this.lName = lName;
        this.street = street;
        this.zip = zip;
        this.hobbyName = hobbyName;
        this.phNumber = phNumber;
    }
    
    
    public PersonDTO(Person p) {
        this.email = p.getEmail();
        this.fName = p.getFirstName();
        this.lName = p.getLastname();
        this.street = p.getAddress().getStreet();
        this.zip = p.getAddress().getCityinfo().getZipCode();
        this.hobbies = p.getHobbies();
    }

    public int getPhNumber() {
        return phNumber;
    }

    public void setPhNumber(int phNumber) {
        this.phNumber = phNumber;
    }
    
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getfName() {
        return fName;
    }

    public String getHobbyName() {
        return hobbyName;
    }

    public void setHobbyName(String hobbyName) {
        this.hobbyName = hobbyName;
    }
    
    

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
    
    

    public String getFname() {
        return fName;
    }

    public void setFname(String fname) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

}