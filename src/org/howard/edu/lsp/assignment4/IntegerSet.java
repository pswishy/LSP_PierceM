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
                dict1.put(i, 1);
            }
            else{
                // number is already in dictionary
                // so update count
                dict1.put(i, dict1.get(i) + 1);
            }
        }

        for (int i: b.set){
            // if this triggers num is not found
            // so put inside dictionary
            if(dict2.get(i) == null){
                dict2.put(i, 1);
            }
            else{
                // number is already in dictionary
                // so update count
                dict2.put(i, dict2.get(i) + 1);
            }
        }
        return dict1 == dict2;
    }

    public boolean contains(int value){
        for (int i : set){
            if (i == value){
                return true;
            }
        }
        return false;
    }

}