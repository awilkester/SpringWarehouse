package com.example.springwarehouse.service;

import com.example.springwarehouse.model.Admin;
import com.example.springwarehouse.model.Employee;
import com.example.springwarehouse.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    //get all the employees, get all the admins, if employee credential is correct and if admin credential is correct

    public List<Employee> getAllEmployees(){
        return UserRepository.getAllEmployees();
    }

    public List<Admin> getAllAdmins(){
        return UserRepository.getAllAdmins();
    }

    public boolean employeeCredentialCorrect(String name, String password){
        return UserRepository.isUserValid(name, password);
    }

    public boolean adminCredentialCorrect(String name, String password){
        return UserRepository.isUserValid(name, password);
    }
}
