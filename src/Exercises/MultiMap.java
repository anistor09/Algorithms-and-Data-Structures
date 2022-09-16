package Exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiMap {

    private Map<Integer, List<Integer>> map;
    int size;

    /**
     * Creates a new MultiMap.
     */
    public MultiMap() {
        // TODO
        map = new HashMap<>();
        size = 0;

    }

    /**
     * Gets the size of this MultiMap.
     *
     * @return The number of (key, value) pairs in the MultiMap.
     */
    public int size() {
        // TODO
        return size;
    }

    /**
     * Gets whether this MultiMap is empty.
     *
     * @return True if the MultiMap is empty, false otherwise.
     */
    public boolean isEmpty() {
        // TODO
        return (size() == 0);

    }

    /**
     * Adds the given (key, value) pair to the MultiMap.
     *
     * @param key   Key for the new item.
     * @param value New item to add to the MultiMap.
     */
    public void put(int key, int value) {
        // TODO

        List<Integer> listIn = map.get(key);
        if (listIn == null) {
            listIn = new ArrayList<>();
            map.put(key, listIn);
        }
        listIn.add(value);

        size++;
    }

    /**
     * Returns all values in the MultiMap for the given key.
     *
     * @param key Key to return all entries for.
     * @return A list of all entries for the given key.
     * If the key is not in the map, return an empty list.
     */
    public List<Integer> get(int key) {
        // TODO
        if (map.get(key) == null)
            return new ArrayList<Integer>();
        else
            return map.get(key);
    }

    /**
     * Removes the given (key, value) pair from the MultiMap.
     *
     * @param key   Key for the value that should be removed.
     * @param value Value to remove.
     * @return True if removal was successful, false otherwise.
     */
    public boolean remove(int key, int value) {
        // TODO
        boolean removed = false;
        List<Integer> lst = map.get(key);
        if (lst != null) {
            removed = lst.remove((Integer) value);
            if (lst.size() == 0)
                map.remove(key);
            size--;
        }
        return removed;


    }
}