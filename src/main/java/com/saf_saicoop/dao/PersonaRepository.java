package com.saf_saicoop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saf_saicoop.entity.Persona;
import com.saf_saicoop.entity.PersonaPK;


public interface PersonaRepository extends JpaRepository<Persona,PersonaPK> {
      
}
