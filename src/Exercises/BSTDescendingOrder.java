package Exercises;

import Exercises.Library.BinaryTree;

import java.util.*;

class BSTDescendingOrder {

    /**
     * Return all elements in the given BST in descending order.
     *
     * @param tree
     *     The BST to traverse.
     * @return A list of all elements in reverse order.
     */
    public static List<Integer> descendingOrder(BinaryTree tree) {
        // TODO
        Stack<BinaryTree> temp = new Stack();
        temp.push(tree);
        List<Integer> ans = new ArrayList();
        while(!temp.isEmpty())
        {    BinaryTree current = temp.peek();
            if(current.hasRight())
            {
                temp.push(current.getRight());
                current.setRight(null);
            }
            else if(current.hasLeft())
            {
                temp.pop();
                temp.push(current.getLeft());
                ans.add(current.getKey());
            }
            else{
                temp.pop();
                ans.add(current.getKey());
            }
        }
        return ans;



    }
}

