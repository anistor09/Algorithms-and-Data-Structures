package Exercises;

import Exercises.Library.BinaryTree;

public class NodesCounterPerLevel {
    /**
     * Counts the number of nodes in the tree at a certain level.
     *
     * @param tree
     *     The binary tree to count nodes in.
     * @param level
     *     The specified level to count nodes in.
     * @return the number of nodes at that level, or 0 if tree is null.
     */
    public static int countNodesAtLevel(BinaryTree tree, int level) {
        // TODO
        if(tree==null)
            return 0;
        return countNodesAtLevelHelper(tree,level,0);
    }
    public static int countNodesAtLevelHelper(BinaryTree tree,int level,int current)
    {
        if(tree==null)
            return 0;
        if(current == level)
            return 1;
        return countNodesAtLevelHelper(tree.getLeft(),level,current+1)+countNodesAtLevelHelper(tree.getRight(),level,current+1);
    }
}
