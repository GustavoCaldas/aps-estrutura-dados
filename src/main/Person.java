package main;

public class Person {
	
	private String name;
	private int age;
	private boolean emergency; 

	public Person(String name, int age, boolean emerge) {
		this.name = name;
		this.age = age;
		this.emergency = emerge;
	}
	
	public boolean isEmergency() {
		return emergency;
	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
}
