package com.echair.project_manage.common.cache;

import com.echair.project_manage.common.pojo.vo.UserVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: 线程安全的单例
 * @author: wjk
 * @date: 2020/9/2 14:58
 **/
public class MapCache implements CacheStrategy{
    /**
     * map缓存
     */
    private Map<String ,UserExpired> cache;
    private static volatile  MapCache instance = null;
    /**
     * 锁
     */
    private final static Object lock = new Object();
    private MapCache() {
        cache =new ConcurrentHashMap<>(64);
    }

    /**
     * 获得实例
     * @return
     */
    public static MapCache getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new MapCache();
                }
            }
        }
        return instance;
    }
    @Override
    public String getName() {
        return "map";
    }
    public UserVO getCache(String key) {
        /**
         * 移除过期时间的key
         */
        UserExpired userExpired = cache.get(key);
        if (userExpired == null) {
            return null;
        }
//        System.out.println(userExpired == null);
        if (System.currentTimeMillis() > userExpired.getExpired()) {
            cache.remove(key);
            return null;
        }
        return cache.get(key).getUserVO();
    }

    /**
     * 添加缓存
     * @param userVO
     * @param expired
     */
    public void setCache(UserVO userVO ,long expired) {
        expired = System.currentTimeMillis() + expired;
        UserExpired userExpired = new UserExpired(expired, userVO);
        cache.put(userVO.getUserid(), userExpired);
    }

    public void remove(String key) {
        cache.remove(key);
    }
    public void removeAll() {
        cache.clear();
    }

    /**
     * 清空过期时间的缓存
     */
    public void removeExpired() {
//        Iterator<Map.Entry<String, UserExpired>> it = cache.entrySet().iterator();
//        while(it.hasNext()){
//            Map.Entry<String, UserExpired> entry = it.next();
//            UserExpired value = entry.getValue();
//            if (value.getExpired() < System.currentTimeMillis()) {
//                it.remove();
//            }
//        }
        Set<String> strings = cache.keySet();
        strings.forEach(e->{
            if (cache.get(e).getExpired() < System.currentTimeMillis()) {
                cache.remove(e);
            }
        });
    }
    @Data
    @AllArgsConstructor
    private static class UserExpired{
        private long expired;
       private UserVO userVO;
    }
}
