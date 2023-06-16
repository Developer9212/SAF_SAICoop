package com.saf_saicoop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saf_saicoop.dao.ColoniaRepository;
import com.saf_saicoop.entity.Colonia;

@Service
public class ColoniaServiceImpl implements IColoniaService {

	@Autowired
	private ColoniaRepository coloniaRepository;
	
	@Override
	public Colonia buscarPorId(Integer id) {
		return coloniaRepository.findById(id).orElse(null);
	}

}
