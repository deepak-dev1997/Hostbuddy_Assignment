package com.example.HostBuddy_assignment.controller;

import com.example.HostBuddy_assignment.entrydto.ItemEntryDto;
import com.example.HostBuddy_assignment.model.Item;
import com.example.HostBuddy_assignment.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ItemController {

    @Autowired
    ItemService itemService;

    @PostMapping("/add")
    public ResponseEntity<String> addItem(@RequestBody ItemEntryDto itemEntryDto){
        try {
           return new ResponseEntity<>(itemService.addItem(itemEntryDto),HttpStatus.CREATED) ;
        }
        catch (Exception e){
            return new ResponseEntity<>("cannot be added", HttpStatus.NOT_IMPLEMENTED);
        }
    }

    @GetMapping("/viewAll")
    public ResponseEntity<List<Item>> viewAll(){
        try{
            return new ResponseEntity<>(itemService.viewAll(),HttpStatus.FOUND);
        }
        catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Item>> getItemByKeyword(@RequestParam("keyword") String search) {
        try {
            return new ResponseEntity<>(itemService.viewByKeword(search), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }





}
