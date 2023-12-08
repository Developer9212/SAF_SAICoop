package com.saf_saicoop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saf_saicoop.dao.EstadoRepository;
import com.saf_saicoop.entity.Estado;


@Service
public class EstadoServiceImpl implements IEstadoService{

	@Autowired
	private EstadoRepository estadoDao;
	
	@Override
	public Estado buscarPorId(Integer id) {
		return estadoDao.findById(id).orElse(null);
	}

	
}
