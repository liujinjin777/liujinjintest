package com.liujinjin.suanfa.array;

import java.util.*;

/**
 * 求数组中所有数的组合
 *
 * 1, 3, 5
 * 1, 3, 5, 13, 15, 35, 135
 *
 * Created by liuxin on 17/2/9.
 */
public class PrintAllCombination {


    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("3");
        list.add("5");
        listAll(list," ");
    }

    /**
     * 思想:
     *    1     for(int i=0; i<3; i++)              list=1,2,3
     *          sout(p + list[i])                   // p=""+1
     *    2         for(int j=0; j<3; j++)          list=2,3
     *              sout(p + list[i])           // p=" 1"+2;
     *    3             for
     *
     *
     *
     *
     *
     */
    public static void listAll(List<String> candidate, String prefix){
        System.out.println(prefix);

        for(int i=0; i<candidate.size(); i++){
            List<String> temp = new LinkedList<String>(candidate);
            listAll(temp, prefix+removePre(temp, i));
        }
    }

    /**
     * 删除i之前元素 (包括i)
     *
     * @return
     */
    private static String removePre(List<String> list, int n){
        String s = list.get(n);
        for(Iterator<String> i = list.iterator(); i.hasNext() && n >= 0; n--){
            i.next();
            i.remove();
        }
        return s;
    }





}
