package day6_SchemaValidate;

public class Student_PojoClass {

	String name;
	String job;
	String phone;
	String courses[];
	
	public String getName(String string) {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob(String string) {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getPhone(String string) {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String[] getCourses() {
		return courses;
	}
	public void setCourses(String[] courses) {
		this.courses = courses;
	}

	
}
