package com.saf_saicoop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saf_saicoop.dao.VColoniaRepository;
import com.saf_saicoop.entity.VColonia;

@Service
public class VColoniaServiceImpl implements IVColoniaService {

	@Autowired
	private VColoniaRepository vColoniaRepository;
	
	@Override
	public VColonia buscarPorId(Integer id) {
		return vColoniaRepository.findById(id).orElse(null);
	}

}
