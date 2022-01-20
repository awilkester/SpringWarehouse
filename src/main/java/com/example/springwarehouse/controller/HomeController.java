package com.example.springwarehouse.controller;

import com.example.springwarehouse.model.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

@Controller
public class HomeController {
    RestTemplate restTemplate;

    @GetMapping(value = "/")
    public String home(){
        return "index";
    }

    @GetMapping("/listAllItems")
    public String getListAllItemsPage(HttpServletRequest request, Model model) {
        restTemplate = new RestTemplate();
        String itemResourceUrl = "http://localhost:" + request.getLocalPort() + "/warehouse/getAllItems";
        String warehouseResourceUrl = "http://localhost:" + request.getLocalPort() + "/warehouse/getWarehouses";

        List<Item> response = restTemplate.getForObject(
                itemResourceUrl,
                List.class
        );

        Set<Integer> warehouseResponse = restTemplate.getForObject(
                warehouseResourceUrl,
                Set.class
        );

        model.addAttribute("warehouses", warehouseResponse);
        model.addAttribute("items", response);
        model.addAttribute("itemCount", response.size());
        return "items_list";
    }

    @GetMapping("/listItemsByWarehouse/{warehouseId}")
    public String getListItemByWarehousePage(HttpServletRequest request, Model model, @PathVariable("warehouseId") int warehouseId) {
        restTemplate = new RestTemplate();
        String itemResourceUrl = "http://localhost:" + request.getLocalPort() + "/warehouse/getAllItems/" + warehouseId;

        List<Item> response = restTemplate.getForObject(
                itemResourceUrl,
                List.class
        );


        model.addAttribute("warehouse", warehouseId);
        model.addAttribute("items", response);
        model.addAttribute("itemCount", response.size());
        return "items_list_by_warehouse";
    }
    @GetMapping("/browseByCategory")
    public String getAllCategoriesPage(HttpServletRequest request, Model model) {
        restTemplate = new RestTemplate();
        String categoryResourceUrl = "http://localhost:" + request.getLocalPort() + "/warehouse/getCategories";

        Set<String> response = restTemplate.getForObject(
                categoryResourceUrl,
                Set.class
        );

        model.addAttribute("categories", response);
        model.addAttribute("categoryCount", response.size());
        return "browse_by_category";
    }
    @GetMapping("/browseByCategory/{category}")
    public String getItemsListOfCategory(HttpServletRequest request, Model model, @PathVariable String category) {
        restTemplate = new RestTemplate();
        String itemResourceUrl = "http://localhost:" + request.getLocalPort() + "/warehouse/getItemsByCategory/" + category;

        List<Item> response = restTemplate.getForObject(
                itemResourceUrl,
                List.class
        );

        model.addAttribute("items", response);
        model.addAttribute("itemCount", response.size());
        return "browse_by_specific_category";
    }

}
