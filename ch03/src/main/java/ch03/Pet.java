package ch03;

import java.util.Date;

import lombok.Data;
//@Getter	// getter method 자동생성
//@Setter	// setter method 자동생성
@Data	// getter setter 한꺼번에 생성
public class Pet {
	private int petId;
	private String petName;
	private String ownerName;
	private int price;
	private Date birthDate;
}
