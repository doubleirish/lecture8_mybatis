package edu.uw.data.lecture8.mappers;

import edu.uw.data.lecture8.model.Order;
import edu.uw.data.lecture8.service.ClassicService;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;

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
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true) //TODO run with rollback=false too, you may see different results because the transaction is commited.
public class OrderMapperTest extends AbstractTransactionalJUnit4SpringContextTests {

    static final Logger log = LoggerFactory.getLogger(OrderMapperTest.class);

     @Autowired
    private ClassicService classicService;

    @Override
    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        super.setDataSource(dataSource);
    }



    @Test
    public void findAllOrdersTest() {


        //
        // first call miss and put
        //
        List<Order> orders = classicService.findAllOrders();
        assertThat(orders.size(),greaterThan(0));
        Order order = orders.get(0);

        System.out.println("1st order "+order);

        assertThat(order.getOrderNumber(), notNullValue());

        orders = classicService.findAllOrders();
        order = orders.get(0);
        System.out.println("2nd order  again "+order);


        printEhcacheStatistics() ;

    }


    @Test
    public void findOrderByIdTest() {

        Order order = classicService.findOrderById(10100);
        System.out.println("first order  "+order);
        assertThat(order , notNullValue());

        order = classicService.findOrderById(10100);
        System.out.println("first order  again "+order);

        CacheManager cacheManager = CacheManager.getInstance();

        String orderMapperCache="edu.uw.data.lecture8.mappers.OrderMapper";
        System.out.println( " Cache Hit on orderMapper is "+cacheManager.getCache(orderMapperCache).getStatistics().toString());


        printEhcacheStatistics() ;

    }


    public   void  printEhcacheStatistics() {


        List<CacheManager> allCacheManagers = CacheManager.ALL_CACHE_MANAGERS;
        System.out.println("found  " + allCacheManagers.size() + " cacheManagers");
        for (CacheManager aCacheManager : allCacheManagers) {

            System.out.println("===== cache manager : " + aCacheManager.getName());
            String[] cacheNames = aCacheManager.getCacheNames();
            for (String cacheName : cacheNames) {
                Cache cache = aCacheManager.getCache(cacheName);
                net.sf.ehcache.Statistics statistics = cache.getStatistics();
                System.out.format(" %50s Cache has '%d' hits,  '%d' misses \n", cacheName, statistics.getCacheHits(), statistics.getCacheMisses());
            }

        }
    }

}
