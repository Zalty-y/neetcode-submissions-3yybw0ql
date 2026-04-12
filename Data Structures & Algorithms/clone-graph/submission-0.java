/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> oldToCopy = new HashMap<>();
        return dfs(node, oldToCopy);
    }

    private Node dfs(Node node, Map<Node, Node> oldToCopy) {
        if (node == null) {
            return null;
        }
        if (oldToCopy.containsKey(node)) {
            return oldToCopy.get(node);
        }

        Node copy = new Node(node.val);
        oldToCopy.put(node, copy);

        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(dfs(neighbor, oldToCopy));
        }

        return copy;
    }
}