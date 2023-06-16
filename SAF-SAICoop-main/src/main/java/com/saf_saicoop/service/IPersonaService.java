package com.saf_saicoop.service;

import org.springframework.stereotype.Service;

import com.saf_saicoop.entity.Persona;
import com.saf_saicoop.entity.PersonaPK;


@Service
public interface IPersonaService {
	
	public Persona buscarPorId(PersonaPK pk);
}
 