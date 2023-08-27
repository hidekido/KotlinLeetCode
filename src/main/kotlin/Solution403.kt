class Solution403 {
    fun canCross(stones: IntArray): Boolean {
        val stoneMap = mutableMapOf<Int, Int>()
        for (i in 0..stones.lastIndex) {
            stoneMap.put(stones[i], i)
        }

        return dp(1, 1, stones, mutableSetOf(), stoneMap)
    }

    private fun dp(i: Int, turn: Int, stones: IntArray, memo: MutableSet<String>, stoneMap: Map<Int, Int>): Boolean {
        if (!stoneMap.containsKey(i)) {
            return false
        }

        if (stoneMap[i] == stones.lastIndex) {
            return true
        }

        val key = "$i $turn"

        if (memo.contains(key)) {
            return false
        }

        memo.add(key)

        return dp(i + turn, turn, stones, memo, stoneMap) || dp(
            i + turn + 1,
            turn + 1,
            stones,
            memo,
            stoneMap
        ) || (if (turn > 0) dp(i + turn - 1, turn - 1, stones, memo, stoneMap) else false)
    }
}