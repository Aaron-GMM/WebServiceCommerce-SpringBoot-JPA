package com.curs.cursospring.repositories;

import com.curs.cursospring.entities.Product;
import com.curs.cursospring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
