package com.example.springwarehouse.controller;

import com.example.springwarehouse.model.Item;
import com.example.springwarehouse.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class WarehouseController {


    //		- GET -> /warehouse/getWarehouses  -> returns Set<Integer>
    //		- GET -> /warehouse/getAllItems    -> returns List<Item>
    //		- GET -> /warehouse/getAllItems/{warehouseId} -> returns List<Item>
    //		- GET -> /warehouse/getCategories  -> returns Set<String>
    //		- GET -> /warehouse/getItemsByCategory/{category}  -> returns List<Item>

    private final WarehouseService warehouseService;

    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @GetMapping(value = "/warehouse/getWarehouses")
    public Set<Integer> getWarehouses(){
        return warehouseService.getWarehouses();
    }

    @GetMapping(value = "/warehouse/getAllItems")
    public List<Item> getAllItems(){
        return warehouseService.getAllItems();
    }

    @GetMapping(value = "/warehouse/getAllItems/{warehouseId}")
    public List<Item> getItemsByWarehouse(@PathVariable int warehouseId){
        return warehouseService.getItemsByWarehouse(warehouseId);
    }

    @GetMapping(value = "/warehouse/getCategories")
    public Set<String> getCategories(){
        return warehouseService.getCategories();
    }

    @GetMapping(value = "/warehouse/getItemsByCategory/{category}")
    public List<Item> getItemsByCategory(@PathVariable String category){
        return warehouseService.getItemsByCategory(String category);
    }
}
