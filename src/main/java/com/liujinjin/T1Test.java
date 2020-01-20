package com.liujinjin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.liujinjin.java8.methodReference.People;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @author liuxin
 * @date 2018/1/7
 */
public class T1Test {

    int a = -1;
    double b = 0;

    class CustomThreadFactory implements ThreadFactory {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread("CUSTOM_NAME_PREFIX");
            return thread;
        }
    }

    @Test
    public void t191101(){
        Integer a = null;
        List<Object> objects = Lists.newArrayList(a);

        List<People> list = Lists.newArrayList();
        list.add(new People(null, "1"));
        //list.add(new People("2", null));


        Map<String, String> collect = list.stream().collect(Collectors.toMap(People::getId, People::getName));
    }

    @Test
    public void t190923(){
        HashMap<String, Boolean> map = Maps.newHashMap();
        map.put("1", true);
        map.put("2", false);
        System.out.println(JSON.toJSONString(map));
        String json = "{\"1\":true,\"2\":false}";
        Map<Integer, Boolean> map1 = JSON.parseObject(json, new TypeReference<Map<Integer, Boolean>>() {});
        System.out.println(map1);

    }

    @Test
    public void t1905161() throws ExecutionException, InterruptedException {
        ThreadFactory build = new ThreadFactoryBuilder().setNameFormat("liuxin-%d").build();


        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), build);


        for (int i = 0; i <10 ; i++) {
            Future<?> submit = threadPoolExecutor.submit(() -> {
                        System.out.println(Thread.currentThread().getName() + "    a");
                    });
            submit.get();
        }

    }
    @Test
    public void t190516() throws Exception {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CountDownLatch countDownLatch = new CountDownLatch(2);

        Future<?> submit = executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "查询未对账订单");
            countDownLatch.countDown();
        });

        Future<?> submit1 = executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "查询派送单");
            countDownLatch.countDown();
        });

        countDownLatch.await();

        // 执行对账操作
        System.out.println(Thread.currentThread().getName() + "执行对账操作");
        // 差异写入差异库
        System.out.println(Thread.currentThread().getName() + "差异写入差异库");

    }


    private int size = 0;
    private Object[] elementData;

    public int indexOf(Object o) {
        // 如果o为null
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else { // 如果o不为null
            // 是否equals进行比较
            for (int i = 0; i < size; i++) {
                if (o.equals(elementData[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Test
    public void test() {
        Thread thread = new Thread(() -> {
            int i = 0;
            System.out.println(Thread.currentThread().getName() + "  i=" + i++);
            throw new RuntimeException("111111");
        }, "thread-test-lx23");
        thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());

        thread.start();
        ;

        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test190131() {

        People people = new People();
        people.setId("1");
        People people1 = new People();
        people1.setId("1");

        System.out.println(people.hashCode() + "  " + people1.hashCode());
        System.out.println(people.equals(people1));
    }

    @Test
    public void test190125() {

        Map<String, List<Integer>> map = Maps.newHashMap();
        map.put("1", null);
        map.put("1", null);
        map.put("1", null);
        map.put("1", null);

        Set<Integer> objects = Sets.newHashSet();
        map.values().stream().filter(CollectionUtils::isNotEmpty).forEach(objects::addAll);
        System.out.println(objects);
    }

    @Test
    public void test181205() {

        Map<String, Integer> map = Maps.newHashMap();
        map.put("是否美团历史覆盖", 8);
        map.put("POI品类", 5);
        map.put("战略等级", 4);
        String s = JSON.toJSONString(map);
        Map<String, Integer> pushConfig = JSON.parseObject(s, new TypeReference<Map<String, Integer>>() {
        });
        System.out.println(pushConfig);

        String str = "{\"是否美团历史覆盖\":8,\"POI品类\":5,\"战略等级\":4,\"POI所在区域\":7,\"POI所在城市\":3,\"POIID\":1,\"携程当前是否在线\":9,\"产品ID\":10,\"POI名称\":2,\"POI所在省份\":6}";
        Map<String, Integer> pushConfig1 = JSON.parseObject(str, new TypeReference<Map<String, Integer>>() {
        });
        System.out.println(pushConfig1);
    }


    private static String stackTraceToString(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        pw.close();
        try {
            sw.close();
        } catch (IOException e1) {
            //ignore
        }
        return sw.toString();

    }


}
