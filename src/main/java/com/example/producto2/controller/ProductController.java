package com.example.producto2.controller;

import com.example.producto2.model.Tenga;
import com.example.producto2.service.menuService.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(path = "/productos")
public class ProductController {
    @Autowired
    private ProductosService productosService;

    @GetMapping(value = "/agregar")
    public String agregarProducto(Model model) {
        model.addAttribute("producto", new Tenga());
        return "agregar_producto";
    }

    @GetMapping(value = "/mostrar")
    public String mostrarProductos(Model model) {
        model.addAttribute("productos", productosService.findAll());
        return "productos";
    }
    @GetMapping(value = "/contact")
    public String contact(Model model) {
        model.addAttribute("productos", productosService.findAll());
        return "contact";
    }

    @GetMapping(value = "/")
    public String productos(Model model) {
        model.addAttribute("productos", productosService.findAll());
        return "productos";
    }

    @GetMapping(value = "/eliminar/{id}")
    public String eliminarProducto(@PathVariable("id") long id, RedirectAttributes redirectAttrs) {
        productosService.delete(id);
        redirectAttrs
                .addFlashAttribute("mensaje", "Agregado correctamente")
                .addFlashAttribute("clase", "success");
        return "redirect:/productos/mostrar";
    }

    @PostMapping(value = "/editar")
    public String actualizarProducto(@ModelAttribute Tenga tenga, RedirectAttributes redirectAttrs) {
        productosService.update(tenga);
        redirectAttrs
                .addFlashAttribute("mensaje", "Editado correctamente")
                .addFlashAttribute("clase", "success");
        return "redirect:/productos/mostrar";
    }

    @GetMapping(value = "/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        model.addAttribute("producto", productosService.findById(id));
        return "editProduct";
    }

    @PostMapping(value = "/agregar")
    public String guardarProducto(@ModelAttribute Tenga tenga, RedirectAttributes redirectAttrs) {
        productosService.create(tenga);
        redirectAttrs
                .addFlashAttribute("mensaje", "Agregado correctamente")
                .addFlashAttribute("clase", "success");
        return "redirect:/productos/mostrar";
    }
}
