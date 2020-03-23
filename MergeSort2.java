import java.util.Arrays;

public class MergeSort2 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode t = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(t);

        ListNode h = new ListNode(0);
        ListNode r = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        if (left == null) {
            h.next = right;
        } else {
            h.next = left;
        }
        return r.next;
    }

}

