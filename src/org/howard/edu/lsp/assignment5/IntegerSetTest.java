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
        assertEquals(0, set1.length());

        IntegerSet set2 = new IntegerSet();
        set2.clear();
        assertEquals(0, set2.length());

    }
    
    @Test 
    public void testLength(){

        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        assertEquals(3, set1.length());

        IntegerSet set2 = new IntegerSet();
        set2.add(1);
        set2.add(2);
        assertEquals(2, set2.length());

        IntegerSet set3 = new IntegerSet();
        assertEquals(0, set3.length());
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

        assertTrue(setA.equals(setB));

        IntegerSet setC = new IntegerSet();
        assertFalse(setA.equals(setC));

    }

    @Test 
    public void testContains(){

        IntegerSet setA = new IntegerSet();
        setA.add(1);
        setA.add(2);
        setA.add(3);

        assertTrue(setA.contains(3));
        assertFalse(setA.contains(0));

        IntegerSet setB = new IntegerSet();
        assertFalse(setB.contains(0));

    }

    @Test 
    public void testLargest() throws IntegerSetException{

        IntegerSet setA = new IntegerSet();
        setA.add(1);
        setA.add(2);
        setA.add(3);
        assertEquals(3, setA.largest());

        IntegerSet setB = new IntegerSet();
        setB.add(-100);
        setB.add(-1000);
        setB.add(0);
        assertEquals(0, setB.largest());

        IntegerSet setC = new IntegerSet();
        IntegerSetException thrown = assertThrows(IntegerSetException.class, () -> {
            setC.largest();
        });
        assertTrue(thrown.getMessage().contentEquals("IntegerSet is empty"));

    }

    @Test 
    public void testSmallest() throws IntegerSetException{

        IntegerSet setA = new IntegerSet();
        setA.add(1);
        setA.add(2);
        setA.add(3);
        assertEquals(1, setA.smallest());

        IntegerSet setB = new IntegerSet();
        setB.add(-100);
        setB.add(-1000);
        setB.add(0);
        assertEquals(-1000, setB.smallest());

        IntegerSet setC = new IntegerSet();
        IntegerSetException thrown = assertThrows(IntegerSetException.class, () -> {
            setC.smallest();
        });
        assertTrue(thrown.getMessage().contentEquals("IntegerSet is empty"));
    }

    @Test 
    public void testAdd() {

        IntegerSet setA = new IntegerSet();
        setA.add(1);
        setA.add(2);
        setA.add(2);
        setA.add(3);
        setA.add(3);
        assertEquals(3, setA.length());

        IntegerSet setB = new IntegerSet();
        setB.add(-100);
        setB.add(-1000);
        setB.add(0);
        assertEquals(3, setB.length());
    }

    @Test 
    public void testRemove() {

        IntegerSet setA = new IntegerSet();
        setA.add(1);
        setA.add(2);
        setA.add(3);
        setA.remove(3);
        assertEquals(2, setA.length());
        assertFalse(setA.contains(3));

        IntegerSet setB = new IntegerSet();
        setB.remove(0);
        assertEquals(0, setB.length());
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
        assertEquals(4, setA.length());
        assertTrue(setA.contains(0));

        IntegerSet setC = new IntegerSet();
        IntegerSet setD = new IntegerSet();

        setC.union(setD);

        assertEquals(0, setC.length());
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
        assertEquals(3, setA.length());
        assertTrue(setA.contains(3));
        assertFalse(setA.contains(4));

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
        assertEquals(-1, setA.diff(setB));
        
        IntegerSet setC = new IntegerSet();
        IntegerSet setD = new IntegerSet();

        assertEquals(0, setC.diff(setD));

        assertEquals(5, setA.diff(setD));

    }

    @Test 
    public void testIsEmpty() {

        IntegerSet setA = new IntegerSet();
        setA.add(5);
        setA.add(5);
        setA.add(5);
        assertFalse(setA.isEmpty());

        IntegerSet setB = new IntegerSet();
        setB.add(3);
        setB.add(2);
        setB.add(1);
        assertFalse(setB.isEmpty());
        
        IntegerSet setC = new IntegerSet();
        IntegerSet setD = new IntegerSet();

        assertTrue(setC.isEmpty());
        assertTrue(setD.isEmpty());
    }

    @Test 
    public void testToString() {

        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(3);
        assertEquals("1 2 3 ", set1.toString());

        IntegerSet set2 = new IntegerSet();

        set2.add(10);
        set2.add(20);
        set2.add(30);
        set2.add(40);
        assertEquals("10 20 30 40 ", set2.toString());
    }

}
