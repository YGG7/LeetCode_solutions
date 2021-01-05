package noteSWE241P;

import LeetCode.util.HuffmanNode;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Map;

public class HuffmanTree {
    public HuffmanNode root;
    private Map<Character, String> charPrefixHashMap;
    private Map<String, Character> prefixCharHashMap;

    public HuffmanTree() {
        root = null;
        charPrefixHashMap = new HashMap<>();
        prefixCharHashMap = new HashMap<>();
    }

    public void buildTree(char[] chars, int[] freqs) {
        if(chars.length != freqs.length) return;
        PriorityQueue<HuffmanNode> minHeap = new PriorityQueue<>();
        for(int i=0; i<chars.length; i++) {
            minHeap.offer(new HuffmanNode(chars[i], freqs[i]));
        }
        while(minHeap.size()>1) {
            HuffmanNode n1 = minHeap.poll();
            HuffmanNode n2 = minHeap.poll();
            HuffmanNode parent = new HuffmanNode(' ', n1.freq+n2.freq);
            parent.left = n1;
            parent.right = n2;
            minHeap.offer(parent);
        }
        root = minHeap.poll();
    }

    public void setMap(HuffmanNode node, StringBuilder builder) {
        assert node != null;
        if(node.left==null && node.right==null) {
            charPrefixHashMap.put(node.chr, builder.toString());
            prefixCharHashMap.put(builder.toString(), node.chr);
        }
        else {
            // by default, left child represents 0, right child represents 1
            builder.append('0');
            setMap(node.left, builder);
            builder.deleteCharAt(builder.length()-1);

            builder.append('1');
            setMap(node.right, builder);
            builder.deleteCharAt(builder.length()-1);
        }
    }

    public String encode(String s) {
        StringBuilder builder = new StringBuilder();
        for(char c:s.toCharArray()) {
            builder.append(charPrefixHashMap.get(c));
        }
        return builder.toString();
    }

    public String decode(String s) {
        HuffmanNode curr = root;
        StringBuilder builder = new StringBuilder();
        for(char c:s.toCharArray()) {
            long start = System.nanoTime();
            if(c=='0') {
                curr = curr.left;
                if(curr.left==null && curr.right==null) {
                    builder.append(curr.chr);
                    curr = root;
                }
            }
            else if(c=='1') {
                curr = curr.right;
                if(curr.left==null && curr.right==null) {
                    builder.append(curr.chr);
                    curr = root;
                }
            }
            long end = System.nanoTime();
            System.out.println("decode"+(end-start));
        }
        return builder.toString();
    }

    public String decodeFast(String s) {
        StringBuilder tmp = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for(char b:s.toCharArray()) {
            long start = System.nanoTime();
            tmp.append(b);
            long end2 = System.nanoTime();
            Character character = prefixCharHashMap.get(tmp.toString());
            long end3 = System.nanoTime();
            if(character!=null) {
                res.append(character);
                tmp.setLength(0);
            }
            long end = System.nanoTime();
            System.out.println((end2-start)+" "+(end3-end2)+" "+(end-end3));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        char[] letters = {'Z', 'K', 'M', 'C', 'U', 'D', 'L', 'E'};
        int[] frequencies = {2,7,24,32,37,42,42,120};
        HuffmanTree tree = new HuffmanTree();
        tree.buildTree(letters, frequencies);
        tree.setMap(tree.root, new StringBuilder());
        System.out.println("charPrefixHashMap: " + tree.charPrefixHashMap.toString());
        System.out.println("encode: KUCKLE => "+tree.encode("KUCKLE"));
        System.out.println("decode: 11110110011101111011100 => "+tree.decode("11110110011101111011100"));
        System.out.println("decodeFast: 11110110011101111011100 => "+tree.decode("11110110011101111011100"));

        System.out.println("performance comparison between decode and decodeFast");
        StringBuilder testCode = new StringBuilder();
        for(int i=0; i<10; i++) {
            testCode.append("11110110011101111011100");
        }
        long start = System.currentTimeMillis();
        tree.decode(testCode.toString());
        long end = System.currentTimeMillis();
        long startF = System.currentTimeMillis();
        tree.decodeFast(testCode.toString());
        long endF = System.currentTimeMillis();
        System.out.println("decode: "+(end-start)+" "+"decodeFast: "+(endF-startF));
    }
}
