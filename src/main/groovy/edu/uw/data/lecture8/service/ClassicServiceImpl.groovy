package edu.uw.data.lecture8.service
import edu.uw.data.lecture8.mappers.OrderMapper
import edu.uw.data.lecture8.mappers.ProductMapper
import edu.uw.data.lecture8.model.Order
import edu.uw.data.lecture8.model.Product
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.cache.annotation.CacheConfig
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import javax.annotation.Resource
/**
 * Created by Conor on 5/18/2015.
 */
@Transactional
@Service
@CacheConfig(cacheNames = "orders")
class ClassicServiceImpl implements  ClassicService{
    static final Logger log = LoggerFactory.getLogger(ClassicServiceImpl.class);


    @Resource
    OrderMapper orderMapper

    @Resource
    ProductMapper productMapper

     //@Cacheable
    public List<Order> findAllOrders() {
        return orderMapper.findAllOrders();
    }

    //@Cacheable
    public Order findOrderById(int orderNumber) {
        log.info("SERVICE findOrderById")
        return orderMapper.findOrderById(  orderNumber);
    }

    public List<Product> findAllProducts() {
        return productMapper.findAllProducts();
    }




}
