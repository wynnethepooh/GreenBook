package util;

public class LinkedListNode {
  public LinkedListNode next = null;
  public int data;

  public LinkedListNode(int d) {
    data = d;
  }

  public void appendToTail(int d) {
    LinkedListNode end = new LinkedListNode(d);
    LinkedListNode n = this;
    while (n.next != null) {
      n = n.next;
    }
    n.next = end;
  }

  public void appendToTail(LinkedListNode node) {
    LinkedListNode n = this;
    while (n.next != null) {
      n = n.next;
    }
    n.next = node;
  }

  /**
   * Compares values of linked list starting at this node with other linked list.
   *
   * @param head head of other linked list
   * @return true if this linked list equals other linked list
   */
  public boolean equalsList(LinkedListNode head) {
    LinkedListNode curr = this;
    LinkedListNode other = head;

    while (curr != null && other != null) {
      if (curr.data != other.data) {
        return false;
      }
      curr = curr.next;
      other = other.next;
    }

    return (curr == null) == (other == null);
  }

  /**
   * Returns string of values in list.
   *
   * @return list as string
   */
  public String getListString() {
    LinkedListNode curr = this;
    StringBuilder list = new StringBuilder();
    list.append(curr.data);
    curr = curr.next;

    while (curr != null) {
      list.append(" -> ");
      list.append(curr.data);
      curr = curr.next;
    }

    return list.toString();
  }
}
