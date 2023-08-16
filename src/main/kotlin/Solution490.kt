class Solution490 {
    fun hasPath(maze: Array<IntArray>, start: IntArray, destination: IntArray): Boolean {
        return dp(start[0], start[1], maze, destination, Array(maze.size + 1) { BooleanArray(maze[0].size + 1) })
    }

    private fun dp(i: Int, j: Int, maze: Array<IntArray>, destination: IntArray, memo: Array<BooleanArray>): Boolean {
        if (i == destination[0] && j == destination[1]) {
            return true
        }

        if (memo[i][j]) {
            return false
        }

        memo[i][j] = true
        for (next in moveNext(i, j, maze)) {
            if (dp(next[0], next[1], maze, destination, memo)) {
                return true
            }
        }
        return false
    }

    private fun moveNext(i: Int, j: Int, maze: Array<IntArray>): Array<IntArray> {
        val result = Array(4) { IntArray(2) }

        var ii = i
        var jj = j
        while (jj + 1 <= maze[ii].lastIndex && maze[ii][jj + 1] != 1) {
            jj++
        }
        result[0][0] = ii
        result[0][1] = jj

        ii = i
        jj = j
        while (jj - 1 >= 0 && maze[ii][jj - 1] != 1) {
            jj--
        }
        result[1][0] = ii
        result[1][1] = jj

        ii = i
        jj = j
        while (ii + 1 <= maze.lastIndex && maze[ii + 1][jj] != 1) {
            ii++
        }
        result[2][0] = ii
        result[2][1] = jj

        ii = i
        jj = j
        while (ii - 1 >= 0 && maze[ii - 1][jj] != 1) {
            ii--
        }
        result[3][0] = ii
        result[3][1] = jj

        return result
    }
}