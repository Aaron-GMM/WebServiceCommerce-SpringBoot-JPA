package com.curs.cursospring.entities;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private  static final  long serialVersionUID = 1L;

    private  Long id;
    private  String nome;
    private  String email;
    private  String tell;
    private String password;

    public  User(Long id, String nome,String email,String tell, String password){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.tell = tell;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
