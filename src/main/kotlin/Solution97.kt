class Solution97 {
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        val n = s1.length
        val m = s2.length
        if (n + m != s3.length) {
            return false
        }

        val dp = Array(n + 1) { BooleanArray(m + 1) }

        for (i in 0..n) {
            for (j in 0..m) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && s3[i + j - 1] == s2[j - 1]
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && s3[i + j - 1] == s1[i - 1]
                } else {
                    dp[i][j] =
                        (dp[i][j - 1] && s3[i + j - 1] == s2[j - 1]) || dp[i - 1][j] && s3[i + j - 1] == s1[i - 1]
                }
            }
        }

        return dp[n][m]
    }
}