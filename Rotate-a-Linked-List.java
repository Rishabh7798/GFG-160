Rotate a Linked List

class Solution {
    public Node rotate(Node head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Step 1: Find length and tail node
        Node current = head;
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        }
        Node tail = current;

        // Step 2: Effective rotations
        k = k % length;
        if (k == 0) return head;

        // Step 3: Traverse to (k)th node
        current = head;
        for (int i = 1; i < k; i++) {
            current = current.next;
        }

        // Step 4: Rotate
        Node newHead = current.next;
        current.next = null;
        tail.next = head;

        return newHead;
    }
}
