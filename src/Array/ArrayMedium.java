package Array;

import java.util.*;

import static Common.BackTracking.*;
import static Common.Utils.*;

public class ArrayMedium {
    public static void main(String[] args) {
        //ContainerWithMostWater_11();
        //ThreeSum_15();
        //ValidSudoku_36();
        //LongestPalindromicSubstring_5(); // 2 poiters
        //RemoveNthNodeFromEoList_19(); // 2 poiters
        //NextPermutation_31();
        //Permutations_46();
        //Permutations2_47();
        //Combinations_77();
        //CombinationSum_39();
        //CombinationSum2_40();
        //CombinationSum3_216();
        //LetterCombinationsOfAPhoneNumber_17();
        //GenerateParentheses_22();
        //Subsets_78();
        CarPooling_1094();

    }

    private static void CarPooling_1094() {
        int capacity = 4;
        int[][] trips = { {2,1,5}, {3,3,7} };
        System.out.println(carPooling(trips, capacity));
    }
    static boolean carPooling(int[][] trips, int capacity) {
        Hashtable<Integer, Integer> kilometers = new Hashtable<>();
        Arrays.stream(trips)
                .sorted((a, b) -> Integer.compare(a[1], b[1])); // sort by from location

        for (var trip : trips) {
            for (int i = trip[1]; i < trip[2]; i++) {
                if (trip[0] > capacity) return false;
                if (kilometers.containsKey(i)) {
                    if (kilometers.get(i) + trip[0] > capacity) return false;
                    kilometers.put(i, kilometers.get(i) + trip[0]);
                } else {
                    kilometers.put(i, trip[0]);
                }
            }
        }
        return true;
    }



