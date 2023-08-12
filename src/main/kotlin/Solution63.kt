class Solution63 {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        val memo = Array(obstacleGrid.size + 1) { IntArray(obstacleGrid[0].size + 1) { -1 } }
        return dp(0, 0, obstacleGrid, memo)
    }

    private fun dp(i: Int, j: Int, obstacleGrid: Array<IntArray>, memo: Array<IntArray>): Int{
        if(i > obstacleGrid.lastIndex || j > obstacleGrid.first().lastIndex || obstacleGrid[i][j] == 1){
            return 0
        }

        if(i == obstacleGrid.lastIndex && j == obstacleGrid.first().lastIndex){
            return 1
        }

        if(memo[i][j] != -1){
            return memo[i][j]
        }

        memo[i][j] = dp(i + 1, j, obstacleGrid, memo) + dp(i, j + 1, obstacleGrid, memo)

        return memo[i][j]
    }
}