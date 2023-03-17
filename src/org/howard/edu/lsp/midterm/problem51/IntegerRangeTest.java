package src.org.howard.edu.lsp.midterm.problem51;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.*;

public class IntegerRangeTest {

    @Test
    public void testContains(){
    IntegerRange range1 = new IntegerRange(0,10);
    IntegerRange range2 = new IntegerRange(0,20);

    assertTrue(range1.contains(5));
    assertTrue(range2.contains(5));
    assertFalse(range2.contains(-5));
    }

    @Test
    public void testOverlaps() throws EmptyRangeException{
        IntegerRange range1 = new IntegerRange(0,10);
        IntegerRange range2 = new IntegerRange(0,20);
        IntegerRange range3 = new IntegerRange(-10,-1);
        IntegerRange range4 = new IntegerRange(0,0);
        IntegerRange range5 = new IntegerRange(-1,-10);
        assertTrue(range1.overlaps(range2));
        assertFalse(range1.overlaps(range3));
        assertFalse(range2.overlaps(range3));


        EmptyRangeException thrown = assertThrows(EmptyRangeException.class, () -> {
            range4.overlaps(range5);
        });
        assertTrue(thrown.getMessage().contentEquals("Range object is null"));
    }

    @Test
    public void testSize(){
        IntegerRange range1 = new IntegerRange(0,10);
        IntegerRange range2 = new IntegerRange(0,20);
        IntegerRange range3 = new IntegerRange(-10,-1);
       
        assertEquals(11, range1.size());
        assertEquals(21, range2.size());
        assertEquals(10, range3.size());

    }
}
