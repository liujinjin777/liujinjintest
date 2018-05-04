package com.liujinjin.guava;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import com.google.common.collect.Sets;
import com.liujinjin.java8.methodReference.People;

import java.util.Comparator;
import java.util.Set;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author liuxin
 * @date 2017/12/21
 */
public class Test1 {

    public static void main(String[] args) {
        Objects.equal(1,2);
        Objects.hashCode(1);  //return Arrays.hashCode(objects);
        /*List<Integer> list = Lists.newArrayList();
        list.add(null);
        list.add(1);

        System.out.println(list);

        Integer i = null;*/
        /*Integer optional = Optional.ofNullable(i).orElse(2);
        Integer optional0 = Optional.of(i).orElse(2);
        System.out.println(optional);*/

        //Objects.requireNonNull(i, "i is null");

        Object obj = null;
        //Preconditions.checkArgument(true);
        Object o = checkNotNull(obj, "场景信息");
        System.out.println(o);
        java.util.Objects objects;
        com.google.common.base.Objects Objects;

        /*Ordering.natural();
        MyCompare myCompare = new MyCompare();
        myCompare.reverse();

        Ordering.natural().nullsFirst().onResultOf((Function<Object, Comparable>) input -> input);*/

        /*try {
            //int i = 1/0;
            throw new NullPointerException();
        } catch (Exception e){
            Throwables.propagateIfInstanceOf(e, ArithmeticException.class);
            //Throwables.propagateIfInstanceOf(e, Error.class);
            Throwables.propagate(e);
        }

        ImmutableList<Integer> builder = ImmutableList.<Integer>builder().add(1).build();
        ImmutableList<Integer> integers = builder.asList();
        Integer integer = builder.get(0);
        Integer integer1 = integers.get(0);*/

        /*List<Integer> list = Lists.newArrayList(1,2,3,4);
        Collections.reverse(list);
        System.out.println(list);
        List<Integer> reverse = Lists.reverse(list);
        System.out.println(reverse + "  " +list);

        HashSet<Object> objects = Sets.newHashSet();
        Sets.immutableEnumSet(objects);*/


        Optional<Integer> possible = Optional.of(5);
        possible.isPresent(); // return true
        Integer integer = possible.get();// return 5
        System.out.println(integer);

        possible.isPresent();
        possible.get();
        possible.or(6);
        possible.orNull();

        Set<Integer> integers = possible.asSet();




        Ordering.natural();
        Ordering.usingToString();
        Ordering.from(new Comparator<Object>(){
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });

        Ordering<Foo> ordering = Ordering.natural().nullsFirst().onResultOf(
                new Function<Foo, String>() {
                            @Override
                            public String apply(Foo foo) {
                                return foo.sortedBy;
                            }
                        });



        ImmutableList<People> copyOfPeople = ImmutableList.copyOf(Sets.newHashSet(new People("1", "name")));
        ImmutableList<People> peoples = copyOfPeople.asList();
        copyOfPeople.get(0);
        peoples.get(0);

        /*ImmutableSet<People> copyOfPeople1 = ImmutableSet.copyOf(Sets.newHashSet(new People("1", "name")));
        ImmutableList<People> peoples1 = copyOfPeople.asList();
        copyOfPeople1.get(0);  // error
        peoples1.get(0);*/


    }

    class Foo{
        String sortedBy;
        int notSortedBy;
    }


    static class MyCompare extends Ordering<String>{

        @Override
        public int compare(String left, String right) {
            return left.length() - right.length();
        }
    }
}
