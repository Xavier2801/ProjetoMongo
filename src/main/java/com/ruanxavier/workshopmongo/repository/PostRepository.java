package com.ruanxavier.workshopmongo.repository;


import com.ruanxavier.workshopmongo.domain.Post;
import com.ruanxavier.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {


}
