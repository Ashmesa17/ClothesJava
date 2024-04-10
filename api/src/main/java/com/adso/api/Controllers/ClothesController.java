package com.adso.api.Controllers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RestController;
import com.adso.api.Models.Clothes;
import com.adso.api.Services.ClothesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class ClothesController {
    private final ClothesService clothesService;
    public ClothesController(ClothesService clothesService){
        this.clothesService = clothesService;
    }
    @GetMapping(value="/clothes")
    public ResponseEntity<Object> get(){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<Clothes> list = clothesService.findAll();
            return new ResponseEntity<Object>(list,HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value="/clothes/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id){
        try {
            Clothes data = clothesService.findById(id);
            return new ResponseEntity<Object>(data,HttpStatus.OK);
        }
        catch (Exception e) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping(value="/clothes")
    public ResponseEntity<Object> create(@RequestBody Clothes clothes){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Clothes res = clothesService.save(clothes);
            return new ResponseEntity<Object>(res,HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/clothes/{id}")
    public ResponseEntity<Object> update(@RequestBody Clothes clothes, @PathVariable Long
    id){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Clothes existingClothes = clothesService.findById(id);
            existingClothes.setType(clothes.getType());
            existingClothes.setSize(clothes.getSize());
            existingClothes.setColor(clothes.getColor());
            Clothes res = clothesService.save(clothes);
            return new ResponseEntity<Object>(res,HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/clothes/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Clothes existingClothes = clothesService.findById(id);
            clothesService.delete(existingClothes);
            map.put("deleted", true);
            return new ResponseEntity<Object>(map,HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}