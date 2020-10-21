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

        PersonDTO pdto1 = new PersonDTO("bg@ms.com", "Bill", "Gates", "Strandvejen 1", "2900", "Skak", 1234);

        //FACADE.addPerson(pdto1);
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
