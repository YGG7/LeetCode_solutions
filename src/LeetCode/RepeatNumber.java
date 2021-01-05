package LeetCode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RepeatNumber {
    // O(n) but including extra cost of hashing and searching
    public int findRepeatNumber(int[] nums) {
        Set<Integer> hash_set = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            if(hash_set.contains(nums[i])) {
                return nums[i];
            } else {
                hash_set.add(nums[i]);
            }
        }
        return -1;
    }

    // O(nlog(n)) in general conditions
    public int findRepeatNumber3(int[] nums) {
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++) {
            if(nums[i]!=i) {
                return nums[i];
            }
        }
        return -1;
    }

    // O(n)
    public int findRepeatNumber2(int[] nums) {
        for (int i=0;i<nums.length;i++) {
            while (nums[i]!=i) {
                if (compareAndSwap(nums, i, nums[i])) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    private boolean compareAndSwap(int[]nums, int p1, int p2) {
        if (nums[p1]==nums[p2]) return true;
        else {
            int tmp = nums[p1];
            nums[p1] = nums[p2];
            nums[p2] = tmp;
            return false;
        }
    }
}
