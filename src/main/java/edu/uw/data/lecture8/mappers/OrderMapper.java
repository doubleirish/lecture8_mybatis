package edu.uw.data.lecture8.mappers;

import edu.uw.data.lecture8.model.Order;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * Created by Conor on 5/7/2015.
 */
@CacheConfig(cacheNames="edu.uw.data.lecture8.mappers.OrderMapper")
public interface OrderMapper {
    // cache example
    @Cacheable
    List<Order> findAllOrders();

    @Cacheable
    Order findOrderById(int orderNumber);
}