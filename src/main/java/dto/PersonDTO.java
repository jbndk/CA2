package dto;

import entities.Person;

/**
 *
 * @author claes
 */
public class PersonDTO {
    
    private String fName;
    private String lName;
    private String street;

    public PersonDTO(String fname, String lName, String street) {
        this.fName = fname;
        this.lName = lName;
        this.street = street;
    }

    PersonDTO(Person p) {
        this.fName = p.getFirstName();
        this.lName = p.getLastname();
        this.street = p.getAddress().getStreet();
    }

    public PersonDTO() {
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }
    
        public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
    
}
