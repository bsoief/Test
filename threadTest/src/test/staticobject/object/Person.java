package test.staticobject.object;

public class Person {

	private Integer id;
	
	private String name;
	
	private Integer age;
	
	public Person() {
		this.id = 1;
		this.name = "person";
		this.age = 10;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
}
