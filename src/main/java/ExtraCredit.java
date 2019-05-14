import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ExtraCredit {

  /**
   * Consider lines of slope -1 passing between nodes (dotted lines in below
   * diagram). The diagonal sum in a binary tree is the sum of all node’s data
   * lying between these lines. Given a Binary Tree, print all diagonal sums.
   *
   * Example:
   *          1
   *        /  \
   *       /    \
   *      2      3
   *    /  \    / \
   *   9    6  4  5
   *    \  /  / \
   *   10 11 12 7
   *
   * The first diagonal includes 1 + 3 + 5 = 9
   * The second diagonal includes 2 + 6 + 4 + 7 = 19
   * The third diagonal includes 9 + 10 + 11 + 12 = 42
   * The output should be [9, 19, 42]
   *
   * @param root root node
   * @return list of diagonal sums
   */
  public List<Integer> diagonalSums(TreeNode root) {
    List<Integer> sums = new ArrayList<>();

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (queue.size() > 0) {
      Queue<TreeNode> diagonal = queue;
      queue = new LinkedList<>();

      int sum = 0;

      while (diagonal.size() > 0) {
        TreeNode node = diagonal.poll();
        sum += node.data;

        if (node.right != null) {
          diagonal.add(node.right);
        }
        if (node.left != null) {
          queue.add(node.left);
        }
      }
      sums.add(sum);
    }
    return sums;
  }

  /**
   * Given a binary tree, write a function that returns true if the tree
   * satisfies the following property:
   *    For every node, data value must be equal to the sum of data values in
   *    left and right children. Consider data value as 0 for NULL child.
   *
   * Example:
   *  Valid tree:
   *        10
   *       /  \
   *      8   2
   *     / \   \
   *    3  5   2
   *
   *  Invalid tree:
   *        10
   *       /  \
   *      7   3
   *     / \   \
   *    5  3   3
   *
   * @param root root of tree
   * @return true if tree has child sum property
   */
  public boolean childSum(TreeNode root) {
    if (root == null || (root.left == null && root.right == null)) {
      return true;
    }

    int sum = (root.left == null ? 0 : root.left.data) +
            (root.right == null ? 0 : root.right.data);

    if (sum == root.data) {
      return childSum(root.left) && childSum(root.right);
    } else {
      return false;
    }
  }

  /**
   * Given a 2d grid map of '1's (land) and '0's (water), count the number of
   * islands. An island is surrounded by water and is formed by connecting
   * adjacent lands horizontally or vertically. You may assume all four edges
   * of the grid are all surrounded by water.
   *
   * Example 1:
   *
   *  Input:
   *    11110
   *    11010
   *    11000
   *    00000
   *
   *  Output: 1
   *
   * Example 2:
   *
   *  Input:
   *    11000
   *    11000
   *    00100
   *    00011
   *
   *  Output: 3
   *
   * @param grid grid of '1's and '0's
   * @return number of islands
   */
  public int numberOfIslands(char[][] grid) {
    return 0;
  }
}
