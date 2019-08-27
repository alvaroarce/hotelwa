package com.ppalvaro.hotelwa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    private HotelRepository repository;

    public HotelController(HotelRepository repository){
        this.repository = repository;
    }

    @GetMapping()
    public List getAll(){
        return repository.findAll();
    }
}
