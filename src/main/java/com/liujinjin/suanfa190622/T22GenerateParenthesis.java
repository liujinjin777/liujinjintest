package com.liujinjin.suanfa190622;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * 22，生成括号
 *
 *  例如，给出 n = 3，生成结果为：
 *  [
        "((()))",
        "(()())",
        "(())()",
        "()(())",
        "()()()"
    ]
 *
 *  思路：使用递归，下一步可能添加"(" 或者 ")"，
 *  当剩余 ( 的数量大于 ） 的数量时，不满足条件，return。
 *
 * @author liuxin
 * @date 2019/6/22
 */
public class T22GenerateParenthesis {

    @Test
    public void test(){
        int n = 3;
        List<String> list = Lists.newArrayList();
        this.generate(n, n, "", list);
        System.out.println(list);
    }

    private void generate(int left, int right, String s, List<String> list){
        if (left < 0 || right < 0 || left > right) {
            return;
        }

        if(left == 0 && right == 0){
            list.add(s);
            return;
        }

        this.generate(left-1, right, s+"(", list);
        this.generate(left, right-1, s+")", list);
    }

    @Test
    public void test2(){
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6);
        this.forPrint(list, list.size()-1);
    }

    public void forPrint(List<Integer> list, Integer size){
        if(size < 0){
            return;
        }

        System.out.println(list.get(size));
        this.forPrint(list, --size);
    }
}










