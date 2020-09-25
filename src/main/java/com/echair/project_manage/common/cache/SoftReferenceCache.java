package com.echair.project_manage.common.cache;

import com.echair.project_manage.common.pojo.vo.UserVO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @description: gc的时候如果内存不足，会自动清理掉缓存
 * @author: wjk
 * @date: 2020/9/7 14:58
 **/
public class SoftReferenceCache implements CacheStrategy{
    /**
     * map缓存
     */
    private SoftReference<Map<String,UserExpired1>> softCache;
    private static volatile  SoftReferenceCache instance = null;
    /**
     * 锁
     */
    private final static Object lock = new Object();
    private SoftReferenceCache() {
        softCache = new SoftReference<>(new HashMap<>());
    }

    /**
     * 获得实例
     * @return
     */
    public static SoftReferenceCache getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new SoftReferenceCache();
                }
            }
        }
        return instance;
    }
    @Override
    public String getName() {
        return "softReference";
    }
    public UserVO getCache(String key) {
        /**
         * 移除过期时间的key
         */
        Map<String, UserExpired1> cache = softCache.get();
        UserExpired1 userExpired = cache.get(key);
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
        UserExpired1 userExpired = new UserExpired1(expired, userVO);
        softCache.get().put(userVO.getUserid(), userExpired);
    }

    public void remove(String key) {
        softCache.get().remove(key);
    }
    public void removeAll() {
        softCache.get().clear();
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
        Set<String> strings = softCache.get().keySet();
        strings.forEach(e->{
            if (softCache.get().get(e).getExpired() < System.currentTimeMillis()) {
                softCache.get().remove(e);
            }
        });
    }
    @Data
    @AllArgsConstructor
    private static class UserExpired1{
        private long expired;
        private UserVO userVO;
    }
}
