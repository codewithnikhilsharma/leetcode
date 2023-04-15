class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        // create a 2D array to store the maximum value of coins for choosing j coins from the first i piles
        int[][] dp = new int[piles.size() + 1][k + 1];
        // fill the first row of the array with zeros
        Arrays.fill(dp[0], 0);
        // fill the first column of the array with zeros
        for (int i = 1; i <= piles.size(); i++) {
            dp[i][0] = 0;
        }
        // iterate through the array and compute the maximum value of coins for each subproblem
        for (int i = 1; i <= piles.size(); i++) {
            for (int j = 1; j <= k; j++) {
                int cur = 0;
                // try all possible choices for the current pile and update the maximum result
                for (int x = 0; x < Math.min(piles.get(i - 1).size(), j); x++) {
                    cur += piles.get(i - 1).get(x);
                    dp[i][j] = Math.max(dp[i][j], cur + dp[i - 1][j - x - 1]);
                }
                // if not choosing any coin from the current pile gives a better result, use that instead
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
            }
        }
        // the last element of the array is the maximum value of coins for choosing k coins from all the piles
        return dp[piles.size()][k];
    }
}
