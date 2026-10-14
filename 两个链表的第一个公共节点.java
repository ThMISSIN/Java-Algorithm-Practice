public class 两个链表的第一个公共节点 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = listNodeLength(pHead1);
        int len2 = listNodeLength(pHead2);
        // 如果链表一更长，则先走 len1 - len2 步
        if(len1 > len2) {
            int offset = len1 - len2;
            for(int i = 0; i < offset; i++) {
                pHead1 = pHead1.next;
            }
            // 随后链表同时移动找到公共点为止
            while((pHead1 != null) && (pHead2 != null) && (pHead1 != pHead2)) {
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
        } else {
            int offset = len2 - len1;
            for(int i = 0; i < offset; i++) {
                pHead2 = pHead2.next;
            }
            // 随后链表同时移动找到公共点为止
            while((pHead1 != null) && (pHead2 != null) && (pHead1 != pHead2)) {
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
        }
        return pHead1;
    }

    public int listNodeLength(ListNode head) {
        int n = 0;
        ListNode l = head;
        while(l != null) {
            n++;
            l = l.next;
        }
        return n;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
