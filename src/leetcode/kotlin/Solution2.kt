package leetcode.kotlin

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution2 {
    fun addTwoNumbers(_l1: ListNode?, _l2: ListNode?): ListNode? {
        val head = ListNode(0)
        var tail = head
        var l1 = _l1
        var l2 = _l2

        var carry = 0
        while (l1 != null || l2 != null || carry > 0) {
            val v = (l1?.`val` ?: 0) + (l2?.`val` ?: 0) + carry
            tail.next = ListNode(v % 10)
            carry = v / 10

            l1 = l1?.next
            l2 = l2?.next
            tail = tail.next!!
        }

        return head.next
    }
}