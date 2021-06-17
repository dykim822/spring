package hib.dao;
import java.util.List;

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
	public void update(Person person) {
		ht.update(person);
	}
	public List<Person> list() {
		// 주의사항; from Person에서 Person은 테이블명이 아닌 클래스명이므로 대문자로 시작
		return (List<Person>) ht.find("from Person");
	}
	public void delete(String id) {
		Person person = new Person();
		person.setId(id);
		// 객체를 생성하고 객체에 key를 setting한 후에 객체 삭제
		ht.delete(person);
	}
	
}
