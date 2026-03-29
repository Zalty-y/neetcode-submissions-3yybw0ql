class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencies = new HashMap<>();

        for (int num : nums) {
            frequencies.putIfAbsent(num, 0);
            frequencies.put(num, frequencies.get(num) + 1);
        }

        Queue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> Integer.compare(a.getValue(), b.getValue()));

        for (Map.Entry<Integer, Integer> pair : frequencies.entrySet()) {
            heap.offer(pair);

            if (k < heap.size()) {
                heap.poll();
            }
        }

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = heap.poll().getKey();
        }

        return result;
    }
}
