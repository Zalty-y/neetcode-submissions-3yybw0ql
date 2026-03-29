class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for (String str : strs) {
            int[] charCount = new int[26];
            char offset = 'a';

            for (char c : str.toCharArray()) {
                charCount[c - offset]++;
            }

            String key = Arrays.toString(charCount);

            groups.putIfAbsent(key, new ArrayList<>());
            groups.get(key).add(str);
        }
        
        return new ArrayList<>(groups.values());
    }
}
