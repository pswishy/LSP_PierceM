import java.util.*;


public class IntegerSet {
    private List<Integer> set = new ArrayList<Integer>();

    // default constructor
    public IntegerSet(){
    }

    public void clear(){
        set.clear();
    }

    public int length(){
        return set.size();
    }

    public boolean equals(IntegerSet b){
        Dictionary<Integer, Integer> dict1 = new Hashtable<>();
        Dictionary<Integer, Integer> dict2 = new Hashtable<>();

        for (int i: set){
            // if this triggers num is not found
            // so put inside dictionary
            if(dict1.get(i) == null){


            }
        }


    }


}