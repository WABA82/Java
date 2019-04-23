package day0423;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestService3 {

	// 의존성 주입 받을 객체에 어노테이션 적용하기.
	@Autowired
	private TestDAO3 td;

	public TestDAO3 getTestDAO3() {
		return td;
	}// getTestDAO3

}// class
