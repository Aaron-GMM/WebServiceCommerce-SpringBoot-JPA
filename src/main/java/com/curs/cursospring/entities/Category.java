package com.curs.cursospring.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
@Entity
@Table(name = "tb_category")
public class Category implements Serializable {
    private  static final  long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;


    public Category() {
    }
    public Category( String name) {
        super();

        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id == category.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
