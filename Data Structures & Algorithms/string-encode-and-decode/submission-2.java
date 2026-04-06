class Solution {
    private String nullString = "null";
    private String empty = "";
    private char separator = '#';

    public String encode(List<String> strs) {
        if (strs == null || strs.isEmpty()) {
            return nullString;
        } 

        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(str.length()).append(separator).append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList();

        if (str.equals(nullString)) {
            return result;
        }

        int left = 0;
        int right = 0;

        while (right < str.length()) {
            if (str.charAt(right) != separator) {
                right++;
                continue;
            }

            int length = Integer.parseInt(str.substring(left, right));
            right++;

            String substring = str.substring(right, right + length);
            result.add(substring);

            right += length;
            left = right;
        }

        return result;
    }
}
