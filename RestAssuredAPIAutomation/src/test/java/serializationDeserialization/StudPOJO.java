package serializationDeserialization;

public class StudPOJO 
{
	 private String name;
	    private String location;
	    private String phone;
	    private String[] courses;

	    // Getter and Setter for name
	    public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }

	    // Getter and Setter for location
	    public String getLocation() {
	        return location;
	    }
	    public void setLocation(String location) {
	        this.location = location;
	    }

	    // Getter and Setter for phone
	    public String getPhone() {
	        return phone;
	    }
	    public void setPhone(String phone) {
	        this.phone = phone;
	    }

	    // Getter and Setter for courses
	    public String[] getCourses() {
	        return courses;
	    }
	    public void setCourses(String[] courses) {
	        this.courses = courses;
	    }
}
