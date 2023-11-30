package com.saf_saicoop.service;

import com.saf_saicoop.entity.InsertarPF;
import com.saf_saicoop.entity.PersonaPK;

public interface IInsertaPFService {
   
	public InsertarPF buscarPorId(PersonaPK id);
	public InsertarPF guardar(InsertarPF personaFisica);
	
}
