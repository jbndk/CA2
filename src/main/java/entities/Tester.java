package entities;

import dto.PersonDTO;
import dto.PersonsDTO;
import facades.PersonFacade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import utils.EMF_Creator;

/**
 *
 * @author claes
 */

public class Tester {
    
        private static final EntityManagerFactory EMFC = EMF_Creator.createEntityManagerFactory();
        private static final PersonFacade FACADE =  PersonFacade.getPersonFacade(EMFC);
                
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

        EntityManager em = emf.createEntityManager();
        
        Person p1 = new Person("claesvonh@gmail.com","Claes","Lindholm");
        Person p2 = new Person("th@ambrox.com","Torben","Helstrup");
        
        Phone ph1 = new Phone(1234,"privat");
        Phone ph2 = new Phone(5678,"kontor");
        Phone ph3 = new Phone(8888,"mobil");
        Phone ph4 = new Phone(7777,"handy");
        
        CityInfo c1 = new CityInfo(2820,"Gentofte");
        CityInfo c2 = new CityInfo(2100,"Østerbro");
        
        Address a1 = new Address("Kildeskovsvej 53","hjem");
        Address a2 = new Address("Østerbrogade 1", "kontor");
        
        Hobby h1 = new Hobby("Golf","boring");
        Hobby h2 = new Hobby("Fishing","wet");
        
        p1.addHobby(h1);
        p2.addHobby(h2);
        
        a1.setCityinfo(c1);
        a2.setCityinfo(c2);
        
        a1.addPerson(p1);
        a2.addPerson(p2);
        
        p1.addTelNo(ph1);
        p1.addTelNo(ph3);
        p2.addTelNo(ph2);
        p2.addTelNo(ph4);
        
        /*
        em.getTransaction().begin();
        em.persist(p1);
        em.persist(p2);
        em.getTransaction().commit();
        */
      
        TypedQuery<Phone> q1 = em.createQuery("SELECT p FROM Phone p", Phone.class);
        
        List<Phone> phones = q1.getResultList();
        
        phones.forEach(p -> {
            System.out.println(p.getPerson().getFirstName() + ", " + p.getPerson().getLastname() + ", Numbers: " + p.getNumber());
        });
        
        
        PersonsDTO pdto = FACADE.getAllPersons();
        
        pdto.getAll().forEach(p -> {
            System.out.println("First name: " + p.getfName() + ". Last name: " + p.getlName());
        });
        
        PersonDTO pdto2 = FACADE.getPersonByPhone(7777);
        
        System.out.println("First name by phone: " + pdto2.getfName() + ". Address: " + pdto2.getStreet());
        
             
    }

}
