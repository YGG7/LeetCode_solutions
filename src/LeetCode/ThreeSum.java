package LeetCode;

import java.util.*;

/**
 * LeetCode 15. Three Sum https://leetcode-cn.com/problems/3sum/
 */
public class ThreeSum {
    public static List<List<Integer>> getTreeSum(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        if(arr==null || arr.length<3) return res;
        int len = arr.length;
        Arrays.sort(arr);
        for(int i=0; i<len-2;) {
            if(arr[i]>0) break;
            int j=i+1, k=len-1;
            while(j<k) {
                int treeSum = arr[i]+arr[j]+arr[k];
                if(treeSum==0) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(arr[i]);
                    tmp.add(arr[j]);
                    tmp.add(arr[k]);
                    res.add(tmp);
                    while (j<k && arr[j]==arr[++j]);
                    while (j<k && arr[k]==arr[--k]);
                }
                else if(treeSum<0) {
                    while (j<k && arr[j]==arr[++j]);
                }
                else {
                    while (j<k && arr[k]==arr[--k]);
                }
            }
            while(i<len-1 && arr[i]==arr[++i]);
        }
        return res;
    }
}
