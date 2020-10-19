package entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Claus
 */

@Entity
@NamedQuery(name = "CityInfo.deleteAllRows", query = "DELETE from CityInfo")
public class CityInfo implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int zipCode;
    private String city;

    @OneToMany(mappedBy = "cityInfo", cascade =
    {
        CascadeType.MERGE, CascadeType.PERSIST
    })
    private Set<Address> addresses = new HashSet();


    public CityInfo()
    {
    }

    public CityInfo(int zipCode, String city)
    {
        this.zipCode = zipCode;
        this.city = city;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getZipCode()
    {
        return zipCode;
    }

    public void setZipCode(int zipCode)
    {
        this.zipCode = zipCode;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

 
    @Override
    public String toString()
    {
        return "CityInfo{" + "zipCode=" + zipCode + ", city=" + city + '}';
    }

}

