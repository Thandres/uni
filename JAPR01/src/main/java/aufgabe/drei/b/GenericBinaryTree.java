package aufgabe.drei.b;



public class GenericBinaryTree<T extends Comparable<T>> {

    GenericTreeNode<T> root = null; // WurzeldesBaums

    public void add(T value) {
        if (root == null) root = new GenericTreeNode<>(value);
        else root.add(value);
    }

    public boolean contains(T value) {
        return root != null && root.contains(value);
    }

    @Override
    public String toString() {
        String result = "";
        if (root != null) result = root.toString();
        return result;
    }
}
