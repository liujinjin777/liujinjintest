package com.liujinjin.suanfa191229;

import lombok.ToString;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author liuxin23
 * @date 2019/12/29
 */
public class T4 {

    @Test
    public void test(){
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode treeNode = this.reConstructBinaryTree(pre, in);
        System.out.println(treeNode);
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length == 0 || in.length == 0){
            return null;
        }

        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if(in[i] == pre[0]){
                root.left = reConstructBinaryTree(this.copyOfRange(pre, 1, i+1), this.copyOfRange(in, 0, i));
                root.right = reConstructBinaryTree(this.copyOfRange(pre, i+1, pre.length), this.copyOfRange(in, i+1, in.length));
                break;
            }
        }

        return root;
    }

    public int[] copyOfRange(int[] array, int start, int end){
        int newLength = end - start;
        int[] copy = new int[newLength];
        int point = 0;
        for(int i = start; i < end; i++){
            copy[point++] = array[i];
        }
        return copy;
    }

    @ToString
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }


  }
}
