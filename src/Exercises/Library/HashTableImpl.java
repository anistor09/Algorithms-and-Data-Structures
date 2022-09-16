package Exercises.Library;
import java.util.*;

import Exercises.HashTable;
import Exercises.Library.Entry;

public class HashTableImpl extends HashTable {

    public int numCalls;

    public HashTableImpl(int size) {
        super(size);
    }

    @Override
    public int hash(String item) {
        numCalls++;
        return item == null ? 0 : Math.abs(item.hashCode()) % getCapacity();
    }

    public LinkedList<Entry>[] getTable() {
        return myTable;
    }
}

