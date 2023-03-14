package src.org.howard.edu.lsp.assignment5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.*;

public class IntegerSetTest {

    @Test
    public void testClear(){
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.clear();
        assertEquals("Testing if clear results in empty IntegerSet",0, set1.length());
        IntegerSet set2 = new IntegerSet();
        set2.clear();
        assertEquals("Testing make sure clear works on empty IntegerSet", 0, set2.length());

    }
    
    @Test 
    public void testLength(){

        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        assertEquals("Test to confirm IntegerSet length method works", 3, set1.length());

        IntegerSet set2 = new IntegerSet();
        set2.add(1);
        set2.add(2);
        assertEquals("Test to confirm IntegerSet length method works", 2, set2.length());

        IntegerSet set3 = new IntegerSet();
        assertEquals("Test to confirm IntegerSet length method works on empty IntegerSet", 0, set3.length());
    }

    @Test 
    public void testEquals(){

        IntegerSet setA = new IntegerSet();
        setA.add(1);
        setA.add(2);
        setA.add(3);

        IntegerSet setB = new IntegerSet();
        setB.add(3);
        setB.add(2);
        setB.add(1);

        assertTrue("Test equality on two IntegerSets",setA.equals(setB));

        IntegerSet setC = new IntegerSet();
        assertFalse("Test equality on two IntegerSets", setA.equals(setC));

    }

    @Test 
    public void testContains(){

        IntegerSet setA = new IntegerSet();
        setA.add(1);
        setA.add(2);
        setA.add(3);

        assertTrue("Test confiming contains method returns true if item does exist inside IntegerSet", setA.contains(3));
        assertFalse("Test confiming contains methof returns false if item does not exist inside IntegerSet", setA.contains(0));

        IntegerSet setB = new IntegerSet();
        assertFalse("Test confiming contains method returns false if contain method is used on empty IntegerSet",setB.contains(0));

    }

    @Test 
    public void testLargest() throws IntegerSetException{

        IntegerSet setA = new IntegerSet();
        setA.add(1);
        setA.add(2);
        setA.add(3);
        assertEquals("Test confiming largest method returns the largest number of an IntegerSet with all positive numbers", 3, setA.largest());

        IntegerSet setB = new IntegerSet();
        setB.add(-100);
        setB.add(-1000);
        setB.add(0);
        assertEquals("Test confiming largest method returns the largest number of an IntegerSet with negative numbers",0, setB.largest());

        IntegerSet setC = new IntegerSet();
        IntegerSetException thrown = assertThrows(IntegerSetException.class, () -> {
            setC.largest();
        });
        assertTrue("Test confiming largest method throws IntegerSetException when largest method is called on empty IntegerSet", thrown.getMessage().contentEquals("IntegerSet is empty"));

    }

    @Test 
    public void testSmallest() throws IntegerSetException{

        IntegerSet setA = new IntegerSet();
        setA.add(1);
        setA.add(2);
        setA.add(3);
        assertEquals("Test confiming smallest method returns the smallest number of an IntegerSet with all positive numbers",1, setA.smallest());

        IntegerSet setB = new IntegerSet();
        setB.add(-100);
        setB.add(-1000);
        setB.add(0);
        assertEquals("Test confiming smallest method returns the smallest number of an IntegerSet with negative numbers", -1000, setB.smallest());

        IntegerSet setC = new IntegerSet();
        IntegerSetException thrown = assertThrows(IntegerSetException.class, () -> {
            setC.smallest();
        });
        assertTrue("Test confiming smallest method throws IntegerSetException when smallest method is called on empty IntegerSet",thrown.getMessage().contentEquals("IntegerSet is empty"));
    }

    @Test 
    public void testAdd() {

        IntegerSet setA = new IntegerSet();
        setA.add(1);
        setA.add(2);
        setA.add(2);
        setA.add(3);
        setA.add(3);
        assertEquals("Test confiming add method does not add a duplicate positive number to IntegerSet", 3, setA.length());

        IntegerSet setB = new IntegerSet();
        setB.add(-100);
        setB.add(-1000);
        setB.add(-1000);
        setB.add(0);
        assertEquals("Test confiming add method does not add a duplicate negative number to IntegerSet", 3, setB.length());
    }

