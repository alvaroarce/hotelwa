package com.ppalvaro.hotelwa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
