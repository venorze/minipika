package com.poseidon.framework.cache;

import com.poseidon.framework.db.NativeJdbc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Create by 2BKeyboard on 2019/12/4 20:25
 */
public class PoseidonCache {

    // 容器
    private Map<String, NativeJdbc> map = new HashMap<>();

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Lock writeLock = readWriteLock.writeLock();
    private Lock readLock = readWriteLock.readLock();

    private final static PoseidonCache cache = new PoseidonCache();

    public static PoseidonCache getCache(){
        return cache;
    }

    public void save(String key, NativeJdbc value) {
        writeLock.lock();
        map.put(key, value);
        writeLock.unlock();
    }

    public NativeJdbc get(String key) {
        readLock.lock();
        NativeJdbc result = map.get(key);
        readLock.unlock();
        return result;
    }

    public void remove(String key) {
        writeLock.lock();
        map.remove(key);
        writeLock.unlock();
    }

}
