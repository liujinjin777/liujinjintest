package com.liujinjin.suanfa20210506.mianshi;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liuxin14 <liuxin14@kuaishou.com>
 * Created on 2021-05-14
 */
public class TproducerAndConsumer <T> {

    private final Object[] array;
    private final Lock lock;
    private final Condition notFull;
    private final Condition notEmpty;
    private int size;

    public TproducerAndConsumer(int size, boolean fair) {
        if (size <= 0) {
            throw new RuntimeException("size<0");
        }
        array = new Object[size];
        lock = new ReentrantLock(fair);
        notFull = lock.newCondition();
        notEmpty = lock.newCondition();
    }

    public boolean push(T ele) throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (size == array.length - 1) {
                notFull.wait();
            }
            array[size++] = ele;
            notEmpty.signal();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            lock.unlock();
        }
        return true;
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            Integer point = map.get(target - nums[0]);
            if (point != null) {
                return new int[]{i, point};
            }
        }
        return null;
    }

    public T pop() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (size == 0) {
                notEmpty.wait();
            }
            @SuppressWarnings("unchecked")
            T ele = (T) array[size];
            size--;
            notFull.signal();
            return ele;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }
}
