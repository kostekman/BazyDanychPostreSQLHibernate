package edu.agh.bazyprojekt.controller;

import edu.agh.bazyprojekt.model.Product;

import java.util.List;
import java.util.Map;

public interface ProductController {

    void createNewProduct(Product product);
    Product mapJSONToProduct(Map<String,String> json);
    void updateProduct(Product product);
    Product removeProduct(Product product);
    List<Product> getProduct(Map<String,String> restrictions);
}
