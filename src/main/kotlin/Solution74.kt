class Solution74 {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val n = matrix[0].size
        var left = 0
        var right = matrix.size * matrix[0].size - 1

        while(left <= right){
            val pointer = (left + right) / 2

            val i = pointer / n
            val j = pointer % n

            if(matrix[i][j] == target){
                return true
            } else if(matrix[i][j] < target){
                left = pointer + 1
            } else {
                right = pointer - 1
            }
        }

        return false
    }
}