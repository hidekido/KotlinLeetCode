class Solution2366 {
    fun minimumReplacement(nums: IntArray): Long {
        var result = 0L
        for(i in nums.lastIndex - 1 downTo 0){
            if(nums[i] <= nums[i + 1]){
                continue
            }

            val newElements = if(nums[i] % nums[i + 1] == 0){
                nums[i] / nums[i + 1]
            } else {
                nums[i] / nums[i + 1] + 1
            }

            result += newElements - 1

            nums[i] = nums[i] / newElements
        }

        return result
    }
}