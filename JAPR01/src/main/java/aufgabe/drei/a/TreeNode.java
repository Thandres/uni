package aufgabe.drei.a;

class TreeNode { // innereKlasse
  final int value;
  TreeNode left, right;

  public TreeNode(int value) {
    this.value = value;
  }

  public void add(int value) {
    if (value > this.value) {
      if (right == null) right = new TreeNode(value);
      else right.add(value);
    } else {
      if (left == null) left = new TreeNode(value);
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

  public boolean contains(int value) {
    return isThis(value) || inSubTree(value);
  }

  private boolean inSubTree(int value) {
    return value > this.value ? inRightSubTree(value) : inLeftSubTree(value);
  }

  private boolean inLeftSubTree(int value) {
    return left != null && this.left.contains(value);
  }

  private boolean inRightSubTree(int value) {
    return right != null && this.right.contains(value);
  }

  private boolean isThis(int value) {
    return this.value == value;
  }
}
