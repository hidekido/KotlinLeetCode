class Solution852 {
    fun peakIndexInMountainArray(arr: IntArray): Int {
        for(i in 1..arr.size - 1){
            if(arr[i - 1] > arr[i]){
                return i - 1
            }
        }
        return -1
    }
}