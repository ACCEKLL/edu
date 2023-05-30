package org.accekll.utils;

//import net.sf.ehcache.Cache;
//import net.sf.ehcache.CacheManager;
//import net.sf.ehcache.Element;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

/**
 * @Author: ZKL
 * @DataTime: 2022/9/9 11:51
 * @Description:
 **/
@Component
public class EhCacheUtil {

    @Autowired
    private CacheManager cacheManager;

    public void setToken(String key, String value) {
        Cache cache = cacheManager.getCache("TokenCache");
        cache.put(key, value);
    }

    public void setToken(String key) {
        Cache cache = cacheManager.getCache("TokenCache");
        cache.put(key, "flag");
    }

    public String getToken(String key) {
        Cache cache = cacheManager.getCache("TokenCache");
        String token = cache.get(key, String.class);
        return token;
    }

    public boolean removeToken(String key) {
        Cache cache = cacheManager.getCache("TokenCache");
        return cache.evictIfPresent(key);
    }


}
