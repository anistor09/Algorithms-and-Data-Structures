package Exercises;
import Exercises.Library.BinaryTreeRedBlack;


public class IsRedBlackTree {
    /**
     * Checks whether the given BinaryTree is a Red Black Tree.
     *
     * @param tree
     *     BinaryTree to check.
     * @return True if the given tree is a Red Black Tree, false otherwise.
     */
    public static int generalBlackDepth;
    public static boolean isRedBlackTree(BinaryTreeRedBlack tree) {
        // TODO
        if(tree==null)
            return true;
        generalBlackDepth=calculateBlackDepth(tree,0);
        System.out.println(generalBlackDepth);
        System.out.println(isBST(tree));
        System.out.println(tree.isBlack());
        System.out.println(redProperty(tree));
        System.out.println(blackDepthPropriety(tree,0));

        return isBST(tree)&&tree.isBlack()&&redProperty(tree)&&blackDepthPropriety(tree,0)
                ;//&& externalPropriety(tree);
    }
    public static boolean isBST(BinaryTreeRedBlack tree)
    {
        return isBSTHelper(tree,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public static boolean isBSTHelper(BinaryTreeRedBlack tree, int min, int max)
    {
        if(tree==null)
        {
            return true;

        }
        if(tree.getValue()<min||tree.getValue()>max)
            return false;

        return isBSTHelper(tree.getLeft(),min,tree.getValue()-1)&&
                isBSTHelper(tree.getRight(),tree.getValue()+1,max);
    }
    public static boolean redProperty(BinaryTreeRedBlack tree)
    {
        if(tree==null)
            return true;

        if(tree.isRed())
        {
            if(tree.hasLeft() && tree.getLeft().isRed())
                return false;

            if(tree.hasRight()&& tree.getRight().isRed())
                return false;
        }
        return redProperty(tree.getLeft())&&redProperty(tree.getRight());
    }
    /* public static boolean externalPropriety(BinaryTree tree)
     {
         if(tree==null)
         return true;
         if(!tree.hasLeft()&&!tree.hasRight()&&tree.isRed())
         return false;
         return true;
     }
     */
    public static int calculateBlackDepth(BinaryTreeRedBlack tree,int aux)
    {
        if(tree==null)
        {
            return aux;
        }
        if(tree.isBlack())
            aux++;

        return Math.max(calculateBlackDepth(tree.getLeft(),aux),calculateBlackDepth(tree.getRight(),aux));
    }
    public static boolean blackDepthPropriety(BinaryTreeRedBlack tree, int aux)
    {
        if(tree==null)
        {
            if(aux!=generalBlackDepth)
            {return false;}
            else
            {
                return true;
            }
        }

        if(tree.isBlack())
            aux++;
        return blackDepthPropriety(tree.getLeft(),aux)&&blackDepthPropriety(tree.getRight(),aux);

    }
}
