package facades;

import dto.PersonDTO;
import entities.Address;
import entities.CityInfo;
import entities.Hobby;
import entities.Person;
import entities.Phone;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator;

@Disabled
public class PersonFacadeTest {
    private static EntityManagerFactory emf;
    private static PersonFacade facade;
    
    /*
    @BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        EntityManager em = emf.createEntityManager();
        facade = PersonFacade.getPersonFacade(emf);
        
        Person p1 = new Person("yrsalarsen@gmail.com","Yrsa","Larsen");
        
        Phone ph1 = new Phone(77449982,"privat");
        Phone ph2 = new Phone(77449980,"kontor");
        
        CityInfo c1 = new CityInfo(2820,"Gentofte");
        
        Address a1 = new Address("Store Gade 7","hjem");

        Hobby h1 = new Hobby("Tennis","Description here");
        Hobby h2 = new Hobby("Skiing","Description here");
        
        p1.addHobby(h1);
        p1.addHobby(h2);
        
        a1.setCityinfo(c1);
  
        a1.addPerson(p1);
        
        p1.addTelNo(ph1);
        p1.addTelNo(ph2);

        em.getTransaction().begin();
        em.persist(p1);
        em.getTransaction().commit();
    }
    
    @AfterAll
    public static void tearDownClass() {
    //Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }
    
    @Test
    public void testGetPersonByPhone() {
        PersonDTO actual = facade.getPersonByPhone(77449980);
        PersonDTO expected = new PersonDTO("Yrsa", "Larsen", "Store Gade 7");
        assertEquals(expected.getfName(), actual.getfName());
        assertEquals(expected.getlName(), actual.getlName());
        assertEquals(expected.getStreet(), actual.getStreet());
    }*/
}