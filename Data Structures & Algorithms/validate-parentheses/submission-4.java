class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')','(');
        pairs.put('}','{');
        pairs.put(']','[');

        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if (!pairs.keySet().contains(c)) {
                stack.push(c);
                continue;
            }

            if (stack.empty()) {
                return false;
            }

            char opening = stack.pop();
            if (opening != pairs.get(c)) {
                return false;
            }
        }

        return stack.empty();
    }
}
