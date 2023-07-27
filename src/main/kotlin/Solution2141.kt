class Solution2141 {
    fun maxRunTime(n: Int, batteries: IntArray): Long {
        batteries.sortDescending()
        var sum : Long = 0
        for(b in batteries){
            sum += b
        }
        var count = 0
        while(batteries[count] > sum / (n - count)){
            sum -= batteries[count]
            count++
        }
        return sum / (n - count)
    }
}