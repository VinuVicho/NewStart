package org.vinuvicho.leetcode.med;

import org.vinuvicho.leetcode.Node;

import java.util.ArrayList;
import java.util.List;

public class TreeLevelOrderTraversal {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> test = new ArrayList<>();
        test.add(new ArrayList<>());
        System.out.println(test.get(0).add(1));
    }
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        calculate(result, root, 0);
        return result;
    }
    void calculate(List<List<Integer>> result, Node node, int a) {
        System.out.println(result);
        if (result.size() > a) result.get(a).add(node.val);
        else {
            ArrayList<Integer> line = new ArrayList<>();
            line.add(node.val);
        }
        for (int i = 0; i < node.children.size(); i++) {
            calculate(result, node.children.get(i), a+1);
        }
    }
}
