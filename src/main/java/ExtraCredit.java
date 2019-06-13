import util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    return null;
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
    return false;
  }

  /**
   * Convert a given tree to its sum tree.
   *
   * Given a binary tree where each node has positive and negative values,
   * convert this to a tree where each node contains the sum of the left and
   * right sub trees in the original tree. The values of leaf nodes are changed
   * to 0.
   *
   * For example, the following tree
   *
   *                 10
   *                /  \
   *              -2   6
   *             / \  / \
   *            8 -4 7  5
   * should be changed to
   *
   *                  20=(((8-4)-2)+((7+5)+6))
   *                /      \
   *          4=(8-4)      12=(7+5)
   *            /   \      /  \
   *          0      0    0    0
   *
   * @param root root of tree
   */
  public void transformToSumTree(TreeNode root) {

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
    return null;
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
    return false;
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
    return 0;
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
    return matrix;
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
    return null;
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
    return Integer.MIN_VALUE;
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

  /**
   * Given a binary tree, write a function to get the maximum width of the
   * given tree. Width of a tree is maximum of widths of all levels.
   *
   * Let us consider the below example tree.
   *
   *          1
   *         /  \
   *        2    3
   *      /  \     \
   *     4    5     8
   *               /  \
   *              6    7
   *
   * For the above tree,
   * width of level 1 is 1,
   * width of level 2 is 2,
   * width of level 3 is 3
   * width of level 4 is 2.
   *
   * So the maximum width of the tree is 3.
   *
   * @param root root of tree
   * @return maximum width of tree
   */
  public int maxWidthOfBinaryTree(TreeNode root) {
    return -1;
  }

  /**
   * Construct all possible binary search trees for keys 1 to N.
   *
   * For example, for N = 2, there are 2 unique BSTs
   *      1               2
   *       \            /
   *        2         1
   *
   * For N = 3, there are 5 possible BSTs
   *   1              3        3         2      1
   *     \           /        /        /  \      \
   *      3        2         1        1    3      2
   *     /       /            \                    \
   *    2      1               2                    3
   */
  public List<TreeNode> uniqueBSTs(int n) {
    return new ArrayList<>();
  }

  /**
   * Given two lists of integers, return a list of the integers that appear in
   * both input lists.
   *
   * Example:
   *    a: [1, 2, 3]
   *    b: [2, 5]
   *    output: [2]
   *
   * Can you do it with no auxiliary space?
   */
  public List<Integer> sameNumbers(List<Integer> list1, List<Integer> list2) {
    return new ArrayList<>();
  }
}
