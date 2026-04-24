package com.example.certamen1.services;

import com.example.certamen1.repository.LibrosRepository;
import com.example.certamen1.entities.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibrosServices {

    @Autowired
    LibrosRepository librosRepository;


    public List<Libro> getAll(String search){
        if (search != null && !search.isEmpty()) {
            return librosRepository.findByTituloContainingIgnoreCaseOrAutorContainingIgnoreCase(search, search);
        }
        return librosRepository.findAll();
    }

    public Libro createBook(Libro libro) {
        return this.librosRepository.save(libro);
    }

    public List<Libro>findByAutor(String autor){
        return librosRepository.findByAutor(autor);
    }


}
