package com.example.apiRest.services;

import com.example.apiRest.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonaService extends BaseService<Persona, Long>{
    Page<Persona> searchPaged(String filtro, Pageable pageable) throws Exception;

    List<Persona> search(String filtro) throws Exception;
}
