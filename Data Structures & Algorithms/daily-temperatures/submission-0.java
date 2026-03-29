class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int currentTemp = temperatures[i];

            while (!stack.isEmpty() && temperatures[stack.peek()] < currentTemp) {
                int oldIndex = stack.pop();
                temperatures[oldIndex] = i - oldIndex;
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            temperatures[stack.pop()] = 0;
        }

        return temperatures;
    }
}
