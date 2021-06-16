package hib.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hib.dao.PersonDao;
import hib.model.Person;
@Service
public class PersonServiceImpl implements PersonService {
	@Autowired
	private PersonDao pd;

	public int insert(Person person) {
		int result = 0;
		// id 중복체크/ per은 db에서 읽어온 데이터/ person은 scanner로 입력한 데이터
		Person per = pd.select(person.getId());
		if(per == null) {
			pd.save(person);
			result = 1;
		} else {
			System.out.println("이미 존재하는 Id입니다");
		}
		return result;
	}
}
