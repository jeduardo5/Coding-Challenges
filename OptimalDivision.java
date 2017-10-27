class Solution {
    public String optimalDivision(int[] nums) {
       StringBuilder build = new StringBuilder();
        build.append(nums[0]);
        if (nums.length == 1){
           return build.toString();
       }
        if(nums.length == 2){
            return build.append("/" + nums[1]).toString();
        }
        if (nums.length > 2){
            int index = 1;
            build.append("/(" + nums[index]);
            index++;
            while (index < nums.length){
                build.append("/").append(nums[index]);
                index++;
            }
            return build.append(")").toString();
        }
        return build.toString();
}
}
