package Sorting;

import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        //SortStudentKScore_2545();
        MaximumNumberOfCoins_1561();
        
    }

    private static void MaximumNumberOfCoins_1561() {
        int[] piles = {2,4,1,2,7,8};
        System.out.println(maxCoins(piles));
    }

    private static int maxCoins(int[] piles) {
        int n = piles.length / 3; // 3n
        Arrays.sort(piles);
        int maxCoins = 0;
        // ANY way
        // n times minimum are for Bob, so 2nd is for ME, largest for Alice
        for (int i = piles.length - 2; i >= n; i -= 2) {
            maxCoins += piles[i];
        }
        return maxCoins;
    }

    private static void SortStudentKScore_2545() {
        int k = 2;
        int[][] score = {{10, 6, 9, 1}, {7, 5, 11, 2}, {4, 8, 3, 15}};
        var re = sortTheStudents(score, k);
    }

    static int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (a, b) -> Integer.compare(b[k], a[k]));
        return score;
    }

}
