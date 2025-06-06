Remove loop in Linked List - https://www.geeksforgeeks.org/batch/gfg-160-problems/track/linked-list-gfg-160/problem/remove-loop-in-linked-list

/*
class Node
{
    int data;
    Node next;
}
*/

class Solution {
    public static void removeLoop(Node head) {
        if (head == null || head.next == null) return;

        Node slow = head, fast = head;

        // Step 1: Detect loop using Floyd’s Cycle Detection
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Loop detected
            if (slow == fast) {
                break;
            }
        }

        // If loop doesn't exist, return
        if (slow != fast) return;

        // Step 2: Find the start of the loop
        slow = head;

        // Edge case: when loop starts at head
        if (slow == fast) {
            while (fast.next != slow) {
                fast = fast.next;
            }
        } else {
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
        }

        // Step 3: Remove loop
        fast.next = null;
    }
}
