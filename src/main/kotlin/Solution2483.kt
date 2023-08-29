class Solution2483 {
    fun bestClosingTime(customers: String): Int {
        val penalties = IntArray(customers.length)
        var penalty = 0
        for(i in customers.lastIndex downTo 0){
            if(customers[i] == 'Y'){
                penalty++
            }
            penalties[i] = penalty
        }

        penalty = 0
        var result = Int.MAX_VALUE
        var resultDay = 0
        for(i in 0..customers.lastIndex){
            if(result > penalties[i] + penalty){
                result = penalties[i] + penalty
                resultDay = i
            }
            if(customers[i] == 'N'){
                penalty++
            }
        }
        return if(penalty < result){
            customers.length
        } else {
            resultDay
        }
    }
}