package test;

public class Person implements Comparable<Person>{//comparable 이해 필요

	public String name;
	public int age;
	public int point;
	
	public Person(String name, int age, int point) {
		super();
		this.name = name;
		this.age = age;
		this.point = point;
	}

	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", point=" + point + "]";
	}

	public int compareTo(Person o) {
		
	 if(point<o.point) return -1;
	 if(point>o.point) return 1;
	 return 0;
	 //비교 대상이 무엇인지 모르면 안 되니 비교 대상을 
	 // return point-o.point;
	 // return o.point-point; 오름차순
	}
	
}
