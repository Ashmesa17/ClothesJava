package com.adso.api.Services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.adso.api.Models.Clothes;
import com.adso.api.interfaces.ClothesRepository;

@Service
public class ClothesServiceImplement implements ClothesService {

    @Autowired
    private final ClothesRepository clothesRepository;
    public ClothesServiceImplement(ClothesRepository clothesRepository){
    this.clothesRepository = clothesRepository;
    }
    public List<Clothes> findAll() {
    return (List<Clothes>) clothesRepository.findAll();
    }
    @SuppressWarnings("Null")
    public Clothes save(Clothes clothes) {
    return clothesRepository.save(clothes);
    }
    @SuppressWarnings("Null")
    public Clothes findById(Long id) {
    return clothesRepository.findById(id).orElse(null);
    }
    @SuppressWarnings("Null")
    public void delete(Clothes clothes) {
    clothesRepository.delete(clothes);
    }
}


