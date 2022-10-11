import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class LRUCache extends LinkedHashMap {


    Map<Integer, Integer> lruMap = new HashMap();
    Map<Integer, Integer> age = new HashMap();
    int capacity = 0;
    public LRUCache(int capacity) {
        this.capacity = capacity;

    }

    public int get(int key) {

        if(lruMap.containsKey(key))
        {
            for( int element : lruMap.keySet()){

                age.put(element,age.get(element)+1);
            }
            age.put(key,1);

            return lruMap.get(key);
        }

        return -1;

    }

    public void put(int key, int value) {
        if(capacity == 0){
            int maxi = 0;
            int maxiKey = 0;
            for( int element : age.keySet()){

                if(age.get(element) > maxi)
                {
                    maxi = age.get(element);
                    maxiKey = element;
                }
            }
            lruMap.remove(maxiKey);
            age.remove(maxiKey);
        }
        for( int element : lruMap.keySet()){

            age.put(element,age.get(element)+1);
        }


        lruMap.put(key,value);
        age.put(key,1);

        capacity-- ;

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */