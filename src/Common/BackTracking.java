package Common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTracking {
    /*
    * Backtracking là một phương pháp giải quyết vấn đề bằng cách xây dựng từng bước giải pháp,
    * và loại bỏ các giải pháp không hợp lệ trong quá trình.
    * Phương pháp này thường được sử dụng để giải quyết các bài toán tổ hợp như
    * sắp xếp, chọn lọc, phân chia và các bài toán đệ quy khác.

    Ý tưởng chính của Backtracking:
    Bắt đầu từ một giải pháp rỗng.
    Xây dựng giải pháp một cách dần dần: Thêm các phần tử vào giải pháp một cách tuần tự.
    Kiểm tra tính hợp lệ: Ở mỗi bước, kiểm tra xem giải pháp hiện tại có hợp lệ không.
    Nếu không hợp lệ, quay lại bước trước đó và thử một lựa chọn khác (quay lui).
    Lặp lại quá trình này cho đến khi tìm được giải pháp hoặc xác định rằng không có
    giải pháp nào khả thi từ bước hiện tại.
    *
    * Ứng dụng của Backtracking:
    Bài toán N-Queens: Đặt N quân hậu trên bàn cờ NxN sao cho không quân hậu nào có thể tấn công quân hậu khác.
    Sudoku: Giải các bảng Sudoku bằng cách điền các số hợp lệ vào các ô trống.
    Tổ hợp và hoán vị: Tìm tất cả các tổ hợp hoặc hoán vị của một tập hợp các phần tử.
    Bài toán túi ba lô (Knapsack Problem): Tìm cách chọn các vật phẩm sao cho tổng trọng lượng
    không vượt quá giới hạn cho phép và tổng giá trị là lớn nhất.
    Backtracking là một kỹ thuật mạnh mẽ và linh hoạt, nhưng cũng có thể tốn kém về thời gian
    * và không gian nếu không được sử dụng cẩn thận, đặc biệt là đối với các bài toán có không gian tìm kiếm lớn.
    * */

    public static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                // Skip used elements or duplicates
                // handle duplicates, we also skip the element if it is the same as the previous element and the previous element has not been used in the current permutation (nums[i] == nums[i - 1] && !used[i - 1])
                if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) continue;
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(result, tempList, nums, used);
                // After the recursive call, we backtrack by unmarking the element as used and removing it from tempList
                used[i] = false; // Backtrack
                tempList.remove(tempList.size() - 1); // Remove the last element to try another one
            }
        }
    }

    public static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack(result, tempList, nums);
                tempList.remove(tempList.size() - 1); // remove last element
            }
        }
    }

    // Combinations
    public static void backtrack(List<List<Integer>> result, List<Integer> tempList, int start, int n, int k) {
        if (tempList.size() == k) {//have a complete combination
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i <= n; i++) {
                tempList.add(i);//add each integer to tempList
                backtrack(result, tempList, i + 1, n, k);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    // Combination Sum
    public static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remain, int start) {
        if (remain < 0) {
            return; // If remaining target is less than 0, no valid combination
        } else if (remain == 0) {
            result.add(new ArrayList<>(tempList)); // Found a valid combination
        } else {
            for (int i = start; i < candidates.length; i++) {
                tempList.add(candidates[i]);
                backtrack(result, tempList, candidates, remain - candidates[i], i); // Not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1); // Remove last element for backtracking
            }
        }
    }



    // Combination Sum 2
    public static void backtrack2(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remain, int start) {
        if (remain < 0) {
            return; // If remaining target is less than 0, no valid combination
        } else if (remain == 0) {
            result.add(new ArrayList<>(tempList)); // Found a valid combination
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) continue; // Skip duplicates
                tempList.add(candidates[i]);
                backtrack2(result, tempList, candidates, remain - candidates[i], i + 1); // Not reuse same elements
                tempList.remove(tempList.size() - 1); // Remove last element for backtracking
            }
        }
    }
    /*
    Given a collection of candidate numbers (candidates) and a target number (target),
    find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.



Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output:
[
[1,2,2],
[5]
]
    * */

    // Combination Sum 3
    public static void backtrack3(List<List<Integer>> result, List<Integer> tempList, int remain, int start, int k, boolean[] used) {
        if (remain < 0) {
            return; // If remaining target is less than 0, no valid combination
        } else if (remain == 0 && tempList.size() == k) {
            result.add(new ArrayList<>(tempList)); // Found a valid combination
        } else {
            for (int i = start; i < 10; i++) {
                if (used[i]) continue;
                used[i] = true;
                tempList.add(i);
                backtrack3(result, tempList, remain - i, i, k, used); //  reuse same elements
                used[i] = false;
                tempList.remove(tempList.size() - 1); // Remove last element for backtracking
            }
        }
    }
}
