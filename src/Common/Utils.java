package Common;

import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    public static void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end){
            swap(nums, start, end);
            start++; end--;
        }
    }
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static boolean isPalindrome(char[] arr){
        int l = 0; int r = arr.length - 1;
        while (l < r){
            if (arr[l] != arr[r]) return false;
            l++;
            r--;
        }
        return true;
    }

    public static void printList2(List<List<Integer>> arr2){
        for (List<Integer> combination : arr2) {
            System.out.println(combination);
        }
    }
}
