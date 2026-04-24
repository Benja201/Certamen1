package com.example.certamen1.controllers;

import com.example.certamen1.entities.Libro;
import com.example.certamen1.services.LibrosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibrosController {

    @Autowired
    private LibrosServices librosServices;

    @GetMapping("/libros")
    public ResponseEntity<List<Libro>> getAll(@RequestParam(required = false)String search) {
        try {
            List<Libro> libros = this.librosServices.getAll(search);
            return ResponseEntity.ok(libros);
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/crearLibro")
    public ResponseEntity<Libro> createBook(@RequestBody Libro libro){
        Libro nuevoLibro = librosServices.createBook(libro);
        if(nuevoLibro != null){
            return ResponseEntity.ok(nuevoLibro);
        }
        return ResponseEntity.internalServerError().build();
    }

    @GetMapping("/libros/{autor}")
    public ResponseEntity<List<Libro>>findByAutor(@PathVariable String autor){
        List<Libro> libros = librosServices.findByAutor(autor);
        return ResponseEntity.ok(libros);
    }
}