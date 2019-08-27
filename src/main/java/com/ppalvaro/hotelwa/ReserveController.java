package com.ppalvaro.hotelwa;

import org.springframework.http.ResponseEntity;
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

    @GetMapping(path = { "/{id}" })
    public ResponseEntity<Reserve> findById(@PathVariable long id) {
        return repository.findById(id).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Reserve> update(@PathVariable("id") long id, @RequestBody Reserve reserve) {
        return repository.findById(id).map(record -> {
            record.setId_user(reserve.getId_user());
            record.setId_hotel(reserve.getId_hotel());
            record.setNumbers_rooms(reserve.getNumbers_rooms());
            record.setStartDate(reserve.getStartDate());
            record.setFinalDate(reserve.getFinalDate());
            Reserve updated = repository.save(record);
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
