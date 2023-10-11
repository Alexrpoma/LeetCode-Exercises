/**
 * Definition for singly-linked list.
 * This class is for sum of two numbers represented by linked list.
 * Example:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation:
 * 342 + 465 = 807
 */
public class ListNode {
  public static void main(String[] args) {
    ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
    ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
    ListNode result = new Solution().addTwoNumbers(l1, l2);
    while (result != null) {
      System.out.print(result.val);
      result = result.next;
    }
  }
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  static class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode result = new ListNode();
      ListNode current = result;
      int carry = 0;
      while (l1 != null || l2 != null) {
        int sum = carry;
        if (l1 != null) {
          sum += l1.val;
          l1 = l1.next;
        }
        if (l2 != null) {
          sum += l2.val;
          l2 = l2.next;
        }
        current.next = new ListNode(sum % 10);
        current = current.next;
        carry = sum / 10;
      }
      if (carry > 0) {
        current.next = new ListNode(carry);
      }
      return result.next;
    }
  }
}
