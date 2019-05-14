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
    int count = 0;

    if (grid.length == 0) {
      return count;
    }

    boolean[][] visited = new boolean[grid.length][grid[0].length];

    // Go through rows and columns
    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[0].length; col++) {
        // If item is land and has not been visited, DFS on its neighbors
        if (grid[row][col] == '1' && !visited[row][col]) {
          visitNeighbors(grid, visited, row, col);
          count++;
        }
      }
    }

    return count;
  }

  private void visitNeighbors(char[][] grid,
                              boolean[][] visited,
                              int row,
                              int col) {
    if (grid[row][col] == '0' || visited[row][col]) {
      return;
    }

    visited[row][col] = true;

    // Recurse on top, bottom, left, right
    if (row > 0) {
      visitNeighbors(grid, visited, row - 1, col);
    }
    if (row < grid.length - 1) {
      visitNeighbors(grid, visited, row + 1, col);
    }
    if (col > 0) {
      visitNeighbors(grid, visited, row, col - 1);
    }
    if (col < grid[0].length - 1) {
      visitNeighbors(grid, visited, row, col + 1);
    }
  }

  /**
   * Given a binary tree, imagine yourself standing on the right side of it,
   * return the values of the nodes you can see ordered from top to bottom.
   *
   * Example:
   *
   * Input: [1,2,3,null,5,null,4,7]
   *      1
   *     / \
   *    2  3
   *    \   \
   *    5   4
   *   /
   *  7
   *
   * Output: [1, 3, 4, 7]
   *
   * @param root root of tree
   * @return right view of tree
   */
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Queue<TreeNode> nextLevel = new LinkedList<>();
    nextLevel.add(root);

    while (!nextLevel.isEmpty()) {
      Queue<TreeNode> currentLevel = nextLevel;
      nextLevel = new LinkedList<>();

      TreeNode node = null;

      while (currentLevel.peek() != null) {
        node = currentLevel.poll();
        if (node.left != null) {
          nextLevel.add(node.left);
        }
        if (node.right != null) {
          nextLevel.add(node.right);
        }
      }
      result.add(node.data);
    }
    return result;
  }

  /**
   * Count of strings that can be formed using a, b and c under given
   * constraints.
   *
   * Given a length n, count the number of strings of length n that can be made
   * using ‘a’, ‘b’ and ‘c’ with at-most one ‘b’ and two ‘c’s allowed.
   *
   * Examples :
   *
   *  Input : n = 3
   *  Output : 19
   *
   *  Below strings follow given constraints:
   *    aaa   bca
   *    aab   bcc
   *    aac   caa
   *    aba   cab
   *    abc   cac
   *    aca   cba
   *    acb   cbc
   *    acc   cca
   *    baa   ccb
   *    bac
   *
   *  Input  : n = 4
   *  Output : 39
   *
   * @param n string length
   * @return count of strings that can be formed under constraints
   */
  public int countCombinationStrings(int n) {
    return 0;
  }
}
