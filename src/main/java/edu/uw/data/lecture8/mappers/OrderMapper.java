package edu.uw.data.lecture8.mappers;

import edu.uw.data.lecture8.model.Order;

import java.util.List;

/**
 * Created by Conor on 5/7/2015.
 */
//@CacheConfig(cacheNames="orders")
public interface OrderMapper {

  //  @Cacheable   // spring method cache example
    List<Order> findAllOrders();

   // mybatis cache example
    Order findOrderById(int orderNumber);
}