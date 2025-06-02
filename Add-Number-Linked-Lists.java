Add Number Linked Lists - https://www.geeksforgeeks.org/batch/gfg-160-problems/track/linked-list-gfg-160/problem/add-two-numbers-represented-by-linked-lists

// Node definition
/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/
class Solution {

    // Helper to reverse a linked list
    static Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }

    // Main method to add two linked lists
    static Node addTwoLists(Node num1, Node num2) {
        // Step 1: Reverse both lists
        num1 = reverse(num1);
        num2 = reverse(num2);

        Node dummy = new Node(0);  // Dummy head for result list
        Node current = dummy;
        int carry = 0;

        // Step 2: Add digits with carry
        while (num1 != null || num2 != null || carry != 0) {
            int sum = carry;
            if (num1 != null) {
                sum += num1.data;
                num1 = num1.next;
            }
            if (num2 != null) {
                sum += num2.data;
                num2 = num2.next;
            }

            carry = sum / 10;
            current.next = new Node(sum % 10);
            current = current.next;
        }

        // Step 3: Reverse the result
        Node result = reverse(dummy.next);

        // Step 4: Remove leading zeros (if any)
        while (result != null && result.data == 0 && result.next != null) {
            result = result.next;
        }

        return result;
    }
}