    // Given an integer array nums of unique elements, return all possible subsets (the power set).
    //
    //The solution set must not contain duplicate subsets. Return the solution in any order.
    private static void Subsets_78() {
        int[] nums = { 1, 2, 3 };
        var re = subsets(nums);
        printList2(re);
    }
    static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrackSubsets(result, new ArrayList<>(), 0, nums);
        return result;
    }

    private static void backtrackSubsets(List<List<Integer>> result, ArrayList<Integer> tempList, int start, int[] nums) {
        result.add(new ArrayList<>(tempList));

        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrackSubsets(result, tempList, i + 1, nums);
            tempList.removeLast();
        }
    }

    //Example 1:
    //
    //Input: nums = [1,2,3]
    //Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
    //Example 2:
    //
    //Input: nums = [0]
    //Output: [[],[0]]
    //
    //
    //Constraints:
    //
    //1 <= nums.length <= 10
    //-10 <= nums[i] <= 10
    //All the numbers of nums are unique.




    // Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
    private static void GenerateParentheses_22() {
        int n = 3;
        var result = generateParenthesis(n);
        System.out.println(result);
    }
    static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrackParenthese(result, new StringBuilder(), 0, 0, n);
        return result;
    }







    private static void LetterCombinationsOfAPhoneNumber_17() {
        String s = "23";
        var result = letterCombinations(s);
        System.out.println(result);
    }
    static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        String[] map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        backtractLetter(result, new StringBuilder(), map, digits, 0);
        return result;
    }







    //Only numbers 1 through 9 are used.
    //Each number is used at most once.
    private static void CombinationSum3_216() {
        int k = 3;
        int n = 9;
        var result = combinationSum3(k, n);
        printList2(result);
    }

    static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[10];
        backtrack3(result, new ArrayList<>(), n, 1, k, used);
        return result;
    }


    private static void CombinationSum2_40() {
        int[] ints = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        var result = combinationSum2(ints, target);
        printList2(result);
    }

    private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort the array to handle duplicates
        backtrack2(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }


    private static void CombinationSum_39() {
        int[] ints = {2, 3, 6, 7};
        int target = 7;
        var result = combinationSum(ints, target);
    }

    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }


    private static void Combinations_77() {
        int n = 4;
        int k = 2;
        List<List<Integer>> combinations = combine(n, k);
    }

    static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 1, n, k);
        return result;
    }


    private static void Permutations2_47() {
        int[] nums = {1, 3, 1};
        var re = permuteUnique(nums);
    }

    static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort the array to handle duplicates
        boolean[] used = new boolean[nums.length];
        backtrack(result, new ArrayList<>(), nums, used);
        return result;
    }


    private static void Permutations_46() {
        int[] nums = {2, 3, 1};
        var re = permute(nums);
    }

    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }


    private static void NextPermutation_31() {
        int[] nums = {1, 2, 3, 1};
        nextPermutation(nums);
    }

    static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // Find the first pair decreasing consecutive element from the end
        // >> identifies the point where the array needs to be rearranged
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Ensure that the next permutation is just slightly larger than the current permutation
        if (i >= 0) {
            // Find the element just lager than nums[i]
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            // Swap the found elements
            swap(nums, i, j);
        }

        // Reverse the elements after index i >> get the next lexicographical permutation
        reverse(nums, i + 1);
    }


    private static void RemoveNthNodeFromEoList_19() {
        int n = 2;
        ListNode heah = new ListNode(1);
        heah.next = new ListNode(2);
        heah.next.next = new ListNode(3);
        heah.next.next.next = new ListNode(4);
        heah.next.next.next.next = new ListNode(5);

        heah = removeNthFromEnd(heah, n);

        String s = "";
        ListNode curr = heah;
        while (curr != null) {
            s += curr.val + " ";
            curr = curr.next;
        }
        System.out.println(s);

    }

    static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast pointer n+1 steps ahead >> get distance |n from tail| = |n from head|
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {   // slow moved before del node
            fast = fast.next;
            slow = slow.next;
        }

        // Remove the nth node from the end
        slow.next = slow.next.next;

        return dummy.next;
    }


    private static void LongestPalindromicSubstring_5() {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    static String longestPalindrome(String s) {
        if (s.length() == 0) return "";
        int start = 0;
        int end = 0;
        //char[] c = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int maxLen = Math.max(len1, len2);
            if (maxLen > end - start) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    static int expandAroundCenter(String s, int left, int right) {
        char[] c = s.toCharArray();
        while (left >= 0 && right < s.length() && c[left] == c[right]) {
            left--;
            right++;
        }
        return right - left - 1;
    }


    private static void ValidSudoku_36() {
        char[][] board =
                {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println(isValidSudoku(board));
    }

    private static boolean isValidSudoku(char[][] board) {
        // Arrays to store occurrences of each number in rows, columns and sub-boxes
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        // Traverse the board
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char num = board[r][c];
                if (num != '.') {
                    int n = num - '1'; // Convert to int 0 - 8
                    int boxIndex = (r / 3) * 3 + (c / 3);// Calculate th box index
                    // Check num is exits?
                    if (rows[r][n] || cols[c][n] || boxes[boxIndex][n]) {
                        return false;
                    }
                    rows[r][n] = true;
                    cols[c][n] = true;
                    boxes[boxIndex][n] = true;
                }
            }
        }
        // if no conflict, the board is valid
        return true;
    }


    private static void ThreeSum_15() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        var res = threeSum(nums);
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        if (nums == null || nums.length < 3) return res;

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }

    /*
    You are given an integer array height of length n.
    There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
    Find two lines that together with the x-axis form a container, such that the container contains the most water.
    Return the maximum amount of water a container can store.
    Notice that you may not slant the container.
*/
    private static void ContainerWithMostWater_11() {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

    private static int maxArea(int[] height) {
        int n = height.length;
        int max = -1;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            if (area > max) max = area;
            if (height[l] < height[r]) l++;
            else r--;
        }
        return max;
    }

    private static int maxArea_notEfficient(int[] height) {
        int n = height.length;
        int max = -1;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int area = Math.min(height[i], height[j]) * (j - i);
                if (area > max) max = area;
            }
        }
        return max;
    }
}
