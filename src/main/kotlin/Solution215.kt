import java.util.PriorityQueue

class Solution215 {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val queue = PriorityQueue<Int>()
        for(i in nums){
            queue.offer(i)
            if(queue.size > k){
                queue.poll()
            }
        }

        return queue.poll()
    }
}