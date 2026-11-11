class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] postfix = new int[n];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                prefix[i] = 1;
                postfix[n-1] = 1;
                continue;
            }
            prefix[i] = prefix[i-1] * nums[i-1];
            postfix[n-i-1] = postfix[n-i] * nums[n-i];
        }

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = prefix[i] * postfix[i];
        }

        return answer;
    }
}
