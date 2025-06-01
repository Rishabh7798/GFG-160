Linked List Group Reverse - https://www.geeksforgeeks.org/batch/gfg-160-problems/track/linked-list-gfg-160/problem/reverse-a-linked-list-in-groups-of-given-size

class Solution {
    public static Node reverseKGroup(Node head, int k) {
        Node current = head;
        int count = 0;

        // Check if there are at least k nodes left to reverse
        while (current != null && count < k) {
            current = current.next;
            count++;
        }

        // If we have k nodes, then reverse them
        if (count == k) {
            Node prev = null;
            current = head;
            int i = 0;
            
            // Reverse k nodes
            while (i < k && current != null) {
                Node next = current.next;
                current.next = prev;
                prev = current;
                current = next;
                i++;
            }

            // Recursively call for the next part and attach
            head.next = reverseKGroup(current, k);

            // prev is the new head of the reversed group
            return prev;
        }

        // Less than k nodes remaining — still reverse them as a group
        return reverseRemaining(head);
    }

    private static Node reverseRemaining(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
