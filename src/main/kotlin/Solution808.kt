class Solution808 {
    fun soupServings(n: Int): Double {
        if(n > 4800){
            return 1.0
        }
        val firstA = dp(n, n, mutableMapOf())
        return firstA
    }

    private fun dp(n: Int, m: Int, memo : MutableMap<String, Double>): Double {
        when{
            n <= 0 && m <= 0 -> return .5
            m <= 0 -> return .0
            n <= 0 -> return 1.0
        }

        val key = "${n}_${m}"

        if(memo.containsKey(key)){
            return memo[key]!!
        }
        var result = 0.0
        result += dp(n - 100, m, memo)
        result += dp(n - 75,m - 25, memo)
        result += dp(n - 50, m - 50, memo)
        result += dp(n - 25, m - 75, memo)

        memo[key] = result / 4

        return memo[key]!!
    }

}