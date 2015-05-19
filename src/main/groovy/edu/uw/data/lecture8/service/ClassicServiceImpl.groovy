package edu.uw.data.lecture8.service

import edu.uw.data.lecture8.mappers.OrderMapper
import edu.uw.data.lecture8.mappers.ProductMapper
import edu.uw.data.lecture8.model.Order
import edu.uw.data.lecture8.model.Product
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import javax.annotation.Resource

/**
 * Created by Conor on 5/18/2015.
 */
@Transactional
@Service
class ClassicServiceImpl implements  ClassicService{

    @Resource
    OrderMapper orderMapper

    @Resource
    ProductMapper productMapper

    public List<Order> findAllOrders() {
        return orderMapper.findAllOrders();
    }


    public Order findOrderById(int orderNumber) {
        return orderMapper.findOrderById(  orderNumber);
    }

    public List<Product> findAllProducts() {
        return productMapper.findAllProducts();
    }




}
