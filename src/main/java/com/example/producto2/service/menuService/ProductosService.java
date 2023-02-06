package com.example.producto2.service.menuService;

import com.example.producto2.model.Tenga;
import com.example.producto2.repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ProductosService implements IProductosService {
    @Autowired
    private ProductosRepository productosRepository;

    public Object findAll() {
        return this.productosRepository.findAll();
    }

    @Override
    public Optional<Tenga> findById(Long id) {
        return productosRepository.findById(id);
    }

    @Override
    public Tenga create(Tenga tenga) {
        return productosRepository.save(tenga);
    }

    @Override
    public Tenga update(Tenga tenga) {
        Tenga currentTenga = productosRepository.findById(tenga.getId()).get();
        currentTenga.setPrice(tenga.getPrice());
        currentTenga.setName(tenga.getName());
        currentTenga.setDescripcion(tenga.getDescripcion());
        return productosRepository.save(currentTenga);
    }
    @Override
    public void delete(Long id) {
        Optional<Tenga> producto = productosRepository.findById(id);
        System.out.println(producto);
        productosRepository.deleteById(id);
    }

}
