class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int preProduct = 1;
        int postProduct = 1;
        int[] answer = new int[n];

        Arrays.fill(answer, 1);

        for (int i = 0; i < n; i++) {
            answer[i] *= preProduct;
            answer[n-1-i] *= postProduct;
            preProduct *= nums[i];
            postProduct *= nums[n-1-i];
        }

        return answer;
    }
}  
