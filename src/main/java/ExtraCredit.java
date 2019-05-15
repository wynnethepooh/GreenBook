import util.TreeNode;

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
}
