class Solution168 {
    fun convertToTitle(columnNumber: Int): String {
        val result = StringBuilder()
        var num = columnNumber
        while(num > 0){
            num -= 1
            val c = (num % 26 + 'A'.toInt()).toChar()
            result.append(c)
            num /= 26
        }

        return result.reverse().toString()
    }
}