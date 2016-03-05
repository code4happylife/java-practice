package org.copy;



/**
*深拷贝
 */
class Family implements Cloneable {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

class Student implements Cloneable {
	private String name;
	private Family family;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Family getFamily() {
		return family;
	}

	public void setFamily(Family family) {
		this.family = family;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {/*
																 * The class
																 * Object does
																 * not itself
																 * implement the
																 * interface
																 * Cloneable, so
																 * calling the
																 * clone method
																 * on an object
																 * whose class
																 * is Object
																 * will result
																 * in throwing
																 * an exception
																 * at run time
																 */
		Student student=(Student)super.clone();
		student.family=(Family)family.clone();
		return student;
		
	}
}

class StringObj implements Cloneable {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

public class CopyT {
	public static void main(String[] args) throws CloneNotSupportedException {
		Family family = new Family();
		family.setName("Army-Family");
		Student student1 = new Student();
		student1.setFamily(family);
		student1.setName("James");
		System.out.println(student1.getName() + " "
				+ student1.getFamily().getName());
		// OBJECT对象的clone()方法默认是浅拷贝,即只是拷贝了对象的引用，因此两者会同时改变
		//A shallow copy just copies the values of the references in the class
		Student student2 = (Student) student1.clone();
		System.out.println(student2.getName() + " "
				+ student2.getFamily().getName());
		/*System.out.println((student1.getName()==student2.getName()));
		System.out.println((student1.getFamily()==student2.getFamily()));*/
		student2.setName("John");
		student2.getFamily().setName("Agriculture-Family");
		System.out.println(student1.getName() + " "
				+ student1.getFamily().getName());
		System.out.println(student2.getName() + " "
				+ student2.getFamily().getName());

		/*
		 * // 深拷贝 Family family3 = new Family();
		 * family3.setName("President Family"); Student student3 = new
		 * Student(); student3.setName("Obama"); student3.setFamily(family3);
		 * System.out.println(student3.getName() + " " +
		 * student3.getFamily().getName());
		 */
		StringObj a = new StringObj();
		a.setName("Hello");
		StringObj b = (StringObj) a.clone();
		System.out.println((a.getName()==b.getName()));
		System.out.println(a.getName());
		System.out.println(b.getName());
		b.setName("I like you");
		System.out.println(a.getName());
		System.out.println(b.getName());
		/*
		 * If a change is made to the value of a deeply copied reference, then
		 * the copy does not reflect that change because it does not share the
		 * same reference.
		 */
		
	}
}