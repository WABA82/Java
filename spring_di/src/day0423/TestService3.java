package day0423;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestService3 {

	// ������ ���� ���� ��ü�� ������̼� �����ϱ�.
	@Autowired
	private TestDAO3 td;

	public TestDAO3 getTestDAO3() {
		return td;
	}// getTestDAO3

}// class
