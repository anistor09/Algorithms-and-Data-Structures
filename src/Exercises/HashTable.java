package Exercises;
import Exercises.Library.Entry;

import java.util.LinkedList;
import java.util.Objects;

public abstract class HashTable {

    protected LinkedList<Entry>[] myTable;

    /**
     * Constructs a new HashTable.
     *
     * @param capacity
     *     to be used as capacity of the table.
     * @throws IllegalArgumentException
     *     if the input capacity is invalid.
     */
    @SuppressWarnings("unchecked")
    public HashTable(int capacity) {

        if(capacity<=0)
            throw new IllegalArgumentException();
        else{
            myTable= new LinkedList[capacity];
        }
        for(int i=0;i<capacity ;i++)
            myTable[i]= new LinkedList<>();

        // TODO
    }

    /**
     * Add a key value pair to the HashTable.
     *
     * @param key
     *     to identify the value.
     * @param value
     *     that is identified by the key.
     */
    public void put(String key, Integer value) {
        // TODO
        Entry e = new Entry(key,value);
        if(!containsKey(key))
        {
            myTable[hash(key)].offer(e);}
        else{

            for(Entry x : myTable[hash(key)])
            {
                if(Objects.equals(x.getKey(),key))
                    myTable[hash(key)].remove(x);

            }
            myTable[hash(key)].offer(e);
        }

    }

    /**
     * @param key
     *     to look for in the HashTable.
     * @return true iff the key is in the HashTable.
     */
    public boolean containsKey(String key) {
        // TODO
        LinkedList<Entry> list = myTable[hash(key)];
        for(Entry x : list)
        {
            if(Objects.equals(x.getKey(),key))
                return true;
        }
        return false;
    }

    /**
     * Get a value from the HashTable.
     *
     * @param key
     *     that identifies the value.
     * @return the value associated with the key or `null` if the key is not in the HashTable.
     */
    public Integer get(String key) {
        // TODO
        if(containsKey(key))
        {
            LinkedList<Entry> list = myTable[hash(key)];
            for(Entry x: list)
                if(Objects.equals(x.getKey(),key))
                    return x.getValue();
        }
        return null;

    }

    /**
     * Gets the capacity of this HashTable.
     *
     * @return the capacity of the HashTable.
     */
    public int getCapacity() {
        return myTable.length;
    }

    /**
     * Hashes a string/key.
     *
     * @param item
     *     to hash.
     * @return the hashcode of the string, modulo the capacity of the HashTable.
     */
    public abstract int hash(String item);
}
