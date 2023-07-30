class Solution1060 {
    fun missingElement(nums: IntArray, k: Int): Int {
        val start = nums[0]
        var l = 0
        var r = nums.lastIndex

        val missedTotal = (nums.last() - start + 1) - nums.size
        if(missedTotal < k){
            return nums.last() + k - missedTotal
        }

        while(l < r - 1){
            val pointer = (l + r) / 2
            val missed = (nums[pointer] - start) - pointer
            if(missed >= k){
                r = pointer
            } else {
                l = pointer
            }
        }

        return k + start + l
    }
}