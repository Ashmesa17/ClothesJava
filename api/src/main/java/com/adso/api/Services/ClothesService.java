package com.adso.api.Services;
import java.util.List;
import org.springframework.stereotype.Service;
import com.adso.api.Models.Clothes;

@Service
public interface ClothesService {
    public List<Clothes> findAll();
    public Clothes save(Clothes clothes);
    public Clothes findById(Long id);
    public void delete(Clothes clothes);
}

