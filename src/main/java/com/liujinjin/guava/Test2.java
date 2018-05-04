package com.liujinjin.guava;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multiset;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author liuxin
 * @date 2017/12/21
 */
public class Test2 {

    public static void main(String[] args) {
        List<String> words = Lists.newArrayList("a", "a", "b", "c");
        Map<String, Integer> counts = Maps.newHashMap();
        for (String word : words) {
            Integer count = counts.get(word);
            if (count == null) {
                counts.put(word, 1);
            } else {
                counts.put(word, count + 1);
            }
        }
        System.out.println(counts);

        Multiset<String> multiset = HashMultiset.create();
        for(String word : words){
            multiset.add(word);
        }
        System.out.println(multiset);
        System.out.println(multiset.size());
        System.out.println(multiset.count("a"));
        System.out.println(multiset.elementSet());
        multiset.setCount("a", 2, 4);
        multiset.setCount("a", 4, 8);
        multiset.setCount("a", 1);
        for (Multiset.Entry<String> set : multiset.entrySet()) {
            System.out.println("key:" + set.getElement() + "     count:" + set.getCount());
        }

        Iterator<String> iterator = multiset.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("size=" + multiset.size());

    }

}
