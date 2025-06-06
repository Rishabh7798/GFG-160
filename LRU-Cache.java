LRU Cache - https://www.geeksforgeeks.org/batch/gfg-160-problems/track/linked-list-gfg-160/problem/lru-cache

class LRUCache {
    private static class Node {
        int key, value;
        Node prev, next;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private static int capacity;
    private static Map<Integer, Node> map;
    private static Node head, tail;

    public LRUCache(int cap) {
      // code here
        capacity = cap;
        map = new HashMap<>();
        
        // Dummy head and tail to avoid null checks
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public static int get(int key) {
      // your code here
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        insertToFront(node);
        return node.value;
    }

    public static void put(int key, int value) {
      // your code here
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (map.size() == capacity) {
            remove(tail.prev); // Least recently used
        }
        insertToFront(new Node(key, value));
    }

    // Helper method to remove a node
    private static void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Helper method to insert a node right after head (most recently used)
    private static void insertToFront(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}
