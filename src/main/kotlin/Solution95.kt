import entity.TreeNode

class Solution95 {
    fun generateTrees(n: Int): List<TreeNode?> {
        return recurse(1, n)
    }

    fun recurse(from: Int, to: Int): List<TreeNode?> {
        if(from > to){
            return listOf(null)
        }
        if(from == to){
            return listOf(TreeNode(from))
        }
        val result = mutableListOf<TreeNode>()
        for(cur in from..to){
            val left = recurse(from, cur - 1)
            val right = recurse(cur + 1, to)
            for(l in left){
                for(r in right){
                    val next = TreeNode(cur)
                    next.left = l
                    next.right = r
                    result.add(next)
                }
            }
        }
        return result
    }
}