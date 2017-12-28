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
        if ( nums == null || nums.length == 0)// if the array is null or empty return null
            return null;
        TreeNode head = doStuff(nums, 0, nums.length-1);// implement the recursive helper method; 
        return head;
    }
    
    public TreeNode doStuff(int[] nums, int min, int max ){
        
        if (min > max)
            return null;
        /**
        * use divide and conquer; split the array by 2 and declare the middle the root node. Use the TreeNode definition
        * to declare the left and right child. redefine the min and max parameter based on the definition of a binary tree.
        * definition: left child < parent < right child
        */
        int mid = (min + max) / 2; 
        TreeNode head = new TreeNode(nums[mid]);
        head.left = doStuff(nums , min, mid-1);
        head.right = doStuff(nums, mid+1, max);
        return head;
        
    }
}
