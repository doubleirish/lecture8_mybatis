package edu.uw.data.lecture8.mappers;

import edu.uw.data.lecture8.model.Product;
import edu.uw.data.lecture8.service.ClassicService;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertEquals;

/**
 * repeatable tests
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:/data-tier-spring.xml",
        "classpath:/cache-spring.xml",
        "classpath:/datasource-embedded-init-p6spy.xml"
        //     "classpath:/datasource-embedded-init.xml"
        //  "classpath:/datasource-standalone-test.xml"
})
public class ProductMapperTest extends AbstractJUnit4SpringContextTests {

    static final Logger log = LoggerFactory.getLogger(ProductMapperTest.class);

     @Autowired
    private ClassicService classicService;


    @Resource(name="cacheManager")
    private EhCacheCacheManager cacheManager;


    @Before
    public void before() {
        List<CacheManager> allCacheManagers = CacheManager.ALL_CACHE_MANAGERS;
        for (CacheManager cacheManager : allCacheManagers) {
            for (String cacheName : cacheManager.getCacheNames()) {
                Cache cache = cacheManager.getCache(cacheName);
                cache.removeAll();
            }
        }
    }





    public void verifyEmptyCache() {

        CacheManager cacheManager = CacheManager.getInstance();
        for (String name : cacheManager.getCacheNames()) {
            Cache cache = cacheManager.getCache(name);
            assertEquals("expected cache " + name + " to be zero", 0, cache.getSize());
        }
    }



    @Test
    public void findAllProductsTest_CACHE_LAB() {
        verifyEmptyCache();

        printEhcacheStatistics();
        String cacheName = "edu.uw.data.lecture8.mappers.ProductMapper";
        long hitsBefore = getHits(cacheName);
        System.out.println("BEFORE: Cache ["+cacheName+"] has "+hitsBefore+" hits " );


        //
        // first call (Cache Miss and PUT)
        //
        List<Product> products = classicService.findAllProducts();
        assertThat(products.size(),greaterThan(0));
        Product product = products.get(0);
        assertThat(product.getProductCode(), notNullValue());
        System.out.println("first product "+product.getProductCode()+" "+product.getProductName());


        //
        // second  call (Cache Hit)
        //
        classicService.findAllProducts();






        printEhcacheStatistics();

        long hitsAfter = getHits(cacheName);
        System.out.println("AFTER: Cache ["+cacheName+"] has "+hitsAfter+" hits " );
        assertEquals(hitsAfter, hitsBefore + 1L);

    }


    /*
    =============== Utilities =====================
     */
    public   void  printEhcacheStatistics() {
        List<CacheManager> allCacheManagers = CacheManager.ALL_CACHE_MANAGERS;
        System.out.println("found  " +allCacheManagers.size()+ " cacheManagers");
        for (CacheManager aCacheManager : allCacheManagers) {
            System.out.println("===== cache manager : "+aCacheManager.getName());
            String[] cacheNames = aCacheManager.getCacheNames();
            for (String cacheName : cacheNames) {
                Cache cache = aCacheManager.getCache(cacheName);
                net.sf.ehcache.Statistics statistics = cache.getStatistics();
                System.out.format(" %50s Cache has '%d' hits,  '%d' misses, '%d' evicts , '%d' size \n"
                        , cacheName
                        , statistics.getCacheHits()
                        , statistics.getCacheMisses()
                        , statistics.getEvictionCount()
                        , statistics.getMemoryStoreObjectCount()
                );
            }
        }
    }
    public void beforeMultiManagerVariant() {
        List<CacheManager> allCacheManagers = CacheManager.ALL_CACHE_MANAGERS;
        for (CacheManager cacheManager : allCacheManagers) {
            for (String cacheName : cacheManager.getCacheNames()) {
                Cache cache = cacheManager.getCache(cacheName);
                cache.removeAll();
            }
        }
    }


    private long getHits(String cacheName) {
        CacheManager cacheManager = CacheManager.getInstance();
        Cache cache = cacheManager.getCache(cacheName);
        assertNotNull("cache regions not set up for "+cacheName,cache);
        return cache.getStatistics().getCacheHits();

    }


    private long getEvictionCount(String cacheName) {
        CacheManager cacheManager = CacheManager.getInstance();
        Cache cache = cacheManager.getCache(cacheName);
        return cache.getStatistics().getEvictionCount();
    }

    private long getObjectCount(String cacheName) {
        CacheManager cacheManager = CacheManager.getInstance();
        Cache cache = cacheManager.getCache(cacheName);
        return cache.getStatistics().getObjectCount();
    }



}
