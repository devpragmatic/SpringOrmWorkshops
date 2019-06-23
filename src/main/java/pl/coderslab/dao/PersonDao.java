package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Person;
import pl.coderslab.entity.Person;
import pl.coderslab.entity.PersonNew;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PersonDao extends GenericDao<PersonNew> {

    public PersonDao() {
        super(PersonNew.class);
    }
}
