package com.example.producto2.service.menuService;

import com.example.producto2.model.Tenga;

import java.util.Optional;

public interface IProductosService {
    Object findAll();
    Optional<Tenga> findById(Long id);
    Tenga create(Tenga tenga);
    Tenga update(Tenga tenga);
    void delete(Long id);

}
