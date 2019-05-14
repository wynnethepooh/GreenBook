import org.junit.jupiter.api.Test;
import util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    assertEquals(expected, ec.rightSideView(tree));
  }
}