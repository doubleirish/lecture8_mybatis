package edu.uw.data.lecture8.mappers;

import edu.uw.data.lecture8.model.Order;
import edu.uw.data.lecture8.service.ClassicService;
import net.sf.ehcache.CacheManager;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
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
        ToStringBuilder.setDefaultStyle(ToStringStyle.MULTI_LINE_STYLE);
        List<Order> orders = classicService.findAllOrders();
        assertThat(orders.size(),greaterThan(0));
        Order order = orders.get(0);

        System.out.println("first order "+order);

        assertThat(order.getOrderNumber(), notNullValue());

        orders = classicService.findAllOrders();
        order = orders.get(0);
        System.out.println("first order  again "+order);

        CacheManager cacheManager = CacheManager.getInstance();
        String[] cacheNames = cacheManager.getCacheNames();
        for (int i = 0; i < cacheNames.length; i++) {
            String cacheName = cacheNames[i];
            System.out.println(cacheName+" - "+ cacheManager.getCache(cacheName).getStatistics().toString());
        }

    }


    @Test
    public void findOrderByIdTest() {

        Order order = classicService.findOrderById(10100);
        System.out.println("first order  "+order);
        assertThat(order , notNullValue());

        order = classicService.findOrderById(10100);
        System.out.println("first order  again "+order);

        CacheManager cacheManager = CacheManager.getInstance();

        String cacheName="edu.uw.data.lecture8.mappers.OrderMapper";
        System.out.println( cacheManager.getCache(cacheName).getStatistics().toString());


//        String[] cacheNames = cacheManager.getCacheNames();
//        for (int i = 0; i < cacheNames.length; i++) {
//            String cacheName = cacheNames[i];
//            System.out.println(cacheName+" - "+ cacheManager.getCache(cacheName).getStatistics().toString());
//        }

    }


}
