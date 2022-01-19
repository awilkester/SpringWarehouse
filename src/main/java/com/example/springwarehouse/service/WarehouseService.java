package com.example.springwarehouse.service;

import com.example.springwarehouse.model.Item;
import com.example.springwarehouse.repository.WarehouseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class WarehouseService {
    //get warehouse, get all the items, get items by warehouse, get categories and get items by category

    public Set<Integer> getWarehouses(){
        return WarehouseRepository.getWarehouseIds();
    }

    public List<Item> getAllItems(){
        return WarehouseRepository.getAllItems();
    }

    public List<Item> getItemsByWarehouse(int id){

    }
}
