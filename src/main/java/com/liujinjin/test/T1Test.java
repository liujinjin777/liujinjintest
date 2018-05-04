package com.liujinjin.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.google.common.collect.*;
import com.liujinjin.java8.methodReference.People;
import com.liujinjin.java8.methodReference.Son;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liuxin
 * @date 2018/1/7
 */
public class T1Test {

    @Test
    public void testStreamClose1() throws Exception {
        FileOutputStream fos = new FileOutputStream("d:\\a.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
        BufferedWriter bw = new BufferedWriter(osw);
        bw.write("java IO close test");

        //从内带外顺序顺序会报异常
        fos.close();
        osw.close();
        bw.close();
    }

    @Test
    public void testStreamClose2() throws Exception {
        FileOutputStream fos = new FileOutputStream("d:\\a.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
        BufferedWriter bw = new BufferedWriter(osw);
        bw.write("java IO close test  ");

        // 从外到内关闭
        bw.close();
        osw.close();
        fos.close();
    }

    @Test
    public void testStreamClose3() throws Exception {
        FileOutputStream fos = new FileOutputStream("d:\\a.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
        BufferedWriter bw = new BufferedWriter(osw);
        bw.write("java IO close test");

        bw.close();
    }

    @Test
    public void testPriority(){
        boolean a = true;
        boolean b = true;
        boolean c = true;
        boolean d = false;


        if(a && b || c && d){
            System.out.println("1111");
        }

        if(a && b || (c && d)){
            System.out.println("22222");
        }
    }

    @Test
    public void testContains(){
        List<Long> longs = Lists.newArrayList(1L, 2L);
        if(longs.contains(1)){
            System.out.println("111");
        }
    }

    @Test
    public void testStatic(){
        System.out.println(TTTStatic.a);
        Long ssss = Long.parseLong("777");
        System.out.println(ssss);
    }

    @Test
    public void testMapJson(){
        Map<String, String> map = Maps.newHashMap();
        map.put("1", "2");
        map.put("3", "4");
        System.out.println(JSON.toJSONString(map));

        String json = JSON.toJSONString(map);
        Map<String, String> map2 = JSON.parseObject(json, new TypeReference<Map<String, String>>(){});
        for(String object : map2.keySet()){
            System.out.println(object + " " + map2.get(object));
        }

    }

    @Test
    public void testCopy(){
        Son son = new Son();

    }

    @Test
    public void testForTrans(){
        List<Long> list = Lists.newArrayList(1L, 2L, 3L);
        List<Integer> newList = list.stream().map(n -> n.intValue()).collect(Collectors.toList());
        for(Integer i : newList){
            System.out.println(i);
        }

        Long i = 1L;
        Integer int1 = i.intValue();
        Integer int2 = i.intValue();
        Long i2 = 128L;
        Integer int3 = i2.intValue();
        Integer int4 = i2.intValue();
        System.out.println(int1 == int2);
        System.out.println(int3 == int4);
    }

    @Test
    public void testSplit(){
        String s = "13";
        String[] split = s.split(";");
        System.out.println(JSON.toJSONString(split));
    }

    @Test
    public void testList(){
        List<String> objects = Lists.newArrayList("a");
        list(objects);
        System.out.println(objects);
    }

    public void list(List<String> list){
        list = Lists.newArrayList("1111");
    }

    @Test
    public void testCalendar(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(weekDay);
    }

    @Test
    public void testStr(){
        String s = "浙江桐乡乌镇+乌村包车二日游【纯玩  免费接送  包车自由行】";
        System.out.println(s.indexOf("一日游"));
    }

    @Test
    public void testCopyOf(){
        Son son = new Son();
        son.setId("1");
        son.setName("2");
        Object obj = son;
        People target = new People();

        BeanUtils.copyProperties(obj, target);
        System.out.println(JSON.toJSONString(target));
    }

    @Test
    public void testDate(){
        String pattern = "yyyyMMdd0HH";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.US);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 3);
        String format = sdf.format(calendar.getTime());
        System.out.println(format);
    }

    @Test
    public void testMap(){
        Multimap<Object, String> multimap = ArrayListMultimap.create();
        multimap.put(3344, "1");
        multimap.put(3344, "2");

        for(Object key : multimap.keySet()){
            System.out.println(key);
        }
    }

    @Test
    public void testTable(){
        HashBasedTable<Object, Object, Object> table = HashBasedTable.create();
        table.put("1", "2", "a");
        table.put("1", "2", "a");
        table.put("1", "2", "a");
        table.put("1", "2", "a");
        table.put("1", "2", "a");
        table.put("1", "3", "a");
        table.put("2", "3", "a");
        System.out.println(table);
        System.out.println(table.size());
        System.out.println(table.columnMap());
        System.out.println(table.rowMap());
        Map<Object, Map<Object, Object>> objectMapMap = table.rowMap();
    }

    @Test
    public void testListsPart(){
        List<Integer> list = Lists.newArrayList(1, 2, 3);
        List<List<Integer>> partition = Lists.partition(list, 4);
        System.out.println(JSON.toJSONString(partition) + "   " + partition.size());
    }
    @Test
    public void testListsPart1(){
        List<Long> allPoiList = Lists.newArrayList();
        List<Long> savedPoiList = Lists.newArrayList(2L);
        Collection<Long> diffPoiList = CollectionUtils.subtract(allPoiList, savedPoiList);
        System.out.println(diffPoiList);
    }

    @Test
    public void testMultiMap(){
        HashMultimap<Integer, Integer> map = HashMultimap.create();
        map.put(1, 1);
        map.put(1, 1);
        map.put(2, 1);
        map.put(2, 1);
        map.put(3, 1);
        map.put(3, 2);


        System.out.println(JSON.toJSONString(map));
        System.out.println(JSON.toJSONString(map.values()));
        System.out.println(map.values().size());
        System.out.println(map.keys().size());
        System.out.println(map.keySet().size());
        System.out.println(Sets.newHashSet(map.values()));

        System.out.println("----------");
        ArrayListMultimap<Integer, Integer> listMap = ArrayListMultimap.create();
        listMap.put(1, 1);
        listMap.put(1, 1);
        listMap.put(2, 1);
        listMap.put(2, 1);
        listMap.put(3, 1);
        listMap.put(3, 2);


        System.out.println(JSON.toJSONString(listMap));
        System.out.println(JSON.toJSONString(listMap.values()));
        System.out.println(listMap.values().size());
        System.out.println(listMap.keys().size());
        System.out.println(listMap.keySet().size());
        System.out.println(Sets.newHashSet(listMap.values()));
    }

    @Test
    public void t1() throws InterruptedException {
        List<Student> list = Lists.newArrayList();
        while(true) {
            list.add(new Student());
            System.out.println(1);
        }
    }

    @Test
    public void t2(){
        System.out.println(2);
    }


    private class Student{
        private String name = "事实似乎丝毫似是杀死后四十回";
        private String name1 = "事实似乎丝毫似是杀死后四十回";
        private String name2  = "事实似乎丝毫似是杀死后四十回";
        private String name3 = "事实似乎丝毫似是杀死后四十回";
        private String name4 = "事实似乎丝毫似是杀死后四十回";
        private String name5 = "事实似乎丝毫似是杀死后四十回";
    }
}
