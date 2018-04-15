/**
 *
 */
package lab1ass;

/**
 * @author RAWR xD
 */
public class TestDriverClass {

    /**
     * @param args
     */

    public static void main(String[] args) {
    	
    	//Person Test
    	
    	System.out.println("\n PERSON TEST DATA");
    	
        // create test case 1 - a person owning a pet dog
        Person p1 = new Person("25 somewhere Street", "Kathleen", "2000", "Casey");
        Animal p1Pet = new Dog("Pug", "Fido", "F", "05 01 1998", "05 01 1998", 13, true, false);
        p1.addAPet(p1Pet);
        System.out.println("\n I have a person object : " + p1.toString());

        // create test case 2 - another person owing a spider
        Person p2 = new Person("12 curly avenue", "Fred", "3350", "Casey");
        Animal p2Pet = new Rabbit("American Fuzzy Lop", "Leonard", "F", "05 01 1998", "05 01 1998",null);
        p2.addAPet(p2Pet);
        System.out.println("\n I have a second person object : " + p2.toString());

        // create test case 3 - another person owing a pet dog
        Person p3 = new Person("12 curly avenue", "Mark", "3350", "Casey");
        Animal p3Pet = new Cat("Siamese", "Leonard", "F", "05 01 1998", "05 01 1998", 14);
        p3.addAPet(p3Pet);
        System.out.println(" \n I have a third person object : " + p3.toString());
        
        //Course Test
        
        System.out.println("\n COURSE TEST DATA");
        
        //Create a Course and give it to someone
        Course c1 = new Course(36, "IT_Giggle_Physics", 220, 6);
        p1.enrollInCourse(c1);
        System.out.println(" \n I have a Course Object : " + p1.toStringWithCourse());
        
        //Create another Course and give it to someone
        Course c2 = new Course(666, "Garden Time With Nine", 69, 2);
        p2.enrollInCourse(c2);
        System.out.println(" \n I have a Course Object : " + p2.toStringWithCourse());
        
        //Create Last Course and give it to someone
        Course c3 = new Course(333, "Euro Beat With Blan3y", 148, 12);
        p3.enrollInCourse(c3);
        System.out.println(" \n I have a Course Object : " + p3.toStringWithCourse());
    }

}
