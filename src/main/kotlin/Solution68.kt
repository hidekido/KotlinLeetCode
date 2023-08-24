class Solution68 {
    fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
        val result = mutableListOf<String>()
        var i = 0
        while(i <= words.lastIndex){
            val row = mutableListOf<String>()
            var len = words[i].length
            var lenWords = words[i].length
            row.add(words[i])
            i++
            while(i <= words.lastIndex && len + words[i].length + 1 <= maxWidth){
                len += words[i].length + 1
                lenWords += words[i].length
                row.add(words[i])
                i++
            }
            var spaces = maxWidth - lenWords
            val sb = StringBuilder()

            if(i == words.size){
                row[row.lastIndex] += " ".repeat(maxWidth - len)
                spaces = row.size - 1
            }

            if(row.size == 1){
                row[0] += " ".repeat(spaces)
            } else {
                while (spaces > 0) {
                    for (w in 0..row.lastIndex - 1) {
                        if (spaces > 0) {
                            row[w] = row[w] + ' '
                            spaces--
                        } else {
                            break
                        }
                    }
                }
            }

            for(word in row){
                sb.append(word)
            }

            result.add(sb.toString())
        }

        return result
    }
}