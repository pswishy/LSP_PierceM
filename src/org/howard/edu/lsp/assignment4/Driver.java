package src.org.howard.edu.lsp.assignment4;

public class Driver{
	
    public static void main(String[] args) throws IntegerSetException {

        IntegerSet set1 = new IntegerSet();

        // Individual Set Operations

        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(3);
        System.out.println("Value of Set 1 is: " + set1.toString());
        System.out.println("Largest Value of Set 1 is: " + String.valueOf(set1.largest()));
        System.out.println("Smallest Value of Set 1 is: " + String.valueOf(set1.smallest()));
        System.out.println("The Length of Set 1 is: " + String.valueOf(set1.length()));
        System.out.println("Does Set 1 contain the value 1: " + String.valueOf(set1.contains(1)));
        System.out.println("Does Set 1 contain the value 5: " + String.valueOf(set1.contains(5)));

        // Set Comparison
        IntegerSet set2 = new IntegerSet();
        set2.add(4);
        set2.add(3);
        set2.add(2);
        set2.add(1);
        System.out.println("Value of Set 2 is: " + set2.toString());

        System.out.println("Is Set 1 equal to Set 2: " + set1.equals(set2));
        System.out.println("The difference between Set 1 and Set 2 is: " + set1.diff(set2));

        set1.intersection(set2);
        System.out.println("Result of Set 1 Intersection With Set 2: " + set1.toString());

        set1.union(set2);
        System.out.println("Result of Set 1 Union With Set 2: " + set1.toString());
        
        // Set Removing & Clearing
        set1.remove(4);
        System.out.println("Result of removing 4 from set 1: " + set1.toString());

        set1.clear();
        System.out.println("Check if Set 1 was successfully cleared by using isEmpty(): " + set1.isEmpty());


    }
}