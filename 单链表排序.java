import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 单链表排序 {
    public ListNode sortInList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Collections.sort(list);
        ListNode res = new ListNode(-1);
        ListNode phead = res;
        for (int val : list) {
            phead.next = new ListNode(val);
            phead = phead.next;
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
