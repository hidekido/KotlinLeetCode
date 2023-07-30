import kotlin.math.min

class Solution664 {
    fun strangePrinter(s: String): Int {
        val str = StringBuilder()
        var i = 0
        while (i < s.length) {
            val c = s[i]
            while (i + 1 < s.length && s[i + 1] == c) {
                i++
            }
            str.append(c)
            i++
        }

        val n = str.length
        val dp = Array(n) { IntArray(n) { 0 } }
        for (i in n - 1 downTo 0) {
            dp[i][i] = 1
            for (j in i + 1 until n) {
                if (str[i] == str[j]) {
                    dp[i][j] = dp[i][j - 1]
                } else {
                    var min = Int.MAX_VALUE
                    for (k in i until j) {
                        min = minOf(min, dp[i][k] + dp[k + 1][j])
                    }
                    dp[i][j] = min
                }
            }
        }
        return dp[0][n - 1]
    }
}
