package com.curs.cursospring.repositories;

import com.curs.cursospring.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {

}
