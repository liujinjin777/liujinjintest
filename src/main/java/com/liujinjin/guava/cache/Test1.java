package com.liujinjin.guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author liuxin
 * @date 2018/9/25
 */
public class Test1 {


    ListeningExecutorService backgroundRefreshPools =
            MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(20));


    LoadingCache<String, Object> caches = CacheBuilder.newBuilder()
            .maximumSize(1)
            .refreshAfterWrite(10, TimeUnit.MILLISECONDS)
            .build(new CacheLoader<String, Object>() {
                @Override
                public Object load(String key) throws Exception {
                    System.out.println("" + Thread.currentThread().getName());
                    return 1;
                }

                @Override
                public ListenableFuture<Object> reload(String key, Object oldValue) throws Exception {
                    return backgroundRefreshPools.submit(() -> {
                        System.out.println("" + Thread.currentThread().getName());
                        return 1;
                    });
                }
            });

    @Test
    public void test(){

        try {
            caches.get("1");
            Thread.sleep(1000L);
            caches.get("1");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
