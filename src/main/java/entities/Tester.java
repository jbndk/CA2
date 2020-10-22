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
    private static final PersonFacade FACADE = PersonFacade.getPersonFacade(EMFC);

    public static void main(String[] args) {
        
        
        
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

        EntityManager em = emf.createEntityManager();
        
        /*
        //DATABASE SET-UP:
        
        PersonDTO p1 = new PersonDTO("bg@ms.com", "Bill", "Gates", "Strandvejen 1", "2900", "Skak", 1234);
        PersonDTO p2 = new PersonDTO("hans@ms.com", "Hans", "Smith", "Strandvejen 48", "2100", "Skak", 1122);
        PersonDTO p3 = new PersonDTO("bente@ms.com", "Bente", "Jensen", "Byvej 3", "2800", "Astrologi", 3344);
        PersonDTO p4 = new PersonDTO("mariam1982@hotmail.com", "Maria", "Madsen", "Søvej 2", "4800", "Astrologi", 3344);
        PersonDTO p5 = new PersonDTO("dave2004@hotmail.com", "David", "Eskelund", "Troelsgaardsvej 124B", "2820", "Astrologi", 3344);
        PersonDTO p6 = new PersonDTO("kiarra1983@hotmail.com", "Kia", "Rasted", "Lysbygade 24", "4684", "Astrologi", 3344);
        PersonDTO p7 = new PersonDTO("cornell1979@hotmail.com", "Chris", "Nelli", "Bygaden 1", "4700", "Astrologi", 3344);
        PersonDTO p8 = new PersonDTO("fae1990@yahoo.com", "Frank", "Andersen", "Røvervænget 40", "2800", "Astrologi", 3344);
        PersonDTO p9 = new PersonDTO("emmie19731988@yahoo.com", "Emmie", "Petersen", "Saksegade 3", "2100", "Astrologi", 3344);
        PersonDTO p10 = new PersonDTO("mohammad_greenho@gmail.com", "Mohammad", "Jensen", "Øverupvej 583", "2880", "Astrologi", 3344);
        
        FACADE.addPerson(p1);
        FACADE.addPerson(p2);
        FACADE.addPerson(p3);
        FACADE.addPerson(p4);
        FACADE.addPerson(p5);
        FACADE.addPerson(p6);
        FACADE.addPerson(p7);
        FACADE.addPerson(p8);
        FACADE.addPerson(p9);
        FACADE.addPerson(p10);
        */
        
        
        /*
                PersonsDTO pdto = FACADE.getAllPersons();
        pdto.getAll().forEach(p -> {
            System.out.println("Person first name: " + p.getFname());
        });

        PersonDTO pdto1 = new PersonDTO("bg@ms.com", "Bill", "Gates", "Strandvejen 1", "2900", "Skak", 1234);
        PersonDTO pdto2 = new PersonDTO("hans@ms.com", "Hans", "Smith", "Strandvejen 48", "2100", "Skak", 1122);
        PersonDTO pdto3 = new PersonDTO("bente@ms.com", "Bente", "Jensen", "Byvej 3", "2800", "Astrologi", 3344);

        FACADE.addPerson(pdto1);
        FACADE.addPerson(pdto2);
        FACADE.addPerson(pdto3);
        
        PersonsDTO persons = FACADE.getAllPersonsByHobby("Skak");
        persons.getAll().forEach(p -> {
            System.out.println("Persons with hobby SKAK: " + p.getfName());
        });
        
        PersonsDTO persons2 = FACADE.getAllPersonsByHobby("Astrologi");
        persons2.getAll().forEach(p -> {
            System.out.println("Persons with hobby ASTROLOGI: " + p.getfName());
        });
        
        */
        
        /*
        Long antal = FACADE2.getCityCount();
        System.out.println(antal);
        CityInfosDTO cities = FACADE2.getAllCities();
        
        cities.getAll().stream().forEach(System.out::println);
*/
        /*
        em.getTransaction().begin();
        em.persist(p1);
        em.persist(p2);
        em.getTransaction().commit();
         
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
        */
    }

}
