import util.Node;
import java.util.HashSet;
import java.util.Set;

public class Chapter2 {

  /**
   * Write code to remove duplicates from an unsorted linked list.
   *
   * @param head head of linked list
   */
  public void removeDups(Node head) {
    Node prev = head;
    Node curr = head.next;

    Set<Integer> unique = new HashSet<>();
    unique.add(prev.data);
    while (curr != null) {
      if (unique.contains(curr.data)) {
        curr = curr.next;
        prev.next = curr;
      } else {
        unique.add(curr.data);
      }
      prev = prev.next;
      if (curr != null) {
        curr = curr.next;
      }
    }
  }

  /**
   * FOLLOW UP
   * How would you solve the previous problem if a temporary buffer is not
   * allowed?
   *
   * @param head head of linked list
   */
  public void removeDupsNoBuffer(Node head) {

  }

  /**
   * Implement an algorithm to find the kth to last element of a singly linked
   * list.
   *
   * @param head head of linked list
   * @param k number
   * @return Kth to last element
   */
  public Node returnKthToLast(Node head, int k) {
    return null;
  }

  /**
   * Implement an algorithm to delete a node in the middle of a singly linked
   * list, given only access to that node.
   *
   * Example
   *  Input: the node c from the linked list
   *    a->b->c->d->e
   *  Output: true if node was deleted; linked list should look like this
   *    a->b->d->e
   *
   * @param node node
   * @return true if node has been deleted
   */
  public boolean deleteMiddleNode(Node node) {
    return false;
  }

  /**
   * Write code to partition a linked list around a value x, such that all nodes
   * less than x come before all nodes greater than or equal to x. If x is
   * contained within the list, the values of x only need to be after the
   * elements less than x (see below).
   *
   * Example
   *  Input:  3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [parition = 5]
   *  Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
   *
   * @param head head of linked list
   * @param partition partition value
   */
  public void partition(Node head, int partition) {

  }

  /**
   * You have two numbers represented by a linked list, where each node contains
   * a single digit. The digits are stored in reverse order, such that the 1's
   * digit is at the head of the list. Write a function that adds the two
   * numbers and returns the sum as a linked list.
   *
   * Example
   *  Input: (7 -> 1 -> 6) + (5 -> 9 -> 2). That is 617 + 295.
   *  Output: 2 -> 1 -> 9. That is, 912.
   *
   * @param d1 digit 1
   * @param d2 digit 2
   * @return sum as linked list
   */
  public Node sumLists(Node d1, Node d2) {
    return null;
  }

  /**
   * FOLLOW UP
   * Suppose the digits are stored in forward order. Repeat the above problem.
   *
   * @param d1 digit 1
   * @param d2 digit 2
   * @return sum as linked list
   */
  public Node sumListsForwardOrder(Node d1, Node d2) {
    return null;
  }

  /**
   * Implement a function to check if a linked list is a palindrome.
   *
   * @param head head of linked list
   * @return true if linked list is a palindrome
   */
  public boolean palindrome(Node head) {
    return false;
  }

  /**
   * Given two (singly) linked lists, determine if the two lists intersect.
   * Return the intersecting node. Note that the intersection is defined based
   * on reference, not value. That is, if the kth node of the first linked list
   * is the exact same node (by reference) as the jth node of the second linked
   * list, then they are intersecting.
   *
   * @param h1 head of first linked list
   * @param h2 head of second linked list
   * @return intersecting node
   */
  public Node intersection(Node h1, Node h2) {
    return null;
  }

  /**
   * Given a circular linked list, implement an algorithm that returns the node
   * at the beginning of the loop.
   *
   * DEFINITION
   * Circular linked list: A (corrupt) linked list in which a node's next pointer
   * points to an earlier node, so as to make a loop in the linked list
   *
   * Example
   *  Input: A -> B -> C -> D -> E -> C [the same C as earlier]
   *  Output: C
   *
   * @param head head of linked list
   * @return node at beginning of loop
   */
  public Node loopDetection(Node head) {
    return null;
  }

}
