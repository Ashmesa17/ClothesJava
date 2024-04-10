package com.adso.api.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adso.api.Models.Clothes;

@Repository
public interface ClothesRepository extends JpaRepository<Clothes, Long> {

}
