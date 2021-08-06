package org.vinuvicho.leetcode;

import java.util.List;

public class Node {
    public int val;
    public List<Node> children;
    public int n = 0;
    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
