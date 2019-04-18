package util;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {

  int data;
  TreeNode right;
  TreeNode left;

  public TreeNode(Integer d) {
    data = d;
  }

  /**
   * Take in array of Integers (or null) and fill tree by level.
   *
   * @param nums
   */
  public TreeNode(Integer[] nums) {
    data = nums[0];

    int curr = 1;
    // Keep queue of nodes created (going level by level)
    Queue<TreeNode> nodes = new LinkedList<>();
    nodes.add(this);

    // Continue to add to nodes until end of array
    while (curr < nums.length) {
      TreeNode nextNode = nodes.poll();
      if (nextNode != null) {
        // Set left and right of dequeued node according to values in array
        // and add new nodes to queue
        if (nums[curr] != null) {
          nextNode.left = new TreeNode(nums[curr]);
          nodes.add(nextNode.left);
        }
        curr++;
        if (curr < nums.length && nums[curr] != null) {
          nextNode.right = new TreeNode(nums[curr]);
          nodes.add(nextNode.right);
        }
        curr++;
      }
    }
  }

  /**
   * Compares values of tree starting at root with other root.
   *
   * @param other root of other tree
   * @return true if this tree equals other tree
   */
  public boolean equalsTree(TreeNode other) {

    System.out.println("what");
    // If left of one of them is null, return false
    if (other.left == null ^ this.left == null) {
      return false;
    }
    // If right of one of them is null, return false
    if (other.right == null ^ this.right == null) {
      return false;
    }

    // Check left subtree
    if (this.left != null && !this.left.equalsTree(other.left)) {
      return false;
    }
    // Check current value
    if (this.data != other.data) {
      return false;
    }

    // Check right subtree
    if (this.right != null && !this.right.equalsTree(other.right)) {
      return false;
    }

    return true;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();

    // Keep track of nodes by level in queue
    Queue<TreeNode> level = new LinkedList<>();
    level.add(this);

    boolean nonEmptyLevel = true;

    while (level.size() > 0) {
      // Save current level and reset level queue
      Queue<TreeNode> currentLevel = level;
      level = new LinkedList<>();

      if (nonEmptyLevel) {
        // Reset nonEmptyLevel to false
        nonEmptyLevel = false;

        // Go through each node in current level
        for (TreeNode node : currentLevel) {
          if (node != null) {
            builder.append(" " + node.data + "  ");
            // Set nonEmptyLevel to true if there is a node in the level
            nonEmptyLevel = true;
          } else {
            builder.append("null");
          }
          builder.append(" ");

          level.add(node != null ? node.left : null);
          level.add(node != null ? node.right : null);
        }

        builder.append("\n");
      }
    }

    return builder.toString();
  }
}
