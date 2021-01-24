package LeetCode;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        public Node() {}
        public Node(int k, int val) {
            key = k;
            value = val;
            prev = null;
            next = null;
        }
    }

    private HashMap<Integer, Node> hashMap;
    // double-linked list with fake head and tail
    private Node head;
    private Node tail;
    private int size;
    private int capacity;

    public LRUCache(int capacity) {
        hashMap = new LinkedHashMap<>();
        head = new Node();
        tail = new Node();
        head.prev = null;
        head.next = tail;
        tail.prev = head;
        tail.next = null;
        size = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (hashMap.containsKey(key)) {
            Node toReturn = hashMap.get(key);
            moveToHead(toReturn);
            return toReturn.value;
        }
        else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (hashMap.containsKey(key)) {
            Node existing = hashMap.get(key);
            existing.value = value;
            moveToHead(existing);
        }
        else {
            Node toPut = new Node(key, value);
            hashMap.put(key, toPut);
            addToHead(toPut);
            size++;
        }
        if (size>capacity) {
            Node toRemove = removeFromTail();
            hashMap.remove(toRemove.key);
            size--;
        }
    }

    private void moveToHead(Node node) {
        remove(node);
        addToHead(node);
    }

    private void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private Node removeFromTail() {
        Node toRemove = tail.prev;
        remove(toRemove);
        return toRemove;
    }
}
