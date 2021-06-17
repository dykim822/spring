package hib.dao;

import java.util.List;

import hib.model.Person;

public interface PersonDao {

	Person select(String id);

	void save(Person person);

	void update(Person person);

	List<Person> list();

	void delete(String id);

}
