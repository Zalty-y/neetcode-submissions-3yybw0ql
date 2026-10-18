class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        char offset = 'a';
        Map<String, List<String>> anagramMap = new HashMap<String, List<String>>();

        for (String str : strs) {
            char[] letters = new char[26];
            
            for (char c : str.toCharArray()) {
                letters[c - offset]++;
            }

            StringBuilder anagramCode = new StringBuilder("");
            for (int count : letters) {
                anagramCode.append(count);
                anagramCode.append('.');
            }

            String anagramCodeString = anagramCode.toString();
            anagramMap.computeIfAbsent(anagramCodeString, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList(anagramMap.values());
    }
}
