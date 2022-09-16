package Exercises;

import Exercises.Library.BinaryTree;

public class isAVLTree {
    /**
     * Computes whether the BinaryTree is an AVL tree.
     *
     * @param tree
     *     the BinaryTree to check.
     * @return true iff the BinaryTree is an AVL tree, else false.
     */
    public static boolean isTreeAVL(BinaryTree tree) {
        return isBalanced(tree)&&isTreeBST(tree);
    }

    public static boolean isBalanced(BinaryTree tree){
        if(tree == null){
            return true;
        }
        if(Math.abs(height(tree.getLeft())-height(tree.getRight()))>1){
            return false;
        }
        else {
            return isBalanced(tree.getLeft())&&isBalanced(tree.getRight());
        }
    }

    public static int height(BinaryTree tree){
        if(tree == null){
            return 0;
        }
        else {
            return Math.max(height(tree.getLeft()), height(tree.getRight()))+1;
        }
    }

    public static boolean isTreeBST(BinaryTree tree) {

        return isTreeBSTHelper(tree,Integer.MIN_VALUE,Integer.MAX_VALUE);

    }
    public static boolean isTreeBSTHelper(BinaryTree tree, int min, int max)
    {
        if(tree==null)
            return true;
        if(tree.getKey()<min||tree.getKey()>max)
            return false;
        return (isTreeBSTHelper(tree.getLeft(),min,tree.getKey()-1)&&isTreeBSTHelper(tree.getRight(),tree.getKey()+1,max));

    }
}
