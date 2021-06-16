package hib.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import hib.model.Person;

@Repository
public class PersonDaoImpl implements PersonDao {
	@Autowired
	private HibernateTemplate ht;

	public Person select(String id) {
		return ht.get(Person.class, id);
	}
	public void save(Person person) {
		ht.save(person);
	}
	
}
