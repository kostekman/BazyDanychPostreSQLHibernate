package edu.agh.bazyprojekt.model;

import java.util.ArrayList;
import java.util.Map;

public class OrderRequestBody {
    private Map<String,String> orderInfo;
    private ArrayList<OrderDetails> orderDetails;

    public void setOrderInfo(Map<String, String> orderInfo) {
        this.orderInfo = orderInfo;
    }

    public void setOrderDetails(ArrayList<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Map<String, String> getOrderInfo() {
        return orderInfo;
    }

    public ArrayList<OrderDetails> getOrderDetails() {
        return orderDetails;
    }
}
