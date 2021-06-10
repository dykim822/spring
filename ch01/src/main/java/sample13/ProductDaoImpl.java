package sample13;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
// @ 붙어 있는 것이 annotation
//@Component	//객체(Component)로 만들라는 의미
//Component를 Repository/ Service로 나누는 것을 권장
@Repository("pd1")
public class ProductDaoImpl implements ProductDao {
	public Product getProduct(String name) {
		return new Product(name, 20000);
	}

}
