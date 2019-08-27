package com.ppalvaro.hotelwa;

import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public  Hotel create(@RequestBody  Hotel hotel){
        return repository.save(hotel);
    }
}
