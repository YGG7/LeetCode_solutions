package noteSWE241P;

public class LinkedList {
    static class Node {
        int data;
        Node next;
        Node prev;
        Node(int d) {
            data = d;
            next = null;
            prev = null;
        }
    }

    private Node head;
    private Node tail;

    LinkedList() {
        head = null;
        tail = null;
    }

    public void insert(int d) {
        Node n = new Node(d);
        if (head==null&&tail==null) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            n.next=null;
            n.prev=tail;
            tail = n;
        }
    }

    public void delete(int d) {
        Node curr = head;
        while (curr!=null) {
            if (curr.data==d) break;
            curr = curr.next;
        }
        if (curr==null) return;

        if (curr.next==null&&curr.prev==null) {
            head=null;
            tail=null;
            return;
        }
        if (curr.prev==null) {
            head = curr.next;
            curr.next.prev=null;
        } else if (curr.next==null) {
            tail = curr.prev;
            curr.prev.next=null;
        } else {
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Node curr = head;
        while (curr!=null) {
            s.append(" ").append(curr.data);
            curr = curr.next;
        }
        return s.toString();
    }
}
