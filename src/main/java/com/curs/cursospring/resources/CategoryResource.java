package com.curs.cursospring.resources;

import com.curs.cursospring.entities.Category;
import com.curs.cursospring.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categorys")
public class CategoryResource {
    @Autowired
    private CategoryService service;
    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> list_Category = service.findAll();

        return  ResponseEntity.ok().body(list_Category);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        Category obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }


}
