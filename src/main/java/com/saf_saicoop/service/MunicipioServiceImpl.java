package com.saf_saicoop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saf_saicoop.dao.MunicipioRepository;
import com.saf_saicoop.entity.Municipio;


@Service
public class MunicipioServiceImpl implements IMunicipioService{
    
	@Autowired
	private MunicipioRepository municipioDao;
	
	@Override
	public Municipio buscarPorId(Integer id) {
		return municipioDao.findById(id).orElse(null);
	}

}
