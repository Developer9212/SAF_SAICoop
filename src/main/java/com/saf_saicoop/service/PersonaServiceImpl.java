package com.saf_saicoop.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saf_saicoop.dao.PersonaRepository;
import com.saf_saicoop.entity.Persona;
import com.saf_saicoop.entity.PersonaPK;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PersonaServiceImpl implements IPersonaService{
	
	@Autowired
	private PersonaRepository personaRepository;

	@Override
	public Persona buscarPorId(PersonaPK pk) {
		return personaRepository.getById(pk);
	}
	
	
	
	
	

}
