package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author claes
 */
@Entity
public class CityInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int zip;
    private String city;
    
    @OneToMany(mappedBy = "cityinfo" , cascade = CascadeType.PERSIST)
    List<Address> addresses;

    public CityInfo() {
    }

    public CityInfo(int zip, String city) {
        this.zip = zip;
        this.city = city;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    public void addAddress(Address address) {
        this.addresses.add(address);
        if(address != null) {
            address.setCityinfo(this);
        }
    }

    public List<Address> getAddresses() {
        return addresses;
    }
    
}

