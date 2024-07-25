package DynamicProgramming;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicP01 {
    public static void main(String[] args) {
        //PascalTriangle2_119();
        //ClimbingStairs_70();
        MinCostClimbingStairs_746();

    }

    private static void MinCostClimbingStairs_746() {
        int[] cost = new int[]{10, 15, 20};
        int re = minCostClimbingStairs(cost);
        System.out.println(re);
    }

    // Bottom Up DP     O(n)
    static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        dp[0] = 0; dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] +  cost[i - 2]);
        }
        return dp[n];
    }


    private static void ClimbingStairs_70() {
        int ways = climbStairs(10);
    }

    private static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i >= 1) dp[i] += dp[i - 1];
            if (i >= 2) dp[i] += dp[i - 2];
        }
        return dp[n];
    }

    private static void PascalTriangle2_119() {
        List<Integer> re = GetRow(33);
    }

    private static List<Integer> GetRow(int rowIndex) {
        List<Integer> li = new ArrayList<>(List.of(1));
        if (rowIndex == 0) return li;
        li.add(1);
        if (rowIndex == 1) return li;
        for (int row = 2; row <= rowIndex; row++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int i = 0; i < row - 1; i++) {
                temp.add(li.get(i) + li.get(i + 1));
            }
            temp.add(1);
            li = temp;
        }
        return li;
    }


}
