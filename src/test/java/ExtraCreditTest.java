import org.junit.jupiter.api.Test;
import util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ExtraCreditTest {

  ExtraCredit ec = new ExtraCredit();

  @Test
  public void diagonalSums() {
    /*
     Tree:
               1
             /  \
            /    \
           2      3
         /  \    / \
        9    6  4  5
         \  /  / \
        10 11 12 7

     The first diagonal includes 1 + 3 + 5 = 9
     The second diagonal includes 2 + 6 + 4 + 7 = 19
     The third diagonal includes 9 + 10 + 11 + 12 = 42
     The output should be [9, 19, 42]

     */

    TreeNode tree = new TreeNode(
            new Integer[] {1, 2, 3, 9, 6, 4, 5, null, 10, 11, null, 12, 7});
    List<Integer> expected = new ArrayList<>();
    expected.add(9);
    expected.add(19);
    expected.add(42);

    List<Integer> result = ec.diagonalSums(tree);
    assertEquals(expected, result);
  }

  @Test
  public void childSum() {
    /*
       Valid tree:

             10
            /  \
           8    2
          / \    \
         3   5    2
     */
    TreeNode valid = new TreeNode(
            new Integer[] { 10, 8, 2, 3, 5, null, 2 });

    /*
       Invalid tree:

             10
            /  \
           7    3
          / \    \
         5   3    3

     */
    TreeNode invalid = new TreeNode(
            new Integer[] { 10, 7, 3, 5, 3, null, 3 });

    assertTrue(ec.childSum(valid),
            valid.toString() + " should be valid");
    assertFalse(ec.childSum(invalid),
            invalid.toString() + " should be invalid");
  }

  @Test
  public void transformToSumTree() {
    TreeNode tree = new TreeNode(new Integer[] {
            10,
            -2, 6,
            8, -4, 7, 5
    });
    TreeNode expected = new TreeNode(new Integer[] {
            20,
            4, 12,
            0, 0, 0, 0
    });
    TreeNode result = ec.transformToSumTree(tree);
    assertNotNull(result);

    assertTrue(expected.equalsTree(result),
            "expected: \n" + expected.toString()
                    + "\nactual: \n" + result.toString());
  }

  @Test
  public void numberOfIslands() {
    char[][] grid = new char[][] {
            { '1','1','1','1','0' },
            { '1','1','0','1','0' },
            { '1','1','0','0','0' },
            { '0','0','0','0','0' }};
    int result = ec.numberOfIslands(grid);
    assertEquals(1, result,
            "\n" + Arrays.deepToString(grid).replace("], ", "]\n")
                    + "\nOutput should be 1 island");

    grid = new char[][] {
            { '1','1','0','0','0' },
            { '1','1','0','0','0' },
            { '0','0','1','0','0' },
            { '0','0','0','1','1' }};
    result = ec.numberOfIslands(grid);
    assertEquals(3, result,
            "\n" + Arrays.deepToString(grid).replace("], ", "]\n")
                    + "\nOutput should be 3 islands");
  }

  @Test
  public void rightSideView() {
    /*
     Tree:

           1
          / \
         2  3
         \   \
         5   4
        /
       7

      Expected output: [1, 3, 4, 7]
     */
    TreeNode tree = new TreeNode(new Integer[]
            { 1, 2, 3, null, 5, null, 4, 7 });
    List<Integer> expected = Arrays.asList(1, 3, 4, 7);

    assertEquals(expected, ec.rightSideView(tree),
            tree.toString() + " should have returned list " +
            expected.toString());
  }

  @Test
  public void countCombinationStrings() {
    int expected = 19;
    int length = 3;
    assertEquals(expected, ec.countCombinationStrings(length),
            "There should be " + expected + " possible combinations of " +
                    "string length 3");

    expected = 39;
    length = 4;
    assertEquals(expected, ec.countCombinationStrings(length),
            "There should be " + expected + " possible combinations of " +
                    "string length 3");
  }

  @Test
  public void validateSudoku() {
    char[][] valid = new char[][] {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
    };
    assertTrue(ec.validateSudoku(valid));

    char[][] invalid = new char[][] {
            {'8','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
    };
    assertFalse(ec.validateSudoku(invalid));
  }

  @Test
  public void countNodesInRange() {
    /*
     * Input:
     *       10
     *      /  \
     *     5    50
     *    /    /  \
     *   1    40  100
     *
     * Range: [5, 45]
     *
     * Output: 3
     */
    TreeNode tree = new TreeNode(new Integer[]{10, 5, 50, 1, null, 40, 100});
    assertEquals(3, ec.countNodesInRange(tree, 5, 45));
  }

  @Test
  public void countPathsInMatrix() {
    /*
    1 1 1 1
    1 2 3 4
    1 3 6 10
     */
    int[][] matrix = new int[3][4];
    int[][] expected = new int[][] {
            { 1, 1, 1, 1 },
            { 1, 2, 3, 4 },
            { 1, 3, 6, 10}
    };
    int[][] result = ec.countPathsInMatrix(matrix);

    System.out.println("\nExpected: \n" + Arrays.deepToString(expected));
    System.out.println("\nActual: \n" + Arrays.deepToString(result));
    for (int row = 0; row < matrix.length; row++) {
      assertTrue(Arrays.equals(expected[row], result[row]));
    }
  }

  @Test
  public void maxPathSum() {
    /*
     *        10
     *       /  \
     *     -2   7
     *     / \
     *    8  -4
     */
    TreeNode tree = new TreeNode(new Integer[] {
            10,
            -2, 7,
            8, -4
    });
    Integer[] expectedArray = new Integer[] { 7, 10 };
    List<Integer> expected = Arrays.asList(expectedArray);

    assertEquals(expected, ec.maxSumPath(tree));
  }

  @Test
  public void maxSumBetweenLeaves() {
    /*
     *        -15
     *        /  \
     *       5    6
     *      / \  / \
     *    -8  1  3  9
     *    / \        \
     *   2  6        0
     *              / \
     *             4  -1
     *                /
     *               10
     */
    TreeNode tree = new TreeNode(new Integer[] {
            -15,
            5, 6,
            -8, 1, 3, 9,
            2, 6, null, null, null, null, null, 0,
            null, null, null, null, 4, -1,
            null, null, 10
    });

    assertEquals(27, ec.maxSumBetweenLeaves(tree));
  }

  @Test
  public void returnKthSmallestBST() {
    /*
     *        20
     *       /  \
     *      8   22
     *     / \
     *    4  12
     *      /  \
     *     10  14
     */
    TreeNode tree = new TreeNode(new Integer[] {
            20,
            8, 22,
            4, 12, null, null,
            null, null, 10, 14
    });

    assertEquals(4, ec.returnKthSmallestBST(tree, 1));
    assertEquals(8, ec.returnKthSmallestBST(tree, 2));
    assertEquals(10, ec.returnKthSmallestBST(tree, 3));
    assertEquals(12, ec.returnKthSmallestBST(tree, 4));
    assertEquals(14, ec.returnKthSmallestBST(tree, 5));
    assertEquals(20, ec.returnKthSmallestBST(tree, 6));
    assertEquals(22, ec.returnKthSmallestBST(tree, 7));
  }
}
