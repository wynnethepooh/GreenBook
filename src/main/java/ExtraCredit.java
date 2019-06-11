import util.TreeNode;

import java.util.*;

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
    int[][][] dp = new int[n+1][2][3];
    initializeDP(dp);
    return countStr(n, 1, 2, dp);
  }

  private void initializeDP(int[][][] dp) {
    for (int n = 0; n < dp.length; n++) {
      for (int b = 0; b < dp[n].length; b++) {
        Arrays.fill(dp[n][b], -1);
      }
    }
  }

  private int countStr(int n,
                       int b,
                       int c,
                       int[][][] dp) {
    // Base cases
    if (b < 0 || c < 0) {
      return 0; // is not valid
    }
    if (n == 0 || (b == 0 && c == 0)) {
      return 1; // valid; can contain 1 or less b and 2 or less c
    }

    if (dp[n][b][c] != -1) {
      return dp[n][b][c];
    }

    int result = 0;
    result += countStr(n - 1, b, c, dp);
    result += countStr(n - 1, b - 1, c, dp);
    result += countStr(n - 1, b, c - 1, dp);

    dp[n][b][c] = result;
    return result;
  }

  /**
   * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be
   * validated according to the following rules:
   *
   *  - Each row must contain the digits 1-9 without repetition.
   *  - Each column must contain the digits 1-9 without repetition.
   *  - Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9
   *    without repetition.
   *
   * The Sudoku board could be partially filled, where empty cells are filled
   * with the character '.'.
   *
   * Example 1:
   *
   *  Input:
   *  [
   *   ['5','3','.','.','7','.','.','.','.'],
   *   ['6','.','.','1','9','5','.','.','.'],
   *   ['.','9','8','.','.','.','.','6','.'],
   *   ['8','.','.','.','6','.','.','.','3'],
   *   ['4','.','.','8','.','3','.','.','1'],
   *   ['7','.','.','.','2','.','.','.','6'],
   *   ['.','6','.','.','.','.','2','8','.'],
   *   ['.','.','.','4','1','9','.','.','5'],
   *   ['.','.','.','.','8','.','.','7','9']
   *  ]
   *  Output: true
   *
   * Example 2:
   *
   *  Input:
   *  [
   *   ['8','3','.','.','7','.','.','.','.'],
   *   ['6','.','.','1','9','5','.','.','.'],
   *   ['.','9','8','.','.','.','.','6','.'],
   *   ['8','.','.','.','6','.','.','.','3'],
   *   ['4','.','.','8','.','3','.','.','1'],
   *   ['7','.','.','.','2','.','.','.','6'],
   *   ['.','6','.','.','.','.','2','8','.'],
   *   ['.','.','.','4','1','9','.','.','5'],
   *   ['.','.','.','.','8','.','.','7','9']
   *  ]
   *  Output: false
   *  Explanation: Same as Example 1, except with the 5 in the top left corner
   *    being modified to 8. Since there are two 8's in the top left 3x3
   *    sub-box, it is invalid.
   *
   * Note:
   *
   * - A Sudoku board (partially filled) could be valid but is not necessarily
   *   solvable.
   * - Only the filled cells need to be validated according to the mentioned
   *   rules.
   * - The given board contain only digits 1-9 and the character '.'.
   * - The given board size is always 9x9.
   *
   * @param board 9x9 board
   * @return true if valid sudoku board
   */
  public boolean validateSudoku(char[][] board) {

    for (int row = 0; row < board.length; row++) {
      Set<Character> rows = new HashSet<>();
      Set<Character> cols = new HashSet<>();
      Set<Character> squares = new HashSet<>();

      for (int col = 0; col < board[0].length; col++) {
        // Add num to rows set and if it is not unique, return false
        if (board[row][col] != '.' && !rows.add(board[row][col])) {
          return false;
        }

        // Add num to cols set and if it is not unique, return false
        if (board[col][row] != '.' && !cols.add(board[col][row])) {
          return false;
        }

        // Add num to squares set and if it is not unique, return false
        int subRow = (row / 3) * 3;
        int subCol = (row % 3) * 3;

        if (board[subRow + col/3][subCol + col%3] != '.'
                && !squares.add(board[subRow + col/3][subCol + col%3])) {
          return false;
        }
      }
    }

    return true;
  }

  /**
   * Given a Binary Search Tree (BST) and a range, count number of nodes that
   * lie in the given range.
   *
   * Examples:
   *
   * Input:
   *      10
   *     /  \
   *    5   50
   *   /   /  \
   *  1   40  100
   *
   * Range: [5, 45]
   *
   * Output:  3
   *
   * @param root root of tree
   * @param start start of range
   * @param end end of range
   * @return
   */
  public int countNodesInRange(TreeNode root, int start, int end) {
    return countNodes(root, start, end, 0);
  }

  private int countNodes(TreeNode root, int start, int end, int count) {
    // If node is null, return current count
    if (root == null) {
      return count;
    }

    // Get count in left subtree
    count = countNodes(root.left, start, end, count);

    // If value is between start and end, increment count
    if (root.data >= start && root.data <= end) {
      count++;
    }

    // Get count in right subtree
    count = countNodes(root.right, start, end, count);

    return count;
  }

  /**
   * Given an NxM matrix, return a matrix with the number of paths from the top
   * left corner to any position.
   *
   * @param matrix NxM matrix
   * @return matrix with each position containing number of paths to that
   * position
   */
  public int[][] countPathsInMatrix(int[][] matrix) {
    initializeFirstRowCol(matrix);
    countPathsHelper(matrix);
    return matrix;
  }

  private void initializeFirstRowCol(int[][] matrix) {
    for (int col = 0; col < matrix[0].length; col++) {
      matrix[0][col] = 1;
    }
    for (int row = 0; row < matrix.length; row++) {
      matrix[row][0] = 1;
    }
  }

  private void countPathsHelper(int[][] matrix) {

    for (int row = 1; row < matrix.length; row++) {
      for (int col = 1; col < matrix[row].length; col++) {
        // Increment matrix at row, col
        matrix[row][col] = matrix[row-1][col] + matrix[row][col-1];
      }
    }
  }

  /**
   * Find the maximum sum leaf to root path in a binary tree.
   *
   * Given a binary tree, find the maximum sum path from a leaf to root. For
   * example, in the following tree, there are three leaf to root paths
   * 8 -> -2 -> 10, -4 -> -2 -> 10 and 7 -> 10. The sums of these three paths
   * are 16, 4 and 17 respectively. The maximum of them is 17 and the path for
   * maximum is 7 -> 10.
   *
   *        10
   *       /  \
   *     -2   7
   *     / \
   *    8  -4
   *
   * @param root root of tree
   * @return maximum path sum from leaf to root
   */
  public List<Integer> maxSumPath(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    maxSumPathHelper(root, 0, result);
    return result;
  }

  int maxSumPathVal = Integer.MIN_VALUE;

  private void maxSumPathHelper(TreeNode node, int sum, List<Integer> result) {
    // Base case: null or leaf; if null, return 0, if leaf, return leaf value
    if (node == null) {
      return;
    }

    // Add current data to sum
    int currentSum = node.data + sum;
    // If node is leaf and sum > maxSumPathVal
    if (node.left == null && node.right == null) {
      if (currentSum > maxSumPathVal){
        // update maxSumPathVal
        maxSumPathVal = currentSum;
        // reset result list and add leaf data
        result.clear();
        result.add(node.data);
      }
      return;
    }

    // Recurse on left and right
    maxSumPathHelper(node.left, currentSum, result);
    maxSumPathHelper(node.right, currentSum, result);

    // If result isn't empty, add current data to result (moving up tree)
    if (!result.isEmpty()) {
      result.add(node.data);
    }
  }

  /**
   * Find the maximum path sum between two leaves of a binary tree.
   *
   * Given a binary tree in which each node element contains a number, find the
   * maximum possible sum from one leaf node to another. The maximum sum path
   * may or may not go through root. For example, in the following binary tree,
   * the maximum sum is 27(3 + 6 + 9 + 0 – 1 + 10). Expected time complexity
   * is O(n).
   *
   *        -15
   *        /  \
   *       5    6
   *      / \  / \
   *    -8  1 3  9
   *    / \       \
   *   2  6       0
   *             / \
   *            4  -1
   *               /
   *              10
   *
   * If one side of root is empty, then function should return minus infinite.
   *
   * @param root root of tree
   * @return maximum path sum between any two leaves
   */
  public int maxSumBetweenLeaves(TreeNode root) {
    maxSumBetweenLeavesHelper(root);
    return maxSumBetweenLeaves;
  }

  int maxSumBetweenLeaves = Integer.MIN_VALUE;

  private int maxSumBetweenLeavesHelper(TreeNode current) {
    // Base case: leaf node (no left or right), return value of leaf
    if (current == null) {
      return 0;
    }
    if (current.left == null && current.right == null) {
      return current.data;
    }

    // Get left and right path sums
    int left = maxSumBetweenLeavesHelper(current.left);
    int right = maxSumBetweenLeavesHelper(current.right);

    // At each node, set max of max and (left + right max path sums + current)
    maxSumBetweenLeaves = Math.max(
            maxSumBetweenLeaves,
            left + right + current.data);
    // return current + max(left, right)
    return current.data + Math.max(left, right);
  }

  /**
   * Find kth smallest element in BST (Order Statistics in BST)
   *
   * Given root of binary search tree and K as input, find kth smallest element
   * in the BST.
   *
   * For example, in the following BST, if k = 3, then output should be 10, and
   * if k = 5, then output should be 14.
   *
   *        20
   *       /  \
   *      8   22
   *     / \
   *    4  12
   *      /  \
   *     10  14
   *
   * @param root root of binary search tree
   * @param k k
   * @return kth smallest element in tree
   */
  public int returnKthSmallestBST(TreeNode root, int k) {
    return 0;
  }
}
