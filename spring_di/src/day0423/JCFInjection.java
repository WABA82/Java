package day0423;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class JCFInjection {

	private List<String> list;
	private List<TestVO> voList;
	private Set<String> set;
	private Map<String, String> map;

	public JCFInjection(List<String> list) {
		this.list = list;
		System.out.println("List Injection");
	}// ������

	public JCFInjection(Set<String> set) {
		this.set = set;
		System.out.println("Set Injection");
	}// ������

	public JCFInjection(List<TestVO> voList, int i) {
		this.voList = voList;
		System.out.println("voList Injection");
	}// ������

	public JCFInjection(Map<String, String> map) {
		this.map = map;
		System.out.println("Map Injection");
	}// ������

	public List<String> getList() {
		return list;
	}// getList

	public Set<String> getSet() {
		return set;
	}// getList

	public List<TestVO> getVoList() {
		return voList;
	}// getVoList

	public Map<String, String> getMap() {
		return map;
	}

}// class
