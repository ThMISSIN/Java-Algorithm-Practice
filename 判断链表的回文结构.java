public class 判断链表的回文结构 {
    public boolean isPail(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // 通过快慢指针找到链表中点
        ListNode fast = head;
        ListNode slow = head;

        // fast指向 第二个 2 ，slow指向第一个2
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 翻转slow的下一个节点， 1->2->1->2
        ListNode rightHead = reverse(slow.next);


        ListNode left = head;
        ListNode right = rightHead;

        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }


    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
