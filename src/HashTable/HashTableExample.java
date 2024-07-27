package HashTable;

import java.util.*;
import java.util.stream.Collectors;

public class HashTableExample {
    public static void main(String[] args) {
        //HappyNumber_202();
        //MajorityElement_169();
        //MajorityElement2_229();
        //MostFrequentEvenElement_2404();
        //TopKFrequentElement_347();
        //ThirdMaximumNumber_414();
        NeitherMaximumNorMinimum_2733();

    }




    private static void NeitherMaximumNorMinimum_2733() {
        int[] nums = {3,2,1};
        System.out.println(findNonMinOrMax(nums));
    }
    static int findNonMinOrMax(int[] nums) {
        int max = Arrays.stream(nums).max().orElse(-1);
        int min = Arrays.stream(nums).min().orElse(-1);
        return Arrays.stream(nums).filter(x -> x != max && x != min).findFirst().orElse(-1);
    }

    // third distinct maximum
    private static void ThirdMaximumNumber_414() {
        int[] nums = {3,2,1};
        System.out.println(thirdMax(nums));
    }
    static int thirdMax(int[] nums) {
        // distinct
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        return set.stream()
                .sorted((a1, a2) -> Integer.compare(a2, a1))//desc
                .skip(2) // get 3rd ele
                .findFirst()
                .orElseGet(() -> Arrays.stream(nums).max().orElse(-1));
    }




    /*
    * Given an integer array nums and an integer k, return the k most frequent elements.
    * You may return the answer in any order.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]


Constraints:

1 <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
    * */
    private static void TopKFrequentElement_347() {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(topKFrequent(nums, k));
    }
    static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> occurs = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            if (occurs.containsKey(key)) {
                occurs.put(key, occurs.get(key) + 1);
            } else {
                occurs.put(key, 1);
            }
        }

        // 215
        // Sort in descending order, skip k elements, limit to 1, and get the first element
        int n = Arrays.stream(nums)
                .boxed()
                .sorted((a1, a2) -> Integer.compare(a2, a1))//desc
                .skip(k)
                .findFirst()
                .orElse(-1); // Provide a default value if no elements are found

        // 414 third distinct maximum number
        n = Arrays.stream(nums)
                .boxed()
                .sorted((a1, a2) -> Integer.compare(a2, a1))//desc
                .skip(2) // get 3rd ele
                .findFirst()
                .orElseGet(() -> Arrays.stream(nums).max().orElse(-1));



        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(occurs.entrySet());
        list.sort((e1,e2) -> e2.getValue().compareTo(e1.getValue()));

        return list.stream().limit(k).mapToInt(Map.Entry::getKey).toArray();
    }




    // Given an integer array nums, return the most frequent even element.
    //If there is a tie, return the smallest one.
    // If there is no such element, return -1.
    private static void MostFrequentEvenElement_2404() {
        int[] nums = {0,1,2,2,4,4,1};
        System.out.println(mostFrequentEven(nums));
    }
    static int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> evens = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            if (key % 2 == 0) {
                if (evens.containsKey(key)) {
                    evens.put(key, evens.get(key) + 1);
                } else {
                    evens.put(key, 1);
                }
            }
        }

        if (evens.isEmpty()) return -1;

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(evens.entrySet());
        entryList.sort((e1, e2) -> {
            int compare = e2.getValue().compareTo(e1.getValue());//desc
            if (compare != 0) {
                return compare;
            } else {
                return e1.getKey().compareTo(e2.getKey());
            }
        });

        return entryList.get(0).getKey();
    }

    // Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
    private static void MajorityElement2_229() {
        int[] nums = {3, 2, 3};
        System.out.println(majorityElement2(nums));
    }
    static List<Integer> majorityElement2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            var key = nums[i];
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        for (var key : map.keySet()) {
            if (map.get(key) > nums.length / 3) res.add(key);
        }
        return res;
    }



    private static void MajorityElement_169() {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums));
    }

    static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> occurences = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (occurences.containsKey(nums[i])) {
                occurences.put(nums[i], occurences.get(nums[i]) + 1);
                if (occurences.get(nums[i]) > nums.length / 2) return nums[i];
            } else {
                occurences.put(nums[i], 1);
            }
        }
        for (var key : occurences.keySet()) {
            if (occurences.get(key) > nums.length / 2) return key;
        }
        return Integer.MIN_VALUE;
    }


    private static void HappyNumber_202() {
        System.out.println(isHappy(22));
    }

    static boolean isHappy(int n) {
        Set<Integer> memo = new HashSet<>();
        while (n != 1 && !memo.contains(n)) {
            memo.add(n);
            n = getSum(n);
        }
        return n == 1;
    }

    private static int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n = n / 10;
        }
        return sum;
    }

    /*
    * Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.



Example 1:

Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
Example 2:

Input: n = 2
Output: false


Constraints:

1 <= n <= 231 - 1
    * */
}
