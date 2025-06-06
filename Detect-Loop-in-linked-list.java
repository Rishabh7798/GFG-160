Detect Loop in linked list - https://www.geeksforgeeks.org/batch/gfg-160-problems/track/linked-list-gfg-160/problem/detect-loop-in-linked-list

class Solution {
    // Function to check if the linked list has a loop.
    public static boolean detectLoop(Node head) {
      // Add code here
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;           // move by 1
            fast = fast.next.next;      // move by 2

            if (slow == fast) {
                return true; // Loop detected
            }
        }

        return false; // No loop
    }
}
