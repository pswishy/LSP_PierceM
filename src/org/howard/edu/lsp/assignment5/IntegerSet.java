package src.org.howard.edu.lsp.assignment5;

import java.util.*;

/**
 * IntegerSet class which replicates Mathematical Set Operation in Java
 * @author Pierce Medy
 */

public class IntegerSet {
    /**
     * The List obeject containg all the values in our IntegerSet
     */
    private List<Integer> set = new ArrayList<Integer>();

    public IntegerSet(){
    }

    /**
     * Removes all values from the IntegerSet
     */
    public void clear(){
        set.clear();
    }

    /**
     * Finds length of the IntegerSet
     * @return length of the set
     */
    public int length(){
        return set.size();
    }

    /**
     * Finds equality between two IntegerSets. A IntegerSet is considered equal
     * if both sets contain the same values(regardless of order)
     * @param b IntegerSet that is being compared
     * @return true if the 2 sets are equal, false otherwise
     */
    public boolean equals(IntegerSet b){
        Boolean equals = true;
        
        if(set.size() != b.set.size()){
            return false;
        }

        for (int i: b.set){
            if(!set.contains(i)){
                equals = false;
            }
        }
        return equals;
    }

   /**
     * Check to see if IntegerSet contains a specific value
     * @param value Integer that is being checked
     * @return true if the value is found in the IntegerSet, false otherwise
     */
    public boolean contains(int value){
        for (int i : set){
            if (i == value){
                return true;
            }
        }
        return false;
    }

    /**
     * Finds the largest value in the IntegerSet
     * @return The largest value in the IntegerSet
     */
    public int largest() throws IntegerSetException{
         Integer largest_num = Integer.MIN_VALUE;

        if(set.size() == 0){
            throw new IntegerSetException("IntegerSet is empty");
        }
        
        for (int i : set){
            if (i > largest_num){
                largest_num = i;
            }
        }
        return largest_num;
    }

    /**
     * Finds the smallest value in the IntegerSet
     * @return The smallest value in the IntegerSet
     */
    public int smallest() throws IntegerSetException{
        Integer smallest_num = Integer.MAX_VALUE;

       if(set.size() == 0){
           throw new IntegerSetException("IntegerSet is empty");
       }
       
       for (int i : set){
           if (i < smallest_num){
            smallest_num = i;
           }
       }
       return smallest_num;
   }

    /**
     * Adds an Integer to the IntegerSet
     */
   public void add(int item){

    if(!set.contains(item)){
        set.add(item);
    }
   }

    /**
     * Removes an Integer to the IntegerSet
     */
   public void remove(int item){
    if(set.contains(item)){
        set.remove(set.indexOf(item));
    }
   }

    /**
     * Finds the union between two IntegerSets
     * @param b IntegerSet that is being combined
     */
   public void union(IntegerSet b){
    for(int i : b.set){
        if(!set.contains(i)){
            set.add(i);
        }
    }
   }

    /**
     * Finds the Intersection between two IntegerSets
     * @param b IntegerSet that is being combined
     */
   public void intersection(IntegerSet b){
    for(int i : set){
        if(!b.set.contains(i)){
            set.remove(i);
        }
    }
   

   }

    /**
     * Summs the values of Integerset 1 and IntegerSet 2 and then finds the differnece
     * @param b Second Integer Set
     * @return The mathematical diffeence between IntegerSet 1 and IntegerSet 2
     */
   public int diff(IntegerSet b){
    int set1_size = 0;
    int set2_size = 0;
    for(int i: set){
        set1_size += i;
        }
    for(int i: b.set){
        set2_size += i;
        }

    return set1_size - set2_size;
   }

    /**
     * Checks to see if IntegerSet is empty
     */
    boolean isEmpty(){
        return set.isEmpty();
    }

    /**
     * Turns IntegerSet values into strings
     */
    public String toString(){
        String return_string = "";

        for(int i: set){
            return_string += String.valueOf(i) + " ";
        }

        return return_string;
    }
}

/**
* An exception class used to notify the user uses the smallest or largest methods
* on a empty IntegerSet.
*/
class IntegerSetException extends Exception
{
    public IntegerSetException(String message)
    {
        super(message);
    }
}