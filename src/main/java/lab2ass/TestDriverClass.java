package lab2ass;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * The Test Driver Class
 *
 * @author RAWR-XD
 * @version 1.0
 */
class TestDriverClass {
    static void runTestPerson(String[] args) {
        Result result = JUnitCore.runClasses(PersonTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println("Success: " + result.wasSuccessful());
    }

    static void runTestPet(String[] args) {
        Result result = JUnitCore.runClasses(PetTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println("Success: " + result.wasSuccessful());
    }

    static void runTestCourse(String[] args) {
        Result result = JUnitCore.runClasses(CourseTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println("Success: " + result.wasSuccessful());
    }
}