import kotlin.math.ceil
import kotlin.math.max
import kotlin.math.min

class Solution1870 {
    fun minSpeedOnTime(dist: IntArray, hour: Double): Int {
        if (dist.size > Math.ceil(hour)) {
            return -1
        }
        var min = 1
        var maxValue = dist.max()!!
        maxValue = max(maxValue, dist.last() * 100)
        maxValue = min(maxValue, 10_000_000)
        while(min < maxValue) {
            val pointer = min + (maxValue - min) / 2
            if (calc(dist, hour, pointer)) {
                maxValue = pointer
            } else {
                min = pointer + 1
            }
        }
        return min
    }

    fun calc(dist: IntArray, hour: Double, speed: Int): Boolean {
        var result = 0.0
        for(i in 0 until dist.lastIndex){
            result += ceil(dist[i].toDouble() / speed)
            if(result > hour){
                return false
            }
        }
        result += dist.last().toDouble() / speed
        return result <= hour
    }
}