public class 链表相加 {

    public ListNode reverseList(ListNode l) {
        if (l == null) return null;
        ListNode curr = l;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public ListNode addInList(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        // 翻转链表
        head1 = reverseList(head1);
        head2 = reverseList(head2);
        // 添加表头
        ListNode res = new ListNode(-1);
        ListNode head = res;

        int carry = 0; // 进位符号
        // 只要链表还有 或 进位还有 就继续
        while (head1 != null || head2 != null || carry != 0) {
            int val1 = head1 == null ? 0 : head1.val;
            int val2 = head2 == null ? 0 : head2.val;

            int temp = val1 + val2 + carry;
            // 如果 temp > 10 说明需要往前进位
            carry = temp / 10;
            // 当前位置的数则为 temp % 10
            temp %= 10;

            // 将当前元素添加到新链表中
            head.next = new ListNode(temp);
            head = head.next;

            // 移动链表
            if (head1 != null) head1 = head1.next;
            if (head2 != null) head2 = head2.next;

        }

        return reverseList(res.next);
    }


    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
