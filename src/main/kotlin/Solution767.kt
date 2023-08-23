class Solution767 {
    fun reorganizeString(s: String): String {
        val chars = IntArray(27)
        for(c in s){
            chars[c - 'a']++
        }
        var last = -1
        val sb = StringBuilder()
        while(sb.length < s.length){
            var next = 26
            for(i in 0..25){
                if(chars[i] > chars[next] && i != last){
                    next = i
                }
            }
            if(chars[next] == 0){
                return ""
            }
            chars[next]--
            sb.append(('a' + next).toChar())
            last = next
        }

        return sb.toString()
    }
}