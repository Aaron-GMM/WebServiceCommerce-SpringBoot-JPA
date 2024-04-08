package com.curs.cursospring.services;

import com.curs.cursospring.entities.Product;
import com.curs.cursospring.entities.User;
import com.curs.cursospring.repositories.ProductRepository;
import com.curs.cursospring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
    return  repository.findAll();
    }

    public  Product findById(long id){
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }
}
