import util.GraphNode;
import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static util.GraphNode.State.Unvisited;
import static util.GraphNode.State.Visited;
import java.util.List;
import java.util.Queue;

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

    // Breadth-first search
    // Keep queue of nodes visiting; add n1 to queue
    Queue<GraphNode> visiting = new LinkedList<>();
    visiting.add(n1);

    GraphNode node;
    // While queue is not empty, poll queue to check nodes
    while (visiting.peek() != null) {
      node = visiting.poll();

      // Check neighbors of polled node
      for (GraphNode neighbor : node.adjacent) {
        // If node is Unvisited, check node
        if (neighbor.state == Unvisited) {
          // If node is equal to n1, return true
          if (neighbor == n2) {
            return true;
          } else {
            // Else add node to visiting queue
            visiting.add(neighbor);
          }
        }
      }
      // Set polled node to visited
      node.state = Visited;
    }

    // Return false if no node equals n2
    return false;

    /*
    // Depth-first search

    // Base case: if either are null, return false
    if (n1 == null || n2 == null) {
      return false;
    }

    // Set state to visited
    n1.state = Visited;

    // If n1 = n2, a route has been found; return true
    if (n1 == n2) {
      return true;
    }

    // Check neighbors of current node
    for(GraphNode neighbor : n1.adjacent) {
      // If neighbor has not been visited, recursively try to find route
      if(neighbor.state != Visited && routeBetweenNodes(neighbor, n2)) {
        // If a route has been found, return true
        return true;
      }
    }

    // Otherwise a route has not been found; return false
    return false;
    */
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

    ArrayList<LinkedList<TreeNode>> levelLists = new ArrayList<>();
    LinkedList<TreeNode> level = new LinkedList<>();

    // Add root to queue of nodes to visit
    level.add(root);

    // While visit queue is not empty
    while (level.peek() != null) {
      // Add current queue to list of level queues
      levelLists.add(level);

      // Save current queue as a new queue
      LinkedList<TreeNode> currentLevel = level;

      // Reset level queue
      level = new LinkedList<>();

      // For each node in current level
      for (TreeNode node : currentLevel) {

        // Add node.left and node.right to level list and level queue
        if (node.left != null) {
          level.add(node.left);
        }
        if (node.right != null) {
          level.add(node.right);
        }
      }
    }

    return levelLists;
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

    if (checkHeight(root) == ERROR_CODE) {
      return false;
    } else {
      return true;
    }
  }

  private int ERROR_CODE = -2;

  private int checkHeight(TreeNode root) {
    // If root is null, return -1
    if (root == null) {
      return -1;
    }

    // Check left height
    int leftHeight = checkHeight(root.left);

    // Check right height
    int rightHeight = checkHeight(root.right);

    if (leftHeight == ERROR_CODE || rightHeight == ERROR_CODE) {
      return ERROR_CODE;
    }

    // If difference of left and right is more than 1, return error code
    if (Math.abs(leftHeight - rightHeight) > 1) {
      return ERROR_CODE;
    } else {
      // Else return the bigger height
      return Math.max(leftHeight, rightHeight) + 1;
    }
  }

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

  private Integer lastValue = null;

  /**
   * Write an algorithm to find the "next" node (i.e., in-order successor) of a
   * given node in a binary search tree. You may assume that each node has a
   * link to its parent.
   *
   * @param node node
   * @return in-order successor of node
   */
  public TreeNode successor(TreeNode node) {

    // If node has right subtree
    if (node.right != null) {
      TreeNode rightSubtree = node.right;

      // Find leftmost node of right subtree
      while (rightSubtree.left != null) {
        rightSubtree = rightSubtree.left;
      }
      return rightSubtree;

    } else {
      TreeNode n = node;

      // Else keep going up until node is left child of parent
      while (n.parent != null && n != n.parent.left) {
        n = n.parent;
      }
      return n.parent;
    }
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
    // Find depths of both
    int depth1 = findDepth(n1);
    int depth2 = findDepth(n2);

    // Find difference of depths to move up in longer tree
    int difference = Math.abs(depth1 - depth2);

    TreeNode longer = depth1 > depth2 ? n1 : n2;
    TreeNode shorter = longer == n1 ? n2 : n1;

    // Go up longer tree for all of difference
    while (difference > 0) {
      longer = longer.parent;
      difference--;
    }

    // Return first common ancestor
    while (shorter != longer) {
      shorter = shorter.parent;
      longer = longer.parent;
    }
    return shorter;
  }

  private int findDepth(TreeNode node) {
    int depth = 0;
    while (node != null) {
      depth++;
      node = node.parent;
    }
    return depth;
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

    if (t1 == null) {
      return false;
    } else if (t2 == null) {
      return true;
    }

    // If t1 = t2, check rest of t1 and t2
    if (t1.data == t2.data && checkRestOfTree(t1, t2)) {
      return true;
    }

    // Check each node of t1 and check if equal to t2
    return checkSubtree(t1.left, t2) || checkSubtree(t1.right, t2);
  }

  private boolean checkRestOfTree(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) {
      // Reached leaf node
      return true;
    } else if (t1 == null || t2 == null) {
      // If one of the nodes is null, return false
      return false;
    }

    if (t1.data == t2.data) {
      return checkRestOfTree(t1.left, t2.left)
              && checkRestOfTree(t1.right, t2.right);
    } else {
      return false;
    }
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

  /*
   * EXTRA PROBLEMS
   */

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
    return false;
  }
}
