import entity.TreeNode

class Solution894 {


    val memo: MutableMap<Int, MutableList<TreeNode>> = mutableMapOf()
    fun allPossibleFBT(n: Int): List<TreeNode?> {
        if (n % 2 == 0) {
            return emptyList()
        }

        if (n == 1) {
            return listOf(TreeNode(0))
        }

        if (memo.containsKey(n)) {
            return memo[n]!!
        }

        val result = mutableListOf<TreeNode>()

        for (i in 1..n - 1 step 2) {
            val left = allPossibleFBT(i)
            val right = allPossibleFBT(n - i - 1)
            for (l in left) {
                for (r in right) {
                    val root = TreeNode(0)
                    root.left = l
                    root.right = r
                    result.add(root)
                }
            }
        }

        memo[n] = result

        return result
    }

}