package src.org.howard.edu.lsp.assignment5;

import static org.junit.Assert.assertEquals;

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
}
