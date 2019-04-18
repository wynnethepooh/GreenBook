import org.junit.jupiter.api.Test;
import util.TreeNode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Chapter4Test {

  Chapter4 chapter4 = new Chapter4();

  @Test
  public void routeBetweenNodes() {

  }

  @Test
  public void minimalTree() {
    TreeNode result;

    int[] evenSortedArray = new int[] { 0, 1, 2, 3, 4, 5 };
    // Even sorted tree:
    //     2
    //    / \
    //   0   4
    //    \ / \
    //    1 3  5
    TreeNode evenSortedTree = new TreeNode(new Integer[] {2, 0, 4, null, 1, 3, 5});
    result = chapter4.minimalTree(evenSortedArray);
    assertTrue(evenSortedTree.equalsTree(result));

    int[] oddSortedArray = new int[] { 0, 1, 2, 3, 4 };
    // Odd sorted tree:
    //     2
    //    / \
    //   0   3
    //    \   \
    //    1   4
    TreeNode oddSortedTree = new TreeNode(new Integer[] {2, 0, 3, null, 1, null, 4});
    result = chapter4.minimalTree(oddSortedArray);
    assertTrue(oddSortedTree.equalsTree(result));
  }

  @Test
  public void listOfDepths() {

  }

  @Test
  public void checkBalanced() {

  }

  @Test
  public void validateBST() {

    // Good tree:
    //     2
    //    / \
    //   2   3
    //  /   / \
    // 1   3   4
    TreeNode goodBST = new TreeNode(new Integer[]{2, 2, 3, 1, null, 3, 4});
    assertTrue(chapter4.validateBST(goodBST));
    System.out.println("Validated good BST");

    // Bad Tree:
    //    0
    //     \
    //      1
    //     / \
    //    2   2
    //   /
    //  3
    TreeNode badBST = new TreeNode(new Integer[]{0, null, 1, 2, 2, 3});
    assertFalse(chapter4.validateBST(badBST));
    System.out.println("Validated bad BST");
  }

  @Test
  public void successor() {

  }

  @Test
  public void buildOrder() {

  }

  @Test
  public void firstCommonAncestor() {

  }

  @Test
  public void bstSequences() {

  }

  @Test
  public void checkSubtree() {

  }

  @Test
  public void randomNode() {

  }

  @Test
  public void pathsWithSum() {

  }

  @Test
  public void validateTreeNodeFunctions() {
    /*

    Tree 1 and 2:
        0
         \
          1
         / \
        2   2
       /
      3

    Tree 3:
        0
         \
          1
           \
            2
           /
          3

     */
    TreeNode tree = new TreeNode(
            new Integer[]{0, null, 1, 2, 2, 3});

    TreeNode tree2 = new TreeNode(
            new Integer[]{0, null, 1, 2, 2, 3});
    TreeNode tree3 = new TreeNode(
            new Integer[]{0, null, 1, null, 2, 3});

    boolean valid = tree.equalsTree(tree2);
    valid = tree.equalsTree(tree3);

    assertTrue(tree.equalsTree(tree2));
    assertFalse(tree.equalsTree(tree3));

    System.out.println(tree.toString());
    System.out.println(tree3.toString());
  }
}
