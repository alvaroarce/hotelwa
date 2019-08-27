package com.ppalvaro.hotelwa;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserve")
public class ReserveController {

    private ReserveRepository repository;

    public ReserveController(ReserveRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List getAll(){
        return  repository.findAll();
    }

    @PostMapping
    public Reserve create(@RequestBody Reserve reserve){
        return repository.save(reserve);
    }
}
