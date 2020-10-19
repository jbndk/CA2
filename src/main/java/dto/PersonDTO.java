package dto;

/**
 *
 * @author claes
 */
public class PersonDTO {
    
    private String fname;
    private String lName;

    public PersonDTO(String fname, String lName) {
        this.fname = fname;
        this.lName = lName;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }
    
    
    
}
