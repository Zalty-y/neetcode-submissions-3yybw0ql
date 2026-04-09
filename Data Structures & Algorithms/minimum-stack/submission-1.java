class MinStack {
    private class StackNode {
        public int val;
        public int min;
        public StackNode next;

        public StackNode(int val, int min, StackNode next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    private StackNode head;

    public MinStack() {
    }
    
    public void push(int val) {
        if (head == null) {
            head = new StackNode(val, val, null);
            return;
        }

        StackNode temp = new StackNode(val, Math.min(head.min, val), head);
        head = temp;
    }
    
    public void pop() {
        if (head == null) {
            return;
        }

        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
}
