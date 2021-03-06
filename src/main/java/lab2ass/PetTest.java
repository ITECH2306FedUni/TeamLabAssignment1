package lab2ass;

import org.junit.Assert;

/**
 * The Pet Test Class
 *
 * @author RAWR-XD (Nathan Blaney)
 * @version 1.0
 */
public class PetTest {
    /**
     * Test's adding a Pet
     */
    @org.junit.Test
    public void testAddPet() {
        Person p1test = new Person("25 Somewhere Street", "Kathleen", "2000", "Casey");
        Animal p1testPet = new Dog("Pug", "Fido", "F", "05 01 1998", "05 01 1998", 13, true, false);
        Animal TestPet = null;
        p1test.addAPet(p1testPet);
        for (Animal pet : p1test.personPetList) {
            TestPet = pet;
        }
        Assert.assertEquals("Dog,Pug,Fido,05 01 1998,F,05 01 1998,13,true,false", TestPet.toString());
        // testing a failure of adding a pet to a person
    }

    /**
     * Test's a person having a Pet
     */
    @org.junit.Test
    public void testHasPetTrue() {
        Person p1test = new Person("25 Somewhere Street", "Kathleen", "2000", "Casey");
        Animal p1testPet = new Dog("Pug", "Fido", "F", "05 01 1998", "05 01 1998", 13, true, false);
        p1test.addAPet(p1testPet);
        Assert.assertEquals(true, p1test.hasPet());
        //testing adding a person to a list
    }

    /**
     * Test's a person not having a Pet
     */
    @org.junit.Test
    public void testHasPetFalse() {
        Person p1test = new Person("25 Somewhere Street", "Kathleen", "2000", "Casey");
        Assert.assertEquals(false, p1test.hasPet());
        //testing adding a person to a list
    }

    /**
     * Tests adding a pet but assert wrong details into the list
     */
    @org.junit.Test
    public void testAddPetFailure() {
        Person p1test = new Person("25 Somewhere Street", "Kathleen", "2000", "Casey");
        p1test.addAPet(new Dog("Pug", "Fido", "F", "05 01 1998", "05 01 1998", 13, true, false));
        Animal TestPet = null;
        for (Animal pet : p1test.personPetList) {
            TestPet = pet;
        }
        Assert.assertEquals("German Shepherd", TestPet.getBreed());
        // testing a failure of adding a pet to a person 
    }

    /**
     * Tests listing multiple pet's names
     */
    @org.junit.Test
    public void testAddMultiple() {
        Person p1test = new Person("25 Somewhere Street", "Kathleen", "2000", "Casey");
        p1test.addAPet(new Cat("Dim Sim", "Tissue", "F", "05 01 1998", "05 01 1998", 14));
        p1test.addAPet(new Dog("Pug", "Fido", "F", "05 01 1998", "05 01 1998", 13, false, false));
        Animal TestPet = null;
        TestPet = p1test.personPetList.get(0);
        Assert.assertEquals("Tissue", TestPet.getName());
        TestPet = p1test.personPetList.get(1);
        Assert.assertEquals("Fido", TestPet.getName());
    }

    /**
     * Tests rates for a desexed dog
     */
    @org.junit.Test
    public void testRateDesexed() {
        Person p1test = new Person("25 Somewhere Street", "Kathleen", "2000", "Casey");
        p1test.addAPet(new Dog("Pug", "Fido", "F", "05 01 1998", "05 01 1998", 13, true, false));
        Animal TestPet = null;
        TestPet = p1test.personPetList.get(0);
        Assert.assertEquals(16.35813875194462, TestPet.calcRates(), 1e-15);
    }

    /**
     * Tests rates for a not desexed dog
     */
    @org.junit.Test
    public void testRateNotDesexed() {
        Person p1test = new Person("25 Somewhere Street", "Kathleen", "2000", "Casey");
        p1test.addAPet(new Dog("Pug", "Fido", "F", "05 01 1998", "05 01 1998", 13, false, false));
        Animal TestPet = null;
        TestPet = p1test.personPetList.get(0);
        Assert.assertEquals(21.756324540086347, TestPet.calcRates(), 1e-15);
    }
}