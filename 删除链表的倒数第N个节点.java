
public class 删除链表的倒数第N个节点 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @param n    int整型
     * @return ListNode类
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = new ListNode(-1);
        res.next = head;

        ListNode fast = head;
        ListNode slow = head;

        // 先让 快指针 移动 n 步，再同时移动，最后 慢指针 指向的就是要删除的点
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        ListNode pre = res;
        while (fast != null) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }

        // 删除slow节点
        pre.next = slow.next;

        return res.next;
    }


    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
}