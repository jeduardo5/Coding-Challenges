/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        return doStuff(head, null);
    }
    
    public TreeNode doStuff(ListNode head, ListNode tail){
        if(head == tail)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast!=tail && fast.next!=tail){
            slow = slow.next;   //traverse 1 node at a time
            fast = fast.next.next;   //traverse 2 nodes at a time
        }
            TreeNode treeHead = new TreeNode(slow.val); //should be at the halfway point of the List
            treeHead.left = doStuff(head,slow);
            treeHead.right= doStuff(slow.next, tail);
            return treeHead;
        }
    }
