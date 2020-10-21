package facades;

import dto.PersonDTO;
import dto.PersonsDTO;
import entities.Address;
import entities.CityInfo;
import entities.Hobby;
import entities.Person;
import entities.Phone;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class PersonFacade {

    private static PersonFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    public PersonFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static PersonFacade getPersonFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new PersonFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public PersonsDTO getAllPersons() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p", Person.class);
            List<Person> list = query.getResultList();
            PersonsDTO result = new PersonsDTO(list);
            return result;
            //Query query = em.createQuery("SELECT new dto.PersonDTO(p.firstName, p.lastname) FROM Person p");
            //return new PersonsDTO(query.getResultList());
        } finally {
            em.close();
        }
    }

    public PersonDTO getPersonByPhone(int phone) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p WHERE p.id = (SELECT h.person.id FROM Phone h WHERE h.number = :phone)", Person.class);
            query.setParameter("phone", phone);
            Person person = query.getSingleResult();
            return new PersonDTO(person.getFirstName(), person.getLastname(), person.getAddress().getStreet(), person.getAddress().getCityinfo().getZipCode());
        } finally {
            em.close();
        }
    }

    public PersonsDTO getAllPersonsByHobby(String hobby) {
        EntityManager em = getEntityManager();
        try {

            TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p INNER JOIN p.hobbies Hobby WHERE Hobby.hobbyName = :hobby", Person.class);
            query.setParameter("hobby", hobby);
            List<Person> resultList = query.getResultList();
            PersonsDTO result = new PersonsDTO(resultList);
            return result;
        } finally {
            em.close();
        }
    }

    public PersonDTO addPerson(PersonDTO p) {
        EntityManager em = emf.createEntityManager();
        Person person = new Person(p.getEmail(), p.getFname(), p.getlName());
        PersonDTO pdto = null;
        try {
            TypedQuery<CityInfo> query1 = em.createQuery("Select c from CityInfo c where c.zipCode = :zip", CityInfo.class);
            query1.setParameter("zip", p.getZip());
            CityInfo cityInfo = query1.getSingleResult();
            Address address = new Address(p.getStreet());
            address.setCityinfo(cityInfo);
            Phone ph = new Phone(p.getPhNumber());

            person.addTelNo(ph);

            person.setAddress(address);

            TypedQuery<Hobby> query2 = em.createQuery("Select h from Hobby h where h.name = :name", Hobby.class);
            query2.setParameter("name", p.getHobbyName());
            Hobby hobby = query2.getSingleResult();

            person.addHobby(hobby);

            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
            pdto = new PersonDTO(person);

        } finally {
            em.close();
        }
        return pdto;

    }
}
