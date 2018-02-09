package edu.agh.bazyprojekt.controller;

import edu.agh.bazyprojekt.model.OrderDetails;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class HibernateOrderDetailsController extends HibernateController implements OrderDetailsController{
    public OrderDetails mapJSONToOrderDetails(HashMap<String, String> json){

        OrderDetails newOD = new OrderDetails();
        ProductController productController = new HibernateProductController();
        OrderController orderController = new HibernateOrderController();


        newOD.setOrderId(Short.parseShort(json.get("orderId")));
        newOD.setProductId(Short.parseShort(json.get("productId")));
        newOD.setUnitPrice(Float.parseFloat(json.get("unitPrice")));
        newOD.setQuantity(Short.parseShort(json.get("quantity")));
        newOD.setDiscount(Float.parseFloat(json.get("discount")));

        Map<String,String> productRestrictions = new HashMap<>();
        productRestrictions.put("productId",json.get("productId"));
        newOD.setProduct(productController.getProduct(productRestrictions).get(0));

        Map<String, String> orderRestriction = new HashMap<>();
        orderRestriction.put("orderId",json.get("orderId"));
        newOD.setOrder(orderController.getOrder(orderRestriction).get(0));


        return newOD;
    }

    @Override
    public void createNewOrderDetails(OrderDetails orderDetails) {
        saveObjectToDb(orderDetails);
    }

    @Override
    public void alterOrderDetails(OrderDetails orderDetails) {

    }

    @Override
    public OrderDetails removeOrderDetails(OrderDetails orderDetails) {
        return null;
    }

    @Override
    public List<OrderDetails> getOrderDetails(Map<String, String> query) {
        return null;
    }
}
