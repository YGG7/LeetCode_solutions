package LeetCode;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianInStream {
    private PriorityQueue<Integer> maxHeap, minHeap;
    public MedianInStream() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(maxHeap.size() == minHeap.size()) {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
        else {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        return maxHeap.size()==minHeap.size()?(maxHeap.peek()+minHeap.peek())/2.0:maxHeap.peek();
    }
}
