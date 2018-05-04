package com.liujinjin.guava;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.liujinjin.java8.methodReference.People;

import java.util.Set;

/**
 * @author liuxin
 * @date 2017/12/18
 */
public class TestImmutable {

    public static final ImmutableSet<String> Color_names =
            ImmutableSet.of("red", "orange", "yellow");

    public static void main(String[] args) {
        ImmutableSet<Integer> integers = ImmutableSet.copyOf(Sets.newHashSet(1));
        Set<Integer> integers1 = ImmutableSet.copyOf(Sets.newHashSet(1));


        ImmutableSet<Integer> copyOf = ImmutableSet.copyOf(Sets.newHashSet(1));
        ImmutableSet<Integer> of = ImmutableSet.of(1);
        ImmutableSet.Builder<Integer> builder = ImmutableSet.<Integer>builder().add(1).addAll(Sets.newHashSet(1, 2));


        ImmutableSet<People> copyOfPeople = ImmutableSet.copyOf(Sets.newHashSet(new People("1", "name")));
        System.out.println(copyOfPeople.asList().get(0));
        for(People p : copyOfPeople){
            p.setName("111");
            System.out.println(p);
        }
        copyOfPeople.asList();
    }

    class foo{
        Set<People> bars;
        foo(Set<People> bars){
            this.bars = ImmutableSet.copyOf(bars);
        }
    }
}
