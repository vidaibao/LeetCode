package Array;

public class Array01 {
    public static void main(String[] args) {
        ContainerWithMostWater_11();
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

    private static int maxArea(int[] height){
        int n = height.length;
        int max = -1;
        int l = 0; int r = n - 1;
        while (l < r){
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
