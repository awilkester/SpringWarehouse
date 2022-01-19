package com.example.springwarehouse.service;

import com.example.springwarehouse.model.Item;
import com.example.springwarehouse.model.Warehouse;
import com.example.springwarehouse.repository.WarehouseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class WarehouseService {
    // get categories and get items by category

    public Set<Integer> getWarehouses(){
        return WarehouseRepository.getWarehouseIds();
    }

    public List<Item> getAllItems(){
        return WarehouseRepository.getAllItems();
    }

    public List<Item> getItemsByWarehouse(int id){
        List<Item> result = null;
        for(Warehouse x : WarehouseRepository.getWarehouseList()){
            if(x.getId() == id){
                result = x.getStock();
            }
        }
        return result;
    }

    public Set<String> getCategories(){
        return WarehouseRepository.getCategories();
    }

    public List<Item> getItemsByCategory(String category){
        return WarehouseRepository.getItemsByCategory(String category);
    }

}
