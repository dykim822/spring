package hib.service;
import java.util.List;

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
			System.out.println("이미 존재하는 ID입니다");
		}
		return result;
	}
	public void select(String id) {
		Person person = pd.select(id);
		if(person == null) {
			System.out.println("존재하지 않는 ID입니다");
		} else {
			print(person);
		}
	}
	private void print(Person person) {
		System.out.println("=====회원정보=====");
		System.out.println("아이디 : "+person.getId());
		System.out.println("이름 : "+person.getName());
	}
	public int update(Person person) {
		int result = 0;
		Person per = pd.select(person.getId());
		if(per != null) {
			pd.update(person);
			result = 1;
		} else {
			System.out.println("데이터가 존재하지 않아 수정할 수 없습니다");
		}
		return result;
	}
	public void list() {
		List<Person> list = pd.list();
		if(list == null || list.size() == 0) {
			System.out.println("데이터가 없습니다");
		} else {
			for(Person person:list) {
				print(person);
			}
		}
	}
	public int delete(String id) {
		int result = 0;
		Person per = pd.select(id);
		if(per != null) {
			pd.delete(id);
			result = 1;
		} else {
			System.out.println("데이터가 존재하지 않아 삭제할 수 없습니다");
		}
		return result;
	}
}
