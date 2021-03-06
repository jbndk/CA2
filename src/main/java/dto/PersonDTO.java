package dto;

import entities.Hobby;
import entities.Person;
import entities.Phone;
import java.util.ArrayList;
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
    private String additInfo;
    private String zip;
    private String hobbyName;
    private int phNumber;
    private String descrip;

    private List<HobbyDTO> hobbies;
    private List<PhoneDTO> phones;

    public PersonDTO(String fName, String lName, String street, String zip) {
        this.fName = fName;
        this.lName = lName;
        this.street = street;
        this.zip = zip;
    }

    public PersonDTO(String email, String fName, String lName) {
        this.email = email;
        this.fName = fName;
        this.lName = lName;
    }

    public PersonDTO(String email, String fName, String lName, String street,
            String additInfo, String zip, String hobbyName, int phNumber, String descrip) {
        this.email = email;
        this.fName = fName;
        this.lName = lName;
        this.street = street;
        this.additInfo = additInfo;
        this.zip = zip;
        this.hobbyName = hobbyName;
        this.phNumber = phNumber;
        this.descrip = descrip;
        this.hobbies = new ArrayList<>();
        this.phones = new ArrayList<>();
    }

    public PersonDTO(Person p) {
        this.email = p.getEmail();
        this.fName = p.getFirstName();
        this.lName = p.getLastname();
        this.street = p.getAddress().getStreet();
        this.zip = p.getAddress().getCityinfo().getZipCode();
        this.hobbies = new ArrayList();
        for (Hobby hobby : p.getHobbies()) {
            this.hobbies.add(new HobbyDTO(hobby));
        }
        this.phones = new ArrayList<>();
        for (Phone ph : p.getTelNos()) {
            this.phones.add(new PhoneDTO(ph));
        }
    }

    public String getAdditInfo() {
        return additInfo;
    }

    public void setAdditInfo(String additInfo) {
        this.additInfo = additInfo;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public List<PhoneDTO> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneDTO> phones) {
        this.phones = phones;
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

    public List<HobbyDTO> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<HobbyDTO> hobbies) {
        this.hobbies = hobbies;
    }
}
