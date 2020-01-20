package com.liujinjin.book.codingInterviews.t6222222;

import com.liujinjin.suanfa.common.BinaryTree;
import com.liujinjin.suanfa.common.MyArrayStack;

/**
 * Created by liuxin on 17/2/13.
 */
public class For {


    public static void main(String[] args) {
        /**
         *      1
         *    2   3
         *   4 5 6 7
         */
        BinaryTree binaryTree = new BinaryTree(1,
                new BinaryTree(2, new BinaryTree(4, null, null), new BinaryTree(5, null, null)),
                new BinaryTree(3, new BinaryTree(6, null, null), new BinaryTree(7, null, null)));
        System.out.println(binaryTree);

        /*  //先序遍历测试
        preorder(binaryTree);
        System.out.println();
        preorder0(binaryTree);
        */

        /*  // 中序遍历测试
        infixOrder(binaryTree);
        System.out.println();
        infixOrder0(binaryTree);
        */

        // 后序遍历测试
        postorder(binaryTree);

    }

    // 深度遍历
    public static void deeporder(BinaryTree root){

    }

    // 后序遍历-递归
    public static void postorder(BinaryTree root) {
        if (root != null) {
            postorder(root.leftChildNode);
            postorder(root.rightChildNode);
            System.out.print(root.value + " ");
        }
    }

    // 中序遍历-非递归
    public static void infixOrder0(BinaryTree root) {
        if (root == null) return;

        BinaryTree currentNode = root;
        MyArrayStack<BinaryTree> myArrayStack = new MyArrayStack<BinaryTree>();

        while (currentNode != null || myArrayStack.isNotEmpty()) {
            while (currentNode != null) {
                myArrayStack.push(currentNode);
                currentNode = currentNode.leftChildNode;
            }

            if (myArrayStack.isNotEmpty()) {
                currentNode = myArrayStack.pop();
                System.out.println(currentNode.value);
                currentNode = currentNode.rightChildNode;
            }
        }

    }

    // 中序遍历-递归
    public static void infixOrder(BinaryTree root) {
        if (root != null) {
            infixOrder(root.leftChildNode);
            System.out.print(root.value + "");
            infixOrder(root.rightChildNode);
        }
    }


    // 先序遍历-非递归
    public static void preorder0(BinaryTree root) {
        if (root == null) return;

        MyArrayStack<BinaryTree> arrayStack = new MyArrayStack<BinaryTree>();
        arrayStack.push(root);

        while (arrayStack.isNotEmpty()) {
            root = arrayStack.pop();
            System.out.print(root.value + " ");

            if (root.rightChildNode != null)
                arrayStack.push(root.rightChildNode);

            if (root.leftChildNode != null)
                arrayStack.push(root.leftChildNode);
        }
    }

    // 先序遍历-递归
    public static void preorder(BinaryTree root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preorder(root.leftChildNode);
            preorder(root.rightChildNode);
        }
    }


}







