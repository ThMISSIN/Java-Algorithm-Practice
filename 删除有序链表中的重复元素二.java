public class 删除有序链表中的重复元素二 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode res = new ListNode(0);
        res.next = head;
        ListNode curr = res;
        while (curr.next != null && curr.next.next != null) {
            if (curr.next.val == curr.next.next.val) {
                int temp = curr.next.val;
                // 将所有相同的都跳过
                while (curr.next != null && curr.next.val == temp)
                    curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
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
