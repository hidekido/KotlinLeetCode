class Solution439 {
    fun parseTernary(expression: String): String {
        if (expression.length == 1) return expression
        var count = 0
        for (i in 2 until expression.length) {
            if (expression[i] == '?') count++
            else if (expression[i] == ':') count--
            if (count == -1) {
                return if (expression[0] == 'T')
                    parseTernary(expression.substring(2, i))
                else
                    parseTernary(expression.substring(i + 1))
            }
        }
        return ""
    }
}