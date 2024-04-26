package com.webservicecommerce.services;

import com.webservicecommerce.entities.User;
import com.webservicecommerce.repositories.UserRepository;
import com.webservicecommerce.services.exceptions.DatabaseException;
import com.webservicecommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
            try {
                repository.deleteById(id);
            }catch (EmptyResultDataAccessException e){
                throw new ResourceNotFoundException(id);
            }catch (RuntimeException e) {
                throw new DatabaseException(e.getMessage());
            }


    }

    public User update(long id, User newuser){
        try {
            User entity = repository.getReferenceById(id);
            updateData(entity, newuser);
            return repository.save(entity);
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }
    }
    public  void updateData(User entity, User obj){
        entity.setNome(obj.getNome());
        entity.setEmail(obj.getEmail());
        entity.setTell(obj.getTell());
    }


}
