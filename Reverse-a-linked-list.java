Reverse a linked list - https://www.geeksforgeeks.org/batch/gfg-160-problems/track/linked-list-gfg-160/problem/reverse-a-linked-list

// function Template for Java

/* linked list node class:

class Node {
    int data;
    Node next;
    Node(int value) {
        this.value = value;
    }
}

*/
class Solution {
    Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;  // Store next node
            current.next = prev;  // Reverse current node's pointer
            prev = current;       // Move prev one step forward
            current = next;       // Move current one step forward
        }

        return prev;  // New head of the reversed list
    }
}
