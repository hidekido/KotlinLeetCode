import java.util.*

class Solution225 {
    class MyStack() {

        var first = LinkedList<Int>()
        var second = LinkedList<Int>()

        var top = 0

        fun push(x: Int) {
            first.push(x)
            top = x
        }

        fun pop(): Int {
            while(first.size > 1){
                top = first.removeLast();
                second.push(top)
            }
            val result = first.removeLast()
            first = second
            second = LinkedList<Int>()
            return result
        }

        fun top(): Int {
            return top
        }

        fun empty(): Boolean {
            return first.isEmpty()
        }
    }
}