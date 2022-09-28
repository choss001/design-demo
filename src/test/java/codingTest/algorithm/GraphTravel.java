package codingTest.algorithm;
import java.util.LinkedList;
import java.util.Queue;

public class GraphTravel {
  static class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int key) {
      data = key;
      left = right = null;
    }
  }

  static void preorder(TreeNode TreeNode) {
    if (TreeNode == null)
      return;

    // Traverse root
    System.out.print(TreeNode.data + " ");
    // Traverse left
    preorder(TreeNode.left);
    // Traverse right
    preorder(TreeNode.right);
  }

  static void inorder(TreeNode TreeNode) {
    if (TreeNode == null)
      return;

    // Traverse left
    inorder(TreeNode.left);
    // Traverse root
    System.out.print(TreeNode.data + " ");
    // Traverse right
    inorder(TreeNode.right);
  }

  static void postorder(TreeNode TreeNode) {
    if (TreeNode == null)
      return;

    // Traverse left
    postorder(TreeNode.left);
    // Traverse right
    postorder(TreeNode.right);
    // Traverse root
    System.out.print(TreeNode.data + " ");
  }
  static void printLevelOrder(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode tempNode = queue.poll();
      System.out.print(tempNode.data + " ");

      /*add left child to the queue */
      if (tempNode.left != null) {
        queue.add(tempNode.left);
      }

      /*add right right child to the queue */
      if (tempNode.right != null) {
        queue.add(tempNode.right);
      }
    }
  }

  public static void main(String args[])

  {
    TreeNode root = new TreeNode(0);
    root.left = new TreeNode(1);
    root.right = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(4);
    System.out.println("Inorder traversal");
    inorder(root);

    System.out.println("\nPreorder traversal ");
    preorder(root);

    System.out.println("\nPostorder traversal");
    postorder(root);

    System.out.println("\nLevelorder traversal");
    printLevelOrder(root);

  }

}