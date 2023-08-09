import kotlin.math.abs

class Solution2616 {
    fun minimizeMax(nums: IntArray, p: Int): Int {
        nums.sort()
        var left = 0
        var right = nums.last() - nums.first()
        while(left < right){
            val pointer = left + (right - left) / 2

            if(countPairs(nums, pointer) >= p){
                right = pointer
            } else {
                left = pointer + 1
            }
        }
        return left
    }

    private fun countPairs(nums: IntArray, diff: Int): Int{
        var index = 0
        var count = 0
        while(index < nums.lastIndex){
            if(nums[index + 1] - nums[index] <= diff){
                count++
                index++
            }
            index++
        }

        return count
    }
}