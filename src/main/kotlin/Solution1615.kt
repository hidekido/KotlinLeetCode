class Solution1615 {
    fun maximalNetworkRank(n: Int, roads: Array<IntArray>): Int {
        val map = mutableMapOf<Int, MutableSet<Int>>()

        for(i in 0..n){
            map[i] = mutableSetOf()
        }

        for(road in roads){
            val i = road[0]
            val j = road[1]
            map[j]!!.add(i)
            map[i]!!.add(j)
        }

        var max = 0

        for(i in 0..n - 1){
            for(j in i + 1..n){
                val result = map[i]!!.size + map[j]!!.size - if(map[i]!!.contains(j)) 1 else 0

                max = maxOf(max, result)
            }
        }

        return max
    }
}