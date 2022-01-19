package com.example.springwarehouse.controller;

import com.example.springwarehouse.model.Admin;
import com.example.springwarehouse.model.Employee;
import com.example.springwarehouse.model.LoginDTO;
import com.example.springwarehouse.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    //		- GET -> /users/getAllEmployees  -> returns List<Employee>
    //		- GET -> /users/getAllAdmins    -> returns List<Admin>
    //		- GET -> /users/employee/login -> takes LoginDTO in RequestBody -> returns boolean
    //		- GET -> /users/admin/login  -> takes LoginDTO in RequestBody  -> returns boolean
    //		(return true if credentials match, otherwise false)

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users/getAllEmployees")
    public List<Employee> getAllEmployees(){
        return userService.getAllEmployees();
    }

    @GetMapping(value = "/users/getAllAdmins")
    public List<Admin> getAllAdmins(){
        return userService.getAllAdmins();
    }

    @GetMapping(value = "/users/employee/login")
    public boolean employeeLogin(@RequestBody LoginDTO loginDTO){
        return userService.employeeCredentialCorrect(loginDTO.getUsername(), loginDTO.getPassword());
    }
    @GetMapping(value = "/users/admin/login")
    public boolean adminLogin(@RequestBody LoginDTO loginDTO){
        return userService.employeeCredentialCorrect(loginDTO.getUsername(), loginDTO.getPassword());
    }
}
