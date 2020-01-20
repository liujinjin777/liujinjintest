package com.liujinjin.guava.cache;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.liujinjin.guava.MultimapTest;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author liuxin
 * @date 2019/7/19
 */
public class Test2 {

    private LoadingCache<Integer, String> TAG_ID_NAME_CACHE = CacheBuilder.newBuilder()
            .expireAfterWrite(1, TimeUnit.DAYS)
            .maximumSize(50)
            .build(new CacheLoader<Integer, String>() {

                @Override
                public String load(Integer key) throws Exception {
                    return null;
                }

                @Override
                public Map<Integer, String> loadAll(Iterable<? extends Integer> ids) throws Exception {
                    HashMap<Integer, String> map = Maps.newHashMap();
                    map.put(1, "1");
                    return map;
                }
            });

    @Test
    public void test2(){
        MultimapTest.T2 t2 = new MultimapTest.T2();
        String s = JSON.toJSONString(t2);
        System.out.println(s);

        MultimapTest.T2 t21 = JSON.parseObject(s, MultimapTest.T2.class);
        System.out.println(t21);

        System.out.println(MultimapTest.class.getName());
        System.out.println(MultimapTest.class.getCanonicalName());
        System.out.println(MultimapTest.class.getSimpleName());
        System.out.println(MultimapTest.class.getTypeName());

        System.out.println(MultimapTest.T2.class.getName());
        System.out.println(MultimapTest.T2.class.getCanonicalName());
        System.out.println(MultimapTest.T2.class.getSimpleName());
        System.out.println(MultimapTest.T2.class.getTypeName());


        JSONObject deptPoiVipDiscount = JSONObject.parseObject("{\"1853\":0,\"1855\":0.05,\"1854\":0,\"3881\":0}");
        System.out.println(deptPoiVipDiscount);

        try {
            ImmutableMap<Integer, String> all = TAG_ID_NAME_CACHE.getAll(Lists.newArrayList(1, 2));
            // ImmutableMap<Integer, String> all = TAG_ID_NAME_CACHE.getAll(Lists.newArrayList(1));
            System.out.println(JSON.toJSONString(all));
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
