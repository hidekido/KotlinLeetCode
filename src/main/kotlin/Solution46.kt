class Solution46 {
    fun permute(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        process(nums.toMutableSet(), mutableListOf(), result)

        return result
    }

    private fun process(nums: MutableSet<Int>, cur: MutableList<Int>, result: MutableList<List<Int>>){
        if(nums.isEmpty()){
            result.add(cur.toList())
            return
        }
        val nextItems = nums.toList()
        for(i in nextItems){
            nums.remove(i)
            cur.add(i)
            process(nums, cur, result)
            cur.removeAt(cur.lastIndex)
            nums.add(i)
        }
    }
}