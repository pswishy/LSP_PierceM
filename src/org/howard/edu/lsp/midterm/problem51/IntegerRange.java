package src.org.howard.edu.lsp.midterm.problem51;

public class IntegerRange implements Range {
    private int lower;
    private int upper;

    IntegerRange(int lower, int upper) { 	
            this.lower = lower;
            this.upper = upper;
    }
    public int getLower(){
        return this.lower;
    }
    public int getUpper(){
        return upper;
    }
    public boolean contains(int value) {
        return value >= this.lower && value <= this.upper;
    }
    public boolean overlaps(Range other) throws EmptyRangeException {
        int otherLower = other.getLower();
        int otherUpper = other.getUpper();

        if (other == null || otherUpper < otherLower || this.upper < this.lower){
            throw new EmptyRangeException("Range object is null");
        }
    return this.lower <= otherUpper && otherLower <= this.upper;

    }
    public int size()  {
    return this.upper - this.lower + 1;
    }
}