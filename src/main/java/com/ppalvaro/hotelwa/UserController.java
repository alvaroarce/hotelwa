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
    public Usuario create(@RequestBody Usuario user){
        return repository.save(user);
    }

}