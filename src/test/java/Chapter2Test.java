import org.junit.jupiter.api.Test;
import util.Node;

import static org.junit.jupiter.api.Assertions.*;

public class Chapter2Test {

  Chapter2 chapter2 = new Chapter2();

  @Test
  public void removeDups() {
    // a -> b -> a -> c -> d -> b
    Node input = new Node('a');
    input.appendToTail('b');
    input.appendToTail('a');
    input.appendToTail('c');
    input.appendToTail('d');
    input.appendToTail('b');

    Node output = new Node('a');
    output.appendToTail('b');
    output.appendToTail('c');
    output.appendToTail('d');

    Node result = chapter2.removeDups(input);
    assertTrue(result.equalsList(output),
            "expected: " + result.getListString() + "\n" +
            "actual: " + output.getListString());

    result = chapter2.removeDups(output);
    assertTrue(result.equals(output),
            "expected: " + result.getListString() + "\n" +
                    "actual: " + output.getListString());
  }

  @Test
  public void removeDupsNoBuffer() {
    // 5 -> 3 -> 5 -> 2 -> 7 -> 1
    Node input = new Node(5);
    input.appendToTail(3);
    input.appendToTail(5);
    input.appendToTail(2);
    input.appendToTail(7);
    input.appendToTail(1);

    // 5 -> 3 -> 2 -> 7 -> 1
    Node output = new Node(5);
    output.appendToTail(3);
    output.appendToTail(2);
    output.appendToTail(7);
    output.appendToTail(1);

    Node result = chapter2.removeDupsNoBuffer(input);
    assertTrue(result.equalsList(output),
            "expected: " + result.getListString() + "\n" +
                    "actual: " + output.getListString());

    result = chapter2.removeDupsNoBuffer(output);
    assertTrue(result.equals(output),
            "expected: " + result.getListString() + "\n" +
                    "actual: " + output.getListString());
  }

  @Test
  public void returnKthToLast() {
    // 10 -> 5 -> 1 -> 3 -> 4
    // k = 3
    // return 1

    Node input = new Node(10);
    input.appendToTail(5);
    input.appendToTail(1);
    input.appendToTail(3);
    input.appendToTail(4);

    Node expected = input.next.next; // 1
    Node result = chapter2.returnKthToLast(input, 3);
    assertEquals(expected.data, result.data);
    assertEquals(expected, result);

    result = chapter2.returnKthToLast(input, 10);
    assertEquals(null, result);
  }

  @Test
  public void deleteMiddleNode() {
    Node input = new Node('a');
    input.appendToTail('b');
    input.appendToTail('c');
    input.appendToTail('d');
    input.appendToTail('e');

    Node c = input.next.next;

    Node expected = new Node('a');
    expected.appendToTail('b');
    expected.appendToTail('d');
    expected.appendToTail('e');

    assertTrue(chapter2.deleteMiddleNode(c),
            "Failed to delete node from list");
    assertTrue(expected.equalsList(input),
            "expected: " + expected + "\n" +
            "actual: " + input);
  }

  @Test
  public void partition() {
    // 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1
    // partition = 5
    Node input = new Node(3);
    input.appendToTail(5);
    input.appendToTail(8);
    input.appendToTail(5);
    input.appendToTail(10);
    input.appendToTail(2);
    input.appendToTail(1);

    Node output = new Node(3);
    output.appendToTail(1);
    output.appendToTail(2);
    output.appendToTail(10);
    output.appendToTail(5);
    output.appendToTail(5);
    output.appendToTail(8);

    Node result = chapter2.partition(input, 5);
    assertTrue(output.equalsList(result),
            "expected: " + output.getListString() + "\n" +
            "actual: " + result.getListString());
  }

  @Test
  public void sumLists() {
    Node d1 = new Node(7);
    d1.appendToTail(1);
    d1.appendToTail(6);

    Node d2 = new Node(5);
    d2.appendToTail(9);
    d2.appendToTail(2);

    Node sum = new Node(2);
    sum.appendToTail(1);
    sum.appendToTail(9);

    Node result = chapter2.sumLists(d1, d2);
    assertTrue(sum.equalsList(result),
            "expected: " + sum.getListString() + "\n" +
            "actual: " + result.getListString());
  }

  @Test
  public void sumListsForwardOrder() {
    Node d1 = new Node(6);
    d1.appendToTail(1);
    d1.appendToTail(7);

    Node d2 = new Node(2);
    d2.appendToTail(9);
    d2.appendToTail(5);

    Node sum = new Node(9);
    sum.appendToTail(1);
    sum.appendToTail(2);

    Node result = chapter2.sumListsForwardOrder(d1, d2);
    assertTrue(sum.equalsList(result),
            "expected: " + sum.getListString() + "\n" +
            "actual: " + result.getListString());
  }

  @Test
  public void palindrome() {
    Node input = new Node(1);
    input.appendToTail(2);
    input.appendToTail(3);
    input.appendToTail(2);

    assertFalse(chapter2.palindrome(input),
            input.getListString() + " is not a palindrome");

    input.appendToTail(1);
    assertTrue(chapter2.palindrome(input),
            input.getListString() + " is a palindrome");
  }

  @Test
  public void intersection() {

  }

  @Test
  public void loopDetection() {

  }
}