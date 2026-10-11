import java.util.ArrayList;

public class 合并k组已排序链表 {
    public ListNode merge(ListNode l1,ListNode l2) {
        // 边界值判断
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        // 表头
        ListNode head = new ListNode(0);
        ListNode curr = head;

        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if(l1 != null) curr.next = l1;
        else curr.next = l2;

        return head.next;
    }

    //            merge([0,3])
    //            /        \
    //     merge([0,1])    merge([2,3])
    //      /    \          /    \
    //    [0]    [1]       [2]    [3]
    // **不断对半拆分成左右两组**，分别合并左右两组，最后把左右合并的结果再用`merge`函数合并
    public ListNode divideMerge(ArrayList<ListNode> lists, int left, int right) {
        // 左边界大于右边界 → 区间没有链表，返回空链表。
        if(left > right)
            return null;
            // 区间只有**1 个链表（left 和 right 相等）**，不用合并
        else if (left == right)
            return lists.get(left);

        int mid = (left +right) / 2;
        return merge(divideMerge(lists,left,mid),divideMerge(lists, mid + 1, right));
    }

    public ListNode mergeKLists (ArrayList<ListNode> lists) {
        return divideMerge(lists, 0 , lists.size() - 1);
    }



    public class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int val) {
            this.val = val;
        }
    }
}
