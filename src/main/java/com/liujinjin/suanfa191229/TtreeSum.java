package com.liujinjin.suanfa191229;

import com.liujinjin.util.Node;
import org.junit.Test;

import java.awt.font.TextHitInfo;
import java.util.ArrayList;

/**
 * @author liuxin23
 * @date 2020/01/11
 */
public class TtreeSum {



    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if (root == null){
            return null;
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        this.find(root, target, result, path);
        return result;
    }


    private void find(TreeNode root, int target, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }

        path.add(root.val);
        target -= root.val;

        if(target < 0){
            return;
        }

        if(target == 0 && root.left == null && root.right == null){
            result.add(0, path);
            return;
        }

        this.find(root.left, target, result, new ArrayList<>(path));
        this.find(root.right, target, result, new ArrayList<>(path));
    }

    /**
     * 从下打印所有节点的高度
     */
    public boolean printNodeHigh(TreeNode root){
        if(root == null){
            return true;
        }

        return this.printNodeHigh2(root) != -1;
    }

    private int printNodeHigh2(TreeNode node){
        if(node == null){
            return 0;
        }

        int leftI = this.printNodeHigh2(node.left);
        int rightI = this.printNodeHigh2(node.right);
        if(leftI == -1 || rightI == -1 || leftI - rightI > 1){
            return -1;
        }

        int height = Math.max(leftI, rightI) + 1;
        System.out.println("node="+node.val + ", height=" + height);
        return height;

    }

    /**
     *      10
     *   12    5
     *  3    7
     * 2
     */
    @Test
    public void test() {
        TreeNode t10 = new TreeNode(10);
        TreeNode t5 = new TreeNode(5);
        TreeNode t12 = new TreeNode(12);
        TreeNode t7 = new TreeNode(7);
        TreeNode t3 = new TreeNode(3);
        TreeNode t2 = new TreeNode(2);

        t10.left = t12;
        t10.right = t5;
        t5.right = t7;
        t12.left = t3;
        t3.left = t2;
        print(t10);
        System.out.println("-----华丽丽的分割线------");
        System.out.println(this.printNodeHigh(t10));
    }

    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }


    public void print(TreeNode root){
        if(root == null){
            return;
        }
        this.print(root.left);
        System.out.println(root.val);
        this.print(root.right);
    }
}
