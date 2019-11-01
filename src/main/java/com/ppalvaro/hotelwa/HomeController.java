package com.ppalvaro.hotelwa;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    private HotelRepository repository;

    public HomeController(HotelRepository repository){
        this.repository = repository;
    }

    @GetMapping("/list")
    public String list(Model model){
        List<Hotel> listHotels = repository.findAll();
        model.addAttribute("listHoteles", listHotels);
        return "list";
    }

    @PostMapping("/registrar")
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

    @RequestMapping(value ="/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("newHotel") Hotel newHotel) {
        newHotel.setCreation_date("27/08/2019");
        repository.save(newHotel);
        return "index";
    }

    @RequestMapping("/list")
    public String listFarms(Model model) throws ParseException {
        List<Hotel> listFarms= repository.findAll();
        model.addAttribute("listFarms", listFarms);
        return "ListHotels";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditFarm(@PathVariable(name = "id") Long id) {
        ModelAndView edit = new ModelAndView("edit_hotel");

        Hotel newHotel= repository.findById(id).get();
        edit.addObject("newHotel", newHotel);
        return edit;
    }

}
