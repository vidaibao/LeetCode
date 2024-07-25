package Array;

import java.util.Arrays;

public class ArrayEasy {
    public static void main(String[] args) {
        RemoveElement_27();
        
    }

    private static void RemoveElement_27() {
        int[] nums = { 2, 4, 3, 6, 1, 3, -5 };
        int k = removeElement(nums, 3);
    }
    static int removeElement(int[] nums, int val) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val){
                nums[idx++] = nums[i];
            }
        }
        return idx;
    }
}
