package com.saf_saicoop.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saf_saicoop.dao.TablaRepository;
import com.saf_saicoop.entity.Tabla;
import com.saf_saicoop.entity.TablaPK;


@Service
public class TablaServiceImpl implements ITablaService {
    
	@Autowired
	private TablaRepository tablaRepository;
	
	@Override
	public Tabla buscarPorId(TablaPK pk) {
		return tablaRepository.findById(pk).orElse(null);
	}
	
	

}
