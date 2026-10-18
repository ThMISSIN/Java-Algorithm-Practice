public class 链表奇偶重排 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        // 偶数位
        ListNode even = head.next;
        // 奇数位
        ListNode odd = head;

        ListNode evenHead = even;

        while (even != null && even.next != null) {
            // 偶数位后面一定是奇数位
            odd.next = even.next;
            odd = odd.next;
            // 奇数位后面一定是偶数位
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }


    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
