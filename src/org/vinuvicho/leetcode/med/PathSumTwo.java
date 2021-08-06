package org.vinuvicho.leetcode.med;

import org.vinuvicho.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumTwo {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) calculate(result, root, (short) 0, (short) targetSum, new ArrayList<>());
        return result;
    }
    public void calculate(List<List<Integer>> result, TreeNode node, short val, short target, List<Integer> sum) {
        val += node.val;
        sum.add(node.val);
        if (node.left != null) calculate(result, node.left, val, target, new ArrayList<>(sum));
        if (node.right != null) calculate(result, node.right, val, target, new ArrayList<>(sum));
        else if (node.left == null && val == target)  result.add(sum);
    }
}
