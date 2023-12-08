package com.saf_saicoop.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saf_saicoop.dao.PaisRepository;
import com.saf_saicoop.entity.Pais;


@Service
public class PaisServiceImpl implements IPaisService {
    
	@Autowired
    private PaisRepository paisDao;
	
	@Override
	public Pais buscarPorId(Integer id) {
		return paisDao.findById(id).orElse(null);
	}

}
