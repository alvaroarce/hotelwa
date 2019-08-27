package com.ppalvaro.hotelwa;

import org.springframework.http.ResponseEntity;
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

    @GetMapping(path = { "/{id}" })
    public ResponseEntity<Usuario> findById(@PathVariable long id) {
        return repository.findById(id).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

}