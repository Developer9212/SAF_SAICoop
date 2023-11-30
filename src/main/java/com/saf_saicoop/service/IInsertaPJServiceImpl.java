package com.saf_saicoop.service;

import org.springframework.stereotype.Service;

import com.saf_saicoop.dao.InsertarPJRepository;
import com.saf_saicoop.entity.InsertarPJ;
import com.saf_saicoop.entity.PersonaPK;

@Service
public class IInsertaPJServiceImpl implements IInsertaPJService {
 
	private InsertarPJRepository insertarPJRepository; 
	
	@Override
	public InsertarPJ buscarPorId(PersonaPK id) {
		return insertarPJRepository.findById(id).orElse(null);
	}

	@Override
	public InsertarPJ guardar(InsertarPJ personaJuridica) {
		return insertarPJRepository.save(personaJuridica);
	}

}
