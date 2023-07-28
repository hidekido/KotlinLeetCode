import kotlin.math.max

class Solution486 {
    fun PredictTheWinner(nums: IntArray): Boolean {
        val result = dp(nums, 0, nums.lastIndex, mutableMapOf())
        return result >= 0
    }

    fun dp(nums: IntArray, i: Int, j: Int, memo : MutableMap<String, Int>) : Int {
        if(i == j){
            return nums[i]
        }

        val key = "${i}_${j}"

        if(memo.containsKey(key)){
            return memo[key]!!
        }

        val left = -dp(nums, i + 1, j, memo) + nums[i]
        val right = -dp(nums, i, j - 1, memo) + nums[j]
        val result = max(left, right)
        memo[key] = result

        return result
    }
}