package com.ruanxavier.workshopmongo.services;

import com.ruanxavier.workshopmongo.domain.User;
import com.ruanxavier.workshopmongo.repository.UserRepository;
import com.ruanxavier.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;


    // metodo findAll
    public List<User> findAll() {
        return repo.findAll();
    }

    //metodo findById
    public User findById(String id) {
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
    }
