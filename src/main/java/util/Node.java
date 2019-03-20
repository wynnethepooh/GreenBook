package util;

public class Node {
  public Node next = null;
  public int data;

  public Node(int d) {
    data = d;
  }

  public void appendToTail(int d) {
    Node end = new Node(d);
    Node n = this;
    while (n.next != null) {
      n = n.next;
    }
    n.next = end;
  }

  /**
   * Compares values of linked list starting at this node with other linked list.
   *
   * @param head head of other linked list
   * @return true if this linked list equals other linked list
   */
  public boolean equalsList(Node head) {
    Node curr = this;
    Node other = head;

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
    Node curr = this;
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
