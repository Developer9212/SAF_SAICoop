package com.saf_saicoop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saf_saicoop.dao.TrabajoRepository;
import com.saf_saicoop.entity.PersonaPK;
import com.saf_saicoop.entity.Trabajo;


@Service
public class TrabajoServiceImpl implements ITrabajoService{
    
	@Autowired
	private TrabajoRepository trabajoRepository;
	
	@Override
	public Trabajo buscarPorId(PersonaPK pk) {
		return trabajoRepository.buscarPorOgs(pk.getIdorigen(), pk.getIdgrupo(),pk.getIdsocio());
	}

}
