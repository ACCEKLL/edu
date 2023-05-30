package org.accekll.config;

import net.sf.ehcache.CacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: ZKL
 * @DataTime: 2022/9/9 23:05
 * @Description:
 **/
@Configuration
public class CacheConfig {

    @Bean
    public EhCacheCacheManager cacheManager() {
        return new EhCacheCacheManager(new CacheManager());
    }

}
