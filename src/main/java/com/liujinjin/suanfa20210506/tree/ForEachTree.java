package com.liujinjin.suanfa20210506.tree;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

import com.liujinjin.suanfa20210506.base.TreeNode;

/**
 *
 * @author liuxin14 <liuxin14@kuaishou.com>
 * Created on 2021-05-05
 */
public class ForEachTree {

    @Test
    public void forEach() {
        //  1
        // 2 3
        //45 67
        TreeNode treeNode = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4, null, null),
                        new TreeNode(5, null, null)),
                new TreeNode(3,
                        new TreeNode(6, null, null),
                        new TreeNode(7, null, null)));
        System.out.println(treeNode);

        // zForEach(treeNode);
        rootLeftRight(treeNode);
    }

    public void zForEach(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        List<TreeNode> list = new ArrayList<>();
        list.add(treeNode);

        while (true) {
            // 每一层的节点集合
            List<TreeNode> levelList = new ArrayList<>();
            for (TreeNode node : list) {
                System.out.println(node.val);
                if (node.left != null) {
                    levelList.add(node.left);
                }
                if (node.right != null) {
                    levelList.add(node.right);
                }
            }
            if (CollectionUtils.isEmpty(levelList)) {
                break;
            }
            list = levelList;
        }
    }

    public void rootLeftRight(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        rootLeftRight(treeNode.left);
        rootLeftRight(treeNode.right);
        System.out.println(treeNode.val);
    }

}
