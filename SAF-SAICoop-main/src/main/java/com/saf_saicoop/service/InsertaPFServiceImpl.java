package com.saf_saicoop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saf_saicoop.dao.InsertaPFRepository;
import com.saf_saicoop.entity.InsertarPF;
import com.saf_saicoop.entity.PersonaPK;

@Service
public class InsertaPFServiceImpl implements IInsertaPFService{
   	
	@Autowired
	private InsertaPFRepository insertaPFRepository;
	
	@Override
	public InsertarPF guardar(InsertarPF personaFisica) {
		return insertaPFRepository.save(personaFisica);
	}

	@Override
	public InsertarPF buscarPorId(PersonaPK id) {
		return insertaPFRepository.findById(id).orElse(null);
	}

	
}
