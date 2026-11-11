class Solution {
    private static final String NULL = "null";
    private static final String EMPTY = "empty";
    private static final char SEP = '#';

    public String encode(List<String> strs) {
        if (strs == null) {
            return NULL;
        }
        if (strs.size() == 0) {
            return EMPTY;
        }

        StringBuilder builder = new StringBuilder();
        for (String str : strs) {
            builder.append(str.length());
            builder.append(SEP);
            builder.append(str);
        }

        return builder.toString();
    }

    public List<String> decode(String str) {
        if (str.equals(NULL)) {
            return null;
        }
        if (str.equals(EMPTY)) {
            return new ArrayList<>();
        }

        List<String> answer = new ArrayList<>();
        StringBuilder string = new StringBuilder();
        StringBuilder number = new StringBuilder();
        int length = -1;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (length > 0) {
                string.append(c);
                length--;
                continue;
            }
            if (length == 0) {
                answer.add(string.toString());
                length = -1;
                string = new StringBuilder();
            }
            if (c != SEP) {
                number.append(c);
                continue;
            }

            length = Integer.parseInt(number.toString());
            number = new StringBuilder();
        }

        answer.add(string.toString());
        return answer;
    }
}
