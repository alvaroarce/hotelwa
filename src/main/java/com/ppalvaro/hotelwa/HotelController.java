package com.ppalvaro.hotelwa;

import org.springframework.http.ResponseEntity;
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

    @GetMapping(path = { "/{id}" })
    public ResponseEntity<Hotel> findById(@PathVariable long id) {
        return repository.findById(id).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Hotel> update(@PathVariable("id") long id, @RequestBody Hotel hotel) {
        return repository.findById(id).map(record -> {
            record.setName(hotel.getName());
            record.setIdentification(hotel.getIdentification());
            record.setCreation_date(hotel.getCreation_date());
            record.setNumber_rooms(hotel.getNumber_rooms());
            record.setNumber_rooms(hotel.getNumber_rooms());
            record.setNumbers_star(hotel.getNumbers_star());
            record.setLocation(hotel.getLocation());
            record.setAddress(hotel.getAddress());
            Hotel updated = repository.save(record);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = { "/{id}" })
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        return repository.findById(id).map(record -> {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }

}
