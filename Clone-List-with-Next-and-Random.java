Clone List with Next and Random - https://www.geeksforgeeks.org/batch/gfg-160-problems/track/linked-list-gfg-160/problem/clone-a-linked-list-with-next-and-random-pointer

/*linked list node
class Node {
    int data;
    Node next;
    Node random;

    Node(int x) {
        data = x;
        next = null;
        random = null;
    }
}
*/
class Solution {
    public Node cloneLinkedList(Node head) {
        if (head == null) return null;

        // Step 1: Clone nodes and insert them next to original nodes
        Node curr = head;
        while (curr != null) {
            Node clone = new Node(curr.data);
            clone.next = curr.next;
            curr.next = clone;
            curr = clone.next;
        }

        // Step 2: Set random pointers for cloned nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate original and cloned list
        curr = head;
        Node dummy = new Node(0);
        Node copy = dummy;
        
        while (curr != null) {
            Node clone = curr.next;
            copy.next = clone;
            copy = clone;

            curr.next = clone.next;
            curr = curr.next;
        }

        return dummy.next;
    }
}
