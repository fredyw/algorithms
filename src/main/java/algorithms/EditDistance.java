package algorithms;

public class EditDistance {
    public static int editDistance(String a, String b) {
        int[][] memo = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                memo[i][j] = -1;
            }
        }
        return editDistance(a, b, a.length(), b.length(), memo);
    }

    private static int editDistance(String a, String b, int i, int j, int[][] memo) {
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (i == 0) {
            return j;
        }
        if (j == 0) {
            return i;
        }
        if (a.charAt(i - 1) == b.charAt(j - 1)) {
            return editDistance(a, b, i - 1, j - 1, memo);
        }
        int insert = editDistance(a, b, i, j - 1, memo);
        int delete = editDistance(a, b, i - 1, j, memo);
        int replace = editDistance(a, b, i - 1, j - 1, memo);

        int min = 1 + Math.min(insert, Math.min(delete, replace));
        memo[i][j] = min;
        return min;
    }
}
