package com.example.apiRest.services;

import com.example.apiRest.entities.Persona;
import com.example.apiRest.repositories.BaseRepository;
import com.example.apiRest.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona, Long> implements PersonaService {

    @Autowired private PersonaRepository personaRepository;

    public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepository) {
        super(baseRepository);
    }
    @Override
    public Page<Persona> searchPaged(String filtro, Pageable pageable) throws Exception {
        try {
             Page<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro, pageable);
            return personas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Persona> search(String filtro) throws Exception {
        try {
            //Misma request utilizando query con JPQL
            // List<Persona> personas = personaRepository.search(filtro);
            // Mismo request utilizando Query Nativo
            // List<Persona> personas = personaRepository.searchNativo(filtro);
            List<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro);
            return personas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}

