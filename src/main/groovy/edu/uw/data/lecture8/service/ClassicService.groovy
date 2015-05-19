package edu.uw.data.lecture8.service

import edu.uw.data.lecture8.model.Order
import edu.uw.data.lecture8.model.Product

/**
 * Created by Conor on 5/18/2015.
 */
interface ClassicService {
    List<Order> findAllOrders();

    List<Product> findAllProducts();


     Order findOrderById(int orderNumber);
}
