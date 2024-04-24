package com.curs.cursospring.services;

import com.curs.cursospring.entities.User;
import com.curs.cursospring.repositories.UserRepository;
import com.curs.cursospring.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
    return  repository.findAll();
    }

    public  User findById(long id){
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(()->new ResourceNotFoundException(id));
    }

    public  User insert(User user){
      return   repository.save(user);
    }

    public  void delete(Long id){
        repository.deleteById(id);
    }

    public User update(long id, User newuser){
        User entity = repository.getReferenceById(id);
        updateData(entity, newuser);
        return repository.save(entity);
    }
    public  void updateData(User entity, User obj){
        entity.setNome(obj.getNome());
        entity.setEmail(obj.getEmail());
        entity.setTell(obj.getTell());
    }


}
