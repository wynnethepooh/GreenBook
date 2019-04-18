import org.junit.jupiter.api.Test;
import util.GraphNode;
import util.TreeNode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Chapter4Test {

  Chapter4 chapter4 = new Chapter4();

  @Test
  public void routeBetweenNodes() {
    GraphNode node0 = new GraphNode(0);
    GraphNode node1 = new GraphNode(1);
    GraphNode node2 = new GraphNode(2);
    GraphNode node3 = new GraphNode(3);
    GraphNode node4 = new GraphNode(4);
    GraphNode node5 = new GraphNode(5);

    node0.addAdjacent(node1);
    node0.addAdjacent(node2);
    node2.addAdjacent(node3);
    node3.addAdjacent(node4);

    assertTrue(chapter4.routeBetweenNodes(node0, node4),
            "Should have found route between nodes 0 and 4");
    assertFalse(chapter4.routeBetweenNodes(node0, node5),
            "Shouldn't have found route between nodes 0 and 5");
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
    assertTrue(evenSortedTree.equalsTree(result),
            "\nexpected: " + evenSortedTree.toString() +
            "\nactual: " + result.toString());

    int[] oddSortedArray = new int[] { 0, 1, 2, 3, 4 };
    // Odd sorted tree:
    //     2
    //    / \
    //   0   3
    //    \   \
    //    1   4
    TreeNode oddSortedTree = new TreeNode(new Integer[] {2, 0, 3, null, 1, null, 4});
    result = chapter4.minimalTree(oddSortedArray);
    assertTrue(oddSortedTree.equalsTree(result),
            "\nexpected: " + oddSortedTree.toString() +
            "\nactual: " + result.toString());
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
    assertTrue(chapter4.validateBST(goodBST), "Validation of good BST failed");
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
    assertFalse(chapter4.validateBST(badBST), "Validation of bad BST failed");
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
