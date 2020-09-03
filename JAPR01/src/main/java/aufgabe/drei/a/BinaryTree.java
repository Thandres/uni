package aufgabe.drei.a;

public class BinaryTree {

  TreeNode root = null; // WurzeldesBaums

  public void add(int value) {
    if (root == null) root = new TreeNode(value);
    else root.add(value);
  }

  public boolean contains(int value) {
    return root != null && root.contains(value);
  }

  @Override
  public String toString() {
    String result = "";
    if (root != null) result = root.toString();
    return result;
  }
}
