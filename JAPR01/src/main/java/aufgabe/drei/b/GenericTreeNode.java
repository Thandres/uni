package aufgabe.drei.b;

public class GenericTreeNode<T extends Comparable<T>> {
    final T value;
    GenericTreeNode<T> left, right;

    public GenericTreeNode(T value) {
        this.value = value;
    }

    public void add(T value) {
        if (value.compareTo(this.value) > 0) {
            if (right == null) right = new GenericTreeNode<>(value);
            else right.add(value);
        } else {
            if (left == null) left = new GenericTreeNode<>(value);
            else left.add(value);
        }
    }

    @Override
    public String toString() {
        String result = "";
        if (left != null) result = left.toString();
        result += "" + value;
        if (right != null) result += right.toString();
        return result;
    }

    public boolean contains(T value) {
        return isThis(value) || inSubTree(value);
    }

    private boolean inSubTree(T value) {
        return value.compareTo(this.value) > 0? inRightSubTree(value) : inLeftSubTree(value);
    }

    private boolean inLeftSubTree(T value) {
        return left != null && this.left.contains(value);
    }

    private boolean inRightSubTree(T value) {
        return right != null && this.right.contains(value);
    }

    private boolean isThis(T value) {
        return this.value.equals(value);
    }
}
