import entity.ListNode

class Solution86 {
    fun partition(head: ListNode?, x: Int): ListNode? {
        val dummy = ListNode(-1)
        val greaterDummy = ListNode(-1)
        var left = dummy
        var right = greaterDummy

        var pointer = head

        while(pointer != null){
            if(pointer.`val` < x){
                left.next = pointer
                left = pointer
            } else {
                right.next = pointer
                right = pointer
            }
            pointer = pointer.next
        }
        left.next = null
        right.next = null

        return if(dummy.next != null){
            left.next = greaterDummy.next
            dummy.next
        } else {
            greaterDummy.next
        }
    }
}