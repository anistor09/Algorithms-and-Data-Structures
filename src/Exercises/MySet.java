package Exercises;

import java.util.HashSet;
import java.util.Iterator;

public class MySet extends HashSet<String> {
    private static final long serialVersionUID = 1L;

    public MySet() {
        super();
    }

    /**
     * Unions this set with the given other set.
     *
     * @return the union of the elements of this and that
     */
    public MySet union(MySet that) {
        MySet result = new MySet();
        // TODO
        if(that==null)
            that =  new MySet();
        Iterator it = this.iterator();
        while(it.hasNext())
        {

            result.add((String)it.next());
        }
        Iterator it2 = that.iterator();
        while(it2.hasNext())
        {
            result.add((String)it2.next());
        }

        return result;
    }

    /**
     * Intersects this set with the given other set.
     *
     * @return the intersection of the elements of this and that
     */
    public MySet intersection(MySet that) {
        MySet result = new MySet();
        // TODO
        if(that==null)
            that =  new MySet();
        Iterator it = this.iterator();
        while(it.hasNext())
        {
            String o = (String)it.next();
            if(that.contains(o))
                result.add(o);
        }

        return result;
    }

    /**
     * Gets the difference between this set and the given other set.
     *
     * @return the difference of the elements of this and that
     */
    public MySet difference(MySet that) {
        MySet result = new MySet();
        if(that==null)
            that =  new MySet();
        // TODO
        // TODO
        Iterator it = this.iterator();
        while(it.hasNext())
        {
            String o = (String)it.next();
            if(!that.contains(o))
                result.add(o);
        }


        return result;
    }

    /**
     * Gets the exclusive or between this set and the given other set.
     *
     * @return the exclusive or (XOR) of the elements of this and that
     */
    public MySet exclusiveOr(MySet that) {
        MySet result = new MySet();
        // TODO
        if(that==null)
            that =  new MySet();
        Iterator it = this.iterator();
        while(it.hasNext())
        {
            String o = (String)it.next();
            if(!that.contains(o))
                result.add(o);
        }
        Iterator it2 = that.iterator();
        while(it2.hasNext())
        {
            String o =(String) it2.next();
            if(!this.contains(o))
                result.add(o);
        }

        return result;
    }

    /**
     * Converts this set to a string representation.
     *
     * @return a String representation of a MySet object
     */
    public String toString() {
        // TODO
        String s ="<MySet{";
        Iterator it = this.iterator();
        int k=1;
        while(it.hasNext())
        {
            if(k==1)
            {
                s = s + it.next();
                k=0;
            }
            else
                s = s + ","+it.next();
        }

        s = s + "}>";
        return s;
    }
}
