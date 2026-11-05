class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for (String s : strs) {
            String anagramKey = getAnagramKey(s);
            groups.computeIfAbsent(anagramKey, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList(groups.values());
    }

    private String getAnagramKey(String s) {
        StringBuilder sb = new StringBuilder();
        int[] charCount = new int[26];
        int offset = 'a';

        for (char c : s.toCharArray()) {
            charCount[c - offset]++;
        }

        for (int i : charCount) {
            sb.append(i);
            sb.append('#');
        }

        return sb.toString();
    }
}
