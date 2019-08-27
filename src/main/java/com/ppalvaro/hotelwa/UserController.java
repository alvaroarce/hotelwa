package com.ppalvaro.hotelwa;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UsuarioRepository repository;

    public UserController(UsuarioRepository repo) {
        this.repository = repo;
    }

    @GetMapping()
    public List getAll() {
        final List<Usuario> allUsers = repository.findAll();
        return allUsers;
    }

    @PostMapping
    public Usuario create(Usuario user){
//        user.setName("name");
//        user.setLast_name("last");
//        user.setIdentification("123");
//        user.setEmail("asd");
//        user.setPassword("pass");
        //return repository.save(user);
        return null;
    }

}