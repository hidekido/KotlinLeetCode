class Solution33 {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1

        while(left <= right){
            val pointer = (left + right) / 2

            if(nums[pointer] == target){
                return pointer
            }

            if(nums[left] <= nums[pointer]){
                if(target >= nums[left] && target < nums[pointer]){
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

        return -1
    }
}