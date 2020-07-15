package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Excute {
	public static void main(String[] args) {
		List<Person> pList = new ArrayList<>();
		pList.add(new Person("동혁",22,80));
		pList.add(new Person("인혁",32,95));
		pList.add(new Person("상혁",33,90));
		Collections.sort(pList);
		System.out.println(pList);
	}
}
