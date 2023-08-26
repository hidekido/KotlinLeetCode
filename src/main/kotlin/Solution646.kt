class Solution646 {
    fun findLongestChain(pairs: Array<IntArray>): Int {
        pairs.sortWith(compareBy({ it[1] }, { it[0] }))
        var prev = pairs[0]
        var result = 1
        for(i in 1..pairs.lastIndex){
            if(pairs[i][0] > prev[1]){
                prev = pairs[i]
                result++
            }
        }
        return result
    }
}