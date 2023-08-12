class Solution271 {
    class Codec {
        // Encodes a list of strings to a single string.
        fun encode(strs: List<String>): String {
            val result = StringBuilder()
            for(s in strs){
                result.append(s.length).append("=").append(s)
            }

            return result.toString()
        }

        // Decodes a single string to a list of strings.
        fun decode(s: String): List<String> {
            val result = mutableListOf<String>()
            var i = 0
            while(i <= s.lastIndex){
                var size = 0
                while(s[i].isDigit()){
                    size *= 10
                    size += s[i].toInt() - '0'.toInt()
                    i++
                }
                val next = s.substring(i + 1, i + 1 + size)
                result.add(next)
                i += 1 + size
            }
            return result
        }
    }
}