// Time Complexity :  O(N/K) where N is the number of all possible keys and K is the number of predefined buckets in the hashmap, which is 2069 in our case.
// Space Complexity : O(K+M) where K is the number of predefined buckets in the hashmap and M is the number of unique keys
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//Creating a Pair Class having the Key and the Value in the List
class Pair<U,V>{
    public U first;
    public V second;
    
    public Pair(U first, V second){
        this.first = first;
        this.second = second;
    }
}

//Creating an List of Bucket array having the pair of integers as keys and values
class Bucket{
    private List<Pair<Integer,Integer>> bucket;
    
    public Bucket(){
        this.bucket = new LinkedList<Pair<Integer,Integer>>();
    }
    
    public Integer get(Integer key){
        for(Pair<Integer, Integer> pair: this.bucket){
            if(pair.first.equals(key))
                return pair.second;
        }
        return -1;
    }
    
  //Creating an update function having input as integers as keys and values
    public void update(Integer key, Integer value){
        boolean found = false;
        for(Pair<Integer, Integer> pair: this.bucket){
            if(pair.first.equals(key)){
                pair.second = value;
                found = true;
            }
        }
        
        if(!found){
            this.bucket.add(new Pair<Integer, Integer>(key, value));
        }
    }
    
  //Creating an remove function to remove the key from the array
    public void remove(Integer key){
       for(Pair<Integer, Integer> pair : this.bucket){
           if(pair.first.equals(key)){
               this.bucket.remove(pair);
               break;
           }
       } 
    }
}

//Creating my hashmap class
class MyHashMap{
    //creating an variable named key_space
    private int key_space;
    //creating an List of Bucket Type
    private List<Bucket> hash_table;
    
  //creating HashMap
    public MyHashMap(){
        this.key_space = 2069;
        this.hash_table = new ArrayList<Bucket>();
        for(int i = 0; i < this.key_space; ++i){
            this.hash_table.add(new Bucket());
        }
    }
    
    public void put(int key, int value){
        int hash_key = key%this.key_space;
        this.hash_table.get(hash_key).update(key,value);
    }
    
    public int get(int key){
        int hash_key = key % this.key_space;
        return this.hash_table.get(hash_key).get(key);
    }
    
    public void remove(int key){
        int hash_key = key % this.key_space;
        this.hash_table.get(hash_key).remove(key);
    }
}


