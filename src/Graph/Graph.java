package Graph;

public class Graph {
    public static void main(String[] args) {
        FindTheTownJudge_997();
    }

    private static void FindTheTownJudge_997() {
        int n = 4;
        int[][] trust = {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};
        System.out.println(findJudge(n, trust));
    }

    static int findJudge(int n, int[][] trust) {
        if (trust.length == 1) return trust[0][1];

        for (int townJudge = 1; townJudge <= n; townJudge++) {
            int count = 0; boolean isJudge = true;
            for (int i = 0; i < trust.length; i++){
                if (trust[i][0] == townJudge) {
                    isJudge = false;
                    break;
                }
                if (trust[i][1] == townJudge) count++;
            }
            if (count == n - 1 && isJudge) return townJudge;
        }

        return -1;
    }
}
