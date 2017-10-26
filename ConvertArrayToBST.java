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
    public TreeNode sortedArrayToBST(int[] nums) {
        if ( nums == null || nums.length == 0)
            return null;
        TreeNode head = doStuff(nums, 0, nums.length-1);
        return head;
    }
    
    public TreeNode doStuff(int[] nums, int min, int max ){
        
        if (min > max)
            return null;
        
        int mid = (min + max) / 2;
        TreeNode head = new TreeNode(nums[mid]);
        head.left = doStuff(nums , min, mid-1);
        head.right = doStuff(nums, mid+1, max);
        return head;
        
    }
}
