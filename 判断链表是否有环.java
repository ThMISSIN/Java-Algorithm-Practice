public class 判断链表是否有环 {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;

        // 定义快慢指针
        ListNode fast = head;
        ListNode slow = head;

        // 快指针移动两次，慢指针移动一次
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            // 当快慢指针相遇时，说明有环
            if(slow == fast)  return true;
        }

        return false;
    }

    public class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int val) {
            this.val = val;
        }
    }

}
