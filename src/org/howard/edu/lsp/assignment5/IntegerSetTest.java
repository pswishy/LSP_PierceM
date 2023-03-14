package src.org.howard.edu.lsp.assignment5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.*;

public class IntegerSetTest {
    
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
}
