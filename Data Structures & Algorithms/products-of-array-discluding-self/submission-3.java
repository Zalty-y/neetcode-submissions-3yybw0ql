class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] post = new int[n];
        
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                pre[i] = 1;
                post[n-1] = 1;
                continue;
            }
            
            pre[i] = pre[i-1] * nums[i-1];
            post[n-1-i] = post[n-i] * nums[n-i];
        }
        
        for (int i = 0; i < n; i++) {
            pre[i] *= post[i];
        }

        return pre;
    }
}  
