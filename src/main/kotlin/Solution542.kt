class Solution542 {
    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        val n = mat.size
        val m = mat[0].size

        for (i in 0..n - 1) {
            for (j in 0..m - 1) {
                if(mat[i][j] == 0){
                    continue
                }

                var len = n * m

                if(i > 0){
                    len = minOf(len, mat[i - 1][j])
                }
                if(j > 0){
                    len = minOf(len, mat[i][j - 1])
                }

                mat[i][j] = len + 1
            }
        }

        for(i in n - 1 downTo 0){
            for(j in m - 1 downTo 0){
                if(mat[i][j] == 0){
                    continue
                }

                var len = n * m

                if(i < n - 1){
                    len = minOf(len, mat[i + 1][j])
                }
                if(j < m - 1){
                    len = minOf(len, mat[i][j + 1])
                }

                mat[i][j] = minOf(mat[i][j], len + 1)
            }
        }

        return mat
    }
}