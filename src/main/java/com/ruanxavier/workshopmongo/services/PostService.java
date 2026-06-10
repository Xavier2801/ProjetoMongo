package com.ruanxavier.workshopmongo.services;

import com.ruanxavier.workshopmongo.domain.Post;
import com.ruanxavier.workshopmongo.domain.User;
import com.ruanxavier.workshopmongo.dto.UserDTO;
import com.ruanxavier.workshopmongo.repository.PostRepository;
import com.ruanxavier.workshopmongo.repository.UserRepository;
import com.ruanxavier.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;


    //metodo de busca por id
    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    //metodo de busca por titulo
    public List<Post> findByTitle(String text) {
        return repo.searchTitle(text);
    }

    //metodo de consulta
    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repo.fullSearch(text, minDate, maxDate);
    }

    }
