import util.GraphNode;
import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class Chapter4 {

  /**
   * Given a directed graph, design an algorithm to find out whether there is a
   * route between two nodes.
   *
   * @param n1 node 1
   * @param n2 node 2
   * @return true if there is a route between the nodes
   */
  public boolean routeBetweenNodes(GraphNode n1, GraphNode n2) {
    return false;
  }

  /**
   * Given a sorted (increasing order) array with unique integer elements,
   * write an algorithm to create a binary search tree with minimal height.
   *
   * @param nums array of sorted (increasing order) unique integer elements
   * @return binary search tree
   */
  public TreeNode minimalTree(int[] nums) {
    return createBST(nums, 0, nums.length - 1);
  }

  private TreeNode createBST(int[] nums, int beginning, int end) {
    if (end < beginning) {
      return null;
    }

    // Take middle element and set as root
    int midpoint = (beginning + end) / 2;
    TreeNode root = new TreeNode(nums[midpoint]);

    // Recursively insert middle of left and right into tree
    root.left = createBST(nums, beginning, midpoint - 1);
    root.right = createBST(nums, midpoint + 1, end);
    return root;
  }


  /**
   * Given a binary tree, design an algorithm which creates a linked list of all
   * the nodes at each depth (e.g., if you have a tree with depth 0, you'll have
   * 0 linked lists).
   *
   * @param root root of binary tree
   * @return list of linked lists of nodes at each depth
   */
  public ArrayList<LinkedList<TreeNode>> listOfDepths(TreeNode root) {
    return null;
  }

  /**
   * Implement a function to check if a binary tree is balanced. For the
   * purposes of this question, a balanced tree is defined to be a tree such
   * that the heights of the two subtrees of any node never differ by more than
   * one.
   *
   * @param root root of binary tree
   * @return true if binary tree is balanced
   */
  public boolean checkBalanced(TreeNode root) {
    return false;
  }

  private Integer lastValue = null;

  /**
   * Implement a function to check if a binary tree is a binary search tree.
   *
   * @param root root of binary tree
   * @return true if binary tree is binary search tree
   */
  public boolean validateBST(TreeNode root) {

    // Binary tree is left <= current < right

    // Check if node is null; return true
    if (root == null) {
      return true;
    }

    // Check left subtree
    if (!validateBST(root.left)) {
      return false;
    }
    // Check current data
    if (lastValue != null && root.data < lastValue) {
      return false;
    }
    lastValue = root.data;
    // Check right subtree
    if (!validateBST(root.right)) {
      return false;
    }
    return true;
  }

  /**
   * Write an algorithm to find the "next" node (i.e., in-order successor) of a
   * given node in a binary search tree. You may assume that each node has a
   * link to its parent.
   *
   * @param node node
   * @return in-order successor of node
   */
  public TreeNode successor(TreeNode node) {
    return null;
  }

  /**
   * You are given a list of projects and a list of dependencies (which is a
   * list of pairs of projects, where the second project is dependent on the
   * first project). All of a project's dependencies must be built before the
   * project is. Find a build order that will allow the projects to be built.
   * If there is no valid build order, return an error.
   *
   * EXAMPLE
   * Input:
   *   projects: a, b, c, d, e, f
   *   dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
   * Output: f, e, a, b, d, c
   *
   * @param projects projects and their dependencies
   * @return array of build order
   */
  public GraphNode[] buildOrder(GraphNode[] projects) {
    return null;
  }

  /**
   * Design an algorithm and write code to find the first common ancestor of two
   * nodes in a binary tree. Avoid storing additional nodes in a data structure.
   * NOTE: This is not necessarily a binary search tree.
   *
   * @param n1 node 1
   * @param n2 node 2
   * @return first common ancestor
   */
  public TreeNode firstCommonAncestor(TreeNode n1, TreeNode n2) {
    return null;
  }

  /**
   * A binary search tree was created by traversing through an array from left
   * to right and inserting each element. Given a binary search tree with
   * distinct elements, print all possible arrays that could have led to this
   * tree.
   *
   * EXAMPLE
   * Input:
   *      2
   *     / \
   *    1  3
   *
   * Output:
   * {2, 1, 3}, {2, 3, 1}
   *
   * @param root
   * @return
   */
  public ArrayList<int[]> bstSequences(TreeNode root) {
    return null;
  }

  /**
   * T1 and T2 are two very large binary trees, with T1 much bigger than T2.
   * Create an algorithm to determine if T2 is a subtree of Tl.
   *
   * A tree T2 is a subtree of T1 if there exists a node n in T1 such that the
   * subtree of n is identical to T2. That is, if you cut off the tree at node
   * n, the two trees would be identical.
   *
   * @param t1 tree 1
   * @param t2 tree 2
   * @return true if T2 isa subtree of T1
   */
  public boolean checkSubtree(TreeNode t1, TreeNode t2) {
    return false;
  }

  /**
   * You are implementing a binary tree class from scratch which, in addition
   * to insert, find, and delete, has a method getRandomNode() which returns a
   * random node from the tree. All nodes should be equally likely to be chosen.
   * Design and implement an algorithm for getRandomNode, and explain how you
   * would implement the rest of the methods.
   *
   * @return binary tree class
   */
  public Object randomNode() {
    return null;
  }

  /**
   * You are given a binary tree in which each node contains an integer value
   * (which might be positive or negative). Design an algorithm to count the
   * number of paths that sum to a given value. The path does not need to start
   * or end at the root or a leaf, but it must go downwards (traveling only
   * from parent nodes to child nodes).
   *
   * @param root root of binary tree
   * @param value value
   * @return number of paths that sum to given value
   */
  public int pathsWithSum(TreeNode root, int value) {
    return 0;
  }
}
