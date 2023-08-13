class Solution2369 {
    fun validPartition(nums: IntArray): Boolean {
        return dp(0, 0, nums, Array(nums.size + 1){ BooleanArray(5) })
    }


    /*
    Conditions:
    0 - start of a new subarray
    1 - second equal element
    2 - third equal element
    3 - second increasing element
    4 - third increasing element
     */


    private fun dp(cur: Int, condition: Int, nums: IntArray, memo: Array<BooleanArray>): Boolean{
        if(cur == nums.size){
            return condition == 0
        }

        if(memo[cur][condition]){
            return false
        }

        var result = false

        when(condition) {
            0 -> result = dp(cur + 1, 1, nums, memo) || dp(cur + 1, 3, nums, memo)
            1 -> {
                result = if(nums[cur] == nums[cur - 1])
                    dp(cur + 1, 2, nums, memo) || dp(cur + 1, 0, nums, memo)
                else
                    false
            }
            2 -> {
                result = if(nums[cur] == nums[cur - 1])
                    dp(cur + 1, 0, nums, memo)
                else
                    false
            }
            3 -> {
                result = if(nums[cur] == nums[cur - 1] + 1)
                    dp(cur + 1, 4, nums, memo)
                else
                    false
            }
            4 -> {
                result = if(nums[cur] == nums[cur - 1] + 1)
                    dp(cur + 1, 0, nums, memo)
                else
                    false
            }
        }

        memo[cur][condition] = true

        return result
    }
}