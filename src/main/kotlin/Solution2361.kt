class Solution2361 {
    fun minimumCosts(regular: IntArray, express: IntArray, expressCost: Int): LongArray {
        val n = regular.size
        val dp = Array(n) { LongArray(2) { Long.MAX_VALUE } }
        dp[0][0] = regular[0].toLong()
        dp[0][1] = express[0].toLong() + expressCost
        for (i in 1 until n) {
            dp[i][0] = minOf(dp[i - 1][0], dp[i - 1][1]) + regular[i]
            dp[i][1] = minOf(dp[i - 1][0] + express[i] + expressCost, dp[i - 1][1] + express[i])
        }
        val result = LongArray(n)
        for (i in 0 until n) {
            result[i] = minOf(dp[i][0], dp[i][1])
        }
        return result
    }
}