package com.turbo.test.javaoffer;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * <p>
 * 二叉树的定义：
 * 二叉树：二叉树(binary tree)t是有限个元素的集合（可以为空）。当二叉树非空时，其中有一个称为根的元素，余下的元素（如果有的话）被组成2个二叉树，
 * 分别称为t的左子树和右子树。
 * <p>
 * 二叉树的特性
 * 特性1： 包含n(n>0)个元素的二叉树边数是n-1。
 * 特性2： 若二叉树的高度为h,h≥0,则该二叉树最少有h个元素，最多有2h−1个元素。
 * 特性3： 包含n个元素的二叉树的高度最大是n，最小是⌈log2(n+1)⌉。
 * 特性4： 设完全二叉树中一元素的序号是i，1≤i≤n。则有以下关系成立：
 * 1) 当i=1时，该元素为二叉树的根，若i>1,则该元素父节点的编号是⌊i/2⌋。
 * 2) 当2i>n时，该元素没有左子树，否则，其左子树的编号是2i。
 * 3) 若2i+1>n时，该元素没有右子树，否则，其右子树的编号是2i+1。
 */
public class No4 {
    public static void main(String[] args) {
        Integer[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        Integer[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        //由pre可知，1是根节点，再看in，4,7,2是左子树，5,3,8,6是右子树
        //由pre可知，2是根节点，再看in，4,7是左子树，没有右子树
        //由pre可知，4是根节点，没有左子树，7,是右子树
        //由pre可知，3是根节点，再看in，5是左子树，8,6是右子树
        //由pre可知，6是根节点，再看in，8是左子树，没有右子树
        System.out.println(reConstructBinaryTree(pre, in));
    }

    public static TreeNode reConstructBinaryTree(Integer[] pre, Integer[] in) {
        if (pre.length == 0 || in.length == 0) return null;
        if(pre.length==1 || in.length == 0)return new TreeNode(pre[0]);
        TreeNode treeNode = new TreeNode(pre[0]);
        Integer[] newPre = new Integer[pre.length];
        Integer[] newIn = new Integer[in.length];
        for (int i = 0; i < pre.length; i++) {
            newPre[i] = Integer.valueOf(pre[i]);
        }
        for (int i = 0; i < in.length; i++) {
            newIn[i] = Integer.valueOf(in[i]);
        }
        List<Integer> newPreList = Arrays.asList(newPre);
        List<Integer> newInList = Arrays.asList(newIn);
        List<Integer> newInListLeft = newInList.subList(0, newInList.indexOf(pre[0]));
        List<Integer> newInListRight = newInList.subList(newInList.indexOf(pre[0]), newInList.size());


        List<Integer> newPreListLeft = newPreList.subList(1, newInListLeft.size() + 1);
        List<Integer> newPreListRight = newPreList.subList(newInListLeft.size() + 1, newPreList.size());


        Integer[] preResult = new Integer[newPreListLeft.size()], inResult = new Integer[newInListLeft.size()];
        newPreListLeft.toArray(preResult);
        newInListLeft.toArray(inResult);
        treeNode.left = reConstructBinaryTree(preResult, inResult);//pre即为{2, 4, 7} in即为{4, 7, 2}

        Integer[] preResult2 = new Integer[newPreListRight.size()], inResult2 = new Integer[newInListRight.size()];
        newPreListRight.toArray(preResult2);
        newInListRight.toArray(inResult2);
        treeNode.right = reConstructBinaryTree(preResult2, inResult2);;//pre即为{3, 5, 6, 8} in即为{5, 3, 8, 6}
        return treeNode;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
