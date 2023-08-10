class Solution81 {
    fun search(nums: IntArray, target: Int): Boolean {
        var left = 0
        var right = nums.lastIndex

        while(left <= right){
            val pointer = left + (right - left) / 2

            if(nums[pointer] == target){
                return true
            }

            if(nums[left] == nums[pointer]){
                left++
                continue
            }

            if(nums[left] <= nums[pointer]){
                if(nums[left] <= target && target < nums[pointer]){
                    right = pointer - 1
                } else {
                    left = pointer + 1
                }
            }

            if(nums[pointer] <= nums[right]){
                if(nums[pointer] < target && target <= nums[right]){
                    left = pointer + 1
                } else {
                    right = pointer - 1
                }
            }
        }

        return false
    }
}