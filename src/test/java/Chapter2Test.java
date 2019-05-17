import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import util.LinkedListNode;

import static org.junit.jupiter.api.Assertions.*;

public class Chapter2Test {

  Chapter2 chapter2 = new Chapter2();

  @Test
  public void removeDups() {
    // a -> b -> a -> c -> d -> b
    LinkedListNode input = new LinkedListNode('a');
    input.appendToTail('b');
    input.appendToTail('a');
    input.appendToTail('c');
    input.appendToTail('d');
    input.appendToTail('b');

    // a -> b -> c -> d
    LinkedListNode expected = new LinkedListNode('a');
    expected.appendToTail('b');
    expected.appendToTail('c');
    expected.appendToTail('d');

    LinkedListNode test1 = input;
    chapter2.removeDups(test1);
    System.out.println(expected.getListString());
    System.out.println(test1.getListString());
    assertTrue(test1.equalsList(expected),
            "\nexpected: " + expected.getListString() +
            "\nactual: " + test1.getListString());

    LinkedListNode test2 = expected;
    chapter2.removeDups(test2);
    assertTrue(test2.equals(expected),
            "\nexpected: " + expected.getListString() +
            "\nactual: " + test2.getListString());

    LinkedListNode test3 = new LinkedListNode('a');
    test3.appendToTail('a');
    expected = new LinkedListNode('a');
    chapter2.removeDups(test3);
    assertTrue(test3.equalsList(expected),
            "\nexpected: " + expected.getListString() +
            "\nactual: " + test3.getListString());
  }

  @Test
  public void removeDupsNoBuffer() {
    // 5 -> 3 -> 5 -> 2 -> 7 -> 1
    LinkedListNode input = new LinkedListNode(5);
    input.appendToTail(3);
    input.appendToTail(5);
    input.appendToTail(2);
    input.appendToTail(7);
    input.appendToTail(1);

    // 5 -> 3 -> 2 -> 7 -> 1
    LinkedListNode expected = new LinkedListNode(5);
    expected.appendToTail(3);
    expected.appendToTail(2);
    expected.appendToTail(7);
    expected.appendToTail(1);

    LinkedListNode test1 = input;
    chapter2.removeDupsNoBuffer(test1);
    assertTrue(test1.equalsList(expected),
            "\nexpected: " + expected.getListString() +
                    "\nactual: " + test1.getListString());

    LinkedListNode test2 = expected;
    chapter2.removeDupsNoBuffer(test2);
    assertTrue(test2.equals(expected),
            "\nexpected: " + expected.getListString() +
                    "\nactual: " + test2.getListString());
  }

  @Test
  public void returnKthToLast() {
    // 10 -> 5 -> 1 -> 3 -> 4
    // k = 3
    // return 1

    LinkedListNode input = new LinkedListNode(10);
    input.appendToTail(5);
    input.appendToTail(1);
    input.appendToTail(3);
    input.appendToTail(4);

    LinkedListNode expected = input.next.next; // 1
    LinkedListNode result = chapter2.returnKthToLast(input, 3);
    assertEquals(expected.data, result.data);
    assertEquals(expected, result);

    result = chapter2.returnKthToLast(input, 10);
    assertEquals(null, result);
  }

  @Disabled
  @Test
  public void deleteMiddleNode() {
    LinkedListNode input = new LinkedListNode('a');
    input.appendToTail('b');
    input.appendToTail('c');
    input.appendToTail('d');
    input.appendToTail('e');

    LinkedListNode c = input.next.next;

    LinkedListNode expected = new LinkedListNode('a');
    expected.appendToTail('b');
    expected.appendToTail('d');
    expected.appendToTail('e');

    assertTrue(chapter2.deleteMiddleNode(c),
            "Failed to delete node from list");
    assertTrue(expected.equalsList(input),
            "expected: " + expected + "\n" +
            "actual: " + input);

    assertFalse(chapter2.deleteMiddleNode(null));
  }

