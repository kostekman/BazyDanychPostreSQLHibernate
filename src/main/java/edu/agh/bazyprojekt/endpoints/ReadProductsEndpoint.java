package edu.agh.bazyprojekt.endpoints;

import com.fasterxml.jackson.core.JsonProcessingException;
import edu.agh.bazyprojekt.controller.ProductController;
import edu.agh.bazyprojekt.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.naming.OperationNotSupportedException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/readProducts")
public class ReadProductsEndpoint {

    @Autowired
    ProductController productController;

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    List<Product> read(@RequestBody Map<String,String> restrictions) throws OperationNotSupportedException, JsonProcessingException {
        return productController.getProduct(restrictions);
    }
}

