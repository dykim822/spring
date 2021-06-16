package hib.dao;

import hib.model.Person;

public interface PersonDao {

	Person select(String id);

	void save(Person person);

}
