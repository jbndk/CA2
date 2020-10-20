package entities;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author claes
 */
public class Tester {

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
        
        /*
        TypedQuery<Person> q2 = em.createQuery("SELECT p FROM Person p", Person.class);
        
        List<Person> persons = q2.getResultList();
        
        persons.forEach(p -> {
            System.out.println("Email: "+p.getEmail()+", Name: "+p.getFirstName()+" "+p.getLastname()+", Address: "+p.getAddress().getStreet()+
            ", "+p.getAddress().getCityinfo().getCity()+", "+p.getAddress().getCityinfo().getZip()+", Tel.nos: "+p.getTelNos().toString());
        });
        */
    }

}
