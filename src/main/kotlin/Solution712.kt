class Solution712 {
    fun minimumDeleteSum(s1: String, s2: String): Int {
        val m = s1.length
        val n = s2.length

        val dp = Array(m + 1) { IntArray(n + 1) }

        for (i in 1..m) {
            dp[i][0] = dp[i - 1][0] + s1[i - 1].toInt()
        }

        for (j in 1..n) {
            dp[0][j] = dp[0][j - 1] + s2[j - 1].toInt()
        }

        for (i in 1..m) {
            for (j in 1..n) {
                dp[i][j] = if (s1[i - 1] == s2[j - 1]) {
                    dp[i - 1][j - 1]
                } else {
                    minOf(dp[i - 1][j] + s1[i - 1].toInt(), dp[i][j - 1] + s2[j - 1].toInt())
                }
            }
        }

        return dp[m][n]
    }
}