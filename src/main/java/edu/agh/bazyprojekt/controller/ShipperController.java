package edu.agh.bazyprojekt.controller;

import edu.agh.bazyprojekt.model.Shipper;

import java.util.List;
import java.util.Map;

public interface ShipperController {

    void createNewShipper(Shipper product);
    Shipper mapJSONToShipper(Map<String,String> json);
    void updateShipper(Shipper product);
    Shipper removeShipper(Shipper product);
    List<Shipper> getShipper(Map<String,String> restrictions);

}