  @Disabled
  @Test
  public void partition() {
    // 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1
    // partition = 5
    LinkedListNode input = new LinkedListNode(3);
    input.appendToTail(5);
    input.appendToTail(8);
    input.appendToTail(5);
    input.appendToTail(10);
    input.appendToTail(2);
    input.appendToTail(1);

    int partition = 5;
    LinkedListNode result = chapter2.partition(input, 5);
    LinkedListNode curr = result;

    // Assert that there are 3 elements less than 5
    for (int i = 0; i < 3; i++) {
      if (curr != null) {
        assertTrue(curr.data < partition);
        curr = curr.next;
      }
    }
    while (curr != null) {
      assertTrue(curr.data >= partition);
      curr = curr.next;
    }
  }

  @Disabled
  @Test
  public void sumLists() {
    LinkedListNode d1 = new LinkedListNode(7);
    d1.appendToTail(1);
    d1.appendToTail(6);

    LinkedListNode d2 = new LinkedListNode(5);
    d2.appendToTail(9);
    d2.appendToTail(2);

    LinkedListNode sum = new LinkedListNode(2);
    sum.appendToTail(1);
    sum.appendToTail(9);

    LinkedListNode result = chapter2.sumLists(d1, d2);
    assertTrue(sum.equalsList(result),
            "\nexpected: " + sum.getListString() +
            "\nactual: " + result.getListString());
  }

  @Disabled
  @Test
  public void sumListsForwardOrder() {
    LinkedListNode d1 = new LinkedListNode(6);
    d1.appendToTail(1);
    d1.appendToTail(7);

    LinkedListNode d2 = new LinkedListNode(2);
    d2.appendToTail(9);
    d2.appendToTail(5);

    LinkedListNode expected = new LinkedListNode(9);
    expected.appendToTail(1);
    expected.appendToTail(2);

    LinkedListNode result = chapter2.sumListsForwardOrder(d1, d2);
    assertTrue(expected.equalsList(result),
            "\nexpected: " + expected.getListString() +
            "\nactual: " + result.getListString());

    d1 = new LinkedListNode(2);
    d1.appendToTail(6);
    d1.appendToTail(1);
    d1.appendToTail(7);

    d2 = new LinkedListNode(2);
    d2.appendToTail(9);
    d2.appendToTail(5);

    expected = new LinkedListNode(2);
    expected.appendToTail(9);
    expected.appendToTail(1);
    expected.appendToTail(2);

    result = chapter2.sumListsForwardOrder(d1, d2);
    assertTrue(expected.equalsList(result),
            "\nexpected: " + expected.getListString() +
                    "\nactual: " + result.getListString());
  }

  @Disabled
  @Test
  public void palindrome() {
    LinkedListNode input = new LinkedListNode(1);
    input.appendToTail(2);
    input.appendToTail(3);
    input.appendToTail(2);

    assertFalse(chapter2.palindrome(input),
            input.getListString() + " is not a palindrome");

    input.appendToTail(1);
    assertTrue(chapter2.palindrome(input),
            input.getListString() + " is a palindrome");
  }

  @Disabled
  @Test
  public void intersection() {
    LinkedListNode first = new LinkedListNode(3);
    first.appendToTail(1);
    first.appendToTail(5);
    first.appendToTail(9);

    LinkedListNode second = new LinkedListNode(4);
    second.appendToTail(6);

    assertNull(chapter2.intersection(first, second),
            "\n" + first.getListString() + " and " +
            "\n" + second.getListString() + " do not intersect.");

    LinkedListNode same = new LinkedListNode(7);
    same.appendToTail(2);
    same.appendToTail(1);

    first.appendToTail(same);
    second.appendToTail(same);

    assertEquals(same, chapter2.intersection(first, second),
            "\n" + first.getListString() + " and " +
            "\n" + second.getListString() + " intersect at 7.");
  }

  @Disabled
  @Test
  public void loopDetection() {

  }
}
