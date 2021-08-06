package org.vinuvicho.leetcode.easy;

import org.vinuvicho.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTravesal {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) return calculate(root, new ArrayList<>());
        else return new ArrayList<>();
    }
    public List<Integer> calculate(TreeNode node, List<Integer> list) {
        if (node.left != null) calculate(node.left, list);
        list.add(node.val);
        if (node.right != null) calculate(node.right, list);
        return list;
    }
}
