package lab2ass;

import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Course
 *
 * @author  RAWR-XD
 * @version 1.0
 */
public class Course {
	
	public static Person personToAdd = new Person();
    private static int nextValidCourseID = -0;
    ArrayList<Course> courseList = new ArrayList<>();
	private ArrayList<Person> personToaddList = new ArrayList<Person>();
    
    private int courseID; 
    private String name;
    private double price;
    private int runtime;
    private double cost;
    public float result;
    public Course(int _studentID, String _name, double _cost, double _price, int _runtime) {
        int studentID = _studentID;
        this.name = _name;
        this.cost = _cost;
        this.price = _price;
        setRuntime(_runtime);
        this.setCourseID();
       // this.runtime = _runtime;
    }

    public void setCourses (ArrayList inputCourses) {
        this.courseList = inputCourses;
    }

	public Course() {
		this.setCourseID();
	}

	public void finalize() throws Throwable {

    }
    public int getID() {
        return courseID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCost () {
        return cost;
    }

    public void setCost (double cost) {
        this.cost = cost;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) throws IllegalArgumentException  {
        if (runtime > 0 && runtime <= 10) {
            this.runtime = runtime;
                  } else {
        	throw new IllegalArgumentException("Runtime Can Not be Lower than 0 or Higer than 10"); // makes sure the runtime is greater than 0 and lower than 11
        }
    }

    public String runTimeToString(int runtime) {
        return String.valueOf(runtime);
    }
    private void setCourseID() { // allocate next available ID
        this.courseID = nextValidCourseID++;
      
    }
    public void diffrentCourses(Course courseAddToList)
    {
    	courseList.add(courseAddToList);
    	
    }
    public void enrollstudent(Person personAddToList)
    {
    	personToaddList.add(personAddToList);
    	System.out.println(personAddToList.getName() + " added to course");
    }
    
      

    @Override
    public String toString() {
        return "Course [course=" + name + ", price=" + price + ", runtime=" + runtime + ", courseID=" + courseID +", students= "+ personToaddList.toString() + "]";
    }
    public String toStringNameAndPeople()
    {
    	return "Course [course=" + name + ", students= " + personToaddList.toString() + "]";
    }
    
    public String toStringShort() {
    	return "Course [ID= " + courseID + ", name= " + name + "]" ;
    }

    //load courses from file
    public ArrayList loadCourses () {
        System.out.println ("Loading courses...");
        try {
            ArrayList data = new ArrayList();
            Scanner input = new Scanner (
                new File("courses.txt")
            );
            while (input.hasNextLine()) {
                String inputType = input.nextLine();
                int inputID = Integer.parseInt(input.nextLine());
                String inputName = input.nextLine();
                double inputCost = Double.parseDouble(input.nextLine());
                double inputPrice = Double.parseDouble(input.nextLine());
                int inputRuntime = Integer.parseInt(input.nextLine());
                Course course = null;
                switch (inputType) {
                    case "class lab2ass.Course":
                        course = new Course (inputID, inputName, inputCost, inputPrice, inputRuntime);
                        break;
                    case "class lab2ass.OnlineCourse":
                        course = new OnlineCourse (inputID, inputName, inputCost, inputPrice, inputRuntime);
                        break;
                    case "class lab2ass.ShortCourse":
                        course = new ShortCourse (inputID, inputName, inputCost, inputPrice, inputRuntime);
                        break;
                    case "class lab2ass.EveningCourse":
                        course = new EveningCourse (inputID, inputName, inputCost, inputPrice, inputRuntime);
                        break;
                }
                System.out.println (course.toString());
                data.add(course);
            }
            return data;
        } catch (FileNotFoundException e) {
            System.out.println ("Error: file not found");
        }
        return null;
    }
    
    // Save all courses to a list
    public void saveCourses () {
        System.out.println ("Saving courses...");
        try {
            File saveLocation = new File ("courses.txt");
            PrintWriter output = new PrintWriter (saveLocation);
            for (Course course: this.courseList) {
                output.println (course.getClass());
                output.println (course.getID());
                output.println (course.getName());
                output.println (course.getCost());
                output.println (course.getPrice());
                output.println (course.getRuntime());
            }
            output.close();
        } catch (FileNotFoundException e) {
            System.out.println ("we didn't find the file we literally just made FFS java");
        }
    }
}