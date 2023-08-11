class Solution518 {
    fun change(amount: Int, coins: IntArray): Int {
        val memo = Array(coins.size + 1){ IntArray(amount + 1){ -1 } }
        return dp(0, amount, coins, memo)
    }

    private fun dp(cur: Int, sum: Int, coins: IntArray, memo: Array<IntArray>): Int {
        if(sum == 0){
            return 1
        }

        if(cur > coins.lastIndex){
            return 0
        }

        if(memo[cur][sum] != -1){
            return memo[cur][sum]
        }

        var result = 0

        for(i in 0..sum / coins[cur]){
            result += dp(cur + 1, sum - i * coins[cur], coins, memo)
        }

        memo[cur][sum] = result

        return result
    }
}