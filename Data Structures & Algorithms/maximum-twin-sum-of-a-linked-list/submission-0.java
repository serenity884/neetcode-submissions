/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        // Phase 1: reverse the first half while finding the middle
        ListNode slow = head, fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;

            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        // prev = head of reversed first half, slow = head of second half

        int maxSum = 0;
        while (slow != null) {
            maxSum = Math.max(maxSum, prev.val + slow.val);
            prev = prev.next;
            slow = slow.next;
        }
        return maxSum;
    }
}