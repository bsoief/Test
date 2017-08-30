package test.iterator.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import test.iterator.vo.Person;

/**
 * Iterator在并发环境下，对集合框架的保护并不全面。
 * @author admin
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test1();
	}

	public static void test1() {
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person(1, "aaa"));
		persons.add(new Person(2, "bbb"));
		persons.add(new Person(3, "ccc"));
		Iterator<Person> iterator = persons.iterator();
		while(iterator.hasNext()) {
			Person person = iterator.next();
			if (person.getId() == 2) {
				Person person1 = persons.get(0);
				person1.setName("ddd");
			}
		}
		persons.forEach(p -> System.out.println(p.getName()));
	}
}
