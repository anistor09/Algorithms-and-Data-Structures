package Exercises.Library;

public class BinaryTreeRedBlack {
    private int value;

    private BinaryTreeRedBlack left, right;

    private boolean isRed;

    /**
     * Simple constructor.
     *
     * @param value
     *     Value for this tree set as value.
     * @param isRed
     *     True if this node is red, false otherwise.
     */
    public BinaryTreeRedBlack(int value, boolean isRed) {
        this.value = value;
        this.isRed = isRed;
    }

    /**
     * Extended constructor.
     *
     * @param value
     *     to set as value.
     * @param left
     *     to set as left child.
     * @param right
     *     to set as right child.
     */
    public BinaryTreeRedBlack(int value, boolean isRed, BinaryTreeRedBlack left, BinaryTreeRedBlack right) {
        this(value, isRed);
        setLeft(left);
        setRight(right);
    }

    /**
     * @return the value of this tree.
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value
     *     the new value of this tree.
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * @return the left child.
     */
    public BinaryTreeRedBlack getLeft() {
        return left;
    }

    /**
     * @return the right child.
     */
    public BinaryTreeRedBlack getRight() {
        return right;
    }

    /**
     * @return true if this node is red, false otherwise.
     */
    public boolean isRed() {
        return isRed;
    }

    /**
     * @return true if this node is black, false otherwise.
     */
    public boolean isBlack() {
        return !isRed;
    }

    /**
     * @return True if the tree has a left child, false otherwise.
     */
    public boolean hasLeft() {
        return left != null;
    }

    /**
     * @return True if the tree has a right child, false otherwise.
     */
    public boolean hasRight() {
        return right != null;
    }

    /**
     * @param left
     *     Left subtree to set.
     */
    public void setLeft(BinaryTreeRedBlack left) {
        this.left = left;
    }

    /**
     * @param right
     *     Right subtree to set.
     */
    public void setRight(BinaryTreeRedBlack right) {
        this.right = right;
    }

    /**
     * @param red
     *     True if the new color is red, false otherwise.
     */
    public void setRed(boolean red) {
        isRed = red;
    }
}
