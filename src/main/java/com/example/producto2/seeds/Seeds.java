package com.example.producto2.seeds;

import com.example.producto2.model.Tenga;
import com.example.producto2.repository.ProductosRepository;

public class Seeds {
    private ProductosRepository productosRepository;

    public Seeds(ProductosRepository productosRepository) {this.productosRepository = productosRepository; }

    public void generateSeeds(){
        Tenga tengaBasico = new Tenga("Tenga Basico","Un tenga de lo mas basico",30);
        Tenga tengaMediana = new Tenga("Tenga Mediana","Un tenga de lo mas mediano",50);

        productosRepository.save(tengaBasico);
        productosRepository.save(tengaMediana);
    }

}
