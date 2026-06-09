package com.ruanxavier.workshopmongo.dto;

import com.ruanxavier.workshopmongo.domain.User;


    // Implementando um DTO(data transfer object) para carregar dados de entidades de maneira simples

public class UserDTO {

    private String id;
    private String name;
    private String email;

    public UserDTO(){}

    public UserDTO(User obj) {
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
    }

    // getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
