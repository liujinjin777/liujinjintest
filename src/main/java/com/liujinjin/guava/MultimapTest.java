package com.liujinjin.guava;

import com.google.common.base.Optional;
import com.google.common.collect.*;
import com.liujinjin.java8.methodReference.People;

import java.util.Collection;
import java.util.Set;

/**
 * @author liuxin
 * @date 2017/12/24
 */
public class MultimapTest {

    public static void main(String[] args) {
        // testBitMap();

        // testMultiMap();

        // testTable();

        testSets();
    }

    private static void testUtil(){
        Lists.newArrayList();
        Sets.newHashSet();
        Maps.newHashMap();
    }

    private static void testSets(){

        Set<String> s1 = Sets.newHashSet("1", "2", "3");
        Set<String> s2 = Sets.newHashSet("2", "3", "4");
        System.out.println(Sets.difference(s1, s2));
        System.out.println(Sets.symmetricDifference(s1, s2));
        System.out.println(Sets.intersection(s1, s2));
        System.out.println(Sets.union(s1, s2));
    }

    private static void testImmutableMap() {
        ImmutableMap<String, Object> of = ImmutableMap.of();
        of.asMultimap();
    }

    private static void testTable() {
        HashBasedTable<Integer, Integer, Integer> table = HashBasedTable.create();
        table.put(1, 1, 1);
        table.put(1, 2, 2);
        table.put(1, 2, 2);
        table.put(1, 3, 3);
        table.put(1, 4, 4);
        table.put(1, 5, 5);
        System.out.println(table);
        System.out.println(table.get(1, 2));
        System.out.println(table.row(1));
    }

    private static void testMultiMap() {
        Multimap<String, People> customersByType = ArrayListMultimap.create();
        customersByType.put("abc", new People("1", "1"));
        customersByType.put("abc", new People("1", "1"));
        customersByType.put("abc", new People("1", "1"));
        customersByType.put("abc", new People("1", "1"));
        Collection<People> abc = customersByType.get("abc");
        System.out.println(abc);
    }

    private static void testOptional() {
        Optional<String> absent = Optional.absent();
        absent.asSet();
    }


    private static void testBitMap() {
        //双向map
        BiMap<Integer, String> biMap = HashBiMap.create();

        biMap.put(1, "hello");
        biMap.put(2, "helloa");
        biMap.put(3, "world");
        biMap.put(4, "worldb");
        biMap.put(6, "myc");
        biMap.forcePut(7, "my");
        biMap.forcePut(5, "my");


        int value = biMap.inverse().get("my");
        System.out.println("inverse.inverse"+biMap.inverse().inverse());
        System.out.println("my --" + value);

    }
}