    @Test 
    public void testRemove() {

        IntegerSet setA = new IntegerSet();
        setA.add(1);
        setA.add(2);
        setA.add(3);
        setA.remove(3);
        assertEquals("Test confiming remove method succesfully removes value from IntegerSet",2, setA.length());
        assertFalse("Test confiming removed value is no longer in IntegerSet", setA.contains(3));

        IntegerSet setB = new IntegerSet();
        setB.remove(0);
        assertEquals("Test confiming remove method works on empty IntegerSet", 0, setB.length());
    }

    @Test 
    public void testUnion() {

        IntegerSet setA = new IntegerSet();
        setA.add(1);
        setA.add(2);
        setA.add(3);

        IntegerSet setB = new IntegerSet();
        setB.add(0);

        setA.union(setB);
        assertEquals("Test confiming union method works on IntegerSet", 4, setA.length());
        assertTrue("Test confiming union method successfully modifies IntegerSet", setA.contains(0));

        IntegerSet setC = new IntegerSet();
        IntegerSet setD = new IntegerSet();

        setC.union(setD);

        assertEquals("Test confiming union method works on two empty IntegerSets", 0, setC.length());
    }

    @Test 
    public void testIntersection() {

        IntegerSet setA = new IntegerSet();
        setA.add(1);
        setA.add(2);
        setA.add(3);

        IntegerSet setB = new IntegerSet();
        setB.add(4);
        setB.add(3);
        setB.add(2);
        setB.add(1);

        setA.intersection(setB);
        assertEquals("Test confiming intersection method works on IntegerSet", 3, setA.length());
        assertTrue("Test confiming intersection method successfully modifies IntegerSet", setA.contains(3));
        assertFalse("Test confiming intersection method successfully modifies IntegerSet", setA.contains(4));

    }

    @Test 
    public void testDifference() {

        IntegerSet setA = new IntegerSet();
        setA.add(5);
        setA.add(5);
        setA.add(5);

        IntegerSet setB = new IntegerSet();
        setB.add(3);
        setB.add(2);
        setB.add(1);
        assertEquals("Test confiming difference method works on IntegerSets with mismatch sizes ", -1, setA.diff(setB));
        
        IntegerSet setC = new IntegerSet();
        IntegerSet setD = new IntegerSet();

        assertEquals("Test confiming difference method works on two empty IntegerSets", 0, setC.diff(setD));

        assertEquals("Test confiming difference method works on one empty IntegerSet and one filled IntegerSet",5, setA.diff(setD));

    }

    @Test 
    public void testIsEmpty() {

        IntegerSet setA = new IntegerSet();
        setA.add(5);
        setA.add(5);
        setA.add(5);
        assertFalse("Test confiming isEmpty method returns false on filled IntegerSet", setA.isEmpty());

        IntegerSet setB = new IntegerSet();
        setB.add(3);
        setB.add(2);
        setB.add(1);
        assertFalse("Test confiming isEmpty method returns false on filled IntegerSet", setB.isEmpty());
        
        IntegerSet setC = new IntegerSet();
        IntegerSet setD = new IntegerSet();

        assertTrue("Test confiming isEmpty method returns true on empty IntegerSet", setC.isEmpty());
        assertTrue("Test confiming isEmpty method returns true on empty IntegerSet", setD.isEmpty());
    }

    @Test 
    public void testToString() {

        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(3);
        assertEquals("Test confiming toString method returns string version of IntegerSet", "1 2 3 ", set1.toString());

        IntegerSet set2 = new IntegerSet();

        set2.add(10);
        set2.add(20);
        set2.add(30);
        set2.add(40);
        assertEquals("Test confiming toString method returns string version of IntegerSet", "10 20 30 40 ", set2.toString());

        IntegerSet set3 = new IntegerSet();
        assertEquals("Test confiming toString method returns string version of empty IntegerSet", "", set3.toString());

    }

}
