public class 链表倒数第k个节点 {

    public ListNode FindKthToTail(ListNode pHead, int k) {
        ListNode fast = pHead;
        ListNode slow = pHead;

        for (int i = 0; i < k; i++) {
            if (fast != null)
                // 快指针先走k步
                fast = fast.next;
            else
                // 走不到k步说明链表太短
                return slow = null;
        }

        // 随后同步移动
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
