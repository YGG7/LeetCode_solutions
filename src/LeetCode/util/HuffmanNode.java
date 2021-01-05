package LeetCode.util;

public class HuffmanNode implements Comparable<HuffmanNode> {
    public char chr;
    public int freq;
    public HuffmanNode left;
    public HuffmanNode right;

    public HuffmanNode(char c, int f) {
        chr = c;
        freq = f;
        left = null;
        right = null;
    }

    public boolean isLeaf() {
        return (left==null) && (right==null);
    }

    @Override
    public int compareTo(HuffmanNode n) {
        return freq-n.freq;
    }
}
