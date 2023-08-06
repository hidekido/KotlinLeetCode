class Solution920 {
    fun numMusicPlaylists(n: Int, goal: Int, k: Int): Int {
        val MODULO = 1_000_000_007

        val memo = Array(goal + 1) {LongArray(n + 1)}

        memo[0][0] = 1

        for(i in 1..goal){
            for(j in 1..minOf(n, i)){
                memo[i][j] = memo[i - 1][j - 1] * (n - j + 1) % MODULO

                if(j > k){
                    memo[i][j] = (memo[i][j] + memo[i - 1][j] * (j - k)) % MODULO
                }
            }
        }

        return memo[goal][n].toInt()
    }

}