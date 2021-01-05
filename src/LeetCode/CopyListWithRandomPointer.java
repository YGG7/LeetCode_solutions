package LeetCode;

import LeetCode.util.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * Jianzhi 35. https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 */
public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        return copy(head);
    }

    private Node copy(Node head) {
        if(head==null) return null;
        Node curr = head, currCp = null, nextOrigin = null, headCp = null;
        // copy next
        while(curr!=null) {
            Node cp = new Node(curr.val);
            nextOrigin = curr.next;
            curr.next = cp;
            cp.next = nextOrigin;
            curr = nextOrigin;
        }

        curr = head;
        headCp = head.next;
        // copy random
        while(curr!=null) {
            currCp = curr.next;
            currCp.random = curr.random==null?null:curr.random.next;
            curr = currCp.next;
        }

        curr = head;
        // split duplicate list from original list
        while(curr!=null) {
            currCp = curr.next;
            curr.next = currCp.next;
            curr = currCp.next;
            currCp.next = currCp.next==null?null:currCp.next.next;
        }
        return headCp;
    }

    private Node copyByHashMap(Node head) {
        if(head==null) return null;
        Node curr = head;
        Map<Node, Node> originToCopy = new HashMap<>();
        while(curr!=null) {
            Node cp = new Node(curr.val);
            originToCopy.put(curr, cp);
            curr = curr.next;
        }

        curr = head;
        while(curr!=null) {
            Node currCp = originToCopy.get(curr);
            currCp.next = originToCopy.get(curr.next);
            currCp.random = originToCopy.get(curr.random);
            curr = curr.next;
        }
        return originToCopy.get(head);
    }
}
