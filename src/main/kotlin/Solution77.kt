class Solution77 {
    fun combine(n: Int, k: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        recurse(1, n, result, mutableListOf(), k)
        return result
    }

    private fun recurse(from: Int, to: Int, acc: MutableList<List<Int>>, cur: MutableList<Int>, k: Int){
        if(k == 0){
            acc.add(cur.toList())
            return
        }

        for(i in from..to - k + 1){
            cur.add(i)
            recurse(i + 1, to, acc, cur, k - 1)
            cur.removeAt(cur.lastIndex)
        }
    }
}